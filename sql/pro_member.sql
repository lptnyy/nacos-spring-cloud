/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pro_member

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 12/10/2020 22:27:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_member
-- ----------------------------
DROP TABLE IF EXISTS `pro_member`;
CREATE TABLE "pro_member" (
  "member_id" bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  "member_no" varchar(32) NOT NULL COMMENT '会员号',
  "nick_name" varchar(128) NOT NULL COMMENT '会员昵称',
  "user_name" varchar(32) NOT NULL COMMENT '会员账号',
  "pass_word" varchar(32) NOT NULL COMMENT '会员密码',
  "head_portrait" varchar(128) NOT NULL COMMENT '会员头像',
  "ntroduction" varchar(128) NOT NULL COMMENT '会员简介',
  "sex" varchar(32) NOT NULL COMMENT '性别',
  "age" varchar(32) NOT NULL COMMENT '年龄',
  "province" varchar(32) NOT NULL COMMENT '省份',
  "city" varchar(32) NOT NULL COMMENT '城市',
  "area" varchar(32) NOT NULL COMMENT '区',
  "school" varchar(32) NOT NULL COMMENT '学校',
  "level_Id" int(11) NOT NULL DEFAULT '1' COMMENT '会员等级',
  "state" varchar(32) NOT NULL COMMENT '会员状态',
  "pay_password" varchar(32) NOT NULL DEFAULT '123456' COMMENT '充值密码',
  "withdrawal_password" varchar(32) NOT NULL DEFAULT '123456' COMMENT '提现密码',
  "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY ("member_id")
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='会员表 会员';

-- ----------------------------
-- Records of pro_member
-- ----------------------------
BEGIN;
INSERT INTO `pro_member` VALUES (4, '123', '123', '123', '123', 'jpg/2020100712133729801.jpg', '123', 'girl', '123', '123', '123', '123', '123', 123, 'normal', '123', '123', '2020-10-10 23:26:23', '2020-10-10 23:26:38');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE "undo_log" (
  "id" bigint(20) NOT NULL AUTO_INCREMENT,
  "branch_id" bigint(20) NOT NULL,
  "xid" varchar(100) NOT NULL,
  "context" varchar(128) NOT NULL,
  "rollback_info" longblob NOT NULL,
  "log_status" int(11) NOT NULL,
  "log_created" datetime NOT NULL,
  "log_modified" datetime NOT NULL,
  "ext" varchar(100) DEFAULT NULL,
  PRIMARY KEY ("id"),
  UNIQUE KEY "ux_undo_log" ("xid","branch_id")
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
