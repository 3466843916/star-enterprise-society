package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZCardFavoritesDTO;
import com.sxpi.model.entity.ZCardFavorites;
import com.sxpi.model.vo.ZCardFavoritesVO;
import com.sxpi.service.ZCardFavoritesService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-favorites")
@RequiredArgsConstructor
public class ZCardFavoritesController {
    @Resource
    private ZCardFavoritesService favoritesService;
    
    @GetMapping("/{id}")
    public Result<ZCardFavoritesVO> getById(@PathVariable Long id) {
        return Result.ok(favoritesService.getById(id));
    }
    
    @GetMapping("/user/{userId}")
    public Result<List<ZCardFavoritesVO>> getByUserId(@PathVariable Long userId) {
        return Result.ok(favoritesService.getByUserId(userId));
    }
    
    @GetMapping("/card/{cardId}")
    public Result<List<ZCardFavoritesVO>> getByCardId(@PathVariable Long cardId) {
        return Result.ok(favoritesService.getByCardId(cardId));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZCardFavoritesDTO favoritesDTO) {
        return Result.ok(favoritesService.save(favoritesDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> removeById(@PathVariable Long id) {
        return Result.ok(favoritesService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZCardFavoritesVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZCardFavoritesDTO favoritesDTO) {
        Page<ZCardFavorites> page = new Page<>(current, size);
        return Result.ok(favoritesService.page(page, favoritesDTO));
    }
} 