package com.sxpi.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.sxpi.common.BaseEntity;
import com.sxpi.model.page.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author happy
 * @create 2024-01-07-{TIME}
 */
@Data
@TableName(value = "z_user", autoResultMap = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
public class ZUser extends BaseEntity implements UserDetails, Serializable {
    private static final long serialVersionUID = -1212367372911855308L;

    @TableId
    private Long id;            // 用户id
    private String username;
    private String password;
    private String phone;
    private Integer gender;
    private String avatar;

//    /** 创建者 */
//    private Long createdBy;
//
//    /** 创建时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createdTime;
//
//    /** 更新者 */
//    private Long updateBy;
//
//    /** 更新时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updateTime;
//
//    /**
//     * 是否删除（0否，1是）
//     */
//    @TableLogic
//    private Integer isDeleted;


    @TableField(exist = false)
    private List<String> permissions;
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<SimpleGrantedAuthority> authorities;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        if (authorities != null) {
            return authorities;
        }
//        authorities = permissions.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        if (this.permissions == null) {
            permissions = new ArrayList<>();
        }
        authorities = new ArrayList<>();
        for (String permission : permissions) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        }
        return authorities;
//        return null;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
