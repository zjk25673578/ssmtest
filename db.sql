/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-01-20 10:28:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appuser
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
INSERT INTO `appuser` VALUES ('2', 'xiaoming', '小明', '2018-09-01', '1');
INSERT INTO `appuser` VALUES ('3', 'jack', '杰克', '2012-02-11', '1');
INSERT INTO `appuser` VALUES ('4', 'Tom', '汤姆', '2018-09-01', '0');
INSERT INTO `appuser` VALUES ('5', 'lucy', '露西', '2015-01-12', '0');
INSERT INTO `appuser` VALUES ('6', 'hanmeimei', '韩梅梅', '2018-09-01', '1');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `otitle` varchar(50) DEFAULT NULL,
  `content` varchar(150) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('50001', '晚上吃点啥 ?', 'layui（谐音：类UI) 是一款采用自身模块规范编写的前端 UI 框架，遵循原生 HTML/CSS/JS 的书写与组织形式，门槛极低，拿来即用。其外在极简，却又不失饱满的内在，体积轻盈，组件丰盈，从核心代码到 API 的每一处细节都经过精心雕琢，非常适合界面的快速开发。', '2019-01-20 09:24:41');

-- ----------------------------
-- Table structure for attencensus
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
-- Table structure for attendance
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

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
INSERT INTO `attendance` VALUES ('57', '1', '2018', '9', '5', '4', '1');
INSERT INTO `attendance` VALUES ('58', '1', '2018', '9', '5', '2', '1');
INSERT INTO `attendance` VALUES ('59', '1', '2018', '9', '6', '6', '1');
INSERT INTO `attendance` VALUES ('60', '1', '2018', '9', '7', '2', '1');
INSERT INTO `attendance` VALUES ('61', '1', '2018', '9', '14', '4', '1');
INSERT INTO `attendance` VALUES ('62', '5', '2018', '11', '13', '4', '1');
INSERT INTO `attendance` VALUES ('63', '5', '2018', '11', '14', '3', '1');
INSERT INTO `attendance` VALUES ('64', '5', '2018', '11', '15', '1', '1');
INSERT INTO `attendance` VALUES ('65', '5', '2018', '11', '16', '1', '1');
INSERT INTO `attendance` VALUES ('66', '5', '2018', '11', '17', '1', '1');
INSERT INTO `attendance` VALUES ('67', '3', '2018', '11', '1', '2', '1');
INSERT INTO `attendance` VALUES ('68', '3', '2018', '11', '8', '2', '1');
INSERT INTO `attendance` VALUES ('69', '3', '2018', '11', '2', '1', '1');
INSERT INTO `attendance` VALUES ('70', '2', '2019', '5', '8', '3', '1');
INSERT INTO `attendance` VALUES ('71', '2', '2019', '5', '9', '2', '1');
INSERT INTO `attendance` VALUES ('72', '2', '2019', '5', '9', '1', '1');

-- ----------------------------
-- Table structure for attendic
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

-- ----------------------------
-- Table structure for db_columns
-- ----------------------------
DROP TABLE IF EXISTS `db_columns`;
CREATE TABLE `db_columns` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `sche` varchar(50) DEFAULT NULL,
  `tname` varchar(50) DEFAULT NULL,
  `colname` varchar(100) DEFAULT NULL,
  `coltype` varchar(100) DEFAULT NULL,
  `isnull` varchar(10) DEFAULT NULL,
  `clength` varchar(20) DEFAULT NULL,
  `related` varchar(300) DEFAULT NULL,
  `ccomment` varchar(300) DEFAULT NULL,
  `note` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=6223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for db_commons
-- ----------------------------
DROP TABLE IF EXISTS `db_commons`;
CREATE TABLE `db_commons` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `dbtype` varchar(30) DEFAULT NULL,
  `dbname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of db_commons
-- ----------------------------
INSERT INTO `db_commons` VALUES ('3', 'root', '123456', 'localhost', 'mysql', 'stms');
INSERT INTO `db_commons` VALUES ('4', 'root', '123456', 'localhost', 'mysql', 'k_sms');
INSERT INTO `db_commons` VALUES ('5', 'root', '123456', 'localhost', 'mysql', 'myhome');

-- ----------------------------
-- Table structure for db_tables
-- ----------------------------
DROP TABLE IF EXISTS `db_tables`;
CREATE TABLE `db_tables` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `sche` varchar(50) DEFAULT NULL,
  `tname` varchar(100) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `profunc` varchar(300) DEFAULT NULL,
  `tcomment` varchar(300) DEFAULT NULL,
  `related` varchar(300) DEFAULT NULL,
  `note` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=1628 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(50) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `age` tinyint(5) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` float(10,2) DEFAULT NULL,
  `comm` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '王献涵', '0', '18', '2018-11-20', '1200.00', '10');
