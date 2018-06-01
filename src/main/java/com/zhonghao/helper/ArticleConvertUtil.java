package com.zhonghao.helper;


import com.zhonghao.entity.Article;
import com.zhonghao.model.dto.ArticleDTO;
import com.zhonghao.model.vo.ArticleVO;
import com.zhonghao.common.util.DozerUtil;

import java.util.Date;

public final class ArticleConvertUtil {

    public static Article articleDTO2Article(ArticleDTO articleDTO, Article article) {
        if(article == null) {
            article = new Article();
        }
        if(articleDTO == null) {
            return article;
        }
        DozerUtil.map(articleDTO, article);
        if (articleDTO.getCreateTime() != null) {
            article.setCreateTime(articleDTO.getCreateTime().getTime());
        }
        return article;
    }

    public static ArticleVO article2ArticleVO(Article article) {
        ArticleVO vo = new ArticleVO();
        if(article == null) {
            return vo;
        }
        DozerUtil.map(article, vo);
        if (article.getCreateTime() != null) {
            vo.setCreateTime(new Date(article.getCreateTime()));
        }
        return vo;
    }

}
