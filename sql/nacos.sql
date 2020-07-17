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


-- 导出 pro_user 的数据库结构
DROP DATABASE IF EXISTS `pro_user`;
CREATE DATABASE IF NOT EXISTS `pro_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `pro_user`;

-- 导出  表 pro_user.pro_enum 结构
DROP TABLE IF EXISTS `pro_enum`;
CREATE TABLE IF NOT EXISTS `pro_enum` (
  `enum_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '枚举id',
  `keyStr` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'key',
  `valueStr` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'value',
  `type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'type',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',
  PRIMARY KEY (`enum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='枚举表 ';

-- 正在导出表  pro_user.pro_enum 的数据：~9 rows (大约)
DELETE FROM `pro_enum`;
/*!40000 ALTER TABLE `pro_enum` DISABLE KEYS */;
INSERT INTO `pro_enum` (`enum_id`, `keyStr`, `valueStr`, `type`, `create_time`) VALUES
	(1, 'image', '图片', 'oss', '2020-05-03 23:08:26'),
	(2, 'video', '视频', 'oss', '2020-05-03 23:08:59'),
	(3, 'audio', '音乐', 'oss', '2020-05-03 23:09:16'),
	(4, 'file', '文件', 'oss', '2020-05-03 23:09:26'),
	(5, 'default', '默认', 'oss', '2020-05-04 21:12:55'),
	(6, '根目录', '0', 'menu', '2020-05-10 13:29:14'),
	(7, '子页面', '1', 'menu', '2020-05-10 13:30:12'),
	(8, '功能', '2', 'menu', '2020-05-10 13:30:29'),
	(9, '链接', '3', 'menu', '2020-05-10 13:30:44');
/*!40000 ALTER TABLE `pro_enum` ENABLE KEYS */;

