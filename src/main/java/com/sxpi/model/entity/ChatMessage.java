package com.sxpi.model.entity;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 聊天消息表（chat_messages）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage extends BaseEntity {
    /**
     * 消息ID
     */
    private Long id;
    
    /**
     * 会话ID
     */
    private Long sessionId;
    
    /**
     * 发送者ID
     */
    private Long senderId;
    
    /**
     * 消息类型：1-文本，2-图片，3-语音，4-视频，5-位置，6-文件，7-系统消息
     */
    private Integer messageType;
    
    /**
     * 消息内容
     */
    private String content;
    
    /**
     * 媒体URL
     */
    private String mediaUrl;
    
    /**
     * 媒体大小(字节)
     */
    private Long mediaSize;
    
    /**
     * 媒体时长(秒)
     */
    private Integer mediaDuration;
    
    /**
     * 缩略图URL
     */
    private String thumbnail;
    
    /**
     * 纬度(位置消息)
     */
    private BigDecimal latitude;
    
    /**
     * 经度(位置消息)
     */
    private BigDecimal longitude;
    
    /**
     * 地址(位置消息)
     */
    private String address;
    
    /**
     * 引用消息ID(回复某条消息)
     */
    private Long referenceId;
} 