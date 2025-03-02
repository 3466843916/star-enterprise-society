package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZCardDTO;
import com.sxpi.model.entity.ZCard;
import com.sxpi.model.vo.ZCardVO;
import com.sxpi.service.ZCardService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class ZCardController {
    @Resource
    private ZCardService cardService;
    
    @GetMapping("/{id}")
    public Result<ZCardVO> getById(@PathVariable Long id) {
        return Result.ok(cardService.getById(id));
    }
    
    @GetMapping("/user/{userId}")
    public Result<List<ZCardVO>> getByUserId(@PathVariable Long userId) {
        return Result.ok(cardService.getByUserId(userId));
    }
    
    @GetMapping("/company/{company}")
    public Result<List<ZCardVO>> getByCompany(@PathVariable String company) {
        return Result.ok(cardService.getByCompany(company));
    }
    
    @GetMapping("/tag/{tag}")
    public Result<List<ZCardVO>> getByTag(@PathVariable String tag) {
        return Result.ok(cardService.getByTag(tag));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZCardDTO cardDTO) {
        return Result.ok(cardService.save(cardDTO));
    }
    
    @PutMapping
    public Result<Boolean> update(@RequestBody ZCardDTO cardDTO) {
        return Result.ok(cardService.update(cardDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> removeById(@PathVariable Long id) {
        return Result.ok(cardService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZCardVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZCardDTO cardDTO) {
        Page<ZCard> page = new Page<>(current, size);
        return Result.ok(cardService.page(page, cardDTO));
    }
} 