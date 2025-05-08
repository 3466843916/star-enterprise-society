package com.sxpi.convert;

import com.sxpi.model.dto.AuditDTO;
import com.sxpi.model.entity.Audit;
import com.sxpi.model.vo.AuditVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Audit转换器
 */
@Mapper
public interface AuditConvert {
    AuditConvert INSTANCE = Mappers.getMapper(AuditConvert.class);

    List<AuditVO> convertEntityToVo(List<Audit> audits);
    AuditVO convertEntityToVo(Audit audit);
    Audit convertDtoToEntity(AuditDTO auditDTO);
} 