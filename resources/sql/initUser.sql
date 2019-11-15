-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
-- Host: localhost    Database: magicboot
-- Server version	5.7.23

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `p_id` varchar(64) NOT NULL,
  `p_age` varchar(54) DEFAULT NULL,
  `p_name` varchar(128) NOT NULL,
  `p_sex` varchar(54) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('001','18','lili','woamn','BeiJing','123456','lili@163.com','131-xxxx-8139');
INSERT INTO `user` VALUES ('002','23','jingjing','woman','ShangHai','123456','jingjing@163.com','131-xxxx-8133');
INSERT INTO `user` VALUES ('003','35','liuwen','man','GuangZhou','123456','liuwen@163.com','131-xxxx-8131');
UNLOCK TABLES;
