package com.sxpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.convert.DishesConvert;
import com.sxpi.costant.FileDirConstant;
import com.sxpi.mapper.DishesMapper;
import com.sxpi.model.dto.DishesDTO;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.DishesVO;
import com.sxpi.service.DishesService;
import com.sxpi.service.ZImageService;
import com.sxpi.utils.PageUtil;
import com.sxpi.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author happy
 * @create 2025-03-10-{TIME}
 */
@Service
public  class DishesServicelmpl extends ServiceImpl<DishesMapper, Dishes> implements DishesService {
    @Resource
    private DishesMapper dishesMapper;

    @Resource
    private ZImageService zImageService;

    @Override
    public PageResult<DishesVO> pageList(DishesDTO dishesDTO) {
        Page<Dishes> page = new Page<>(dishesDTO.getPageNo(), dishesDTO.getPageSize());

        LambdaQueryWrapper<Dishes> queryWrapper = new LambdaQueryWrapper<>();
        /*queryWrapper.eq(articlesDTO.getAuditStatus() != null, Articles::getAuditStatus, articlesDTO.getAuditStatus())
                .eq(articlesDTO.getUserId() != null, Articles::getUserId, articlesDTO.getUserId())
                .like(articlesDTO.getContent() != null, Articles::getContent, articlesDTO.getContent())
                .like(articlesDTO.getTitle() != null, Articles::getTitle, articlesDTO.getTitle())
                .like(articlesDTO.getTags() != null, Articles::getTags, articlesDTO.getTags())
                .like(articlesDTO.getSupplement() != null, Articles::getSupplement, articlesDTO.getSupplement())
                .eq(articlesDTO.getStatus() != null, Articles::getStatus, articlesDTO.getStatus())
                .eq(articlesDTO.getAuditStatus() != null, Articles::getAuditStatus, articlesDTO.getAuditStatus())
                .like(articlesDTO.getIndustry() != null, Articles::getIndustry, articlesDTO.getIndustry())
                .like(articlesDTO.getRegion() != null, Articles::getRegion, articlesDTO.getRegion())
                .orderByDesc(Articles::getCreatedTime);*/

        IPage<Dishes> dishesIPage = dishesMapper.selectPage(page, queryWrapper);

        List<DishesVO> dishesVOS = DishesConvert.INSTANCE.convertEntityToVo(dishesIPage.getRecords());


        return PageUtil.createPageResult(page, dishesVOS, dishesIPage.getTotal());
    }




    @Override
    public Boolean saveDishes(DishesDTO dishesDTO, List<MultipartFile> files) {
        ZUser loginUser = SecurityUtils.getLoginUser();
        List<String> imgPaths = new ArrayList<>();
        // 存储到服务器磁盘
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                String uuid = UUID.randomUUID() + loginUser.getUsername() + loginUser.getId();
                String filePath = zImageService.uploadImageFile(FileDirConstant.DISHES, file, uuid);
                imgPaths.add(filePath);
            }
        }
        dishesDTO.setImageUrl(String.valueOf(imgPaths));
        dishesDTO.setUserId(loginUser.getId());
        return dishesMapper.insert(DishesConvert.INSTANCE.convertDtoToEntity(dishesDTO)) > 0;
    }


}
