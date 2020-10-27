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


-- 导出 pro_business 的数据库结构
CREATE DATABASE IF NOT EXISTS `pro_business` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pro_business`;

-- 导出  表 pro_business.pro_business 结构
CREATE TABLE IF NOT EXISTS `pro_business` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商家名称',
  `abbreviation` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商家简称',
  `logo` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商家logo',
  `province` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '省份',
  `city` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '城市',
  `area` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '区',
  `address` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '地址',
  `longitude` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '经度',
  `latitude` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维度',
  `introduce` text COLLATE utf8mb4_unicode_ci COMMENT '介绍',
  `type_id` int(11) NOT NULL DEFAULT '0' COMMENT '类型id',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `imgs` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商家图库',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_del` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家信息表 ';

-- 正在导出表  pro_business.pro_business 的数据：~0 rows (大约)
DELETE FROM `pro_business`;
/*!40000 ALTER TABLE `pro_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_business` ENABLE KEYS */;

-- 导出  表 pro_business.pro_business_audit 结构
CREATE TABLE IF NOT EXISTS `pro_business_audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '审核id',
  `business_id` int(11) NOT NULL DEFAULT '0' COMMENT '商户id',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '法人姓名',
  `id_number` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '法人身份证号',
  `id_number_img` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '法人正面图片',
  `business_license` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '营业执照号码',
  `business_license_img` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '营业执照图片',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '审核状态',
  `message` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核消息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `audit_time` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家审核表 ';

-- 正在导出表  pro_business.pro_business_audit 的数据：~0 rows (大约)
DELETE FROM `pro_business_audit`;
/*!40000 ALTER TABLE `pro_business_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_business_audit` ENABLE KEYS */;

-- 导出  表 pro_business.pro_business_type 结构
CREATE TABLE IF NOT EXISTS `pro_business_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '类型名称',
  `is_del` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家类型 ';

-- 正在导出表  pro_business.pro_business_type 的数据：~0 rows (大约)
DELETE FROM `pro_business_type`;
/*!40000 ALTER TABLE `pro_business_type` DISABLE KEYS */;
INSERT INTO `pro_business_type` (`type_id`, `name`, `is_del`, `create_time`) VALUES
	(2, '123', 1, '2020-10-27 17:16:50'),
	(3, '43444', 1, '2020-10-27 17:23:33'),
	(4, '1234', 1, '2020-10-27 17:49:53');
/*!40000 ALTER TABLE `pro_business_type` ENABLE KEYS */;

-- 导出  表 pro_business.undo_log 结构
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- 正在导出表  pro_business.undo_log 的数据：~0 rows (大约)
DELETE FROM `undo_log`;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
