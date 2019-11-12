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
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('ff8080816e3a6e7a016e3a6fd08f0000','18','lili','woamn','BeiJing','lili@163.com','131-xxxx-8139');
INSERT INTO `user` VALUES ('ff8080816e3a6e7a016e3a6fd08f0001','23','jingjing','woman','ShangHai','jingjing@163.com','131-xxxx-8133');
INSERT INTO `user` VALUES ('ff8080816e3a6e7a016e3a6fd08f0002','35','liuwen','man','GuangZhou','liuwen@163.com','131-xxxx-8131');
UNLOCK TABLES;
