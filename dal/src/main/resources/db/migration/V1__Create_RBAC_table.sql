/**
  CREATE DATABASE  `superm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
  grant all on superm.* to 'superm'@'%';
 */
create table if not exists `user`
(
    `id`          int(10) unsigned auto_increment primary key,
    `username`    varchar(32) not null comment '帐号名称，唯一，手机号或邮箱',
    `password`    varchar(128)         default '' comment '加密后的密码',
    `state`       tinyint     not null default 0 comment '帐号状态 0:正常 1禁用',
    `create_time` timestamp   not null default current_timestamp comment '创建时间',
    `update_time` timestamp   not null default current_timestamp on update current_timestamp comment '更新时间',
    unique key `uqx_username` (`username`)
) engine = innodb
  default charset = utf8mb4;


create table if not exists `role`
(
    `id`          int(10) unsigned auto_increment primary key,
    `name`        varchar(64) not null comment '角色名称',
    `desc`        varchar(256) comment '角色描述',
    `create_time` timestamp   not null default current_timestamp comment '创建时间',
    `update_time` timestamp   not null default current_timestamp on update current_timestamp comment '更新时间',
    unique key `uqx_name` (`name`)
) engine = innodb
  default charset = utf8mb4;

create table if not exists `resource`
(
    `id`        int(10) unsigned auto_increment primary key,
    `name`      varchar(64)      not null comment '资源名称',
    `desc`      varchar(256) comment '资源描述',
    `path`      varchar(256) comment '资源路径',
    `type`      tinyint unsigned not null comment '资源类型，菜单、资源等',
    `parent_id` int(10) unsigned default 0 comment '父id'
) engine = innodb
  default charset = utf8mb4;

create table if not exists `user_role`
(
    `user_id`     int(10) unsigned not null comment 'user id',
    `role_id`     int(10) unsigned not null comment 'role id',
    `create_time` timestamp        not null default current_timestamp comment '创建时间',
    `update_time` timestamp        not null default current_timestamp on update current_timestamp comment '更新时间',
    unique key `uqx_user_role` (`user_id`, `role_id`)
) engine = innodb
  default charset = utf8mb4;

create table if not exists `role_resource`
(
    `role_id`     int(10) unsigned not null comment 'role id',
    `resource_id` int(10) unsigned not null comment 'resource id',
    `create_time` timestamp        not null default current_timestamp comment '创建时间',
    `update_time` timestamp        not null default current_timestamp on update current_timestamp comment '更新时间',
    unique key `uqx_role_resource` (`role_id`, `resource_id`)
) engine = innodb
  default charset = utf8mb4;