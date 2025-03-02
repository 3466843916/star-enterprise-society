package com.sxpi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxpi.mapper.ZBannerMapper;
import com.sxpi.model.entity.ZBanner;
import com.sxpi.service.ZBannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author happy
 * @create 2024-01-03-{TIME}
 */
@Service
@Slf4j
@Transactional
public class ZBannerServiceImpl extends ServiceImpl<ZBannerMapper, ZBanner> implements ZBannerService {

}
