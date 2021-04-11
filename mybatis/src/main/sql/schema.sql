DROP TABLE IF EXISTS `user`;

--用户表
CREATE TABLE common.user (
	id varchar(64) NOT NULL,
    name varchar(128) NOT NULL COMMENT '名字',
	age varchar(54) DEFAULT NULL COMMENT '年龄',
	sex varchar(54) DEFAULT NULL COMMENT '性别',
	password varchar(128) DEFAULT NULL COMMENT '密码',
	address varchar(128) DEFAULT NULL COMMENT '住址',
	email varchar(128) DEFAULT NULL COMMENT '邮箱',
	phone varchar(64) DEFAULT NULL COMMENT '电话',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

