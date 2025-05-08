package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.Category;

import org.apache.ibatis.annotations.Mapper;

/**
 * 餐品分类Mapper接口
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

} 