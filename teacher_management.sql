/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.34 : Database - teacher_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`teacher_management` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `teacher_management`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `did` int NOT NULL,
  `dname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `department` */

insert  into `department`(`did`,`dname`) values 
(1,'党群部门'),
(2,'行政部门'),
(3,'教学部门'),
(4,'教辅部门');

/*Table structure for table `element` */

DROP TABLE IF EXISTS `element`;

CREATE TABLE `element` (
  `eid` int NOT NULL,
  `iid` int NOT NULL,
  `iname` varchar(40) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`eid`,`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `element` */

insert  into `element`(`eid`,`iid`,`iname`) values 
(1,1,'政治理论学习考核'),
(2,1,'工作作风及廉政考核'),
(3,2,'学生评教'),
(4,2,'专家评教'),
(5,2,'教学常规检查日常'),
(6,2,'课程思政'),
(7,3,'学风建设'),
(8,3,'院(部)工作'),
(9,3,'同行评价'),
(10,3,'教师个人专业发展'),
(11,4,'社会服务、实践教学能力'),
(12,5,'教学事故处罚'),
(13,5,'安全事故处理'),
(14,5,'教师参加教学类技能比赛'),
(15,5,'教学成果创建方面');

/*Table structure for table `examine_record` */

DROP TABLE IF EXISTS `examine_record`;

CREATE TABLE `examine_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `year` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `term` enum('一','二') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `tid` char(4) COLLATE utf8mb3_bin NOT NULL,
  `name` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `status` enum('教师','专家') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`year`,`term`,`tid`,`status`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `examine_record` */

insert  into `examine_record`(`id`,`year`,`term`,`tid`,`name`,`status`) values 
(65,'2022~2023','一','0033','张何林','教师'),
(66,'2022~2023','一','0106','张明杰','教师'),
(61,'2022~2023','一','0134','张青','专家'),
(62,'2022~2023','一','0168','李兆楠','专家'),
(63,'2022~2023','一','0280','张洁','专家'),
(64,'2022~2023','一','0331','孙小果\r\n','专家');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `iid` int NOT NULL,
  `iname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `item` */

insert  into `item`(`iid`,`iname`) values 
(1,'师德师风'),
(2,'教学质量'),
(3,'院(部)评价'),
(4,'社会服务、实践教学能力'),
(5,'其他扣分项和加分项');

/*Table structure for table `office` */

DROP TABLE IF EXISTS `office`;

