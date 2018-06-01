package com.zhonghao.model.query;

import com.zhonghao.common.bean.BaseQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ArticleQuery extends BaseQuery {

    private Long createUser;
    private Integer isShow;
    private String title;
    private String content;
    private Long categoryId;
    private String tags;

}
