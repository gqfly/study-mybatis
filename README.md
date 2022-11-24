# Mybatis 学习之旅
## 认识 Mybatis
* MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射
* MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作
* MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录
## 入门 Hello World
### 引入依赖
要使用 MyBatis，只需将 Mybatis 的 jar 文件置于类路径（classpath）中即可。
如果使用 Maven 来构建项目，则需将下面的依赖代码置于 pom.xml 文件中：
```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.11</version>
</dependency>
```
### 从 XML 中构建 SqlSessionFactory
```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/study_mybatis?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false
jdbc.username=root
jdbc.password=123456
```
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <properties resource="jdbc.properties" />
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="mapper/BlogMapper.xml"/>
    </mappers>
</configuration>
```
```java
// 通过xml文件来构建SqlSessionFactory
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("mybatis-config.xml"));
```
### 获取 SqlSession
```java
SqlSession sqlSession = sqlSessionFactory.openSession();
```
### 查询数据库
```java
BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
Blog blog = blogMapper.selectById(1);
System.out.println(blog);
```