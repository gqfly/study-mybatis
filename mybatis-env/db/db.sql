create table if not exists ms_blog (
    id int auto_increment not null comment '主键',
    author varchar(32) not null comment '作者',
    title varchar(32) not null comment '标题',
    details varchar(900) not null comment '详情',
    primary key (id)
);

insert into ms_blog (author, title, details) values ('gqfly', 'Mybatis 学习', 'Mybatis 是一个优秀的持久层框架...');