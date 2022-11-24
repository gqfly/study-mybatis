package com.gqfly.mybatis;

import com.gqfly.mybatis.entity.Blog;
import com.gqfly.mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author gqfly
 * @version 1.0
 */
public class SqlSessionFactoryTest {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @BeforeEach
    void sqlSessionFactory() throws IOException {
        // 通过xml文件来构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    void selectById() {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectById(1);
        System.out.println(blog);
    }
}
