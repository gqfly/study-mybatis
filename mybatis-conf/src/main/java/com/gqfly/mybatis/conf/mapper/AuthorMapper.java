package com.gqfly.mybatis.conf.mapper;

import com.gqfly.mybatis.conf.entity.Author;
import org.apache.ibatis.annotations.Param;

/**
 * @author gqfly
 * @version 1.0
 */
public interface AuthorMapper {

    Integer insert(@Param("author") Author author);

    Author selectById(@Param("id") Integer id);
}