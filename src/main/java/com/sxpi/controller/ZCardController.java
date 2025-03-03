package com.sxpi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.common.result.Result;
import com.sxpi.convert.ZCardConvert;
import com.sxpi.model.dto.ZCardDTO;
import com.sxpi.model.entity.ZCard;
import com.sxpi.model.enums.CardEnum;
import com.sxpi.model.vo.ZCardVO;
import com.sxpi.service.ZCardService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class ZCardController {
    private static final Logger log = LoggerFactory.getLogger(ZCardController.class);
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
        cardDTO.setStatus(CardEnum.UP_SHELVES.getCode());
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
    @PutMapping("shelves")
    public Result<String> shelves(@RequestBody ZCard zCardDTO) {
        // 根据传入的 id 从数据库中查询出对应记录
        ZCardVO card = cardService.getById(zCardDTO.getId());
        if (card == null) {
            return Result.fail("未找到对应记录");
        }

        // 获取数据库中当前的状态
        Integer currentStatus = card.getStatus();
        if (currentStatus != null && currentStatus.equals(CardEnum.ON_SHELVES.getCode())) {
            // 当前状态为上架，改为下架
            card.setStatus(CardEnum.UP_SHELVES.getCode());
        } else {
            // 当前状态为下架或null，改为上架
            card.setStatus(CardEnum.ON_SHELVES.getCode());
        }

        // 使用 ZCardConvert 工具类将 ZCardVO 转换为 ZCard
        ZCard zCard = ZCardConvert.INSTANCE.convertVoToEntity(card);
        // 使用 ZCardConvert 工具类将 ZCard 转换为 ZCardDTO
        ZCardDTO convertedZCardDTO = ZCardConvert.INSTANCE.convertEntityToDto(zCard);

        boolean update = cardService.update(convertedZCardDTO);
        if (update) {
            return Result.ok("操作成功");
        }
        return Result.fail("操作失败");
    }




} 