/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-04-16 13:36:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '权限表(主键id)',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `descritpion` varchar(255) NOT NULL COMMENT '权限描述',
  `url` varchar(255) NOT NULL COMMENT '拥有权限url(授权链接)',
  `pid` int(20) DEFAULT NULL COMMENT '父节点id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'Home', '/', null);
INSERT INTO `sys_permission` VALUES ('2', 'ROLE_ADMIN', 'Admin', '/admin', null);

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色权限中间表(主键id)',
  `role_id` int(20) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2');
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表(主键id)',
  `name` varchar(255) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表(主键id)',
  `Sys_User_id` int(11) DEFAULT NULL COMMENT '用户id',
  `Sys_Role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表(主键id)',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'abel', 'abel');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'W', '香菇', '15186866868');
INSERT INTO `user` VALUES ('2', 'W', '木耳', '15168688686');
INSERT INTO `user` VALUES ('3', 'M', '红枣', '17368688686');
