package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.model.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tt
 */
public interface UserService {

    /**
     * 用户登录
     * @param userDTO
     * @param request
     * @return 0 登录成功
     */
    Result<?> userLogin(UserDTO userDTO, HttpServletRequest request);

    /**
     * 退出登录
     * @param request
     * @return
     */
    Result<?> logout(HttpServletRequest request);
    
    /**
     * 根据username 修改密码
     * @param userDTO
     * @return
     */
    Result<?> updateUser(UserDTO userDTO);

    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    Result<?> saveUser(UserDTO userDTO);
}
