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


-- 导出 pro_product 的数据库结构
CREATE DATABASE IF NOT EXISTS `pro_product` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pro_product`;

-- 导出  表 pro_product.pro_product 结构
CREATE TABLE IF NOT EXISTS `pro_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `enterprise_id` int(11) NOT NULL DEFAULT '0' COMMENT '企业id',
  `type_id` int(11) NOT NULL DEFAULT '0' COMMENT '分类id',
  `title` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `subtitle` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '子标题',
  `image` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '列表展示图片',
  `fabulous_num` int(11) NOT NULL DEFAULT '0' COMMENT '赞数',
  `comment_num` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `sales_num` int(11) NOT NULL DEFAULT '0' COMMENT '销售数量',
  `share_num` int(11) NOT NULL DEFAULT '0' COMMENT '分享数',
  `discount_sts` int(11) NOT NULL DEFAULT '0' COMMENT '是否会员打折',
  `integral_sts` int(11) NOT NULL DEFAULT '0' COMMENT '是否积分兑换',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '产品状态',
  `freight_id` int(11) NOT NULL DEFAULT '0' COMMENT '运费方式',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品管理';

-- 正在导出表  pro_product.pro_product 的数据：~0 rows (大约)
DELETE FROM `pro_product`;
/*!40000 ALTER TABLE `pro_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_product` ENABLE KEYS */;

-- 导出  表 pro_product.pro_product_info 结构
CREATE TABLE IF NOT EXISTS `pro_product_info` (
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `imgs` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图库',
  `introduce` text COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品介绍',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品详情 ';

-- 正在导出表  pro_product.pro_product_info 的数据：~0 rows (大约)
DELETE FROM `pro_product_info`;
/*!40000 ALTER TABLE `pro_product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_product_info` ENABLE KEYS */;

-- 导出  表 pro_product.pro_product_type 结构
CREATE TABLE IF NOT EXISTS `pro_product_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `列 6` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '分类名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图标地址',
  `enterprise_id` int(11) NOT NULL DEFAULT '0' COMMENT '企业id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='产品分类 ';

-- 正在导出表  pro_product.pro_product_type 的数据：~2 rows (大约)
DELETE FROM `pro_product_type`;
/*!40000 ALTER TABLE `pro_product_type` DISABLE KEYS */;
INSERT INTO `pro_product_type` (`type_id`, `列 6`, `name`, `sort`, `parent_id`, `icon`, `enterprise_id`, `create_time`) VALUES
	(16, '', '产品分类', 1, 0, 'jpg/2020101716533624632.jpg', 0, '2020-10-20 15:36:16'),
	(17, '', '电子产品', 1, 16, 'jpg/2020101716533624632.jpg', 0, '2020-10-20 15:42:22');
/*!40000 ALTER TABLE `pro_product_type` ENABLE KEYS */;

-- 导出  表 pro_product.undo_log 结构
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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- 正在导出表  pro_product.undo_log 的数据：~0 rows (大约)
DELETE FROM `undo_log`;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
