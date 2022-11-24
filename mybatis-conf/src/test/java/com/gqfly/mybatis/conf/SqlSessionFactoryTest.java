package com.gqfly.mybatis.conf;

import com.gqfly.mybatis.conf.entity.Author;
import com.gqfly.mybatis.conf.entity.Blog;
import com.gqfly.mybatis.conf.mapper.AuthorMapper;
import com.gqfly.mybatis.conf.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

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
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    void selectBlogById() {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectById(1);
        System.out.println(blog);
    }

    @Test
    void insert() {
        Author author = Author.builder()
                .name("gqfly")
                .createdTime(Instant.now())
                .updatedTime(Instant.now())
                .build();
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        Integer id = authorMapper.insert(author);
        System.out.println(id);
        System.out.println(author);
    }

    @Test
    void selectAuthorById() {
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        Author author = authorMapper.selectById(1);
        System.out.println(author);
    }

    @AfterEach
    void close() {
        sqlSession.close();
    }
}
