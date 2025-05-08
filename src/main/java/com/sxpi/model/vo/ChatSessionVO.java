package com.sxpi.model.vo;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 聊天会话表（chat_sessions）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSessionVO extends BaseEntity {
    /**
     * 会话ID
     */
    private Long id;
    
    /**
     * 会话类型：1-单聊，2-群聊
     */
    private Integer sessionType;
    
    /**
     * 会话名称(群聊有效)
     */
    private String name;
    
    /**
     * 会话头像(群聊有效)
     */
    private String avatar;
    
    /**
     * 创建者ID(群聊有效)
     */
    private Long ownerId;
    
    /**
     * 最后一条消息内容
     */
    private String lastMessage;
    
    /**
     * 最后一条消息时间
     */
    private Date lastMessageTime;
    
    /**
     * 成员数量
     */
    private Integer memberCount;
    
    /**
     * 所属社区ID
     */
    private Long communityId;
} 