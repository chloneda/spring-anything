DROP TABLE IF EXISTS `user`;

-- 用户表
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

DELETE FROM user;
-- 插入用户数据
INSERT INTO user (id, name, age, sex, password, address, email, phone) VALUES
(1, 'hegel', 18, "man", "123456", "北京", 'hegel@gmail.com', "166xxxx5031"),
(2, 'marx', 36,  "man", "123456", "上海", 'marx@163.com', "166xxxx5033"),
(3, 'allen', 28,  "man", "123456", "广州", 'allen@gmail.com', "166xxxx5036"),
(4, 'jack', 21,  "man", "123456", "北京", 'jack@qq.com', "166xxxx5038"),
(5, 'alice', 23,  "woman", "123456", "广州", 'alice@foxmail.com', "166xxxx5039");

