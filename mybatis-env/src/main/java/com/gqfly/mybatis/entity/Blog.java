package com.gqfly.mybatis.entity;

import lombok.Data;

/**
 * @author gqfly
 * @version 1.0
 */
@Data
public class Blog {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 作者
     */
    private String author;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String details;
}