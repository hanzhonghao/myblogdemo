package com.zhonghao.service.impl;

import com.zhonghao.common.Result;
import com.zhonghao.common.constant.UserConstants;
import com.zhonghao.entity.User;
import com.zhonghao.entity.UserLog;
import com.zhonghao.exception.UserException;
import com.zhonghao.helper.UserConvertUtil;
import com.zhonghao.mapper.UserLogMapper;
import com.zhonghao.mapper.UserMapper;
import com.zhonghao.model.dto.UserDTO;
import com.zhonghao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import static com.zhonghao.enums.UserExceptionEnum.NOT_FOUND_USER;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public static final String salt = "{2038alkdjfwoieurnvytnlklsjdgalkjdfah#}";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public Result<?> userLogin(UserDTO userDTO, HttpServletRequest request) {
        if(userDTO == null) {
            log.error("userDo is empty");
            return Result.fail("用户名密码不能为空");
        }
        User user = userMapper.findByUsername(userDTO.getUsername());
        if(user == null) {
            log.error("user is empty");
            return Result.fail("用户名或密码不正确");
        }
        UserLog userLog = userLogMapper.findByUserId(user.getId());

        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword()+salt).getBytes());
        if(!user.getPassword().equals(pwd)) {
            log.error("user password error");
            if(userLog == null) {
                userLogMapper.save(new UserLog(0L, user.getId(), new Date(), 1, 1));
            } else {
                userLog.setLoginTime(new Date());
                userLog.setLoginErrorCount(userLog.getLoginErrorCount() + 1);
                userLog.setLoginStat(userLog.getLoginStat() + 1);
                userLogMapper.update(userLog);
            }
            return Result.fail("用户名或密码不正确");
        }

        if(userLog != null) {
            if(System.currentTimeMillis() - userLog.getLoginTime().getTime() < 1000 * 60 * 30 && userLog.getLoginErrorCount() >= 3) {
                return Result.fail("该用户禁止登录，请联系管理员");
            }
            userLog.setLoginStat(userLog.getLoginStat() + 1);
            userLog.setLoginTime(new Date());
            userLog.setLoginErrorCount(0);
            userLogMapper.update(userLog);
        } else {
            userLogMapper.save(new UserLog(0L, user.getId(), new Date(), 1, 0));
        }

        request.getSession().setAttribute(UserConstants.SESSION_USER, user);
        return Result.success("登录成功");
    }

    @Override
    public Result<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute(UserConstants.SESSION_USER);
        return Result.success("退出成功");
    }

    @Override
    public Result<?> updateUser(UserDTO userDTO) {
        if(userDTO == null) {
            throw new IllegalArgumentException("userDTO is null");
        }
        User user = userMapper.findByUsername(userDTO.getUsername());
        if (user == null) {
            throw new UserException(NOT_FOUND_USER);
        }
        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword()+salt).getBytes());
        user.setPassword(pwd);
        int i = userMapper.updateByUsername(user);
        return i > 0 ? Result.success("更新成功") : Result.fail("更新失败");
    }

    @Override
    public Result<?> saveUser(UserDTO userDTO) {
        Assert.notNull(userDTO, "userDTO must not be null");

        String pwd = DigestUtils.md5DigestAsHex((userDTO.getPassword() + salt).getBytes());
        userDTO.setPassword(pwd);
        User user = UserConvertUtil.userDTO2User(userDTO, null);
        user.setCreateTime(System.currentTimeMillis());
        int row = userMapper.save(user);
        return row > 0 ? Result.success("添加成功") : Result.fail("添加失败");
    }
}
