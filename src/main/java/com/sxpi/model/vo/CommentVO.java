package com.sxpi.model.vo;

import com.sxpi.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评论表（comments）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO extends BaseEntity {
    /**
     * 评论ID
     */
    private Long id;
    
    /**
     * 评论目标类型：1-商家，2-菜品，3-分享，4-活动
     */
    private Integer targetType;
    
    /**
     * 评论目标ID
     */
    private Long targetId;
    
    /**
     * 评论用户ID
     */
    private Long userId;
    
    /**
     * 父评论ID，回复某条评论时有值
     */
    private Long parentId;
    
    /**
     * 根评论ID，回复某条评论时有值
     */
    private Long rootId;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 图片URL，多个用逗号分隔
     */
    private String imageUrls;
    
    /**
     * 点赞数
     */
    private Integer likeCount;
    
    /**
     * 回复数
     */
    private Integer replyCount;
    
    /**
     * 是否匿名：0-否，1-是
     */
    private Integer isAnonymous;
    
    /**
     * 状态：0-待审核，1-已通过，2-已拒绝
     */
    private Integer status;
} 