CREATE TABLE `office` (
  `oid` int NOT NULL,
  `did` int DEFAULT NULL,
  `oname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `oname2` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `office` */

insert  into `office`(`oid`,`did`,`oname`,`oname2`) values 
(1,1,'党委办公室',NULL),
(2,1,'纪委','监察处'),
(3,1,'党委宣传部','统战部'),
(4,1,'党委学生工作部',NULL),
(5,1,'工会',NULL),
(6,1,'退休人员工作处',NULL),
(7,1,'团委',NULL),
(8,2,'院长办公室',NULL),
(9,2,'人事处',NULL),
(10,2,'教务处',NULL),
(11,2,'发展与质量管理处',NULL),
(12,2,'财务处',NULL),
(13,2,'科研处事处',NULL),
(14,2,'招生处',NULL),
(15,2,'校企合作与就业处',NULL),
(16,2,'资产管理处',NULL),
(17,2,'基建处',NULL),
(18,2,'保卫处',NULL),
(19,2,'后勤处',NULL),
(20,3,'化学工程学院',NULL),
(21,3,'制药工程学院',NULL),
(22,3,'医药学院',NULL),
(23,3,'机电工程学院',NULL),
(24,3,'信息工程学院',NULL),
(25,3,'护理学院',NULL),
(26,3,'建筑工程学院',NULL),
(27,3,'经济管理学院',NULL),
(28,3,'商学院',NULL),
(29,3,'本科部',NULL),
(30,3,'马克思主义学院',NULL),
(31,3,'基础教学部',NULL),
(32,3,'体育教学部',NULL),
(33,3,'艺术教学部',NULL),
(34,4,'开封校区综合服务中心',NULL),
(35,4,'信息化管理中心',NULL),
(36,4,'图书馆',NULL),
(37,4,'心理健康教育中心',NULL),
(38,4,'继续教育学院',NULL),
(39,4,'创新创业学院',NULL),
(40,4,'职业教育研究所','学报编辑部');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `tid` char(4) COLLATE utf8mb3_bin NOT NULL,
  `iid` int NOT NULL,
  `eid` int NOT NULL,
  `result` float NOT NULL,
  PRIMARY KEY (`tid`,`iid`,`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `score` */

insert  into `score`(`tid`,`iid`,`eid`,`result`) values 
('0033',1,1,10),
('0033',1,2,10),
('0033',2,3,15),
('0033',2,4,15),
('0033',2,5,10),
('0033',2,6,5),
('0033',3,7,5),
('0033',3,8,10),
('0033',3,9,5),
('0033',3,10,5),
('0033',4,11,10),
('0033',5,12,-0),
('0033',5,13,-0),
('0033',5,14,0),
('0033',5,15,0),
('0123',1,1,10),
('0123',1,2,10),
('0123',2,3,15),
('0123',2,4,15),
('0123',2,5,10),
('0123',2,6,5),
('0123',3,7,5),
('0123',3,8,10),
('0123',3,9,5),
('0123',3,10,5),
('0123',4,11,10),
('0123',5,12,-10),
('0123',5,13,-10),
('0123',5,14,3),
('0123',5,15,4),
('0134',1,1,10),
('0134',1,2,10),
('0134',2,3,15),
('0134',2,4,15),
('0134',2,5,10),
('0134',2,6,5),
('0134',3,7,5),
('0134',3,8,10),
('0134',3,9,5),
('0134',3,10,5),
('0134',4,11,10),
('0134',5,12,-1),
('0134',5,13,-1),
('0134',5,14,2),
('0134',5,15,2),
('1234',1,1,10),
('1234',1,2,10),
('1234',2,3,15),
('1234',2,4,15),
('1234',2,5,10),
('1234',2,6,5),
('1234',3,7,5),
('1234',3,8,10),
('1234',3,9,5),
('1234',3,10,5),
('1234',4,11,10),
('1234',5,12,-0),
('1234',5,13,-0),
('1234',5,14,0),
('1234',5,15,0);

/*Table structure for table `score_prize` */

DROP TABLE IF EXISTS `score_prize`;

CREATE TABLE `score_prize` (
  `year` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `term` enum('一','二') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `tid` char(4) COLLATE utf8mb3_bin NOT NULL,
  `pname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `level` enum('省级','国家级','世界级') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `prank` enum('一等奖','二等奖','三等奖') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `comment` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `type` enum('教学类技能比赛','教学成果创建方面') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `pass` tinyint(1) DEFAULT '0',
  `result` float DEFAULT NULL,
  PRIMARY KEY (`year`,`term`,`tid`,`pname`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `score_prize` */

insert  into `score_prize`(`year`,`term`,`tid`,`pname`,`level`,`prank`,`comment`,`type`,`pass`,`result`) values 
('2023~2024','一','0134','2333','省级','一等奖','2333','教学类技能比赛',1,7),
('2023~2024','一','0134','321','省级','一等奖','321','教学类技能比赛',1,3),
('2023~2024','一','0134','333','省级','一等奖','333','教学类技能比赛',1,2),
('2023~2024','一','0134','444','省级','一等奖','444','教学类技能比赛',1,1),
('2023~2024','一','0134','567','省级','二等奖','567','教学类技能比赛',1,5),
('2023~2024','一','0134','777','省级','一等奖','777','教学类技能比赛',1,7),
('2023~2024','一','0134','988','省级','一等奖','8989','教学类技能比赛',1,5);

/*Table structure for table `score_prof` */

DROP TABLE IF EXISTS `score_prof`;

CREATE TABLE `score_prof` (
  `year` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `term` enum('二','一') CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `times` int NOT NULL DEFAULT '1',
  `professor` char(4) COLLATE utf8mb3_bin NOT NULL,
  `tid` char(4) COLLATE utf8mb3_bin NOT NULL,
  `tname` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `cname` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `address` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `time` varchar(20) COLLATE utf8mb3_bin DEFAULT NULL,
  `content` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `pass` tinyint(1) DEFAULT '0',
  `result` float DEFAULT NULL,
  PRIMARY KEY (`year`,`term`,`times`,`professor`,`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `score_prof` */

insert  into `score_prof`(`year`,`term`,`times`,`professor`,`tid`,`tname`,`cname`,`address`,`time`,`content`,`pass`,`result`) values 
('2023~2024','一',1,'0134','0123','姬彦红','123','123','22','123',0,22),
('2023~2024','一',2,'0134','0123','姬彦红','33','33','33','33',33,33);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` char(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `tname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `identity` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `did` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  `comment` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT '无',
  `password` varchar(20) COLLATE utf8mb3_bin DEFAULT '123',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`tname`,`identity`,`did`,`oid`,`comment`,`password`) values 
('0033','张何林','中层干部',4,39,'空','123'),
('0106','张明杰','中层干部',4,39,'空','123'),
('0110','马春燕','中层干部',4,39,'空','123'),
('0123','姬彦红','专职教师',4,39,'空','123'),
('0134','张青','中层干部',4,39,'空','123'),
('0168','李兆楠','中层干部',4,39,'空','123'),
('0280','张洁','专职教师\r\n',4,39,'无','123'),
('0331','孙小果\r\n','专职教师\r\n',4,39,'无','123'),
('0415','许文广','专职教师',4,39,'空','123'),
('0421','侯海舰','专职教师\r\n',4,39,'无','123'),
('0422','陈沛','专职行政',4,39,'空','123'),
('0448','张二月','中层干部',4,39,'空','123'),
('0528','游大磊','专职教师',4,39,'空','123'),
('0534','王倩\r\n','中层干部\r\n',4,39,'无','123'),
('0535','刘家麟','专职教师',4,39,'无课\r\n','123');

/* Function  structure for function  `getItemScore` */

/*!50003 DROP FUNCTION IF EXISTS `getItemScore` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getItemScore`(id char(4),item int) RETURNS varchar(20) CHARSET utf8mb3 COLLATE utf8mb3_bin
BEGIN
	declare ans varchar(20);
	select sum(result) into ans from score where tid=id and iid=item;
	RETURN ans;
END */$$
DELIMITER ;

/* Function  structure for function  `getPass` */

/*!50003 DROP FUNCTION IF EXISTS `getPass` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getPass`(pass int) RETURNS varchar(20) CHARSET utf8mb3 COLLATE utf8mb3_bin
BEGIN
	DECLARE ans VARCHAR(20);
	if pass=0 then set ans='未通过';
	else SET ans='通过';
	end if;
	return ans;
END */$$
DELIMITER ;

/* Function  structure for function  `getWholeScore` */

/*!50003 DROP FUNCTION IF EXISTS `getWholeScore` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `getWholeScore`(id CHAR(4)) RETURNS varchar(20) CHARSET utf8mb3 COLLATE utf8mb3_bin
BEGIN
	DECLARE ans VARCHAR(20);
	SELECT SUM(result) INTO ans FROM score WHERE tid=id;
	RETURN ans;
END */$$
DELIMITER ;

/*Table structure for table `examine_professor` */

DROP TABLE IF EXISTS `examine_professor`;

/*!50001 DROP VIEW IF EXISTS `examine_professor` */;
/*!50001 DROP TABLE IF EXISTS `examine_professor` */;

/*!50001 CREATE TABLE  `examine_professor`(
 `学年` varchar(20) ,
 `学期` enum('一','二') ,
 `工号` char(4) ,
 `姓名` varchar(20) ,
 `身份` enum('教师','专家') 
)*/;

/*Table structure for table `examine_teacher` */

DROP TABLE IF EXISTS `examine_teacher`;

/*!50001 DROP VIEW IF EXISTS `examine_teacher` */;
/*!50001 DROP TABLE IF EXISTS `examine_teacher` */;

/*!50001 CREATE TABLE  `examine_teacher`(
 `学年` varchar(20) ,
 `学期` enum('一','二') ,
 `工号` char(4) ,
 `姓名` varchar(20) ,
 `身份` enum('教师','专家') 
)*/;

/*Table structure for table `prize_view` */

DROP TABLE IF EXISTS `prize_view`;

/*!50001 DROP VIEW IF EXISTS `prize_view` */;
/*!50001 DROP TABLE IF EXISTS `prize_view` */;

/*!50001 CREATE TABLE  `prize_view`(
 `是否通过` varchar(20) ,
 `类型` enum('教学类技能比赛','教学成果创建方面') ,
 `学年` varchar(20) ,
 `学期` enum('一','二') ,
 `工号` char(4) ,
 `教师姓名` varchar(20) ,
 `比赛名称` varchar(20) ,
 `比赛级别` enum('省级','国家级','世界级') ,
 `获奖` enum('一等奖','二等奖','三等奖') ,
 `证明` varchar(100) ,
 `得分` float 
)*/;

/*Table structure for table `record_view` */

DROP TABLE IF EXISTS `record_view`;

/*!50001 DROP VIEW IF EXISTS `record_view` */;
/*!50001 DROP TABLE IF EXISTS `record_view` */;

/*!50001 CREATE TABLE  `record_view`(
 `学年` varchar(20) ,
 `学期` enum('一','二') ,
 `教师工号` char(4) ,
 `教师姓名` varchar(20) ,
 `身份` enum('教师','专家') 
)*/;

/*Table structure for table `score_prof_view` */

DROP TABLE IF EXISTS `score_prof_view`;

/*!50001 DROP VIEW IF EXISTS `score_prof_view` */;
/*!50001 DROP TABLE IF EXISTS `score_prof_view` */;

/*!50001 CREATE TABLE  `score_prof_view`(
 `是否通过` varchar(20) ,
 `学年` varchar(20) ,
 `学期` enum('二','一') ,
 `评价次数` int ,
 `专家工号` char(4) ,
 `专家姓名` varchar(20) ,
 `教师工号` char(4) ,
 `教师姓名` varchar(20) ,
 `课程名称` varchar(20) ,
 `上课地点` varchar(20) ,
 `时间` varchar(20) ,
 `听课内容` varchar(100) ,
 `得分` float 
)*/;

/*Table structure for table `score_simple` */

DROP TABLE IF EXISTS `score_simple`;

/*!50001 DROP VIEW IF EXISTS `score_simple` */;
/*!50001 DROP TABLE IF EXISTS `score_simple` */;

/*!50001 CREATE TABLE  `score_simple`(
 `工号` char(4) ,
 `教师姓名` varchar(20) ,
 `师德师风` varchar(20) ,
 `教学质量` varchar(20) ,
 `院(部)评价` varchar(20) ,
 `社会服务、实践教学能力` varchar(20) ,
 `其他扣分项和加分项` varchar(20) ,
 `总分` varchar(20) 
)*/;

/*Table structure for table `teacherview` */

DROP TABLE IF EXISTS `teacherview`;

/*!50001 DROP VIEW IF EXISTS `teacherview` */;
/*!50001 DROP TABLE IF EXISTS `teacherview` */;

/*!50001 CREATE TABLE  `teacherview`(
 `工号` char(4) ,
 `教师姓名` varchar(20) ,
 `教师身份` varchar(20) ,
 `部门` varchar(20) ,
 `教研室` varchar(20) ,
 `备注` varchar(100) ,
 `密码` varchar(20) 
)*/;

/*View structure for view examine_professor */

/*!50001 DROP TABLE IF EXISTS `examine_professor` */;
/*!50001 DROP VIEW IF EXISTS `examine_professor` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `examine_professor` AS select `examine_record`.`year` AS `学年`,`examine_record`.`term` AS `学期`,`examine_record`.`tid` AS `工号`,`examine_record`.`name` AS `姓名`,`examine_record`.`status` AS `身份` from `examine_record` where (`examine_record`.`status` = '专家') order by `examine_record`.`year` desc,`examine_record`.`term`,`examine_record`.`status`,`examine_record`.`tid` */;

/*View structure for view examine_teacher */

/*!50001 DROP TABLE IF EXISTS `examine_teacher` */;
/*!50001 DROP VIEW IF EXISTS `examine_teacher` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `examine_teacher` AS select `examine_record`.`year` AS `学年`,`examine_record`.`term` AS `学期`,`examine_record`.`tid` AS `工号`,`examine_record`.`name` AS `姓名`,`examine_record`.`status` AS `身份` from `examine_record` where (`examine_record`.`status` = '教师') order by `examine_record`.`year` desc,`examine_record`.`term`,`examine_record`.`status`,`examine_record`.`tid` */;

/*View structure for view prize_view */

/*!50001 DROP TABLE IF EXISTS `prize_view` */;
/*!50001 DROP VIEW IF EXISTS `prize_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `prize_view` AS select `getPass`(`a`.`pass`) AS `是否通过`,`a`.`type` AS `类型`,`a`.`year` AS `学年`,`a`.`term` AS `学期`,`a`.`tid` AS `工号`,`b`.`tname` AS `教师姓名`,`a`.`pname` AS `比赛名称`,`a`.`level` AS `比赛级别`,`a`.`prank` AS `获奖`,`a`.`comment` AS `证明`,`a`.`result` AS `得分` from (`score_prize` `a` join `teacher` `b`) where (`a`.`tid` = `b`.`tid`) order by `a`.`pass`,`a`.`type` */;

/*View structure for view record_view */

/*!50001 DROP TABLE IF EXISTS `record_view` */;
/*!50001 DROP VIEW IF EXISTS `record_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `record_view` AS select `examine_record`.`year` AS `学年`,`examine_record`.`term` AS `学期`,`examine_record`.`tid` AS `教师工号`,`examine_record`.`name` AS `教师姓名`,`examine_record`.`status` AS `身份` from `examine_record` order by `examine_record`.`status` desc */;

/*View structure for view score_prof_view */

/*!50001 DROP TABLE IF EXISTS `score_prof_view` */;
/*!50001 DROP VIEW IF EXISTS `score_prof_view` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `score_prof_view` AS select `getPass`(`a`.`pass`) AS `是否通过`,`a`.`year` AS `学年`,`a`.`term` AS `学期`,`a`.`times` AS `评价次数`,`a`.`professor` AS `专家工号`,`b`.`tname` AS `专家姓名`,`a`.`tid` AS `教师工号`,`a`.`tname` AS `教师姓名`,`a`.`cname` AS `课程名称`,`a`.`address` AS `上课地点`,`a`.`time` AS `时间`,`a`.`content` AS `听课内容`,`a`.`result` AS `得分` from (`score_prof` `a` join `teacher` `b`) where (`a`.`professor` = `b`.`tid`) order by `a`.`pass` */;

/*View structure for view score_simple */

/*!50001 DROP TABLE IF EXISTS `score_simple` */;
/*!50001 DROP VIEW IF EXISTS `score_simple` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `score_simple` AS select `a`.`tid` AS `工号`,`a`.`tname` AS `教师姓名`,`getItemScore`(`b`.`tid`,1) AS `师德师风`,`getItemScore`(`b`.`tid`,2) AS `教学质量`,`getItemScore`(`b`.`tid`,3) AS `院(部)评价`,`getItemScore`(`b`.`tid`,4) AS `社会服务、实践教学能力`,`getItemScore`(`b`.`tid`,5) AS `其他扣分项和加分项`,`getWholeScore`(`a`.`tid`) AS `总分` from (`teacher` `a` join `score` `b`) where (`a`.`tid` = `b`.`tid`) group by `a`.`tid` */;

/*View structure for view teacherview */

/*!50001 DROP TABLE IF EXISTS `teacherview` */;
/*!50001 DROP VIEW IF EXISTS `teacherview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacherview` AS select `a`.`tid` AS `工号`,`a`.`tname` AS `教师姓名`,`a`.`identity` AS `教师身份`,`b`.`dname` AS `部门`,`c`.`oname` AS `教研室`,`a`.`comment` AS `备注`,`a`.`password` AS `密码` from ((`teacher` `a` join `department` `b`) join `office` `c`) where ((`a`.`did` = `b`.`did`) and (`a`.`oid` = `c`.`oid`)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
