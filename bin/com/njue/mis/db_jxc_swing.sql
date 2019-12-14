/*
Navicat MySQL Data Transfer

Source Server         : mysql5
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : db_jxc_swing

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-14 21:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `id` char(10) NOT NULL,
  `customername` varchar(50) NOT NULL,
  `zip` char(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `connectionperson` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `bank` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('001', '猿来入此', '201600', '上海 浦东新区', '13555555555', '猿来入此站长', '18888888888', '上海银行', '1888888888888888', 'llqqxf@163.com', '021-5656565', '1');
INSERT INTO `tb_customer` VALUES ('1', '张三', '734100', '北京', '1535283645', '小三', '16283548102', '中国银行', '74937264912', '11111@qq.com', '23641162', '0');
INSERT INTO `tb_customer` VALUES ('2', '李四', '384612', '上海', '18465739371', '小李', '18345429870', '建设银行', '82736459283', '22222@qq.com', '28374622', '2');
INSERT INTO `tb_customer` VALUES ('252000', '展超', '252000', '山东大学威海', '15166585337', '312313', '13213', '中国人民银行', '123231', '123133@mail.com', '13213', '1');
INSERT INTO `tb_customer` VALUES ('3', '王五', '793648', '天津', '18593648262', '小屋', '12874645263', '工商银行', '6480273645', '33333@qq.com', '36451272', '3');
INSERT INTO `tb_customer` VALUES ('4', '赵六', '658422', '南京', '12365421534', '小赵', '1986547382', '农业银行', '37465152635', '44444@qq.com', '48372651', '4');
INSERT INTO `tb_customer` VALUES ('5', '冯七', '673511', '广州', '17635218265', '小七', '1635482635328', '招商银行', '8374648362', '55555@qq.com', '37646553', '5');
INSERT INTO `tb_customer` VALUES ('6', '李增', '123123', '天水', '19294842739', '小增', '143274816', '光大银行', '7472893742', '66666@qq.com', '21737374', '6');
INSERT INTO `tb_customer` VALUES ('7', '陈迪', '342445', '兰州', '17328742362', '小陈', '173218436', '花旗银行', '6347246421', '77777@qq.com', '64732642', '7');
INSERT INTO `tb_customer` VALUES ('8', '蔡斌', '234723', '西安', '16387216342', '小蔡', '163821642', '信用社', '6274322513', '88888@qq.com', '54362453', '8');
INSERT INTO `tb_customer` VALUES ('阿三', '的飒飒 ', '201600', '撒旦', '13656565656', '阿三', '打撒地方', '发多少 是', '发多少打撒', 'llq@qq.com', '打撒', '0');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` char(10) NOT NULL,
  `goodsname` varchar(50) NOT NULL,
  `produceplace` varchar(50) DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `package` varchar(50) DEFAULT NULL,
  `productcode` varchar(20) DEFAULT NULL,
  `promitcode` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` float NOT NULL,
  `providerid` char(10) NOT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `providerid` (`providerid`) USING BTREE,
  CONSTRAINT `tb_goods_ibfk_1` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('1', '牙刷', '中国', '支', '有', '23876374', '374638261', '牙刷', '2', '1', '1');
INSERT INTO `tb_goods` VALUES ('2', '小游戏机', '日本', '个', '有', '31245324', '343123452', '游戏机', '33', '1', '1');
INSERT INTO `tb_goods` VALUES ('3', '小面包', '广州', '个', '有', '32848672', '324764243', '面包', '25', '1', '1');
INSERT INTO `tb_goods` VALUES ('4', '牙膏', '中国', '支', '有', '21377128', '231739832', '牙膏', '12', '2', '1');
INSERT INTO `tb_goods` VALUES ('5', '可贺', '上海市', '瓶', '有', '21321342', '213232147', '可乐', '3', '3', '1');

-- ----------------------------
-- Table structure for tb_inport
-- ----------------------------
DROP TABLE IF EXISTS `tb_inport`;
CREATE TABLE `tb_inport` (
  `id` char(20) NOT NULL,
  `providerid` char(10) NOT NULL,
  `paytype` varchar(50) NOT NULL,
  `inporttime` datetime NOT NULL,
  `operateperson` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `goodsid` char(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `goodsid` (`goodsid`) USING BTREE,
  KEY `providerid` (`providerid`) USING BTREE,
  CONSTRAINT `tb_inport_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`),
  CONSTRAINT `tb_inport_ibfk_2` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_inport
-- ----------------------------
INSERT INTO `tb_inport` VALUES ('2', '1', '2', '2016-12-25 23:00:03', '2', '2', '2', '2', '1');
INSERT INTO `tb_inport` VALUES ('PI20190226141011', '1', '现金', '2019-02-26 14:10:11', 'admin', '2', '46', '哈哈哈', '3');
INSERT INTO `tb_inport` VALUES ('PI20190226170100', '1', '银行卡', '2019-02-26 17:01:00', 'admin', '2', '46', '运营', '3');
INSERT INTO `tb_inport` VALUES ('PI20190227133230', '1', '现金', '2019-02-27 13:32:30', 'admin', '5', '165', 'haha', '2');
INSERT INTO `tb_inport` VALUES ('PI20190227133317', '1', '银行卡', '2019-02-27 13:33:17', 'admin', '5', '35', '4', '1');

-- ----------------------------
-- Table structure for tb_operator
-- ----------------------------
DROP TABLE IF EXISTS `tb_operator`;
CREATE TABLE `tb_operator` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `power` char(10) NOT NULL,
  `dept` varchar(255) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_operator
-- ----------------------------
INSERT INTO `tb_operator` VALUES ('admin', 'admin', 'shark', '操作员', '管理员');
INSERT INTO `tb_operator` VALUES ('chengpin', '123', 'shark', '操作员', '成品库');
INSERT INTO `tb_operator` VALUES ('counter', '123', 'shark', '操作员', '财务部');
INSERT INTO `tb_operator` VALUES ('product', '123', 'shark', '操作员', '生产车间');
INSERT INTO `tb_operator` VALUES ('raw', '123', 'shark', '操作员', '原料库');
INSERT INTO `tb_operator` VALUES ('sale', '123', 'shark', '操作员', '销售部');
INSERT INTO `tb_operator` VALUES ('schedule', '123', 'shark', '操作员', '生产计划课');
INSERT INTO `tb_operator` VALUES ('刘裕圆', '123', 'shark', '操作员', '操作员');

-- ----------------------------
-- Table structure for tb_outport
-- ----------------------------
DROP TABLE IF EXISTS `tb_outport`;
CREATE TABLE `tb_outport` (
  `id` char(20) NOT NULL,
  `providerid` char(10) NOT NULL,
  `paytype` varchar(50) NOT NULL,
  `outporttime` datetime NOT NULL,
  `operateperson` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `goodsid` char(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `goodsid` (`goodsid`) USING BTREE,
  KEY `providerid` (`providerid`) USING BTREE,
  CONSTRAINT `tb_outport_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`),
  CONSTRAINT `tb_outport_ibfk_2` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_outport
-- ----------------------------
INSERT INTO `tb_outport` VALUES ('3', '1', '3', '2016-12-25 23:00:29', '3', '3', '3', '3', '1');
INSERT INTO `tb_outport` VALUES ('PO20190227094232', '1', '现金', '2019-02-27 09:42:32', 'admin', '1', '23', 'ds速度', '3');

-- ----------------------------
-- Table structure for tb_provider
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider`;
CREATE TABLE `tb_provider` (
  `id` char(10) NOT NULL,
  `providername` varchar(50) NOT NULL,
  `zip` char(6) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `connectionperson` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `bank` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_provider
-- ----------------------------
INSERT INTO `tb_provider` VALUES ('1', '嘉业有限公司', '456345', '吉林省', '74362840', '晓华', '19863548263', '建设银行', '37826367162', '23736@qq.com', '1', '1');
INSERT INTO `tb_provider` VALUES ('2', '好吃点食品公司', '328374', '广东省', '32176216', '合欢', '137817231', '光大银行', '1238681633', '23134@qq.com', '1', '1');
INSERT INTO `tb_provider` VALUES ('3', '沃达有限公司', '231344', '上海市', '21343321', '沃达', '123242422', '工商银行', '3213231242', '32423@qq.com', '1', '1');
INSERT INTO `tb_provider` VALUES ('发多少', '东方大厦', '201556', '发多少', '13545456556', '发多少', '发', '发多少', 'llq@123.com', ' 打撒', '发多少', '0');

-- ----------------------------
-- Table structure for tb_sales
-- ----------------------------
DROP TABLE IF EXISTS `tb_sales`;
CREATE TABLE `tb_sales` (
  `id` char(20) NOT NULL,
  `customerid` char(10) NOT NULL,
  `paytype` varchar(50) NOT NULL,
  `salestime` datetime NOT NULL,
  `operateperson` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `goodsid` char(10) NOT NULL,
  `state` varchar(255) NOT NULL DEFAULT '现货',
  PRIMARY KEY (`id`,`operateperson`,`state`) USING BTREE,
  KEY `customerid` (`customerid`) USING BTREE,
  KEY `goodsid` (`goodsid`) USING BTREE,
  CONSTRAINT `tb_sales_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`),
  CONSTRAINT `tb_sales_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_sales
-- ----------------------------
INSERT INTO `tb_sales` VALUES ('SI20191211101310', '001', '现金', '2019-12-11 10:13:10', 'admin', '1', '3', '人人', '5', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191213011706', '1', '支票', '2019-12-13 01:17:06', 'admin', '1', '3', 'nill', '5', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191213012059', '1', '现金', '2019-12-13 01:20:59', 'admin', '1', '7', '12313', '1', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191213012322', '1', '现金', '2019-12-13 01:23:22', 'admin', '1', '3', 'all', '5', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191214120901', '1', '现金', '2019-12-14 12:09:01', '', '3', '6', '应该时2*3', '1', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191214131022', '1', '现金', '2019-12-14 13:10:22', 'admin', '123131', '1477580', '', '4', '预定');
INSERT INTO `tb_sales` VALUES ('SI20191214132024', '2', '现金', '2019-12-14 13:20:24', '', '1', '33', '', '2', '现货');
INSERT INTO `tb_sales` VALUES ('SI20191214132101', '2', '现金', '2019-12-14 13:21:01', '', '1999', '5997', '', '5', '预定');
INSERT INTO `tb_sales` VALUES ('SI20191214132234', '1', '银行卡', '2019-12-14 13:22:34', '', '123112', '1477340', '', '4', '预定');
INSERT INTO `tb_sales` VALUES ('SI20191214202114', '3', '现金', '2019-12-14 20:21:14', '', '11', '132', '无', '4', '预定');

-- ----------------------------
-- Table structure for tb_salesback
-- ----------------------------
DROP TABLE IF EXISTS `tb_salesback`;
CREATE TABLE `tb_salesback` (
  `id` char(20) NOT NULL,
  `customerid` char(10) NOT NULL,
  `paytype` varchar(50) NOT NULL,
  `salesbacktime` datetime NOT NULL,
  `operateperson` varchar(50) NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `goodsid` char(10) NOT NULL,
  `state` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `customerid` (`customerid`) USING BTREE,
  KEY `goodsid` (`goodsid`) USING BTREE,
  CONSTRAINT `tb_salesback_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`),
  CONSTRAINT `tb_salesback_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_salesback
-- ----------------------------
INSERT INTO `tb_salesback` VALUES ('SB20190227101509', '4', '银行卡', '2019-02-27 10:15:09', 'admin', '7', '21', '76', '5', '现货');
INSERT INTO `tb_salesback` VALUES ('SB20191213135136', '2', '现金', '2019-12-13 13:51:36', 'admin', '1', '12', '2', '4', '现货');
INSERT INTO `tb_salesback` VALUES ('SB20191213135522', '1', '现金', '2019-12-13 13:55:22', 'admin', '2', '14', '', '1', '现货');
INSERT INTO `tb_salesback` VALUES ('SB20191214202245', '3', '现金', '2019-12-14 20:22:45', '', '20', '500', '', '3', null);

-- ----------------------------
-- Table structure for tb_storagecheck
-- ----------------------------
DROP TABLE IF EXISTS `tb_storagecheck`;
CREATE TABLE `tb_storagecheck` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` char(10) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `goodsid` (`goodsid`) USING BTREE,
  CONSTRAINT `tb_storagecheck_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_storagecheck
-- ----------------------------
INSERT INTO `tb_storagecheck` VALUES ('1', '3', '11');
INSERT INTO `tb_storagecheck` VALUES ('2', '1', '3');
INSERT INTO `tb_storagecheck` VALUES ('3', '5', '6');
INSERT INTO `tb_storagecheck` VALUES ('4', '2', '5');
INSERT INTO `tb_storagecheck` VALUES ('5', '4', '1');

-- ----------------------------
-- Procedure structure for pr_changeGoodsNumber
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_changeGoodsNumber`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_changeGoodsNumber`(in ky char(10),in num int)
BEGIN
	set @state = CONCAT(' UPDATE (tb_storagecheck) set  number=number+ '+ num +'  where tb_storagecheck.goodsid=\''+ky+ '\' and number+' + num+'>=0');
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllCustomer
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllCustomer`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllCustomer`()
BEGIN
     select * from tb_customer where available!=0;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllgoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllgoods`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllgoods`()
BEGIN
     select * from tb_goods;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllPortIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllPortIn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllPortIn`()
BEGIN
     select * from tb_inport;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllPortOut
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllPortOut`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllPortOut`()
BEGIN
     select * from tb_outport;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllProvider
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllProvider`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllProvider`()
BEGIN
     select * from tb_provider ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllSalesBack
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllSalesBack`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllSalesBack`()
BEGIN
     select * from tb_salesback;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllSalesIn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllSalesIn`()
BEGIN
     select * from tb_sales ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_getAllStorageGoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllStorageGoods`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllStorageGoods`()
BEGIN
     select * from tb_goods,tb_storagecheck where tb_goods.id=tb_storagecheck.id ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchCustomer
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchCustomer`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchCustomer`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_customer) where tb_customer.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchGoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchGoods`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchGoods`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_goods) where tb_goods.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchPortIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchPortIn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchPortIn`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_inport) where tb_inport.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchPortOut
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchPortOut`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchPortOut`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_outport) where tb_outport.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchProvider
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchProvider`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchProvider`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_provider) where tb_provider.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchSalesBack
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchSalesBack`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchSalesBack`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_salesback) where tb_salesback.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchSalesIn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchSalesIn`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_sales) where tb_sales.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_searchThroughTime
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchThroughTime`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchThroughTime`(in ky varchar(50),in val varchar(50) ,t1 datetime,t2 datetime)
BEGIN
	set @state = CONCAT(' select * from (tb_inport) where tb_inport.',ky,' = \'',val,'\' and inporttime BETWEEN ',t1,' and ',t2);
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `new_order_isxianhuo`;
DELIMITER ;;
CREATE TRIGGER `new_order_isxianhuo` BEFORE INSERT ON `tb_sales` FOR EACH ROW begin
	
	DECLARE now int;
	DECLARE num int;
 
	set now=new.number;
	set num =
	(select number 
	from tb_goods,tb_storagecheck
	where tb_goods.id=tb_storagecheck.goodsid and tb_goods.id = new.goodsid);

	if now > num
	then 
	set NEW.state='预定';
	else 
	set NEW.state='现货';
	end if;
	
end
;;
DELIMITER ;
