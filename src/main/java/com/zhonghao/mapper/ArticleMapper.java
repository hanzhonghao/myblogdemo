package com.zhonghao.mapper;

import com.zhonghao.entity.Article;
import com.zhonghao.model.query.ArticleQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    
    int save(Article e);
    
    int delete(Long id);
    
    int update(Article e);
    
    Article findById(Long id);
    
    List<Article> findAll(@Param("q") ArticleQuery articleQuery, @Param("status") int status);

    Article findByFixedLink(String fixedLink);

    int updatePv(Long id);
}
