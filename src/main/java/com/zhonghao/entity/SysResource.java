package com.zhonghao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统资源(t_resource)
 *
 */
@Setter
@Getter
@ToString
public class SysResource implements java.io.Serializable {

    private Long id;
    private String url;
    private Long createUser;
    private Long createTime;
}
