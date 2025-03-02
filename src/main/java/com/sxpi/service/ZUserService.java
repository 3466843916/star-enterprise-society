package com.sxpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxpi.common.result.ResultCodeEnum;
import com.sxpi.model.dto.Login;
import com.sxpi.model.dto.ZUserDTO;
import com.sxpi.model.entity.ZUser;
import com.sxpi.model.page.PageResult;
import com.sxpi.model.vo.ZUserVO;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author happy
 * @create 2024-07-31-{TIME}
 */
public interface ZUserService extends IService<ZUser> {


    ZUserVO loginOrRegister(Login login);

    ResultCodeEnum logout(HttpServletRequest request);

    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public ZUserVO selectUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public PageResult<ZUserVO> selectUserList(ZUser user);

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

    Boolean cancel(Integer id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
//    public int deleteUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
//    public int deleteUserById(Long id);

}
