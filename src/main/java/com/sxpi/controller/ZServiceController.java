package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZServiceDTO;
import com.sxpi.model.entity.ZService;
import com.sxpi.model.vo.ZServiceVO;
import com.sxpi.service.ZServiceService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ZServiceController {
    @Resource
    private ZServiceService serviceService;
    
    @GetMapping("/{id}")
    public Result<ZServiceVO> getById(@PathVariable Long id) {
        return Result.ok(serviceService.getById(id));
    }
    
    @GetMapping("/name/{name}")
    public Result<List<ZServiceVO>> getByName(@PathVariable String name) {
        return Result.ok(serviceService.getByName(name));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZServiceDTO serviceDTO) {
        return Result.ok(serviceService.save(serviceDTO));
    }
    
    @PutMapping
    public Result<Boolean> update(@RequestBody ZServiceDTO serviceDTO) {
        return Result.ok(serviceService.update(serviceDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.ok(serviceService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZServiceVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZServiceDTO serviceDTO) {
        Page<ZService> page = new Page<>(current, size);
        return Result.ok(serviceService.page(page, serviceDTO));
    }
} 