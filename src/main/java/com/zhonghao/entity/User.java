package com.zhonghao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 用户(t_user)
 * @author tt
 *
 */
@Data
public class User  {

    private Long id;
    private String username;
    private String password;
    private String nickName;
    private Long createTime;
    
}
