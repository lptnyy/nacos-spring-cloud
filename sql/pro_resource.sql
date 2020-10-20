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


-- 导出 pro_resource 的数据库结构
CREATE DATABASE IF NOT EXISTS `pro_resource` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pro_resource`;

-- 导出  表 pro_resource.pro_resource_file 结构
CREATE TABLE IF NOT EXISTS `pro_resource_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `file_name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件名称',
  `physics_path` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物理地址',
  `path` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '相对路径',
  `md5` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文件指纹',
  `file_size` int(11) DEFAULT NULL COMMENT '文件大小',
  `file_dns` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问域名',
  `type` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类型',
  `suffix` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源后缀',
  `source_type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '储存源',
  `upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统资源文件表 ';

-- 正在导出表  pro_resource.pro_resource_file 的数据：~1 rows (大约)
DELETE FROM `pro_resource_file`;
/*!40000 ALTER TABLE `pro_resource_file` DISABLE KEYS */;
INSERT INTO `pro_resource_file` (`file_id`, `file_name`, `physics_path`, `path`, `md5`, `file_size`, `file_dns`, `type`, `suffix`, `source_type`, `upload_time`) VALUES
	(24, 'timg.jpg', NULL, 'jpg/2020101716533624632.jpg', '49ed9e211e05c352e03877aca42c7174', 17353, 'https://wzytestfile.s3-cn-south-1.qiniucs.com/', 'image', 'jpg', 'qiniu', '2020-10-17 16:53:27');
/*!40000 ALTER TABLE `pro_resource_file` ENABLE KEYS */;

-- 导出  表 pro_resource.undo_log 结构
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
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- 正在导出表  pro_resource.undo_log 的数据：~0 rows (大约)
DELETE FROM `undo_log`;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
