package com.zhonghao.model.query;

import com.zhonghao.common.bean.BaseQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class CommentQuery extends BaseQuery {

    private Long articleId;

}
