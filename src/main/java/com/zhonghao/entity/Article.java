package com.zhonghao.entity;

import lombok.Data;

/**
 * Created by zhonghao.han on 5/31/2018.
 */
@Data
public class Article {
    private Long id;
    private String title;
    private String fixedLink;
    private String content;
    private String html;
    private Integer isShow;
    private Integer sortValue;
    private Long categoryName;
    private String tags;
    private Long createUser;
    private Long createTime;
    private Long updateTime;

}
