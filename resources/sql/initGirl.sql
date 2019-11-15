-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
-- Host: localhost    Database: magicboot
-- Server version	5.7.23

DROP TABLE IF EXISTS `girl`;

CREATE TABLE `girl` (
  `id` varchar(64) NOT NULL,
  `age` varchar(54) DEFAULT NULL,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `girl` WRITE;
INSERT INTO `girl` VALUES ('001','18','lili','BeiJing','lili@163.com','131-xxxx-8139');
INSERT INTO `girl` VALUES ('002','23','jingjing','ShangHai','jingjing@163.com','131-xxxx-8133');
INSERT INTO `girl` VALUES ('003','35','liuwen','GuangZhou','liuwen@163.com','131-xxxx-8131');
UNLOCK TABLES;
