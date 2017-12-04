package com.bee.myApp.blog.dao.mapper;

import com.bee.myApp.blog.dao.entity.Administrator;
import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Administrator record);

    Administrator selectByPrimaryKey(Long id);

    List<Administrator> selectAll();

    int updateByPrimaryKey(Administrator record);
}