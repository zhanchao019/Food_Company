/*
 Navicat Premium Data Transfer

 Source Server         : mysql5
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : db_jxc_swing

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 11/12/2019 21:26:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`  (
  `id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customername` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zip` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `connectionperson` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fax` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_customer
-- ----------------------------
INSERT INTO `tb_customer` VALUES ('001', '猿来入此', '201600', '上海 浦东新区', '13555555555', '猿来入此站长', '18888888888', '上海银行', '1888888888888888', 'llqqxf@163.com', '021-5656565', 1);
INSERT INTO `tb_customer` VALUES ('1', '张三', '734100', '北京', '1535283645', '小三', '16283548102', '中国银行', '74937264912', '11111@qq.com', '23641162', 1);
INSERT INTO `tb_customer` VALUES ('2', '李四', '384612', '上海', '18465739371', '小李', '18345429870', '建设银行', '82736459283', '22222@qq.com', '28374622', 2);
INSERT INTO `tb_customer` VALUES ('3', '王五', '793648', '天津', '18593648262', '小屋', '12874645263', '工商银行', '6480273645', '33333@qq.com', '36451272', 3);
INSERT INTO `tb_customer` VALUES ('4', '赵六', '658422', '南京', '12365421534', '小赵', '1986547382', '农业银行', '37465152635', '44444@qq.com', '48372651', 4);
INSERT INTO `tb_customer` VALUES ('5', '冯七', '673511', '广州', '17635218265', '小七', '1635482635328', '招商银行', '8374648362', '55555@qq.com', '37646553', 5);
INSERT INTO `tb_customer` VALUES ('6', '李增', '123123', '天水', '19294842739', '小增', '143274816', '光大银行', '7472893742', '66666@qq.com', '21737374', 6);
INSERT INTO `tb_customer` VALUES ('7', '陈迪', '342445', '兰州', '17328742362', '小陈', '173218436', '花旗银行', '6347246421', '77777@qq.com', '64732642', 7);
INSERT INTO `tb_customer` VALUES ('8', '蔡斌', '234723', '西安', '16387216342', '小蔡', '163821642', '信用社', '6274322513', '88888@qq.com', '54362453', 8);
INSERT INTO `tb_customer` VALUES ('阿三', '的飒飒 ', '201600', '撒旦', '13656565656', '阿三', '打撒地方', '发多少 是', '发多少打撒', 'llq@qq.com', '打撒', 0);

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods`  (
  `id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodsname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `produceplace` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `package` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `promitcode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float NOT NULL,
  `providerid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `providerid`(`providerid`) USING BTREE,
  CONSTRAINT `tb_goods_ibfk_1` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('1', '牙刷', '中国', '支', '有', '23876374', '374638261', '牙刷', 7, '1', 1);
INSERT INTO `tb_goods` VALUES ('2', '小游戏机', '日本', '个', '有', '31245324', '343123452', '游戏机', 33, '1', 1);
INSERT INTO `tb_goods` VALUES ('3', '小面包', '广州', '个', '有', '32848672', '324764243', '面包', 25, '1', 1);
INSERT INTO `tb_goods` VALUES ('4', '牙膏', '中国', '支', '有', '21377128', '231739832', '牙膏', 12, '2', 1);
INSERT INTO `tb_goods` VALUES ('5', '可贺', '上海市', '瓶', '有', '21321342', '213232147', '可乐', 3, '3', 1);

-- ----------------------------
-- Table structure for tb_inport
-- ----------------------------
DROP TABLE IF EXISTS `tb_inport`;
CREATE TABLE `tb_inport`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providerid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paytype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inporttime` datetime(0) NOT NULL,
  `operateperson` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  INDEX `providerid`(`providerid`) USING BTREE,
  CONSTRAINT `tb_inport_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_inport_ibfk_2` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_inport
-- ----------------------------
INSERT INTO `tb_inport` VALUES ('2', '1', '2', '2016-12-25 23:00:03', '2', 2, 2, '2', '1');
INSERT INTO `tb_inport` VALUES ('PI20190226141011', '1', '现金', '2019-02-26 14:10:11', 'admin', 2, 46, '哈哈哈', '3');
INSERT INTO `tb_inport` VALUES ('PI20190226170100', '1', '银行卡', '2019-02-26 17:01:00', 'admin', 2, 46, '运营', '3');
INSERT INTO `tb_inport` VALUES ('PI20190227133230', '1', '现金', '2019-02-27 13:32:30', 'admin', 5, 165, 'haha', '2');
INSERT INTO `tb_inport` VALUES ('PI20190227133317', '1', '银行卡', '2019-02-27 13:33:17', 'admin', 5, 35, '4', '1');

-- ----------------------------
-- Table structure for tb_operator
-- ----------------------------
DROP TABLE IF EXISTS `tb_operator`;
CREATE TABLE `tb_operator`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `power` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_operator
-- ----------------------------
INSERT INTO `tb_operator` VALUES ('admin', 'admin', 'shark', '操作员', '管理员');
INSERT INTO `tb_operator` VALUES ('sale', '123', 'shark', '操作员', '销售部');
INSERT INTO `tb_operator` VALUES ('刘裕圆', '123', 'shark', '操作员', '操作员');

-- ----------------------------
-- Table structure for tb_outport
-- ----------------------------
DROP TABLE IF EXISTS `tb_outport`;
CREATE TABLE `tb_outport`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providerid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paytype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `outporttime` datetime(0) NOT NULL,
  `operateperson` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  INDEX `providerid`(`providerid`) USING BTREE,
  CONSTRAINT `tb_outport_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_outport_ibfk_2` FOREIGN KEY (`providerid`) REFERENCES `tb_provider` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_outport
-- ----------------------------
INSERT INTO `tb_outport` VALUES ('3', '1', '3', '2016-12-25 23:00:29', '3', 3, 3, '3', '1');
INSERT INTO `tb_outport` VALUES ('PO20190227094232', '1', '现金', '2019-02-27 09:42:32', 'admin', 1, 23, 'ds速度', '3');

-- ----------------------------
-- Table structure for tb_provider
-- ----------------------------
DROP TABLE IF EXISTS `tb_provider`;
CREATE TABLE `tb_provider`  (
  `id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `providername` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zip` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `connectionperson` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fax` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_provider
-- ----------------------------
INSERT INTO `tb_provider` VALUES ('1', '嘉业有限公司', '456345', '吉林省', '74362840', '晓华', '19863548263', '建设银行', '37826367162', '23736@qq.com', '1', 1);
INSERT INTO `tb_provider` VALUES ('2', '好吃点食品公司', '328374', '广东省', '32176216', '合欢', '137817231', '光大银行', '1238681633', '23134@qq.com', '1', 1);
INSERT INTO `tb_provider` VALUES ('3', '沃达有限公司', '231344', '上海市', '21343321', '沃达', '123242422', '工商银行', '3213231242', '32423@qq.com', '1', 1);
INSERT INTO `tb_provider` VALUES ('发多少', '东方大厦', '201556', '发多少', '13545456556', '发多少', '发', '发多少', 'llq@123.com', ' 打撒', '发多少', 0);

-- ----------------------------
-- Table structure for tb_sales
-- ----------------------------
DROP TABLE IF EXISTS `tb_sales`;
CREATE TABLE `tb_sales`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paytype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salestime` datetime(0) NOT NULL,
  `operateperson` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerid`(`customerid`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `tb_sales_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_sales_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sales
-- ----------------------------
INSERT INTO `tb_sales` VALUES ('SI20190227101310', '001', '现金', '2019-02-27 10:13:10', 'admin', 1, 3, '人人', '5');

-- ----------------------------
-- Table structure for tb_salesback
-- ----------------------------
DROP TABLE IF EXISTS `tb_salesback`;
CREATE TABLE `tb_salesback`  (
  `id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paytype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salesbacktime` datetime(0) NOT NULL,
  `operateperson` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `price` float NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerid`(`customerid`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `tb_salesback_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_salesback_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_salesback
-- ----------------------------
INSERT INTO `tb_salesback` VALUES ('SB20190227101509', '4', '银行卡', '2019-02-27 10:15:09', 'admin', 7, 21, '76', '5');

-- ----------------------------
-- Table structure for tb_storagecheck
-- ----------------------------
DROP TABLE IF EXISTS `tb_storagecheck`;
CREATE TABLE `tb_storagecheck`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `tb_storagecheck_ibfk_1` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storagecheck
-- ----------------------------
INSERT INTO `tb_storagecheck` VALUES (1, '3', 11);
INSERT INTO `tb_storagecheck` VALUES (2, '1', 3);
INSERT INTO `tb_storagecheck` VALUES (3, '5', 6);
INSERT INTO `tb_storagecheck` VALUES (4, '2', 5);

-- ----------------------------
-- Procedure structure for pr_getAllCustomer
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllCustomer`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllCustomer`()
BEGIN
     select * from tb_customer where available!=0;
    END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
