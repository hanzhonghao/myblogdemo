package com.zhonghao.controller;

import com.github.pagehelper.PageInfo;
import com.zhonghao.common.Result;
import com.zhonghao.model.dto.CommentDTO;
import com.zhonghao.model.query.CommentQuery;
import com.zhonghao.model.vo.CommentVO;
import com.zhonghao.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/list/{articleId}")
    @ResponseBody
    public Result<?> list(@PathVariable("articleId") Long articleId,
                          @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false, defaultValue = "10")Integer pageSize) {
        CommentQuery commentQuery = new CommentQuery();
        commentQuery.setArticleId(articleId);
        commentQuery.setPageNum(pageNum);
        commentQuery.setPageSize(pageSize);
        List<CommentVO> list = commentService.getCommentsByArticleId(commentQuery);
        PageInfo<CommentVO> page = new PageInfo<>(list);
        return Result.success("ok", page);
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Result<?> save(@Valid CommentDTO commentDTO, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        return commentService.save(commentDTO);
    }

}
