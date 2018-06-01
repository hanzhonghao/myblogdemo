package com.zhonghao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhonghao.common.Result;
import com.zhonghao.entity.Comment;
import com.zhonghao.enums.StatusEnum;
import com.zhonghao.helper.CommentConvertUtil;
import com.zhonghao.mapper.CommentMapper;
import com.zhonghao.model.dto.CommentDTO;
import com.zhonghao.model.query.CommentQuery;
import com.zhonghao.model.vo.CommentVO;
import com.zhonghao.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVO> getCommentsByArticleId(CommentQuery commentQuery) {
        PageHelper.startPage(commentQuery.getPageNum(), commentQuery.getPageSize());
        List<Comment> list = commentMapper.findByCommentObj(commentQuery.getArticleId());
        Page<Comment> temp = (Page<Comment>) list;
        Page<CommentVO> page = new Page<>(temp.getPageNum(), temp.getPageSize());
        page.setTotal(temp.getTotal());
        for (Comment c : list) {
            page.add(CommentConvertUtil.comment2CommentVO(c, null));
        }
        return page;
    }

    @Override
    public Result<?> save(CommentDTO commentDTO) {
        Assert.notNull(commentDTO, "commentDTO must not be null");
        Comment comment = CommentConvertUtil.commentDTO2Comment(commentDTO, null);
        if (comment.getParentId() != null) {
            Comment parent = commentMapper.findById(comment.getParentId());
            if (parent != null) {
                comment.setToNickName(parent.getNickName());
            }
        }
        comment.setStatus(StatusEnum.OK.getKey());
        comment.setCreateTime(System.currentTimeMillis());
        int row = commentMapper.save(comment);
        return row > 0 ? Result.success("保存成功") : Result.fail("保存失败");
    }

}
