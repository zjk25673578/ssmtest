/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001
123123123123123123
Date: 2018-11-06 22:23:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appuser`
-- ----------------------------
DROP TABLE IF EXISTS `appuser`;
CREATE TABLE `appuser` (
  `ids` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `realname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `createtime` date DEFAULT NULL COMMENT '生日',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appuser
-- ----------------------------
INSERT INTO `appuser` VALUES ('1', 'admin', '我不是校草', '2018-09-01', '1');
INSERT INTO `appuser` VALUES ('2', 'xiaoming', '小明', '2018-09-01', '0');
INSERT INTO `appuser` VALUES ('3', 'jack', '杰克', '2012-02-11', '0');
INSERT INTO `appuser` VALUES ('4', 'Tom', '汤姆', '2018-09-01', '0');
INSERT INTO `appuser` VALUES ('5', 'lucy', '露西', '2015-01-12', '0');
INSERT INTO `appuser` VALUES ('6', 'hanmeimei', '韩梅梅', '2018-09-01', '1');

-- ----------------------------
-- Table structure for `attencensus`
-- ----------------------------
DROP TABLE IF EXISTS `attencensus`;
CREATE TABLE `attencensus` (
  `ids` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '关联用户主键',
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `month` int(11) DEFAULT NULL COMMENT '月份',
  `atten` int(11) DEFAULT NULL COMMENT '假勤状态',
  `attentotal` int(11) DEFAULT NULL COMMENT '假勤统计',
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attencensus
-- ----------------------------

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `ids` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(11) DEFAULT NULL COMMENT '关联用户主键',
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `month` int(11) DEFAULT NULL COMMENT '月份',
  `day` int(11) DEFAULT NULL COMMENT '日期',
  `atten` int(11) DEFAULT NULL COMMENT '假勤状态',
  `status` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '1', '2018', '9', '8', '1', '1');
