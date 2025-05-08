package com.sxpi.convert;

import com.sxpi.model.dto.AuditDTO;
import com.sxpi.model.entity.Audit;
import com.sxpi.model.vo.AuditVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-06T04:08:48+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
public class AuditConvertImpl implements AuditConvert {

    @Override
    public List<AuditVO> convertEntityToVo(List<Audit> audits) {
        if ( audits == null ) {
            return null;
        }

        List<AuditVO> list = new ArrayList<AuditVO>( audits.size() );
        for ( Audit audit : audits ) {
            list.add( convertEntityToVo( audit ) );
        }

        return list;
    }

    @Override
    public AuditVO convertEntityToVo(Audit audit) {
        if ( audit == null ) {
            return null;
        }

        AuditVO auditVO = new AuditVO();

        auditVO.setPageNo( audit.getPageNo() );
        auditVO.setPageSize( audit.getPageSize() );
        auditVO.setCreatedBy( audit.getCreatedBy() );
        auditVO.setCreatedTime( audit.getCreatedTime() );
        auditVO.setUpdateBy( audit.getUpdateBy() );
        auditVO.setUpdateTime( audit.getUpdateTime() );
        auditVO.setIsDeleted( audit.getIsDeleted() );
        auditVO.setId( audit.getId() );
        auditVO.setBusinessType( audit.getBusinessType() );
        auditVO.setBusiness( audit.getBusiness() );
        auditVO.setSubmitterId( audit.getSubmitterId() );
        auditVO.setStatus( audit.getStatus() );
        auditVO.setSubmitTime( audit.getSubmitTime() );
        auditVO.setAuditorId( audit.getAuditorId() );
        auditVO.setAuditTime( audit.getAuditTime() );
        auditVO.setRejectReason( audit.getRejectReason() );

        return auditVO;
    }

    @Override
    public Audit convertDtoToEntity(AuditDTO auditDTO) {
        if ( auditDTO == null ) {
            return null;
        }

        Audit audit = new Audit();

        audit.setPageNo( auditDTO.getPageNo() );
        audit.setPageSize( auditDTO.getPageSize() );
        audit.setCreatedBy( auditDTO.getCreatedBy() );
        audit.setCreatedTime( auditDTO.getCreatedTime() );
        audit.setUpdateBy( auditDTO.getUpdateBy() );
        audit.setUpdateTime( auditDTO.getUpdateTime() );
        audit.setIsDeleted( auditDTO.getIsDeleted() );
        audit.setId( auditDTO.getId() );
        audit.setBusinessType( auditDTO.getBusinessType() );
        audit.setBusiness( auditDTO.getBusiness() );
        audit.setSubmitterId( auditDTO.getSubmitterId() );
        audit.setStatus( auditDTO.getStatus() );
        audit.setSubmitTime( auditDTO.getSubmitTime() );
        audit.setAuditorId( auditDTO.getAuditorId() );
        audit.setAuditTime( auditDTO.getAuditTime() );
        audit.setRejectReason( auditDTO.getRejectReason() );

        return audit;
    }
}