INSERT INTO `emp` VALUES ('2', '赵剑珂', '1', '32', '2019-07-10', '2100.00', '10');
INSERT INTO `emp` VALUES ('3', '吴彦祖', '1', '20', '2018-11-11', '1300.00', '20');
INSERT INTO `emp` VALUES ('4', '吴彦祖', '1', '20', '2018-12-30', '1300.00', '20');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `art_id` int(11) DEFAULT NULL,
  `reply_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('27', '50001', '50001', '1', 'aaaaaa', '2019-01-20 09:39:47');
INSERT INTO `reply` VALUES ('28', '50001', '50001', '2', '再见', '2019-01-20 09:41:51');
INSERT INTO `reply` VALUES ('29', '50001', '50001', '5', '哈哈哈', '2019-01-20 09:42:04');
INSERT INTO `reply` VALUES ('30', '50001', '29', '6', '晚上一起吃饭吧', '2019-01-20 09:42:17');
INSERT INTO `reply` VALUES ('31', '50001', '30', '4', '可不可以带我一个', '2019-01-20 09:42:36');
INSERT INTO `reply` VALUES ('32', '50001', '31', '1', '你长那么丑, 就算了吧', '2019-01-20 09:42:52');
INSERT INTO `reply` VALUES ('33', '50001', '30', '5', '好啊好啊', '2019-01-20 09:43:16');
INSERT INTO `reply` VALUES ('34', '50001', '50001', '3', '从核心代码到 API 的每一处细节都经过精心雕琢', '2019-01-20 09:43:48');

-- ----------------------------
-- Table structure for sysmenu
-- ----------------------------
DROP TABLE IF EXISTS `sysmenu`;
CREATE TABLE `sysmenu` (
  `ids` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysmenu
-- ----------------------------
INSERT INTO `sysmenu` VALUES ('42', '库存管理', 'fa fa-home', '0', null);
INSERT INTO `sysmenu` VALUES ('43', '客户信息', 'layui-icon-user', '0', null);
INSERT INTO `sysmenu` VALUES ('44', '日程管理', 'layui-icon-date', '0', null);
INSERT INTO `sysmenu` VALUES ('45', '会议管理', 'layui-icon-chat', '0', null);
INSERT INTO `sysmenu` VALUES ('46', '系统设置', null, '0', null);
INSERT INTO `sysmenu` VALUES ('47', '入库记录', 'layui-icon-star', '42', null);
INSERT INTO `sysmenu` VALUES ('48', '出库记录', 'layui-icon-star-fill', '42', null);
INSERT INTO `sysmenu` VALUES ('49', '库存盘点', 'layui-icon-form', '42', null);
INSERT INTO `sysmenu` VALUES ('50', '潜在客户', 'layui-icon-username', '43', null);
INSERT INTO `sysmenu` VALUES ('51', '新增客户', 'layui-icon-add-1', '43', null);
INSERT INTO `sysmenu` VALUES ('52', 'A类客户', null, '43', null);
INSERT INTO `sysmenu` VALUES ('53', 'B类客户', null, '43', null);
INSERT INTO `sysmenu` VALUES ('54', 'C类客户', null, '43', null);
INSERT INTO `sysmenu` VALUES ('55', 'D类客户', null, '43', null);
INSERT INTO `sysmenu` VALUES ('56', '我的日程', 'layui-icon-cellphone', '44', null);
INSERT INTO `sysmenu` VALUES ('57', '日程提醒', 'layui-icon-tips', '44', null);
INSERT INTO `sysmenu` VALUES ('58', '我的会议', 'layui-icon-auz', '45', null);
INSERT INTO `sysmenu` VALUES ('59', '会议提醒', 'layui-icon-reply-fill', '45', null);
INSERT INTO `sysmenu` VALUES ('60', '更换皮肤', 'layui-icon-fonts-clear', '46', null);
INSERT INTO `sysmenu` VALUES ('61', '自动退出时间', 'layui-icon-upload-circle', '46', null);
INSERT INTO `sysmenu` VALUES ('62', '重新登陆', 'layui-icon-face-smile-fine', '46', null);
INSERT INTO `sysmenu` VALUES ('63', '个人中心', 'layui-icon-friends', '46', null);
INSERT INTO `sysmenu` VALUES ('64', '我参加的会议', 'layui-icon-release', '58', null);
INSERT INTO `sysmenu` VALUES ('65', '我发起的会议', 'layui-icon-about', '58', null);
INSERT INTO `sysmenu` VALUES ('66', '更换头像', null, '63', null);
INSERT INTO `sysmenu` VALUES ('67', '密码修改', 'layui-icon-survey', '63', null);
INSERT INTO `sysmenu` VALUES ('82', '本地上传', 'layui-icon-edit', '66', '');
INSERT INTO `sysmenu` VALUES ('83', '网络图片', 'layui-icon-website', '66', null);