INSERT INTO `attendance` VALUES ('2', '1', '2018', '9', '7', '2', '1');
INSERT INTO `attendance` VALUES ('3', '1', '2018', '9', '8', '5', '1');
INSERT INTO `attendance` VALUES ('4', '1', '2018', '9', '4', '6', '1');
INSERT INTO `attendance` VALUES ('5', '1', '2018', '9', '2', '1', '1');
INSERT INTO `attendance` VALUES ('6', '1', '2018', '9', '3', '6', '1');
INSERT INTO `attendance` VALUES ('7', '1', '2018', '9', '25', '5', '1');
INSERT INTO `attendance` VALUES ('8', '1', '2018', '9', '21', '3', '1');
INSERT INTO `attendance` VALUES ('9', '1', '2018', '9', '14', '5', '1');
INSERT INTO `attendance` VALUES ('10', '1', '2018', '9', '30', '7', '1');
INSERT INTO `attendance` VALUES ('11', '1', '2018', '9', '1', '7', '1');
INSERT INTO `attendance` VALUES ('12', '1', '2018', '9', '1', '1', '1');
INSERT INTO `attendance` VALUES ('13', '1', '2018', '9', '1', '5', '1');
INSERT INTO `attendance` VALUES ('14', '1', '2018', '9', '11', '7', '1');
INSERT INTO `attendance` VALUES ('15', '1', '2018', '9', '12', '4', '1');
INSERT INTO `attendance` VALUES ('16', '1', '2018', '9', '12', '3', '1');
INSERT INTO `attendance` VALUES ('17', '1', '2018', '9', '12', '2', '1');
INSERT INTO `attendance` VALUES ('18', '1', '2018', '9', '12', '1', '1');
INSERT INTO `attendance` VALUES ('19', '1', '2018', '9', '12', '7', '1');
INSERT INTO `attendance` VALUES ('20', '1', '2018', '9', '13', '3', '1');
INSERT INTO `attendance` VALUES ('21', '1', '2018', '9', '13', '4', '1');
INSERT INTO `attendance` VALUES ('22', '1', '2018', '9', '13', '7', '1');
INSERT INTO `attendance` VALUES ('23', '1', '2018', '9', '27', '7', '1');
INSERT INTO `attendance` VALUES ('24', '1', '2018', '9', '28', '7', '1');
INSERT INTO `attendance` VALUES ('25', '1', '2018', '9', '29', '7', '1');
INSERT INTO `attendance` VALUES ('26', '1', '2018', '9', '26', '7', '1');
INSERT INTO `attendance` VALUES ('27', '1', '2018', '9', '24', '7', '1');
INSERT INTO `attendance` VALUES ('28', '1', '2018', '9', '23', '7', '1');
INSERT INTO `attendance` VALUES ('29', '1', '2018', '9', '16', '7', '1');
INSERT INTO `attendance` VALUES ('30', '1', '2018', '9', '9', '7', '1');
INSERT INTO `attendance` VALUES ('31', '1', '2018', '9', '10', '7', '1');
INSERT INTO `attendance` VALUES ('32', '1', '2018', '9', '5', '7', '1');
INSERT INTO `attendance` VALUES ('33', '1', '2018', '9', '6', '7', '1');
INSERT INTO `attendance` VALUES ('34', '1', '2018', '9', '15', '7', '1');
INSERT INTO `attendance` VALUES ('35', '1', '2018', '9', '22', '7', '1');
INSERT INTO `attendance` VALUES ('36', '1', '2018', '9', '17', '7', '1');
INSERT INTO `attendance` VALUES ('37', '1', '2018', '9', '18', '7', '1');
INSERT INTO `attendance` VALUES ('38', '1', '2018', '9', '19', '7', '1');
INSERT INTO `attendance` VALUES ('39', '1', '2018', '9', '20', '7', '1');
INSERT INTO `attendance` VALUES ('40', '1', '2018', '10', '3', '3', '1');
INSERT INTO `attendance` VALUES ('41', '1', '2018', '10', '4', '6', '1');
INSERT INTO `attendance` VALUES ('42', '1', '2018', '10', '4', '1', '1');
INSERT INTO `attendance` VALUES ('43', '1', '2018', '10', '4', '5', '1');
INSERT INTO `attendance` VALUES ('44', '1', '2018', '10', '4', '6', '1');
INSERT INTO `attendance` VALUES ('45', '1', '2018', '10', '3', '5', '1');
INSERT INTO `attendance` VALUES ('46', '1', '2018', '10', '3', '7', '1');
INSERT INTO `attendance` VALUES ('47', '1', '2018', '11', '1', '5', '1');
INSERT INTO `attendance` VALUES ('48', '1', '2018', '11', '1', '1', '1');
INSERT INTO `attendance` VALUES ('49', '1', '2018', '11', '1', '5', '1');
INSERT INTO `attendance` VALUES ('50', '1', '2018', '12', '13', '5', '1');
INSERT INTO `attendance` VALUES ('51', '1', '2018', '12', '12', '1', '1');
INSERT INTO `attendance` VALUES ('52', '1', '2018', '12', '11', '5', '1');
INSERT INTO `attendance` VALUES ('53', '1', '2018', '12', '10', '5', '1');
INSERT INTO `attendance` VALUES ('54', '1', '2018', '12', '9', '4', '1');
INSERT INTO `attendance` VALUES ('55', '1', '2018', '12', '14', '3', '1');
INSERT INTO `attendance` VALUES ('56', '1', '2018', '12', '15', '2', '1');

-- ----------------------------
-- Table structure for `attendic`
-- ----------------------------
DROP TABLE IF EXISTS `attendic`;
CREATE TABLE `attendic` (
  `ids` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attencode` varchar(50) DEFAULT NULL COMMENT '假勤状态代码',
  `attenname` varchar(50) DEFAULT NULL COMMENT '假勤状态名称',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendic
-- ----------------------------
INSERT INTO `attendic` VALUES ('1', '1', '迟到');
INSERT INTO `attendic` VALUES ('2', '2', '早退');
INSERT INTO `attendic` VALUES ('3', '3', '旷工');
INSERT INTO `attendic` VALUES ('4', '4', '事假');
INSERT INTO `attendic` VALUES ('5', '5', '加班');
INSERT INTO `attendic` VALUES ('6', '6', '病假');
INSERT INTO `attendic` VALUES ('7', '7', '上班');
