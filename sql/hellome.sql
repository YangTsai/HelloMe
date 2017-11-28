/*
Navicat MySQL Data Transfer

Source Server         : 凡卡其
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hellome

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-27 22:55:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6e286ae5965846259e6eee5f35a1f0e3', 'e10adc3949ba59abbe56e057f20f883e', '18710792567', '18710792567', null, null);
INSERT INTO `user` VALUES ('b5c5a92038be4915b74bbb237af0c933', 'e10adc3949ba59abbe56e057f20f883e', '18292922318', '18292922318', null, null);
INSERT INTO `user` VALUES ('d825d14a3d424db582c3ff849a4bb63c', 'e10adc3949ba59abbe56e057f20f883e', '18292922318', '18292922318', null, null);
