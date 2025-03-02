package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.model.dto.ZMemberDisplayDTO;
import com.sxpi.model.entity.ZMemberDisplay;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZMemberDisplayVO;
import com.sxpi.service.ZMemberDisplayService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-display")
@RequiredArgsConstructor
public class ZMemberDisplayController {
    @Resource
    private ZMemberDisplayService memberDisplayService;
    
    @GetMapping("/{id}")
    public Result<ZMemberDisplayVO> getById(@PathVariable Long id) {
        return Result.ok(memberDisplayService.getById(id));
    }
    
    @GetMapping("/user/{userId}")
    public Result<List<ZMemberDisplayVO>> getByUserId(@PathVariable Long userId) {
        return Result.ok(memberDisplayService.getByUserId(userId));
    }
    
    @GetMapping("/type/{type}")
    public Result<List<ZMemberDisplayVO>> getByType(@PathVariable Integer type) {
        return Result.ok(memberDisplayService.getByType(type));
    }
    
    @PostMapping
    public Result<Boolean> save(@RequestBody ZMemberDisplayDTO memberDisplayDTO) {
        return Result.ok(memberDisplayService.save(memberDisplayDTO));
    }
    
    @PutMapping
    public Result<Boolean> update(@RequestBody ZMemberDisplayDTO memberDisplayDTO) {
        return Result.ok(memberDisplayService.update(memberDisplayDTO));
    }
    
    @DeleteMapping("/{id}")
    public Result<Boolean> removeById(@PathVariable Long id) {
        return Result.ok(memberDisplayService.removeById(id));
    }

    @GetMapping("/page")
    public Result<Page<ZMemberDisplayVO>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            ZMemberDisplayDTO memberDisplayDTO) {
        Page<ZMemberDisplay> page = new Page<>(current, size);
        return Result.ok(memberDisplayService.page(page, memberDisplayDTO));
    }

    @GetMapping("/list")
    public Result<PageResult<ZMemberDisplayVO>> list(ZMemberDisplay memberDisplay) {
        PageResult<ZMemberDisplayVO> list = memberDisplayService.selectMemberDisplayList(memberDisplay);
        return Result.ok(list);
    }
} 