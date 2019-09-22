/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : booksystem

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2019-08-26 10:02:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `lnum` char(10) NOT NULL,
  `rolenum` char(10) DEFAULT NULL,
  `lname` varchar(20) NOT NULL,
  `lsex` tinyint(1) NOT NULL,
  `lemail` varchar(20) NOT NULL,
  `lstate` int(11) NOT NULL,
  `llevel` int(11) NOT NULL,
  PRIMARY KEY (`lnum`),
  KEY `FK_containthree` (`rolenum`),
  CONSTRAINT `FK_containthree` FOREIGN KEY (`rolenum`) REFERENCES `role` (`rolenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '1', '鬼谷子', '1', 'admin@qq.com', '1', '0');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `anum` int(10) NOT NULL AUTO_INCREMENT,
  `aname` varchar(10) NOT NULL,
  PRIMARY KEY (`anum`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', '狄仁杰');
INSERT INTO `author` VALUES ('2', '张良');
INSERT INTO `author` VALUES ('16', '思履');
INSERT INTO `author` VALUES ('17', '李春保');
INSERT INTO `author` VALUES ('18', '丁越潮');
INSERT INTO `author` VALUES ('19', '凯');
INSERT INTO `author` VALUES ('20', '张嘉佳');
INSERT INTO `author` VALUES ('21', '测试');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bnum` char(4) NOT NULL,
  `collectionnum` varchar(20) DEFAULT NULL,
  `bstate` int(11) unsigned zerofill NOT NULL,
  `blnum` char(1) DEFAULT NULL,
  PRIMARY KEY (`bnum`),
  KEY `FK_Correspondingfour2` (`collectionnum`),
  KEY `FK_Correspondingfour` (`blnum`) USING BTREE,
  CONSTRAINT `FK_Correspondingfour` FOREIGN KEY (`blnum`) REFERENCES `branchlibraries` (`blnum`),
  CONSTRAINT `FK_Correspondingfour2` FOREIGN KEY (`collectionnum`) REFERENCES `bookdescrip` (`collectionnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('0001', 'a978-704-043', '00000000000', 'a');
INSERT INTO `book` VALUES ('0002', 'a978-704-043', '00000000000', 'a');
INSERT INTO `book` VALUES ('0003', 'b978-704-043', '00000000001', 'b');
INSERT INTO `book` VALUES ('0004', 'a978-777-777', '00000000000', 'a');
INSERT INTO `book` VALUES ('0006', 'a123-123-123', '00000000000', 'a');
INSERT INTO `book` VALUES ('0007', 'a777-777-777', '00000000000', 'a');
INSERT INTO `book` VALUES ('0009', 'a777-666-666', '00000000000', 'a');

-- ----------------------------
-- Table structure for bookdescrip
-- ----------------------------
DROP TABLE IF EXISTS `bookdescrip`;
CREATE TABLE `bookdescrip` (
  `collectionnum` varchar(20) NOT NULL,
  `ccnum` char(10) DEFAULT NULL,
  `pnum` char(10) DEFAULT NULL,
  `btnum` char(2) DEFAULT NULL,
  `ISBN` char(12) NOT NULL,
  `bname` varchar(100) NOT NULL,
  `wordnum` int(11) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  PRIMARY KEY (`collectionnum`),
  KEY `FK_classmode2` (`ccnum`),
  KEY `FK_containtype2` (`btnum`),
  KEY `FK_publish` (`pnum`),
  CONSTRAINT `FK_classmode2` FOREIGN KEY (`ccnum`) REFERENCES `chineseclass` (`ccnum`),
  CONSTRAINT `FK_containtype2` FOREIGN KEY (`btnum`) REFERENCES `borrowtype` (`btnum`),
  CONSTRAINT `FK_publish` FOREIGN KEY (`pnum`) REFERENCES `press` (`pnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookdescrip
-- ----------------------------
INSERT INTO `bookdescrip` VALUES ('a123-123-123', 'z', '7-01', 'aa', '123-123-123', 'Web编程技术', '200000', '49.60');
INSERT INTO `bookdescrip` VALUES ('a777-666-666', 'j', '7-02', 'a', '777-666-666', '测试', '2000', '39.90');
INSERT INTO `bookdescrip` VALUES ('a777-777-777', 'i', '7-04', 'aa', '777-777-777', '从你的全世界路过', '20000', '49.90');
INSERT INTO `bookdescrip` VALUES ('a978-704-043', 'k', '7-03', 'a', '978-704-043', '长安十二时辰', '630000', '39.60');
INSERT INTO `bookdescrip` VALUES ('a978-777-777', 'i', '7-02', 'a', '978-777-777', '山海经', '508000', '59.00');
INSERT INTO `bookdescrip` VALUES ('b978-704-043', 'k', '7-03', 'a', '978-704-043', '长安十二时辰', '630000', '39.60');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `rnum` char(10) NOT NULL,
  `bnum` char(4) NOT NULL,
  `snum` char(10) DEFAULT '',
  `bdate` date NOT NULL,
  `edate` date DEFAULT NULL,
  `restate` tinyint(1) DEFAULT NULL,
  `brstate` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rnum`,`bnum`,`bdate`),
  KEY `FK_Borrow2` (`bnum`),
  KEY `FK_Borrow3` (`snum`),
  CONSTRAINT `FK_Borrow` FOREIGN KEY (`rnum`) REFERENCES `reader` (`rnum`),
  CONSTRAINT `FK_Borrow2` FOREIGN KEY (`bnum`) REFERENCES `book` (`bnum`),
  CONSTRAINT `FK_Borrow3` FOREIGN KEY (`snum`) REFERENCES `semester` (`snum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('2017002', '0001', 'last1', '2019-05-01', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017002', '0003', 'last1', '2019-07-10', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017003', '0001', 'last1', '2019-07-10', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017003', '0001', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017003', '0003', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017003', '0004', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017003', '0006', 'last1', '2019-07-12', '2019-09-21', '1', '0');
INSERT INTO `borrow` VALUES ('2017004', '0001', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017004', '0004', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017008', '0003', 'last1', '2019-07-12', '2019-10-21', '0', '1');
INSERT INTO `borrow` VALUES ('2017008', '0006', 'last1', '2019-07-12', '2019-09-21', '1', '0');
INSERT INTO `borrow` VALUES ('2017009', '0001', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017009', '0004', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017011', '0001', 'last1', '2019-07-12', '2019-09-21', '1', '0');
INSERT INTO `borrow` VALUES ('2017011', '0004', 'last1', '2019-07-12', '2019-10-21', '0', '0');
INSERT INTO `borrow` VALUES ('2017011', '0007', 'last1', '2019-07-12', '2019-09-21', '1', '0');
INSERT INTO `borrow` VALUES ('2017011', '0009', 'last1', '2019-07-12', '2019-09-21', '1', '0');

-- ----------------------------
-- Table structure for borrowrequire
-- ----------------------------
DROP TABLE IF EXISTS `borrowrequire`;
CREATE TABLE `borrowrequire` (
  `rcnum` char(10) NOT NULL,
  `btnum` char(2) NOT NULL,
  `brnum` int(11) NOT NULL,
  `brdate` int(11) NOT NULL,
  `brrenew` int(11) NOT NULL,
  PRIMARY KEY (`rcnum`,`btnum`),
  KEY `FK_BorrowRequire2` (`btnum`),
  CONSTRAINT `FK_BorrowRequire` FOREIGN KEY (`rcnum`) REFERENCES `readerclass` (`rcnum`),
  CONSTRAINT `FK_BorrowRequire2` FOREIGN KEY (`btnum`) REFERENCES `borrowtype` (`btnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowrequire
-- ----------------------------
INSERT INTO `borrowrequire` VALUES ('1', 'a', '3', '30', '15');
INSERT INTO `borrowrequire` VALUES ('1', 'aa', '3', '15', '10');
INSERT INTO `borrowrequire` VALUES ('1', 'b', '3', '30', '15');
INSERT INTO `borrowrequire` VALUES ('1', 'bb', '3', '15', '10');
INSERT INTO `borrowrequire` VALUES ('2', 'a', '5', '60', '30');
INSERT INTO `borrowrequire` VALUES ('2', 'aa', '5', '15', '10');
INSERT INTO `borrowrequire` VALUES ('2', 'b', '5', '60', '30');
INSERT INTO `borrowrequire` VALUES ('2', 'bb', '5', '15', '10');
INSERT INTO `borrowrequire` VALUES ('3', 'a', '7', '90', '45');
INSERT INTO `borrowrequire` VALUES ('3', 'aa', '7', '15', '10');
INSERT INTO `borrowrequire` VALUES ('3', 'b', '7', '90', '45');
INSERT INTO `borrowrequire` VALUES ('3', 'bb', '7', '15', '10');

-- ----------------------------
-- Table structure for borrowtype
-- ----------------------------
DROP TABLE IF EXISTS `borrowtype`;
CREATE TABLE `borrowtype` (
  `btnum` char(2) NOT NULL,
  `btname` varchar(10) NOT NULL,
  PRIMARY KEY (`btnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowtype
-- ----------------------------
INSERT INTO `borrowtype` VALUES ('a', '中文图书');
INSERT INTO `borrowtype` VALUES ('aa', '中文图书（新）');
INSERT INTO `borrowtype` VALUES ('b', '外文图书');
INSERT INTO `borrowtype` VALUES ('bb', '外文图书（新）');

-- ----------------------------
-- Table structure for branchlibraries
-- ----------------------------
DROP TABLE IF EXISTS `branchlibraries`;
CREATE TABLE `branchlibraries` (
  `blnum` char(1) NOT NULL,
  `blname` varchar(20) NOT NULL,
  PRIMARY KEY (`blnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branchlibraries
-- ----------------------------
INSERT INTO `branchlibraries` VALUES ('a', '陈延奎图书馆');
INSERT INTO `branchlibraries` VALUES ('b', '陈嘉庚图书馆');

-- ----------------------------
-- Table structure for chineseclass
-- ----------------------------
DROP TABLE IF EXISTS `chineseclass`;
CREATE TABLE `chineseclass` (
  `ccnum` char(10) NOT NULL,
  `ccexplain` varchar(100) DEFAULT NULL,
  `ccsup` char(10) DEFAULT NULL,
  PRIMARY KEY (`ccnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chineseclass
-- ----------------------------
INSERT INTO `chineseclass` VALUES ('a', '马克思主义、列宁主义、毛泽东思想、邓小平理论', null);
INSERT INTO `chineseclass` VALUES ('b', '哲学、宗教', null);
INSERT INTO `chineseclass` VALUES ('c', '社会科学总论', null);
INSERT INTO `chineseclass` VALUES ('d', '政治、法律', null);
INSERT INTO `chineseclass` VALUES ('e', '军事', null);
INSERT INTO `chineseclass` VALUES ('f', '经济', null);
INSERT INTO `chineseclass` VALUES ('g', '文化、科学、教育、体育', null);
INSERT INTO `chineseclass` VALUES ('h', '语言、文字', null);
INSERT INTO `chineseclass` VALUES ('i', '文学', null);
INSERT INTO `chineseclass` VALUES ('j', '艺术', null);
INSERT INTO `chineseclass` VALUES ('k', '历史、地理', null);
INSERT INTO `chineseclass` VALUES ('n', '自然科学总论', null);
INSERT INTO `chineseclass` VALUES ('o', '天文学、地球科学', null);
INSERT INTO `chineseclass` VALUES ('q', '生物科学', null);
INSERT INTO `chineseclass` VALUES ('r', '医药、卫生', null);
INSERT INTO `chineseclass` VALUES ('s', '农业科学', null);
INSERT INTO `chineseclass` VALUES ('t', '工业技术', null);
INSERT INTO `chineseclass` VALUES ('u', '交通运输', null);
INSERT INTO `chineseclass` VALUES ('v', '航空、航天', null);
INSERT INTO `chineseclass` VALUES ('x', '环境科学、安全科学', null);
INSERT INTO `chineseclass` VALUES ('z', '综合性图书', null);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cnum` char(20) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `ctel` char(11) NOT NULL,
  PRIMARY KEY (`cnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('2017001', '集美大学', '13285970367');
INSERT INTO `company` VALUES ('2017002', '野区', '13285970367');
INSERT INTO `company` VALUES ('2017003', '中路', '13285970367');
INSERT INTO `company` VALUES ('2017004', '集美大学计算机', '12345678900');
INSERT INTO `company` VALUES ('2017008', '集美大学', '12345678910');
INSERT INTO `company` VALUES ('2017009', '地址', '12345678910');
INSERT INTO `company` VALUES ('2017011', '测试', '12345678910');

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press` (
  `pnum` char(10) NOT NULL,
  `pname` varchar(10) NOT NULL,
  `padress` varchar(100) NOT NULL,
  PRIMARY KEY (`pnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES ('7-01', '人民出版社', '北京');
INSERT INTO `press` VALUES ('7-02', '人民文学出版社', '北京');
INSERT INTO `press` VALUES ('7-03', '科学出版社', '北京');
INSERT INTO `press` VALUES ('7-04', '高等教育出版社', '北京');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `rnum` char(10) NOT NULL,
  `cnum` char(20) DEFAULT NULL,
  `rolenum` char(10) DEFAULT NULL,
  `rcnum` char(10) DEFAULT NULL,
  `rname` varchar(20) DEFAULT NULL,
  `rsex` tinyint(1) DEFAULT NULL,
  `remail` varchar(20) DEFAULT NULL,
  `rstate` int(11) DEFAULT NULL,
  `roverdue` int(11) DEFAULT NULL,
  `rlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`rnum`),
  KEY `FK_Correspondingtwo` (`rcnum`),
  KEY `FK_containone` (`rolenum`),
  KEY `FK_where` (`cnum`),
  CONSTRAINT `FK_containone` FOREIGN KEY (`rolenum`) REFERENCES `role` (`rolenum`),
  CONSTRAINT `FK_Correspondingtwo` FOREIGN KEY (`rcnum`) REFERENCES `readerclass` (`rcnum`),
  CONSTRAINT `FK_where` FOREIGN KEY (`cnum`) REFERENCES `company` (`cnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('2017001', '2017001', '0', '1', '卤蛋', '1', '201700111@qq.com', '1', '0', '1');
INSERT INTO `reader` VALUES ('2017002', '2017002', '0', '2', '韩信', '1', '2017002@qq.com', '1', '1', '2');
INSERT INTO `reader` VALUES ('2017003', '2017003', '0', '3', '诸葛亮', '1', '2017003@qq.com', '1', '0', '3');
INSERT INTO `reader` VALUES ('2017004', '2017004', '0', null, null, '0', '11111@qq.com', '1', '0', '1');
INSERT INTO `reader` VALUES ('2017008', '2017008', '0', null, null, '0', '123456@qq.com', '1', '0', '1');
INSERT INTO `reader` VALUES ('2017009', '2017009', '0', '1', '张三', '1', '348958520@qq.com', '1', '0', '1');
INSERT INTO `reader` VALUES ('2017011', '2017011', '0', '1', '测试', '1', '348958520@qq.com', '1', '0', '1');

-- ----------------------------
-- Table structure for readerclass
-- ----------------------------
DROP TABLE IF EXISTS `readerclass`;
CREATE TABLE `readerclass` (
  `rcnum` char(10) NOT NULL,
  `rcname` varchar(20) NOT NULL,
  `maxnum` int(11) NOT NULL,
  PRIMARY KEY (`rcnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readerclass
-- ----------------------------
INSERT INTO `readerclass` VALUES ('1', '学生', '4');
INSERT INTO `readerclass` VALUES ('2', '研究生', '5');
INSERT INTO `readerclass` VALUES ('3', '教师', '6');

-- ----------------------------
-- Table structure for readerfine
-- ----------------------------
DROP TABLE IF EXISTS `readerfine`;
CREATE TABLE `readerfine` (
  `rfnum` int(11) NOT NULL AUTO_INCREMENT,
  `rnum` char(10) DEFAULT NULL,
  `bnum` char(4) DEFAULT NULL,
  `rfmoney` decimal(3,1) NOT NULL,
  `reason` text NOT NULL,
  PRIMARY KEY (`rfnum`),
  UNIQUE KEY `FK_beoverdue` (`bnum`) USING BTREE,
  KEY `FK_beoverdue2` (`rnum`) USING BTREE,
  CONSTRAINT `FK_beoverdue` FOREIGN KEY (`bnum`) REFERENCES `book` (`bnum`),
  CONSTRAINT `FK_beoverdue2` FOREIGN KEY (`rnum`) REFERENCES `reader` (`rnum`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readerfine
-- ----------------------------
INSERT INTO `readerfine` VALUES ('120', '2017002', '0001', '2.2', '逾期');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rolenum` char(10) NOT NULL,
  `rolename` char(20) NOT NULL,
  PRIMARY KEY (`rolenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', '读者');
INSERT INTO `role` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester` (
  `snum` char(10) NOT NULL,
  `bdate` date NOT NULL,
  `edate` date NOT NULL,
  PRIMARY KEY (`snum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of semester
-- ----------------------------
INSERT INTO `semester` VALUES ('last1', '2019-02-25', '2019-07-13');
INSERT INTO `semester` VALUES ('nest1', '2019-08-25', '2020-01-18');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `blnum` char(1) NOT NULL,
  `collectionnum` varchar(20) NOT NULL,
  `stocknumtol` int(11) DEFAULT NULL,
  `instocknum` int(11) DEFAULT NULL,
  PRIMARY KEY (`blnum`,`collectionnum`),
  KEY `FK_Stock2` (`collectionnum`),
  CONSTRAINT `FK_Stock` FOREIGN KEY (`blnum`) REFERENCES `branchlibraries` (`blnum`),
  CONSTRAINT `FK_Stock2` FOREIGN KEY (`collectionnum`) REFERENCES `bookdescrip` (`collectionnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('a', 'a123-123-123', '1', '1');
INSERT INTO `stock` VALUES ('a', 'a777-666-666', '1', '1');
INSERT INTO `stock` VALUES ('a', 'a777-777-777', '1', '1');
INSERT INTO `stock` VALUES ('a', 'a978-704-043', '2', '2');
INSERT INTO `stock` VALUES ('a', 'a978-777-777', '1', '1');
INSERT INTO `stock` VALUES ('b', 'b978-704-043', '1', '0');

-- ----------------------------
-- Table structure for towrite
-- ----------------------------
DROP TABLE IF EXISTS `towrite`;
CREATE TABLE `towrite` (
  `bnum` char(4) NOT NULL,
  `rolename` char(20) DEFAULT NULL,
  `anum` int(10) DEFAULT NULL,
  PRIMARY KEY (`bnum`),
  KEY `FK_Towrite2` (`anum`),
  CONSTRAINT `FK_Towrite` FOREIGN KEY (`bnum`) REFERENCES `book` (`bnum`),
  CONSTRAINT `FK_Towrite2` FOREIGN KEY (`anum`) REFERENCES `author` (`anum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of towrite
-- ----------------------------
INSERT INTO `towrite` VALUES ('0001', '主编', '1');
INSERT INTO `towrite` VALUES ('0002', '主编', '1');
INSERT INTO `towrite` VALUES ('0003', '主编', '1');
INSERT INTO `towrite` VALUES ('0004', '主编1', '16');
INSERT INTO `towrite` VALUES ('0006', '主编', '18');
INSERT INTO `towrite` VALUES ('0007', '主编', '20');
INSERT INTO `towrite` VALUES ('0009', '主编', '21');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `usernum` char(10) NOT NULL,
  `rolenum` char(10) DEFAULT NULL,
  `userpwd` char(10) NOT NULL,
  PRIMARY KEY (`usernum`),
  KEY `FK_correspondingone` (`rolenum`),
  CONSTRAINT `FK_correspondingone` FOREIGN KEY (`rolenum`) REFERENCES `role` (`rolenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2017001', '0', '123456');
INSERT INTO `user` VALUES ('2017002', '0', '123456');
INSERT INTO `user` VALUES ('2017003', '0', '123456');
INSERT INTO `user` VALUES ('2017004', '0', '123456');
INSERT INTO `user` VALUES ('2017008', '0', '888888');
INSERT INTO `user` VALUES ('2017009', '0', '123456');
INSERT INTO `user` VALUES ('2017011', '0', '123456');
INSERT INTO `user` VALUES ('admin', '1', '000000');
