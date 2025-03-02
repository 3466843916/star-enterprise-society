/*
SQLyog Ultimate v8.32
MySQL - 8.0.30 : Database - star-enterprise-society
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`star-enterprise-society` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `star-enterprise-society`;

/*Table structure for table `z_banner` */

DROP TABLE IF EXISTS `z_banner`;

CREATE TABLE `z_banner` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
                            `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
                            `created_by` varchar(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
                            `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_by` varchar(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                            `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1删除，0否）',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `z_banner` */

/*Table structure for table `z_menu` */

DROP TABLE IF EXISTS `z_menu`;

CREATE TABLE `z_menu` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `menu_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NULL' COMMENT '菜单名',
                          `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NULL' COMMENT '路由地址',
                          `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NULL' COMMENT '组件路径',
                          `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '菜单状态(0正常，1停用)',
                          `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NULL' COMMENT '权限标识',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人',
                          `created_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_by` bigint DEFAULT NULL COMMENT '更新人',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（0否，1是）',
                          KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `z_menu` */

insert  into `z_menu`(`id`,`menu_name`,`path`,`component`,`status`,`perms`,`created_by`,`created_time`,`update_by`,`update_time`,`is_deleted`) values (1,'Page','/page','PageComponent','0','page:page',149,'2025-03-03 00:20:59',NULL,NULL,0),(2,'Home','/home','HomeComponent','0','home:home',149,'2025-03-03 00:21:19',NULL,NULL,0);

/*Table structure for table `z_role` */

DROP TABLE IF EXISTS `z_role`;

CREATE TABLE `z_role` (
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'NULL' COMMENT '角色名称',
                          `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色权限字符串',
                          `status` tinyint(1) DEFAULT '0' COMMENT '角色状态(0正常，1停用)',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人',
                          `created_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `update_by` bigint DEFAULT NULL COMMENT '更新人',
                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                          `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（0否，1是）',
                          KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `z_role` */

insert  into `z_role`(`id`,`name`,`role_key`,`status`,`created_by`,`created_time`,`update_by`,`update_time`,`is_deleted`) values (1,'Admin','admin',0,149,'2025-03-03 00:20:23',NULL,NULL,0),(2,'User','user',0,149,'2025-03-03 00:20:29',NULL,NULL,0);

/*Table structure for table `z_role_menu` */

DROP TABLE IF EXISTS `z_role_menu`;

CREATE TABLE `z_role_menu` (
                               `role_id` bigint NOT NULL COMMENT '角色ID',
                               `menu_id` bigint NOT NULL COMMENT '菜单ID',
                               `created_by` bigint DEFAULT NULL COMMENT '创建人',
                               `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新人',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（0否，1是）',
                               PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `z_role_menu` */

insert  into `z_role_menu`(`role_id`,`menu_id`,`created_by`,`created_time`,`update_by`,`update_time`,`is_deleted`) values (1,1,149,'2025-03-03 00:21:52',NULL,'2025-03-03 00:21:52',0),(1,2,149,'2025-03-03 00:21:52',NULL,'2025-03-03 00:21:52',0),(2,1,149,'2025-03-03 00:22:02',NULL,'2025-03-03 00:22:02',0),(2,2,149,'2025-03-03 00:22:02',NULL,'2025-03-03 00:22:02',0);

/*Table structure for table `z_user` */

DROP TABLE IF EXISTS `z_user`;

CREATE TABLE `z_user` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                          `username` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
                          `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
                          `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话号码',
                          `gender` int DEFAULT '1' COMMENT '性别',
                          `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像路径',
                          `created_by` varchar(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                          `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_by` varchar(33) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                          `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                          `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（1删除，0否）',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `z_user` */

insert  into `z_user`(`id`,`username`,`password`,`phone`,`gender`,`avatar`,`created_by`,`created_time`,`update_by`,`update_time`,`is_deleted`) values (2,'0041561340',NULL,'15353528762',1,NULL,'0','2025-03-03 00:41:56',NULL,'2025-03-03 00:41:56',0),(3,'0049357282',NULL,'15719172394',1,NULL,'149','2025-03-03 00:49:36',NULL,'2025-03-03 00:49:35',0);

/*Table structure for table `z_user_role` */

DROP TABLE IF EXISTS `z_user_role`;

CREATE TABLE `z_user_role` (
                               `user_id` bigint DEFAULT NULL COMMENT '用户ID',
                               `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                               `created_by` bigint DEFAULT NULL COMMENT '创建人',
                               `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_by` bigint DEFAULT NULL COMMENT '更新人',
                               `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除（0否，1是）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `z_user_role` */

insert  into `z_user_role`(`user_id`,`role_id`,`created_by`,`created_time`,`update_by`,`update_time`,`is_deleted`) values (2,2,0,'2025-03-03 00:41:56',NULL,'2025-03-03 00:41:56',0),(3,2,149,'2025-03-03 00:49:36',NULL,'2025-03-03 00:49:35',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
