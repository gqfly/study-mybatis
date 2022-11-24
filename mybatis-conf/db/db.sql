drop table if exists ms_blog;
create table ms_blog (
    id int auto_increment not null comment '主键',
    author varchar(32) not null comment '作者',
    title varchar(32) not null comment '标题',
    details varchar(900) not null comment '详情',
    primary key (id)
);

insert into ms_blog (author, title, details)
values ('gqfly', 'Mybatis 学习', 'Mybatis 是一个优秀的持久层框架...');

drop table if exists ms_author;
create table ms_author (
    id int auto_increment not null comment '主键',
    name varchar(32) not null comment '名字',
    created_time timestamp comment '创建时间',
    updated_time timestamp comment '更新时间',
    primary key (id)
);