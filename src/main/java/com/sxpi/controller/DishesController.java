package com.sxpi.controller;

import com.sxpi.common.result.Result;
import com.sxpi.convert.DishesConvert;
import com.sxpi.model.dto.DishesDTO;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.DishesVO;
import com.sxpi.service.DishesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 菜品管理接口
 *
 * @author happy
 * @since 2025-03-10
 */
@RestController
@RequestMapping("/dishes")
public class DishesController {

    @Resource
    private DishesService dishesService;

    /**
     * 分页查询菜品列表
     */
    @GetMapping("/list")
    public Result<PageResult<DishesVO>> pageList(DishesDTO dishesDTO) {
        PageResult<DishesVO> pageResult = dishesService.pageList(dishesDTO);
        return Result.ok(pageResult);
    }

    /**
     * 新增菜品
     */
    @PostMapping
    public Result<Boolean> add(@RequestBody DishesDTO dishesDTO,
                               List<MultipartFile> files) {
        return Result.ok(dishesService.saveDishes(dishesDTO, files));
    }

    /**
     * 根据ID查询菜品详情
     */
    @GetMapping("/{id}")
    public Result<DishesVO> selectById(@PathVariable Long id) {
        Dishes dish = dishesService.getById(id);
        return Result.ok(DishesConvert.INSTANCE.convertEntityToVo(dish));
    }

    /**
     * 更新菜品
     */
    @PutMapping
    public Result<String> update(@RequestBody DishesDTO dishesDTO) {
        Dishes dish = DishesConvert.INSTANCE.convertDtoToEntity(dishesDTO);
        boolean updated = dishesService.updateById(dish);
        return updated ? Result.ok("更新成功") : Result.fail("更新失败");
    }

    /**
     * 批量删除菜品
     */
    @DeleteMapping
    public Result<String> delete(@RequestBody List<Long> ids) {
        boolean removed = dishesService.removeBatchByIds(ids);
        return removed ? Result.ok("删除成功") : Result.fail("删除失败");
    }

    /**
     * 删除菜品
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable Long id){
        boolean removed = dishesService.removeById(id);
        return removed ? Result.ok("删除成功") : Result.fail("删除失败");
    }
}
