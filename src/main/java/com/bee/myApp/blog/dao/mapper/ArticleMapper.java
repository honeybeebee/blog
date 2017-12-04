package com.bee.myApp.blog.dao.mapper;

import com.bee.myApp.blog.dao.entity.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);
}