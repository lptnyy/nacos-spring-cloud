-- --------------------------------------------------------
-- 主机:                           192.168.1.144
-- 服务器版本:                        5.7.27-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 pro_member 的数据库结构
CREATE DATABASE IF NOT EXISTS `pro_member` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pro_member`;

-- 导出  表 pro_member.pro_level 结构
CREATE TABLE IF NOT EXISTS `pro_level` (
  `level_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级id',
  `level_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '等级名称',
  `image` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '展示图片',
  `integral` int(11) NOT NULL DEFAULT '0' COMMENT '等级积分',
  `price` decimal(32,2) NOT NULL DEFAULT '0.00' COMMENT '等级价格',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员等级 会员等级';

-- 正在导出表  pro_member.pro_level 的数据：~1 rows (大约)
DELETE FROM `pro_level`;
/*!40000 ALTER TABLE `pro_level` DISABLE KEYS */;
INSERT INTO `pro_level` (`level_id`, `level_name`, `image`, `integral`, `price`, `create_time`) VALUES
	(2, '普通会员', 'jpg/2020101716154170110.jpg', 0, 0.00, '2020-10-17 16:17:49');
/*!40000 ALTER TABLE `pro_level` ENABLE KEYS */;

-- 导出  表 pro_member.pro_member 结构
CREATE TABLE IF NOT EXISTS `pro_member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_no` varchar(32) NOT NULL COMMENT '会员号',
  `nick_name` varchar(128) NOT NULL COMMENT '会员昵称',
  `user_name` varchar(32) NOT NULL COMMENT '会员账号',
  `pass_word` varchar(32) NOT NULL COMMENT '会员密码',
  `head_portrait` varchar(128) NOT NULL COMMENT '会员头像',
  `ntroduction` varchar(128) NOT NULL COMMENT '会员简介',
  `sex` varchar(32) NOT NULL COMMENT '性别',
  `age` varchar(32) NOT NULL COMMENT '年龄',
  `province` varchar(32) NOT NULL COMMENT '省份',
  `city` varchar(32) NOT NULL COMMENT '城市',
  `area` varchar(32) NOT NULL COMMENT '区',
  `school` varchar(32) NOT NULL COMMENT '学校',
  `level_Id` int(11) NOT NULL DEFAULT '1' COMMENT '会员等级',
  `state` varchar(32) NOT NULL COMMENT '会员状态',
  `pay_password` varchar(32) NOT NULL DEFAULT '123456' COMMENT '充值密码',
  `withdrawal_password` varchar(32) NOT NULL DEFAULT '123456' COMMENT '提现密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='普通会员';

-- 正在导出表  pro_member.pro_member 的数据：~1 rows (大约)
DELETE FROM `pro_member`;
/*!40000 ALTER TABLE `pro_member` DISABLE KEYS */;
INSERT INTO `pro_member` (`member_id`, `member_no`, `nick_name`, `user_name`, `pass_word`, `head_portrait`, `ntroduction`, `sex`, `age`, `province`, `city`, `area`, `school`, `level_Id`, `state`, `pay_password`, `withdrawal_password`, `create_time`, `update_time`) VALUES
	(5, '123', '123', '123', '123', 'jpg/2020101716154170110.jpg', '123', 'girl', '12', '120000', '120100', '120104', '123123', 2, 'normal', '123123', '123', '2020-10-17 16:43:35', '2020-10-17 17:26:03');
/*!40000 ALTER TABLE `pro_member` ENABLE KEYS */;

-- 导出  表 pro_member.pro_merchant 结构
CREATE TABLE IF NOT EXISTS `pro_merchant` (
  `merchant_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标示列',
  `abbreviation` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '企业简称',
  `user_name` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '账号',
  `pass_word` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `logo_url` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'logo图片',
  `name` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '企业全名',
  `qualification` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '商户资质材料',
  `margin` decimal(32,2) NOT NULL DEFAULT '0.00' COMMENT '保证金额',
  `collect_money` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '收款账号',
  `tel` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '固定电话',
  `phone` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '邮箱',
  `province` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '省份',
  `city` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '城市',
  `area` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '地区',
  `address` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '详细地址',
  `qq` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT 'qq号码',
  `home_url` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '企业官网',
  `stat` int(11) NOT NULL DEFAULT '0' COMMENT '状态(枚举表 enterprise_stat)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商户表 ';

-- 正在导出表  pro_member.pro_merchant 的数据：~0 rows (大约)
DELETE FROM `pro_merchant`;
/*!40000 ALTER TABLE `pro_merchant` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_merchant` ENABLE KEYS */;

-- 导出  表 pro_member.undo_log 结构
CREATE TABLE IF NOT EXISTS `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- 正在导出表  pro_member.undo_log 的数据：~0 rows (大约)
DELETE FROM `undo_log`;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
