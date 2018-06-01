package com.zhonghao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分类(t_category)
 *
 */
@Setter
@Getter
@ToString
public class Category {

    private Long id;
    private String name;
    private String aliasName;
    private Long createUser;
    private Long createTime;
    private Long updateUser;
    private Long updateTime;


}
