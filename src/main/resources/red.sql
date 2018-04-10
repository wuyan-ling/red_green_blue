/*
SQLyog Enterprise v12.2.6 (64 bit)
MySQL - 5.5.59-0ubuntu0.14.04.1 : Database - red_green_blue
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`red_green_blue` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `red_green_blue`;

/*Table structure for table `application_form` */

DROP TABLE IF EXISTS `application_form`;

CREATE TABLE `application_form` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id唯一字符串',
  `responsibility_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '负责人姓名非空',
  `project_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名称',
  `project_information` text COLLATE utf8_unicode_ci COMMENT '项目简介 可为空',
  `college` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '团队所属学院 非空',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '申请状态0未处理 1通过 2未通过',
  `error_message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '未通过理由',
  `responsibility_phone_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目负责人电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `application_form` */

/*Table structure for table `operation_message` */

DROP TABLE IF EXISTS `operation_message`;

CREATE TABLE `operation_message` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id字符串',
  `month_turnover` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '月营业额 单位元',
  `transaction_time` int(11) DEFAULT NULL COMMENT '当月累计成交次数',
  `product_main` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '主营产品名称',
  `product_minor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '次要产品名称',
  `buy_cost` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '采购费用',
  `employee_expend` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职工费用',
  `liability` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '负债情况',
  `investment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '风投信息',
  `month_work` text COLLATE utf8_unicode_ci COMMENT '本月工作内容',
  `next_month_work` text COLLATE utf8_unicode_ci COMMENT '下个月工作',
  `project_specialty` text COLLATE utf8_unicode_ci COMMENT '项目突出点',
  `project_question` text COLLATE utf8_unicode_ci COMMENT '项目运营存在的问题',
  `team_need` text COLLATE utf8_unicode_ci COMMENT '团队需求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `operation_message` */

/*Table structure for table `public_facility` */

DROP TABLE IF EXISTS `public_facility`;

CREATE TABLE `public_facility` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id字符串',
  `request_address` int(11) NOT NULL DEFAULT '0' COMMENT '申请地点 0会议室 1培训教室 2路演中心 ...',
  `person_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '人数范围',
  `request_use_time` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '申请使用时间',
  `contact_way` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系方式',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `public_facility` */

/*Table structure for table `team_member` */

DROP TABLE IF EXISTS `team_member`;

CREATE TABLE `team_member` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '团队成员主键id',
  `team_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '所属团队id',
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '成员姓名',
  `phone_number` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系方式 可为空',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `team_member` */

/*Table structure for table `team_message` */

DROP TABLE IF EXISTS `team_message`;

CREATE TABLE `team_message` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '团队表主键id',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '团队名称',
  `leader` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '团队负责人',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态0可用户 1不可以',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `team_message` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `phone_number` varchar(15) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键手机号',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户姓名 非空',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码 md5加密 非空',
  `mark` int(11) NOT NULL DEFAULT '1' COMMENT '身份标识符 0管理员1团队负责人 默认为1',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态0可用 1不可用',
  PRIMARY KEY (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`phone_number`,`username`,`password`,`mark`,`status`) values 
('18270313383','redstar','1B4395FEEB7E8209BD9D5B211C2E2B29',0,0);

/*Table structure for table `wechat_news` */

DROP TABLE IF EXISTS `wechat_news`;

CREATE TABLE `wechat_news` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '主键id唯一不为空',
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '新闻标题',
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片',
  `description` text COLLATE utf8_unicode_ci COMMENT '简介',
  `time` int(11) DEFAULT NULL COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `wechat_news` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
