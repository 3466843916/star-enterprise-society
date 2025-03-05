package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.ZBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author happy
 * @create 2024-01-03-{TIME}
 */
@Mapper
public interface ZBannerMapper extends BaseMapper<ZBanner> {
    @Select("SELECT COALESCE(MAX(sort), 0) FROM z_banner")
    Integer selectMaxSort();
}
