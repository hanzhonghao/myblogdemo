package com.zhonghao.service;

import com.zhonghao.model.query.ArticleQuery;
import com.zhonghao.model.vo.ArticleVO;

import java.util.List;

public interface BlogService {



    /**
     * 查询用户all article
     * @param articleQuery
     * @return
     */
    List<ArticleVO> getUserArticle(ArticleQuery articleQuery);

    /**
     * 根据fixedLink获取article
     * @param fixedLink
     * @return
     */
    ArticleVO getArticle(String fixedLink);

    /**
     * 更新article pv
     * @param articleId
     * @return
     */
    int updateArticlePV(Long articleId);

}
