package com.zhonghao.entity;

import com.zhonghao.common.security.IUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 用户(t_user)
 * @author tt
 *
 */
@Getter
@Setter
@ToString
public class User implements IUser {

    private Long id;
    private String username;
    private String password;
    private String nickName;
    private Long createTime;

}
