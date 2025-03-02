package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZResourceDTO;
import com.sxpi.model.entity.ZResource;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZResourceVO;
import com.sxpi.service.ZResourceService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ZResourceController {
    @Resource
    private ZResourceService resourceService;
    
    @GetMapping("/{id}")
    public Result<ZResourceVO> getById(@PathVariable Long id) {
        return Result.ok(resourceService.getById(id));
    }
    
    @GetMapping("/user/{userId}")
    public Result<List<ZResourceVO>> getByUserId(@PathVariable Long userId) {
        return Result.ok(resourceService.getByUserId(userId));
    }
    
    @GetMapping("/category/{category}")
    public Result<List<ZResourceVO>> getByCategory(@PathVariable String category) {
        return Result.ok(resourceService.getByCategory(category));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZResourceDTO resourceDTO) {
        return Result.ok(resourceService.save(resourceDTO));
    }
    
    @PutMapping
    public Result<Boolean> update(@RequestBody ZResourceDTO resourceDTO) {
        return Result.ok(resourceService.update(resourceDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> remove(@PathVariable Long id) {
        return Result.ok(resourceService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZResourceVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZResourceDTO resourceDTO) {
        Page<ZResource> page = new Page<>(current, size);
        return Result.ok(resourceService.page(page, resourceDTO));
    }

    @GetMapping("/list")
    public Result<PageResult<ZResourceVO>> list(ZResource resource) {
        PageResult<ZResourceVO> list = resourceService.selectResourceList(resource);
        return Result.ok(list);
    }
} 