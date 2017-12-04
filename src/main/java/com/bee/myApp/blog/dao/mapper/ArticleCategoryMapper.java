package com.bee.myApp.blog.dao.mapper;

import com.bee.myApp.blog.dao.entity.ArticleCategory;
import java.util.List;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Long id);

    List<ArticleCategory> selectAll();

    int updateByPrimaryKey(ArticleCategory record);
}