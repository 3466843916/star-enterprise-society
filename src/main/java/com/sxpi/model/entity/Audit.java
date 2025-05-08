package com.sxpi.model.entity;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 审核表（audits）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit extends BaseEntity {
    /**
     * 审核ID
     */
    private Long id;
    
    /**
     * 业务类型：1-商家入驻，2-配送员认证，3-用户实名认证，4-内容审核，5-退款申请
     */
    private Integer businessType;
    
    /**
     * 审核资料
     */
    private String business;
    
    /**
     * 提交人ID
     */
    private Long submitterId;
    
    /**
     * 审核状态：0-待审核，1-已通过，2-已拒绝
     */
    private Integer status;
    
    /**
     * 提交时间
     */
    private Date submitTime;
    
    /**
     * 审核人ID
     */
    private Long auditorId;
    
    /**
     * 审核时间
     */
    private Date auditTime;
    
    /**
     * 拒绝原因
     */
    private String rejectReason;
    


} 