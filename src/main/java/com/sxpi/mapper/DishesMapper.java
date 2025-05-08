package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.Dishes;
import com.sxpi.model.vo.DishesVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author happy
 * @create 2025-03-10-{TIME}
 */
@Mapper
public interface DishesMapper extends BaseMapper<Dishes> {

}
