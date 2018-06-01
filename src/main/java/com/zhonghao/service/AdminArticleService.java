package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.common.security.IUser;
import com.zhonghao.model.dto.ArticleDTO;
import com.zhonghao.model.query.ArticleQuery;
import com.zhonghao.model.vo.ArticleVO;

import java.util.List;

public interface AdminArticleService {

    /**
     * 保存article
     * @param articleDTO
     * @return
     */
    Result<?> addOrUpdateArticle(ArticleDTO articleDTO);

    /**
     * 编辑article
     * @param articleId
     * @param user 当前登录用户
     * @return
     */
    Result<ArticleVO> editArticle(Long articleId, IUser user);


    /**
     * 删除article
     * @param articleId
     * @param user
     * @return
     */
    Result<?> deleteArticle(Long articleId, IUser user);

    /**
     * 获取用户所有article
     * @param articleQuery
     * @return
     */
    List<ArticleVO> getUserArticleAll(ArticleQuery articleQuery);
}
