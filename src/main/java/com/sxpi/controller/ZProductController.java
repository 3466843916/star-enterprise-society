package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZProductDTO;
import com.sxpi.model.entity.ZProduct;
import com.sxpi.model.vo.ZProductVO;
import com.sxpi.service.ZProductService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ZProductController {
    @Resource
    private ZProductService productService;
    
    @GetMapping("/{id}")
    public Result<ZProductVO> getById(@PathVariable Long id) {
        return Result.ok(productService.getById(id));
    }
    
    @GetMapping("/status/{status}")
    public Result<List<ZProductVO>> getByStatus(@PathVariable Integer status) {
        return Result.ok(productService.getByStatus(status));
    }
    
    @GetMapping("/name/{name}")
    public Result<List<ZProductVO>> getByName(@PathVariable String name) {
        return Result.ok(productService.getByName(name));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZProductDTO productDTO) {
        return Result.ok(productService.save(productDTO));
    }
    
    @PutMapping
    public Result<Boolean> update(@RequestBody ZProductDTO productDTO) {
        return Result.ok(productService.update(productDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> removeById(@PathVariable Long id) {
        return Result.ok(productService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZProductVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZProductDTO productDTO) {
        Page<ZProduct> page = new Page<>(current, size);
        return Result.ok(productService.page(page, productDTO));
    }
} 