/*
Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2019-01-04 16:06:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `username` varchar(100) COLLATE utf8_bin NOT NULL,
  `passwd` varchar(50) COLLATE utf8_bin NOT NULL,
  `realname` varchar(20) COLLATE utf8_bin NOT NULL,
  `admintype` tinyint(2) NOT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('11111', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', '1', '2019-01-04 16:06:33');
