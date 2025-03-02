package com.sxpi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxpi.model.entity.ZUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
@Mapper
public interface ZUserMapper extends BaseMapper<ZUser> {
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public ZUser selectUserById(Long id);

//    /**
//     * 查询用户列表
//     *
//     * @param user 用户
//     * @return 用户集合
//     */
//    public List<ZUser> selectUserList(ZUser user);
//
//    int selectUserCount(ZUser user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
//    public int insertUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    public int updateUser(ZUser user);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
//    public int deleteUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
//    public int deleteUserByIds(Long[] ids);
}
