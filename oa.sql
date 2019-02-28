/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : oa

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 17/02/2019 22:07:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oa_application
-- ----------------------------
DROP TABLE IF EXISTS `oa_application`;
CREATE TABLE `oa_application`  (
  `application_id` int(4) NOT NULL AUTO_INCREMENT,
  `application_title` varchar(50) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  `application_date` datetime NOT NULL,
  `application_status` varchar(10) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  `application_document_path` varchar(100) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  `applicant_id` int(4) NULL DEFAULT NULL COMMENT '申请人',
  `template_id` int(4) NULL DEFAULT NULL COMMENT '所属模板',
  PRIMARY KEY (`application_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = big5 COLLATE = big5_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for oa_approve_info
-- ----------------------------
DROP TABLE IF EXISTS `oa_approve_info`;
CREATE TABLE `oa_approve_info`  (
  `approve_info_id` int(4) NOT NULL AUTO_INCREMENT,
  `approve_date` datetime NULL DEFAULT NULL,
  `approve_status` varchar(10) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  `approve_comment` varchar(100) CHARACTER SET big5 COLLATE big5_bin NULL DEFAULT NULL,
  `approver_id` int(4) NULL DEFAULT NULL COMMENT '审批人',
  `application_id` int(4) NULL DEFAULT NULL COMMENT '所属的申请',
  PRIMARY KEY (`approve_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = big5 COLLATE = big5_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for oa_department
-- ----------------------------
DROP TABLE IF EXISTS `oa_department`;
CREATE TABLE `oa_department`  (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `department_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `department_level` int(11) NOT NULL,
  PRIMARY KEY (`department_id`) USING BTREE,
  INDEX `FK_qdcw4c2soeg8jkbyw2f4ssbm3`(`parent_id`) USING BTREE,
  CONSTRAINT `FK_qdcw4c2soeg8jkbyw2f4ssbm3` FOREIGN KEY (`parent_id`) REFERENCES `oa_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_department
-- ----------------------------
INSERT INTO `oa_department` VALUES (1, '总经理室', '总经理室', NULL, 1);
INSERT INTO `oa_department` VALUES (2, '市场部', '市场部', NULL, 1);
INSERT INTO `oa_department` VALUES (3, 'OA产品部', 'OA产品部', NULL, 1);
INSERT INTO `oa_department` VALUES (4, '售服部', '售服部', NULL, 1);
INSERT INTO `oa_department` VALUES (6, 'IBM', 'IBM', 4, 2);
INSERT INTO `oa_department` VALUES (7, 'abc', 'abc', 6, 3);

-- ----------------------------
-- Table structure for oa_privilege
-- ----------------------------
DROP TABLE IF EXISTS `oa_privilege`;
CREATE TABLE `oa_privilege`  (
  `privilege_id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `privilege_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `privilege_level` int(11) NOT NULL,
  `privilege_is_leaf` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `privilege_is_module` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `privilege_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`privilege_id`) USING BTREE,
  INDEX `FK_4dt1cid3kaixsfa8v35vbgr11`(`parent_id`) USING BTREE,
  CONSTRAINT `FK_4dt1cid3kaixsfa8v35vbgr11` FOREIGN KEY (`parent_id`) REFERENCES `oa_privilege` (`privilege_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_privilege
-- ----------------------------
INSERT INTO `oa_privilege` VALUES (1, '系统管理', '/oa', 1, 'N', 'Y', NULL, '');
INSERT INTO `oa_privilege` VALUES (2, '审批流转', '/approve', 1, 'N', 'Y', NULL, '');
INSERT INTO `oa_privilege` VALUES (3, '实用工具', '/util', 1, 'N', 'Y', NULL, '');
INSERT INTO `oa_privilege` VALUES (4, '部门管理', '/system/deparmentAction_list.action', 2, 'N', 'Y', 1, 'department:list');
INSERT INTO `oa_privilege` VALUES (5, '角色管理', '/system/roleAction_list.action', 2, 'N', 'Y', 1, 'role:list');
INSERT INTO `oa_privilege` VALUES (6, '用户管理', '/system/userAction_list.action', 2, 'N', 'Y', 1, 'user:list');
INSERT INTO `oa_privilege` VALUES (7, '部门列表', '/system/deparmentAction_list.action', 3, 'Y', 'N', 4, 'department:list');
INSERT INTO `oa_privilege` VALUES (8, '部门添加跳转', '/system/deparmentAction_saveUI.action', 3, 'Y', 'N', 4, 'departemnt:saveUI');
INSERT INTO `oa_privilege` VALUES (9, '部门添加', '/system/deparmentAction_save.action', 3, 'Y', 'N', 4, 'department:save');
INSERT INTO `oa_privilege` VALUES (10, '部门删除', '/system/deparmentAction_delete.action', 3, 'Y', 'N', 4, 'department:delete');
INSERT INTO `oa_privilege` VALUES (11, '部门更新跳转', '/system/deparmentAction_updateUI.action', 3, 'Y', 'N', 4, 'department:updateUI');
INSERT INTO `oa_privilege` VALUES (12, '部门更新', '/system/deparmentAction_update.action', 3, 'Y', 'N', 4, 'department:update');
INSERT INTO `oa_privilege` VALUES (13, '角色列表', '/system/roleAction_list.action', 3, 'Y', 'N', 5, 'role:list');
INSERT INTO `oa_privilege` VALUES (14, '角色授权跳转', '/system/roleAction_setPrivilegeUI.action', 3, 'Y', 'N', 5, 'role:setPrivilegeUI');
INSERT INTO `oa_privilege` VALUES (15, '角色授权', '/system/roleAction_setPrivilege.action', 3, 'Y', 'N', 5, 'role:setPrivilege');

-- ----------------------------
-- Table structure for oa_role
-- ----------------------------
DROP TABLE IF EXISTS `oa_role`;
CREATE TABLE `oa_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role_description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_role
-- ----------------------------
INSERT INTO `oa_role` VALUES (1, '档案管理员', '档案管理员');
INSERT INTO `oa_role` VALUES (2, '系统管理员', '系统管理员');
INSERT INTO `oa_role` VALUES (3, '部门经理', '部门经理');
INSERT INTO `oa_role` VALUES (4, '副总经理', '副总经理');
INSERT INTO `oa_role` VALUES (5, '财务经理', '财务经理');
INSERT INTO `oa_role` VALUES (6, '总经理', '总经理');

-- ----------------------------
-- Table structure for oa_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `oa_role_privilege`;
CREATE TABLE `oa_role_privilege`  (
  `role_privilege_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `privilege_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`role_privilege_id`) USING BTREE,
  INDEX `FK_shhs68dsh3yxfmsmh6oo2ay6t`(`role_id`) USING BTREE,
  INDEX `FK_amf4pt45pmuj8xhs9t82x3eyp`(`privilege_id`) USING BTREE,
  CONSTRAINT `FK_amf4pt45pmuj8xhs9t82x3eyp` FOREIGN KEY (`privilege_id`) REFERENCES `oa_privilege` (`privilege_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_shhs68dsh3yxfmsmh6oo2ay6t` FOREIGN KEY (`role_id`) REFERENCES `oa_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_role_privilege
-- ----------------------------
INSERT INTO `oa_role_privilege` VALUES (1, 1, 1);
INSERT INTO `oa_role_privilege` VALUES (2, 1, 2);
INSERT INTO `oa_role_privilege` VALUES (3, 1, 3);
INSERT INTO `oa_role_privilege` VALUES (4, 1, 4);
INSERT INTO `oa_role_privilege` VALUES (5, 1, 5);
INSERT INTO `oa_role_privilege` VALUES (13, 2, 3);
INSERT INTO `oa_role_privilege` VALUES (29, 2, 1);
INSERT INTO `oa_role_privilege` VALUES (30, 2, 4);
INSERT INTO `oa_role_privilege` VALUES (31, 2, 10);
INSERT INTO `oa_role_privilege` VALUES (134, 5, 1);
INSERT INTO `oa_role_privilege` VALUES (135, 5, 4);
INSERT INTO `oa_role_privilege` VALUES (136, 5, 10);
INSERT INTO `oa_role_privilege` VALUES (137, 5, 9);
INSERT INTO `oa_role_privilege` VALUES (138, 5, 7);
INSERT INTO `oa_role_privilege` VALUES (139, 5, 6);
INSERT INTO `oa_role_privilege` VALUES (140, 5, 2);
INSERT INTO `oa_role_privilege` VALUES (141, 5, 3);

-- ----------------------------
-- Table structure for oa_template
-- ----------------------------
DROP TABLE IF EXISTS `oa_template`;
CREATE TABLE `oa_template`  (
  `template_id` int(4) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(50) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  `process_definition_key` varchar(50) CHARACTER SET big5 COLLATE big5_bin NOT NULL COMMENT '流程定义的key',
  `template_document_path` varchar(100) CHARACTER SET big5 COLLATE big5_bin NOT NULL,
  PRIMARY KEY (`template_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = big5 COLLATE = big5_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for oa_user
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_password` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  `user_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `FK_adevlieviuai0k1lvqsj5y2um`(`department_id`) USING BTREE,
  CONSTRAINT `FK_adevlieviuai0k1lvqsj5y2um` FOREIGN KEY (`department_id`) REFERENCES `oa_department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_user
-- ----------------------------
INSERT INTO `oa_user` VALUES (1, 'zhangsan', 'admin', 'zhangsan', 'M', 'zhangsan@163.com', 'zhangsan', 4, '7777');
INSERT INTO `oa_user` VALUES (2, 'lisi', 'admin', 'lisi', 'F', 'lisi@163.com', 'lisi', 3, '8888');
INSERT INTO `oa_user` VALUES (3, 'wangwu', 'admin', 'wangwu', 'M', 'wangwu@163.com', 'wangwu', 2, '9999');
INSERT INTO `oa_user` VALUES (4, 'abc', '1234', 'abc', '男', 'abc@1643.com', 'abc', 6, '4444');
INSERT INTO `oa_user` VALUES (6, 'ccc', '1234', 'ccc', '男', 'bbb@163.com', 'ccc', 1, '2222');

-- ----------------------------
-- Table structure for oa_user_role
-- ----------------------------
DROP TABLE IF EXISTS `oa_user_role`;
CREATE TABLE `oa_user_role`  (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `FK_endwy9uw1m8u7slf0ggss43c9`(`user_id`) USING BTREE,
  INDEX `FK_g06ju0x61mp0pl38duvw575s`(`role_id`) USING BTREE,
  CONSTRAINT `FK_endwy9uw1m8u7slf0ggss43c9` FOREIGN KEY (`user_id`) REFERENCES `oa_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_g06ju0x61mp0pl38duvw575s` FOREIGN KEY (`role_id`) REFERENCES `oa_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oa_user_role
-- ----------------------------
INSERT INTO `oa_user_role` VALUES (1, 1, 1);
INSERT INTO `oa_user_role` VALUES (2, 1, 2);
INSERT INTO `oa_user_role` VALUES (3, 1, 4);
INSERT INTO `oa_user_role` VALUES (6, 2, 2);
INSERT INTO `oa_user_role` VALUES (7, 3, 2);
INSERT INTO `oa_user_role` VALUES (8, 3, 4);
INSERT INTO `oa_user_role` VALUES (9, 4, 3);
INSERT INTO `oa_user_role` VALUES (10, 4, 4);
INSERT INTO `oa_user_role` VALUES (11, 4, 6);
INSERT INTO `oa_user_role` VALUES (28, 6, 1);
INSERT INTO `oa_user_role` VALUES (29, 6, 6);

SET FOREIGN_KEY_CHECKS = 1;
