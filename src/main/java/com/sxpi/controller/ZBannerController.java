package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZBannerDTO;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZBannerVO;
import com.sxpi.service.ZBannerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author happy
 * @create 2025-03-03-{TIME}
 */
@RestController
@RequestMapping("/banner")
public class ZBannerController {
    @Resource
    private ZBannerService zBannerService;

    /**
     * 分页查找
     */
    @GetMapping("/list")
    private Result<PageResult<ZBannerVO>> getList(ZBannerDTO zBannerDTO) {
        PageResult<ZBannerVO> zBannerVOPageResult = zBannerService.getList(zBannerDTO);
        return Result.ok(zBannerVOPageResult);
    }
@PutMapping("/update")
public Result<String> update(@RequestBody ZBanner zBanner){
    boolean b = zBannerService.updateById(zBanner);
    if (b){
        return Result.ok("操作成功");
    }
   return Result.fail("操作失败");
}

    /**
     * 修改
     */
    @PutMapping
    public Result<String> updateBanner(@RequestBody ZBannerDTO zBannerDTO) {
        Boolean isSuccess = zBannerService.updateBanner(zBannerDTO);
        if (isSuccess) {
            return Result.ok();
        }
        return Result.fail();
    }


    /**
     * 添加
     */
    @PostMapping
    public Result<String> addBanner(ZBannerDTO zBannerDTO, MultipartFile file) {
        Boolean isSuccess = zBannerService.addBanner(zBannerDTO, file);
        if (isSuccess) {
            return Result.ok();
        }
        return Result.fail();
    }


    /**
     * 删除
     */
    @DeleteMapping
    public Result<String> del(@RequestBody List<Long> ids) {
        return zBannerService.del(ids);
    }

}
