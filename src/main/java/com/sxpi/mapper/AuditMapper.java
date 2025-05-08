package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxpi.model.entity.Audit;

import org.apache.ibatis.annotations.Mapper;

/**
 * 审核Mapper接口
 */
@Mapper
public interface AuditMapper extends BaseMapper<Audit> {

} 