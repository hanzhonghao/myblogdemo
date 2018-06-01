package com.zhonghao.common.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseQuery {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private Long createUser;
    private String createUserName;

}
