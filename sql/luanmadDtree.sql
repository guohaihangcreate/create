/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 6.0.5-alpha-community : Database - create
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`create` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `create`;

/*Table structure for table `treenodes` */

DROP TABLE IF EXISTS `treenodes`;

CREATE TABLE `treenodes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `url` varchar(200) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `target` varchar(20) DEFAULT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `fontStyleName` varchar(500) DEFAULT NULL,
  `iconOpen` varchar(80) DEFAULT NULL,
  `open` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `treenodes` */

insert  into `treenodes`(`id`,`pid`,`name`,`url`,`title`,`target`,`icon`,`sort`,`fontStyleName`,`iconOpen`,`open`) values (35,0,'aaa','/index.jsp','aaa',NULL,'images/ajax_dtree/folder.gif',10,'font-weight:bold;font-size:14px;color:#0066FF',NULL,NULL),(36,0,'bbb','/index.jsp','bbb',NULL,'images/ajax_dtree/folder.gif',2,'font-weight:bold;font-size:14px;color:#009900',NULL,NULL),(37,36,'ccc','#','ccc',NULL,'images/ajax_dtree/folder.gif',3,';;;color:#000000',NULL,NULL),(39,35,'ggg','/index.jsp','ggg',NULL,'images/ajax_dtree/folder.gif',4,'font-weight:bold;font-size:14px;color:#000000',NULL,NULL),(40,35,'fff','/index.jsp','fff',NULL,'images/ajax_dtree/folder.gif',5,';;;color:#000000',NULL,NULL),(92,35,'切实可行','/index.jsp','切实可行',NULL,'images/ajax_dtree/folder.gif',6,';;;color:#000000',NULL,NULL),(93,92,'优胜劣汰','/index.jsp','优胜劣汰',NULL,'images/ajax_dtree/folder.gif',7,';;;color:#000000',NULL,NULL),(94,92,'举国欢腾','/index.jsp','举国欢腾',NULL,'images/ajax_dtree/folder.gif',8,';;;color:#000000',NULL,NULL),(95,35,'基本原理','/index.jsp','基本原理',NULL,'images/ajax_dtree/folder.gif',9,';;;color:#000000',NULL,NULL),(96,0,'基本功','/index.jsp','基本功',NULL,'images/ajax_dtree/folder.gif',1,'font-weight:bold;font-size:14px;color:#9933CC',NULL,NULL),(97,96,'艺术大师','/index.jsp','艺术大师',NULL,'images/ajax_dtree/folder.gif',11,'font-weight:bold;;;color:#999900',NULL,NULL),(98,0,'lanmad!','/index.jsp','lanmad!',NULL,'images/ajax_dtree/folder.gif',12,'font-weight:bold;font-size:20px;color:#FF0000',NULL,NULL),(99,98,'架构与J2EE技术','/index.jsp','架构与J2EE技术',NULL,'images/ajax_dtree/folder.gif',19,'font-weight:bold;;;color:#000000',NULL,NULL),(100,98,'WEB开发（脚本神功与动态技术）','/index.jsp','WEB开发（脚本神功与动态技术）',NULL,'images/ajax_dtree/folder.gif',18,'font-weight:bold;;;color:#000000',NULL,NULL),(101,98,'Linux技术','#','Linux技术',NULL,'images/ajax_dtree/folder.gif',13,'font-weight:bold;;;color:#000000',NULL,NULL),(102,96,'中国','/index.jsp','中国',NULL,'images/ajax_dtree/folder.gif',16,';;;color:#000000',NULL,NULL),(103,96,'草木灰','#','草木灰',NULL,'images/ajax_dtree/folder.gif',17,';;;color:#000000',NULL,NULL),(104,98,'官方经典实例','#','官方经典实例',NULL,'images/ajax_dtree/folder.gif',14,'font-weight:bold;;;color:#000000',NULL,NULL),(105,98,'数据库开发','#','数据库开发',NULL,'images/ajax_dtree/folder.gif',15,'font-weight:bold;;;color:#000000',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
