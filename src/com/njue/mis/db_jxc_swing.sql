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

 Date: 20/12/2019 14:06:12
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
INSERT INTO `tb_customer` VALUES ('1', '张三', '734100', '北京', '1535283645', '小三', '16283548102', '中国银行', '74937264912', '11111@qq.com', '23641162', 0);
INSERT INTO `tb_customer` VALUES ('100', '展', '252000', '啊倒萨', '13561468250', '啊啊', '8088211', '123', '123', 'q@qq.com', '21', 1);
INSERT INTO `tb_customer` VALUES ('2', '李四', '384612', '上海', '18465739371', '小李', '18345429870', '建设银行', '82736459283', '22222@qq.com', '28374622', 2);
INSERT INTO `tb_customer` VALUES ('252000', '展超', '252000', '山东大学威海', '15166585337', '312313', '13213', '中国人民银行', '123231', '123133@mail.com', '13213', 1);
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
  `rawmaterial` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
INSERT INTO `tb_goods`
VALUES ('1', '牙刷', '中国', '30', '小牙刷', '23876374', '374638261', '牙刷', 2, '1', 1);
INSERT INTO `tb_goods`
VALUES ('13', '123', '1', '30', 'ada', '1', '1', 'qe', 1, '1', 1);
INSERT INTO `tb_goods`
VALUES ('2', '小游戏机', '日本', '30', '电路板', '31245324', '343123452', '游戏机', 33, '1', 1);
INSERT INTO `tb_goods`
VALUES ('3', '小面包', '广州', '30', '面粉', '32848672', '324764243', '面包', 25, '1', 1);
INSERT INTO `tb_goods`
VALUES ('4', '牙膏', '中国', '30', '牙膏', '21377128', '231739832', '牙膏', 12, '2', 1);
INSERT INTO `tb_goods`
VALUES ('5', '可贺', '上海市', '30', '钱', '21321342', '213232147', '可乐', 3, '3', 1);
INSERT INTO `tb_goods`
VALUES ('6', '锤子', '茂名', '30', '杠精', '1', '1', '数据库再错我上去就是一锤子', 1, '1', 1);
INSERT INTO `tb_goods`
VALUES ('7', '鼠标', '山东', '30', '键盘侠', '1', '1', '看看触发器', 1, '1', 1);

-- ----------------------------
-- Table structure for tb_goodsschedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_goodsschedule`;
CREATE TABLE `tb_goodsschedule`  (
  `goodsid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `minval` int(1) NULL DEFAULT NULL,
  `aimval` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_goodsschedule