-- 导出  表 pro_user.pro_generator 结构
DROP TABLE IF EXISTS `pro_generator`;
CREATE TABLE IF NOT EXISTS `pro_generator` (
  `gen_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `mysql` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库地址',
  `api_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'api参数包名',
  `controller_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Controller包名',
  `vo_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Vo包名',
  `service_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Service接口包名',
  `service_impl_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Service实现包名',
  `mapper_pkg` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Mapper包名',
  `dto_pgk` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Dto包名',
  `mysql_user` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库账号',
  `mysql_pass` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库密码',
  `table_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库表名称',
  `feign_client_service` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Feign服务名',
  `gate_way_path` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网关访问根目录',
  `log_source_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志来源名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `mysql_dev` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'mysql驱动',
  PRIMARY KEY (`gen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='代码生成表';

-- 正在导出表  pro_user.pro_generator 的数据：~0 rows (大约)
DELETE FROM `pro_generator`;
/*!40000 ALTER TABLE `pro_generator` DISABLE KEYS */;
INSERT INTO `pro_generator` (`gen_id`, `mysql`, `api_pkg`, `controller_pkg`, `vo_pkg`, `service_pkg`, `service_impl_pkg`, `mapper_pkg`, `dto_pgk`, `mysql_user`, `mysql_pass`, `table_name`, `feign_client_service`, `gate_way_path`, `log_source_name`, `create_time`, `mysql_dev`) VALUES
	(6, 'jdbc:mysql://192.168.1.144:3306/xiaoshuo', 'com.nacos.xiaoshuo.request', 'com.nacos.xiaoshuo.controller', 'com.nacos.xiaoshuo.vo', 'com.nacos.xiaoshuo', 'com.nacos.xiaoshuo.service', 'com.nacos.xiaoshuo.mapper', 'com.nacos.xiaoshuo.dto', 'root', '123456', NULL, 'xiaoshuo-service', '/xiaoshuo', 'xiaoshuo-app', '2020-07-15 17:21:00', 'com.mysql.cj.jdbc.Driver');
/*!40000 ALTER TABLE `pro_generator` ENABLE KEYS */;

-- 导出  表 pro_user.pro_log 结构
DROP TABLE IF EXISTS `pro_log`;
CREATE TABLE IF NOT EXISTS `pro_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志名称',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志内容',
  `class_name` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '函数类',
  `function_name` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '函数名',
  `run_time` float DEFAULT NULL COMMENT '执行时间ms',
  `source` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志来源',
  `body` text COLLATE utf8mb4_unicode_ci COMMENT '参数内容',
  `return_body` text COLLATE utf8mb4_unicode_ci COMMENT '反馈数据',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='操作日志';

-- 正在导出表  pro_user.pro_log 的数据：~0 rows (大约)
DELETE FROM `pro_log`;
/*!40000 ALTER TABLE `pro_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_log` ENABLE KEYS */;

-- 导出  表 pro_user.pro_menu 结构
DROP TABLE IF EXISTS `pro_menu`;
CREATE TABLE IF NOT EXISTS `pro_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `url` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '访问地址',
  `icon` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `path` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '物理地址',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `type` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '类型',
  `jurisdiction` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建事件',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单表 ';

-- 正在导出表  pro_user.pro_menu 的数据：~43 rows (大约)
DELETE FROM `pro_menu`;
/*!40000 ALTER TABLE `pro_menu` DISABLE KEYS */;
INSERT INTO `pro_menu` (`menu_id`, `name`, `url`, `icon`, `path`, `parent_id`, `type`, `jurisdiction`, `create_time`, `title`) VALUES
	(55, 'system', NULL, 'ios-settings', 'Main', 0, '0', NULL, '2020-04-13 23:37:43', '系统管理'),
	(56, 'generator', NULL, 'ios-settings', '/pro/gen/index', 86, '1', NULL, '2020-04-13 23:39:12', '代码生成器'),
	(57, 'role', NULL, 'ios-settings', '/pro/system/role/index', 55, '1', NULL, '2020-04-16 00:18:24', '角色管理'),
	(58, 'user', NULL, 'ios-settings', '/pro/system/user/index', 55, '1', NULL, '2020-04-16 00:45:42', '管理员管理'),
	(59, 'menu', NULL, 'ios-settings', '/pro/system/menu/index', 55, '1', NULL, '2020-04-16 00:48:04', '菜单管理'),
	(60, NULL, NULL, NULL, NULL, 59, '2', 'addmenu', '2020-04-20 00:07:38', '添加菜单'),
	(61, NULL, NULL, NULL, NULL, 58, '2', 'addadmin', '2020-04-20 00:09:19', '添加管理员'),
	(62, NULL, NULL, NULL, NULL, 57, '2', 'addrole', '2020-04-20 00:09:38', '添加角色'),
	(63, NULL, NULL, NULL, NULL, 56, '2', 'gen:connecnt', '2020-04-20 00:10:06', '连接'),
	(64, 'enum', NULL, 'ios-settings', '/pro/system/enum/index', 55, '1', NULL, '2020-05-02 11:45:08', '枚举管理'),
	(65, 'file', NULL, 'ios-settings', '/pro/system/file/index', 55, '1', '', '2020-05-03 22:26:27', '文件管理'),
	(66, NULL, NULL, NULL, NULL, 65, '2', 'file_add', '2020-05-04 20:56:24', '上传文件'),
	(67, NULL, NULL, NULL, NULL, 65, '2', 'file_del', '2020-05-04 21:04:59', '文件删除'),
	(68, NULL, NULL, NULL, NULL, 64, '2', 'enum_select', '2020-05-05 13:44:14', '枚举查询'),
	(69, NULL, NULL, NULL, NULL, 64, '2', 'enum_add', '2020-05-05 13:44:40', '枚举添加'),
	(70, NULL, NULL, NULL, NULL, 64, '2', 'enum_edit', '2020-05-05 13:45:27', '枚举编辑'),
	(71, NULL, NULL, NULL, NULL, 64, '2', 'enum_del', '2020-05-05 13:45:44', '枚举删除'),
	(72, NULL, NULL, NULL, NULL, 65, '2', 'file_select', '2020-05-07 23:14:36', '文件查询'),
	(73, 'log', NULL, 'ios-settings', '/pro/system/log/index', 82, '1', NULL, '2020-05-08 00:42:06', '日志管理'),
	(74, NULL, NULL, NULL, NULL, 73, '2', 'log_select', '2020-05-08 00:42:30', '日志查询'),
	(75, NULL, NULL, NULL, NULL, 73, '0', 'log_del', '2020-05-08 00:42:42', '日志删除'),
	(76, NULL, NULL, NULL, NULL, 73, '2', 'log_info', '2020-05-08 01:25:00', '查看详情'),
	(77, NULL, NULL, NULL, NULL, 58, '2', 'admin_select', '2020-05-09 21:32:28', '管理员查询'),
	(78, NULL, NULL, NULL, NULL, 58, '2', 'admin_edit', '2020-05-09 21:32:52', '管理员修改'),
	(79, NULL, NULL, NULL, NULL, 58, '2', 'admin_del', '2020-05-09 21:33:49', '管理员删除'),
	(82, 'monitor', NULL, 'ios-settings', '/Main', 0, '0', NULL, '2020-05-10 00:04:38', '监控管理'),
	(83, 'eureka', NULL, 'ios-settings', 'http://localhost:8001', 82, '3', NULL, '2020-05-10 00:06:16', '注册服务'),
	(84, 'admin', NULL, 'ios-settings', 'http://192.168.0.151:8003', 82, '3', NULL, '2020-05-10 00:09:16', 'Admin'),
	(85, 'zipkin', NULL, 'ios-settings', 'http://192.168.0.151:8004', 82, '3', NULL, '2020-05-10 00:15:56', 'ZipKin'),
	(86, 'gen', NULL, 'ios-settings', 'Main', 0, '0', NULL, '2020-05-10 14:26:27', '生成器'),
	(88, 'generatoroption', NULL, 'ios-settings', '/pro/gen/option', 86, '1', NULL, '2020-04-13 23:39:12', '生成器设置'),
	(89, 'Merchant', NULL, 'ios-settings', 'Main', 0, '0', '', '2020-06-04 16:36:22', '企业管理'),
	(90, 'MerchantList', NULL, 'ios-settings', '/pro/merchant/index', 89, '1', 'merchant_select', '2020-06-04 16:45:28', '企业列表'),
	(91, 'XiaoShuo', NULL, 'ios-settings', 'Main', 0, '0', '', '2020-07-15 18:00:19', '小说管理'),
	(92, 'XiaoShuoType', NULL, 'ios-settings', '/pro/xiaoshuo/type/index', 91, '1', '', '2020-07-15 18:02:32', '类型管理'),
	(93, '', NULL, '', '', 92, '2', 'xiaoshuo_type_list', '2020-07-15 18:43:52', '查询操作'),
	(94, '', NULL, '', '', 92, '2', 'xiaoshuo_type_add', '2020-07-15 18:44:27', '添加操作'),
	(95, '', NULL, '', '', 92, '2', 'xiaoshuo_type_del', '2020-07-15 18:44:49', '删除操作'),
	(96, '', NULL, '', '', 92, '2', 'xiaoshuo_type_edit', '2020-07-15 18:45:15', '编辑操作'),
	(97, 'XiaoShuoNovel', NULL, 'ios-settings', '/pro/xiaoshuo/novel/index', 91, '1', '', '2020-07-17 11:39:38', '内容管理'),
	(98, '', NULL, '', '', 97, '2', 'xiaoshuo_novel_list', '2020-07-17 11:40:00', '查询内容'),
	(99, '', NULL, '', '', 97, '2', 'xiaoshuo_novel_edit', '2020-07-17 11:40:24', '内容编辑'),
	(100, '', NULL, '', '', 97, '2', 'xiaoshuo_novel_del', '2020-07-17 11:40:42', '内容删除'),
	(101, '', NULL, '', '', 97, '2', 'xiaoshuo_novel_add', '2020-07-17 11:41:23', '添加内容');
/*!40000 ALTER TABLE `pro_menu` ENABLE KEYS */;

-- 导出  表 pro_user.pro_resource_file 结构
DROP TABLE IF EXISTS `pro_resource_file`;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统资源文件表 ';

-- 正在导出表  pro_user.pro_resource_file 的数据：~9 rows (大约)
DELETE FROM `pro_resource_file`;
/*!40000 ALTER TABLE `pro_resource_file` DISABLE KEYS */;
INSERT INTO `pro_resource_file` (`file_id`, `file_name`, `physics_path`, `path`, `md5`, `file_size`, `file_dns`, `type`, `suffix`, `source_type`, `upload_time`) VALUES
	(1, '王振宇的简历.pdf', NULL, '2020050420570427761.pdf', '900c442c3e313dbf8e5235eb15beffe6', 101183, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '文件', 'pdf', 'ali', '2020-05-04 20:57:10'),
	(2, '【研发部】2020年工作周报汇总.xlsx', NULL, '2020050421135225885.xlsx', 'f96dc1fcd554bcaa1ecc3246f016e32c', 38969, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'xlsx', 'ali', '2020-05-04 21:13:58'),
	(3, '下载.jpeg', NULL, '2020050513523582617.jpeg', 'd9e71ec5d7902591b6ded40c7ed72c1d', 8408, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '图片', 'jpeg', 'ali', '2020-05-05 13:52:38'),
	(4, '资助过程性管理系统开发需求规格说明书.docx', NULL, '2020050720010015446.docx', 'c4f62c3430a2153a3431552fcf383cbc', 427772, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'docx', 'ali', '2020-05-07 20:01:05'),
	(5, '2020-05-08 01_21_35.zip', NULL, '2020050920284982917.zip', 'c1d43fb8611e3fecd82b1d4a7f1205ae', 3372, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'zip', 'ali', '2020-05-09 20:28:53'),
	(6, 'db_jude.sql', NULL, '2020051013194433539.sql', '3aefd9a1b2846172583286d23819ed4', 290096, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '视频', 'sql', 'ali', '2020-05-10 13:19:48'),
	(7, 'db_jude.sql', NULL, '202005101449288127.sql', '3aefd9a1b2846172583286d23819ed4', 290096, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'sql', 'ali', '2020-05-10 14:49:33'),
	(9, '__1__00010-00052__3.png', 'D:\\pro\\nacos-spring-cloud\\fileCache/png', '/png/2020070113574050080.png', '25c1fdaa38da31b7059d68940b169ba8', 5863, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'png', 'file', '2020-07-01 13:57:37'),
	(10, '功能表.xlsx', 'D:\\pro\\nacos-spring-cloud\\fileCache/xlsx', '/xlsx/2020070316004987137.xlsx', '70a725f8d672ff97a288b5b05b47a572', 21026, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'xlsx', 'file', '2020-07-03 16:00:52'),
	(11, '【研发部】2020年工作周报汇总.xlsx', 'D:\\pro\\nacos-spring-cloud\\fileCache/xlsx', '/xlsx/2020071315481659494.xlsx', '2f8f1493da507f44cc483a5f590aaebd', 59965, 'https://wzyfiles.oss-cn-beijing.aliyuncs.com/', '默认', 'xlsx', 'file', '2020-07-13 15:48:18');
/*!40000 ALTER TABLE `pro_resource_file` ENABLE KEYS */;

-- 导出  表 pro_user.pro_role 结构
DROP TABLE IF EXISTS `pro_role`;
CREATE TABLE IF NOT EXISTS `pro_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统角色表 ';

-- 正在导出表  pro_user.pro_role 的数据：~4 rows (大约)
DELETE FROM `pro_role`;
/*!40000 ALTER TABLE `pro_role` DISABLE KEYS */;
INSERT INTO `pro_role` (`role_id`, `name`, `create_time`) VALUES
	(17, '管理员', '2020-03-21 22:23:03'),
	(18, '生成管理员', '2020-03-29 00:58:34'),
	(19, '角色管理员', '2020-05-10 16:42:59'),
	(20, '共和国管理', '2020-05-10 23:52:37');
/*!40000 ALTER TABLE `pro_role` ENABLE KEYS */;

-- 导出  表 pro_user.pro_role_menu 结构
DROP TABLE IF EXISTS `pro_role_menu`;
CREATE TABLE IF NOT EXISTS `pro_role_menu` (
  `rm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标示id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`rm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5429 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色菜单关系表';

-- 正在导出表  pro_user.pro_role_menu 的数据：~139 rows (大约)
DELETE FROM `pro_role_menu`;
/*!40000 ALTER TABLE `pro_role_menu` DISABLE KEYS */;
INSERT INTO `pro_role_menu` (`rm_id`, `role_id`, `menu_id`, `create_time`) VALUES
	(4922, 18, 86, '2020-05-10 19:36:32'),
	(4923, 18, 56, '2020-05-10 19:36:32'),
	(4924, 18, 63, '2020-05-10 19:36:32'),
	(4925, 18, 88, '2020-05-10 19:36:32'),
	(4926, 18, 82, '2020-05-10 19:36:32'),
	(4927, 18, 85, '2020-05-10 19:36:33'),
	(4928, 18, 84, '2020-05-10 19:36:33'),
	(4929, 18, 83, '2020-05-10 19:36:33'),
	(4930, 18, 73, '2020-05-10 19:36:33'),
	(4931, 18, 76, '2020-05-10 19:36:33'),
	(4932, 18, 75, '2020-05-10 19:36:33'),
	(4933, 18, 74, '2020-05-10 19:36:33'),
	(4934, 18, 55, '2020-05-10 19:36:33'),
	(4935, 18, 65, '2020-05-10 19:36:34'),
	(4936, 18, 72, '2020-05-10 19:36:34'),
	(4937, 18, 67, '2020-05-10 19:36:34'),
	(4938, 18, 66, '2020-05-10 19:36:34'),
	(4939, 18, 64, '2020-05-10 19:36:34'),
	(4940, 18, 71, '2020-05-10 19:36:34'),
	(4941, 18, 70, '2020-05-10 19:36:34'),
	(4942, 18, 69, '2020-05-10 19:36:34'),
	(4943, 18, 68, '2020-05-10 19:36:34'),
	(4944, 18, 59, '2020-05-10 19:36:34'),
	(4945, 18, 60, '2020-05-10 19:36:34'),
	(4946, 18, 58, '2020-05-10 19:36:34'),
	(4947, 18, 79, '2020-05-10 19:36:34'),
	(4948, 18, 78, '2020-05-10 19:36:34'),
	(4949, 18, 77, '2020-05-10 19:36:34'),
	(4950, 18, 61, '2020-05-10 19:36:34'),
	(4951, 18, 57, '2020-05-10 19:36:34'),
	(4952, 18, 62, '2020-05-10 19:36:34'),
	(4953, 19, 86, '2020-05-10 19:36:40'),
	(4954, 19, 56, '2020-05-10 19:36:41'),
	(4955, 19, 63, '2020-05-10 19:36:41'),
	(4956, 19, 88, '2020-05-10 19:36:41'),
	(4957, 19, 82, '2020-05-10 19:36:41'),
	(4958, 19, 85, '2020-05-10 19:36:41'),
	(4959, 19, 84, '2020-05-10 19:36:42'),
	(4960, 19, 83, '2020-05-10 19:36:42'),
	(4961, 19, 73, '2020-05-10 19:36:42'),
	(4962, 19, 76, '2020-05-10 19:36:42'),
	(4963, 19, 75, '2020-05-10 19:36:42'),
	(4964, 19, 74, '2020-05-10 19:36:42'),
	(4965, 19, 55, '2020-05-10 19:36:42'),
	(4966, 19, 65, '2020-05-10 19:36:42'),
	(4967, 19, 72, '2020-05-10 19:36:42'),
	(4968, 19, 67, '2020-05-10 19:36:42'),
	(4969, 19, 66, '2020-05-10 19:36:42'),
	(4970, 19, 64, '2020-05-10 19:36:43'),
	(4971, 19, 71, '2020-05-10 19:36:43'),
	(4972, 19, 70, '2020-05-10 19:36:43'),
	(4973, 19, 69, '2020-05-10 19:36:43'),
	(4974, 19, 68, '2020-05-10 19:36:43'),
	(4975, 19, 59, '2020-05-10 19:36:43'),
	(4976, 19, 60, '2020-05-10 19:36:43'),
	(4977, 19, 58, '2020-05-10 19:36:43'),
	(4978, 19, 79, '2020-05-10 19:36:43'),
	(4979, 19, 78, '2020-05-10 19:36:43'),
	(4980, 19, 77, '2020-05-10 19:36:43'),
	(4981, 19, 61, '2020-05-10 19:36:43'),
	(4982, 19, 57, '2020-05-10 19:36:43'),
	(4983, 19, 62, '2020-05-10 19:36:43'),
	(5278, 20, 89, '2020-07-03 16:50:51'),
	(5279, 20, 90, '2020-07-03 16:50:51'),
	(5280, 20, 86, '2020-07-03 16:50:51'),
	(5281, 20, 56, '2020-07-03 16:50:51'),
	(5282, 20, 63, '2020-07-03 16:50:51'),
	(5283, 20, 88, '2020-07-03 16:50:51'),
	(5284, 20, 82, '2020-07-03 16:50:51'),
	(5285, 20, 85, '2020-07-03 16:50:51'),
	(5286, 20, 84, '2020-07-03 16:50:51'),
	(5287, 20, 83, '2020-07-03 16:50:51'),
	(5288, 20, 73, '2020-07-03 16:50:51'),
	(5289, 20, 76, '2020-07-03 16:50:51'),
	(5290, 20, 75, '2020-07-03 16:50:52'),
	(5291, 20, 74, '2020-07-03 16:50:52'),
	(5292, 20, 55, '2020-07-03 16:50:52'),
	(5293, 20, 65, '2020-07-03 16:50:52'),
	(5294, 20, 72, '2020-07-03 16:50:52'),
	(5295, 20, 67, '2020-07-03 16:50:52'),
	(5296, 20, 66, '2020-07-03 16:50:52'),
	(5297, 20, 64, '2020-07-03 16:50:52'),
	(5298, 20, 71, '2020-07-03 16:50:52'),
	(5299, 20, 70, '2020-07-03 16:50:52'),
	(5300, 20, 69, '2020-07-03 16:50:52'),
	(5301, 20, 68, '2020-07-03 16:50:52'),
	(5302, 20, 59, '2020-07-03 16:50:52'),
	(5303, 20, 60, '2020-07-03 16:50:52'),
	(5304, 20, 58, '2020-07-03 16:50:52'),
	(5305, 20, 79, '2020-07-03 16:50:53'),
	(5306, 20, 78, '2020-07-03 16:50:53'),
	(5307, 20, 77, '2020-07-03 16:50:53'),
	(5308, 20, 61, '2020-07-03 16:50:53'),
	(5309, 20, 57, '2020-07-03 16:50:53'),
	(5310, 20, 62, '2020-07-03 16:50:53'),
	(5385, 17, 91, '2020-07-17 11:41:38'),
	(5386, 17, 97, '2020-07-17 11:41:38'),
	(5387, 17, 101, '2020-07-17 11:41:38'),
	(5388, 17, 100, '2020-07-17 11:41:38'),
	(5389, 17, 99, '2020-07-17 11:41:38'),
	(5390, 17, 98, '2020-07-17 11:41:38'),
	(5391, 17, 92, '2020-07-17 11:41:38'),
	(5392, 17, 96, '2020-07-17 11:41:38'),
	(5393, 17, 95, '2020-07-17 11:41:39'),
	(5394, 17, 94, '2020-07-17 11:41:39'),
	(5395, 17, 93, '2020-07-17 11:41:39'),
	(5396, 17, 89, '2020-07-17 11:41:39'),
	(5397, 17, 90, '2020-07-17 11:41:39'),
	(5398, 17, 86, '2020-07-17 11:41:39'),
	(5399, 17, 56, '2020-07-17 11:41:39'),
	(5400, 17, 63, '2020-07-17 11:41:39'),
	(5401, 17, 88, '2020-07-17 11:41:39'),
	(5402, 17, 82, '2020-07-17 11:41:39'),
	(5403, 17, 85, '2020-07-17 11:41:39'),
	(5404, 17, 84, '2020-07-17 11:41:39'),
	(5405, 17, 83, '2020-07-17 11:41:39'),
	(5406, 17, 73, '2020-07-17 11:41:39'),
	(5407, 17, 76, '2020-07-17 11:41:40'),
	(5408, 17, 75, '2020-07-17 11:41:40'),
	(5409, 17, 74, '2020-07-17 11:41:40'),
	(5410, 17, 55, '2020-07-17 11:41:40'),
	(5411, 17, 65, '2020-07-17 11:41:40'),
	(5412, 17, 72, '2020-07-17 11:41:40'),
	(5413, 17, 67, '2020-07-17 11:41:40'),
	(5414, 17, 66, '2020-07-17 11:41:40'),
	(5415, 17, 64, '2020-07-17 11:41:40'),
	(5416, 17, 71, '2020-07-17 11:41:40'),
	(5417, 17, 70, '2020-07-17 11:41:40'),
	(5418, 17, 69, '2020-07-17 11:41:40'),
	(5419, 17, 68, '2020-07-17 11:41:40'),
	(5420, 17, 59, '2020-07-17 11:41:40'),
	(5421, 17, 60, '2020-07-17 11:41:40'),
	(5422, 17, 58, '2020-07-17 11:41:41'),
	(5423, 17, 79, '2020-07-17 11:41:41'),
	(5424, 17, 78, '2020-07-17 11:41:41'),
	(5425, 17, 77, '2020-07-17 11:41:41'),
	(5426, 17, 61, '2020-07-17 11:41:41'),
	(5427, 17, 57, '2020-07-17 11:41:41'),
	(5428, 17, 62, '2020-07-17 11:41:41');
/*!40000 ALTER TABLE `pro_role_menu` ENABLE KEYS */;

-- 导出  表 pro_user.pro_user 结构
DROP TABLE IF EXISTS `pro_user`;
CREATE TABLE IF NOT EXISTS `pro_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `head_img` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '头像',
  `user_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `user_pass` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `stats` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统管理员表 ';

-- 正在导出表  pro_user.pro_user 的数据：~3 rows (大约)
DELETE FROM `pro_user`;
/*!40000 ALTER TABLE `pro_user` DISABLE KEYS */;
INSERT INTO `pro_user` (`user_id`, `head_img`, `user_name`, `user_pass`, `login_num`, `last_login_time`, `stats`, `create_time`) VALUES
	(1, '2020050513523582617.jpeg', 'lptnyy', 'wangyang', 0, NULL, 0, '2020-05-10 03:15:20'),
	(33, '2020050513523582617.jpeg', 'lptnii', 'wangyang', 0, NULL, 0, '2020-05-10 03:18:12'),
	(34, '2020050513523582617.jpeg', 'lptnuu', 'wangyang', 0, NULL, 0, '2020-05-10 03:30:33');
/*!40000 ALTER TABLE `pro_user` ENABLE KEYS */;

-- 导出  表 pro_user.pro_user_role 结构
DROP TABLE IF EXISTS `pro_user_role`;
CREATE TABLE IF NOT EXISTS `pro_user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户角色关系表 ';

-- 正在导出表  pro_user.pro_user_role 的数据：~13 rows (大约)
DELETE FROM `pro_user_role`;
/*!40000 ALTER TABLE `pro_user_role` DISABLE KEYS */;
INSERT INTO `pro_user_role` (`ur_id`, `role_id`, `user_id`, `create_time`) VALUES
	(4, 18, 3, '2020-04-20 00:38:01'),
	(5, 17, 3, '2020-04-20 00:38:01'),
	(10, 18, 1, '2020-05-02 10:04:25'),
	(11, 17, 1, '2020-05-02 10:04:25'),
	(12, 18, 6, '2020-05-07 20:31:28'),
	(13, 17, 6, '2020-05-07 20:31:28'),
	(16, 18, 33, '2020-05-10 03:18:46'),
	(17, 17, 33, '2020-05-10 03:18:46'),
	(18, 17, 32, '2020-05-10 14:50:38'),
	(19, 18, 32, '2020-05-10 14:50:38'),
	(20, 20, 34, '2020-06-30 15:52:14'),
	(21, 19, 34, '2020-06-30 15:52:14'),
	(22, 18, 34, '2020-06-30 15:52:14'),
	(23, 17, 34, '2020-06-30 15:52:14');
/*!40000 ALTER TABLE `pro_user_role` ENABLE KEYS */;

-- 导出  表 pro_user.undo_log 结构
DROP TABLE IF EXISTS `undo_log`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  pro_user.undo_log 的数据：~0 rows (大约)
DELETE FROM `undo_log`;
/*!40000 ALTER TABLE `undo_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `undo_log` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
