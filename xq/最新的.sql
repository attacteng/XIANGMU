create table if not exists admin
(
    id       int          not null comment '管理员'
        constraint `PRIMARY`
        primary key,
    username varchar(255) null comment '用户名',
    password varchar(255) null comment '密码',
    name     varchar(255) null comment '名字',
    phone    varchar(255) null comment '手机',
    age      int          null comment '年龄',
    sex      int          null comment '性别'
);

create table if not exists building
(
    id   int auto_increment
        constraint `PRIMARY`
        primary key,
    name varchar(255) null,
    type int          null comment '0：电梯；1：楼梯'
);

create table if not exists room
(
    id          int auto_increment
        constraint `PRIMARY`
        primary key,
    name        varchar(255) null comment '房屋名称',
    area        varchar(255) null comment '房屋面积',
    status      varchar(255) null comment '是否为空',
    building_id int          null,
    constraint room_ibfk_1
        foreign key (building_id) references building (id)
);

create index building
    on room (building_id);

create table if not exists tousu
(
    id      int auto_increment
        constraint `PRIMARY`
        primary key,
    content varchar(255) null,
    user_id int          null,
    status  int          null,
    time    datetime     null,
    result  varchar(255) null
);

create index `6`
    on tousu (user_id);

create table if not exists user
(
    id       int auto_increment,
    username varchar(255) null comment '用户名',
    password varchar(255) null comment '密码',
    user_id  varchar(60)  not null comment '身份证',
    name     varchar(255) null comment '姓名',
    sex      int          null comment '性别',
    work     varchar(60)  null comment '工作单位',
    phone    varchar(255) not null comment '手机号',
    family   int          null comment '家庭人口',
    constraint `PRIMARY`
        primary key (id, phone, user_id)
);

create table if not exists repair
(
    id         int auto_increment
        constraint `PRIMARY`
        primary key,
    content    varchar(255) null,
    user_id    int          null,
    status     varchar(255) null comment '是否解决',
    admin_name varchar(255) null comment '负责人名字',
    time       datetime     null comment '创建时间',
    result     varchar(255) null,
    constraint repair_ibfk_1
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

create index `5`
    on repair (user_id);

create table if not exists user_payment
(
    id      int auto_increment
        constraint `PRIMARY`
        primary key,
    user_id int          null,
    room_Id int          null,
    time    datetime     null,
    status  int          null,
    value   varchar(255) null,
    constraint `11`
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

create table if not exists user_room
(
    id      int auto_increment
        constraint `PRIMARY`
        primary key,
    user_id int null comment '用户',
    room_id int null comment '房屋',
    constraint `4`
        foreign key (room_id) references room (id)
            on update cascade on delete cascade,
    constraint user_room_ibfk_1
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

create index `3`
    on user_room (user_id);

create procedure add_gu_memory()
BEGIN
    DECLARE i INT DEFAULT 1;
    SET i = 2;
    WHILE (i <= 60)
        DO
            INSERT into `car`(`name`, `type`, `status`) VALUEs (CONCAT('车位', i), 0, 0);
            set i = i + 1;
        END WHILE;
END;


