package com.sxpi.model.dto;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 系统消息通知表（system_notifications）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemNotificationDTO extends BaseEntity {
    /**
     * 通知ID
     */
    private Long id;
    
    /**
     * 接收用户ID
     */
    private Long userId;
    
    /**
     * 通知标题
     */
    private String title;
    
    /**
     * 通知内容
     */
    private String content;
    
    /**
     * 通知类型：1-系统消息，2-活动通知，3-订单通知，4-社区通知，5-优惠促销
     */
    private Integer notificationType;
    
    /**
     * 关联业务ID
     */
    private Long relatedId;
    
    /**
     * 关联业务类型：1-订单，2-活动，3-评价，4-社区动态
     */
    private Integer relatedType;
    
    /**
     * 是否已读：0-未读，1-已读
     */
    private Integer isRead;
    
    /**
     * 阅读时间
     */
    private Date readTime;
    
    /**
     * 优先级：1-普通，2-重要，3-紧急
     */
    private Integer priority;
    
    /**
     * 过期时间
     */
    private Date expireTime;
    
    /**
     * 推送状态：0-未推送，1-已推送，2-推送失败
     */
    private Integer pushStatus;
    
    /**
     * 推送时间
     */
    private Date pushTime;
} 