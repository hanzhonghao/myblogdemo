package com.zhonghao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统参数(t_param)
 *
 */
@Setter
@Getter
@ToString
public class SysParam implements java.io.Serializable {

    private String paramName;
    private String paramValue;
    private Long createUser;
    private Long createTime;
    private Long updateUser;
    private Long updateTime;

}
