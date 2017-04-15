/*
Navicat MySQL Data Transfer

Source Server         : 192.168.25.188
Source Server Version : 50635
Source Host           : 192.168.25.188:3306
Source Database       : xuexijia

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-24 17:13:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `xxj_book`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_book`;
CREATE TABLE `xxj_book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `book_name` varchar(200) NOT NULL COMMENT '书籍名称',
  `grade_id` int(11) DEFAULT NULL COMMENT '年级ID',
  `subject_id` int(11) DEFAULT NULL COMMENT '科目ID',
  `book_version` varchar(200) DEFAULT NULL COMMENT '版本',
  `book_type` int(1) NOT NULL COMMENT '类型：0：文科 1：理科',
  `book_status` int(1) NOT NULL COMMENT '状态：0在售1停售',
  `sort` int(11) NOT NULL COMMENT '排序',
  `created` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍表';

-- ----------------------------
-- Records of xxj_book
-- ----------------------------

-- ----------------------------
-- Table structure for `xxj_book_list`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_book_list`;
CREATE TABLE `xxj_book_list` (
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `book_list` varchar(255) NOT NULL COMMENT '书籍列表',
  `created` datetime NOT NULL COMMENT '创建时间',
  `express_company_name` varchar(50) NOT NULL COMMENT '公司名称',
  `express_company_serial_number` varchar(255) NOT NULL COMMENT '公司流水号',
  PRIMARY KEY (`order_id`),
  CONSTRAINT `xxj_book_list_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `xxj_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送书表';

-- ----------------------------
-- Records of xxj_book_list
-- ----------------------------

-- ----------------------------
-- Table structure for `xxj_content`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_content`;
CREATE TABLE `xxj_content` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '内容包ID',
  `content_name` varchar(50) NOT NULL COMMENT '内容包名称',
  `content_status` int(1) NOT NULL COMMENT '内容包状态：0:在线1:下线',
  `content_introduce` varchar(150) NOT NULL COMMENT '内容包介绍',
  `video_list` text NOT NULL COMMENT '视频列表',
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='内容包表';

-- ----------------------------
-- Records of xxj_content
-- ----------------------------
INSERT INTO `xxj_content` VALUES ('1', '语文', '0', '一年级语文', '1611,1612,1613,1614,1615,1616,1617,1618,1619,1620,1621,1622,1623,1624,1625,1626,1627,1628,1629,1630\r\n');
INSERT INTO `xxj_content` VALUES ('2', '数学', '0', '一年级数学', '1582,1583,1584,1585,1586,1587,1588,1589,1590,1591,1592,1593,1594,1595,1596,1597,1598,1599,1600,1601,1602,1603,1604,1605,1606,1607,1608,1609,1610\r\n');
INSERT INTO `xxj_content` VALUES ('3', '语文', '0', '初一语文', '355,356,357,358,359,360,362,363,364,365,366,367,368,594,632,1202,1230,1231,1232,1233,1234,1235,1236,1237,1238,1239,1240,1241,1242,1250,1341\r\n');
INSERT INTO `xxj_content` VALUES ('4', '数学', '0', '初一数学', '456,457,458,459,498,499,500,501,502,503,504,505,506,780,781,782,783,784,785,786,787,788,789,790,944,945,946,947,948,949,950,951,952,953,954,1050,1051,1052,1053,1054,1055,1056,1057,1504,1505,1506\r\n');
INSERT INTO `xxj_content` VALUES ('5', '英语', '0', '初一英语', '187,188,189,190,191,192,193,194,576,577,580,717,820\r\n');
INSERT INTO `xxj_content` VALUES ('6', '语文', '0', '高一语文', '455,460,461,462,463,464,465,466,517,518,519,520,521,522,523,524,525,526,722,726,729,736,737,739,963,1306,1307,1308,1309,1310,1311,1312,1313,1314,1315,1316,1317,1318,1319,1320,1321,1322,1323,1324,1325\r\n');
INSERT INTO `xxj_content` VALUES ('7', '数学 ', '0', '高一数学', '244,245,246,247,248,249,250,251,252,253,254,565,566,567,568,569,570,571,814,815,816,817,818,819,821,822,823,824,825,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,848,849,850,851,852,854,855,856,1459,1460\r\n');
INSERT INTO `xxj_content` VALUES ('8', '语文', '0', '二年级语文', '1631,1632,1633,1634,1635,1636,1637,1638,1639,1640,1641,1642,1643,1644,1645,1646,1647,1648\r\n');
INSERT INTO `xxj_content` VALUES ('9', '数学', '0', '二年级数学', '1649,1650,1651,1652,1653,1654,1655,1656,1657,1658,1659,1660,1661,1662,1663,1664,1665,1666,1667,1668,1669,1670,1671,1672,1673,1674,1675,1676\r\n');

-- ----------------------------
-- Table structure for `xxj_grade`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_grade`;
CREATE TABLE `xxj_grade` (
  `grade_id` int(11) NOT NULL COMMENT '年级ID',
  `grade_name` varchar(50) NOT NULL COMMENT '年级名称',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  PRIMARY KEY (`grade_id`),
  KEY `xued_id` (`xued_id`),
  CONSTRAINT `xxj_grade_ibfk_1` FOREIGN KEY (`xued_id`) REFERENCES `xxj_xued` (`xued_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='年级表';

-- ----------------------------
-- Records of xxj_grade
-- ----------------------------
INSERT INTO `xxj_grade` VALUES ('39781', '初一', '39779');
INSERT INTO `xxj_grade` VALUES ('39782', '初二', '39779');
INSERT INTO `xxj_grade` VALUES ('39783', '初三', '39779');
INSERT INTO `xxj_grade` VALUES ('39784', '高一', '39780');
INSERT INTO `xxj_grade` VALUES ('39785', '高二', '39780');
INSERT INTO `xxj_grade` VALUES ('39786', '高三', '39780');
INSERT INTO `xxj_grade` VALUES ('41688', '一年级', '41687');
INSERT INTO `xxj_grade` VALUES ('41689', '二年级', '41687');
INSERT INTO `xxj_grade` VALUES ('41690', '三年级', '41687');
INSERT INTO `xxj_grade` VALUES ('41691', '四年级', '41687');
INSERT INTO `xxj_grade` VALUES ('41692', '五年级', '41687');
INSERT INTO `xxj_grade` VALUES ('41693', '六年级', '41687');

-- ----------------------------
-- Table structure for `xxj_home`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_home`;
CREATE TABLE `xxj_home` (
  `home_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '首页标识',
  `home_name` varchar(50) NOT NULL COMMENT '图片名称',
  `home_image` varchar(200) NOT NULL COMMENT '图片地址',
  `home_location` int(11) NOT NULL COMMENT '图片位置',
  `UIID` int(11) NOT NULL COMMENT '图片ID',
  `effective` datetime NOT NULL COMMENT '有效时间',
  `expires` datetime NOT NULL COMMENT '过期时间',
  `params` varchar(255) NOT NULL COMMENT '参数：年级ID、科目ID、专题ID',
  PRIMARY KEY (`home_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='首页表';

-- ----------------------------
-- Records of xxj_home
-- ----------------------------

-- ----------------------------
-- Table structure for `xxj_notice`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_notice`;
CREATE TABLE `xxj_notice` (
  `id` varchar(1) NOT NULL COMMENT '公告ID',
  `notice` varchar(255) DEFAULT NULL COMMENT '公告信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告信息';

-- ----------------------------
-- Records of xxj_notice
-- ----------------------------
INSERT INTO `xxj_notice` VALUES ('1', '');

-- ----------------------------
-- Table structure for `xxj_order`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_order`;
CREATE TABLE `xxj_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `product_name` varchar(200) NOT NULL COMMENT '产品名称',
  `order_price` varchar(50) NOT NULL COMMENT '订单价格',
  `effective` datetime NOT NULL COMMENT '生效时间',
  `expires` datetime NOT NULL COMMENT '过期时间',
  `buy_type` int(1) NOT NULL COMMENT '购买类型：0:指定日期1:包月2:半年3:全年',
  `is_cancel` int(1) DEFAULT NULL COMMENT '退订：0:未退订1:已退订',
  `serial_number` varchar(255) DEFAULT NULL COMMENT '流水号',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付类型：',
  `pay_status` int(1) DEFAULT NULL COMMENT '支付状态：0:成功1:失败',
  `pay_desc` varchar(200) DEFAULT NULL COMMENT '支付结果描述',
  PRIMARY KEY (`order_id`),
  KEY `product_id` (`product_id`) USING BTREE,
  CONSTRAINT `xxj_order_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `xxj_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of xxj_order
-- ----------------------------
INSERT INTO `xxj_order` VALUES ('1', '3', '1', '1', '一年级全科套餐', '24', '2011-01-09 11:47:39', '2018-02-09 11:47:50', '1', '0', '323232323232', '1', '0', null);
INSERT INTO `xxj_order` VALUES ('2', '3', '7', '1', '一年级单科套餐', '299', '2017-01-03 11:51:07', '2017-06-22 11:51:20', '1', '0', '43434343434', '1', '0', null);
INSERT INTO `xxj_order` VALUES ('3', '3', '1', '1', '12121', '399', '2014-01-10 12:22:30', '2015-01-22 12:22:41', '1', '0', '343434', '1', '0', null);

-- ----------------------------
-- Table structure for `xxj_point`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_point`;
CREATE TABLE `xxj_point` (
  `point_id` int(11) NOT NULL COMMENT '知识点ID',
  `point_name` varchar(50) NOT NULL COMMENT '知识点名称',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `grade_id` int(11) NOT NULL COMMENT '年级ID',
  `subject_id` int(11) NOT NULL COMMENT '科目ID',
  `term` int(1) NOT NULL COMMENT '学期：1:上学期2:下学期',
  `sort` int(11) NOT NULL COMMENT '排序',
  `params` varchar(255) NOT NULL COMMENT '相关推荐（产品、知识点）',
  PRIMARY KEY (`point_id`),
  KEY `xued_id` (`xued_id`),
  KEY `grade_id` (`grade_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `xxj_point_ibfk_1` FOREIGN KEY (`xued_id`) REFERENCES `xxj_xued` (`xued_id`),
  CONSTRAINT `xxj_point_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `xxj_grade` (`grade_id`),
  CONSTRAINT `xxj_point_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `xxj_subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='知识点表';

-- ----------------------------
-- Records of xxj_point
-- ----------------------------
INSERT INTO `xxj_point` VALUES ('39986', '语言运用（上）', '39779', '39781', '39787', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39987', '阅读（上）', '39779', '39781', '39787', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39988', '写作（上）', '39779', '39781', '39787', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39989', '语言运用（下）', '39779', '39781', '39787', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39990', '文学积累（下）', '39779', '39781', '39787', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39991', '阅读（下）', '39779', '39781', '39787', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39992', '写作（下）', '39779', '39781', '39787', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39993', '有理数', '39779', '39781', '39788', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39994', '整式', '39779', '39781', '39788', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39995', '一元一次方程', '39779', '39781', '39788', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39996', '几何图形初步', '39779', '39781', '39788', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('39997', '相交线与平行线', '39779', '39781', '39788', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39998', '实数', '39779', '39781', '39788', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('39999', '平面直角坐标系', '39779', '39781', '39788', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40000', '二元一次方程组', '39779', '39781', '39788', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40001', '不等式与不等式组', '39779', '39781', '39788', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40005', '文学积累（上）', '39779', '39782', '39790', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40006', '阅读（上）', '39779', '39782', '39790', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40007', '语言运用（上）', '39779', '39782', '39790', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40008', '写作（上）', '39779', '39782', '39790', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40009', '文学积累（下）', '39779', '39782', '39790', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40010', '阅读（下）', '39779', '39782', '39790', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40011', '写作（下）', '39779', '39782', '39790', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40012', '一次函数', '39779', '39782', '39791', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40013', '全等三角形', '39779', '39782', '39791', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40014', '对称轴', '39779', '39782', '39791', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40015', '整式', '39779', '39782', '39791', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40016', '平行四边形', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40017', '勾股定理', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40018', '三角形', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40019', '分式', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40020', '二次函数', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40021', '数据的分析', '39779', '39782', '39791', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40025', '机械运动', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40026', '声现象', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40027', '物态变化', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40028', '光现象', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40029', '透镜及其应用', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40030', '质量与密度', '39779', '39782', '39793', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40031', '力', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40032', '运动和力', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40033', '压强', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40034', '浮力', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40035', '功和机械能', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40036', '简单机械', '39779', '39782', '39793', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40037', '语言运用（上）', '39779', '39783', '39794', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40038', '文学积累（上）', '39779', '39783', '39794', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40039', '阅读（上）', '39779', '39783', '39794', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40040', '写作（上）', '39779', '39783', '39794', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40041', '文学积累（下）', '39779', '39783', '39794', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40042', '阅读（下）', '39779', '39783', '39794', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40043', '写作（下）', '39779', '39783', '39794', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40044', '二次根式', '39779', '39783', '39795', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40045', '一元二次方程', '39779', '39783', '39795', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40046', '旋转', '39779', '39783', '39795', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40047', '圆', '39779', '39783', '39795', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40048', '概率初步', '39779', '39783', '39795', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40049', '反比例函数', '39779', '39783', '39795', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40050', '相似', '39779', '39783', '39795', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40051', '三角函数', '39779', '39783', '39795', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40052', '投影与视图', '39779', '39783', '39795', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40057', '内能', '39779', '39783', '39797', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40058', '内能的利用', '39779', '39783', '39797', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40059', '电流和电路', '39779', '39783', '39797', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40060', '电压 电阻', '39779', '39783', '39797', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40061', '欧姆定律', '39779', '39783', '39797', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40062', '电功率', '39779', '39783', '39797', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40063', '生活用电', '39779', '39783', '39797', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40064', '电与磁', '39779', '39783', '39797', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40065', '信息的传递', '39779', '39783', '39797', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40066', '能源与可持续发展', '39779', '39783', '39797', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40067', '走进化学世界', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40068', '我们周围的空气', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40069', '物质构成的奥秘', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40070', '自然界的水', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40071', '化学方程式', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40072', '碳和碳的氧化物', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40073', '燃料及利用', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40074', '金属和金属材料', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40075', '溶液', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40076', '酸和碱', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40077', '盐、化肥', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40078', '化学与生活', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40079', '化学总复习专题（上）', '39779', '39783', '39798', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('40080', '化学总复习专题（下）', '39779', '39783', '39798', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('40082', '重点篇目（必修1）', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40083', '重点篇目（必修2）', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40084', '重点篇目（必修3）', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40085', '重点篇目（必修4）', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40086', '语文学习方法', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40088', '记叙文写作', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40089', '散文写作', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40090', '议论文写作', '39780', '39784', '39835', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40091', '集合与函数概念', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40092', '基本初等函数', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40093', '空间几何体', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40094', '算法初步', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40095', '统计', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40096', '概率', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40097', '三角函数', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40098', '平面向量', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40099', '三角恒等变换', '39780', '39784', '39836', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40104', '质点的直线运动', '39780', '39784', '39838', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40105', '相互作用与牛顿定律', '39780', '39784', '39838', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40106', '曲线运动', '39780', '39784', '39838', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40107', '万有引力与航天', '39780', '39784', '39838', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40108', '机械能及其守恒定律', '39780', '39784', '39838', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40109', '化学计量、混合物的分离和提纯', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40110', '化学物质及其变化', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40111', '金属及其化合物', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40112', '非金属及其化合物', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40113', '物质结构、元素周期律', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40114', '化学反应与能量', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40115', '有机化合物', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40116', '化学与自然资源的开发利用', '39780', '39784', '39839', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40117', '走进细胞', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40118', '组成细胞的分子', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40119', '细胞的基本结构', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40120', '细胞的物质输入和输出', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40121', '细胞的能量供应和利用', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40122', '细胞的生命历程', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40123', '遗传的基本规律', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40124', '遗传的细胞基础', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40125', '遗传的分子基础', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40126', '生物的变异', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40127', '生物的进化', '39780', '39784', '39840', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40128', '行星地球', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40129', '地球上的大气', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40130', '地球上的水', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40131', '地表形态的塑造', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40132', '自然地理环境的整体性与差异性', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40133', '人口的变化', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40134', '城市与城市化', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40135', '农业地域的形成与发展', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40136', '工业地域的形成与发展', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40137', '交通运输布局及其影响', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40138', '人类与地理环境的协调发展', '39780', '39784', '39843', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40139', '生活与消费', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40140', '生产、劳动与经营', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40141', '收入与分配', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40142', '发展社会主义市场经济', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40143', '经济全球化与对外开放', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40148', '古代中国的政治制度', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40149', '古代希腊罗马的政治制度', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40150', '近代西方资本主义政治制度的确立与发展', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40151', '近代中国反侵略、求民主的潮流', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40152', '从科学社会主义理论到社会主义制度的建立', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40153', '现代中国的政治建设与祖国统一', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40154', '现代中国的对外关系', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40155', '当今世界政治格局的多极化趋势', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40156', '古代中国经济的基本结构与特点', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40157', '资本主义世界的市场的形成和发展', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40158', '近代中国经济结构的变动与资本主义的曲折发展', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40159', '中国特色社会主义建设的道路', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40160', '中国近现代社会生活的变迁', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40161', '世界资本主义经济政策的调整', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40162', '苏联的社会主义建设', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40163', '世界经济的全球化趋势', '39780', '39784', '39842', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40167', '重点篇目（必修5）', '39780', '39785', '39844', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40168', '冠词', '39779', '39781', '39789', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40169', '名词', '39779', '39781', '39789', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40170', '代词', '39779', '39781', '39789', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40171', '介词', '39779', '39781', '39789', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40172', '连词', '39779', '39781', '39789', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40173', '形容词', '39779', '39782', '39792', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40174', '副词', '39779', '39782', '39792', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40175', '数词', '39779', '39782', '39792', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40176', '情态动词', '39779', '39782', '39792', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40177', '动词的时态和语态', '39779', '39782', '39792', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40179', '主谓一致', '39779', '39783', '39796', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40180', '简单句', '39779', '39783', '39796', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40181', '倒装句', '39779', '39783', '39796', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40182', '非谓语动词', '39779', '39783', '39796', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40183', '复合句', '39779', '39783', '39796', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40184', '定语从句', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40185', '状语从句', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40186', '情态动词', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40187', '短语动词', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40188', '动词不定式', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40189', '易错的几种时态', '39780', '39784', '39837', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40190', '重点篇目（选修）', '39780', '39785', '39844', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40191', '解三角形', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40192', '数列', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40193', '不等式', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40197', '常用逻辑用语', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40198', '圆锥曲线与方程', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40199', '空间向量与立体几何', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40201', '导数及其应用', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40202', '推理与证明', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40203', '数系的扩充与复数的引入', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40205', '计数原理', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40206', '随机变量及其分布', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40207', '统计案例', '39780', '39785', '39845', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40212', '动名词', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40213', '分词', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40214', '虚拟语气', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40215', '倒装', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40216', '主谓一致', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40217', '名词性从句', '39780', '39785', '39846', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40218', '静电场', '39780', '39785', '39847', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40219', '恒定电流', '39780', '39785', '39847', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40220', '磁场', '39780', '39785', '39847', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40221', '电磁感应', '39780', '39785', '39847', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40222', '交流电与变压器', '39780', '39785', '39847', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40223', '关注营养平衡', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40224', '促进身心健康', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40225', '探索生活材料', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40226', '保护生存环境', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40227', '化学反应与能量', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40228', '化学反应速率和化学平衡', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40229', '水溶液中的离子平衡', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40230', '电化学基础', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40231', '有机化学基础', '39780', '39785', '39848', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40232', '内环境与稳态', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40233', '动物生命活动的调节', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40234', '植物生命活动的调节', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40235', '种群和群落', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40236', '生态与环境', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40237', '微生物的利用', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40238', '酶的应用', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40239', '生物技术在食品加工中的应用', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40240', '生物技术在其他方面的应用', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40241', '基因工程', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40242', '克隆技术', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40243', '胚胎工程', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40244', '生物技术的安全性和伦理问题', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40245', '生态工程', '39780', '39785', '39849', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40246', '人口的变化', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40247', '地理环境与区域发展', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40248', '区域生态环境建设', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40249', '区域自然资源综合开发利用', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40250', '区域经济发展', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40251', '区际联系与区域协调发展', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40252', '选修精讲', '39780', '39785', '39852', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40253', '文化与社会', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40254', '文化传承与创新', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40255', '中华文化与民族精神', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40256', '发展中国特色社会主义文化', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40257', '生活智慧与时代精神', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40258', '探索世界与追求真理', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40259', '思想方法与创新意识', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40260', '认识社会与价值选择', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40262', '选修2', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40263', '选修3', '39780', '39785', '39850', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40264', '中国传统文化主流思想的演变', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40265', '西方人文精神的起源及其发展', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40266', '古代中国的科学技术与文学艺术', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40267', '近代以来世界的科学发展历程', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40268', '近代中国的思想解放潮流', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40269', '20世纪以来中国重大思想理论成果', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40270', '现代中国的科技、教育与文学艺术', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40271', '19世纪以来的世界文学艺术', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40272', '历史上重大改革回眸', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40273', '中外历史人物评说', '39780', '39785', '39851', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40275', '公民的政治生活', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40276', '为人民服务的政府', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40277', '发展社会主义民主政治', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40278', '当代国际社会', '39780', '39784', '39841', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40280', '高考指导', '39780', '39786', '39853', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40281', '语言运用', '39780', '39786', '39853', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40282', '古诗词鉴赏', '39780', '39786', '39853', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40283', '阅读', '39780', '39786', '39853', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40284', '写作', '39780', '39786', '39853', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40286', '集合与命题', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40287', '函数', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40288', '三角函数', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40289', '解三角形', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40290', '数列', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40291', '圆锥曲线与方程', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40293', '介词', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40294', 'It的用法', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40295', 'There be结构', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40296', '省略句', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40297', '五种基本句型', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40298', '非谓语动词', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40300', '阅读理解', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40303', '写作', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40304', '完形填空', '39780', '39786', '39855', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40306', '一轮复习', '39780', '39786', '39856', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40308', '基本概念', '39780', '39786', '39857', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40309', '基础理论', '39780', '39786', '39857', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40310', '常见无机物及其应用', '39780', '39786', '39857', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40311', '化学实验', '39780', '39786', '39857', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40312', '有机化学基础', '39780', '39786', '39857', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40314', '分子与细胞', '39780', '39786', '39858', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40315', '遗传与进化', '39780', '39786', '39858', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40316', '生态与环境', '39780', '39786', '39858', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40317', '生物技术实践', '39780', '39786', '39858', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40318', '现代生物科技专题', '39780', '39786', '39858', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40320', '人口的变化', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40321', '城市与城市化', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40322', '交通运输布局及其影响', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40323', '农业区位因素', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40324', '工业', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40325', '行星地球', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40326', '地球上的大气', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40327', '地球上的水', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40328', '自然地理环境的整体性与差异性', '39780', '39786', '39861', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40330', '古代中国', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40331', '古代希腊、罗马', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40332', '近代世界', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40333', '近代中国', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40334', '现代世界', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40335', '现代中国', '39780', '39786', '39860', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40685', '议论文写作', '39780', '39785', '39844', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('40686', '文学类作文', '39780', '39785', '39844', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41280', '立体几何', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41342', '导数', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41343', '概率统计', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41344', '不等式', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41345', '复数', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41346', '算法初步', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41347', '排列组合', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41348', '几何证明', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41349', '统计案例', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41350', '积分与正态分布', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41351', '参数方程与极坐标', '39780', '39786', '39854', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41774', '拼音', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41775', '准备课', '41687', '41688', '41698', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41776', '1~20的认识和加减法', '41687', '41688', '41698', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41778', '100以内数的认识', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41779', '认识人民币', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41780', '100以内的加法和减法(一）', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41781', '位置', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41782', '认识图形', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41783', '分类与整理', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41784', '找规律', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41785', '偏旁、部首、笔画、笔顺', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41786', '字的音、形、义', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41787', '常见词语', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41788', '叠词', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41789', '连词成句', '41687', '41688', '41694', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41790', '儿歌、小短文阅读', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41791', '古诗词（一）', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41792', '名著名篇导读', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41793', '看图说话', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41794', '续说故事', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41795', '情景交际', '41687', '41688', '41694', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41796', '100以内的加法和减法', '41687', '41689', '41703', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41797', '表内乘法', '41687', '41689', '41703', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41798', '认识时间', '41687', '41689', '41703', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41799', '表内除法', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41800', '混合运算', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41801', '有余数的除法', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41802', '万以内数的认识', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41803', '克和千克', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41804', '长度单位', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41805', '角的初步认识', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41806', '观察物体', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41807', '图形的运动', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41808', '数学广角', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41809', '数据收集整理', '41687', '41689', '41703', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41810', '字的音、形、义', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41811', '查字典', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41812', '字与词', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41813', '标点符号', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41814', '句式转换', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41816', '古诗词（二）', '41687', '41689', '41702', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41817', '名著名篇导读', '41687', '41689', '41702', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41818', '口语交际', '41687', '41689', '41702', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41819', '写话', '41687', '41689', '41702', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41820', '时间的认识', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41821', '万以内的加法和减法', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41822', '测量', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41823', '倍的认识', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41824', '多位数乘一位数', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41825', '分数的初步认识', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41826', '除数是一位数的除法', '41687', '41690', '41712', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41836', '字的音、形、义', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41837', '四字词语或成语', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41840', '关联词语', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41841', '句式转换', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41842', '修改病句', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41843', '修辞手法', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41844', '标点符号', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41845', '名言警句谚语', '41687', '41690', '41710', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41846', '阅读方法介绍', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41847', '古诗词（三）', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41848', '寓言', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41849', '神话', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41850', '记叙文写作', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41851', '想象作文', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41852', '应用文写作', '41687', '41690', '41710', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41853', '字母与语音', '41687', '41690', '41714', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41854', '词汇', '41687', '41690', '41714', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41855', '陈述句', '41687', '41690', '41714', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41856', '一般疑问句', '41687', '41690', '41714', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41857', '特殊疑问句', '41687', '41690', '41714', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41858', '听力', '41687', '41690', '41714', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41859', '阅读理解', '41687', '41690', '41714', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41860', '书面表达', '41687', '41690', '41714', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41861', '巧填算符', '41687', '41690', '41716', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41862', '和倍问题和差倍问题', '41687', '41690', '41716', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41863', '枚举法', '41687', '41690', '41716', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41866', '大数的认识', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41867', '公顷和平方千米', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41868', '三位数乘两位数', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41869', '除数是两位数的除法', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41870', '四则运算', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41871', '运算定律', '41687', '41691', '41725', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41872', '小数的意义和性质', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41873', '小数的加法和减法', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41874', '角的度量', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41875', '平行四边形和梯形', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41876', '观察物体', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41877', '三角形', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41878', '图形的运动', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41879', '条形统计图', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41880', '数学广角', '41687', '41691', '41725', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41881', '字的音、形、义', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41882', '四字词语或成语', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41883', '多义词', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41885', '关联词语', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41886', '句式转换', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41887', '修改病句', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41888', '修辞手法', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41889', '标点符号', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41890', '名言警句谚语', '41687', '41691', '41724', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41891', '阅读方法介绍', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41892', '古诗词（四）', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41893', '中外民间故事、神话故事', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41894', '记叙文写作', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41895', '应用文写作', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41896', '想象作文写作', '41687', '41691', '41724', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41897', '语音', '41687', '41691', '41726', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41898', '词汇', '41687', '41691', '41726', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41899', '陈述句', '41687', '41691', '41726', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41900', '一般疑问句', '41687', '41691', '41726', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41901', '特殊疑问句', '41687', '41691', '41726', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41902', '祈使句', '41687', '41691', '41726', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41903', '听力', '41687', '41691', '41726', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41904', '阅读理解', '41687', '41691', '41726', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41905', '书面表达', '41687', '41691', '41726', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41906', '妙用假设法', '41687', '41691', '41727', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41907', '年龄问题', '41687', '41691', '41727', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41908', '有趣的竖式谜', '41687', '41691', '41727', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41911', '小数乘法', '41687', '41692', '41729', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41912', '小数除法', '41687', '41692', '41729', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41913', '简易方程', '41687', '41692', '41729', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41914', '因数与倍数', '41687', '41692', '41729', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41915', '分数的意义和性质', '41687', '41692', '41729', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41916', '分数的加法和减法', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41917', '位置', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41918', '多边形的面积', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41919', '观察物体', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41920', '长方体和正方体', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41921', '图形的运动', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41922', '折线统计图', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41923', '可能性', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41924', '打电话', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41925', '数学广角', '41687', '41692', '41729', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41926', '字的音、形、义', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41927', '四字词语或成语', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41928', '多义词', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41929', '词语的色彩', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41930', '关联词语', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41931', '句式转换', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41932', '修改病句', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41933', '修辞手法', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41934', '标点符号', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41935', '名言警句谚语', '41687', '41692', '41728', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41936', '说明文阅读', '41687', '41692', '41728', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41937', '记叙文阅读', '41687', '41692', '41728', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41938', '古诗词（五）', '41687', '41692', '41728', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41939', '文学名著', '41687', '41692', '41728', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41940', '写作', '41687', '41692', '41728', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41942', '语音', '41687', '41692', '41730', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41943', '词汇', '41687', '41692', '41730', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41944', '陈述句', '41687', '41692', '41730', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41945', '一般疑问句', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41946', '特殊疑问句', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41947', '时态', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41948', '听力', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41949', '阅读理解', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41950', '书面表达', '41687', '41692', '41730', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41951', '整除问题', '41687', '41692', '41731', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41952', '牛吃草问题', '41687', '41692', '41731', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41953', '容斥原理', '41687', '41692', '41731', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41956', '分数乘法', '41687', '41693', '41733', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41957', '分数除法', '41687', '41693', '41733', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41958', '比', '41687', '41693', '41733', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41959', '百分数', '41687', '41693', '41733', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41960', '负数', '41687', '41693', '41733', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41961', '比例', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41962', '位置与方向', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41963', '圆', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41964', '圆柱与圆锥', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41965', '扇形统计图', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41966', '数学广角', '41687', '41693', '41733', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41967', '字的音、形、义', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41968', '四字词语或成语', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41969', '多义词', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41970', '词语的色彩', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41971', '关联词语', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41972', '句式转换', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41973', '修改病句', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41974', '修辞手法', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41975', '标点符号', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41976', '名言警句谚语', '41687', '41693', '41732', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41977', '诗歌阅读', '41687', '41693', '41732', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41978', '记叙文阅读', '41687', '41693', '41732', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41979', '古诗词（六）', '41687', '41693', '41732', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41980', '文学名著', '41687', '41693', '41732', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41983', '写作', '41687', '41693', '41732', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41984', '语音', '41687', '41693', '41734', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41985', '词汇', '41687', '41693', '41734', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41986', '陈述句', '41687', '41693', '41734', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('41987', '特殊疑问句', '41687', '41693', '41734', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41988', '时态', '41687', '41693', '41734', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41989', '听力', '41687', '41693', '41734', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41990', '阅读理解', '41687', '41693', '41734', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41991', '书面表达', '41687', '41693', '41734', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('41992', '计算综合', '41687', '41693', '41735', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41993', '方程解应用题', '41687', '41693', '41735', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41994', '经济问题', '41687', '41693', '41735', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('41999', '认识钟表', '41687', '41688', '41698', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42000', '短文阅读', '41687', '41689', '41702', '1', '0', '');
INSERT INTO `xxj_point` VALUES ('42001', '巧求周长', '41687', '41690', '41716', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42002', '周期问题', '41687', '41690', '41716', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42003', '盈亏问题', '41687', '41691', '41727', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42004', '基本行程问题', '41687', '41691', '41727', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42005', '质数与合数', '41687', '41692', '41731', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42006', '因数与倍数', '41687', '41692', '41731', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42007', '比例的应用', '41687', '41693', '41735', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42008', '立体图形', '41687', '41693', '41735', '0', '0', '');
INSERT INTO `xxj_point` VALUES ('42010', '两位数乘两位数', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42011', '年、月、日', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42012', '小数的初步认识', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42013', '数学广角', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42014', '位置与方向', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42015', '长方形和正方形', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42016', '面积', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42017', '复式统计表', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42018', '搭配', '41687', '41690', '41712', '2', '0', '');
INSERT INTO `xxj_point` VALUES ('42019', '词语搭配', '41687', '41691', '41724', '1', '0', '');

-- ----------------------------
-- Table structure for `xxj_product`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_product`;
CREATE TABLE `xxj_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `product_name` varchar(50) NOT NULL COMMENT '产品名称',
  `product_introduce` varchar(150) NOT NULL COMMENT '产品介绍',
  `product_image` varchar(150) NOT NULL COMMENT '产品图片',
  `product_status` int(1) NOT NULL COMMENT '产品状态：0:可用1:不可用',
  `product_type` int(1) NOT NULL COMMENT '产品类型：1:全科2:单科3:专题',
  `effective` datetime NOT NULL COMMENT '产品生效时间',
  `expires` datetime NOT NULL COMMENT '产品过期时间',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `grade_id` int(11) DEFAULT NULL COMMENT '年级ID',
  `subject_id` int(11) DEFAULT NULL COMMENT '科目ID',
  `subject_type` int(1) NOT NULL COMMENT '文理科：3:全部1:文科2:理科',
  `is_free` int(1) NOT NULL COMMENT '产品免费：0:收费1:免费',
  `sort` int(11) NOT NULL COMMENT '产品排序',
  `content_list` varchar(100) NOT NULL COMMENT '产品内容包，如果同步课则查询xxj_content表，如果专题查询xxj_special',
  `buy_days` int(11) DEFAULT NULL COMMENT '指定购买日期：天数',
  `buy_type` varchar(25) NOT NULL COMMENT '可购买类型 3全年、2半年、1包月、0特定日期',
  `buy_tips` varchar(150) DEFAULT NULL COMMENT '购买提示',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
-- Records of xxj_product
-- ----------------------------
INSERT INTO `xxj_product` VALUES ('1', '3', '一年级', '一年级全科套餐', 'www.uflowertv.com', '0', '1', '2017-01-06 17:09:04', '2017-01-29 17:09:08', '41687', '41688', null, '3', '0', '0', '1,2', null, '1,2,3', null);
INSERT INTO `xxj_product` VALUES ('2', '3', '初一', '初一全科套餐', 'www.uflowertv.com', '0', '1', '2017-01-09 10:44:05', '2018-01-09 10:44:09', '39779', '39781', null, '3', '0', '0', '3,4,5', null, '1,2,3', null);
INSERT INTO `xxj_product` VALUES ('3', '3', '高一', '高一全科套餐', 'www.uflowertv.com', '0', '1', '2017-01-09 10:46:24', '2018-01-09 10:46:29', '39780', '39784', null, '3', '0', '0', '6,7', null, '1,2,3', null);
INSERT INTO `xxj_product` VALUES ('4', '3', '二年级', '二年级全科套餐', 'www.uflowertv.com', '0', '1', '2017-01-09 13:54:08', '2018-01-09 13:54:10', '41687', '41689', null, '3', '0', '0', '8,9', null, '1,2,3', null);
INSERT INTO `xxj_product` VALUES ('5', '3', '多科专题', '一年级专题', 'www.uflowertv.com', '0', '3', '2017-01-14 11:12:56', '2017-02-14 11:13:04', '41687', null, null, '3', '0', '0', '1', null, '0', null);
INSERT INTO `xxj_product` VALUES ('6', '3', '单科专题', '一年级数学专题', 'www.uflowertv.com', '0', '3', '2017-01-12 17:55:53', '2017-01-19 17:56:02', '41687', null, null, '3', '0', '0', '2', '10', '0', null);
INSERT INTO `xxj_product` VALUES ('7', '3', '一年级单科', '一年级单科套餐', '3434343434343434343', '0', '2', '2017-01-16 11:03:49', '2018-01-22 11:03:54', '41687', '41688', null, '3', '0', '0', '1', null, '1,2,3', null);

-- ----------------------------
-- Table structure for `xxj_rated`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_rated`;
CREATE TABLE `xxj_rated` (
  `rated_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '定价ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `product_type` int(1) DEFAULT NULL COMMENT '产品类型：1:包月2:半年3:全年0:指定日期',
  `operator_id` varchar(32) NOT NULL COMMENT '运营商产品ID',
  `rated_price` varchar(255) NOT NULL COMMENT '价格',
  `show_price` varchar(255) NOT NULL COMMENT '显示价格',
  `effective` datetime NOT NULL COMMENT '生效时间',
  `expires` datetime NOT NULL COMMENT '过期时间',
  `rated_type` int(1) NOT NULL COMMENT '定价类型：0:正常1:促销',
  PRIMARY KEY (`rated_id`),
  KEY `FK_5l2q2jiq7r6n9nwebtq9ddym7` (`product_id`),
  CONSTRAINT `FK_5l2q2jiq7r6n9nwebtq9ddym7` FOREIGN KEY (`product_id`) REFERENCES `xxj_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='定价表';

-- ----------------------------
-- Records of xxj_rated
-- ----------------------------
INSERT INTO `xxj_rated` VALUES ('1', '1', '3', '1', '1', '49', '49元/月', '2017-01-21 15:01:07', '2019-02-09 15:01:10', '0');
INSERT INTO `xxj_rated` VALUES ('2', '1', '3', '2', '1', '299', '299元/半年', '2017-01-09 15:06:42', '2018-01-09 15:06:44', '0');
INSERT INTO `xxj_rated` VALUES ('3', '1', '3', '3', '1', '499', '499元/年', '2017-01-09 15:01:35', '2018-01-10 15:01:44', '0');
INSERT INTO `xxj_rated` VALUES ('4', '1', '3', '1', '1', '29', '29元/月', '2017-01-13 15:35:52', '2017-01-31 15:36:00', '1');
INSERT INTO `xxj_rated` VALUES ('5', '5', '3', '0', '1', '55', '55元', '2017-01-11 12:54:44', '2017-06-18 12:54:51', '0');

-- ----------------------------
-- Table structure for `xxj_special`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_special`;
CREATE TABLE `xxj_special` (
  `special_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专题ID',
  `special_name` varchar(200) NOT NULL COMMENT '专题名称',
  `special_image` varchar(200) NOT NULL COMMENT '专题图片',
  `template` int(11) NOT NULL COMMENT '专题模版',
  `special_status` int(1) NOT NULL COMMENT '专题状态：0:在线1:下线',
  `params` text NOT NULL COMMENT '专题模版参数',
  PRIMARY KEY (`special_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='专题对象表';

-- ----------------------------
-- Records of xxj_special
-- ----------------------------
INSERT INTO `xxj_special` VALUES ('1', '小学语文', 'www.uflowertv.com', '1', '0', '{\"image\": \"http://abc.jpg\", \"templateId\": \"1\"}');
INSERT INTO `xxj_special` VALUES ('2', '小学数学', 'www.uflowertv.com', '1', '0', '{\"image\": \"http://abc.jpg\", \"templateId\": \"1\"}');

-- ----------------------------
-- Table structure for `xxj_special_list`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_special_list`;
CREATE TABLE `xxj_special_list` (
  `special_id` int(11) NOT NULL COMMENT '专题ID',
  `video_id` int(11) NOT NULL COMMENT '视频ID',
  `video_name` varchar(50) NOT NULL COMMENT '视频名称',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `grade_id` int(11) NOT NULL COMMENT '年级ID',
  `subject_id` int(11) NOT NULL COMMENT '科目ID',
  `term` int(1) NOT NULL COMMENT '学期：1上学期2下学期',
  `point_id` int(11) NOT NULL COMMENT '知识点ID',
  `point_name` varchar(50) NOT NULL COMMENT '知识点名称',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`special_id`,`video_id`),
  KEY `s_special_id` (`special_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题包表';

-- ----------------------------
-- Records of xxj_special_list
-- ----------------------------
INSERT INTO `xxj_special_list` VALUES ('1', '1582', '数一数', '41687', '41688', '41698', '1', '41775', '准备课', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1583', '比多少', '41687', '41688', '41698', '1', '41775', '准备课', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1584', '0~5的认识=、＞和＜的认识', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1585', '分与合、加法和减法的认识', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1586', '6、7的认识和6、7的加减法', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1617', '分类学词语', '41687', '41688', '41694', '1', '41787', '常见词语', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1618', '叠词的组成和运用', '41687', '41688', '41694', '1', '41788', '叠词', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1619', '连词成句题的解答', '41687', '41688', '41694', '1', '41789', '连词成句', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1620', '数短文的自然段', '41687', '41688', '41694', '2', '41790', '儿歌、小短文阅读', '0');
INSERT INTO `xxj_special_list` VALUES ('1', '1621', '根据短文内容提取重要信息填空', '41687', '41688', '41694', '2', '41790', '儿歌、小短文阅读', '0');
INSERT INTO `xxj_special_list` VALUES ('2', '1582', '数一数', '41687', '41688', '41698', '1', '41775', '准备课', '0');
INSERT INTO `xxj_special_list` VALUES ('2', '1583', '比多少', '41687', '41688', '41698', '1', '41775', '准备课', '0');
INSERT INTO `xxj_special_list` VALUES ('2', '1584', '0~5的认识=、＞和＜的认识', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');
INSERT INTO `xxj_special_list` VALUES ('2', '1585', '分与合、加法和减法的认识', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');
INSERT INTO `xxj_special_list` VALUES ('2', '1586', '6、7的认识和6、7的加减法', '41687', '41688', '41698', '1', '41776', '1~20的认识和加减法', '0');

-- ----------------------------
-- Table structure for `xxj_subject`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_subject`;
CREATE TABLE `xxj_subject` (
  `subject_id` int(11) NOT NULL COMMENT '科目ID',
  `subject_name` varchar(50) NOT NULL COMMENT '科目名称',
  `subject_image` varchar(200) NOT NULL COMMENT '图片地址',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `grade_id` int(11) NOT NULL COMMENT '年级ID',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`subject_id`),
  KEY `xued_id` (`xued_id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `xxj_subject_ibfk_1` FOREIGN KEY (`xued_id`) REFERENCES `xxj_xued` (`xued_id`),
  CONSTRAINT `xxj_subject_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `xxj_grade` (`grade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目表';

-- ----------------------------
-- Records of xxj_subject
-- ----------------------------
INSERT INTO `xxj_subject` VALUES ('39787', '语文', '/Uploads/ychpointimg/20161008/57f84f4ecf965.jpg', '39779', '39781', '0');
INSERT INTO `xxj_subject` VALUES ('39788', '数学', '/Uploads/ychpointimg/2016-03/31E2FD9C4DDA9E190E6082AC1DE2B7E0.png', '39779', '39781', '0');
INSERT INTO `xxj_subject` VALUES ('39789', '英语', '/Uploads/ychpointimg/2016-03/5342132C2926784286AA01A64CB11762.png', '39779', '39781', '0');
INSERT INTO `xxj_subject` VALUES ('39790', '语文', '/Uploads/ychpointimg/2016-03/643B4938847F11E73A367DD4407025DE.png', '39779', '39782', '0');
INSERT INTO `xxj_subject` VALUES ('39791', '数学', '/Uploads/ychpointimg/2016-03/FEA1298FF07FC112FD931F2531E4F6A7.png', '39779', '39782', '0');
INSERT INTO `xxj_subject` VALUES ('39792', '英语', '/Uploads/ychpointimg/2016-03/FAD34BD4FC9C3170FFFA19345210A8F6.png', '39779', '39782', '0');
INSERT INTO `xxj_subject` VALUES ('39793', '物理', '/Uploads/ychpointimg/2016-03/EDF0E57AD63BE2F772BBD5D1F2B01303.png', '39779', '39782', '0');
INSERT INTO `xxj_subject` VALUES ('39794', '语文', '/Uploads/ychpointimg/2016-03/67DA92AB6546630519AE1218AB8C45F2.png', '39779', '39783', '0');
INSERT INTO `xxj_subject` VALUES ('39795', '数学', '/Uploads/ychpointimg/2016-03/FE2E070E8B4F83CB399E655060DE0DD9.png', '39779', '39783', '0');
INSERT INTO `xxj_subject` VALUES ('39796', '英语', '/Uploads/ychpointimg/2016-03/F526D7DC8AB7764492E15EC38FFD5180.png', '39779', '39783', '0');
INSERT INTO `xxj_subject` VALUES ('39797', '物理', '/Uploads/ychpointimg/2016-03/C35FF453657B6E9D2C22CF5AB6DD824E.png', '39779', '39783', '0');
INSERT INTO `xxj_subject` VALUES ('39798', '化学', '/Uploads/ychpointimg/2016-03/E847A5D04C14ADA93C2C66DB95993443.png', '39779', '39783', '0');
INSERT INTO `xxj_subject` VALUES ('39835', '语文', '/Uploads/ychpointimg/2016-03/F5BD982C49726A82CD63018372C14D88.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39836', '数学', '/Uploads/ychpointimg/2016-03/DEAC9AE36EC2C89E3836EBF6FCEC6085.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39837', '英语', '/Uploads/ychpointimg/2016-03/02678DCEA5AA21C8EBC605132799E413.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39838', '物理', '/Uploads/ychpointimg/2016-03/9C14B104939B98B1C9A1AF4BC85DEF56.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39839', '化学', '/Uploads/ychpointimg/2016-03/02B63BFE8276B0D022348AFD2175AAF9.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39840', '生物', '/Uploads/ychpointimg/2016-03/B7CC743EE636FE5125D29A47C9BDB3B4.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39841', '政治', '/Uploads/ychpointimg/2016-03/D5F6C49570E7879C9D6A22986976FC4B.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39842', '历史', '/Uploads/ychpointimg/2016-03/4699BFF2D39E820D6E3E721183AA5DCA.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39843', '地理', '/Uploads/ychpointimg/2016-03/CAC8B20698A20EE1D711866E82E8C99B.png', '39780', '39784', '0');
INSERT INTO `xxj_subject` VALUES ('39844', '语文', '/Uploads/ychpointimg/2016-03/2E991710A95D8E7D81D117E80ECBA20A.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39845', '数学', '/Uploads/ychpointimg/2016-03/8F2DB6B76319E5B1FF71651CB3A561CF.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39846', '英语', '/Uploads/ychpointimg/2016-03/B660B9B7E30868D28B7512CF273FBEB6.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39847', '物理', '/Uploads/ychpointimg/2016-03/62A7FDC2F94CDF1B4B704105FD6F1BE1.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39848', '化学', '/Uploads/ychpointimg/2016-03/03BF5A94C99E40C5F0823A845D680304.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39849', '生物', '/Uploads/ychpointimg/2016-03/F5C8D8D3B7432AA6FB315D64575C0E7D.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39850', '政治', '/Uploads/ychpointimg/2016-03/C1261AC5F789B0CE3DEFF74570D44C84.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39851', '历史', '/Uploads/ychpointimg/2016-03/F21DB142AE121186D4F980D30AF8A101.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39852', '地理', '/Uploads/ychpointimg/2016-03/C76979709430A64FFB13C3E1A2CAA690.png', '39780', '39785', '0');
INSERT INTO `xxj_subject` VALUES ('39853', '语文', '/Uploads/ychpointimg/2016-03/C847F08C25F1E4BF388D9D9EB766F1BE.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39854', '数学', '/Uploads/ychpointimg/2016-03/04F6DD807D32339774EB264AA251CBFF.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39855', '英语', '/Uploads/ychpointimg/2016-03/B45116AE6EC07B27FCD24A1CA7AC649A.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39856', '物理', '/Uploads/ychpointimg/2016-03/5A6C60FE5A1271F627DBC4985C603BE4.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39857', '化学', '/Uploads/ychpointimg/2016-03/4BD8E2934ED696128315B56D639789EE.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39858', '生物', '/Uploads/ychpointimg/2016-03/0176B4A3C1005018E10CEC4E5C05E1B1.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39860', '历史', '/Uploads/ychpointimg/2016-04/E981103A288D06FA3A0F429BD55D9D57.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('39861', '地理', '/Uploads/ychpointimg/2016-03/6EE00802F86D212B2C8B2A0A6A989288.png', '39780', '39786', '0');
INSERT INTO `xxj_subject` VALUES ('41694', '语文', '/Uploads/ychpointimg/2016-06/C5F4A5D8B380372FC3B9E96E0C8DDE9A.png', '41687', '41688', '0');
INSERT INTO `xxj_subject` VALUES ('41698', '数学', '/Uploads/ychpointimg/2016-06/6D0B69F792B6A4B8076A2F74E77A0FDD.png', '41687', '41688', '0');
INSERT INTO `xxj_subject` VALUES ('41702', '语文', '/Uploads/ychpointimg/2016-06/6DA43F79604296B804D7033A341454FD.png', '41687', '41689', '0');
INSERT INTO `xxj_subject` VALUES ('41703', '数学', '/Uploads/ychpointimg/2016-06/0237DD5EC29AC0AACDF218BDC01A57BC.png', '41687', '41689', '0');
INSERT INTO `xxj_subject` VALUES ('41710', '语文', '/Uploads/ychpointimg/2016-06/92ADB4DB557F048E7EE576F480496AD0.png', '41687', '41690', '0');
INSERT INTO `xxj_subject` VALUES ('41712', '数学', '/Uploads/ychpointimg/2016-06/9F984132BD8E5B487380A82555498F72.png', '41687', '41690', '0');
INSERT INTO `xxj_subject` VALUES ('41714', '英语', '/Uploads/ychpointimg/2016-06/A700F0ED43AA002DCAF78673AE3E7A7D.png', '41687', '41690', '0');
INSERT INTO `xxj_subject` VALUES ('41716', '奥数', '/Uploads/ychpointimg/2016-06/7117AB0C9FD8C97030CF7C5F7CAD537F.png', '41687', '41690', '0');
INSERT INTO `xxj_subject` VALUES ('41724', '语文', '/Uploads/ychpointimg/2016-06/2B27E715B89C795C95883CB6C83693F5.png', '41687', '41691', '0');
INSERT INTO `xxj_subject` VALUES ('41725', '数学', '/Uploads/ychpointimg/2016-06/ADA7F039E2959DCD865677F0BDDBD635.png', '41687', '41691', '0');
INSERT INTO `xxj_subject` VALUES ('41726', '英语', '/Uploads/ychpointimg/2016-06/C55AB88846C689B92AA1F060C92DC876.png', '41687', '41691', '0');
INSERT INTO `xxj_subject` VALUES ('41727', '奥数', '/Uploads/ychpointimg/2016-06/AC520B5A2318ED6B30D9FB8E6334DC5C.png', '41687', '41691', '0');
INSERT INTO `xxj_subject` VALUES ('41728', '语文', '/Uploads/ychpointimg/2016-06/A78AB9DE8098711586B77DC960718D26.png', '41687', '41692', '0');
INSERT INTO `xxj_subject` VALUES ('41729', '数学', '/Uploads/ychpointimg/2016-06/8055A8A621C6DB95A8B20F36D4481749.png', '41687', '41692', '0');
INSERT INTO `xxj_subject` VALUES ('41730', '英语', '/Uploads/ychpointimg/2016-06/17031F2F87BD09B8E0D967A35EF4B341.png', '41687', '41692', '0');
INSERT INTO `xxj_subject` VALUES ('41731', '奥数', '/Uploads/ychpointimg/2016-06/616AD5CC522F3F18079E0EDEE1F2C4A7.png', '41687', '41692', '0');
INSERT INTO `xxj_subject` VALUES ('41732', '语文', '/Uploads/ychpointimg/2016-06/1278BC8A1A00AD53AC43708B64A40DD6.png', '41687', '41693', '0');
INSERT INTO `xxj_subject` VALUES ('41733', '数学', '/Uploads/ychpointimg/2016-06/2F9368CDD1910005477B891B02AF17E0.png', '41687', '41693', '0');
INSERT INTO `xxj_subject` VALUES ('41734', '英语', '/Uploads/ychpointimg/2016-06/A04998B8EF34F556B6A8A157C2271C36.png', '41687', '41693', '0');
INSERT INTO `xxj_subject` VALUES ('41735', '奥数', '/Uploads/ychpointimg/2016-06/EE42112E1633E2650EDBA1A9AAF48BCD.png', '41687', '41693', '0');

-- ----------------------------
-- Table structure for `xxj_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_teacher`;
CREATE TABLE `xxj_teacher` (
  `tc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师ID',
  `tc_name` varchar(50) NOT NULL COMMENT '教师名称',
  `tc_image` varchar(100) NOT NULL COMMENT '图片',
  `tc_job` varchar(100) NOT NULL COMMENT '职位',
  `tc_introduce` varchar(255) NOT NULL COMMENT '简介',
  `tc_say` varchar(150) NOT NULL COMMENT '描述',
  `grade_list` varchar(255) DEFAULT NULL,
  `subject_list` varchar(255) DEFAULT NULL,
  `school_age` int(2) DEFAULT NULL COMMENT '教龄',
  `sort` int(11) NOT NULL COMMENT '排序',
  `params` text,
  PRIMARY KEY (`tc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COMMENT='教师表';

-- ----------------------------
-- Records of xxj_teacher
-- ----------------------------
INSERT INTO `xxj_teacher` VALUES ('9', '潘爱国', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d67bb8a6.jpg', '高级教师', '物理高级教师，北京师范大学硕士，从事中学物理教学22年。多年来从事高考命题研究、高考试卷分析与评价。曾任湖北省荆门市城乡高中物理教师、物理教研组长、教务主任、教学副校长、北京清华志清中学教务主任、教学副校长。现任物理研究员，人大附中分校物理教研组长。', '潘爱国：高级教师,高考命题研究专家', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('10', '马金辉', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d4a807f2.jpg', '高级教师', '东城区教师研修中心兼职教研员，专研教材教法。在课堂教学中以生动的语言、丰富的知识调动学生的积极性，充分利用物理学科特点，以实验现象为主线，在新课和复习课教学中通过情景的创设和再现引导学生思考、探究、讨论，突出学生主体地位。热爱学生、教学基本功扎实严谨，踏实认真。', '马金辉：东城区物理教研员,高级教师', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('11', '王小辉', '/Uploads/F_Uploads/grkcimg/2014-10/544a0db27369f.jpg', '骨干教师', '北京理工大学附属中学高三化学把关教师，北京市海淀区骨干教师，海淀区教师进修学校兼职教研员，优秀青年教师，曾荣获海淀区大赛一等奖，海淀区高三录像课一等奖，全国第五届多媒体教学软件大赛一等奖。', '王小辉：理工附中高三化学把关教师', null, null, '5', '0', null);
INSERT INTO `xxj_teacher` VALUES ('12', '张晓华', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d08a3d91.jpg', '高级教师', '北京市数学学科骨干教师、海淀区学科带头人。多次参加不同项目的国培计划，承担市、区级的观摩课、讲座、评课等任务。多篇论文获国家级、市级一等奖。', '张晓华：市级骨干教师,海淀区学科带头人', null, null, '12', '0', null);
INSERT INTO `xxj_teacher` VALUES ('13', '杨凤文', '/Uploads/F_Uploads/grkcimg/2014-10/544a0ca98ebe1.jpg', '高级教师', '北京四中高级教师，数学教研组组长，西城区学科带头人，北京数学会理事。曾兼职区教研员，荣获区第四届中青年教师教学比赛一等奖、区第十届“期望杯”奖。积极研究新课程改革，参与高中新课程数学教材的编写工作，有多篇论文在市区获奖。', '杨凤文：北京四中数学教研组长', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('14', '李俊和', '/Uploads/F_Uploads/grkcimg/2014-10/544a0cb890a76.jpg', '特级教师', '北京四中英语特级教师，英语学科组组长，北京市级骨干教师。在北京四中教授英语23年，任英语教研组长十余年。获北京市先进教师称号，北京四中优秀园丁奖。曾多次担任中央电视台教育频道、中国教育电视台、北京电视台和数字电视高考备考节目主讲人。多次为全国各地教师和学生做辅导讲座，并受到欢迎。', '李俊和：北京四中英语组长,市级骨干', null, null, '5', '0', null);
INSERT INTO `xxj_teacher` VALUES ('15', '白素云', '/Uploads/F_Uploads/grkcimg/2015-03/922EC96E81029E6DEDEB3E0D93E91C49.jpg', '特级教师', '北京市东城区教师研修中心特级教师，语文学科带头人。曾获“全国优秀语文教师”称号。曾先后参加多家出版社多套高中语文教材的编写工作，在国家级刊物上发表过40多篇文章。对于高考语文考点的把握相当熟练，有数篇论文获得国家、市级一等奖，两项课题研究荣获北京市政府颁发的教育教学成果奖。', '白素云：全国优秀语文教师,东城区特级教师', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('17', '周业虹', '/Uploads/F_Uploads/grkcimg/2014-10/544a0c6fca65b.jpg', '特级教师', '北京市化学特级教师。北京市东城区教师研修中心化学教研室主任，课改实验工作专家指导组成员。北京市化学学科带头人。长期承担北京教育考试院高中化学会考试题评价工作、北京市高中教师资格认定委员会学科评委工作，主编及参编多部著作，悉心指导青年教师成长。', '周业虹：特级教师,东城化学教研室主任', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('18', '林祖荣', '/Uploads/F_Uploads/grkcimg/2014-10/544a0c8adbc53.jpg', '特级教师', '北京生物特级教师，北京师范大学附属实验中学教科室副主任。教育部考试中心《中学实施新课程后高考生物科命题研究》课题组成员。', '林祖荣：特级教师,北师大实验中学名师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('19', '潘廷宏', '/Uploads/F_Uploads/grkcimg/2014-10/544a0dc082e27.jpg', '高级教师', '北京四中化学教研组组长，高级教师，北京市西城区化学学科带头人。著有“高中化学重点难点综析”、“跳出题海”、“高考能力指要”、“北京四中高考夺冠诀窍”等十余本著作。曾在中央教育电视台作“2001年高考精读辅导”、在中央电视台教育台作“2003年高考大咨询辅导”等系列讲座。', '潘廷宏：特级教师,北京四中化学组长', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('20', '李宗录', '/Uploads/F_Uploads/grkcimg/2014-10/544a0c9dcbcbe.jpg', '特级教师', '教育部“国培计划”首批专家；首都师范大学特级教师中心特聘专家；硕士研究生指导教师；在地理教学相关的核心期刊发表论文60余篇；多次获国家、市、区大奖；多次开展市、区公开课、观摩课和研究课；常年高三把关，教学成绩突出。', '李宗录：特级教师,高三地理把关教师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('21', '张道林', '/Uploads/F_Uploads/grkcimg/2014-10/544a0cd27aea8.jpg', '特级教师', '特级教师，民进中央教育委员会委员，教育部《网络科技时代》专家委员会成员，中国史学会魏晋南北朝史研究会理事，北京《现代教育报·高考周刊》历史版主编，全国历史教学研究会个人会员，人民教育出版社、大象出版社高中历史新课标教材教参编写组成员。', '张道林：特级教师,人教版教材编写者', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('22', '梁侠', '/Uploads/F_Uploads/grkcimg/2014-10/544a0ce15c37e.jpg', '特级教师', '北京师大附属实验中学政治教研组长，中学政治特级教师，北京市政治学科带头人。教育部“跨世纪园丁工程”国家级培训骨干教师。兼任西城区政治学科教研员、北京师范大学中学政治骨干教师班指导教师、北京师范大学教育专业硕士研究生导师，教育部《普通高中课程标准思想政治必修4生活与哲学》2008修订组成员。', '梁侠：特级教师,北师大实验中学政治组长', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('23', '田佩淮', '/Uploads/F_Uploads/grkcimg/2014-10/544a0cef8946c.jpg', '特级教师', '清华大学附属中学地理组组长，北京市特级教师，《高考》杂志地理主编，《高校招生》杂志顾问。从教以来，担任16届高三毕业班地理教学，学生高考成绩优异，多次总评分获重点中学第一。近年来在全国各地做多场关于高考复习的讲座。任第三次学习专家委员会会员、《教科报导》执行编委。', '田佩准：特级教师,清华附中地理组长', null, null, '1', '0', null);
INSERT INTO `xxj_teacher` VALUES ('24', '梁月松', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d1704b7e.jpg', '骨干教师', '执教于清华大学附属中学，担任英语备课组组长；曾执教于北京大学附属中学，所教学生2013年高考英语单科成绩149分。《英语沙龙》杂志长期特邀作者与点评教师。国家十二五教育规划北京教育学院培训项目成员。承担华东师范大学“翻转课堂”全国公开课。', '梁月松：清华附中英语组长,骨干教师', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('25', '张红军', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d7e1db02.jpg', '高级教师', '北京市生物高级教师，北京五中生物教研组组长；东城区兼职教研员；北京市骨干教师；东城区学科带头人。', '张红军：北京五中生物教研组长,东城教研员', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('26', '张芮', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d279cf18.jpg', '骨干教师', '北京市语文学科骨干教师，东城区语文学科教研员，文学硕士。善于以考试真题为例，讲解教学、解题方法。曾受邀参加全国中语会、北京市教育学会相关课题研究工作。在教育教学出版物上出版和发表教育教学论文、教学指导、录制新课标教材示范课，在中央教育电视台、北京电视台等媒体进行备考指导。', '张芮：东城语文教研员,市级骨干教师', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('27', '郭铁良', '/Uploads/F_Uploads/grkcimg/2014-10/544a222cd013e.jpg', '特级教师', '北京市语文特级教师，语文学科带头人，北京市教育科学规划办公室学科专家组成员，全国中语会教学改革研究中心理事。被北京市教委聘为北京市特级教师评审委员会语文学科专家组评审委员。', '郭铁良：语文特级教师,全国中语会理事', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('29', '李卿', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d5959c9a.jpg', '骨干教师', '北京师范大学硕士。2006年-今，在北京市东城区171中学任教。有丰富的教学经验，对中考考点把握准确，解题思路丰富，善于引导学生解题的自主性、启发学生的创造性。', '李卿：北京171中学化学骨干教师', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('30', '李忠华', '/Uploads/F_Uploads/grkcimg/2014-09/540439cc2c85f.jpg', '优秀教师', '北京大学英语语言文学硕士，吉林艺术学院英语部讲师。多年从事英语学科教学工作，对于高考英语必考考点的考察和破解有独特的思路和方法。', '李忠华：高考专家,英语训练名师', null, null, '1', '0', null);
INSERT INTO `xxj_teacher` VALUES ('31', '王苒苒', '/Uploads/F_Uploads/grkcimg/2014-10/544a0d3a526df.jpg', '高级教师', '西城区高级教师，善于将复杂题目循序渐进地进行分解，使学生易于接受。曾获西城区“我心中的好老师”称号，西城区教育系统先进工作者，多篇论文发表在国家级、市级刊物上，曾担任过“微课网”“北京数字教育平台”的授课工作。授课风格自然大方，有亲和力。', '王苒苒：高级教师,学科带头人', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('36', '付正军', '/Uploads/F_Uploads/grkcimg/2014-11/54742149e1dbd.jpg', '高考专家', '新东方明星教师，国内著名高考研究与辅导专家，数学归类解析学习法创始人，北京名师协会秘书长。', '付正军：高考专家,名师协会秘书长', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('37', '张晖', '/Uploads/F_Uploads/grkcimg/2014-12/5490fbc0bdd53.jpg', '优秀教师', '拥有8年数学教学经验，4年毕业班教学经验，主要带精英班，参与数学教研及讲义编写工作。讲课思路清晰，具有亲和力，能抓住学生心理，调动学生积极性，引导思考，采用启发式的教学，鼓励学生自己去发现、去创新，培养学生的学习兴趣。', '张晖：毕业班优秀教师,数学教研员', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('38', '苏拴良', '/Uploads/F_Uploads/grkcimg/2015-01/54a8d5f206092.jpg', '特级教师', '特级教师，省级优秀教师，省级骨干教师，市级名师，省级数学学科带头人，“初中生周报”“德育报”专栏作者，在省级以上报刊发表论文300余篇，策划并主编《高分密码》《新课程新思维》等系列丛书，深受好评，在西单图书大厦连续三周销量第一。', '苏拴良：特级教师,金牌辅导书主编', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('39', '樊翠', '/Uploads/F_Uploads/grkcimg/2015-02/54f18ad59d788.jpg', '优秀教师', '北京龙文学校语文教师。任职期间，对所带的每一个学生认真分析在语文学科方面存在的问题，制定出详细的学习计划，在授课过程中寓教于乐，培养学生对语文的兴趣，在轻松中学习知识。所带学生成绩都有大幅度提高，得到学生、家长和学校领导的一致好评。', '樊翠：培训专家,龙文学校语文名师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('40', '王娟', '/Uploads/F_Uploads/grkcimg/2015-01/54add80015247.jpg', '一级教师', '北京重点中学一级教师，学识渊博，古文和写作功底尤为深厚，所写论文连续两次获北京新课改征文一等奖。', '王娟：北京市重点中学一级教师', null, null, '12', '0', null);
INSERT INTO `xxj_teacher` VALUES ('41', '杨宝军', '/Uploads/F_Uploads/grkcimg/2015-01/54b399037464b.jpg', '优秀教师', '拥有20年教龄，对数学教学和教研具有丰富的经验，善于启发和引导学生主动思考问题，并针对不同学生的学习问题提供解决方案，在培养学习习惯方面积累了很多成功案例，对不同层次学生成绩的提高效果显著。注重知识的形成过程，注重培养学生的逻辑思维能力和对数学学习的兴趣。', '杨宝军：20年教龄优秀教师', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('42', '唐振庭', '/Uploads/F_Uploads/grkcimg/2015-03/DF67ADFCC60F8D17D8A5EC50F08034A2.png', '优秀教师', '北京新东方学校教师，生物学、管理学双学士。', '唐振庭：生物培训专家,新东方生物名师', null, null, '13', '0', null);
INSERT INTO `xxj_teacher` VALUES ('43', '付淑惠', '/Uploads/F_Uploads/grkcimg/2015-01/54bf6ed28d063.png', '高级教师', '北京市重点中学在职一线骨干教师，高级教师。化学教研组组长。授课善于将理论与实践相结合，所带学生成绩提高显著。曾多次参与高考教辅材料及新教材的编写工作，能够准确把握中高考考纲。', '付淑慧：高级教师,北京重点中学化学组长', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('44', '王冠力', '/Uploads/F_Uploads/grkcimg/2015-01/54bf6f1b6091c.png', '优秀教师', '首都师范大学硕士，北京市一线教师。作为青年教师，教学风格活泼、生动。', '王冠力：北京市高中一线名师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('45', '冉峰', '/Uploads/F_Uploads/grkcimg/2015-01/54cb295f692ab.png', '高级教师', '北京市东城区教师研修中心高级教师，从事中学历史教学工作多年，有丰富的教学经验，对于高考历史学科考纲、考点的解读深入，善于引领学生自主学习。', '冉峰：北京东城教研中心高级教师', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('46', '王建', '/Uploads/F_Uploads/grkcimg/2015-01/54c6f5bd545fe.jpg', '高级教师', '高中地理优秀教师，授课风格轻松幽默，教授学生成绩提升显著。拥有多年地理学科教学经验。', '王建：高级教师,一线地理名师', null, null, '13', '0', null);
INSERT INTO `xxj_teacher` VALUES ('47', '王志国', '/Uploads/F_Uploads/grkcimg/2015-01/54c7609a0657c.jpg', '高级教师', '高级教师，多年担任班主任及毕业班任课教师工作，对物理教材及考试方向有较深入研究。所教班级物理成绩优异，尤其对电学、力学有深层次研究且有比较成熟的解决思路和方法。能够熟练驾驭教材，熟悉中考政策，对近几年的中考的考点、重点、难点有深入的研究。教育经验丰富，责任心强，多次被评为优秀教师，曾获评优课一等奖。', '王志国：高级教师,中考物理专家', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('48', '范桂英', '/Uploads/F_Uploads/grkcimg/2015-01/54cb3b072fee9.jpg', '特级教师', '北京市特级教师，北京市第15中学历史教研组组长。一直从事高三高考研究工作。经常应邀去全国各地讲学，受到广泛的好评。所带班级历史在高考中年年获得高分。2002年区优秀教师、2001年区教委第二届学科带头人，骨干教师拔尖人才，北清之慧教育特聘专家。', '范桂英：特级教师,北京15中历史组长', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('49', '张志忠', '/Uploads/F_Uploads/grkcimg/2015-02/54d0913149076.png', '高级教师', '北京东城教研中心政治室主任，主张从“学生喜欢什么样的课堂”角度改进教学方式，从而做到落实基础知识、提高答题技巧和能力、理论联系实际，提高政治课教学的实效性，让学生能学以致用。', '张志忠：高级教师,区教研中心政治室主任', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('50', '王安平', '/Uploads/F_Uploads/grkcimg/2015-02/54dd6466aa79f.jpg', '高考专家', '担任学校高考数学辅导教材主编，编写两本有关高考考前辅导的参考书，对于高考数学考点有深入透彻的研究与独到的教学方法。讲授全国数学竞赛课程和北约、华约、卓越联盟自主招生考试辅导，到目前为止已经5年，成绩显著。成功预测2014年北约自主招生考试解答题。有多名学生数学成绩提分到130以上。', '王安平：金牌教辅主编,高考专家', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('51', '刘彦彬', '/Uploads/F_Uploads/grkcimg/2015-02/54dd64a53100a.jpg', '优秀教师', '初中物理优秀教师，有多年初三物理教学经验。学生物理成绩优异，思维活跃，理科优势明显。', '刘彦彬：优秀教师,中考物理名师', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('56', '徐建烽', '/Uploads/F_Uploads/grkcimg/2015-03/BB428DD327EF22EC3AD463D6EB2C1961.png', '高级教师', '北京首师大附中物理高级教师，海淀区骨干教师，海淀区进修学校兼职教研员。教风亲切洒脱，诙谐幽默，思维开阔，屡有奇思妙想，深受学生喜爱。善于从题海中发掘基本规律及通解通法，从复杂运动中把握物理学本质。有多年高中一线执教经验，高三把关教师，多次参与海淀区模拟试题命题工作，对高考动向把握极其准确。', '徐建烽：首师大附中物理高级教师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('57', '范士闯', '/Uploads/ychpointimg/20160830/57c57780dab01.jpg', '奥数专家', '奥数、中考专家，毕业于清华大学计算机系和法学专业，16年中小学数学培训经验，连续8年被评为希望杯优秀教练、迎春杯优秀教练。所授学员70%在迎春杯和希望杯获奖，深受孩子喜爱，孩子们都称其为可爱的“土豆”老师。', '范世闯：希望杯,迎春杯优秀教练', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('58', '武立恒', '/Uploads/ychpointimg/20160830/57c57a25c960f.jpg', '奥数专家', '小学奥数老师。有着丰富的线上教学经验，线上课程包括视频课程和在线直播课程，累计在线学员人次过千人。', '武立恒：优秀奥数培训专家', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('59', '许振', '/Uploads/ychpointimg/20160830/57c57747f2e09.jpg', '奥数专家', '小学奥数专家。有着深厚的数学功底和超过9年的小学数学、小学奥数教学经验，总授课超过8000课时，学员超过1000人次。', '许振：小学奥数培训专家', null, null, '9', '0', '[\r\n	{\r\n	 platformId:3,\r\n	 product_id:1,\r\n	 content_id:2,\r\n	 video_list:1598,1599,1600,1601,1602,1603,1604,1605\r\n	},\r\n	{\r\n	 platformId:3,\r\n	 product_id:4,\r\n	 content_id:9,\r\n	 video_list:1649,1650,1651,1652,1653,1654,1655,1656,1657,1658,1659\r\n	}\r\n]');
INSERT INTO `xxj_teacher` VALUES ('60', '岳爽', '/Uploads/ychpointimg/20160830/57c57fdf3016f.jpg', '数学专家', '专注于小学三、四、五、六年级校内数学及奥数教学，有着丰富的线上教学经验，线上课程包括视频课程、在线直播课程、在线1V1课程等，累计在线学员超过千人次。', '岳爽：小学数学培训专家', null, null, '5', '0', null);
INSERT INTO `xxj_teacher` VALUES ('63', '王杰', '/Uploads/ychpointimg/20160830/57c5802141c27.jpg', '语文专家', '专注小学三、四、五、六年级语文教育，涉及国学经典阅读、小学写作，有着丰富的线上教学经验。他的课程生动、活泼、自由；善于引导学生学习，调动课堂气氛，启发学生发散性思维。\r\n', '王杰：小学高年级语文研究专家', null, null, '5', '0', null);
INSERT INTO `xxj_teacher` VALUES ('64', '宋北平', '/Uploads/ychpointimg/20160830/57c580342e079.jpg', '培训专家', '教学经验丰富，教学成果卓越。12年和13年教授出石景山区和海淀区两个区状元，中考分数116—119分（满分120）的学生不少于50人。2015年中考，所教学生中最高分数119分。独自编写图书《语文知识地图第一册（初中版）》《小学生轻松3步写好作文之重点要突出》等多本中小学图书。\r\n', '宋北平：语文培训专家,畅销辅导书主编', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('65', '徐丽', '/Uploads/ychpointimg/20160830/57c5818d69045.jpg', '英语专家', '专注于小学三、四、五、六年级校内英语教学，有着丰富的线上教学经验，线上课程包括视频课程、在线直播课程、在线1V1课程等，累计在线学员超过千人次，所教授的学生很多进入名校。\r\n', '徐丽：优秀英语教师,1v1培训名师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('66', '顾海霞', '/Uploads/ychpointimg/20160830/57c58797bac9a.jpg', '骨干教师', '东城区数学教师，二十五年教学生涯，积累了丰富的教学经验。获得东城区骨干教师称号、东城区先进教育工作者称号，教学的课程收录到相关教学杂志中。在培养学生的学习兴趣，激发学生数学学习的潜能，培养学生数学思维能力，提高发展缓慢学生的数学成绩等方面，都有深入的研究，独特的方法。', '顾海霞：东城区骨干教师,先进教育工作者', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('67', '周蓓', '/Uploads/ychpointimg/20160830/57c589134f18b.jpg', '高级教师', '小学高级教师，东城区骨干教师，从2010年开始一直被聘为数学学科的兼职教研员。在2012年被评为“优秀教师”。2013年获得了“育人奖”。所做的课分别获得过全国、北京市、东城区一、二、三等奖，所写的论文分别获得全国、北京市、东城区二、三等奖。\r\n', '周蓓：东城区数学教研员,高级教师', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('68', '赵海', '/Uploads/ychpointimg/20160830/57c587e11308f.jpg', '骨干教师', '北京某上市机构金牌教师，原北京市某学校青年骨干教师。新概念口语大赛考官，希望杯英语大赛培训师，考试培训专家。指导的多位学生获全国英语大赛一，二等奖。口诀教学法，图像教学法，寓教于乐，快乐学习，让学生轻松掌握难度语法，让学生受益匪浅。\r\n', '赵海：新概念大赛考官,英语培训专家', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('69', '张艳梅', '/Uploads/ychpointimg/20160830/57c57fa7c0538.jpg', '高级教师', '小学数学高级教师，研究生学历。她一直从事小学数学教学兼班主任工作，多次参加区教学大赛和区级教学展示活动并荣获一、二等奖，所著论文多次在北京市荣获一等奖。“把机会让给学生，把精彩留给学生，把掌声送给学生，把希望带给学生”是她的教育理念。', '张艳梅：小学数学学科高级教师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('70', '王巍', '/Uploads/ychpointimg/20160830/57c5835dbb2bb.jpg', '优秀教师', '中共党员，石景山区青年教学能手。毕业以来，一直从事小学数学教学，兼任班主任工作。热爱教育事业，勤于钻研，关爱学生。曾多次参加区级公开课，积极参加教学比赛并获得优异成绩，所著论文多次获得国家、市、区级奖项，并在核心期刊发表。', '王巍：区级青年数学教学能手', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('71', '黄颖', '/Uploads/ychpointimg/20160830/57c5836538c36.jpg', '优秀教师', '北京市东城区和平里第四小学语文教师, 教学副校长,东城区语文学科带头人。北京市师德先进个人，曾获北京市基础教育科学研究优秀论文一等奖，北京市教学设计大赛一等奖，教育学会语文现代化教学说课特等奖。', '黄颖：北京东城语文学科带头人,教学副校长', null, null, '1', '0', null);
INSERT INTO `xxj_teacher` VALUES ('72', '盛晴', '/Uploads/ychpointimg/20160830/57c5836a8fee6.jpg', '优秀教师', '北京市东城区优秀语文教师。自参加工作以来，一直从事小学语文教学工作。特别对于低年级语文课程，有着比较丰富的教学经验，参与的教学比赛和撰写的论文曾多次获市、区级一等奖。', '盛晴：北京市东城区优秀语文教师', null, null, '13', '0', null);
INSERT INTO `xxj_teacher` VALUES ('73', '宋丽丽', '/Uploads/ychpointimg/20160830/57c57a5967ed0.jpg', '优秀教师', '石景山外语实验小学语文教师,先后被评为区级师德标兵、区级骨干教师、区级先进教育工作者，北京市家长学校优秀教师。参与录制《名师课堂》课程十余节,参与编写《北京市普通中小学地方教材》,先后获得北京市教学大赛一等奖、北京市说课大赛特等奖、全国说课大赛二等奖、区级教学设计大赛一等奖；论文《以识字为依托，提高课堂教学实效性》、《称象一课教学反思》先后获获北京市一等奖。', '宋丽丽：北京市骨干教师,语文教材编写者', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('74', '焦倩', '/Uploads/ychpointimg/20160830/57c57a3992174.jpg', '骨干教师', '小学语文学科北京市骨干教师，有丰富的教学经验和教研业绩。多次参加市区教学研讨和赛课展示活动，撰写的多篇论文获市区一等奖，所参与的课程研究成果获北京市基础教育教学成果奖。', '焦倩：北京市级语文骨干教师', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('75', '孙海燕', '/Uploads/ychpointimg/20160830/57c5800178a93.jpg', '高级教师', '高级教师，教学经验丰富，现为东城区教师研修中心小学数学教研员。被人民教育出版社聘为人教版义务教育教科书小学数学培训团专家。被中央电教馆和中国联合国儿基金会聘为“灾区教师培训”项目专家和“教师教学方式变革促进农村地区小学生能力发展”项目专家，参与国家级培训与指导，承担小学数学学科培训方案制定和培训手册编写工作。', '孙海燕：高级教师,东城教研中心数学教研员', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('76', '张丽娜', '/Uploads/ychpointimg/20160830/57c58565b387a.jpg', '高级教师', '被评为石景山区语文学科骨干教师。有杰出的教学能力，能将课改新理念大胆地运用到自己的课堂教学中，有创新能力，先后做市级现场课及多节区级研究课、展示课；多篇论文在国家级、市级和区级比赛中获奖。多次被评为学生最喜欢的好教师。', '张丽娜：高级教师,区级语文骨干教师', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('78', '徐姗姗', '/Uploads/ychpointimg/20160830/57c58062cc874.jpg', '高级教师', '小学数学高级教师，区级青年教学能手。热爱钻研，热爱学生，责任心强，教育教学业务突出。从教7年中曾多次荣获市、区级教育教学奖项，并授数节区级研修课，曾被评为区优秀共产党员。', '徐珊珊：高级教师,区级青年教学能手', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('79', '范涪京', '/Uploads/ychpointimg/20160830/57c580865ca93.jpg', '高级教师', '中学高级教师、区级骨干教师。曾在市区范围内上多节研究课并受到好评，多篇论文、教学设计获得市区级一二等奖，参与了市区级课题的研究并担任课题组核心人员。曾在北京市2009年小学新课程教师教学基本功培训和展示活动中荣获数学（低学段）学科一等奖。', '范涪京：高级教师,区级骨干教师', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('80', '邢东燕', '/Uploads/ychpointimg/20160830/57c585a435259.jpg', '骨干教师', '石景山区语文学科骨干教师，北京市课改先进个人，石景山区教育先进工作者，全国第三届跨越名师。曾在全国微格教学学术研讨会上做观摩课，承担北京市“空中课堂”、“北京数字学校”名师讲堂授课任务，并多次在市、区作研究课、公开课。所写论文、案例多次获全国、市、区奖项，多篇文章、教学案例发表。', '刑东燕：区级语文学科骨干教师,空中课堂名师', null, null, '5', '0', null);
INSERT INTO `xxj_teacher` VALUES ('81', '杨珊 ', '/Uploads/ychpointimg/20160830/57c5807e930f9.jpg', '高级教师', '小学高级教师，石景山区语文学科骨干教师，中共党员。从教十余载，坚持教书与育人并重，让孩子在学校中学到知识，学会做人。她的教育如和风细雨，润物无声，先后荣获“市级紫禁杯班主任”“区级百名德育先进工作者”“区级教育先进工作者”“区级师德标兵”“区级优秀少先队辅导员”等称号。', '杨珊：高级教师,语文学科骨干教师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('82', '张文静 ', '/Uploads/ychpointimg/20160830/57c5859ebcf65.jpg', '骨干教师', '现任北京市京源学校小学部教师，从教20余年，连续多年被评为区级骨干教师，多次作市区级公开课，获得好评，她教学风格细腻，以深入浅出的语言，灵活多样的教学方法，努力实践着“在教书中育人，在探索中创新”的理念。', '张文静：20余年教龄,区级骨干教师', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('83', '王琦 ', '/Uploads/ychpointimg/20160830/57c585960a8ac.jpg', '骨干教师', '现任北京市京源学校小学部副校长，连续多年被评为北京市语文骨干教师，多次作国家级市级公开课，并获得好评，勇于探索新的教学方法，不断更新教学理念，带领教师团队，探索出多种切实有效的教学方法，在区域内的小学语文教学方面，起到了引领作用', '王琦：北京市语文骨干教师,教学副校长', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('84', '崔红艳 ', '/Uploads/ychpointimg/20160830/57c5858e16ddd.jpg', '骨干教师', '现任北京市京源学校小学部教师，从教十余年，作为区级骨干教师，多次承担市区级公开课，并获得好评。她主张课堂上要凸现语文教学新理念，力破灌输、注入式教学方法，充分调动学生的主动性，倡导语文教育新方式，并努力通过多种教学方法，激发学生学习兴趣。', '崔红艳：十余年教龄,区级骨干教师', null, null, '1', '0', null);
INSERT INTO `xxj_teacher` VALUES ('85', '李瑜', '/Uploads/ychpointimg/20160830/57c58078b7fe5.jpg', '高级教师', '硕士研究生，任教于北京大学附属小学，北京市市级骨干教师，曾荣获全国教师技能口语展示一等奖、北京市小学英语语篇和会话教学一等奖，曾承担教育部“基础教育优质数字资源建设微课项目”十四节小学英语课程的微课设计及主讲工作。论文《字母拼读在英语课堂教学中的有效性探析》荣获北京市基础教育课程教材实验优秀论文一等奖。', '李瑜：北京市级骨干教师,北大附小一线名师', null, null, '12', '0', null);
INSERT INTO `xxj_teacher` VALUES ('86', '瞿丽', '/Uploads/ychpointimg/20160830/57c585b930f38.jpg', '高级教师', '北京大学附属小学石景山学校英语教学主任，小学高级教师职称，曾先后被评为市、区级小学英语骨干教师，北师大“认知神经科学与学习”国家重点实验室攀登英语项目组外聘专家，论文多次在市、区级比赛中获奖。', '瞿丽：高级教师,区级英语骨干教师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('87', '包丽萍', '/Uploads/ychpointimg/20160830/57c585b3eb26f.jpg', '高级教师', '小学高级教师，石景山区英语骨干教师，教学经验丰富，石景山区教学大赛教学设计一等奖，教学大赛赛课一等奖，辅导学生参加市、区级竞赛获得一等奖。', '包莉萍：高级教师,区级英语骨干教师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('88', '时超赫', '/Uploads/ychpointimg/20160830/57c585aa42f0f.jpg', '高级教师', '北京市石景山区石景山小学英语教师，区青年教学能手，小学高级教师。2015年获“北京市小学生英语听说能力的培养”专题研讨活动课堂教学一等奖。2014年获石景山区“中小学教育教学设计与课堂教学”一等奖。', '时超赫：高级教师,青年教学能手', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('89', '王超南', '/Uploads/ychpointimg/20160830/57c587a659ebe.jpg', '高级教师', '高级教师，北京市东城区教师研修中心语文学科教研员，北京市东城区小学语文学科带头人。所执教的语文课获得北京市青年教师阅读教学大赛一等奖及教学设计一等奖，撰写的多篇论文获得国家级、市级、区级一、二等奖。指导多位教师分别获得国家级、市级、区级教学观摩活动以及教学设计比赛一、二等奖。', '王超男：高级教师,语文教研员', null, null, '6', '0', null);
INSERT INTO `xxj_teacher` VALUES ('91', '徐蕾', '/Uploads/ychpointimg/20160830/57c5879dc83a3.jpg', '高级教师', '北京景山学校小学语文教师。中共党员，北京市骨干教师，中学高级职称。北京景山学校小学语文组教研组长，景山教材编写组成员。曾撰写多篇教育教学论文获奖。指导多名教师参加教学比赛取得优异的成绩', '徐蕾：景山学校高级教师,市骨干教师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('92', '郝萍', '/Uploads/ychpointimg/20160830/57c58791dff5f.jpg', '骨干教师', '荣获“东城区优秀青年教师”、“东城区教育系统先进教育工作者”、“东城区骨干教师”荣誉称号，现为东城区英语学科带头人。参与中央电视台《空中课堂》、北京市名师数字课堂小学英语课（BDS）的录制工作。在第九届全国小学英语课堂教学优秀课展评中，荣获一等奖。\r\n', '郝萍：东城区英语学科带头人,空中课堂名师', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('94', '历娟', '/Uploads/ychpointimg/20160830/57c588104e260.jpg', '高级教师', '中学高级,市级数学骨干教师，现任北大附小石景山学校数学教研组长。2010年《平均数——亲近数据凸显概念的本质》获全国中小学教师“精彩一课”征文评选“教研成果奖”一等奖，2011年获石景山区第九届中小学教育教学说课展示一等奖、教学设计一等奖，连续四年被评为小学希望杯全国数学竞赛优秀辅导员。', '历娟：北大附小分校数学组长,市级骨干教师', null, null, '2', '0', null);
INSERT INTO `xxj_teacher` VALUES ('95', '霍趁趁', '/Uploads/ychpointimg/20160830/57c58809d7477.jpg', '高级教师', '小学高级,现任北大附小石景山学校数学教师，2014年11月，录像课《圆的认识》在第十五届年会“三优”评选活动中获得一等奖；2012年12月12日，可持续发展教育实验学校阶段成果展示会中，做题为《梯形的面积》数学研究课，受到特级教师吴正宪老师的好评。近年来撰写的二十余篇论文获得市区级一、二等奖，多篇文章在市区、级刊物发表。', '霍趁趁：北大附小分校高级教师', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('96', '白雪莲', '/Uploads/ychpointimg/20160830/57c58896af6c9.jpg', '骨干教师', '北京市小学语文骨干教师。1995年毕业于首都师范大学中文系，教学经验丰富，连续三届市、区学科教学骨干、北京市语文教师基本功竞赛一等奖、区十佳青年教师。', '白雪莲：北京市级骨干教师,语文名师', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('97', '刘晓群', '/Uploads/ychpointimg/20160830/57c5880454eba.jpg', '高级教师', '中学高级职称，北京市语文学科骨干教师，先后参加2次市级、6次区级教学大赛，均获得一等奖；2012年还承担了北京市数字学校名师课堂的语文录课任务8节；20余篇论文在全国、市、区级论文评选中获一、二、三等奖。先后被评为区“在教学中取得明显成绩百名优秀青年教师”、教育先进工作者、课改先进个人。', '刘晓群：高级教师,市级语文骨干教师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('98', '杨红兵', '/Uploads/ychpointimg/20160830/57c58b3b30d8c.jpg', '特级教师', '北京教育学院石景山分院教育研修中心副主任兼语文教研员。从事教育教学工作35年,2005年被评为北京市特级教师。她主持的不同研究课题获得北京市课程建设成果一等奖。有百余篇教育教学研究文章先后在国家级、市级报刊上发表,所写论文《经典阅读地方课程实施模式与策略研究》等获北京市论文特等奖,曾出版专著《小学语文实践活动研究》,曾获北京市录像课评比特等奖,现场课评优一等奖。\r\n', '杨红兵：特级教师,语文研修员', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('99', '唐欣', '/Uploads/ychpointimg/20160830/57c587f950145.jpg', '高级教师', '小学高级教师，教学经验丰富，对小学高年级的语文课堂有深入的研究。连续几年被评为石景山区语文骨干教师，有幸参与语文特级教师工作室，并在工作室中积极献课，得到好评。唐老师撰写的论文也在各级论文评比中屡获佳绩。', '唐欣：高级教师,区级语文骨干教师', null, null, '13', '0', null);
INSERT INTO `xxj_teacher` VALUES ('101', '班世伟', '/Uploads/ychpointimg/20160830/57c587e7b858c.jpg', '高级教师', '石景山区实验小学教学主任，中学高级教师，英语市级骨干。曾到英国、新西兰学习，获得过“市科研成果一等奖”、“全国优秀外语教师园丁奖”、“恩欧希教育信息化发明创新奖”、“第二届全国中小学外语教师名师”等荣誉。', '班世伟：高级教师,市级英语骨干教师', null, null, '12', '0', null);
INSERT INTO `xxj_teacher` VALUES ('102', '韩晓晶', '/Uploads/ychpointimg/20160830/57c5889f7f39e.jpg', '优秀教师', '现就职于北京市京源学校小学部，担任学校英语、法语教师。韩晓晶老师具备专业英语8级水平，通过伦敦三一口语11级考试。善于在课堂中运用情境教学法，使学生提升灵活运用英语语言的能力。同时，教师在平时的课堂中，注重对学生语音、语调以及语感的全面锻炼，致力于帮助学生说一口流利的英语、地道的英语。', '韩晓晶：一线优秀英语名师', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('103', '杨军', '/Uploads/ychpointimg/20160830/57c58b92ac6b4.jpg', '高级教师', '小教高级，教学经验丰富。曾做市、区公开课多节，参加市、区赛课和所撰写论文、教学设计多次获得市、区一、二、三等奖，多次评为优秀教育工作者，是区级数学学科的骨干教师。', '杨军：高级教师,区级数学骨干教师', null, null, '1', '0', null);
INSERT INTO `xxj_teacher` VALUES ('105', '沈艳春', '/Uploads/ychpointimg/20160830/57c58b8b692ce.jpg', '高级教师', '石景山区金顶街第二小学数学教师，小学高级教师、石景山区数学学科骨干教师。曾做区级公开课、研究课数十节；参加市、区级课堂教学大赛，分获一、二、三等奖；论文和教学设计分获国家、市、区级一、二、三等奖。并先后被评为区级优秀班主任、师德优秀教师、十佳青年教师、先进教育工作者等光荣称号。', '沈艳春：高级教师,区级数学骨干教师', null, null, '3', '0', null);
INSERT INTO `xxj_teacher` VALUES ('106', '王庆慧', '/Uploads/ychpointimg/20160830/57c58b5e0280f.jpg', '骨干教师', '北京市石景山区金顶街第二小学数学教师， 具有丰富的教育教学经验，多次被评为市级、区级骨干教师。曾三次参加石景山区创新杯大赛，均获得一等奖的成绩；所撰写的论文、教学设计多次获得市、区级一、二等奖。曾代表石景山区参加北京市小学新课程教师教学基本功培训和中展示活动，获中年段二等奖。', '王庆慧：市级骨干教师,一线数学名师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('107', '牛佳', '/Uploads/ychpointimg/20160830/57c58b54c44ab.jpg', '优秀教师', '毕业于首都师范大学，工作以来，始终以“学高为师、身正为范”为宗旨，她所撰写的教学设计、教学论文多次在国家级、市级、区级等教学比赛中获奖。', '牛佳：北京市优秀教师,高年级数学名师', null, null, '9', '0', null);
INSERT INTO `xxj_teacher` VALUES ('108', '吕颖', '/Uploads/ychpointimg/20160830/57c58b848b0ef.jpg', '高级教师', '小教高级，教学经验丰富，教师生涯中最大的事情就是一心一意为学生，教育事业就是爱的事业。关爱每一个学生，以爱动其心，走进学生的内心世界，在平等交往、真诚相待的过程中与学生建立深厚的师生情谊。', '吕颖：高级教师,高年级数学名师', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('109', '梁素霞', '/Uploads/ychpointimg/20160830/57c58b4edc706.jpg', '优秀教师', '石景山区金顶街第二小学教师。30年的教学生涯，一直从事中、高年级数学的教学。教学中精心备课，讲课思路清晰，工作精益求精，认真上好每一节课。多次被评为学生喜爱的教师。\r\n', '梁素霞：优秀教师,30年教龄数学名师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('110', '杨晓菊', '/Uploads/ychpointimg/20160830/57c58b7e8fc04.jpg', '高级教师', '1986年任小学教师，现为石景山区金二小高级教师，教学经验丰富。从教以来，热爱教育事业，积极向上，在教学中善于调动学生学习的主动性，激发学生的创造性思维，多篇论文获奖。', '杨晓菊：高级教师,30年教龄名师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('111', '周颖', '/Uploads/ychpointimg/20160830/57c58b45a24a2.jpg', '优秀教师', '北京市石景山区金顶街第二小数学教师，石景山区教学能手。她认为：学习数学，既要动脑，又要动手，在“做数学”的过程中去认识数学的价值，了解数学的特性，总结数学的规律。', '周颖：区级数学教学能手,一线名师', null, null, '7', '0', null);
INSERT INTO `xxj_teacher` VALUES ('112', '李东', '/Uploads/ychpointimg/20160830/57c58b776f88d.jpg', '高级教师', '1990毕业于师范学校，之后一直担任小学数学教学工作，教学经验丰富，取得了本科学历和小高职称。注重让学生多动手，勤动脑，培养学生自主学习能力，积极参加学校的课题活动，如《小学数学实验室建设与教学研究》和《跨越式课题》等。', '李东：高级教师,数学学科名师', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('113', '罗海华', '/Uploads/ychpointimg/20160830/57c58b7193a1c.jpg', '高级教师', '小学高级教师，2005被评为区级骨干教师。曾参与过全国JIP实验，马芯兰教改实验，中小学心理健康教育，现代信息技术与学科整合，自主学习等课题的研究。在参与“小学生问题解决能力评价研究”时被评为先进个人。撰写论文10余篇，获国家，市、区级论文评比一、二等奖。所上研究课获市、区好评。', '罗海华：高级教师,区级骨干教师', null, null, '4', '0', null);
INSERT INTO `xxj_teacher` VALUES ('114', '吴萍', '/Uploads/ychpointimg/20160830/57c58b6ad387e.jpg', '高级教师', '小学高级，区级语文骨干教师。教学经验丰富，先后参加4次区级教学大赛，分别获得一、二等奖; 多次参加全国、市、区级录像课大赛分获一、二、三等奖；多篇论文、案例在全国、市、区级论文评选中获一、二、三等奖。被评为教科研先进个人。\r\n', '吴萍：高级教师、区级语文骨干教师', null, null, '8', '0', null);
INSERT INTO `xxj_teacher` VALUES ('115', '李秀玲', '/Uploads/ychpointimg/20160830/57c58b628e219.jpg', '高级教师', '硕士研究生，小学英语高级教师，北京市京源学校莲石湖分校英语组组长。曾获石景山区教育教学大赛教学设计与课堂教学一等奖，多篇论文发表，获市、区级论文评比一、二等奖', '李秀玲：高级教师,名校英语组长', null, null, '10', '0', null);
INSERT INTO `xxj_teacher` VALUES ('116', '肖莉', '/Uploads/ychpointimg/20160830/57c5800cdaccb.jpg', '骨干教师', '北京教育学院石景山分院小学语文研修员，中学高级职称，北京市骨干教师。1989年参加工作长期从事小学语文教学、教师专业发展及相关领域的研究实践工作，曾到全国多地进行人教版小语教材的培训。多篇论文获奖或在国家级期刊发表。在小学语文教材解读、低年级识字写字教学、阅读教学两课时内容分配、图画书阅读指导等方面有深入的研究和探索实践。', '肖莉：北京市骨干教师,语文研修员', null, null, '11', '0', null);
INSERT INTO `xxj_teacher` VALUES ('117', '江萍', '/Uploads/ychpointimg/2016-07/48BE5F63F7E4532C2F8B6DA5C9BF3D15.jpg', '高级教师', '北京市东城区教师研修中心小学英语教研员、中学高级教师、北京市小学英语学科教学带头人、中国教育学会外语教学专业委员会教学指导与教师教育委员会委员、全国中小学外语教师园丁奖获得者、全国中小学外语教师名师奖获得者。', '江萍：高级教师,东城区英语教研员', null, null, '13', '0', null);

-- ----------------------------
-- Table structure for `xxj_template`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_template`;
CREATE TABLE `xxj_template` (
  `template_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模版ID',
  `template_image` varchar(255) NOT NULL COMMENT '模版图片',
  `template_name` varchar(255) NOT NULL COMMENT '模版名称',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `UIID` int(11) NOT NULL COMMENT 'UIID',
  `params` text NOT NULL COMMENT '参数：类型、描述、专题ID',
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='专题模版表';

-- ----------------------------
-- Records of xxj_template
-- ----------------------------
INSERT INTO `xxj_template` VALUES ('1', 'www.uflowertv.com', '模板1', '3', '1234', '12112');

-- ----------------------------
-- Table structure for `xxj_user`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_user`;
CREATE TABLE `xxj_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `card` varchar(32) NOT NULL COMMENT '用户卡号',
  `user_addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `post_code` varchar(12) DEFAULT NULL COMMENT '邮编',
  `openId` varchar(255) DEFAULT NULL COMMENT '微信号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_sel6uxjhso868umas4u4v7tn1` (`card`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of xxj_user
-- ----------------------------
INSERT INTO `xxj_user` VALUES ('1', '3', '9950000000337345', null, null, null, null, null, '2016-12-26 16:12:17');
INSERT INTO `xxj_user` VALUES ('2', '3', '23232324565', null, null, null, null, null, '2017-01-05 15:03:15');
INSERT INTO `xxj_user` VALUES ('3', '3', '23232324565333', null, null, null, null, null, '2017-01-05 15:03:27');
INSERT INTO `xxj_user` VALUES ('5', '3', '23123', null, null, null, null, null, '2017-01-10 13:08:54');
INSERT INTO `xxj_user` VALUES ('6', '3', '123', null, null, null, null, null, '2017-01-10 06:46:36');
INSERT INTO `xxj_user` VALUES ('7', '1', '192379huh', null, null, null, null, null, '2017-01-10 15:05:21');
INSERT INTO `xxj_user` VALUES ('8', '1', '192379huh111^&^%$', null, null, null, null, null, '2017-01-10 15:18:54');
INSERT INTO `xxj_user` VALUES ('9', '1', '192379huh111^--__QAaaa 是&^%$', null, null, null, null, null, '2017-01-10 15:19:18');
INSERT INTO `xxj_user` VALUES ('10', '1', '1', null, null, null, null, null, '2017-01-10 15:19:59');
INSERT INTO `xxj_user` VALUES ('13', '1', '12346888JJHJHBJBjbjbjb 你好', null, null, null, null, null, '2017-01-10 15:20:53');
INSERT INTO `xxj_user` VALUES ('16', '3', 'BJBjbjbjb 你好', null, null, null, null, null, '2017-01-10 15:22:31');
INSERT INTO `xxj_user` VALUES ('17', '3', '546546ytyfj', null, null, null, null, null, '2017-01-10 20:30:05');
INSERT INTO `xxj_user` VALUES ('18', '3', '3cacq19a5v70', null, null, null, null, null, '2017-01-11 06:02:09');
INSERT INTO `xxj_user` VALUES ('19', '3', 'cacq19a5v70', null, null, null, null, null, '2017-01-11 06:13:14');
INSERT INTO `xxj_user` VALUES ('20', '3', '2323', null, null, null, null, null, '2017-01-13 14:52:09');

-- ----------------------------
-- Table structure for `xxj_video`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_video`;
CREATE TABLE `xxj_video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频ID',
  `video_name` varchar(200) NOT NULL COMMENT '视频名称',
  `duration` varchar(255) DEFAULT NULL COMMENT '视频时长',
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `grade_id` int(11) DEFAULT NULL COMMENT '年级ID',
  `subject_id` int(11) DEFAULT NULL COMMENT '科目ID',
  `point_id` int(11) DEFAULT NULL COMMENT '知识点ID',
  `term` int(1) DEFAULT NULL COMMENT '学期：1:上学期2:下学期',
  `teacher_id` int(11) NOT NULL COMMENT '教师ID',
  `created` datetime NOT NULL COMMENT '创建时间',
  `video_status` int(11) NOT NULL COMMENT '状态：0：可用1：不可用',
  `is_free` int(11) NOT NULL COMMENT '免费：0：收费1：免费',
  `courseware_count` int(11) NOT NULL COMMENT '课件数量',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`video_id`),
  KEY `xued_id` (`xued_id`),
  KEY `grade_id` (`grade_id`),
  KEY `subject_id` (`subject_id`),
  KEY `point_id` (`point_id`),
  CONSTRAINT `xxj_video_ibfk_1` FOREIGN KEY (`xued_id`) REFERENCES `xxj_xued` (`xued_id`),
  CONSTRAINT `xxj_video_ibfk_2` FOREIGN KEY (`grade_id`) REFERENCES `xxj_grade` (`grade_id`),
  CONSTRAINT `xxj_video_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `xxj_subject` (`subject_id`),
  CONSTRAINT `xxj_video_ibfk_4` FOREIGN KEY (`point_id`) REFERENCES `xxj_point` (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2076 DEFAULT CHARSET=utf8 COMMENT='视频表';

-- ----------------------------
-- Records of xxj_video
-- ----------------------------
INSERT INTO `xxj_video` VALUES ('2', '集气瓶的使用', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:00', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('3', '控制变量法在化学实验中的应用', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:00', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('4', '苯（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('5', '苯（二）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('6', '化学键（二）上', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('7', '化学键（三）上', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('8', '化学键（三）下 ', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('9', '化学键（一）上', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('10', '化学键（一）下', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('11', '化学能与热能（二）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:01', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('12', '化学能与热能（一）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:01', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('13', '基本营养物质（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('15', '乙醇（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('16', '乙醇（二）上', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('17', '乙醇（二）下', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('18', '乙酸（二）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('19', '乙酸（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('20', '乙烯（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:01', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('21', '元素周期表（二）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('22', '元素周期表（三）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('23', '元素周期表（一）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('24', '元素周期律（二）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('25', '元素周期律（三）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('26', '元素周期律（一）', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:01', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('27', '光合色素', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:01', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('28', '光合作用（一）', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:01', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('29', '核酸', '', '39780', '39784', '39840', '40118', '0', '25', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('31', '糖类和脂质', '', '39780', '39784', '39840', '40118', '0', '25', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('32', '无机物', '', '39780', '39784', '39840', '40118', '0', '25', '2017-01-06 17:05:01', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('33', '细胞的癌变', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('34', '细胞的分化', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('35', '细胞的衰老和凋亡', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('36', '细胞的物质输入与输出', '', '39780', '39784', '39840', '40120', '0', '25', '2017-01-06 17:05:01', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('37', '细胞的增殖（一）', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('38', '细胞的增殖（二）', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('39', '细胞的增殖（四）', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:01', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('40', '细胞核', '', '39780', '39784', '39840', '40119', '0', '25', '2017-01-06 17:05:01', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('41', '细胞呼吸（一）', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:01', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('42', '走近细胞', '', '39780', '39784', '39840', '40117', '0', '25', '2017-01-06 17:05:01', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('43', '细胞的代谢', '', '39780', '39786', '39858', '40314', '0', '18', '2017-01-06 17:05:01', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('44', '细胞的分化、衰老和凋亡', '', '39780', '39786', '39858', '40314', '0', '18', '2017-01-06 17:05:01', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('45', '细胞的分子组成', '', '39780', '39786', '39858', '40314', '0', '18', '2017-01-06 17:05:01', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('46', '细胞的结构', '', '39780', '39786', '39858', '40314', '0', '18', '2017-01-06 17:05:01', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('47', '细胞的增殖', '', '39780', '39786', '39858', '40314', '0', '18', '2017-01-06 17:05:01', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('48', '阿伏加德罗常数', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:01', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('49', '氮及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:01', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('50', '化学平衡状态的判断', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:01', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('51', '化学实验探究', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:01', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('52', '基本化学用语', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:01', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('53', '基本营养物质', '', '39780', '39786', '39857', '40312', '0', '17', '2017-01-06 17:05:01', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('54', '离子共存', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:01', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('57', '硫及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('58', '铝及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('59', '氯及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:02', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('60', '钠及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('61', '热化学方程式的书写及正误判断', '', '39780', '39785', '39848', '40227', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('62', '弱电解质电离', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('63', '铁及其化合物', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:02', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('64', '同分异构体', '', '39780', '39786', '39857', '40312', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('65', '物质的变化和分类', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('66', '物质的检验、分离和提纯', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:02', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('67', '物质的性质', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('68', '物质的制备', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('69', '盐类水解的应用', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('70', '氧化还原反应的比较', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('71', '氧化还原反应的计算', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('72', '影响化学平衡移动的因素', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('73', '有机合成与推断', '', '39780', '39786', '39857', '40312', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('74', '与量有关的离子反应方程式', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:02', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('75', '与速率和平衡有关的图像分析', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('76', '元素周期律及其应用', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('77', '原电池原理及其应用', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('78', '综合实验分析', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('79', '高分子化合物', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('80', '羧酸  酯', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('81', '糖类 油脂 蛋白质', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('82', '研究有机物的一般步骤和方法', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('83', '有机合成（一）', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('84', '有机合成（二）', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('85', '有机物的分类、结构特点和命名', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('86', '脂肪烃', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('87', '化学电源', '', '39780', '39785', '39848', '40230', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('88', '化学反应热的计算', '', '39780', '39785', '39848', '40227', '0', '17', '2017-01-06 17:05:02', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('89', '化学反应速率', '', '39780', '39785', '39848', '40228', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('90', '化学平衡图像', '', '39780', '39785', '39848', '40228', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('91', '化学平衡状态', '', '39780', '39785', '39848', '40228', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('92', '金属的腐蚀与防护', '', '39780', '39785', '39848', '40230', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('93', '难溶电解质的溶解平衡', '', '39780', '39785', '39848', '40229', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('94', '燃烧热', '', '39780', '39785', '39848', '40227', '0', '17', '2017-01-06 17:05:02', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('95', '溶液酸碱性', '', '39780', '39785', '39848', '40229', '0', '17', '2017-01-06 17:05:02', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('96', '弱电解质', '', '39780', '39785', '39848', '40229', '0', '17', '2017-01-06 17:05:02', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('97', '水的电离', '', '39780', '39785', '39848', '40229', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('98', '盐类的水解', '', '39780', '39785', '39848', '40229', '0', '17', '2017-01-06 17:05:02', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('99', '影响化学反应速率的因素', '', '39780', '39785', '39848', '40228', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('100', '原电池', '', '39780', '39785', '39848', '40230', '0', '17', '2017-01-06 17:05:02', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('101', '地球的普通性与特殊性', '', '39780', '39784', '39843', '40128', '0', '20', '2017-01-06 17:05:02', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('102', '地球上的大气--三圈环流', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('103', '地球上的大气--大气的水平运动', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('104', '地球上的大气--气旋与反气旋', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('105', '地球上的大气--锋与天气', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('106', '地球上的大气--季风环流', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('107', '地球上的大气--气压带与风带对气候的影响', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('109', '地球上的大气热传递的过程下', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('110', '地球上的大气--热力环流', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:02', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('111', '地球自转的地理意义', '', '39780', '39784', '39843', '40128', '0', '20', '2017-01-06 17:05:02', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('112', '地球公转的地理意义', '', '39780', '39784', '39843', '40128', '0', '20', '2017-01-06 17:05:02', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('113', '太阳对地球的影响', '', '39780', '39784', '39843', '40128', '0', '20', '2017-01-06 17:05:02', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('114', '城市的区位选择和分布特征描述  （上）', '', '39780', '39786', '39861', '40321', '0', '23', '2017-01-06 17:05:02', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('115', '城市的区位选择和分布特征描述(下）  ', '', '39780', '39786', '39861', '40321', '0', '23', '2017-01-06 17:05:02', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('116', '人口数量的变化上', '', '39780', '39786', '39861', '40320', '0', '23', '2017-01-06 17:05:02', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('117', '人口数量的变化下', '', '39780', '39786', '39861', '40320', '0', '23', '2017-01-06 17:05:02', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('118', '地球运动的特点', '', '39780', '39786', '39861', '40325', '0', '23', '2017-01-06 17:05:02', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('119', '地球自转与公转的地理意义', '', '39780', '39786', '39861', '40325', '0', '23', '2017-01-06 17:05:02', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('120', '地球的圈层构造和岩石圈物质循环（上）', '', '39780', '39786', '39861', '40325', '0', '23', '2017-01-06 17:05:02', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('121', '地球的圈层构造和岩石圈物质循环（下）', '', '39780', '39786', '39861', '40325', '0', '23', '2017-01-06 17:05:02', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('122', '大气的水平运动', '', '39780', '39786', '39861', '40326', '0', '23', '2017-01-06 17:05:02', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('123', '大气受热过程与日温差变化', '', '39780', '39786', '39861', '40326', '0', '23', '2017-01-06 17:05:02', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('124', '热力环流的形成和运用 （一）', '', '39780', '39786', '39861', '40326', '0', '23', '2017-01-06 17:05:02', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('125', '热力环流的形成和运用 （二）', '', '39780', '39786', '39861', '40326', '0', '23', '2017-01-06 17:05:02', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('126', '水循环及其地理意义', '', '39780', '39786', '39861', '40327', '0', '23', '2017-01-06 17:05:02', '0', '0', '30', '0');
INSERT INTO `xxj_video` VALUES ('127', '洋流及其对地理环境的影响 （一）', '', '39780', '39786', '39861', '40327', '0', '23', '2017-01-06 17:05:02', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('128', '洋流及其对地理环境的影响（二）', '', '39780', '39786', '39861', '40327', '0', '23', '2017-01-06 17:05:02', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('129', '商品与货币', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:02', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('130', '价格（一）', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:02', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('131', '动词不定式（三）', '', '39780', '39784', '39837', '40188', '0', '14', '2017-01-06 17:05:02', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('132', '价格（二）', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('133', '价格对经济生活的影响', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:03', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('135', '信用工具与外汇（一）', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:03', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('136', '信用工具与外汇（二）', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:03', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('137', '我们的生活消费', '', '39780', '39784', '39841', '40139', '0', '22', '2017-01-06 17:05:03', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('138', '生产与消费', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:03', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('139', '现在完成时态', '', '39780', '39784', '39837', '40189', '0', '14', '2017-01-06 17:05:03', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('140', '我国的基本经济制度', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:03', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('141', '过去进行时', '', '39780', '39784', '39837', '40189', '0', '14', '2017-01-06 17:05:03', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('143', '短语动词', '', '39780', '39784', '39837', '40187', '0', '14', '2017-01-06 17:05:03', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('144', '经济全球化与对外开放', '', '39780', '39784', '39841', '40143', '0', '22', '2017-01-06 17:05:03', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('145', '定语从句（一）', '', '39780', '39784', '39837', '40184', '0', '14', '2017-01-06 17:05:03', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('146', '政府宏观调控', '', '39780', '39784', '39841', '40142', '0', '22', '2017-01-06 17:05:03', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('147', '科学发展观和小康社会的经济建设', '', '39780', '39784', '39841', '40142', '0', '22', '2017-01-06 17:05:03', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('148', '市场在资源配置中起决定性作用', '', '39780', '39784', '39841', '40142', '0', '22', '2017-01-06 17:05:03', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('149', '财政与税收', '', '39780', '39784', '39841', '40141', '0', '22', '2017-01-06 17:05:03', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('150', '定语从句（二）', '', '39780', '39784', '39837', '40184', '0', '14', '2017-01-06 17:05:03', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('151', '投资与理财', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('152', '定语从句（三）', '', '39780', '39784', '39837', '40184', '0', '14', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('153', '收入分配与社会公平', '', '39780', '39784', '39841', '40141', '0', '22', '2017-01-06 17:05:03', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('154', '新时代的劳动者', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:03', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('155', '情态动词（一）', '', '39780', '39784', '39837', '40186', '0', '14', '2017-01-06 17:05:03', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('156', '情态动词（三）', '', '39780', '39784', '39837', '40186', '0', '14', '2017-01-06 17:05:03', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('157', '企业的经营（二）', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:03', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('158', '状语从句（二）', '', '39780', '39784', '39837', '40185', '0', '14', '2017-01-06 17:05:03', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('159', '动词不定式（一）', '', '39780', '39784', '39837', '40188', '0', '14', '2017-01-06 17:05:03', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('160', '哲学概述', '', '39780', '39785', '39850', '40257', '0', '22', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('161', '情态动词（二）', '', '39780', '39784', '39837', '40186', '0', '14', '2017-01-06 17:05:03', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('162', '辩证唯物论（一）', '', '39780', '39785', '39850', '40258', '0', '22', '2017-01-06 17:05:03', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('163', '辩证唯物论（二）', '', '39780', '39785', '39850', '40258', '0', '22', '2017-01-06 17:05:03', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('164', '辩证唯物论（三）', '', '39780', '39785', '39850', '40258', '0', '22', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('165', '辩证唯物主义认识论（一）', '', '39780', '39785', '39850', '40258', '0', '22', '2017-01-06 17:05:03', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('166', '现在分词的时态和语态', '', '39780', '39785', '39846', '40213', '0', '14', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('167', '辩证唯物主义认识论（二）', '', '39780', '39785', '39850', '40258', '0', '22', '2017-01-06 17:05:03', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('168', '现在分词的句法功能', '', '39780', '39785', '39846', '40213', '0', '14', '2017-01-06 17:05:03', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('169', '动词-ed形式的句法功能', '', '39780', '39785', '39846', '40213', '0', '14', '2017-01-06 17:05:03', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('170', '虚拟语气（二）', '', '39780', '39785', '39846', '40214', '0', '14', '2017-01-06 17:05:03', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('171', '倒装（一）', '', '39780', '39785', '39846', '40215', '0', '14', '2017-01-06 17:05:03', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('172', '主谓一致（一）', '', '39780', '39785', '39846', '40216', '0', '14', '2017-01-06 17:05:03', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('173', '主谓一致（二）', '', '39780', '39785', '39846', '40216', '0', '14', '2017-01-06 17:05:03', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('174', '名词性从句的基本知识', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:03', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('175', '表语从句', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('176', '同位语从句', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:03', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('177', '宾语从句', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:03', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('178', '介词短语在句子中的作用', '', '39780', '39786', '39855', '40293', '0', '14', '2017-01-06 17:05:03', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('179', '介词的分类与辨析', '', '39780', '39786', '39855', '40293', '0', '14', '2017-01-06 17:05:03', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('180', 'it作人称和指示代词及强调结构', '', '39780', '39786', '39855', '40294', '0', '14', '2017-01-06 17:05:03', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('181', 'it作形式主语与形式宾语', '', '39780', '39786', '39855', '40294', '0', '14', '2017-01-06 17:05:03', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('182', 'there be 结构', '', '39780', '39786', '39855', '40295', '0', '14', '2017-01-06 17:05:03', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('183', '陈述句与疑问句', '', '39780', '39786', '39855', '40297', '0', '14', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('184', '离子浓度大小比较（一）', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:03', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('185', '离子浓度大小比较（二）', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:03', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('186', '反义疑问句', '', '39780', '39786', '39855', '40297', '0', '14', '2017-01-06 17:05:03', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('187', 'the的用法学习', '', '39779', '39781', '39789', '40168', '0', '24', '2017-01-06 17:05:03', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('188', '不定代词的用法（一）', '', '39779', '39781', '39789', '40170', '0', '24', '2017-01-06 17:05:03', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('189', '不定代词的用法（二）', '', '39779', '39781', '39789', '40170', '0', '24', '2017-01-06 17:05:03', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('190', '零冠词', '', '39779', '39781', '39789', '40168', '0', '24', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('191', '介词的种类和用法（一）', '', '39779', '39781', '39789', '40171', '0', '24', '2017-01-06 17:05:03', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('192', '介词的种类和用法（二）', '', '39779', '39781', '39789', '40171', '0', '24', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('193', '连词的用法（二）', '', '39779', '39781', '39789', '40172', '0', '24', '2017-01-06 17:05:03', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('194', '名词的分类、数和所有格', '', '39779', '39781', '39789', '40169', '0', '24', '2017-01-06 17:05:03', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('195', '副词的用法（一）', '', '39779', '39782', '39792', '40174', '0', '24', '2017-01-06 17:05:03', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('196', '副词的用法（二）', '', '39779', '39782', '39792', '40174', '0', '24', '2017-01-06 17:05:03', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('197', '数词的种类和用法（一）', '', '39779', '39782', '39792', '40175', '0', '24', '2017-01-06 17:05:03', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('198', '数词的种类和用法（二）', '', '39779', '39782', '39792', '40175', '0', '24', '2017-01-06 17:05:03', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('199', '形容词的用法（一）', '', '39779', '39782', '39792', '40173', '0', '24', '2017-01-06 17:05:03', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('200', '形容词的用法（二）', '', '39779', '39782', '39792', '40173', '0', '24', '2017-01-06 17:05:03', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('201', '主动语态与被动语态', '', '39779', '39782', '39792', '40177', '0', '24', '2017-01-06 17:05:03', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('202', '动词时态（三）', '', '39779', '39782', '39792', '40177', '0', '24', '2017-01-06 17:05:03', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('203', '词义猜测上', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('204', '词义猜测下', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '28', '0');
INSERT INTO `xxj_video` VALUES ('206', '事实细节下', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('207', '推理判断上', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('208', '推理判断下', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('209', '主旨大意上', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('210', '主旨大意下', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:03', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('211', '重力做功与重力势能', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:03', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('212', '超重和失重', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('214', '弹力', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('215', '动力学两类问题（1）—常规方法', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('216', '动力学两类问题（2）—整体法与隔离法', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('217', '动力学两类问题（3）—图象问题', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('218', '动能定理（二）', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('219', '动能定理（一）', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('220', '分运动与合运动', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('221', '功', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('222', '功率 车辆的两种典型起动', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('223', '开普勒三定律', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:04', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('224', '力的合成与分解', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('225', '力的基础知识', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('226', '摩擦力', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('227', '摩擦力做功的特点', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('228', '平抛运动（二）', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('229', '平抛运动（一）', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('230', '曲线运动的条件', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('231', '三力平衡问题（一）—静态平衡', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('232', '三力平衡问题（二）—动态平衡', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('233', '三种宇宙速度', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:04', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('234', '探究弹簧弹性势能的表达式', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('235', '同步卫星', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('236', '万有引力定律', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('237', '卫星运动的几组概念', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:04', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('238', '小船过河', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('239', '圆周运动（二）—实例分析', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('240', '圆周运动（三）—竖直平面内的圆周运动', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('241', '重力 基本相互作用', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('243', '弹簧的串联和并联', '', '39780', '39784', '39838', '40105', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('244', '二次方程的实根分布', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('245', '二次函数（1）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('246', '二次函数（2）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('247', '函数单调性（1）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('248', '函数单调性（2）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('249', '函数概念', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('250', '函数奇偶性（1）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('251', '函数奇偶性（2）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('252', '函数周期性与对称性（1）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('253', '函数周期性与对称性（2）', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('254', '集合', '', '39780', '39784', '39836', '40091', '0', '13', '2017-01-06 17:05:04', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('255', '电荷', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('256', '带电粒子在电场中的运动（一）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('257', '带电粒子在电场中的运动（二）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('258', '带电粒子在电场中的运动（三）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('259', '带电粒子在电场中的运动（四）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('260', '等势面', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('261', '电场强度（一）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('262', '电场强度（二）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('263', '电场强度（三）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('264', '电容器（一）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('265', '电容器（二）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('266', '电容器（三）', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('267', '电势', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('268', '电势差', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('269', '电势差与电场强度的关系', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('270', '电势能', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('271', '库仑定律', '', '39780', '39785', '39847', '40218', '0', '9', '2017-01-06 17:05:04', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('272', 'DNA的分子复制', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('273', 'DNA的分子结构', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('275', '伴性遗传（一）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('276', '伴性遗传（二）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('277', '基因对性状的控制', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('278', '基因是有遗传效应的DNA片段', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('279', 'DNA是主要的遗传物质（一）', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('280', '基因突变和基因重组', '', '39780', '39784', '39840', '40126', '0', '25', '2017-01-06 17:05:04', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('281', '基因在染色体上', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('282', '基因指导蛋白质的合成（二）', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('283', '基因指导蛋白质的合成（一）', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:04', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('284', '减数分裂（一）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('285', '减数分裂（二）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('286', '减数分裂（三）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('287', '减数分裂（四）', '', '39780', '39784', '39840', '40124', '0', '25', '2017-01-06 17:05:04', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('288', '两对相对性状的杂交试验（二）', '', '39780', '39784', '39840', '40123', '0', '25', '2017-01-06 17:05:04', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('289', '染色体变异（二）', '', '39780', '39784', '39840', '40126', '0', '25', '2017-01-06 17:05:04', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('290', '染色体变异（一）', '', '39780', '39784', '39840', '40126', '0', '25', '2017-01-06 17:05:04', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('291', '现代生物进化论的由来', '', '39780', '39784', '39840', '40127', '0', '25', '2017-01-06 17:05:04', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('292', '现代生物进化论的主要内容', '', '39780', '39784', '39840', '40127', '0', '25', '2017-01-06 17:05:04', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('293', '一对相对性状的杂交试验（一）', '', '39780', '39784', '39840', '40123', '0', '25', '2017-01-06 17:05:04', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('301', '声的利用', '', '39779', '39782', '39793', '40026', '1', '10', '2017-01-06 17:05:04', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('302', '声音的特性', '', '39779', '39782', '39793', '40026', '1', '10', '2017-01-06 17:05:04', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('304', '运动的快慢', '', '39779', '39782', '39793', '40025', '1', '10', '2017-01-06 17:05:04', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('305', '噪声的危害和控制', '', '39779', '39782', '39793', '40026', '1', '10', '2017-01-06 17:05:05', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('306', '长度和时间的测量', '', '39779', '39782', '39793', '40025', '1', '10', '2017-01-06 17:05:05', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('307', '一对相对性状的杂交试验（二）', '', '39780', '39784', '39840', '40123', '0', '25', '2017-01-06 17:05:05', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('308', '常用仪器及实验基本操作', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('309', '定量实验', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('310', '二氧化碳与氢氧化钠反应', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('312', '复分解反应发生的条件', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('313', '根据化学方程式进行简单计算', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('314', '配制一定溶质质量分数的溶液  溶质质量分数的计算', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('315', '气体的制取、干燥和净化', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('316', '氢氧化钠变质的证明', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('317', '图像专题', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('318', '物质的检验、分离和提纯', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('319', '物质推断', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('320', '压强专题', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('321', '中和反应和pH的测定', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:05', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('322', '元素周期表的结构及其应用', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:05', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('323', '金属的腐蚀与防护', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:05', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('324', '化学实验基本操作', '', '39780', '39786', '39857', '40311', '0', '17', '2017-01-06 17:05:05', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('325', '化学反应中的能量变化', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:05', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('326', '工业流程为背景的试题分析（一）', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:05', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('327', '工业流程为背景的试题分析（二）', '', '39780', '39786', '39857', '40310', '0', '17', '2017-01-06 17:05:05', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('328', '盖斯定律及其应用', '', '39780', '39786', '39857', '40308', '0', '17', '2017-01-06 17:05:05', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('329', '电解原理及其应用', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:05', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('330', '古代监察制度', '', '39780', '39784', '39842', '40148', '0', '21', '2017-01-06 17:05:05', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('332', '古代选拔官吏制度', '', '39780', '39784', '39842', '40148', '0', '21', '2017-01-06 17:05:05', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('333', '明清政治制度', '', '39780', '39784', '39842', '40148', '0', '21', '2017-01-06 17:05:05', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('334', '古代希腊罗马的政治制度', '', '39780', '39784', '39842', '40149', '0', '21', '2017-01-06 17:05:05', '1', '1', '67', '0');
INSERT INTO `xxj_video` VALUES ('336', '电解池', '', '39780', '39785', '39848', '40230', '0', '17', '2017-01-06 17:05:05', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('337', '化学平衡常数', '', '39780', '39785', '39848', '40228', '0', '17', '2017-01-06 17:05:05', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('338', '罗马的政治和法律制度', '', '39780', '39784', '39842', '40149', '0', '21', '2017-01-06 17:05:05', '1', '1', '34', '0');
INSERT INTO `xxj_video` VALUES ('339', '雅典城邦的民主政治', '', '39780', '39784', '39842', '40149', '0', '21', '2017-01-06 17:05:05', '0', '0', '40', '0');
INSERT INTO `xxj_video` VALUES ('340', '北美大陆上的新体制', '', '39780', '39784', '39842', '40150', '0', '21', '2017-01-06 17:05:05', '0', '0', '52', '0');
INSERT INTO `xxj_video` VALUES ('341', '欧美资产阶级代议制的确立和发展', '', '39780', '39784', '39842', '40150', '0', '21', '2017-01-06 17:05:05', '0', '0', '36', '0');
INSERT INTO `xxj_video` VALUES ('342', '欧洲大陆的政体改革', '', '39780', '39784', '39842', '40150', '0', '21', '2017-01-06 17:05:05', '1', '1', '37', '0');
INSERT INTO `xxj_video` VALUES ('343', '地球上的大气热传递的过程上', '', '39780', '39784', '39843', '40129', '0', '20', '2017-01-06 17:05:05', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('344', '动词不定式（二）', '', '39780', '39784', '39837', '40188', '0', '14', '2017-01-06 17:05:05', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('345', '过去完成时态', '', '39780', '39784', '39837', '40189', '0', '14', '2017-01-06 17:05:05', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('346', '状语从句（一）', '', '39780', '39784', '39837', '40185', '0', '14', '2017-01-06 17:05:05', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('347', '动名词', '', '39780', '39785', '39846', '40212', '0', '14', '2017-01-06 17:05:05', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('348', '虚拟语气（一）', '', '39780', '39785', '39846', '40214', '0', '14', '2017-01-06 17:05:05', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('349', '倒装（二）', '', '39780', '39785', '39846', '40215', '0', '14', '2017-01-06 17:05:05', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('350', '直接引语和间接引语', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:05', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('351', '祈使句和感叹句', '', '39780', '39786', '39855', '40297', '0', '14', '2017-01-06 17:05:05', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('352', '使用替代词的省略', '', '39780', '39786', '39855', '40296', '0', '14', '2017-01-06 17:05:05', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('353', '介词宾语', '', '39780', '39786', '39855', '40293', '0', '14', '2017-01-06 17:05:05', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('354', '介词与介词在句中的位置', '', '39780', '39786', '39855', '40293', '0', '14', '2017-01-06 17:05:05', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('355', '词的分类', '', '39779', '39781', '39787', '39986', '1', '26', '2017-01-06 17:05:05', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('356', '单句的结构', '', '39779', '39781', '39787', '39986', '1', '26', '2017-01-06 17:05:05', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('357', '短语结构', '', '39779', '39781', '39787', '39986', '1', '26', '2017-01-06 17:05:05', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('358', '古诗鉴赏（二）', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('359', '古诗鉴赏（一）', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('360', '汉字', '', '39779', '39781', '39787', '39986', '1', '26', '2017-01-06 17:05:05', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('362', '文言文阅读（二）', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('363', '文言文阅读（三）', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('364', '文言文阅读（一）', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('365', '写作（二）命题作文', '', '39779', '39781', '39787', '39988', '1', '26', '2017-01-06 17:05:05', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('366', '写作（三）半命题作文', '', '39779', '39781', '39787', '39988', '1', '26', '2017-01-06 17:05:05', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('367', '写作（一）', '', '39779', '39781', '39787', '39988', '1', '26', '2017-01-06 17:05:05', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('368', '阅读（二）说明文', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:05', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('369', '材料探究', '', '39779', '39782', '39790', '40007', '1', '26', '2017-01-06 17:05:05', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('370', '古诗鉴赏（二）', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('371', '古诗鉴赏（一）', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('372', '古诗文背诵默写', '', '39779', '39782', '39790', '40005', '1', '26', '2017-01-06 17:05:05', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('373', '名著阅读', '', '39779', '39782', '39790', '40005', '1', '26', '2017-01-06 17:05:05', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('374', '图表类探究题', '', '39779', '39782', '39790', '40007', '1', '26', '2017-01-06 17:05:05', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('375', '文学文化常识', '', '39779', '39782', '39790', '40005', '1', '26', '2017-01-06 17:05:05', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('376', '文言文阅读（二）', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('377', '文言文阅读（三）', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('378', '文言文阅读（一）', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('379', '写作（二）材料作文', '', '39779', '39782', '39790', '40008', '1', '26', '2017-01-06 17:05:05', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('380', '写作（三）话题作文', '', '39779', '39782', '39790', '40008', '1', '26', '2017-01-06 17:05:05', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('381', '写作（一）', '', '39779', '39782', '39790', '40008', '1', '26', '2017-01-06 17:05:05', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('382', '阅读（二）小说', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('383', '阅读（一）议论文', '', '39779', '39782', '39790', '40006', '1', '26', '2017-01-06 17:05:05', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('384', '常见文言文句式', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:05', '0', '0', '32', '0');
INSERT INTO `xxj_video` VALUES ('385', '高考备考策略', '', '39780', '39786', '39853', '40280', '0', '15', '2017-01-06 17:05:05', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('386', '古代词曲的阅读与鉴赏', '', '39780', '39786', '39853', '40282', '0', '15', '2017-01-06 17:05:05', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('387', '选题角度小', '', '39780', '39786', '39853', '40284', '0', '15', '2017-01-06 17:05:05', '1', '1', '30', '0');
INSERT INTO `xxj_video` VALUES ('388', '语言表达  简明、连贯、得体（二）', '', '39780', '39786', '39853', '40281', '0', '15', '2017-01-06 17:05:06', '0', '0', '36', '0');
INSERT INTO `xxj_video` VALUES ('389', '如何巧妙“变通”素材', '', '39780', '39786', '39853', '40284', '0', '15', '2017-01-06 17:05:06', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('390', '社科文阅读方法和步骤', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:06', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('391', '诗歌鉴赏的常考题型', '', '39780', '39786', '39853', '40282', '0', '15', '2017-01-06 17:05:06', '0', '0', '29', '0');
INSERT INTO `xxj_video` VALUES ('392', '谈谈作文的审题和立意', '', '39780', '39786', '39853', '40284', '0', '15', '2017-01-06 17:05:06', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('393', '文言文阅读专题', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:06', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('394', '语言表达  简明、连贯、得体（一）', '', '39780', '39786', '39853', '40281', '0', '15', '2017-01-06 17:05:06', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('395', '阅读小说的技巧（一）', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:06', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('396', '阅读小说的技巧 （二）', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:06', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('397', '人物传记阅读专题（二）', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:06', '0', '0', '41', '0');
INSERT INTO `xxj_video` VALUES ('398', '金属的化学性质（二）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:06', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('399', '金属的化学性质（一）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:06', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('400', '离子反应（一）上', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('401', '离子反应（一）下', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('402', '离子反应（二）上', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('403', '离子反应（二）下', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('404', '离子共存', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('405', '钠的化合物（二）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:06', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('406', '钠的化合物（一）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:06', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('407', '气体摩尔体积', '', '39780', '39784', '39839', '40109', '0', '19', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('408', '物质的分类及各类物质间的关系（一）', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('409', '物质的量浓度', '', '39780', '39784', '39839', '40109', '0', '19', '2017-01-06 17:05:06', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('410', '物质的分类及各类物质间的关系（二）', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('411', '氧化还原反应（一）', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('412', '氧化还原反应（二）', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('413', '氧化还原反应（三）', '', '39780', '39784', '39839', '40110', '0', '19', '2017-01-06 17:05:06', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('414', '什么是电荷', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('415', '电流的形成', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('416', '电路', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('417', '串联和并联', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('418', '专题一：电路的识别', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('419', '电流的测量', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('420', '串、并联电路中电流的规律', '', '39779', '39783', '39797', '40059', '1', '10', '2017-01-06 17:05:06', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('421', '电压的测量', '', '39779', '39783', '39797', '40060', '1', '10', '2017-01-06 17:05:06', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('422', '串、并联电路中电压的规律', '', '39779', '39783', '39797', '40060', '1', '10', '2017-01-06 17:05:06', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('423', '燃烧和灭火', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('424', '溶液的分类和溶解度', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:06', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('425', '溶液的组成和溶解', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:06', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('426', '碳和碳的氧化物', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('427', '公民参与政治生活(一)', '', '39780', '39784', '39841', '40275', '0', '22', '2017-01-06 17:05:06', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('428', '公民参与政治生活（二）', '', '39780', '39784', '39841', '40275', '0', '22', '2017-01-06 17:05:06', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('429', '政府为人民服务', '', '39780', '39784', '39841', '40276', '0', '22', '2017-01-06 17:05:06', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('430', '政府要提高依法行政水平', '', '39780', '39784', '39841', '40276', '0', '22', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('431', '我国的政党制度（一）', '', '39780', '39784', '39841', '40277', '0', '22', '2017-01-06 17:05:06', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('432', '我国的政党制度（二）', '', '39780', '39784', '39841', '40277', '0', '22', '2017-01-06 17:05:06', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('433', '人民代表大会', '', '39780', '39784', '39841', '40277', '0', '22', '2017-01-06 17:05:06', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('434', '民族区域自治制度', '', '39780', '39784', '39841', '40277', '0', '22', '2017-01-06 17:05:06', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('435', '当代国际社会', '', '39780', '39784', '39841', '40278', '0', '22', '2017-01-06 17:05:06', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('436', '运动的描述（一）', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('437', '运动的描述（二）', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('438', '匀变速直线运动（一）—三个重要规律', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('439', '匀变速直线运动（二）—三个重要推论', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('440', '匀变速直线运动（三）—五个二级结论', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('441', '自由落体', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('442', '竖直上抛', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('443', '匀变速直线运动解题方法（一）—一般公式法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('444', '匀变速直线运动解题方法（二）—平均速度法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('445', '匀变速直线运动解题方法（三）—图象法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('446', '匀变速直线运动解题方法（五）—逆推法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('447', '匀变速直线运动解题方法（六）—比例法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('448', '匀变速直线运动解题方法（七）—递推法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('449', '匀变速直线运动解题方法（四）—推论法', '', '39780', '39784', '39838', '40104', '0', '9', '2017-01-06 17:05:06', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('450', '圆周运动（一）—基础知识', '', '39780', '39784', '39838', '40106', '0', '9', '2017-01-06 17:05:06', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('451', '卫星的稳定运行与变轨运行', '', '39780', '39784', '39838', '40107', '0', '9', '2017-01-06 17:05:06', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('452', '机械能守恒定律（一）', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:06', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('453', '机械能守恒定律（二）', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:06', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('455', '人物的个性，作文的魅力体现', '', '39780', '39784', '39835', '40088', '0', '27', '2017-01-06 17:05:06', '1', '1', '41', '0');
INSERT INTO `xxj_video` VALUES ('456', '有理数', '', '39779', '39781', '39788', '39993', '1', '12', '2017-01-06 17:05:06', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('457', '绝对值', '', '39779', '39781', '39788', '39993', '1', '12', '2017-01-06 17:05:06', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('458', '有理数的运算（1）', '', '39779', '39781', '39788', '39993', '1', '12', '2017-01-06 17:05:06', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('459', '有理数的运算（2）', '', '39779', '39781', '39788', '39993', '1', '12', '2017-01-06 17:05:06', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('460', '散文类文章的结构', '', '39780', '39784', '39835', '40089', '0', '27', '2017-01-06 17:05:06', '1', '1', '49', '0');
INSERT INTO `xxj_video` VALUES ('461', '审题与扣题', '', '39780', '39784', '39835', '40090', '0', '27', '2017-01-06 17:05:06', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('462', '细节描写好，三动四态是根本', '', '39780', '39784', '39835', '40088', '0', '27', '2017-01-06 17:05:06', '0', '0', '41', '0');
INSERT INTO `xxj_video` VALUES ('463', '小而大之，立意新颖的方法', '', '39780', '39784', '39835', '40088', '0', '27', '2017-01-06 17:05:06', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('464', '议论文的三种结构方法', '', '39780', '39784', '39835', '40090', '0', '27', '2017-01-06 17:05:06', '0', '0', '26', '0');
INSERT INTO `xxj_video` VALUES ('465', '议论文事实论据的特点与转述', '', '39780', '39784', '39835', '40090', '0', '27', '2017-01-06 17:05:06', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('466', '真情实感，文章的生命', '', '39780', '39784', '39835', '40088', '0', '27', '2017-01-06 17:05:06', '1', '1', '47', '0');
INSERT INTO `xxj_video` VALUES ('480', '开发利用金属矿物和海水资源（一）', '', '39780', '39784', '39839', '40116', '0', '11', '2017-01-06 17:05:07', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('481', '开发利用金属矿物和海水资源（二）', '', '39780', '39784', '39839', '40116', '0', '11', '2017-01-06 17:05:07', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('482', '化学与资源综合利用  环境保护（一）', '', '39780', '39784', '39839', '40116', '0', '11', '2017-01-06 17:05:07', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('483', '化学与资源综合利用  环境保护（二）', '', '39780', '39784', '39839', '40116', '0', '11', '2017-01-06 17:05:07', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('484', '化学能与电能（一）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:07', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('485', '化学能与电能（三）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:07', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('486', '化学反应速率和限度（三）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:07', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('487', '化学反应速率和限度（二）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:07', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('490', '板块构造学说', '', '39780', '39784', '39843', '40131', '0', '20', '2017-01-06 17:05:07', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('491', '内力作用', '', '39780', '39784', '39843', '40131', '0', '20', '2017-01-06 17:05:07', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('492', '水循环', '', '39780', '39784', '39843', '40130', '0', '20', '2017-01-06 17:05:07', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('493', '外力作用', '', '39780', '39784', '39843', '40131', '0', '20', '2017-01-06 17:05:07', '1', '1', '44', '0');
INSERT INTO `xxj_video` VALUES ('494', '洋流', '', '39780', '39784', '39843', '40130', '0', '20', '2017-01-06 17:05:07', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('495', '自然带', '', '39780', '39784', '39843', '40132', '0', '20', '2017-01-06 17:05:07', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('496', '人口增长', '', '39780', '39785', '39852', '40246', '0', '20', '2017-01-06 17:05:07', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('497', '人口迁移', '', '39780', '39785', '39852', '40246', '0', '20', '2017-01-06 17:05:07', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('498', '《有理数》复习', '', '39779', '39781', '39788', '39993', '1', '12', '2017-01-06 17:05:07', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('499', '整式的概念', '', '39779', '39781', '39788', '39994', '1', '12', '2017-01-06 17:05:07', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('500', '整式的运算（1）', '', '39779', '39781', '39788', '39994', '1', '12', '2017-01-06 17:05:07', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('501', '整式的运算（2）', '', '39779', '39781', '39788', '39994', '1', '12', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('502', '《整式》复习', '', '39779', '39781', '39788', '39994', '1', '12', '2017-01-06 17:05:07', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('503', '方程及一元一次方程的概念', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('504', '等式的性质', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:07', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('505', '解一元一次方程（1）', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:07', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('506', '解一元一次方程（2）', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:07', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('507', '函数', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('508', '一次函数', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('509', '一次函数与一元一次方程、二元一次方程组的关系', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('510', '一次函数与一元一次不等式的关系', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('511', '《一次函数》复习（一）', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('512', '《一次函数》复习（二）', '', '39779', '39782', '39791', '40012', '1', '12', '2017-01-06 17:05:07', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('513', '三角形全等的条件（一）', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:07', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('514', '三角形全等的条件（二）', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:07', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('515', '三角形全等的性质', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('516', '角的平分线的性质', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('517', '古代诗歌中的人物形象的鉴赏', '', '39780', '39784', '39835', '40083', '0', '27', '2017-01-06 17:05:07', '1', '1', '32', '0');
INSERT INTO `xxj_video` VALUES ('518', '课文的梳理与作文', '', '39780', '39784', '39835', '40083', '0', '27', '2017-01-06 17:05:07', '0', '0', '30', '0');
INSERT INTO `xxj_video` VALUES ('519', '抒情散文阅读的“抓矛盾”法', '', '39780', '39784', '39835', '40082', '0', '27', '2017-01-06 17:05:07', '1', '1', '76', '0');
INSERT INTO `xxj_video` VALUES ('520', '高中文言文的学习六法', '', '39780', '39784', '39835', '40082', '0', '27', '2017-01-06 17:05:07', '1', '1', '37', '0');
INSERT INTO `xxj_video` VALUES ('521', '意象入手--现代诗歌导学', '', '39780', '39784', '39835', '40082', '0', '27', '2017-01-06 17:05:07', '1', '1', '63', '0');
INSERT INTO `xxj_video` VALUES ('522', '语文-生命之魂', '', '39780', '39784', '39835', '40086', '0', '27', '2017-01-06 17:05:07', '0', '0', '36', '0');
INSERT INTO `xxj_video` VALUES ('523', '构思技巧--反常合道法', '', '39780', '39784', '39835', '40089', '0', '27', '2017-01-06 17:05:07', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('524', '构思技巧--情节转折法', '', '39780', '39784', '39835', '40089', '0', '27', '2017-01-06 17:05:07', '1', '1', '46', '0');
INSERT INTO `xxj_video` VALUES ('525', '构思技巧--故事新编法', '', '39780', '39784', '39835', '40089', '0', '27', '2017-01-06 17:05:07', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('526', '欲露先藏--构成波澜的方法', '', '39780', '39784', '39835', '40089', '0', '27', '2017-01-06 17:05:07', '0', '0', '54', '0');
INSERT INTO `xxj_video` VALUES ('527', '鸦片战争', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:07', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('528', '太平天国运动', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:07', '1', '1', '36', '0');
INSERT INTO `xxj_video` VALUES ('529', '从中日甲午战争到八国联军侵华', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:07', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('530', '实验探究题解题思路', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('532', '氯及其化合物（一）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('533', '氯及其化合物（二）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('534', '硫及其化合物（一）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('535', '硫及其化合物（二）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('537', '氮及其化合物（一）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('538', '氮及其化合物（二）', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:07', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('539', '人类遗传病', '', '39780', '39784', '39840', '40126', '0', '25', '2017-01-06 17:05:07', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('540', 'ATP', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:07', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('541', '蛋白质', '', '39780', '39784', '39840', '40118', '0', '25', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('542', '光合作用（二）', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('543', '细胞的增殖（三）', '', '39780', '39784', '39840', '40122', '0', '25', '2017-01-06 17:05:07', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('544', '非谓语动词', '', '39780', '39786', '39855', '40298', '0', '30', '2017-01-06 17:05:07', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('545', '交通运输方式特点和选择', '', '39780', '39786', '39861', '40322', '0', '23', '2017-01-06 17:05:07', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('546', '影响交通方式选择的因素', '', '39780', '39786', '39861', '40322', '0', '23', '2017-01-06 17:05:07', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('547', '影响交通线路布局的因素', '', '39780', '39786', '39861', '40322', '0', '23', '2017-01-06 17:05:07', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('548', '文化生活', '', '39780', '39785', '39850', '40253', '0', '22', '2017-01-06 17:05:07', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('549', '文化对人的影响', '', '39780', '39785', '39850', '40253', '0', '22', '2017-01-06 17:05:07', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('550', '文化多样性与文化的传播', '', '39780', '39785', '39850', '40254', '0', '22', '2017-01-06 17:05:07', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('551', '传统文化的继承', '', '39780', '39785', '39850', '40254', '0', '22', '2017-01-06 17:05:07', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('552', '文化创新', '', '39780', '39785', '39850', '40254', '0', '22', '2017-01-06 17:05:07', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('553', '中华文化与民族精神', '', '39780', '39785', '39850', '40255', '0', '22', '2017-01-06 17:05:07', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('554', '发展中国特色社会主义文化', '', '39780', '39785', '39850', '40256', '0', '22', '2017-01-06 17:05:07', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('555', '地理环境整体性与差异性', '', '39780', '39786', '39861', '40328', '0', '23', '2017-01-06 17:05:07', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('556', '地理环境的整体性与差异性（二）', '', '39780', '39786', '39861', '40328', '0', '23', '2017-01-06 17:05:07', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('557', '地理环境的整体性与差异性（三）', '', '39780', '39786', '39861', '40328', '0', '23', '2017-01-06 17:05:07', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('561', '铁的化合物（一）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:07', '1', '1', '36', '0');
INSERT INTO `xxj_video` VALUES ('562', '铁的化合物（二）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:07', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('563', '铝的化合物（一）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:07', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('564', '铝的化合物（二）', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:07', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('565', '指、对数运算（1）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:07', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('566', '指、对数运算（2）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:07', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('567', '指、对数函数（1）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:07', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('568', '指、对数函数（2）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:07', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('569', '幂函数', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:08', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('570', '函数图象变换（1）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:08', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('571', '函数图象变换（2）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:08', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('572', '解题指导概述', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:08', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('576', 'a、an的用法学习', '', '39779', '39781', '39789', '40168', '0', '24', '2017-01-06 17:05:08', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('577', 'it的用法梳理', '', '39779', '39781', '39789', '40170', '0', '24', '2017-01-06 17:05:08', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('579', '动词时态（二）', '', '39779', '39782', '39792', '40177', '0', '24', '2017-01-06 17:05:08', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('580', '人称代词、物主代词、反身代词', '', '39779', '39781', '39789', '40170', '0', '24', '2017-01-06 17:05:08', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('582', '机械能守恒定律（三）', '', '39780', '39784', '39838', '40108', '0', '9', '2017-01-06 17:05:08', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('585', '企业的经营（一）', '', '39780', '39784', '39841', '40140', '0', '22', '2017-01-06 17:05:08', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('586', '辩证否定观', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('587', '科学人生观和价值观', '', '39780', '39785', '39850', '40260', '0', '22', '2017-01-06 17:05:08', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('588', '历史唯物主义观点', '', '39780', '39785', '39850', '40260', '0', '22', '2017-01-06 17:05:08', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('589', '唯物辩证法的发展观', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('590', '唯物辩证法的联系观', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('591', '唯物辩证法的矛盾观（二）', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('592', '唯物辩证法的矛盾观（三）', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('593', '唯物辩证法的矛盾观（一）', '', '39780', '39785', '39850', '40259', '0', '22', '2017-01-06 17:05:08', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('594', '阅读（一）记叙文', '', '39779', '39781', '39787', '39987', '1', '26', '2017-01-06 17:05:08', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('595', '主语从句', '', '39780', '39785', '39846', '40217', '0', '14', '2017-01-06 17:05:08', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('596', '省略的一般用法', '', '39780', '39786', '39855', '40296', '0', '14', '2017-01-06 17:05:08', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('598', '物质的量', '', '39780', '39784', '39839', '40109', '0', '19', '2017-01-06 17:05:08', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('599', '硅及其化合物', '', '39780', '39784', '39839', '40112', '0', '19', '2017-01-06 17:05:08', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('600', '几种重要的金属化合物  练习', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:08', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('601', '钠的化合物（三）上', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:08', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('602', '钠的化合物（三）下', '', '39780', '39784', '39839', '40111', '0', '19', '2017-01-06 17:05:08', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('603', '自然界的水', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('604', '质量守恒定律', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('605', '物质组成的简单计算', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('606', '物质组成的表示', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('607', '物质构成的奥秘', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('608', '物质的多样性', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('609', '物质的变化和性质', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('610', '我们周围的空气', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('611', '燃料、能源、环境', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('612', '情态动词的用法', '', '39779', '39782', '39792', '40176', '0', '24', '2017-01-06 17:05:08', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('613', '金属和金属材料', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('614', '化学反应', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('615', '化学、健康、材料', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('616', '常见的盐', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:08', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('617', '非谓语动词（一）', '', '39779', '39783', '39796', '40182', '0', '24', '2017-01-06 17:05:08', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('618', '非谓语动词（二）', '', '39779', '39783', '39796', '40182', '0', '24', '2017-01-06 17:05:08', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('619', '主谓一致', '', '39779', '39783', '39796', '40179', '0', '24', '2017-01-06 17:05:08', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('620', '定语从句', '', '39779', '39783', '39796', '40183', '0', '24', '2017-01-06 17:05:08', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('621', '状语从句', '', '39779', '39783', '39796', '40183', '0', '24', '2017-01-06 17:05:08', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('622', '简单句', '', '39779', '39783', '39796', '40180', '0', '24', '2017-01-06 17:05:08', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('623', '辛亥革命', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('624', '五四爱国运动', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '1', '1', '29', '0');
INSERT INTO `xxj_video` VALUES ('625', '探索中国近代政体变革', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('626', '马克思主义的诞生', '', '39780', '39784', '39842', '40152', '0', '21', '2017-01-06 17:05:08', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('627', '俄国十月社会主义革命', '', '39780', '39784', '39842', '40152', '0', '21', '2017-01-06 17:05:08', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('628', '中国共产党成立和国民革命', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('629', '国共十年对峙', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('630', '伟大的抗日战争', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('631', '人民解放战争', '', '39780', '39784', '39842', '40151', '0', '21', '2017-01-06 17:05:08', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('632', '名著阅读', '', '39779', '39781', '39787', '39986', '1', '26', '2017-01-06 17:05:08', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('633', '人物传记阅读专题 （一）', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:08', '0', '0', '34', '0');
INSERT INTO `xxj_video` VALUES ('634', '审题的步骤和方法', '', '39780', '39786', '39853', '40284', '0', '15', '2017-01-06 17:05:08', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('635', '社科文阅读', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:08', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('636', '文言文的翻译', '', '39780', '39786', '39853', '40283', '0', '15', '2017-01-06 17:05:08', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('637', '过滤和蒸发', '', '39780', '39784', '39839', '40109', '0', '19', '2017-01-06 17:05:08', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('638', '醛', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:08', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('639', '卤代烃', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:08', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('640', '酚', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:08', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('641', '芳香烃', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:08', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('642', '醇', '', '39780', '39785', '39848', '40231', '0', '17', '2017-01-06 17:05:08', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('643', '植物的激素调节', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:08', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('644', '生物的进化', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:08', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('645', '人体的内环境与稳态', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:08', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('646', '人类遗传病', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:08', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('647', '动物的生命活动调节', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:08', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('648', '汽化及汽化的两种方式', '', '39779', '39782', '39793', '40027', '1', '10', '2017-01-06 17:05:08', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('649', '液化及液化的两种方法', '', '39779', '39782', '39793', '40027', '1', '10', '2017-01-06 17:05:08', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('650', '光的直线传播', '', '39779', '39782', '39793', '40028', '1', '10', '2017-01-06 17:05:08', '0', '0', '31', '0');
INSERT INTO `xxj_video` VALUES ('651', '光的反射', '', '39779', '39782', '39793', '40028', '1', '10', '2017-01-06 17:05:08', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('652', '平面镜成像', '', '39779', '39782', '39793', '40028', '1', '10', '2017-01-06 17:05:08', '0', '0', '29', '0');
INSERT INTO `xxj_video` VALUES ('653', '光的折射', '', '39779', '39782', '39793', '40028', '1', '10', '2017-01-06 17:05:08', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('654', '光的色散', '', '39779', '39782', '39793', '40028', '1', '10', '2017-01-06 17:05:08', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('655', '透镜', '', '39779', '39782', '39793', '40029', '1', '10', '2017-01-06 17:05:08', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('656', '生活中的透镜', '', '39779', '39782', '39793', '40029', '1', '10', '2017-01-06 17:05:09', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('657', '二次根式的定义及其性质', '', '39779', '39783', '39795', '40044', '1', '31', '2017-01-06 17:05:09', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('658', '二次根式的乘除法', '', '39779', '39783', '39795', '40044', '1', '31', '2017-01-06 17:05:09', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('659', '最简二次根式', '', '39779', '39783', '39795', '40044', '1', '31', '2017-01-06 17:05:09', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('660', '二次根式的加减', '', '39779', '39783', '39795', '40044', '1', '31', '2017-01-06 17:05:09', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('661', '二次根式的混合运算', '', '39779', '39783', '39795', '40044', '1', '31', '2017-01-06 17:05:09', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('662', '一元二次方程的概念及直接开平方法解方程', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('663', '配方法解一元二次方程', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('664', '公式法解一元二次方程', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('665', '因式分解法解一元二次方程', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('666', '带字母系数的一元二次方程的解法', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('667', '一元二次方程的根的判别式', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('668', '一元二次方程的应用', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:09', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('669', '图形的旋转', '', '39779', '39783', '39795', '40046', '1', '31', '2017-01-06 17:05:09', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('670', '专题二 电路故障分析', '', '39779', '39783', '39797', '40060', '1', '10', '2017-01-06 17:05:09', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('671', '轴对称', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('672', '细胞呼吸（二）', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:09', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('673', '杂交育种', '', '39780', '39784', '39840', '40126', '0', '25', '2017-01-06 17:05:09', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('674', '两对相对性状的杂交实验（一）', '', '39780', '39784', '39840', '40123', '0', '25', '2017-01-06 17:05:09', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('675', 'DNA是主要的遗传物质（二）', '', '39780', '39784', '39840', '40125', '0', '25', '2017-01-06 17:05:09', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('676', '轴对称变换', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('677', '等腰三角形（一）', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('678', '等腰三角形（二）', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('679', '《轴对称》复习（一）', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('680', '《轴对称》复习（二）', '', '39779', '39782', '39791', '40014', '1', '12', '2017-01-06 17:05:09', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('681', '整式的乘法（一）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('682', '整式的乘法（二）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('683', '因式分解（一）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('684', '因式分解（二）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('685', '《整式》复习（一）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('686', '《整式》复习（二）', '', '39779', '39782', '39791', '40015', '1', '12', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('687', '甲烷（二）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:09', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('688', '甲烷（一）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:09', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('689', '化学能与电能（二）下', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:09', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('690', '化学能与电能（二）上', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:09', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('691', '化学键（二）下', '', '39780', '39784', '39839', '40113', '0', '11', '2017-01-06 17:05:09', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('692', '化学反应速率和限度（一）', '', '39780', '39784', '39839', '40114', '0', '11', '2017-01-06 17:05:09', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('693', '金属流程', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:09', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('694', '金属活动顺序表的应用', '', '39779', '39783', '39798', '40080', '2', '17', '2017-01-06 17:05:09', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('695', '有机化学实验', '', '39780', '39786', '39857', '40312', '0', '17', '2017-01-06 17:05:09', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('696', '难溶电解质的溶解平衡', '', '39780', '39786', '39857', '40309', '0', '17', '2017-01-06 17:05:09', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('697', '电流的微观解释', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('698', '遗传的细胞基础', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:09', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('699', '遗传的基本规律', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:09', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('700', '遗传的分子基础', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:09', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('701', '电源 电动势', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('702', '生物的变异', '', '39780', '39786', '39858', '40315', '0', '18', '2017-01-06 17:05:09', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('703', '欧姆定律', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('704', '闭合电路欧姆定律', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('705', '电路动态分析', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('706', '电表及其改装', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('707', '伏安法测电阻', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('708', '测电池的电动势和电阻', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('709', '电源的输出功率与效率', '', '39780', '39785', '39847', '40219', '0', '9', '2017-01-06 17:05:09', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('713', '常见的酸和碱', '', '39779', '39783', '39798', '40079', '1', '29', '2017-01-06 17:05:09', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('714', '蒸馏  萃取  分液', '', '39780', '39784', '39839', '40109', '0', '19', '2017-01-06 17:05:09', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('715', '乙烯（二）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:09', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('716', '基本营养物质（二）', '', '39780', '39784', '39839', '40115', '0', '11', '2017-01-06 17:05:09', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('717', '指示代词、疑问代词、相互代词', '', '39779', '39781', '39789', '40170', '0', '24', '2017-01-06 17:05:09', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('719', '动词时态（一）', '', '39779', '39782', '39792', '40177', '0', '24', '2017-01-06 17:05:09', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('720', '宾语从句', '', '39779', '39783', '39796', '40183', '0', '24', '2017-01-06 17:05:09', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('721', '完全倒装与部分倒装', '', '39779', '39783', '39796', '40181', '0', '24', '2017-01-06 17:05:09', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('722', '素材的使用要做到三“不”和三“要”', '', '39780', '39784', '39835', '40090', '0', '27', '2017-01-06 17:05:09', '0', '0', '40', '0');
INSERT INTO `xxj_video` VALUES ('723', '作文构思中的“大而小之”', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '1', '1', '34', '0');
INSERT INTO `xxj_video` VALUES ('724', '作文材料的寓意化', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '1', '1', '39', '0');
INSERT INTO `xxj_video` VALUES ('725', '作文材料的阐述方法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '26', '0');
INSERT INTO `xxj_video` VALUES ('726', '诗词怎样表达抽象情感', '', '39780', '39784', '39835', '40085', '0', '27', '2017-01-06 17:05:09', '1', '1', '54', '0');
INSERT INTO `xxj_video` VALUES ('727', '装在套子里的人', '', '39780', '39785', '39844', '40167', '0', '27', '2017-01-06 17:05:09', '0', '0', '40', '0');
INSERT INTO `xxj_video` VALUES ('728', '重点分析段的写作', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '31', '0');
INSERT INTO `xxj_video` VALUES ('729', '张衡传', '', '39780', '39784', '39835', '40085', '0', '27', '2017-01-06 17:05:09', '1', '1', '27', '0');
INSERT INTO `xxj_video` VALUES ('730', '语言换元法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('731', '议论文找“联系”的方法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('732', '咬文嚼字', '', '39780', '39785', '39844', '40167', '0', '27', '2017-01-06 17:05:09', '0', '0', '35', '0');
INSERT INTO `xxj_video` VALUES ('733', '写作内容要扣时代，联自己', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('734', '逍遥游', '', '39780', '39785', '39844', '40167', '0', '27', '2017-01-06 17:05:09', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('735', '滕王阁序', '', '39780', '39785', '39844', '40167', '0', '27', '2017-01-06 17:05:09', '0', '0', '31', '0');
INSERT INTO `xxj_video` VALUES ('736', '琵琶行', '', '39780', '39784', '39835', '40084', '0', '27', '2017-01-06 17:05:09', '1', '1', '36', '0');
INSERT INTO `xxj_video` VALUES ('737', '柳永词两首', '', '39780', '39784', '39835', '40085', '0', '27', '2017-01-06 17:05:09', '1', '1', '58', '0');
INSERT INTO `xxj_video` VALUES ('738', '林教头风雪山神庙', '', '39780', '39785', '39844', '40167', '0', '27', '2017-01-06 17:05:09', '1', '1', '36', '0');
INSERT INTO `xxj_video` VALUES ('739', '林黛玉进贾府', '', '39780', '39784', '39835', '40084', '0', '27', '2017-01-06 17:05:09', '1', '1', '51', '0');
INSERT INTO `xxj_video` VALUES ('740', '假设对立面批驳与例后评价法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '46', '0');
INSERT INTO `xxj_video` VALUES ('741', '基础分析段的局部强化法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:09', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('745', '细胞器', '', '39780', '39784', '39840', '40119', '0', '25', '2017-01-06 17:05:10', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('746', '细胞膜', '', '39780', '39784', '39840', '40119', '0', '25', '2017-01-06 17:05:10', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('747', '生物膜系统', '', '39780', '39784', '39840', '40119', '0', '25', '2017-01-06 17:05:10', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('748', '时评文分析深刻透彻', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '1', '1', '40', '0');
INSERT INTO `xxj_video` VALUES ('750', '议论文结构的模仿', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '0', '0', '46', '0');
INSERT INTO `xxj_video` VALUES ('751', '议论文创造性模仿', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '1', '1', '38', '0');
INSERT INTO `xxj_video` VALUES ('752', '一字经纬法', '', '39780', '39785', '39844', '40686', '0', '27', '2017-01-06 17:05:10', '0', '0', '37', '0');
INSERT INTO `xxj_video` VALUES ('753', '一线三片段法', '', '39780', '39785', '39844', '40686', '0', '27', '2017-01-06 17:05:10', '0', '0', '45', '0');
INSERT INTO `xxj_video` VALUES ('754', '议论文的结构创新法', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '1', '1', '46', '0');
INSERT INTO `xxj_video` VALUES ('755', '”文学类“作文的构思方法', '', '39780', '39785', '39844', '40686', '0', '27', '2017-01-06 17:05:10', '0', '0', '35', '0');
INSERT INTO `xxj_video` VALUES ('756', '种群与群落', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:10', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('757', '微生物的利用', '', '39780', '39786', '39858', '40317', '0', '18', '2017-01-06 17:05:10', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('758', '“脑筋要急转弯”的相关联想', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('759', '生态系统', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:10', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('760', '辩证分析 无懈可击 ', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('761', '生态环境的保护', '', '39780', '39786', '39858', '40316', '0', '18', '2017-01-06 17:05:10', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('762', '酶的应用', '', '39780', '39786', '39858', '40317', '0', '18', '2017-01-06 17:05:10', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('763', '驳论的写作技巧', '', '39780', '39785', '39844', '40685', '0', '27', '2017-01-06 17:05:10', '1', '1', '34', '0');
INSERT INTO `xxj_video` VALUES ('764', '祖国统一的历史潮流', '', '39780', '39784', '39842', '40153', '0', '21', '2017-01-06 17:05:10', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('765', '新中国的外交', '', '39780', '39784', '39842', '40154', '0', '21', '2017-01-06 17:05:10', '0', '0', '29', '0');
INSERT INTO `xxj_video` VALUES ('766', '雅尔塔体系和两极格局的关系', '', '39780', '39784', '39842', '40155', '0', '21', '2017-01-06 17:05:10', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('767', '现代中国的政治建设与祖国统一', '', '39780', '39784', '39842', '40153', '0', '21', '2017-01-06 17:05:10', '1', '1', '39', '0');
INSERT INTO `xxj_video` VALUES ('768', '社会主义政治建设的曲折发展', '', '39780', '39784', '39842', '40153', '0', '21', '2017-01-06 17:05:10', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('769', '跨世纪的世界格局', '', '39780', '39784', '39842', '40155', '0', '21', '2017-01-06 17:05:10', '0', '0', '31', '0');
INSERT INTO `xxj_video` VALUES ('770', '从两极格局到世界多级化趋势', '', '39780', '39784', '39842', '40155', '0', '21', '2017-01-06 17:05:10', '1', '1', '66', '0');
INSERT INTO `xxj_video` VALUES ('771', '农业区位因素(2)', '', '39780', '39786', '39861', '40323', '0', '23', '2017-01-06 17:05:10', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('772', '农业区位因素', '', '39780', '39786', '39861', '40323', '0', '23', '2017-01-06 17:05:10', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('773', '农业地域类型特点及农业生产的环境问题', '', '39780', '39786', '39861', '40323', '0', '23', '2017-01-06 17:05:10', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('774', '描述工业地域发展特点', '', '39780', '39786', '39861', '40324', '0', '23', '2017-01-06 17:05:10', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('775', '工业的集聚和工业地域', '', '39780', '39786', '39861', '40324', '0', '23', '2017-01-06 17:05:10', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('776', '工业区位因素', '', '39780', '39786', '39861', '40324', '0', '23', '2017-01-06 17:05:10', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('777', '运用工业区位因素分析问题', '', '39780', '39786', '39861', '40324', '0', '23', '2017-01-06 17:05:10', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('778', '主导因素选择形成指向型工业', '', '39780', '39786', '39861', '40324', '0', '23', '2017-01-06 17:05:10', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('779', '地球运动的地理意义', '', '39780', '39786', '39861', '40325', '0', '23', '2017-01-06 17:05:10', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('780', '《几何图形初步》复习（1）', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('781', '《几何图形初步》复习（2）', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('782', '角的概念', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('783', '角的平分线', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('784', '立体图形与平面图形', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('785', '线段的中点及求线段的长度', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('786', '《一元一次方程》复习', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:10', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('787', '一元一次方程在实际问题中的应用（1）', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:10', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('788', '一元一次方程在实际问题中的应用（2）', '', '39779', '39781', '39788', '39995', '1', '12', '2017-01-06 17:05:10', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('789', '余角和补角', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('790', '直线、射线、线段', '', '39779', '39781', '39788', '39996', '1', '12', '2017-01-06 17:05:10', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('791', '点与圆的位置关系', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('792', '弧、弦、圆心角', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('793', '圆的基本概念', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('794', '圆的切线的判定', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('795', '圆的切线的性质', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('796', '圆的切线长与三角形的内切圆', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('797', '圆和圆的位置关系', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('798', '圆周角', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('799', '直线和圆的位置关系', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('800', '弧长和扇形面积', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('801', '利用频率估计概率', '', '39779', '39783', '39795', '40048', '1', '31', '2017-01-06 17:05:10', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('802', '随机事件', '', '39779', '39783', '39795', '40048', '1', '31', '2017-01-06 17:05:10', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('803', '用列举法求概率', '', '39779', '39783', '39795', '40048', '1', '31', '2017-01-06 17:05:10', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('804', '圆锥的侧面积和全面积', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('805', '正多边形和圆', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:10', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('806', '密度', '', '39779', '39782', '39793', '40030', '1', '10', '2017-01-06 17:05:10', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('807', '凝固和凝固曲线', '', '39779', '39782', '39793', '40027', '1', '10', '2017-01-06 17:05:10', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('808', '熔化和熔化曲线', '', '39779', '39782', '39793', '40027', '1', '10', '2017-01-06 17:05:10', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('809', '凸透镜成像规律', '', '39779', '39782', '39793', '40029', '1', '10', '2017-01-06 17:05:10', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('810', '温度与温度计', '', '39779', '39782', '39793', '40027', '1', '10', '2017-01-06 17:05:10', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('811', '显微镜和望远镜', '', '39779', '39782', '39793', '40029', '1', '10', '2017-01-06 17:05:10', '1', '1', '29', '0');
INSERT INTO `xxj_video` VALUES ('812', '眼睛和眼镜', '', '39779', '39782', '39793', '40029', '1', '10', '2017-01-06 17:05:10', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('813', '质量', '', '39779', '39782', '39793', '40030', '1', '10', '2017-01-06 17:05:10', '1', '1', '27', '0');
INSERT INTO `xxj_video` VALUES ('814', '空间中的平行关系（1）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('815', '空间中的平行关系（2）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('816', '空间中的垂直关系（1）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('817', '空间中的垂直关系（2）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('818', '多面体（1）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('819', '多面体（2）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('820', '连词的用法（一）', '', '39779', '39781', '39789', '40172', '0', '24', '2017-01-06 17:05:10', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('821', '函数性质应用（1）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:10', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('822', '函数性质应用（2）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:10', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('823', '函数性质应用（3）', '', '39780', '39784', '39836', '40092', '0', '13', '2017-01-06 17:05:10', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('824', '平面的基本性质与推论（1）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('825', '平面的基本性质与推论（2）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:10', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('826', '事实细节上', '', '39780', '39786', '39855', '40300', '0', '24', '2017-01-06 17:05:10', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('827', '算法与程序框图', '', '39780', '39784', '39836', '40094', '0', '36', '2017-01-06 17:05:10', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('828', '程序框图', '', '39780', '39784', '39836', '40094', '0', '36', '2017-01-06 17:05:10', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('829', '统计（2）', '', '39780', '39784', '39836', '40095', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('830', '随机事件的概率', '', '39780', '39784', '39836', '40096', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('831', '古典概型（2）', '', '39780', '39784', '39836', '40096', '0', '36', '2017-01-06 17:05:11', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('832', '几何概型（二）', '', '39780', '39784', '39836', '40096', '0', '36', '2017-01-06 17:05:11', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('833', '两角和与差的正弦、余弦和正切公式', '', '39780', '39784', '39836', '40099', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('834', '平面向量的基本定理及坐标表示', '', '39780', '39784', '39836', '40098', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('835', '平面向量的实际背景及基本概念', '', '39780', '39784', '39836', '40098', '0', '36', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('836', '平面向量的线性运算', '', '39780', '39784', '39836', '40098', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('837', '任意角的三角函数', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('838', '任意角和弧度制（二）', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('839', '三角函数的图象与性质', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('840', '三角函数的诱导公式', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('841', '三角函数模型的简单应用（二）', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('842', '磁场对通电导线的作用', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('843', '磁场对运动电荷的作用', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('844', '带电粒子在匀强磁场中的运动', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('845', '霍尔效应', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('846', '速度选择器', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('847', '质谱仪', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('848', '统计（一）', '', '39780', '39784', '39836', '40095', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('849', '古典概型（一）', '', '39780', '39784', '39836', '40096', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('850', '几何概型（一）', '', '39780', '39784', '39836', '40096', '0', '36', '2017-01-06 17:05:11', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('851', '任意角和弧度制（一）', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('852', '三角函数模型的简单应用（一）', '', '39780', '39784', '39836', '40097', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('853', '磁现象基本知识', '', '39780', '39785', '39847', '40220', '0', '9', '2017-01-06 17:05:11', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('854', '简单的三角恒等变换（一）', '', '39780', '39784', '39836', '40099', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('855', '简单的三角恒等变换（二）', '', '39780', '39784', '39836', '40099', '0', '36', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('856', '简单的三角恒等变换（三）', '', '39780', '39784', '39836', '40099', '0', '36', '2017-01-06 17:05:11', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('857', '不等关系与不等式', '', '39780', '39785', '39845', '40193', '0', '36', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('858', '等比数列', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('859', '等比数列的前n项和', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('860', '等差数列', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('861', '等差数列的前n项和（一）', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('862', '等差数列的前n项和（二）', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('863', '递推数列（一）', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('864', '递推数列（二）', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('865', '基本不等式', '', '39780', '39785', '39845', '40193', '0', '36', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('866', '简单的线性规划问题', '', '39780', '39785', '39845', '40193', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('867', '数列的基本概念及简单的表示方法', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('868', '数列的求和方法', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('869', '数列的应用', '', '39780', '39785', '39845', '40192', '0', '36', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('870', '一元二次不等式及其解法（一）', '', '39780', '39785', '39845', '40193', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('871', '一元二次不等式及其解法（二）', '', '39780', '39785', '39845', '40193', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('872', '余弦定理', '', '39780', '39785', '39845', '40191', '0', '36', '2017-01-06 17:05:11', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('873', '正弦定理（一）', '', '39780', '39785', '39845', '40191', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('874', '正弦定理（二）', '', '39780', '39785', '39845', '40191', '0', '36', '2017-01-06 17:05:11', '0', '0', '2', '0');
INSERT INTO `xxj_video` VALUES ('875', '正弦定理与余弦定理的综合应用', '', '39780', '39785', '39845', '40191', '0', '36', '2017-01-06 17:05:11', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('876', '分式的乘除混合运算', '', '39779', '39782', '39791', '40019', '2', '37', '2017-01-06 17:05:11', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('877', '分式的定义与基本性质', '', '39779', '39782', '39791', '40019', '2', '37', '2017-01-06 17:05:11', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('878', '分式的加减混合运算', '', '39779', '39782', '39791', '40019', '2', '37', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('879', '分式方程及其实际应用', '', '39779', '39782', '39791', '40019', '2', '37', '2017-01-06 17:05:11', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('880', '《全等三角形》复习（一）', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:11', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('881', '《全等三角形》复习（二）', '', '39779', '39782', '39791', '40013', '1', '12', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('882', '垂径定理', '', '39779', '39783', '39795', '40047', '1', '31', '2017-01-06 17:05:11', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('883', '旋转作图', '', '39779', '39783', '39795', '40046', '1', '31', '2017-01-06 17:05:11', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('884', '一元二次方程的根系关系', '', '39779', '39783', '39795', '40045', '1', '31', '2017-01-06 17:05:11', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('885', '中心对称  中心对称图形', '', '39779', '39783', '39795', '40046', '1', '31', '2017-01-06 17:05:11', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('886', '生物技术在食品加工中的应用', '', '39780', '39786', '39858', '40317', '0', '18', '2017-01-06 17:05:11', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('887', '生物技术在其他方面的应用', '', '39780', '39786', '39858', '40317', '0', '18', '2017-01-06 17:05:11', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('888', '生物技术的安全性和伦理问题', '', '39780', '39786', '39858', '40318', '0', '18', '2017-01-06 17:05:11', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('889', '生态工程', '', '39780', '39786', '39858', '40318', '0', '18', '2017-01-06 17:05:11', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('890', '胚胎工程', '', '39780', '39786', '39858', '40318', '0', '18', '2017-01-06 17:05:11', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('891', '克隆技术', '', '39780', '39786', '39858', '40318', '0', '18', '2017-01-06 17:05:11', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('892', '基因工程', '', '39780', '39786', '39858', '40318', '0', '18', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('893', '变压器', '', '39780', '39785', '39847', '40222', '0', '9', '2017-01-06 17:05:11', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('894', '电磁感应的图象问题', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('895', '电磁感应中的能量分析', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('896', '电动势与路端电压', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('897', '动生电动势', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('898', '法拉第电磁感应定律', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('899', '互感和自感', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('900', '交流电的有效值及计算', '', '39780', '39785', '39847', '40222', '0', '9', '2017-01-06 17:05:11', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('901', '楞次定律', '', '39780', '39785', '39847', '40221', '0', '9', '2017-01-06 17:05:11', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('902', '正弦交流电的产生', '', '39780', '39785', '39847', '40222', '0', '9', '2017-01-06 17:05:11', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('903', '二次函数的基本概念和图像', '', '39779', '39782', '39791', '40020', '2', '37', '2017-01-06 17:05:11', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('904', '二次函数的实际应用', '', '39779', '39782', '39791', '40020', '2', '37', '2017-01-06 17:05:11', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('905', '二次函数的性质', '', '39779', '39782', '39791', '40020', '2', '37', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('906', '勾股定理', '', '39779', '39782', '39791', '40017', '2', '37', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('907', '勾股定理的逆定理', '', '39779', '39782', '39791', '40017', '2', '37', '2017-01-06 17:05:11', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('908', '矩形和菱形的性质与判定', '', '39779', '39782', '39791', '40016', '2', '37', '2017-01-06 17:05:11', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('909', '平行四边形的判定', '', '39779', '39782', '39791', '40016', '2', '37', '2017-01-06 17:05:11', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('910', '平行四边形及其性质', '', '39779', '39782', '39791', '40016', '2', '37', '2017-01-06 17:05:11', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('911', '三角形的角与边的性质', '', '39779', '39782', '39791', '40018', '2', '37', '2017-01-06 17:05:11', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('912', '三角形中的模型与应用', '', '39779', '39782', '39791', '40018', '2', '37', '2017-01-06 17:05:11', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('913', '数据分析中的五个基本概念', '', '39779', '39782', '39791', '40021', '2', '37', '2017-01-06 17:05:12', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('914', '正方形的性质及其判定', '', '39779', '39782', '39791', '40016', '2', '37', '2017-01-06 17:05:12', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('915', '多边形及其计算', '', '39779', '39782', '39791', '40016', '2', '37', '2017-01-06 17:05:12', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('916', '标点符号的用法', '', '39779', '39783', '39794', '40037', '1', '39', '2017-01-06 17:05:12', '1', '1', '43', '0');
INSERT INTO `xxj_video` VALUES ('917', '病句的修改和修辞的鉴赏', '', '39779', '39783', '39794', '40037', '1', '39', '2017-01-06 17:05:12', '1', '1', '30', '0');
INSERT INTO `xxj_video` VALUES ('918', '《陈涉世家（二）》', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('919', '《出师表（二）》', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '0', '0', '26', '0');
INSERT INTO `xxj_video` VALUES ('920', '《出师表（一）》', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('921', '汉字音形义的辨析和词语的运用', '', '39779', '39783', '39794', '40037', '1', '39', '2017-01-06 17:05:12', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('922', '记叙文阅读之人物情感的分析', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('923', '记叙文阅读之人物形象的分析', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('924', '记叙文阅读之词语类题型的解析', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('925', '记叙文阅读之概括题型解析', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('926', '记叙文阅读之段落的作用', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('927', '记叙文阅读之如何赏析句子', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('928', '名著阅读', '', '39779', '39783', '39794', '40041', '2', '39', '2017-01-06 17:05:12', '1', '1', '40', '0');
INSERT INTO `xxj_video` VALUES ('929', '说明文题型考点解析（二）', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '28', '0');
INSERT INTO `xxj_video` VALUES ('930', '说明文题型考点解析（一）', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('931', '《唐雎不辱使命》', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '27', '0');
INSERT INTO `xxj_video` VALUES ('932', '文学常识与古诗文默写', '', '39779', '39783', '39794', '40038', '1', '39', '2017-01-06 17:05:12', '0', '0', '30', '0');
INSERT INTO `xxj_video` VALUES ('933', '议论文题型考点解析（二）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:12', '1', '1', '29', '0');
INSERT INTO `xxj_video` VALUES ('934', '议论文题型考点解析（一）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:12', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('935', '语句的运用', '', '39779', '39783', '39794', '40037', '1', '39', '2017-01-06 17:05:12', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('936', '作文的开头和结尾', '', '39779', '39783', '39794', '40043', '2', '39', '2017-01-06 17:05:12', '0', '0', '32', '0');
INSERT INTO `xxj_video` VALUES ('937', '作文的立意和构思', '', '39779', '39783', '39794', '40040', '1', '39', '2017-01-06 17:05:12', '1', '1', '35', '0');
INSERT INTO `xxj_video` VALUES ('938', '作文语言的锤炼', '', '39779', '39783', '39794', '40043', '2', '39', '2017-01-06 17:05:12', '0', '0', '32', '0');
INSERT INTO `xxj_video` VALUES ('939', '从《子路、曾晳、冉有、公西华侍坐》学习含蓄的手法', '', '39780', '39785', '39844', '40190', '0', '27', '2017-01-06 17:05:12', '1', '1', '30', '0');
INSERT INTO `xxj_video` VALUES ('940', '《梦游天姥吟留别》--古代诗歌中的梦境', '', '39780', '39785', '39844', '40190', '0', '27', '2017-01-06 17:05:12', '0', '0', '32', '0');
INSERT INTO `xxj_video` VALUES ('941', '《六国论》--文言文仿写', '', '39780', '39785', '39844', '40190', '0', '27', '2017-01-06 17:05:12', '1', '1', '29', '0');
INSERT INTO `xxj_video` VALUES ('942', '由《春江花月夜》中的“月”谈起', '', '39780', '39785', '39844', '40190', '0', '27', '2017-01-06 17:05:12', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('943', '《陈涉世家（一）》', '', '39779', '39783', '39794', '40039', '1', '39', '2017-01-06 17:05:12', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('944', '不等式及其解法', '', '39779', '39781', '39788', '40001', '2', '41', '2017-01-06 17:05:12', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('945', '不等式及其实际应用', '', '39779', '39781', '39788', '40001', '2', '41', '2017-01-06 17:05:12', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('946', '不等式组及其实际应用', '', '39779', '39781', '39788', '40001', '2', '41', '2017-01-06 17:05:12', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('947', '代入消元法和加减消元法解方程组', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('948', '二元一次方程及其解法', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('949', '二元一次方程组及其解', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('950', '平面直角坐标系', '', '39779', '39781', '39788', '39999', '2', '41', '2017-01-06 17:05:12', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('951', '平面直角坐标系中点与线的变换', '', '39779', '39781', '39788', '39999', '2', '41', '2017-01-06 17:05:12', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('952', '三元一次方程组及其解法', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('953', '用二元一次方程组解决实际问题（一）', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('954', '用二元一次方程组解决实际问题（二）', '', '39779', '39781', '39788', '40000', '2', '41', '2017-01-06 17:05:12', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('955', '变阻器', '', '39779', '39783', '39797', '40060', '1', '10', '2017-01-06 17:05:12', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('956', '电流与电压和电阻的关系', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('957', '电路变化问题分析', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('958', '多种方法测电阻', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('959', '伏安法测电阻', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('960', '欧姆定律', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('961', '欧姆定律在串、并联电路中的应用', '', '39779', '39783', '39797', '40061', '1', '10', '2017-01-06 17:05:12', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('962', '热机效率', '', '39779', '39783', '39797', '40058', '1', '10', '2017-01-06 17:05:12', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('963', '荷塘月色', '', '39780', '39784', '39835', '40083', '0', '27', '2017-01-06 17:05:12', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('964', '《蜀相》--咏史怀古诗导学', '', '39780', '39785', '39844', '40190', '0', '27', '2017-01-06 17:05:12', '0', '0', '43', '0');
INSERT INTO `xxj_video` VALUES ('965', '反射弧和神经调节', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:12', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('967', '免疫类疾病和治疗', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:12', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('968', '免疫调节的过程', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:12', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('969', '免疫调节的基础', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:12', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('970', '其他植物激素', '', '39780', '39785', '39849', '40234', '0', '42', '2017-01-06 17:05:12', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('971', '群落结构和演替', '', '39780', '39785', '39849', '40235', '0', '42', '2017-01-06 17:05:12', '1', '1', '33', '0');
INSERT INTO `xxj_video` VALUES ('972', '神经系统', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:12', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('973', '生态系统的功能', '', '39780', '39785', '39849', '40236', '0', '42', '2017-01-06 17:05:12', '0', '0', '33', '0');
INSERT INTO `xxj_video` VALUES ('974', '生态系统的结构', '', '39780', '39785', '39849', '40236', '0', '42', '2017-01-06 17:05:12', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('975', '生长素的生理作用', '', '39780', '39785', '39849', '40234', '0', '42', '2017-01-06 17:05:12', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('976', '稳态的意义和例子', '', '39780', '39785', '39849', '40232', '0', '42', '2017-01-06 17:05:12', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('977', '植物激素的发现', '', '39780', '39785', '39849', '40234', '0', '42', '2017-01-06 17:05:12', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('978', '种群的特征和数量', '', '39780', '39785', '39849', '40235', '0', '42', '2017-01-06 17:05:12', '1', '1', '32', '0');
INSERT INTO `xxj_video` VALUES ('979', '比例的性质', '', '39779', '39783', '39795', '40049', '2', '38', '2017-01-06 17:05:12', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('980', '反比例函数的图象和性质', '', '39779', '39783', '39795', '40049', '2', '38', '2017-01-06 17:05:12', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('981', '反比例函数的应用', '', '39779', '39783', '39795', '40049', '2', '38', '2017-01-06 17:05:12', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('982', '反比例函数的综合', '', '39779', '39783', '39795', '40049', '2', '38', '2017-01-06 17:05:12', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('983', '反比例函数与一次函数', '', '39779', '39783', '39795', '40049', '2', '38', '2017-01-06 17:05:12', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('984', '解直角三角形及应用', '', '39779', '39783', '39795', '40051', '2', '38', '2017-01-06 17:05:12', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('985', '平行投影和中心投影', '', '39779', '39783', '39795', '40052', '2', '38', '2017-01-06 17:05:12', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('986', '三角函数', '', '39779', '39783', '39795', '40051', '2', '38', '2017-01-06 17:05:12', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('987', '同角三角函数之间的关系', '', '39779', '39783', '39795', '40051', '2', '38', '2017-01-06 17:05:12', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('988', '位似', '', '39779', '39783', '39795', '40050', '2', '38', '2017-01-06 17:05:12', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('989', '相似三角形判定和性质', '', '39779', '39783', '39795', '40050', '2', '38', '2017-01-06 17:05:12', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('990', '相似三角形判定定理', '', '39779', '39783', '39795', '40050', '2', '38', '2017-01-06 17:05:12', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('991', '相似三角形判定综合应用', '', '39779', '39783', '39795', '40050', '2', '38', '2017-01-06 17:05:12', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('992', '相似三角形问题的常用辅助线作法', '', '39779', '39783', '39795', '40050', '2', '38', '2017-01-06 17:05:12', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('993', '由三视图还原几何体', '', '39779', '39783', '39795', '40052', '2', '38', '2017-01-06 17:05:12', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('995', '玻璃、陶瓷、水泥', '', '39780', '39785', '39848', '40225', '0', '11', '2017-01-06 17:05:12', '1', '1', '40', '0');
INSERT INTO `xxj_video` VALUES ('996', '蛋白质', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:12', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('997', '合金', '', '39780', '39785', '39848', '40225', '0', '11', '2017-01-06 17:05:12', '1', '1', '28', '0');
INSERT INTO `xxj_video` VALUES ('998', '合理选择饮食（一）', '', '39780', '39785', '39848', '40224', '0', '11', '2017-01-06 17:05:12', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('999', '合理选择饮食（二）', '', '39780', '39785', '39848', '40224', '0', '11', '2017-01-06 17:05:13', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1000', '金属的腐蚀与防护（一）', '', '39780', '39785', '39848', '40225', '0', '11', '2017-01-06 17:05:13', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1001', '金属的腐蚀与防护（二）', '', '39780', '39785', '39848', '40225', '0', '11', '2017-01-06 17:05:13', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1002', '塑料、纤维、橡胶', '', '39780', '39785', '39848', '40225', '0', '11', '2017-01-06 17:05:13', '0', '0', '35', '0');
INSERT INTO `xxj_video` VALUES ('1003', '糖类（一）', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:13', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1004', '糖类（三）', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:13', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1005', '糖类（二） ', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:13', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1006', '维生素和微量元素', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:13', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1007', '油脂', '', '39780', '39785', '39848', '40223', '0', '11', '2017-01-06 17:05:13', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1008', '正确使用药物', '', '39780', '39785', '39848', '40224', '0', '11', '2017-01-06 17:05:13', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('1009', '原子核外电子排布规律', '', '39779', '39783', '39798', '40069', '1', '43', '2017-01-06 17:05:13', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('1011', '氧气的性质', '', '39779', '39783', '39798', '40068', '1', '43', '2017-01-06 17:05:13', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1012', '氧气的制法', '', '39779', '39783', '39798', '40068', '1', '43', '2017-01-06 17:05:13', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1014', '化学反应类型', '', '39779', '39783', '39798', '40068', '1', '43', '2017-01-06 17:05:13', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1016', '罢黜百家、独尊儒术', '', '39780', '39785', '39851', '40264', '0', '45', '2017-01-06 17:05:13', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1017', '百家争鸣和道家思想', '', '39780', '39785', '39851', '40264', '0', '45', '2017-01-06 17:05:13', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1018', '明清之际活跃的儒家思想', '', '39780', '39785', '39851', '40264', '0', '45', '2017-01-06 17:05:13', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1019', '儒家、法家和墨家', '', '39780', '39785', '39851', '40264', '0', '45', '2017-01-06 17:05:13', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1020', '宋明理学', '', '39780', '39785', '39851', '40264', '0', '45', '2017-01-06 17:05:13', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1021', '不同等级城市的服务功能', '', '39780', '39784', '39843', '40134', '0', '46', '2017-01-06 17:05:13', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1022', '城市化', '', '39780', '39784', '39843', '40134', '0', '46', '2017-01-06 17:05:13', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1023', '城市内部空间结构', '', '39780', '39784', '39843', '40134', '0', '46', '2017-01-06 17:05:13', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1024', '工业的区位因素与区位选择', '', '39780', '39784', '39843', '40136', '0', '46', '2017-01-06 17:05:13', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1025', '农业的区位选择', '', '39780', '39784', '39843', '40135', '0', '46', '2017-01-06 17:05:13', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1026', '人口的合理容量', '', '39780', '39784', '39843', '40133', '0', '46', '2017-01-06 17:05:13', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1027', '人口的空间变化', '', '39780', '39784', '39843', '40133', '0', '46', '2017-01-06 17:05:13', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1028', '人口的数量变化', '', '39780', '39784', '39843', '40133', '0', '46', '2017-01-06 17:05:13', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1029', '以畜牧业为主的农业地域类型', '', '39780', '39784', '39843', '40135', '0', '46', '2017-01-06 17:05:13', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1030', '以种植业为主的农业地域类型', '', '39780', '39784', '39843', '40135', '0', '46', '2017-01-06 17:05:13', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1031', '工业地域的形成', '', '39780', '39784', '39843', '40136', '0', '46', '2017-01-06 17:05:13', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('1032', '交通运输方式和布局', '', '39780', '39784', '39843', '40137', '0', '46', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1033', '交通运输方式和布局变化的影响', '', '39780', '39784', '39843', '40137', '0', '46', '2017-01-06 17:05:13', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1034', '人地关系思想的演变', '', '39780', '39784', '39843', '40138', '0', '46', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1035', '中国的可持续发展实践', '', '39780', '39784', '39843', '40138', '0', '46', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1036', '地理环境对区域发展的影响', '', '39780', '39785', '39852', '40247', '0', '46', '2017-01-06 17:05:13', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1037', '地理信息技术在区域地理环境研究中的应用', '', '39780', '39785', '39852', '40247', '0', '46', '2017-01-06 17:05:13', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('1038', '传统工业区与新兴工业区', '', '39780', '39784', '39843', '40136', '0', '46', '2017-01-06 17:05:13', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1039', '质量守恒定律', '', '39779', '39783', '39798', '40071', '1', '43', '2017-01-06 17:05:13', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1040', '硬水和软水', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1041', '水的组成', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1042', '水的净化', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1043', '如何正确书写化学方程式', '', '39779', '39783', '39798', '40071', '1', '43', '2017-01-06 17:05:13', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1044', '利用化学方程式的简单计算', '', '39779', '39783', '39798', '40071', '1', '43', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1045', '化学式', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1046', '化合价', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1047', '根据化学式的简单计算', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1048', '纯净物的分类', '', '39779', '39783', '39798', '40068', '1', '43', '2017-01-06 17:05:13', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1049', '保护水资源', '', '39779', '39783', '39798', '40070', '1', '43', '2017-01-06 17:05:13', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('1050', '立方根及其计算', '', '39779', '39781', '39788', '39998', '2', '41', '2017-01-06 17:05:13', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1051', '命题与定理', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1052', '平方根及算术平方根', '', '39779', '39781', '39788', '39998', '2', '41', '2017-01-06 17:05:13', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1053', '平行线的性质', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1054', '平行线的应用', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1055', '平移变换', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1056', '同位角 内错角 同旁内角', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1057', '相交线', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:13', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1058', '重力', '', '39779', '39782', '39793', '40031', '2', '47', '2017-01-06 17:05:13', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1059', '液体压强（2）', '', '39779', '39782', '39793', '40033', '2', '47', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1060', '液体压强（1）', '', '39779', '39782', '39793', '40033', '2', '47', '2017-01-06 17:05:13', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1061', '压强（2）', '', '39779', '39782', '39793', '40033', '2', '47', '2017-01-06 17:05:13', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1062', '压强（1）', '', '39779', '39782', '39793', '40033', '2', '47', '2017-01-06 17:05:13', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1063', '牛顿第一定律和惯性', '', '39779', '39782', '39793', '40032', '2', '47', '2017-01-06 17:05:13', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1064', '摩擦力', '', '39779', '39782', '39793', '40032', '2', '47', '2017-01-06 17:05:13', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1065', '利用浮力测物质的密度', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:13', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1066', '力', '', '39779', '39782', '39793', '40031', '2', '47', '2017-01-06 17:05:13', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1067', '杠杆、压强和浮力综合习题（2）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:13', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1068', '杠杆、压强和浮力综合习题（1）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:13', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1069', '浮力', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:13', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1070', '二力平衡', '', '39779', '39782', '39793', '40032', '2', '47', '2017-01-06 17:05:13', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1071', '弹力', '', '39779', '39782', '39793', '40031', '2', '47', '2017-01-06 17:05:13', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1072', '大气压强', '', '39779', '39782', '39793', '40033', '2', '47', '2017-01-06 17:05:13', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1074', '产业转移', '', '39780', '39785', '39852', '40251', '0', '46', '2017-01-06 17:05:13', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1077', '河流的综合开发', '', '39780', '39785', '39852', '40249', '0', '46', '2017-01-06 17:05:13', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1078', '荒漠化的防治', '', '39780', '39785', '39852', '40248', '0', '46', '2017-01-06 17:05:13', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1079', '能源资源的开发', '', '39780', '39785', '39852', '40249', '0', '46', '2017-01-06 17:05:13', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1080', '区域工业化与城市化', '', '39780', '39785', '39852', '40250', '0', '46', '2017-01-06 17:05:13', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1081', '区域农业发展', '', '39780', '39785', '39852', '40250', '0', '46', '2017-01-06 17:05:13', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1082', '森林的开发和保护', '', '39780', '39785', '39852', '40248', '0', '46', '2017-01-06 17:05:13', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1083', '资源的跨区域调配', '', '39780', '39785', '39852', '40251', '0', '46', '2017-01-06 17:05:13', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1084', '充满魅力的书画和戏曲艺术', '', '39780', '39785', '39851', '40266', '0', '45', '2017-01-06 17:05:13', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1085', '古代中国的发明和发现', '', '39780', '39785', '39851', '40266', '0', '45', '2017-01-06 17:05:13', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('1086', '启蒙运动', '', '39780', '39785', '39851', '40265', '0', '45', '2017-01-06 17:05:13', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1087', '文艺复兴', '', '39780', '39785', '39851', '40265', '0', '45', '2017-01-06 17:05:13', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1088', '物理学的重大进展、破解生命起源之谜、从蒸汽机到互联网', '', '39780', '39785', '39851', '40267', '0', '45', '2017-01-06 17:05:14', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1089', '西方人文主义思想的起源', '', '39780', '39785', '39851', '40265', '0', '45', '2017-01-06 17:05:14', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1090', '宗教改革', '', '39780', '39785', '39851', '40265', '0', '45', '2017-01-06 17:05:14', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1094', '商鞅变法（二）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1095', '北魏孝文帝改革', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1096', '王安石变法（一）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1097', '王安石变法（二）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1098', '1861年俄国农奴制改革', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1099', '穆罕默德阿里改革', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1100', '明治维新（一）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1101', '明治维新（二）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1104', '商鞅变法（一）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1107', '燃烧和灭火', '', '39779', '39783', '39798', '40073', '1', '43', '2017-01-06 17:05:14', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1108', '燃料的合理利用和开发', '', '39779', '39783', '39798', '40073', '1', '43', '2017-01-06 17:05:14', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1109', '金属和金属材料', '', '39779', '39783', '39798', '40074', '2', '43', '2017-01-06 17:05:14', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1110', '金属的化学性质2', '', '39779', '39783', '39798', '40074', '2', '43', '2017-01-06 17:05:14', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1111', '金属的化学性质1', '', '39779', '39783', '39798', '40074', '2', '43', '2017-01-06 17:05:14', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1112', '金刚石、石墨和C60', '', '39779', '39783', '39798', '40072', '1', '43', '2017-01-06 17:05:14', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1113', '二氧化碳的制取', '', '39779', '39783', '39798', '40072', '1', '43', '2017-01-06 17:05:14', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1114', '二氧化碳的性质', '', '39779', '39783', '39798', '40072', '1', '43', '2017-01-06 17:05:14', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1115', '欧洲宗教改革', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:14', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1116', '各具特色的国家和国际组织', '', '39780', '39785', '39850', '40263', '0', '49', '2017-01-06 17:05:14', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('1117', '君主立宪制和民主共和制：以英国和法国为例', '', '39780', '39785', '39850', '40263', '0', '49', '2017-01-06 17:05:14', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1118', '联邦制、两党制、三权分立：以美国为例', '', '39780', '39785', '39850', '40263', '0', '49', '2017-01-06 17:05:14', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1119', '民主集中制：我国人民代表大会制度的组织和活动原则', '', '39780', '39785', '39850', '40263', '0', '49', '2017-01-06 17:05:14', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1120', '中和反应及其应用', '', '39779', '39783', '39798', '40076', '2', '43', '2017-01-06 17:05:14', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1121', '有机合成材料', '', '39779', '39783', '39798', '40078', '2', '43', '2017-01-06 17:05:14', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1122', '盐的化学性质', '', '39779', '39783', '39798', '40077', '2', '43', '2017-01-06 17:05:14', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1123', '生活中常见的盐', '', '39779', '39783', '39798', '40077', '2', '43', '2017-01-06 17:05:14', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1124', '溶液的形成', '', '39779', '39783', '39798', '40075', '2', '43', '2017-01-06 17:05:14', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1126', '人类重要的营养物质', '', '39779', '39783', '39798', '40078', '2', '43', '2017-01-06 17:05:14', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1128', '常见的酸', '', '39779', '39783', '39798', '40076', '2', '43', '2017-01-06 17:05:14', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1129', '常见的碱', '', '39779', '39783', '39798', '40076', '2', '43', '2017-01-06 17:05:14', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1130', '果酒、果醋的制作', '', '39780', '39785', '39849', '40239', '0', '44', '2017-01-06 17:05:14', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1131', '酵母细胞的固定化', '', '39780', '39785', '39849', '40238', '0', '44', '2017-01-06 17:05:14', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1132', '酶在果汁生产中的应用', '', '39780', '39785', '39849', '40238', '0', '44', '2017-01-06 17:05:14', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1133', '酶在洗涤中的应用', '', '39780', '39785', '39849', '40238', '0', '44', '2017-01-06 17:05:14', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1134', '泡菜的腌制和亚硝酸含量的测定', '', '39780', '39785', '39849', '40239', '0', '44', '2017-01-06 17:05:14', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1135', '特定微生物数量的测定', '', '39780', '39785', '39849', '40237', '0', '44', '2017-01-06 17:05:14', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1136', '微生物的利用', '', '39780', '39785', '39849', '40237', '0', '44', '2017-01-06 17:05:14', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1137', '微生物的培养与分离（二）', '', '39780', '39785', '39849', '40237', '0', '44', '2017-01-06 17:05:14', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1138', '微生物的培养与分离（一）', '', '39780', '39785', '39849', '40237', '0', '44', '2017-01-06 17:05:14', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1139', '植物组织培养技术', '', '39780', '39785', '39849', '40240', '0', '44', '2017-01-06 17:05:14', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1140', '导数的定义及如何正确求导', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1141', '导数综合提升（二）上', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1142', '导数综合提升（二）下', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1143', '导数综合提升（三）', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1144', '导数综合提升（一）', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1145', '复数代数形式的四则运算', '', '39780', '39785', '39845', '40203', '0', '50', '2017-01-06 17:05:14', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1146', '函数的极值', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1147', '数系的扩充与复数的概念', '', '39780', '39785', '39845', '40203', '0', '50', '2017-01-06 17:05:14', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1148', '有关单调区间与最值问题', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1149', '有关切线的问题', '', '39780', '39785', '39845', '40201', '0', '50', '2017-01-06 17:05:14', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1150', '直接证明与间接证明', '', '39780', '39785', '39845', '40202', '0', '50', '2017-01-06 17:05:14', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1151', '测量小灯泡的电功率', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:14', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1152', '电功率', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:14', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1153', '电能 电功', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:14', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1154', '焦耳定律', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:14', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1155', '分子动理论', '', '39779', '39783', '39797', '40057', '1', '10', '2017-01-06 17:05:14', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1156', '内能和改变内能的两种的方法', '', '39779', '39783', '39797', '40057', '1', '10', '2017-01-06 17:05:14', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1157', '热机', '', '39779', '39783', '39797', '40058', '1', '10', '2017-01-06 17:05:14', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1158', '比热容', '', '39779', '39783', '39797', '40057', '1', '10', '2017-01-06 17:05:14', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1159', '改革开放的总设计师邓小平', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1160', '杰出的科学家（一）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1161', '杰出的科学家（二）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1162', '无产阶级革命家--列宁', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1163', '无产阶级革命家马克思、恩格斯', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1164', '新中国的缔造者毛泽东', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1165', '亚洲觉醒的先驱（一）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1166', '亚洲觉醒的先驱（二）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:14', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1167', '现代中国的科技、教育与文学艺术', '', '39780', '39785', '39851', '40270', '0', '45', '2017-01-06 17:05:14', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1168', '19世纪以来的世界文学艺术', '', '39780', '39785', '39851', '40271', '0', '45', '2017-01-06 17:05:14', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1169', '殖民扩张与世界市场的拓展', '', '39780', '39784', '39842', '40157', '0', '45', '2017-01-06 17:05:14', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1170', '两次工业革命的比较', '', '39780', '39784', '39842', '40157', '0', '45', '2017-01-06 17:05:14', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1171', '开辟新航路', '', '39780', '39784', '39842', '40157', '0', '45', '2017-01-06 17:05:14', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1172', '古代手工业的进步', '', '39780', '39784', '39842', '40156', '0', '45', '2017-01-06 17:05:14', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1173', '古代商业发展', '', '39780', '39784', '39842', '40156', '0', '45', '2017-01-06 17:05:14', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1174', '古代的经济政策', '', '39780', '39784', '39842', '40156', '0', '45', '2017-01-06 17:05:14', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1175', '发达的古代农业', '', '39780', '39784', '39842', '40156', '0', '45', '2017-01-06 17:05:14', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1176', '第一次工业革命', '', '39780', '39784', '39842', '40157', '0', '45', '2017-01-06 17:05:14', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1177', '第二次工业革命', '', '39780', '39784', '39842', '40157', '0', '45', '2017-01-06 17:05:14', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1178', '2014年北京卷完形填空试题解析', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:14', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1179', '原词复现与同反义词解题方法', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:14', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1180', '应用文--发言稿', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:14', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1181', '写作指导概述', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:15', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1182', '文化背景与常识', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:15', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1183', '上下文语境与逻辑', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:15', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1184', '利弊分析类议论文', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:15', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1185', '看图情景作文', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:15', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1186', '完形填空概述', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:15', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1187', '充分必要条件', '', '39780', '39785', '39845', '40197', '0', '50', '2017-01-06 17:05:15', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1188', '简单的逻辑连接词', '', '39780', '39785', '39845', '40197', '0', '50', '2017-01-06 17:05:15', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1189', '保护水资源', '', '39780', '39785', '39848', '40226', '0', '11', '2017-01-06 17:05:15', '1', '1', '33', '0');
INSERT INTO `xxj_video` VALUES ('1190', '改善大气质量', '', '39780', '39785', '39848', '40226', '0', '11', '2017-01-06 17:05:15', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('1191', '空间向量的线性运算与基本定理', '', '39780', '39785', '39845', '40199', '0', '50', '2017-01-06 17:05:15', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1192', '垃圾资源化', '', '39780', '39785', '39848', '40226', '0', '11', '2017-01-06 17:05:15', '0', '0', '25', '0');
INSERT INTO `xxj_video` VALUES ('1193', '空间向量在立体几何中的应用(一)', '', '39780', '39785', '39845', '40199', '0', '50', '2017-01-06 17:05:15', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1194', '空间向量在立体几何中的应用(二)', '', '39780', '39785', '39845', '40199', '0', '50', '2017-01-06 17:05:15', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1195', '抛物线的定义与标准方程', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1196', '全称量词和存在量词', '', '39780', '39785', '39845', '40197', '0', '50', '2017-01-06 17:05:15', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1197', '双曲线的几何性质', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1198', '双曲线及其标准方程', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1199', '四种常见的命题形式', '', '39780', '39785', '39845', '40197', '0', '50', '2017-01-06 17:05:15', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1200', '植物有效成分的提取', '', '39780', '39785', '39849', '40240', '0', '44', '2017-01-06 17:05:15', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1201', '植物细胞工程', '', '39780', '39785', '39849', '40242', '0', '44', '2017-01-06 17:05:15', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1202', '修改病句', '', '39779', '39781', '39787', '39989', '2', '39', '2017-01-06 17:05:15', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1203', '椭圆的简单几何性质', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1204', '细胞融合和单克隆抗体', '', '39780', '39785', '39849', '40242', '0', '44', '2017-01-06 17:05:15', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1205', '椭圆及其标准方程', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1206', '体内受精与早期胚胎发育', '', '39780', '39785', '39849', '40243', '0', '44', '2017-01-06 17:05:15', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1207', '圆锥曲线综合提升训练', '', '39780', '39785', '39845', '40198', '0', '50', '2017-01-06 17:05:15', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1208', '体外受精与胚胎早期培养', '', '39780', '39785', '39849', '40243', '0', '44', '2017-01-06 17:05:15', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1209', '生物技术的安全性和伦理问题', '', '39780', '39785', '39849', '40244', '0', '44', '2017-01-06 17:05:15', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1210', '生态工程的原理及应用', '', '39780', '39785', '39849', '40245', '0', '44', '2017-01-06 17:05:15', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1211', '胚胎移植及胚胎分割', '', '39780', '39785', '39849', '40243', '0', '44', '2017-01-06 17:05:15', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1212', '基因工程的应用', '', '39780', '39785', '39849', '40241', '0', '44', '2017-01-06 17:05:15', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1213', '基因工程的基本操作程序', '', '39780', '39785', '39849', '40241', '0', '44', '2017-01-06 17:05:15', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1214', '海洋地理', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1215', '干细胞培养与应用', '', '39780', '39785', '39849', '40243', '0', '44', '2017-01-06 17:05:15', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1216', '环境保护（一）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1217', '环境保护（二）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1218', '多聚酶链式反应扩增DNA片段', '', '39780', '39785', '39849', '40240', '0', '44', '2017-01-06 17:05:15', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1219', '动物细胞培养', '', '39780', '39785', '39849', '40242', '0', '44', '2017-01-06 17:05:15', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1220', '旅游地理（一）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1221', '动物体细胞核移植和克隆动物', '', '39780', '39785', '39849', '40242', '0', '44', '2017-01-06 17:05:15', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1222', '蛋白质工程', '', '39780', '39785', '39849', '40241', '0', '44', '2017-01-06 17:05:15', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1223', '旅游地理（二）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '1', '1', '31', '0');
INSERT INTO `xxj_video` VALUES ('1224', '蛋白质的提取和分离', '', '39780', '39785', '39849', '40240', '0', '44', '2017-01-06 17:05:15', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1225', '旅游地理（三）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1226', '旅游地理（四）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1227', '自然灾害（二）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1228', '自然灾害（一）', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1229', '城乡规划', '', '39780', '39785', '39852', '40252', '0', '46', '2017-01-06 17:05:15', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1230', '校园应用文写作', '', '39779', '39781', '39787', '39992', '2', '39', '2017-01-06 17:05:15', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1231', '说明文题型解析', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1232', '诗歌鉴赏', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1233', '《伤仲永》', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1234', '如何理解句子', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1235', '如何分析人物形象', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1236', '《木兰诗》', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('1237', '名著阅读', '', '39779', '39781', '39787', '39990', '2', '39', '2017-01-06 17:05:15', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1238', '《口技》', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1239', '环境描写的作用', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1240', '段落的作用', '', '39779', '39781', '39787', '39991', '2', '39', '2017-01-06 17:05:15', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1241', '词义的辨析', '', '39779', '39781', '39787', '39989', '2', '39', '2017-01-06 17:05:15', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1242', '常见修辞方法及作用', '', '39779', '39781', '39787', '39989', '2', '39', '2017-01-06 17:05:15', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('1243', '《左传》', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1244', '《邹忌讽齐王纳谏》', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1245', '《鱼我所欲也》', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1246', '小说阅读（一）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('1247', '小说阅读（二）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1248', '散文阅读（一）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1249', '散文阅读（二·）', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1250', '如何使人物形象丰满', '', '39779', '39781', '39787', '39992', '2', '39', '2017-01-06 17:05:15', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1251', '《孟子两章》', '', '39779', '39783', '39794', '40042', '2', '39', '2017-01-06 17:05:15', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1253', '排列与组合（一）', '', '39780', '39785', '39845', '40205', '0', '50', '2017-01-06 17:05:15', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1254', '二项式定理', '', '39780', '39785', '39845', '40205', '0', '50', '2017-01-06 17:05:15', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1255', '离散型随机变量的均值与方差', '', '39780', '39785', '39845', '40206', '0', '50', '2017-01-06 17:05:15', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1256', '正态分布', '', '39780', '39785', '39845', '40206', '0', '50', '2017-01-06 17:05:15', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1257', '回归分析的基本思想及其初步应用', '', '39780', '39785', '39845', '40207', '0', '50', '2017-01-06 17:05:15', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1258', '独立性检验的基本思想及其初步知识', '', '39780', '39785', '39845', '40207', '0', '50', '2017-01-06 17:05:15', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1264', '排列与组合（二）', '', '39780', '39785', '39845', '40205', '0', '50', '2017-01-06 17:05:15', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1265', '改革开放', '', '39780', '39784', '39842', '40159', '0', '45', '2017-01-06 17:05:15', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1266', '古典经济学巨匠的理论遗产（一）', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:15', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1267', '古典经济学巨匠的理论遗产（二）', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:15', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1268', '马克思主义经济学的伟大贡献', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:15', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1269', '西方国家现代市场经济的兴起与主要模式上', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:15', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1270', '西方国家现代市场经济的兴起与主要模式下', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:15', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1271', '近代后期的民族工业', '', '39780', '39784', '39842', '40158', '0', '45', '2017-01-06 17:05:15', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1272', '经济建设的发展和曲折', '', '39780', '39784', '39842', '40159', '0', '45', '2017-01-06 17:05:15', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1273', '民族工业的初步发展和黄金时期', '', '39780', '39784', '39842', '40158', '0', '45', '2017-01-06 17:05:15', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1274', '世界经济的区域集团化和全球化', '', '39780', '39784', '39842', '40163', '0', '45', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1275', '世界资本主义经济政策的调整', '', '39780', '39784', '39842', '40161', '0', '45', '2017-01-06 17:05:16', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1276', '苏联的社会主义建设', '', '39780', '39784', '39842', '40162', '0', '45', '2017-01-06 17:05:16', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1277', '东西方先哲（一）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1278', '东西方先哲（二）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1279', '梭伦改革', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:16', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1280', '戊戌变法（一）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1281', '戊戌变法（二）', '', '39780', '39785', '39851', '40272', '0', '48', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1282', '中国古代政治家（一）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1283', '中国古代政治家（二）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1284', '资产阶级革命时代的杰出人物（一）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1285', '资产阶级革命时代的杰出人物（二）', '', '39780', '39785', '39851', '40273', '0', '48', '2017-01-06 17:05:16', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1287', '洋务运动', '', '39780', '39784', '39842', '40158', '0', '45', '2017-01-06 17:05:16', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1288', '战后资本主义世界经济体系的形成', '', '39780', '39784', '39842', '40163', '0', '45', '2017-01-06 17:05:16', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1289', '中国近现代社会生活的变迁', '', '39780', '39784', '39842', '40160', '0', '45', '2017-01-06 17:05:16', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1290', '自然经济的逐渐解体与民族资本主义的产生', '', '39780', '39784', '39842', '40158', '0', '45', '2017-01-06 17:05:16', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1291', '律诗', '', '39779', '39782', '39790', '40009', '2', '26', '2017-01-06 17:05:16', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1292', '绝句', '', '39779', '39782', '39790', '40009', '2', '26', '2017-01-06 17:05:16', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1293', '词', '', '39779', '39782', '39790', '40009', '2', '26', '2017-01-06 17:05:16', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1294', '积累运用', '', '39779', '39782', '39790', '40009', '2', '26', '2017-01-06 17:05:16', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1295', '记叙文阅读（一）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1296', '记叙文阅读（二）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1297', '散文阅读（一）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('1298', '散文阅读（二）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1299', '说明文阅读（一）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('1300', '说明文阅读（二）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1301', '文言文阅读（一）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1302', '文言文阅读（二）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1303', '文言文阅读（三）', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1304', '自主写作', '', '39779', '39782', '39790', '40011', '2', '26', '2017-01-06 17:05:16', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('1305', '议论文阅读与写作', '', '39779', '39782', '39790', '40010', '2', '26', '2017-01-06 17:05:16', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1306', '赤壁赋', '', '39780', '39784', '39835', '40083', '0', '40', '2017-01-06 17:05:16', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1307', '寡人之于国（一）', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1308', '寡人之于国（二）', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1309', '鸿门宴（一）', '', '39780', '39784', '39835', '40082', '0', '40', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1310', '鸿门宴（二）', '', '39780', '39784', '39835', '40082', '0', '40', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1311', '荆轲刺秦王（一）', '', '39780', '39784', '39835', '40082', '0', '40', '2017-01-06 17:05:16', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1312', '荆轲刺秦王（二）', '', '39780', '39784', '39835', '40082', '0', '40', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1313', '兰亭集序', '', '39780', '39784', '39835', '40083', '0', '40', '2017-01-06 17:05:16', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1314', '离骚（节选）', '', '39780', '39784', '39835', '40083', '0', '40', '2017-01-06 17:05:16', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('1315', '苏轼词两首', '', '39780', '39784', '39835', '40085', '0', '40', '2017-01-06 17:05:16', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1316', '秋兴八首（其一）、登高', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1317', '劝学（一）', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1318', '劝学（二）', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1319', '诗经两首', '', '39780', '39784', '39835', '40083', '0', '40', '2017-01-06 17:05:16', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1320', '蜀道难', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1321', '水龙吟、登建康赏心亭', '', '39780', '39784', '39835', '40085', '0', '40', '2017-01-06 17:05:16', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1322', '新闻两篇', '', '39780', '39784', '39835', '40082', '0', '40', '2017-01-06 17:05:16', '0', '0', '27', '0');
INSERT INTO `xxj_video` VALUES ('1323', '永遇乐、京口北固亭怀古', '', '39780', '39784', '39835', '40085', '0', '40', '2017-01-06 17:05:16', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1324', '咏怀古迹（其三）', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1325', '祝福', '', '39780', '39784', '39835', '40084', '0', '40', '2017-01-06 17:05:16', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1326', '激素调节总结（二）', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:16', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1327', '毛泽东思想', '', '39780', '39785', '39851', '40269', '0', '45', '2017-01-06 17:05:16', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1328', '激素调节总结（一）', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:16', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1329', '三民主义的形成和发展', '', '39780', '39785', '39851', '40269', '0', '45', '2017-01-06 17:05:16', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1330', '内环境的稳态', '', '39780', '39785', '39849', '40232', '0', '42', '2017-01-06 17:05:16', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1331', '师夷长技', '', '39780', '39785', '39851', '40268', '0', '45', '2017-01-06 17:05:16', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1332', '体液调节', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:16', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1333', '体液调节和神经调节的关系', '', '39780', '39785', '39849', '40233', '0', '42', '2017-01-06 17:05:16', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1334', '细胞生活的环境', '', '39780', '39785', '39849', '40232', '0', '42', '2017-01-06 17:05:16', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1335', '维新变法', '', '39780', '39785', '39851', '40268', '0', '45', '2017-01-06 17:05:16', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1336', '新时期的理论探索', '', '39780', '39785', '39851', '40269', '0', '45', '2017-01-06 17:05:16', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1337', '新文化运动', '', '39780', '39785', '39851', '40268', '0', '45', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1338', '社会主义经济理论的初期探讨', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:16', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1339', '社会主义市场经济的探索', '', '39780', '39785', '39850', '40262', '0', '49', '2017-01-06 17:05:16', '1', '1', '30', '0');
INSERT INTO `xxj_video` VALUES ('1341', '微作文的写作', '', '39779', '39781', '39787', '39992', '2', '39', '2017-01-06 17:05:16', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1342', '书信邮件类', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:16', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1343', '观点类议论文', '', '39780', '39786', '39855', '40303', '0', '24', '2017-01-06 17:05:16', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1344', '词汇辨析和固定搭配', '', '39780', '39786', '39855', '40304', '0', '24', '2017-01-06 17:05:16', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1345', '走进化学世界  ', '', '39779', '39783', '39798', '40067', '1', '43', '2017-01-06 17:05:16', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('1346', '原子的组成', '', '39779', '39783', '39798', '40069', '1', '43', '2017-01-06 17:05:16', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('1347', '元素(二)', '', '39779', '39783', '39798', '40069', '1', '43', '2017-01-06 17:05:16', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1348', '溶液的pH', '', '39779', '39783', '39798', '40076', '2', '43', '2017-01-06 17:05:16', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1349', '溶解度（二）', '', '39779', '39783', '39798', '40075', '2', '43', '2017-01-06 17:05:16', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1350', '溶解度（一）', '', '39779', '39783', '39798', '40075', '2', '43', '2017-01-06 17:05:16', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1351', '空气的组成', '', '39779', '39783', '39798', '40068', '1', '43', '2017-01-06 17:05:16', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('1352', '金属资源的利用和保护', '', '39779', '39783', '39798', '40074', '2', '43', '2017-01-06 17:05:16', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1353', '化学元素与人体健康', '', '39779', '39783', '39798', '40078', '2', '43', '2017-01-06 17:05:16', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1354', '化学仪器的认知', '', '39779', '39783', '39798', '40067', '1', '43', '2017-01-06 17:05:16', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1355', '化肥', '', '39779', '39783', '39798', '40077', '2', '43', '2017-01-06 17:05:16', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1356', '二氧化碳和一氧化碳', '', '39779', '39783', '39798', '40072', '1', '43', '2017-01-06 17:05:16', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1357', '元素（一）', '', '39779', '39783', '39798', '40069', '1', '43', '2017-01-06 17:05:16', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1358', '溶液的浓度', '', '39779', '39783', '39798', '40075', '2', '43', '2017-01-06 17:05:16', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1359', '配制一定质量分数的溶液', '', '39779', '39783', '39798', '40075', '2', '43', '2017-01-06 17:05:16', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1360', '化学实验的基本操作', '', '39779', '39783', '39798', '40067', '1', '43', '2017-01-06 17:05:17', '1', '1', '24', '0');
INSERT INTO `xxj_video` VALUES ('1361', '分子和原子', '', '39779', '39783', '39798', '40069', '1', '43', '2017-01-06 17:05:17', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1370', '测量物质的密度', '', '39779', '39782', '39793', '40030', '1', '10', '2017-01-06 17:05:17', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1371', '集合中的综合问题', '', '39780', '39786', '39854', '40286', '0', '50', '2017-01-06 17:05:17', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1372', '集合中的常见错误分析', '', '39780', '39786', '39854', '40286', '0', '50', '2017-01-06 17:05:17', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1373', '命题与简易逻辑', '', '39780', '39786', '39854', '40286', '0', '50', '2017-01-06 17:05:17', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1374', '函数的定义域', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1375', '函数的值域（2）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1376', '函数的值域（1）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1377', '腐乳的制作', '', '39780', '39785', '39849', '40239', '0', '44', '2017-01-06 17:05:17', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1378', 'DNA粗提取与鉴定', '', '39780', '39785', '39849', '40240', '0', '44', '2017-01-06 17:05:17', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1379', '图像的玄机', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1380', '像福尔摩斯一样（分析判断）', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1381', '复杂过程分析', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1382', '传送带那点事', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1383', '弹簧软中硬', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1384', '斜面，又是斜面', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1385', '测量小灯泡电功率的四种方法', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:17', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1386', '电功率练习', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:17', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1387', '电功率综合计算', '', '39779', '39783', '39797', '40062', '2', '51', '2017-01-06 17:05:17', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1388', '家庭电路', '', '39779', '39783', '39797', '40063', '2', '51', '2017-01-06 17:05:17', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1389', '家庭电路中电流过大的原因', '', '39779', '39783', '39797', '40063', '2', '51', '2017-01-06 17:05:17', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1390', '机械效率练习三-整体法受力分析', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1391', '机械效率练习二-隔离法受力分析', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1392', '机械效率练习一-机械效率的公式应用', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1393', '机械效率（二）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1394', '机械效率（一）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1395', '滑轮做功问题', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1396', '滑轮、杠杆综合计算', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1397', '滑轮和滑轮组', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1398', '杠杆及其应用（二）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1399', '杠杆及其应用（一）', '', '39779', '39782', '39793', '40036', '2', '47', '2017-01-06 17:05:17', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1400', '动能和势能 机械能及其转化', '', '39779', '39782', '39793', '40035', '2', '47', '2017-01-06 17:05:17', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1401', '功和功率', '', '39779', '39782', '39793', '40035', '2', '47', '2017-01-06 17:05:17', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1402', '柱状容器底部压强与浮力变化量的关系', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:17', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1403', '利用液面变化解决浮力问题', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:17', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1404', '物体的浮沉条件及应用（二）', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:17', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1405', '物体的浮沉条件及应用（一）', '', '39779', '39782', '39793', '40034', '2', '47', '2017-01-06 17:05:17', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1406', '三国演义', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1407', '关键词：机械能损失', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1408', '往返与功', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1409', '功率问题别大意', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1410', '做功与圆周', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1411', '首零尾零', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1412', '运动合成', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1413', '天上星光灿烂', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1414', '转啊转', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1415', '板块模型', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1416', '有一才有二（连接体）', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1417', '近代工人运动与近现代科学技术', '', '39780', '39786', '39860', '40332', '0', '45', '2017-01-06 17:05:17', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1418', '西方人文精神的发展', '', '39780', '39786', '39860', '40332', '0', '45', '2017-01-06 17:05:17', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1419', '英、德代议制的确立与发展', '', '39780', '39786', '39860', '40332', '0', '45', '2017-01-06 17:05:17', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1420', '美、法代议制的确立与发展', '', '39780', '39786', '39860', '40332', '0', '45', '2017-01-06 17:05:17', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1421', '新航路的开辟、殖民扩张与资本主义世界市场的形成和发展', '', '39780', '39786', '39860', '40332', '0', '45', '2017-01-06 17:05:17', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1422', '古代希腊罗马', '', '39780', '39786', '39860', '40331', '0', '45', '2017-01-06 17:05:17', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1423', '中国古代文化', '', '39780', '39786', '39860', '40330', '0', '45', '2017-01-06 17:05:17', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1424', '中国古代政治', '', '39780', '39786', '39860', '40330', '0', '45', '2017-01-06 17:05:17', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1425', '中国古代商业和城市发展', '', '39780', '39786', '39860', '40330', '0', '45', '2017-01-06 17:05:17', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1426', '中国古代农业和手工业', '', '39780', '39786', '39860', '40330', '0', '45', '2017-01-06 17:05:17', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1427', '函数的表达式（解析式）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1428', '函数的奇偶性与单调性（1）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1429', '函数的奇偶性与单调性（2）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1430', '环境保护和生态平衡', '', '39780', '39785', '39849', '40236', '0', '42', '2017-01-06 17:05:17', '1', '1', '28', '0');
INSERT INTO `xxj_video` VALUES ('1431', '函数的零点', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1432', '函数的图象（2）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1433', '函数的图象（1）', '', '39780', '39786', '39854', '40287', '0', '50', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1434', '同角三角函数的基本关系式', '', '39780', '39786', '39854', '40288', '0', '50', '2017-01-06 17:05:17', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1435', '诱导公式', '', '39780', '39786', '39854', '40288', '0', '50', '2017-01-06 17:05:17', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1436', '三角函数的和差倍半', '', '39780', '39786', '39854', '40288', '0', '50', '2017-01-06 17:05:17', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1438', '三角函数图象', '', '39780', '39786', '39854', '40288', '0', '50', '2017-01-06 17:05:17', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1439', '解三角形（1）', '', '39780', '39786', '39854', '40289', '0', '50', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1440', '解三角形（2）', '', '39780', '39786', '39854', '40289', '0', '50', '2017-01-06 17:05:17', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('1441', '解三角形（3）', '', '39780', '39786', '39854', '40289', '0', '50', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1442', '平面向量与三角形', '', '39780', '39786', '39854', '40289', '0', '50', '2017-01-06 17:05:17', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1443', '等差数列的常见问题（1）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1444', '等差数列的常见问题（2）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1445', '等比数列的常见问题', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1446', '如何求数列的通项公式（1）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1447', '如何求数列的通项公式（2）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1448', '如何进行数列求和（1）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1449', '如何进行数列求和（2）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1450', '如何证明数列不等式（1）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1451', '如何证明数列不等式（2）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1452', '如何证明数列不等式（3）', '', '39780', '39786', '39854', '40290', '0', '50', '2017-01-06 17:05:17', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1453', '轨迹者，鬼计也', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1454', '电学中的受力分析', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1455', '电场力的功', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1456', '平抛中的比', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1457', '带电粒子', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:17', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1458', '电容', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1459', '旋转体（一）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:18', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1460', '旋转体（二）', '', '39780', '39784', '39836', '40093', '0', '13', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1461', '近代中国的民主革命（一）', '', '39780', '39786', '39860', '40333', '0', '45', '2017-01-06 17:05:18', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1462', '近代中国的民主革命（二）', '', '39780', '39786', '39860', '40333', '0', '45', '2017-01-06 17:05:18', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1463', '近代中国的民主革命（三）', '', '39780', '39786', '39860', '40333', '0', '45', '2017-01-06 17:05:18', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1464', '经济结构的变动与资本主义的曲折发展', '', '39780', '39786', '39860', '40333', '0', '45', '2017-01-06 17:05:18', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1465', '19世纪中国思想解放的潮流', '', '39780', '39786', '39860', '40333', '0', '45', '2017-01-06 17:05:18', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1466', '不计重力', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1467', '考虑重力', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1468', '说圆不圆', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1469', '霍尔效应', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1470', '我们一起看电视吧', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1471', '回旋加速器', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1472', '罗斯福新政和当代资本主义的新变化', '', '39780', '39786', '39860', '40334', '0', '45', '2017-01-06 17:05:18', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1473', '第二次世界大战后世界经济的全球化趋势', '', '39780', '39786', '39860', '40334', '0', '45', '2017-01-06 17:05:18', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1474', '第二次世界大战后世界政治格局的演变', '', '39780', '39786', '39860', '40334', '0', '45', '2017-01-06 17:05:18', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1475', '社会主义政治、经济文化建设（过渡时期）', '', '39780', '39786', '39860', '40335', '0', '45', '2017-01-06 17:05:18', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1476', '俄国十月革命与苏联社会主义建设', '', '39780', '39786', '39860', '40334', '0', '45', '2017-01-06 17:05:18', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1477', '电磁感应中的内外之争', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1478', '热量讨论', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1479', '电磁感应中的推理考查', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1480', '电磁感应中的图象', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1481', '电磁感应中的力', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1482', '电磁感应在生活中的应用', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1483', '有关直线的知识（1）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1484', '有关直线的知识（2）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1485', '有关直线的知识（3）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1486', '有关圆的知识', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1487', '有关椭圆的问题（1）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1488', '有关椭圆的问题（2）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('1489', '有关椭圆的问题（3）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1490', '有关双曲线的问题', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1491', '有关抛物线的问题', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1492', '安全用电', '', '39779', '39783', '39797', '40063', '2', '51', '2017-01-06 17:05:18', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1493', '家庭电路以及常见故障分析', '', '39779', '39783', '39797', '40063', '2', '51', '2017-01-06 17:05:18', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1494', '磁现象 磁场', '', '39779', '39783', '39797', '40064', '2', '51', '2017-01-06 17:05:18', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1495', '电生磁', '', '39779', '39783', '39797', '40064', '2', '51', '2017-01-06 17:05:18', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1496', '电磁铁 电磁继电器', '', '39779', '39783', '39797', '40064', '2', '51', '2017-01-06 17:05:18', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1497', '电动机', '', '39779', '39783', '39797', '40064', '2', '51', '2017-01-06 17:05:18', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1498', '磁生电', '', '39779', '39783', '39797', '40064', '2', '51', '2017-01-06 17:05:18', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1499', '电话与电磁波', '', '39779', '39783', '39797', '40065', '2', '51', '2017-01-06 17:05:18', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1500', '广播、电视和移动通信', '', '39779', '39783', '39797', '40065', '2', '51', '2017-01-06 17:05:18', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1501', '能源与核能', '', '39779', '39783', '39797', '40066', '2', '51', '2017-01-06 17:05:18', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1502', '太阳能和能源可持续发展', '', '39779', '39783', '39797', '40066', '2', '51', '2017-01-06 17:05:18', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1503', '三视图', '', '39779', '39783', '39795', '40052', '2', '38', '2017-01-06 17:05:18', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1504', '无理数和实数', '', '39779', '39781', '39788', '39998', '2', '41', '2017-01-06 17:05:18', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1505', '垂线', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1506', '平行线的判定', '', '39779', '39781', '39788', '39997', '2', '41', '2017-01-06 17:05:18', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1507', '原子物理基础篇', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1509', '原子物理与反冲', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1511', '原子物理与跃迁', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1513', '几何光学', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1515', '光的粒子性', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1517', '光的波动性', '', '39780', '39786', '39856', '40306', '0', '56', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1519', '如何求动点轨迹的方程（1）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1521', '如何求动点轨迹的方程（2）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1523', '如何求动点轨迹的方程（3）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1525', '如何研究定点与定值的问题（1）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1527', '如何研究定点与定值的问题（2）', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1529', '如何思考有关圆锥曲线中面积的问题', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1531', '如何解决有关圆锥曲线中存在性的问题', '', '39780', '39786', '39854', '40291', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1533', '如何分析立体几何的小题', '', '39780', '39786', '39854', '41280', '0', '50', '2017-01-06 17:05:18', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1535', '电阻和影响电阻大小的因素', '', '39779', '39783', '39797', '40060', '1', '10', '2017-01-06 17:05:18', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1537', '如何解决立体几何的大题（1）', '', '39780', '39786', '39854', '41280', '0', '50', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1539', '如何解决立体几何的大题（二）', '', '39780', '39786', '39854', '41280', '0', '50', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1541', '导数中的常见问题（一）上', '', '39780', '39786', '39854', '41342', '0', '50', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1543', '导数中的常见问题（一）下', '', '39780', '39786', '39854', '41342', '0', '50', '2017-01-06 17:05:18', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1545', '导数中的常见问题（二）', '', '39780', '39786', '39854', '41342', '0', '50', '2017-01-06 17:05:18', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1547', '导数中的常见问题（三）', '', '39780', '39786', '39854', '41342', '0', '50', '2017-01-06 17:05:18', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1549', '概率统计常见小题分析', '', '39780', '39786', '39854', '41343', '0', '50', '2017-01-06 17:05:18', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1551', '概率统计常见大题分析', '', '39780', '39786', '39854', '41343', '0', '50', '2017-01-06 17:05:18', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1553', '有关不等式的知识（一）上', '', '39780', '39786', '39854', '41344', '0', '50', '2017-01-06 17:05:18', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1555', '有关不等式的知识（一）下', '', '39780', '39786', '39854', '41344', '0', '50', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1557', '有关不等式的知识（二）', '', '39780', '39786', '39854', '41344', '0', '50', '2017-01-06 17:05:18', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1559', '有关复数的知识', '', '39780', '39786', '39854', '41345', '0', '50', '2017-01-06 17:05:18', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1561', '算法与程序框图', '', '39780', '39786', '39854', '41346', '0', '50', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1563', '排列组合与二项式定理（一）', '', '39780', '39786', '39854', '41347', '0', '50', '2017-01-06 17:05:18', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1565', '排列组合与二项式定理（二）', '', '39780', '39786', '39854', '41347', '0', '50', '2017-01-06 17:05:18', '1', '1', '2', '0');
INSERT INTO `xxj_video` VALUES ('1567', '排列组合与二项式定理（三）', '', '39780', '39786', '39854', '41347', '0', '50', '2017-01-06 17:05:18', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('1569', '排列组合与二项式定理（四）', '', '39780', '39786', '39854', '41347', '0', '50', '2017-01-06 17:05:18', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1571', '几何证明选讲', '', '39780', '39786', '39854', '41348', '0', '50', '2017-01-06 17:05:18', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1573', '统计案例', '', '39780', '39786', '39854', '41349', '0', '50', '2017-01-06 17:05:18', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1575', '积分与正态分布', '', '39780', '39786', '39854', '41350', '0', '50', '2017-01-06 17:05:18', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1577', '参数方程与极坐标', '', '39780', '39786', '39854', '41351', '0', '50', '2017-01-06 17:05:18', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1582', '数一数', '', '41687', '41688', '41698', '41775', '1', '60', '2017-01-06 17:05:18', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1583', '比多少', '', '41687', '41688', '41698', '41775', '1', '60', '2017-01-06 17:05:19', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1584', '0~5的认识=、＞和＜的认识', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1585', '分与合、加法和减法的认识', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1586', '6、7的认识和6、7的加减法', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1587', '8、9的认识和8、9的加减法', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1588', '10的认识和10的加减法', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1589', '连加、连减和加减混合', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1590', '11~20各数的认识', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1591', '20以内的不进位加法和不退位减法', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1592', '9加几', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1593', '8、7、6加几', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1594', '5、4、3、2加几', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1595', '十几减9', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1596', '十几减8、7、6', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1597', '十几减5、4、3、2', '', '41687', '41688', '41698', '41776', '1', '60', '2017-01-06 17:05:19', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1598', '认识整时', '', '41687', '41688', '41698', '41999', '2', '59', '2017-01-06 17:05:19', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1599', '数数、数的组成和读数、写数', '', '41687', '41688', '41698', '41778', '2', '59', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1600', '数的顺序和比较大小', '', '41687', '41688', '41698', '41778', '2', '59', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1601', '整十数加一位数及相应的减法', '', '41687', '41688', '41698', '41778', '2', '59', '2017-01-06 17:05:19', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1602', '认识人民币和简单的计算', '', '41687', '41688', '41698', '41779', '2', '59', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1603', '整十数加、减整十数', '', '41687', '41688', '41698', '41780', '2', '59', '2017-01-06 17:05:19', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1604', '两位数加一位数、整十数', '', '41687', '41688', '41698', '41780', '2', '59', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1605', '两位数减一位数、整十数和小括号', '', '41687', '41688', '41698', '41780', '2', '59', '2017-01-06 17:05:19', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1606', '上、下、前、后和左、右', '', '41687', '41688', '41698', '41781', '2', '70', '2017-01-06 17:05:19', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('1607', '认识立体图形和图形的拼搭', '', '41687', '41688', '41698', '41782', '2', '69', '2017-01-06 17:05:19', '0', '0', '34', '0');
INSERT INTO `xxj_video` VALUES ('1608', '认识平面图形和平面图形的拼组', '', '41687', '41688', '41698', '41782', '2', '69', '2017-01-06 17:05:19', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1609', '分类与整理', '', '41687', '41688', '41698', '41783', '2', '70', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1610', '图形或数字排列的规律', '', '41687', '41688', '41698', '41784', '2', '70', '2017-01-06 17:05:19', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1611', '声母、韵母的读音、形及写法', '', '41687', '41688', '41694', '41774', '1', '71', '2017-01-06 17:05:19', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1612', '整体音节的读音、形及写法', '', '41687', '41688', '41694', '41774', '1', '71', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1613', '声调和标调、拼音方法及规则', '', '41687', '41688', '41694', '41774', '1', '71', '2017-01-06 17:05:19', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1614', '常见偏旁、部首的写法及意义', '', '41687', '41688', '41694', '41785', '1', '71', '2017-01-06 17:05:19', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1615', '汉字的笔画、笔顺', '', '41687', '41688', '41694', '41785', '1', '72', '2017-01-06 17:05:19', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1616', '汉字字形的演变和字义的变化', '', '41687', '41688', '41694', '41786', '1', '72', '2017-01-06 17:05:19', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1617', '分类学词语', '', '41687', '41688', '41694', '41787', '1', '72', '2017-01-06 17:05:19', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1618', '叠词的组成和运用', '', '41687', '41688', '41694', '41788', '1', '72', '2017-01-06 17:05:19', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1619', '连词成句题的解答', '', '41687', '41688', '41694', '41789', '1', '72', '2017-01-06 17:05:19', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1620', '数短文的自然段', '', '41687', '41688', '41694', '41790', '2', '73', '2017-01-06 17:05:19', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1621', '根据短文内容提取重要信息填空', '', '41687', '41688', '41694', '41790', '2', '73', '2017-01-06 17:05:19', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1622', '根据想象回答问题', '', '41687', '41688', '41694', '41790', '2', '73', '2017-01-06 17:05:19', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1623', '写景诗', '', '41687', '41688', '41694', '41791', '2', '64', '2017-01-06 17:05:19', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1624', '咏物诗', '', '41687', '41688', '41694', '41791', '2', '64', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1625', '咏怀诗', '', '41687', '41688', '41694', '41791', '2', '64', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1626', '人物故事', '', '41687', '41688', '41694', '41792', '2', '64', '2017-01-06 17:05:19', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1627', '《伊索寓言》', '', '41687', '41688', '41694', '41792', '2', '64', '2017-01-06 17:05:19', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1628', '看图说话或提出、回答问题', '', '41687', '41688', '41694', '41793', '2', '74', '2017-01-06 17:05:19', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1629', '根据图画，续说小故事', '', '41687', '41688', '41694', '41794', '2', '74', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1630', '根据图画，与人交谈并提出见解', '', '41687', '41688', '41694', '41795', '2', '74', '2017-01-06 17:05:19', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1631', '汉字字形的演变和字义的变化', '', '41687', '41689', '41702', '41810', '1', '64', '2017-01-06 17:05:19', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1632', '音序检字法', '', '41687', '41689', '41702', '41811', '1', '64', '2017-01-06 17:05:19', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1633', '部首检字法', '', '41687', '41689', '41702', '41811', '1', '64', '2017-01-06 17:05:19', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1634', '同音字辨析', '', '41687', '41689', '41702', '41812', '1', '64', '2017-01-06 17:05:19', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1635', '词语排序', '', '41687', '41689', '41702', '41812', '1', '64', '2017-01-06 17:05:19', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1636', '逗号、句号在语境中的用法', '', '41687', '41689', '41702', '41813', '1', '64', '2017-01-06 17:05:19', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1637', '被字句、把字句之间的转换', '', '41687', '41689', '41702', '41814', '1', '64', '2017-01-06 17:05:19', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1638', '结合上下文和生活实际理解字词', '', '41687', '41689', '41702', '42000', '1', '76', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1639', '根据短文内容判断对错', '', '41687', '41689', '41702', '42000', '1', '76', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1640', '提取短文中重要句子，回答问题', '', '41687', '41689', '41702', '42000', '1', '76', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1641', '概括一段文字的主要内容', '', '41687', '41689', '41702', '42000', '1', '76', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1642', '山水诗', '', '41687', '41689', '41702', '41816', '2', '63', '2017-01-06 17:05:19', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1643', '咏物诗', '', '41687', '41689', '41702', '41816', '2', '63', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1644', '儿童生活诗', '', '41687', '41689', '41702', '41816', '2', '63', '2017-01-06 17:05:19', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1645', '成语故事', '', '41687', '41689', '41702', '41817', '2', '63', '2017-01-06 17:05:19', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1646', '《安徒生童话》', '', '41687', '41689', '41702', '41817', '2', '63', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1647', '讲述自己感兴趣的见闻或想法', '', '41687', '41689', '41702', '41818', '2', '116', '2017-01-06 17:05:19', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1648', '结合情境或图片，进行书面表达', '', '41687', '41689', '41702', '41819', '2', '116', '2017-01-06 17:05:19', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1649', '两位数加两位数', '', '41687', '41689', '41703', '41796', '1', '59', '2017-01-06 17:05:19', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1650', '两位数减两位数', '', '41687', '41689', '41703', '41796', '1', '59', '2017-01-06 17:05:19', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1651', '连加、连减和加减混合', '', '41687', '41689', '41703', '41796', '1', '59', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1652', '乘法的初步认识', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1653', '5的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1654', '2、3、4的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1655', '乘加、乘减', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1656', '6的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1657', '7的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1658', '8的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1659', '9的乘法口诀', '', '41687', '41689', '41703', '41797', '1', '59', '2017-01-06 17:05:19', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1660', '认识分和几时几分', '', '41687', '41689', '41703', '41798', '1', '60', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1661', '平均分和除法的认识', '', '41687', '41689', '41703', '41799', '2', '60', '2017-01-06 17:05:19', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1662', '用2～6的乘法口诀求商', '', '41687', '41689', '41703', '41799', '2', '60', '2017-01-06 17:05:19', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1663', '用7、8、9的乘法口诀求商', '', '41687', '41689', '41703', '41799', '2', '60', '2017-01-06 17:05:19', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1664', '关于小括号的混合运算', '', '41687', '41689', '41703', '41800', '2', '60', '2017-01-06 17:05:19', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1665', '有余数除法的认识和竖式计算', '', '41687', '41689', '41703', '41801', '2', '60', '2017-01-06 17:05:19', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1666', '1000和10000以内数的认识', '', '41687', '41689', '41703', '41802', '2', '60', '2017-01-06 17:05:19', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1667', '10000以内数的大小比较', '', '41687', '41689', '41703', '41802', '2', '60', '2017-01-06 17:05:20', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1668', '近似数和整百、整千数加减法', '', '41687', '41689', '41703', '41802', '2', '60', '2017-01-06 17:05:20', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1669', '克和千克', '', '41687', '41689', '41703', '41803', '2', '60', '2017-01-06 17:05:20', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1670', '认识厘米、米、线段和选择度量单位', '', '41687', '41689', '41703', '41804', '2', '69', '2017-01-06 17:05:20', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1671', '认识角和直角、锐角、钝角', '', '41687', '41689', '41703', '41805', '2', '69', '2017-01-06 17:05:20', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1672', '观察物体', '', '41687', '41689', '41703', '41806', '2', '75', '2017-01-06 17:05:20', '1', '1', '40', '0');
INSERT INTO `xxj_video` VALUES ('1673', '轴对称、平移和旋转', '', '41687', '41689', '41703', '41807', '2', '75', '2017-01-06 17:05:20', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1674', '搭配（排列组合）', '', '41687', '41689', '41703', '41808', '2', '75', '2017-01-06 17:05:20', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1675', '生活中的推理', '', '41687', '41689', '41703', '41808', '2', '75', '2017-01-06 17:05:20', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1676', '数据收集整理', '', '41687', '41689', '41703', '41809', '2', '75', '2017-01-06 17:05:20', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1677', '汉字字形的演变和字义的变化', '', '41687', '41690', '41710', '41836', '1', '63', '2017-01-06 17:05:20', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1678', '同音词辨析', '', '41687', '41690', '41710', '41836', '1', '63', '2017-01-06 17:05:20', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1679', '近义词辨析', '', '41687', '41690', '41710', '41836', '1', '63', '2017-01-06 17:05:20', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1680', '多义词在不同语境中的意思', '', '41687', '41690', '41710', '41836', '1', '63', '2017-01-06 17:05:20', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1681', '照样子，写词语', '', '41687', '41690', '41710', '41837', '1', '116', '2017-01-06 17:05:20', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1682', '解读出自寓言、神话的成语', '', '41687', '41690', '41710', '41837', '1', '116', '2017-01-06 17:05:20', '0', '0', '28', '0');
INSERT INTO `xxj_video` VALUES ('1683', '并列、递进关系的概念及运用', '', '41687', '41690', '41710', '41840', '1', '63', '2017-01-06 17:05:20', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1684', '扩句、缩句', '', '41687', '41690', '41710', '41841', '1', '76', '2017-01-06 17:05:20', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1685', '成分残缺、归类不当', '', '41687', '41690', '41710', '41842', '1', '76', '2017-01-06 17:05:20', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1686', '比喻、拟人', '', '41687', '41690', '41710', '41843', '1', '76', '2017-01-06 17:05:20', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1687', '分号、顿号在具体语境中的用法', '', '41687', '41690', '41710', '41844', '1', '63', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1688', '关于奉献、珍惜时间的名言警句', '', '41687', '41690', '41710', '41845', '1', '63', '2017-01-06 17:05:20', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1689', '总起句、中心句、过渡句的辨识', '', '41687', '41690', '41710', '41846', '2', '80', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1690', '怎样理解句子', '', '41687', '41690', '41710', '41846', '2', '80', '2017-01-06 17:05:20', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1691', '给自然段分层，写出层意', '', '41687', '41690', '41710', '41846', '2', '81', '2017-01-06 17:05:20', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1692', '总结自然段的段意', '', '41687', '41690', '41710', '41846', '2', '81', '2017-01-06 17:05:20', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1693', '概括文章的主要内容', '', '41687', '41690', '41710', '41846', '2', '82', '2017-01-06 17:05:20', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1694', '节日诗', '', '41687', '41690', '41710', '41847', '2', '64', '2017-01-06 17:05:20', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1695', '写景诗', '', '41687', '41690', '41710', '41847', '2', '64', '2017-01-06 17:05:20', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1696', '山水诗', '', '41687', '41690', '41710', '41847', '2', '64', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1697', '咏怀诗', '', '41687', '41690', '41710', '41847', '2', '64', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1698', '中国寓言故事', '', '41687', '41690', '41710', '41848', '2', '64', '2017-01-06 17:05:20', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1699', '中国神话传说', '', '41687', '41690', '41710', '41849', '2', '64', '2017-01-06 17:05:20', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1700', '怎样写写景作文', '', '41687', '41690', '41710', '41850', '2', '83', '2017-01-06 17:05:20', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1701', '怎样写写事作文', '', '41687', '41690', '41710', '41850', '2', '83', '2017-01-06 17:05:20', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1702', '怎样写童话', '', '41687', '41690', '41710', '41851', '2', '84', '2017-01-06 17:05:20', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('1703', '怎样写观察日记', '', '41687', '41690', '41710', '41852', '2', '83', '2017-01-06 17:05:20', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1704', '汉字字形的演变和字义的变化', '', '41687', '41691', '41724', '41881', '1', '64', '2017-01-06 17:05:20', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1705', '同音词辨析', '', '41687', '41691', '41724', '41881', '1', '64', '2017-01-06 17:05:20', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1706', '近义词辨析', '', '41687', '41691', '41724', '41881', '1', '64', '2017-01-06 17:05:20', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1707', '照样子，写词语', '', '41687', '41691', '41724', '41882', '1', '64', '2017-01-06 17:05:20', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1708', '解读出自典故中的成语', '', '41687', '41691', '41724', '41882', '1', '64', '2017-01-06 17:05:20', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1709', '多义词在不同语境中的意思', '', '41687', '41691', '41724', '41883', '1', '64', '2017-01-06 17:05:20', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1710', '词语搭配的方法和运用', '', '41687', '41691', '41724', '42019', '1', '64', '2017-01-06 17:05:20', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1711', '转折、选择关系的概念及运用', '', '41687', '41691', '41724', '41885', '1', '64', '2017-01-06 17:05:20', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1712', '反问句、陈述句、感叹句的转换', '', '41687', '41691', '41724', '41886', '1', '64', '2017-01-06 17:05:20', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1713', '搭配不当、词序颠倒', '', '41687', '41691', '41724', '41887', '1', '64', '2017-01-06 17:05:20', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1714', '夸张、排比', '', '41687', '41691', '41724', '41888', '1', '64', '2017-01-06 17:05:20', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1715', '问号、感叹号在语境中的用法及意义', '', '41687', '41691', '41724', '41889', '1', '64', '2017-01-06 17:05:20', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1716', '关于生命和母爱的名言警句', '', '41687', '41691', '41724', '41890', '1', '64', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1717', '联系上下文理解词句的意思', '', '41687', '41691', '41724', '41891', '2', '89', '2017-01-06 17:05:20', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1718', '学会鉴赏和运用语言', '', '41687', '41691', '41724', '41891', '2', '89', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1719', '给文章分段，概括段落大意', '', '41687', '41691', '41724', '41891', '2', '89', '2017-01-06 17:05:20', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1720', '体会文章表达的中心思想', '', '41687', '41691', '41724', '41891', '2', '89', '2017-01-06 17:05:20', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1721', '哲理诗', '', '41687', '41691', '41724', '41892', '2', '63', '2017-01-06 17:05:20', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('1722', '山水诗', '', '41687', '41691', '41724', '41892', '2', '63', '2017-01-06 17:05:20', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1723', '乡村生活诗', '', '41687', '41691', '41724', '41892', '2', '63', '2017-01-06 17:05:20', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1724', '送别诗', '', '41687', '41691', '41724', '41892', '2', '63', '2017-01-06 17:05:20', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1725', '中国民间故事', '', '41687', '41691', '41724', '41893', '2', '63', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1726', '外国神话故事', '', '41687', '41691', '41724', '41893', '2', '63', '2017-01-06 17:05:20', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1727', '写人作文', '', '41687', '41691', '41724', '41894', '2', '71', '2017-01-06 17:05:20', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1728', '叙事作文 -写动物', '', '41687', '41691', '41724', '41894', '2', '71', '2017-01-06 17:05:20', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1729', '叙事作文 -写植物', '', '41687', '41691', '41724', '41894', '2', '71', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1730', '如何写信', '', '41687', '41691', '41724', '41895', '2', '91', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1731', '如何写导游词', '', '41687', '41691', '41724', '41895', '2', '91', '2017-01-06 17:05:20', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1732', '怎样写想象作文', '', '41687', '41691', '41724', '41896', '2', '91', '2017-01-06 17:05:20', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1733', '汉字字形的演变和字义的变化', '', '41687', '41692', '41728', '41926', '1', '63', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1734', '同音词辨析', '', '41687', '41692', '41728', '41926', '1', '63', '2017-01-06 17:05:20', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1735', '近义词辨析', '', '41687', '41692', '41728', '41926', '1', '63', '2017-01-06 17:05:20', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1736', '照样子，写词语', '', '41687', '41692', '41728', '41927', '1', '63', '2017-01-06 17:05:20', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1737', '出自古诗文的成语', '', '41687', '41692', '41728', '41927', '1', '116', '2017-01-06 17:05:20', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1738', '多义词在不同语境中的意思', '', '41687', '41692', '41728', '41928', '1', '63', '2017-01-06 17:05:20', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1739', '褒义词、贬义词、中性词的概念及语境', '', '41687', '41692', '41728', '41929', '1', '63', '2017-01-06 17:05:20', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1740', '因果、假设关系的概念及运用', '', '41687', '41692', '41728', '41930', '1', '63', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1741', '直述句与转述句、肯定句与否定句的转换', '', '41687', '41692', '41728', '41931', '1', '63', '2017-01-06 17:05:20', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1742', '语义重复、语义矛盾', '', '41687', '41692', '41728', '41932', '1', '76', '2017-01-06 17:05:20', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1743', '设问、反问', '', '41687', '41692', '41728', '41933', '1', '63', '2017-01-06 17:05:20', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1744', '冒号、引号在具体语境中的用法及意义', '', '41687', '41692', '41728', '41934', '1', '116', '2017-01-06 17:05:20', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1745', '关于持之以恒、书籍的名言警句', '', '41687', '41692', '41728', '41935', '1', '63', '2017-01-06 17:05:20', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1746', '如何抓住说明文要点', '', '41687', '41692', '41728', '41936', '2', '96', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1747', '了解说明方法及其表达效果', '', '41687', '41692', '41728', '41936', '2', '96', '2017-01-06 17:05:20', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1748', '文章的表达顺序', '', '41687', '41692', '41728', '41937', '2', '96', '2017-01-06 17:05:20', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1749', '关键词、句在表情达意上的作用', '', '41687', '41692', '41728', '41937', '2', '97', '2017-01-06 17:05:20', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('1750', '如何抓住人物特点', '', '41687', '41692', '41728', '41937', '2', '97', '2017-01-06 17:05:20', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1751', '理解重点句段的作用', '', '41687', '41692', '41728', '41937', '2', '97', '2017-01-06 17:05:20', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1752', '咏怀诗', '', '41687', '41692', '41728', '41938', '2', '64', '2017-01-06 17:05:20', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1753', '乡村生活诗', '', '41687', '41692', '41728', '41938', '2', '64', '2017-01-06 17:05:20', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1754', '儿童生活诗', '', '41687', '41692', '41728', '41938', '2', '64', '2017-01-06 17:05:20', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1755', '写景寄情诗', '', '41687', '41692', '41728', '41938', '2', '64', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1756', '《水浒传》', '', '41687', '41692', '41728', '41939', '2', '64', '2017-01-06 17:05:21', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1757', '《童年》', '', '41687', '41692', '41728', '41939', '2', '64', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1758', '怎样写说明文', '', '41687', '41692', '41728', '41940', '2', '96', '2017-01-06 17:05:21', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1759', '怎样写好读后感', '', '41687', '41692', '41728', '41940', '2', '98', '2017-01-06 17:05:21', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1760', '怎样写好采访记录', '', '41687', '41692', '41728', '41940', '2', '99', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1761', '汉字字形的演变和字义的变化', '', '41687', '41693', '41732', '41967', '1', '64', '2017-01-06 17:05:21', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1762', '同音词辨析', '', '41687', '41693', '41732', '41967', '1', '64', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1763', '近义词辨析', '', '41687', '41693', '41732', '41967', '1', '64', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1764', '照样子，写词语', '', '41687', '41693', '41732', '41968', '1', '64', '2017-01-06 17:05:21', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1765', '出自名著的成语', '', '41687', '41693', '41732', '41968', '1', '64', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1766', '多义词在不同语境中的意思', '', '41687', '41693', '41732', '41969', '1', '64', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1767', '褒义词、贬义词、中性词的概念及适用语境', '', '41687', '41693', '41732', '41970', '1', '64', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1768', '条件、解说关系的概念及运用', '', '41687', '41693', '41732', '41971', '1', '64', '2017-01-06 17:05:21', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1769', '变换说法句意；陈述句与比喻句的转换', '', '41687', '41693', '41732', '41972', '1', '64', '2017-01-06 17:05:21', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1770', '不合逻辑、指代不明', '', '41687', '41693', '41732', '41973', '1', '64', '2017-01-06 17:05:21', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1771', '对偶、反复', '', '41687', '41693', '41732', '41974', '1', '64', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1772', '省略号、破折号在语境中的用法及意义', '', '41687', '41693', '41732', '41975', '1', '64', '2017-01-06 17:05:21', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1773', '关于爱国的名言和自然现象的谚语', '', '41687', '41693', '41732', '41976', '1', '64', '2017-01-06 17:05:21', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1774', '把握意象，进入意境', '', '41687', '41693', '41732', '41977', '2', '99', '2017-01-06 17:05:21', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1775', '品析语言和技巧', '', '41687', '41693', '41732', '41977', '2', '99', '2017-01-06 17:05:21', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1776', '抓住关键的词句，领会诗歌的思想感情', '', '41687', '41693', '41732', '41977', '2', '99', '2017-01-06 17:05:21', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1777', '抓住环境描写，感受其作用', '', '41687', '41693', '41732', '41978', '2', '114', '2017-01-06 17:05:21', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1778', '写景记叙文的阅读方法', '', '41687', '41693', '41732', '41978', '2', '114', '2017-01-06 17:05:21', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1779', '巧妙解答开放性题目', '', '41687', '41693', '41732', '41978', '2', '114', '2017-01-06 17:05:21', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1780', '送别诗', '', '41687', '41693', '41732', '41979', '2', '63', '2017-01-06 17:05:21', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1781', '写景诗', '', '41687', '41693', '41732', '41979', '2', '63', '2017-01-06 17:05:21', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1782', '咏怀诗', '', '41687', '41693', '41732', '41979', '2', '63', '2017-01-06 17:05:21', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1783', '言志诗', '', '41687', '41693', '41732', '41979', '2', '63', '2017-01-06 17:05:21', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1784', '《西游记》', '', '41687', '41693', '41732', '41980', '2', '63', '2017-01-06 17:05:21', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1785', '《鲁滨逊漂流记》', '', '41687', '41693', '41732', '41980', '2', '63', '2017-01-06 17:05:21', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1786', '如何写看图作文', '', '41687', '41693', '41732', '41983', '2', '114', '2017-01-06 17:05:21', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1787', '在叙事中表达自己情感的变化', '', '41687', '41693', '41732', '41983', '2', '98', '2017-01-06 17:05:21', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1788', '演讲稿', '', '41687', '41693', '41732', '41983', '2', '98', '2017-01-06 17:05:21', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1789', '建议书', '', '41687', '41693', '41732', '41983', '2', '98', '2017-01-06 17:05:21', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1790', '秒的认识和分与秒的换算', '', '41687', '41690', '41712', '41820', '1', '59', '2017-01-06 17:05:21', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1791', '经过时间的计算', '', '41687', '41690', '41712', '41820', '1', '59', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1792', '两位数加、减两位数的口算', '', '41687', '41690', '41712', '41821', '1', '59', '2017-01-06 17:05:21', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1793', '笔算几百几十加、减几百几十', '', '41687', '41690', '41712', '41821', '1', '59', '2017-01-06 17:05:21', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1794', '三位数加三位数', '', '41687', '41690', '41712', '41821', '1', '59', '2017-01-06 17:05:21', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1795', '三位数减三位数', '', '41687', '41690', '41712', '41821', '1', '59', '2017-01-06 17:05:21', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1796', '毫米、分米、千米的认识', '', '41687', '41690', '41712', '41822', '1', '59', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1797', '吨的认识', '', '41687', '41690', '41712', '41822', '1', '59', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1798', '求一个数是另一个数的几倍', '', '41687', '41690', '41712', '41823', '1', '59', '2017-01-06 17:05:21', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1799', '求一个数的几倍是多少', '', '41687', '41690', '41712', '41823', '1', '59', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1800', '多位数乘一位数的笔算乘法1', '', '41687', '41690', '41712', '41824', '1', '60', '2017-01-06 17:05:21', '1', '1', '18', '0');
INSERT INTO `xxj_video` VALUES ('1801', '多位数乘一位数的笔算乘法2', '', '41687', '41690', '41712', '41824', '1', '60', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1802', '因数中间或末尾有0的乘法', '', '41687', '41690', '41712', '41824', '1', '60', '2017-01-06 17:05:21', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1803', '分数的简单计算与简单应用', '', '41687', '41690', '41712', '41825', '1', '60', '2017-01-06 17:05:21', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1804', '两、三位数除以一位数', '', '41687', '41690', '41712', '41826', '1', '60', '2017-01-06 17:05:21', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('1805', '商中间或末尾有0的笔算除法', '', '41687', '41690', '41712', '41826', '1', '60', '2017-01-06 17:05:21', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('1806', '三位数除以一位数的估算', '', '41687', '41690', '41712', '41826', '1', '60', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1807', '两位数乘两位数（一）', '', '41687', '41690', '41712', '42010', '2', '60', '2017-01-06 17:05:21', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1808', '两位数乘两位数（二）', '', '41687', '41690', '41712', '42010', '2', '60', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1809', '年、月、日的认识', '', '41687', '41690', '41712', '42011', '2', '60', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1810', '24时计时法', '', '41687', '41690', '41712', '42011', '2', '60', '2017-01-06 17:05:21', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1811', '认识小数及简单的小数加、减法', '', '41687', '41690', '41712', '42012', '2', '60', '2017-01-06 17:05:21', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1812', '数字编码', '', '41687', '41690', '41712', '42013', '2', '60', '2017-01-06 17:05:21', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1813', '集合', '', '41687', '41690', '41712', '42013', '2', '60', '2017-01-06 17:05:21', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1814', '认识方向', '', '41687', '41690', '41712', '42014', '2', '78', '2017-01-06 17:05:21', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1815', '正方形的周长和长方形的周长', '', '41687', '41690', '41712', '42015', '2', '70', '2017-01-06 17:05:21', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1816', '面积和面积单位', '', '41687', '41690', '41712', '42016', '2', '78', '2017-01-06 17:05:21', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1817', '长方形、正方形面积的计算', '', '41687', '41690', '41712', '42016', '2', '78', '2017-01-06 17:05:21', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1818', '面积单位间的进率', '', '41687', '41690', '41712', '42016', '2', '78', '2017-01-06 17:05:21', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1819', '复式统计表', '', '41687', '41690', '41712', '42017', '2', '79', '2017-01-06 17:05:21', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1820', '搭配的学问', '', '41687', '41690', '41712', '42018', '2', '69', '2017-01-06 17:05:21', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1821', '亿以内数的认识、读法和写法', '', '41687', '41691', '41725', '41866', '1', '59', '2017-01-06 17:05:21', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1822', '亿以内数的大小比较和近似数', '', '41687', '41691', '41725', '41866', '1', '59', '2017-01-06 17:05:21', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1823', '数的产生、十进制、亿以上数的读写', '', '41687', '41691', '41725', '41866', '1', '59', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1824', '亿以内数和亿以上数的改写', '', '41687', '41691', '41725', '41866', '1', '59', '2017-01-06 17:05:21', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1825', '计算工具的认识', '', '41687', '41691', '41725', '41866', '1', '59', '2017-01-06 17:05:21', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1826', '认识公顷和认识平方千米', '', '41687', '41691', '41725', '41867', '1', '59', '2017-01-06 17:05:21', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1827', '三位数乘两位数的笔算', '', '41687', '41691', '41725', '41868', '1', '59', '2017-01-06 17:05:21', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1828', '积的变化规律和常见的数量关系', '', '41687', '41691', '41725', '41868', '1', '59', '2017-01-06 17:05:21', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1829', '口算除法', '', '41687', '41691', '41725', '41869', '1', '59', '2017-01-06 17:05:21', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1830', '除数是整十数、近整十数的笔算除法', '', '41687', '41691', '41725', '41869', '1', '59', '2017-01-06 17:05:21', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1831', '商是两位数的笔算除法', '', '41687', '41691', '41725', '41869', '1', '59', '2017-01-06 17:05:21', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1832', '商的变化规律', '', '41687', '41691', '41725', '41869', '1', '59', '2017-01-06 17:05:22', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1833', '四则运算的意义和关系', '', '41687', '41691', '41725', '41870', '1', '60', '2017-01-06 17:05:22', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1834', '四则混合运算以及租车方案', '', '41687', '41691', '41725', '41870', '1', '60', '2017-01-06 17:05:22', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1835', '加法、乘法运算律和连减的简便运算', '', '41687', '41691', '41725', '41871', '1', '60', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1836', '小数的意义、读写、性质、比大小', '', '41687', '41691', '41725', '41872', '2', '60', '2017-01-06 17:05:22', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('1837', '小数点移动引起小数大小的变化', '', '41687', '41691', '41725', '41872', '2', '60', '2017-01-06 17:05:22', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1838', '小数与单位换算和小数的近似数', '', '41687', '41691', '41725', '41872', '2', '60', '2017-01-06 17:05:22', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1839', '小数加减法及加减混合运算', '', '41687', '41691', '41725', '41873', '2', '60', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1840', '整数加法运算定律推广到小数', '', '41687', '41691', '41725', '41873', '2', '60', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1841', '线段、直线、射线', '', '41687', '41691', '41725', '41874', '2', '66', '2017-01-06 17:05:22', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1842', '角和角的度量、角的分类、画角', '', '41687', '41691', '41725', '41874', '2', '66', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1843', '平行与垂直、垂线的画法', '', '41687', '41691', '41725', '41875', '2', '66', '2017-01-06 17:05:22', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1844', '平行四边形和梯形', '', '41687', '41691', '41725', '41875', '2', '66', '2017-01-06 17:05:22', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1845', '观察物体', '', '41687', '41691', '41725', '41876', '2', '66', '2017-01-06 17:05:22', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1846', '三角形的特性、分类、内角和', '', '41687', '41691', '41725', '41877', '2', '70', '2017-01-06 17:05:22', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1847', '轴对称和平移', '', '41687', '41691', '41725', '41878', '2', '79', '2017-01-06 17:05:22', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1848', '条形统计图', '', '41687', '41691', '41725', '41879', '2', '79', '2017-01-06 17:05:22', '0', '0', '24', '0');
INSERT INTO `xxj_video` VALUES ('1849', '优化', '', '41687', '41691', '41725', '41880', '2', '79', '2017-01-06 17:05:22', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1850', '鸡兔同笼问题', '', '41687', '41691', '41725', '41880', '2', '78', '2017-01-06 17:05:22', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1851', '小数乘整数、乘小数、积的近似数', '', '41687', '41692', '41729', '41911', '1', '60', '2017-01-06 17:05:22', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1852', '整数乘法运算定律推广到小数', '', '41687', '41692', '41729', '41911', '1', '60', '2017-01-06 17:05:22', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1853', '小数除法', '', '41687', '41692', '41729', '41912', '1', '60', '2017-01-06 17:05:22', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1854', '商的近似数、循环小数', '', '41687', '41692', '41729', '41912', '1', '60', '2017-01-06 17:05:22', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1855', '用计算器探索规律', '', '41687', '41692', '41729', '41912', '1', '60', '2017-01-06 17:05:22', '1', '1', '6', '0');
INSERT INTO `xxj_video` VALUES ('1856', '用字母表示数、化简含有字母的式子', '', '41687', '41692', '41729', '41913', '1', '60', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1857', '方程的意义、等式的性质', '', '41687', '41692', '41729', '41913', '1', '60', '2017-01-06 17:05:22', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1858', '解方程', '', '41687', '41692', '41729', '41913', '1', '60', '2017-01-06 17:05:22', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1859', '因数和倍数', '', '41687', '41692', '41729', '41914', '1', '59', '2017-01-06 17:05:22', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1860', '2、5、3的倍数的特征', '', '41687', '41692', '41729', '41914', '1', '59', '2017-01-06 17:05:22', '0', '0', '7', '0');
INSERT INTO `xxj_video` VALUES ('1861', '质数和合数', '', '41687', '41692', '41729', '41914', '1', '59', '2017-01-06 17:05:22', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1862', '分数的认识、分数的基本性质', '', '41687', '41692', '41729', '41915', '1', '59', '2017-01-06 17:05:22', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1863', '约分、通分', '', '41687', '41692', '41729', '41915', '1', '59', '2017-01-06 17:05:22', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1864', '分数和小数的互化', '', '41687', '41692', '41729', '41915', '1', '59', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1865', '简单分数加、减法', '', '41687', '41692', '41729', '41916', '2', '59', '2017-01-06 17:05:22', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1866', '分数加减混合运算', '', '41687', '41692', '41729', '41916', '2', '59', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1867', '用数对表示位置', '', '41687', '41692', '41729', '41917', '2', '94', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1868', '平行四边形的面积', '', '41687', '41692', '41729', '41918', '2', '67', '2017-01-06 17:05:22', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('1869', '三角形的面积', '', '41687', '41692', '41729', '41918', '2', '67', '2017-01-06 17:05:22', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1870', '梯形的面积', '', '41687', '41692', '41729', '41918', '2', '67', '2017-01-06 17:05:22', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('1871', '组合图形的面积', '', '41687', '41692', '41729', '41918', '2', '67', '2017-01-06 17:05:22', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1872', '观察物体', '', '41687', '41692', '41729', '41919', '2', '94', '2017-01-06 17:05:22', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1873', '长方体和正方体的认识', '', '41687', '41692', '41729', '41920', '2', '95', '2017-01-06 17:05:22', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1874', '长方体和正方体的表面积', '', '41687', '41692', '41729', '41920', '2', '95', '2017-01-06 17:05:22', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1875', '长方体和正方体的体积', '', '41687', '41692', '41729', '41920', '2', '95', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1876', '容积和容积单位', '', '41687', '41692', '41729', '41920', '2', '95', '2017-01-06 17:05:22', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1877', '探索图形', '', '41687', '41692', '41729', '41921', '2', '94', '2017-01-06 17:05:22', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1878', '图形的旋转', '', '41687', '41692', '41729', '41921', '2', '94', '2017-01-06 17:05:22', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1879', '折线统计图', '', '41687', '41692', '41729', '41922', '2', '94', '2017-01-06 17:05:22', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1880', '可能性', '', '41687', '41692', '41729', '41923', '2', '94', '2017-01-06 17:05:22', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1881', '打电话', '', '41687', '41692', '41729', '41924', '2', '94', '2017-01-06 17:05:22', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1882', '植树问题', '', '41687', '41692', '41729', '41925', '2', '94', '2017-01-06 17:05:22', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1883', '找次品', '', '41687', '41692', '41729', '41925', '2', '94', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1884', '分数乘整数、乘分数、乘小数', '', '41687', '41693', '41733', '41956', '1', '60', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1885', '分数乘法交换律、结合律、分配律', '', '41687', '41693', '41733', '41956', '1', '60', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1886', '倒数的认识、分数除法', '', '41687', '41693', '41733', '41957', '1', '60', '2017-01-06 17:05:22', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1887', '分数混合运算', '', '41687', '41693', '41733', '41957', '1', '60', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1888', '比的意义', '', '41687', '41693', '41733', '41958', '1', '60', '2017-01-06 17:05:22', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1889', '比的基本性质', '', '41687', '41693', '41733', '41958', '1', '60', '2017-01-06 17:05:22', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1890', '百分数的意义与读写', '', '41687', '41693', '41733', '41959', '1', '60', '2017-01-06 17:05:22', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1891', '百分数、分数、小数之间的互化', '', '41687', '41693', '41733', '41959', '1', '60', '2017-01-06 17:05:22', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1892', '用百分数解决问题', '', '41687', '41693', '41733', '41959', '1', '60', '2017-01-06 17:05:22', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1893', '折扣和成数', '', '41687', '41693', '41733', '41959', '1', '60', '2017-01-06 17:05:22', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1894', '税率和利率', '', '41687', '41693', '41733', '41959', '1', '60', '2017-01-06 17:05:22', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1895', '负数的意义、正负数的读和写', '', '41687', '41693', '41733', '41960', '1', '59', '2017-01-06 17:05:22', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1896', '相反意义的量、在直线上表示正负数', '', '41687', '41693', '41733', '41960', '1', '59', '2017-01-06 17:05:22', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1897', '比例的意义和基本性质', '', '41687', '41693', '41733', '41961', '2', '59', '2017-01-06 17:05:22', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1898', '解比例', '', '41687', '41693', '41733', '41961', '2', '59', '2017-01-06 17:05:22', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1899', '正比例、反比例', '', '41687', '41693', '41733', '41961', '2', '59', '2017-01-06 17:05:22', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1900', '比例尺的认识、应用', '', '41687', '41693', '41733', '41961', '2', '59', '2017-01-06 17:05:22', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1901', '图形的放大与缩小', '', '41687', '41693', '41733', '41961', '2', '59', '2017-01-06 17:05:22', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('1902', '确定位置、描述简单的路线图', '', '41687', '41693', '41733', '41962', '2', '103', '2017-01-06 17:05:22', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1903', '圆的认识', '', '41687', '41693', '41733', '41963', '2', '111', '2017-01-06 17:05:22', '1', '1', '19', '0');
INSERT INTO `xxj_video` VALUES ('1904', '圆的周长', '', '41687', '41693', '41733', '41963', '2', '105', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1905', '圆的面积', '', '41687', '41693', '41733', '41963', '2', '106', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1906', '扇形', '', '41687', '41693', '41733', '41963', '2', '105', '2017-01-06 17:05:22', '0', '0', '20', '0');
INSERT INTO `xxj_video` VALUES ('1907', '圆柱的认识', '', '41687', '41693', '41733', '41964', '2', '107', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1908', '圆柱的侧面积、表面积', '', '41687', '41693', '41733', '41964', '2', '108', '2017-01-06 17:05:22', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1909', '圆柱的体积、容积的应用', '', '41687', '41693', '41733', '41964', '2', '109', '2017-01-06 17:05:22', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1910', '圆锥的认识、圆锥的体积', '', '41687', '41693', '41733', '41964', '2', '110', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1911', '扇形统计图、统计图的选择', '', '41687', '41693', '41733', '41965', '2', '111', '2017-01-06 17:05:22', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1912', '数与形（规律问题）', '', '41687', '41693', '41733', '41966', '2', '112', '2017-01-06 17:05:22', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1913', '鸽巢问题（抽屉原理）', '', '41687', '41693', '41733', '41966', '2', '113', '2017-01-06 17:05:22', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1914', '填写运算符号完成算式', '', '41687', '41690', '41716', '41861', '0', '57', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1915', '24点游戏', '', '41687', '41690', '41716', '41861', '0', '57', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1916', '和倍问题', '', '41687', '41690', '41716', '41862', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1917', '差倍问题', '', '41687', '41690', '41716', '41862', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1918', '字典排列法', '', '41687', '41690', '41716', '41863', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1919', '树形图', '', '41687', '41690', '41716', '41863', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1920', '平移法求周长', '', '41687', '41690', '41716', '42001', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1921', '标向法求周长', '', '41687', '41690', '41716', '42001', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1922', '基本周期问题', '', '41687', '41690', '41716', '42002', '0', '59', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1923', '环形周期问题', '', '41687', '41690', '41716', '42002', '0', '59', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1924', '基本的鸡兔同笼', '', '41687', '41691', '41727', '41906', '0', '57', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1925', '条件隐藏的鸡兔同笼', '', '41687', '41691', '41727', '41906', '0', '57', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1926', '和差倍相关的年龄问题', '', '41687', '41691', '41727', '41907', '0', '58', '2017-01-06 17:05:23', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1927', '变倍型年龄问题', '', '41687', '41691', '41727', '41907', '0', '58', '2017-01-06 17:05:23', '0', '0', '3', '0');
INSERT INTO `xxj_video` VALUES ('1928', '加减竖式谜', '', '41687', '41691', '41727', '41908', '0', '58', '2017-01-06 17:05:23', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1929', '乘除竖式谜', '', '41687', '41691', '41727', '41908', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1930', '基本的盈亏问题', '', '41687', '41691', '41727', '42003', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1931', '转化条件的盈亏问题', '', '41687', '41691', '41727', '42003', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1932', '相遇问题', '', '41687', '41691', '41727', '42004', '0', '59', '2017-01-06 17:05:23', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1933', '追及问题', '', '41687', '41691', '41727', '42004', '0', '59', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1934', '整除判定方法', '', '41687', '41692', '41731', '41951', '0', '57', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1935', '整除综合应用', '', '41687', '41692', '41731', '41951', '0', '57', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1936', '基本牛吃草', '', '41687', '41692', '41731', '41952', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1937', '排水问题', '', '41687', '41692', '41731', '41952', '0', '58', '2017-01-06 17:05:23', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('1938', '两个对象的容斥原理', '', '41687', '41692', '41731', '41953', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1939', '三个对象的容斥原理', '', '41687', '41692', '41731', '41953', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1940', '明星质数', '', '41687', '41692', '41731', '42005', '0', '58', '2017-01-06 17:05:23', '1', '1', '5', '0');
INSERT INTO `xxj_video` VALUES ('1941', '分解质因数', '', '41687', '41692', '41731', '42005', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1942', '因数个数定理', '', '41687', '41692', '41731', '42006', '0', '59', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1943', '最大公因数与最小公倍数', '', '41687', '41692', '41731', '42006', '0', '59', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1944', '提取公因数', '', '41687', '41693', '41735', '41992', '0', '57', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1945', '换元法', '', '41687', '41693', '41735', '41992', '0', '57', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1946', '二元一次方程组（一）', '', '41687', '41693', '41735', '41993', '0', '58', '2017-01-06 17:05:23', '0', '0', '5', '0');
INSERT INTO `xxj_video` VALUES ('1947', '二元一次方程组（二）', '', '41687', '41693', '41735', '41993', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1948', '公式及应用', '', '41687', '41693', '41735', '41994', '0', '58', '2017-01-06 17:05:23', '1', '1', '4', '0');
INSERT INTO `xxj_video` VALUES ('1949', '份数法', '', '41687', '41693', '41735', '41994', '0', '58', '2017-01-06 17:05:23', '1', '1', '3', '0');
INSERT INTO `xxj_video` VALUES ('1950', '正比例', '', '41687', '41693', '41735', '42007', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1951', '反比例', '', '41687', '41693', '41735', '42007', '0', '58', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1952', '三视图法求表面积', '', '41687', '41693', '41735', '42008', '0', '59', '2017-01-06 17:05:23', '0', '0', '6', '0');
INSERT INTO `xxj_video` VALUES ('1953', '立体图图形与排水问题', '', '41687', '41693', '41735', '42008', '0', '59', '2017-01-06 17:05:23', '0', '0', '4', '0');
INSERT INTO `xxj_video` VALUES ('1954', '26个英文字母', '', '41687', '41690', '41714', '41853', '1', '65', '2017-01-06 17:05:23', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('1955', '五个元音字母的短音发音规律', '', '41687', '41690', '41714', '41853', '1', '65', '2017-01-06 17:05:23', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('1956', '名词（短语）与代词', '', '41687', '41690', '41714', '41854', '1', '65', '2017-01-06 17:05:23', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('1957', '形容词', '', '41687', '41690', '41714', '41854', '1', '65', '2017-01-06 17:05:23', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1958', '介词', '', '41687', '41690', '41714', '41854', '1', '65', '2017-01-06 17:05:23', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1959', '与他人打招呼、自我介绍及告别', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1960', '问候他人并回应他人的问候', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1961', '介绍他人、五官及身体部位', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('1962', '表达赞美或欣赏', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1963', '邀请他人吃/喝东西', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1964', '表达想吃的食物及回答', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1965', '表达感谢并回应感谢', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1966', '向别人介绍自己的国籍或籍贯', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1967', '描述人物动物外形特征', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1968', '表达对某物的好恶', '', '41687', '41690', '41714', '41855', '1', '65', '2017-01-06 17:05:23', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('1969', '询问并回答他人意见', '', '41687', '41690', '41714', '41856', '2', '65', '2017-01-06 17:05:23', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1970', '向他人确认陌生人的身份并回答', '', '41687', '41690', '41714', '41856', '2', '65', '2017-01-06 17:05:23', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1971', '询问物品位置，并作出相应判断', '', '41687', '41690', '41714', '41856', '2', '65', '2017-01-06 17:05:23', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1972', '询问并回答对方是否喜欢某物', '', '41687', '41690', '41714', '41856', '2', '65', '2017-01-06 17:05:23', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('1973', '询问并回答对方姓名', '', '41687', '41690', '41714', '41857', '2', '85', '2017-01-06 17:05:23', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1974', '询问对方近况并回答', '', '41687', '41690', '41714', '41857', '2', '85', '2017-01-06 17:05:23', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1975', '询问并回答近/远处不认识的事物', '', '41687', '41690', '41714', '41857', '2', '85', '2017-01-06 17:05:23', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1976', '询问并回答物品的数量', '', '41687', '41690', '41714', '41857', '2', '86', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1977', '询问并回答他人年龄', '', '41687', '41690', '41714', '41857', '2', '86', '2017-01-06 17:05:23', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('1978', '询问他人的国籍或籍贯并回答', '', '41687', '41690', '41714', '41857', '2', '86', '2017-01-06 17:05:23', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1979', '询问并回答远处的人物', '', '41687', '41690', '41714', '41857', '2', '87', '2017-01-06 17:05:23', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1980', '询问并回答物品、人物的位置、方位', '', '41687', '41690', '41714', '41857', '2', '87', '2017-01-06 17:05:23', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1981', '听前、听时、听后', '', '41687', '41690', '41714', '41858', '2', '88', '2017-01-06 17:05:23', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1982', '五个W、生词处理', '', '41687', '41690', '41714', '41859', '2', '88', '2017-01-06 17:05:23', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1983', '审题、列提纲、选择格式', '', '41687', '41690', '41714', '41860', '2', '88', '2017-01-06 17:05:23', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('1984', '五个元音字母长音的发音规律', '', '41687', '41691', '41726', '41897', '1', '65', '2017-01-06 17:05:23', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('1985', '常见元音字母组合的发音规律', '', '41687', '41691', '41726', '41897', '1', '65', '2017-01-06 17:05:23', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('1986', '名词（短语）', '', '41687', '41691', '41726', '41898', '1', '65', '2017-01-06 17:05:23', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('1987', '形容词', '', '41687', '41691', '41726', '41898', '1', '65', '2017-01-06 17:05:23', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('1988', '动词（短语）', '', '41687', '41691', '41726', '41898', '1', '65', '2017-01-06 17:05:23', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('1989', '描述人物的性格和外貌', '', '41687', '41691', '41726', '41899', '1', '92', '2017-01-06 17:05:23', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('1990', '描述即将要做的事情', '', '41687', '41691', '41726', '41899', '1', '92', '2017-01-06 17:05:23', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('1992', '描述气候特征和天气情况', '', '41687', '41691', '41726', '41899', '1', '92', '2017-01-06 17:05:23', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('1993', '描述物品特点', '', '41687', '41691', '41726', '41899', '1', '92', '2017-01-06 17:05:23', '0', '0', '17', '0');
INSERT INTO `xxj_video` VALUES ('1994', '询问物品、人物的位置，并作出相应判断', '', '41687', '41691', '41726', '41900', '1', '65', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1995', '询问近处或远处的事物并回答', '', '41687', '41691', '41726', '41900', '1', '65', '2017-01-06 17:05:23', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('1996', '询问对方是否拥有某物并回答', '', '41687', '41691', '41726', '41900', '1', '65', '2017-01-06 17:05:23', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1997', '询问他人意见并回答', '', '41687', '41691', '41726', '41900', '1', '65', '2017-01-06 17:05:23', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('1998', '询问并回答人、物的位置、方位', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('1999', '询问并回答某处有什么物品', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('2000', '询问并回答物品的颜色', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2001', '询问并回答他人的姓名', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('2002', '征求并表达用餐意愿', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '0', '0', '8', '0');
INSERT INTO `xxj_video` VALUES ('2003', '提出餐具使用建议', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2004', '询问用餐的食物', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('2005', '询问并回答家中有几位成员', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2006', '询问并回答他人与说话方的亲属关系及职业', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:23', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2007', '询问时间并回答', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:24', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2008', '询问天气情况并回答', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:24', '1', '1', '9', '0');
INSERT INTO `xxj_video` VALUES ('2009', '询问并回答物品名称', '', '41687', '41691', '41726', '41901', '2', '65', '2017-01-06 17:05:24', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('2010', 'Let型祈使句', '', '41687', '41691', '41726', '41902', '2', '92', '2017-01-06 17:05:24', '0', '0', '21', '0');
INSERT INTO `xxj_video` VALUES ('2011', 'Do型祈使句', '', '41687', '41691', '41726', '41902', '2', '92', '2017-01-06 17:05:24', '1', '1', '21', '0');
INSERT INTO `xxj_video` VALUES ('2012', '听句子选择正确答案', '', '41687', '41691', '41726', '41903', '2', '117', '2017-01-06 17:05:24', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('2013', '根据短文内容选择正确答案', '', '41687', '41691', '41726', '41904', '2', '117', '2017-01-06 17:05:24', '1', '1', '25', '0');
INSERT INTO `xxj_video` VALUES ('2014', '写人作文', '', '41687', '41691', '41726', '41905', '2', '117', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2015', '字母y在单词词尾的发音规律', '', '41687', '41692', '41730', '41942', '1', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2016', '常见元音字母组合的发音规律', '', '41687', '41692', '41730', '41942', '1', '65', '2017-01-06 17:05:24', '1', '1', '22', '0');
INSERT INTO `xxj_video` VALUES ('2017', '常见辅音字母组合的发音规律', '', '41687', '41692', '41730', '41942', '1', '65', '2017-01-06 17:05:24', '1', '1', '20', '0');
INSERT INTO `xxj_video` VALUES ('2018', '名词（短语）与代词', '', '41687', '41692', '41730', '41943', '1', '65', '2017-01-06 17:05:24', '0', '0', '19', '0');
INSERT INTO `xxj_video` VALUES ('2019', '形容词', '', '41687', '41692', '41730', '41943', '1', '65', '2017-01-06 17:05:24', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('2020', '动词（短语）', '', '41687', '41692', '41730', '41943', '1', '65', '2017-01-06 17:05:24', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2021', '介词（短语）', '', '41687', '41692', '41730', '41943', '1', '65', '2017-01-06 17:05:24', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('2022', '数词', '', '41687', '41692', '41730', '41943', '1', '65', '2017-01-06 17:05:24', '0', '0', '18', '0');
INSERT INTO `xxj_video` VALUES ('2023', '描述某处有某物', '', '41687', '41692', '41730', '41944', '1', '102', '2017-01-06 17:05:24', '0', '0', '22', '0');
INSERT INTO `xxj_video` VALUES ('2024', '表达将会做某事', '', '41687', '41692', '41730', '41944', '1', '102', '2017-01-06 17:05:24', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('2025', '描述某物属于某人', '', '41687', '41692', '41730', '41944', '1', '102', '2017-01-06 17:05:24', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('2026', '询问并回答某人的性格或外貌特征', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('2027', '询问并回答经常从事的周末活动', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '1', '1', '15', '0');
INSERT INTO `xxj_video` VALUES ('2028', '询问并回答某人能否做某事', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '0', '0', '14', '0');
INSERT INTO `xxj_video` VALUES ('2029', '询问并回答某处是否有某物', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '0', '0', '15', '0');
INSERT INTO `xxj_video` VALUES ('2030', '询问并回答某物是否属于某人', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('2031', '询问并回答某人是否正在做某事', '', '41687', '41692', '41730', '41945', '2', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2032', '询问并回答某人的性格或外貌特征', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('2033', '询问并回答某天的课程、周末安排', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2034', '询问、征求并表达用餐意愿', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2035', '询问并回答最喜欢的食物或饮品', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2036', '询问并回答某人能做某事', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2037', '询问并回答某时做某事', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2038', '询问并回答对季节的喜好', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2039', '询问并回答喜欢某个季节的理由', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2040', '询问并回答某节日、生日日期', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('2041', '询问并回答某物属于某人', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2042', '询问并回答正在做某事', '', '41687', '41692', '41730', '41946', '2', '65', '2017-01-06 17:05:24', '1', '1', '13', '0');
INSERT INTO `xxj_video` VALUES ('2043', '一般现在时构成及用法', '', '41687', '41692', '41730', '41947', '2', '68', '2017-01-06 17:05:24', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('2044', '现在进行时构成及用法', '', '41687', '41692', '41730', '41947', '2', '68', '2017-01-06 17:05:24', '1', '1', '17', '0');
INSERT INTO `xxj_video` VALUES ('2045', '对话理解类试题', '', '41687', '41692', '41730', '41948', '2', '101', '2017-01-06 17:05:24', '0', '0', '23', '0');
INSERT INTO `xxj_video` VALUES ('2046', '根据短文内容填空/回答问题', '', '41687', '41692', '41730', '41949', '2', '101', '2017-01-06 17:05:24', '1', '1', '26', '0');
INSERT INTO `xxj_video` VALUES ('2047', '记事作文', '', '41687', '41692', '41730', '41950', '2', '102', '2017-01-06 17:05:24', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('2048', '句子连读', '', '41687', '41693', '41734', '41984', '1', '65', '2017-01-06 17:05:24', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('2049', '单词及句子重音', '', '41687', '41693', '41734', '41984', '1', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2050', '名词（短语）', '', '41687', '41693', '41734', '41985', '1', '65', '2017-01-06 17:05:24', '1', '1', '23', '0');
INSERT INTO `xxj_video` VALUES ('2051', '介词（短语）', '', '41687', '41693', '41734', '41985', '1', '65', '2017-01-06 17:05:24', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2052', '动词（短语）', '', '41687', '41693', '41734', '41985', '1', '65', '2017-01-06 17:05:24', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2053', '形容词与副词', '', '41687', '41693', '41734', '41985', '1', '65', '2017-01-06 17:05:24', '0', '0', '16', '0');
INSERT INTO `xxj_video` VALUES ('2054', '谈论交通规则', '', '41687', '41693', '41734', '41986', '1', '65', '2017-01-06 17:05:24', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('2055', '安慰他人和提供建议', '', '41687', '41693', '41734', '41986', '1', '65', '2017-01-06 17:05:24', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('2056', '体貌特征的对比', '', '41687', '41693', '41734', '41986', '1', '65', '2017-01-06 17:05:24', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('2057', '谈论或描述某个地方、某人的今昔', '', '41687', '41693', '41734', '41986', '1', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2058', '询问并回答某物的方位、某人的工作', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2059', '询问并回答如何到达某地', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '1', '1', '8', '0');
INSERT INTO `xxj_video` VALUES ('2060', '询问并回答某人的出行方式', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '1', '1', '12', '0');
INSERT INTO `xxj_video` VALUES ('2061', '询问并回答活动内容、时间和地点', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '1', '1', '10', '0');
INSERT INTO `xxj_video` VALUES ('2062', '询问和描述某人的喜好', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '1', '1', '14', '0');
INSERT INTO `xxj_video` VALUES ('2063', '询问并回答某人的职业', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('2064', '询问他人的情绪和心理状态', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '11', '0');
INSERT INTO `xxj_video` VALUES ('2065', '询问并回答某人、某物的体貌特征', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('2066', '询问过去做过某事', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('2067', '询问并回答对方周末过得怎么样', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '9', '0');
INSERT INTO `xxj_video` VALUES ('2068', '询问他人在过去的时间里去了哪里', '', '41687', '41693', '41734', '41987', '2', '65', '2017-01-06 17:05:24', '0', '0', '13', '0');
INSERT INTO `xxj_video` VALUES ('2069', '一般将来时构成及用法', '', '41687', '41693', '41734', '41988', '2', '115', '2017-01-06 17:05:24', '1', '1', '11', '0');
INSERT INTO `xxj_video` VALUES ('2070', '一般过去时构成及用法', '', '41687', '41693', '41734', '41988', '2', '115', '2017-01-06 17:05:24', '0', '0', '12', '0');
INSERT INTO `xxj_video` VALUES ('2071', '短文理解类试题', '', '41687', '41693', '41734', '41989', '2', '115', '2017-01-06 17:05:24', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('2072', '完形填空', '', '41687', '41693', '41734', '41990', '2', '115', '2017-01-06 17:05:24', '1', '1', '16', '0');
INSERT INTO `xxj_video` VALUES ('2073', '应用类作文', '', '41687', '41693', '41734', '41991', '2', '115', '2017-01-06 17:05:24', '1', '1', '7', '0');
INSERT INTO `xxj_video` VALUES ('2074', '英语语调', '', '41687', '41693', '41734', '41984', '1', '65', '2017-01-06 17:05:24', '0', '0', '10', '0');
INSERT INTO `xxj_video` VALUES ('2075', '酶', '', '39780', '39784', '39840', '40121', '0', '25', '2017-01-06 17:05:24', '0', '0', '6', '0');

-- ----------------------------
-- Table structure for `xxj_video_list`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_video_list`;
CREATE TABLE `xxj_video_list` (
  `video_id` int(11) NOT NULL COMMENT '视频ID',
  `platformId` int(11) NOT NULL COMMENT '平台ID',
  `video_url` varchar(255) NOT NULL COMMENT '视频地址',
  PRIMARY KEY (`video_id`,`platformId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频地址列表';

-- ----------------------------
-- Records of xxj_video_list
-- ----------------------------
INSERT INTO `xxj_video_list` VALUES ('10', '3', 'www.baidu.com');
INSERT INTO `xxj_video_list` VALUES ('360', '1', 'www.baidu.com');
INSERT INTO `xxj_video_list` VALUES ('360', '3', 'www.baidu.com');

-- ----------------------------
-- Table structure for `xxj_xued`
-- ----------------------------
DROP TABLE IF EXISTS `xxj_xued`;
CREATE TABLE `xxj_xued` (
  `xued_id` int(11) NOT NULL COMMENT '学段ID',
  `xued_name` varchar(50) DEFAULT NULL COMMENT '学段名称',
  PRIMARY KEY (`xued_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学段';

-- ----------------------------
-- Records of xxj_xued
-- ----------------------------
INSERT INTO `xxj_xued` VALUES ('39779', '初中');
INSERT INTO `xxj_xued` VALUES ('39780', '高中');
INSERT INTO `xxj_xued` VALUES ('41687', '小学');