-- ----------------------------
INSERT INTO `tb_goodsschedule` VALUES ('1', 10, 30);
INSERT INTO `tb_goodsschedule` VALUES ('2', 10, 30);
INSERT INTO `tb_goodsschedule` VALUES ('3', 10, 30);
INSERT INTO `tb_goodsschedule` VALUES ('4', 10, 30);
INSERT INTO `tb_goodsschedule` VALUES ('5', 10, 30);

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
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `tb_operator` VALUES ('admin', 'admin', 'shark', '管理员', '管理员');
INSERT INTO `tb_operator` VALUES ('chengpin', '123', 'shark', '管理员', '成品库');
INSERT INTO `tb_operator` VALUES ('counter', '123', 'shark', '操作员', '财务部');
INSERT INTO `tb_operator` VALUES ('product', '123', 'shark', '操作员', '生产车间');
INSERT INTO `tb_operator` VALUES ('raw', '123', 'shark', '操作员', '原料库');
INSERT INTO `tb_operator` VALUES ('sale', '123', 'shark', '操作员', '销售部');
INSERT INTO `tb_operator` VALUES ('schedule', '123', 'shark', '操作员', '生产计划课');
INSERT INTO `tb_operator` VALUES ('zhanchao', '123', 'zhanchao', '管理员', '管理员');
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
-- Table structure for tb_producing
-- ----------------------------
DROP TABLE IF EXISTS `tb_producing`;
CREATE TABLE `tb_producing`
(
  `scheduleid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum`        int(32)                                                 NULL DEFAULT NULL,
  `finished`   int(32)                                                 NULL DEFAULT NULL,
  `unfinished` int(32)                                                 NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_producing
-- ----------------------------
INSERT INTO `tb_producing`
VALUES ('SI20191213012059', '1', 28, 28, 0);

-- ----------------------------
-- Table structure for tb_producingdetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_producingdetail`;
CREATE TABLE `tb_producingdetail`
(
  `scheduleid`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pici`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `producinglineid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num`             int(32)                                                 NULL DEFAULT NULL,
  `producedate`     datetime(0)                                             NULL DEFAULT NULL,
  `state`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_producingdetail
-- ----------------------------
INSERT INTO `tb_producingdetail`
VALUES ('SI20191213012059', '1', 'K3drgc8OOn', '2', 2, '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_producingdetail`
VALUES ('SI20191213012059', '1', 'XmMxDG0PXq', '4', 10, '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_producingdetail`
VALUES ('SI20191213012059', '1', '88UyoLEVAn', '1', 1, '2019-12-18 00:00:00', 'out');

-- ----------------------------
-- Table structure for tb_producingline
-- ----------------------------
DROP TABLE IF EXISTS `tb_producingline`;
CREATE TABLE `tb_producingline`
(
  `producinglineid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number`          int(32)                                                NULL DEFAULT NULL,
  PRIMARY KEY (`producinglineid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_producingline
-- ----------------------------
INSERT INTO `tb_producingline`
VALUES ('1', 0);
INSERT INTO `tb_producingline`
VALUES ('2', -3);
INSERT INTO `tb_producingline`
VALUES ('3', 0);
INSERT INTO `tb_producingline`
VALUES ('4', -2);
INSERT INTO `tb_producingline`
VALUES ('5', 0);
INSERT INTO `tb_producingline`
VALUES ('6', 0);

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
-- Table structure for tb_rawmaterial
-- ----------------------------
DROP TABLE IF EXISTS `tb_rawmaterial`;
CREATE TABLE `tb_rawmaterial`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_rawmaterial
-- ----------------------------
INSERT INTO `tb_rawmaterial` VALUES ('电路板', '2');
INSERT INTO `tb_rawmaterial` VALUES ('面粉', '3');
INSERT INTO `tb_rawmaterial` VALUES ('牙膏', '4');
INSERT INTO `tb_rawmaterial` VALUES ('钱', '5');
INSERT INTO `tb_rawmaterial` VALUES ('杠精', '6');
INSERT INTO `tb_rawmaterial` VALUES ('小牙刷', '1');
INSERT INTO `tb_rawmaterial` VALUES ('键盘侠', '7');
INSERT INTO `tb_rawmaterial` VALUES ('ada', '13');

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
  `number` int(32) NOT NULL,
  `price` float(1, 0) NOT NULL,
  `comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '现货',
  `paid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false',
  PRIMARY KEY (`id`, `operateperson`, `state`) USING BTREE,
  INDEX `customerid`(`customerid`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `tb_sales_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_sales_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sales
-- ----------------------------
INSERT INTO `tb_sales`
VALUES ('SI20191211101310', '1', '现金', '2019-12-11 10:13:10', 'admin', 2, 3, '人人', '1', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191213011706', '1', '支票', '2019-12-13 01:17:06', 'admin', 1, 3, 'nill', '5', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191213012059', '1', '现金', '2019-12-13 01:20:59', 'admin', 1, 7, '12313', '1', '现货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191213012322', '1', '现金', '2019-12-13 01:23:22', 'admin', 1, 3, 'all', '1', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214120901', '1', '现金', '2019-12-14 12:09:01', '', 3, 6, '应该时2*3', '1', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214131022', '1', '现金', '2019-12-14 13:10:22', 'admin', 123131, 1477580, '', '4', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214132024', '2', '现金', '2019-12-14 13:20:24', '', 1, 33, '', '2', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214132101', '2', '现金', '2019-12-14 13:21:01', '', 1999, 5997, '', '5', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214132234', '1', '银行卡', '2019-12-14 13:22:34', '', 10, 1477340, '', '1', '已出货', 'out');
INSERT INTO `tb_sales`
VALUES ('SI20191214202114', '3', '现金', '2019-12-14 20:21:14', '', 11, 132, '无', '4', '预定', 'true');
INSERT INTO `tb_sales`
VALUES ('SI20191214215854', '1', '银行卡', '2019-12-14 21:58:54', 'sale', 123, 3075, '12312', '3', '现货', 'true');

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
  `state` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerid`(`customerid`) USING BTREE,
  INDEX `goodsid`(`goodsid`) USING BTREE,
  CONSTRAINT `tb_salesback_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `tb_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_salesback_ibfk_2` FOREIGN KEY (`goodsid`) REFERENCES `tb_goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_salesback
-- ----------------------------
INSERT INTO `tb_salesback` VALUES ('SB20190227101509', '4', '银行卡', '2019-02-27 10:15:09', 'admin', 7, 21, '76', '5', '现货', 'false');
INSERT INTO `tb_salesback` VALUES ('SB20191213135136', '2', '现金', '2019-12-13 13:51:36', 'admin', 1, 12, '2', '4', '现货', 'false');
INSERT INTO `tb_salesback` VALUES ('SB20191213135522', '1', '现金', '2019-12-13 13:55:22', 'admin', 2, 14, '', '1', '现货', 'false');
INSERT INTO `tb_salesback` VALUES ('SB20191214202245', '3', '现金', '2019-12-14 20:22:45', '', 20, 500, '', '3', '预定', 'true');
INSERT INTO `tb_salesback` VALUES ('SB20191215155052', '1', '现金', '2019-12-15 15:50:52', 'admin', 1, 3, '1', '5', '预定', 'true');

-- ----------------------------
-- Table structure for tb_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_schedule`;
CREATE TABLE `tb_schedule`  (
  `scheduleid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sum` int(32) NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_schedule
-- ----------------------------
INSERT INTO `tb_schedule`
VALUES ('SI20191214132101', '5', 2023, '预定新订单库存补足', 'true');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132101', '5', 2023, '预定新订单库存补足', 'true');
INSERT INTO `tb_schedule`
VALUES ('SI20191214215854', '3', 152, '成品出库导致库存低于阈值', 'true');
INSERT INTO `tb_schedule`
VALUES ('SI20191213012059', '1', 28, '成品出库导致库存低于阈值', 'true');
INSERT INTO `tb_schedule`
VALUES ('SI20191213012059', '1', 29, '成品出库导致库存低于阈值', 'true');
INSERT INTO `tb_schedule`
VALUES ('SI20191213012322', '5', 25, '成品出库导致库存低于阈值', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191211101310', '1', 31, '成品出库导致库存低于阈值', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191211101310', '1', 33, '成品出库导致库存低于阈值', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191211101310', '1', 30, '成品出库导致库存低于阈值', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191213012322', '1', -90, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');
INSERT INTO `tb_schedule`
VALUES ('SI20191214132234', '1', -81, '预定新订单库存补足', 'false');

-- ----------------------------
-- Table structure for tb_storage
-- ----------------------------
DROP TABLE IF EXISTS `tb_storage`;
CREATE TABLE `tb_storage`
(
  `goodsid`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pici`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderid`     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT 'NULL',
  `producedate` datetime(0)                                             NULL DEFAULT NULL,
  `state`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storage
-- ----------------------------
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191211101310', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214202114', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'demo', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'SI20191214132234', '2019-12-18 00:00:00', 'out');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'XmMxDG0PXq', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', '88UyoLEVAn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'NULL', '2019-12-18 00:00:00', 'in');
INSERT INTO `tb_storage`
VALUES ('1', 'K3drgc8OOn', 'NULL', '2019-12-18 00:00:00', 'in');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_storagecheck
-- ----------------------------
INSERT INTO `tb_storagecheck`
VALUES (1, '3', 0);
INSERT INTO `tb_storagecheck`
VALUES (2, '1', 121);
INSERT INTO `tb_storagecheck`
VALUES (3, '5', 5);
INSERT INTO `tb_storagecheck` VALUES (4, '2', 5);
INSERT INTO `tb_storagecheck`
VALUES (5, '4', 10);

-- ----------------------------
-- Procedure structure for pr_decreaseProducingCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_decreaseProducingCount`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_decreaseProducingCount`(in tmp char(20))
BEGIN
  #Routine body goes here...
  update tb_producingline
  set number=number - 1
  where tb_producingline.producinglineid = tmp;
END
;;
delimiter ;

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

-- ----------------------------
-- Procedure structure for pr_getAllFinishedProducingLineDetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllFinishedProducingLineDetail`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllFinishedProducingLineDetail`()
BEGIN
  select *
  from tb_producingdetail
  where state = 'true';
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllgoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllgoods`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllgoods`()
BEGIN
     select * from tb_goods;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllOnTimeSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllOnTimeSalesIn`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllOnTimeSalesIn`()
BEGIN
  select *
  from tb_sales
  where tb_sales.state = '现货';
		 
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllOrderedSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllOrderedSalesIn`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllOrderedSalesIn`()
BEGIN
  select *
  from tb_sales
  where tb_sales.state = '预定';
		 
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllPortIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllPortIn`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllPortIn`()
BEGIN
     select * from tb_inport;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllPortOut
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllPortOut`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllPortOut`()
BEGIN
     select * from tb_outport;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllProducingLine
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllProducingLine`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllProducingLine`()
BEGIN
  select * from tb_producingline ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllProducingLineDetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllProducingLineDetail`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllProducingLineDetail`()
BEGIN
  select * from tb_producingdetail;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllProvider
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllProvider`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllProvider`()
BEGIN
     select * from tb_provider ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllSalesBack
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllSalesBack`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllSalesBack`()
BEGIN
     select * from tb_salesback;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllSalesIn`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllSalesIn`()
BEGIN
     select * from tb_sales ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllSchedule
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllSchedule`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllSchedule`()
BEGIN
     select * from tb_schedule;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllScheduleproducing
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllScheduleproducing`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_getAllScheduleproducing`()
BEGIN
  select * from tb_producing ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_getAllStorageGoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_getAllStorageGoods`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_getAllStorageGoods`()
BEGIN
     select * from tb_goods,tb_storagecheck where tb_goods.id=tb_storagecheck.id ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_increaseProducingCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_increaseProducingCount`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_increaseProducingCount`(in tmp char(20))
BEGIN
  #Routine body goes here...
  update tb_producingline
  set number=number + 1
  where tb_producingline.producinglineid = tmp;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_pay
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_pay`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_pay`(in orderid char(20))
BEGIN
  #Routine body goes here...
	update tb_sales
	set paid = 'false'
	where tb_sales.id=orderid;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchCustomer
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchCustomer`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchCustomer`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_customer) where tb_customer.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchGoods
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchGoods`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchGoods`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_goods) where tb_goods.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchPortIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchPortIn`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchPortIn`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_inport) where tb_inport.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchPortOut
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchPortOut`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchPortOut`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_outport) where tb_outport.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchProducingLineDetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchProducingLineDetail`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_searchProducingLineDetail`(in ky varchar(50), in val varchar(50))
BEGIN
  set @state = CONCAT(' select * from (tb_producingdetail) where tb_producingdetail.', ky, " = \'", val, "\' ");
  PREPARE tmp from @state;
  EXECUTE tmp;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchProvider
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchProvider`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchProvider`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_provider) where tb_provider.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchSalesBack
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchSalesBack`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchSalesBack`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_salesback) where tb_salesback.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchSalesIn
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchSalesIn`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchSalesIn`(in ky varchar(50),in val varchar(50) )
BEGIN
	set @state = CONCAT(' select * from (tb_sales) where tb_sales.',ky," = \'",val,"\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchSchedule
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchSchedule`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchSchedule`(in ky varchar(50),in val varchar(50) )
BEGIN
  set @state = CONCAT(' select * from (tb_schedule) where tb_schedule.', ky, " = \'", val, "\' ");
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_searchThroughTime
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_searchThroughTime`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_searchThroughTime`(in ky varchar(50),in val varchar(50) ,t1 datetime,t2 datetime)
BEGIN
	set @state = CONCAT(' select * from (tb_inport) where tb_inport.',ky,' = \'',val,'\' and inporttime BETWEEN ',t1,' and ',t2);
	PREPARE tmp from @state;
	EXECUTE tmp ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_updateProducingLineDetail
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_updateProducingLineDetail`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_updateProducingLineDetail`(in pici char(20))
BEGIN
  #Routine body goes here...
  update tb_producingdetail
  set producedate=CURDATE()
  where tb_producingdetail.pici = pici;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pr_updateProducingScheduleCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_updateProducingScheduleCount`;
delimiter ;;
CREATE
  DEFINER =`root`@`localhost` PROCEDURE `pr_updateProducingScheduleCount`(in pici VARCHAR(55))
BEGIN


  set @scheduleid = (SELECT (scheduleid) from tb_producingdetail where (tb_producingdetail.pici = pici));
  set @num = (SELECT num from tb_producingdetail where tb_producingdetail.pici = pici);
  set @finishednum = (select finished from tb_producing where tb_producing.scheduleid = scheduleid);
  set @unfinishednum = (select unfinished from tb_producing where tb_producing.scheduleid = scheduleid);


  update tb_producing
  set tb_producing.unfinished=@unfinishednum - @num
  where tb_producing.scheduleid = @scheduleid;


  update tb_producing
  set tb_producing.finished=@finishednum + @num
  where tb_producing.scheduleid = @scheduleid;

  COMMIT;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_goods
-- ----------------------------
DROP TRIGGER IF EXISTS `addraw`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `addraw` BEFORE INSERT ON `tb_goods` FOR EACH ROW BEGIN
	insert into tb_rawmaterial(`goodsid`,`name`) values(new.id,new.rawmaterial);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_sales
-- ----------------------------
DROP TRIGGER IF EXISTS `dinghuo`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `dinghuo` BEFORE INSERT ON `tb_sales` FOR EACH ROW BEGIN
DECLARE
	num INT;
DECLARE
	num1 INT;

SET num = new.number;

SET num1 = ( SELECT ( number ) FROM tb_storagecheck WHERE tb_storagecheck.goodsid = new.goodsid );
IF
	num > num1 THEN
		
		SET new.state = '预定';
	ELSE 
		SET new.state = '现货';
	
END IF;

END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table tb_sales
-- ----------------------------
DROP TRIGGER IF EXISTS `deal`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `deal` AFTER UPDATE ON `tb_sales` FOR EACH ROW BEGIN
	DECLARE
		num INT;
	DECLARE
		minnum INT;
	DECLARE
		aim INT;
	DECLARE
		STATE VARCHAR ( 50 );
	DECLARE
		orderid VARCHAR ( 50 );
	DECLARE
		goodsid VARCHAR ( 50 );
	DECLARE
		tmp1 INT;
	DECLARE
		tmp2 INT;
	DECLARE STR VARCHAR(255);
		
	
	SET goodsid = new.goodsid;
	
	SET orderid = new.id;
	
	SET tmp1 = (SELECT ( number ) FROM ( tb_storagecheck )  WHERE (tb_storagecheck.goodsid = goodsid) LIMIT 1 );
	
	SET tmp2 = ( SELECT ( aimval ) FROM tb_goodsschedule WHERE (tb_goodsschedule.goodsid = goodsid) LIMIT 1);
	
	SET STATE = NEW.state;
	
	SET num = new.number;
	
	SET minnum = ( SELECT ( minval ) FROM tb_goodsschedule WHERE (tb_goodsschedule.goodsid= goodsid) LIMIT 1);
	
	SET aim = tmp2 + num - tmp1;
	IF new.paid = 'true' THEN
		
		IF state = '预定' THEN
			SET STR = '预定新订单库存补足';
			INSERT INTO tb_schedule ( `scheduleid`, `goodsid`, `sum`,`comment` )
			VALUES
				(orderid, goodsid, aim ,STR) ;

    else
		SET tmp1 = (select (number) from tb_storagecheck WHERE tb_storagecheck.goodsid=goodsid);
		set tmp1 = tmp1-num;
			if tmp1<minnum
			then 
			SET STR = '成品出库导致库存低于阈值';
			set aim=tmp2-tmp1;
			INSERT INTO tb_schedule ( `scheduleid`, `goodsid`, `sum`,`comment` )
			VALUES
				( orderid, goodsid, aim ,STR);
			
			update tb_storagecheck
			set number = tmp1
			where tb_storagecheck.goodsid=goodsid;
			end if;

    set num = new.number;

    update tb_storage
    set tb_storage.orderid=new.id
    where (tb_storage.goodsid = new.goodsid and tb_storage.orderid = 'NULL')
    LIMIT num;


    END IF;
		END IF;
		
	

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
