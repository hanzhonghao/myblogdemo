package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.model.dto.CommentDTO;
import com.zhonghao.model.query.CommentQuery;
import com.zhonghao.model.vo.CommentVO;

import java.util.List;

public interface CommentService {

    /**
     * 根据文章id获取评论
     * @param commentQuery
     * @return
     */
    List<CommentVO> getCommentsByArticleId(CommentQuery commentQuery);

    /**
     * 评论文章
     * @param commentDTO
     * @return
     */
    Result<?> save(CommentDTO commentDTO);
}
