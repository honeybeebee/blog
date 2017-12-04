package com.bee.myApp.blog.dao.mapper;

import com.bee.myApp.blog.dao.entity.ArticleComment;
import java.util.List;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    ArticleComment selectByPrimaryKey(Long id);

    List<ArticleComment> selectAll();

    int updateByPrimaryKey(ArticleComment record);
}