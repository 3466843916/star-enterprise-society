package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.common.result.Result;
import com.sxpi.controller.ZBannerController;
import com.sxpi.convert.ZBannerConvert;
import com.sxpi.costant.FileDirConstant;
import com.sxpi.mapper.ZBannerMapper;
import com.sxpi.model.dto.ZBannerDTO;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZBannerVO;
import com.sxpi.service.ZBannerService;
import com.sxpi.service.ZImageService;
import com.sxpi.utils.PageUtil;
import com.sxpi.utils.SecurityUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author happy
 * @create 2024-01-03-{TIME}
 */
@Service
@Slf4j
@Transactional
public class ZBannerServiceImpl extends ServiceImpl<ZBannerMapper, ZBanner> implements ZBannerService {

    @Resource
    private ZImageService zImageService;

    @Resource
    private ZBannerMapper zBannerMapper;

    @Override
    public PageResult<ZBannerVO> getList(ZBannerDTO zBannerDTO) {
        Page<ZBanner> page = new Page<>(zBannerDTO.getPageNo(), zBannerDTO.getPageSize());

        LambdaQueryWrapper<ZBanner> queryWrapper = new LambdaQueryWrapper<ZBanner>()
                .eq(ZBanner::getIsDeleted, 0)
                .orderByAsc(ZBanner::getSort);// 按 sort 降序

        IPage<ZBanner> zBannerPage = zBannerMapper.selectPage(page, queryWrapper);
        List<ZBannerVO> zBannerVOS = ZBannerConvert.INSTANCE.convertEntityToVo(zBannerPage.getRecords());

        return PageUtil.createPageResult(page, zBannerVOS, zBannerPage.getTotal());
    }

    @Override
    @Transactional
    public Boolean updateBanner(ZBannerDTO zBannerDTO) {
        // 1. 获取当前记录的原始 sort 值
        ZBanner currentBanner = zBannerMapper.selectById(zBannerDTO.getId());
        if (currentBanner == null) {
            return false; // 记录不存在
        }
        Integer oldSort = currentBanner.getSort();
        Integer newSort = zBannerDTO.getSort();

        // 2. 如果新旧 sort 值相同，无需操作
        if (oldSort.equals(newSort)) {
            return true;
        }

        // 3. 动态调整其他记录的 sort 值
        if (newSort < oldSort) {
            // 情况1：将当前记录前移，需要将 [newSort, oldSort-1] 区间的记录后移一位
            zBannerMapper.update(
                    new ZBanner(),
                    new LambdaUpdateWrapper<ZBanner>()
                            .ge(ZBanner::getSort, newSort)
                            .lt(ZBanner::getSort, oldSort)
                            .setSql("sort = sort + 1") // 直接使用 SQL 表达式
            );
        } else {
            // 情况2：将当前记录后移，需要将 [oldSort+1, newSort] 区间的记录前移一位
            zBannerMapper.update(
                    new ZBanner(),
                    new LambdaUpdateWrapper<ZBanner>()
                            .gt(ZBanner::getSort, oldSort)
                            .le(ZBanner::getSort, newSort)
                            .setSql("sort = sort - 1")
            );
        }

        // 4. 更新当前记录的 sort 和 title
        zBannerMapper.update(
                new ZBanner(),
                new LambdaUpdateWrapper<ZBanner>()
                        .eq(ZBanner::getId, zBannerDTO.getId())
                        .set(ZBanner::getSort, newSort)
                        .set(ZBanner::getTitle, zBannerDTO.getTitle())
        );

        return true;
    }

    @Override
    @Transactional
    public Boolean addBanner(ZBannerDTO dto, MultipartFile imageFile) {
        // 参数校验增强
        if (imageFile.isEmpty()) {
            throw new RuntimeException("请上传轮播图");
        }
        validateBannerDTO(dto); // 提取校验逻辑

        // 文件上传（需要事务补偿）
        String fileUUID = null;
        try {
            fileUUID = zImageService.uploadImageFile(
                    FileDirConstant.BANNER,
                    imageFile,
                    UUID.randomUUID().toString()
            );
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败");
        }

        // 设置访问路径
        dto.setImg(fileUUID);

        // 核心业务逻辑
        try {
            return this.doAddBanner(dto);
        } catch (Exception e) {
            // 数据库操作失败时删除已上传文件
            zImageService.deleteImageFile(FileDirConstant.BANNER, fileUUID);
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> del(List<Long> ids) {
        // 参数校验
        if (CollectionUtils.isEmpty(ids)) {
            return Result.fail("请选择要删除的记录");
        }

        // 1. 查询记录并预校验文件路径
        List<ZBanner> banners = zBannerMapper.selectList(
                new LambdaQueryWrapper<ZBanner>().in(ZBanner::getId, ids)
        );

        if (CollectionUtils.isEmpty(banners)) {
            return Result.fail("未找到指定轮播图");
        }

        // 2. 提取待删除文件列表
        List<String> fileNames = banners.stream()
                .map(ZBanner::getImg)
                .filter(StringUtils::isNotBlank)
                .map(url -> {
                    try {
                        return Paths.get(new URI(url).getPath()).getFileName().toString();
                    } catch (URISyntaxException e) {
                        log.error("文件路径解析失败: {}", url);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // 3. 先删除文件
        if (!fileNames.isEmpty()) {
            List<String> failedFiles = zImageService.batchDeleteFiles(FileDirConstant.BANNER, fileNames);
            if (!failedFiles.isEmpty()) {
                throw new RuntimeException("文件删除失败: " + String.join(",", failedFiles));
            }
        }

        // 4. 删除数据库记录
        int deletedCount = zBannerMapper.deleteBatchIds(ids);
        if (deletedCount != ids.size()) {
            log.warn("部分记录删除失败，预期删除 {} 条，实际删除 {} 条", ids.size(), deletedCount);
        }

        return Result.ok("成功删除" + deletedCount + "条记录");
    }
    private Boolean doAddBanner(ZBannerDTO dto) {
        // 获取当前最大排序值（处理空表情况）
        Integer maxSort = zBannerMapper.selectMaxSort();
        maxSort = (maxSort == null) ? 0 : maxSort;

        // 新增自动填充逻辑 ---------------------------
        if (dto.getSort() == null) {
            dto.setSort(maxSort + 1); // 不传值时自动排在最后
        }
        // ------------------------------------------

        // 统一参数校验
        validateSortValue(dto.getSort());
        Integer newSort = dto.getSort();

        // 处理排序冲突
        if (newSort <= maxSort) {
            zBannerMapper.update(
                    new ZBanner(),
                    Wrappers.<ZBanner>lambdaUpdate()
                            .ge(ZBanner::getSort, newSort)
                            .setSql("sort = sort + 1")
            );
        }

        // 统一构建实体对象
        ZBanner entity = new ZBanner();
        entity.setTitle(dto.getTitle());
        entity.setImg(dto.getImg());
        entity.setIsPrimary(dto.getIsPrimary() != null ? dto.getIsPrimary() : 0);
        entity.setSort(newSort);

        return zBannerMapper.insert(entity) > 0;
    }

    // 参数校验方法（修改校验逻辑）
    private void validateBannerDTO(ZBannerDTO dto) {
        if (StringUtils.isBlank(dto.getTitle())) {
            throw new RuntimeException("轮播标题不能为空");
        }
        // 移除对sort的非空校验，允许为空
    }

    private void validateSortValue(Integer sort) {
        // 调整校验逻辑，确保自动填充后的值也有效
        if (sort == null || sort < 1) {
            throw new RuntimeException("排序值必须≥1");
        }
    }
}
