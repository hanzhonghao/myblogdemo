package com.zhonghao.controller;

import com.github.pagehelper.PageInfo;
import com.zhonghao.common.Result;
import com.zhonghao.common.util.DateUtil;
import com.zhonghao.entity.Category;
import com.zhonghao.model.query.ArticleQuery;
import com.zhonghao.model.vo.ArticleVO;
import com.zhonghao.service.BlogService;
import com.zhonghao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author tt
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    long defaultCreateUser = 2;

    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list")
    public ModelAndView postList(ArticleQuery articleQuery) {
        ModelAndView mv = new ModelAndView();
        articleQuery.setCreateUser(defaultCreateUser);
        List<ArticleVO> list = blogService.getUserArticle(articleQuery);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(list);
        mv.addObject("page", pageInfo);
        mv.setViewName("article/list");
        return mv;
    }

    @RequestMapping(value = "/{fixedLink}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("fixedLink") String fixedLink) {
        ModelAndView mv = new ModelAndView();
        ArticleVO articleVO = blogService.getArticle(fixedLink);
        if(articleVO == null) {
            return null;
        }
        mv.addObject("id", articleVO.getId());
        mv.addObject("atitle", articleVO.getTitle());
        mv.addObject("createUser", articleVO.getCreateUser());
        mv.addObject("createUserName", articleVO.getCreateUserName());
        mv.addObject("articleId", articleVO.getId());
        mv.addObject("desc", articleVO.getDesc());
        mv.addObject("html", articleVO.getHtml());
        mv.addObject("time", DateUtil.date2String(articleVO.getCreateTime(), DateUtil.YYYY_MM_DD));
        mv.addObject("pv", articleVO.getPv());
        mv.setViewName("article/detail");
        return mv;
    }
    
    @GetMapping("/categorys")
    @ResponseBody
    public Result<?> categorys() {
        List<Category> categorys = categoryService.getCategorys(defaultCreateUser);
        return Result.success("", categorys);
    }
    
    @GetMapping("/pv/{articleId}")
    @ResponseBody
    public Result<?> pv(@PathVariable("articleId") Long articleId) {
        blogService.updateArticlePV(articleId);
        return Result.success("ok");
    }
    
    @GetMapping("/sidebar")
    public ModelAndView sidebar() {
    	ModelAndView mv = new ModelAndView("/article/_sidebar");
    	getCategorys(mv, defaultCreateUser);
        
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setCreateUser(defaultCreateUser);
        articleQuery.setPageSize(5);
        List<ArticleVO> top5 = blogService.getUserArticle(articleQuery);
        mv.addObject("top5", top5);
        
        return mv;
    }
    
    @GetMapping("/header")
    public ModelAndView header() {
    	ModelAndView mv = new ModelAndView("/article/_header");
    	getCategorys(mv, defaultCreateUser);
    	return mv;
    }
    
    private void getCategorys(ModelAndView mv, Long createUser) {
    	List<Category> categorys = categoryService.getCategorys(defaultCreateUser);
        mv.addObject("categorys", categorys);
    }

}
