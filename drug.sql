/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 04/05/2019 10:35:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `charge_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退单id',
  `solder_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '销售人员姓名',
  `charge_time` timestamp NULL DEFAULT NULL COMMENT '退单时间',
  `charge_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '退单原因',
  `charge_number` int(11) NULL DEFAULT NULL COMMENT '退单编号',
  PRIMARY KEY (`charge_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES (1, '销售员1', '2018-11-17 00:00:00', '疗效不好', 1000001);
INSERT INTO `charge` VALUES (2, '销售员2', '2018-11-17 00:00:00', '不好用', 1000002);

-- ----------------------------
-- Table structure for income_man
-- ----------------------------
DROP TABLE IF EXISTS `income_man`;
CREATE TABLE `income_man`  (
  `in_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收入id',
  `in_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '药品名称',
  `in_number` int(11) NULL DEFAULT NULL COMMENT '数量',
  `in_ordernum` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `in_pay` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付方式',
  `in_card` int(255) NULL DEFAULT NULL COMMENT '会员卡号',
  `in_cashier` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '收银员姓名',
  `in_createTime` timestamp NULL DEFAULT NULL COMMENT '收入时间',
  PRIMARY KEY (`in_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of income_man
-- ----------------------------
INSERT INTO `income_man` VALUES (1, '皮炎平', 1, 10001, '微信', 10010, '收银员1', '2018-11-18 16:41:07');
INSERT INTO `income_man` VALUES (2, '金嗓子', 3, 10011, '支付宝', 10011, '收银员2', '2018-11-18 00:00:00');
INSERT INTO `income_man` VALUES (3, '三九胃泰', 10, 1003, '银行卡', 1003, '收银员2', '2019-05-21 00:00:00');

-- ----------------------------
-- Table structure for into_man
-- ----------------------------
DROP TABLE IF EXISTS `into_man`;
CREATE TABLE `into_man`  (
  `into_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '进货id',
  `into_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '药品名称',
  `into_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '药品种类',
  `into_number` int(11) NULL DEFAULT NULL COMMENT '药品数量',
  `into_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '进货单价',
  `into_createTime` timestamp NULL DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`into_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of into_man
-- ----------------------------
INSERT INTO `into_man` VALUES (1, '皮炎平', '处方药', 100, 10, '2018-11-18 16:01:31');
INSERT INTO `into_man` VALUES (4, '32323', '非处方药', 2, 20, '2018-11-24 00:00:00');
INSERT INTO `into_man` VALUES (5, '三九胃泰', '处方药', 2, 10, '2019-04-28 00:00:00');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `m_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `med_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '药品名',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '价格',
  `med_num` int(11) NULL DEFAULT NULL COMMENT '药品编号',
  `prouduct_date` timestamp NULL DEFAULT NULL COMMENT '生产日期',
  `save_date` timestamp NULL DEFAULT NULL COMMENT '保质期',
  `producter` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '生产商',
  `prouduct_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '生产地区',
  `phone` bigint(255) NULL DEFAULT NULL COMMENT '电话号码',
  `careat_time` timestamp NULL DEFAULT NULL COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (1, '皮炎平', 10, 10010, '2018-11-17 00:00:00', '2018-11-17 00:00:00', '皮炎平', '北京', 13255556666, '2018-11-17 21:08:10', '2019-04-20 18:43:15');
INSERT INTO `medicine` VALUES (2, '金嗓子', 20, 10011, '2018-11-17 05:00:00', '2018-11-17 00:00:00', '金嗓子', '石家庄', 13577779999, '2018-11-17 21:08:32', '2018-11-17 21:08:32');
INSERT INTO `medicine` VALUES (15, '三九胃泰', 45, 10012, '2018-12-04 00:00:00', '2019-06-12 00:00:00', '三九集团', '天津', 13893699969, '2019-05-02 11:01:56', '2019-05-02 11:01:56');
INSERT INTO `medicine` VALUES (16, '999感冒灵', 35, 10013, '2018-05-15 00:00:00', '2020-05-29 00:00:00', '999集团', '北京', 17789655425, '2019-05-02 11:04:28', '2019-05-02 11:04:28');
INSERT INTO `medicine` VALUES (17, '板蓝根颗粒', 18, 10014, '2019-05-02 11:09:05', '2019-05-02 11:09:07', '广州白云山和记黄埔中药有限公司', '广州白云山', 13998795687, '2019-05-02 11:09:09', '2019-05-02 11:10:32');
INSERT INTO `medicine` VALUES (18, '小青龙颗粒', 20, 10015, '2018-11-02 00:00:00', '2019-05-02 11:11:29', '四川泰乐制药有限公司', '四川', 15569451236, '2019-05-02 11:11:47', '2019-05-02 11:11:47');
INSERT INTO `medicine` VALUES (19, '阿司匹林肠溶片', 25, 10016, '2018-04-10 00:00:00', '2019-05-02 11:13:41', '江苏平光制药有限责任公司', '江苏', 18879633695, '2019-05-02 11:14:11', '2019-05-02 11:14:11');
INSERT INTO `medicine` VALUES (20, '藿香正气合剂', 8, 10017, '2018-09-20 00:00:00', '2019-05-02 11:15:38', '江西民济药业有限公司', '江西', 15564235789, '2019-05-02 11:16:03', '2019-05-02 11:16:03');
INSERT INTO `medicine` VALUES (21, '精制银翘解毒片', 15, 10018, '2018-05-31 00:00:00', '2019-05-02 11:19:04', '太极集团四川绵阳制药有限公司', '四川绵阳', 18165422589, '2019-05-02 11:19:14', '2019-05-02 11:19:33');
INSERT INTO `medicine` VALUES (22, '风油精(白云山)', 5, 10019, '2018-05-27 00:00:00', '2019-05-02 11:20:59', '广州白云山制药股份有限公司白云山何济公制药厂', '广州白云山', 15632654897, '2019-05-02 11:21:22', '2019-05-02 11:21:22');
INSERT INTO `medicine` VALUES (23, '皮炎平', 10, 10010, '2019-05-03 16:14:00', '2019-05-03 16:14:00', '工作', NULL, 12222222222, '2019-05-03 16:14:00', '2019-05-03 16:14:00');
INSERT INTO `medicine` VALUES (24, '皮炎平', 10, 10010, '2019-05-03 16:17:02', '2019-05-03 16:17:02', '北京朝阳', '北京', 12222222222, '2019-05-03 16:17:02', '2019-05-03 16:17:02');
INSERT INTO `medicine` VALUES (25, '皮炎平', 11, 10011, '2019-05-03 16:17:03', '2019-05-03 16:17:03', '北京朝阳', '北京', 12222222223, '2019-05-03 16:17:03', '2019-05-03 16:17:03');
INSERT INTO `medicine` VALUES (26, '皮炎平', 12, 10012, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222224, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (27, '皮炎平', 13, 10013, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222225, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (28, '皮炎平', 14, 10014, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222226, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (29, '皮炎平', 15, 10015, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222227, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (30, '皮炎平', 16, 10016, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222228, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (31, '皮炎平', 17, 10017, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222229, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (32, '皮炎平', 18, 10018, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222230, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (33, '皮炎平', 19, 10019, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222231, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (34, '皮炎平', 20, 10020, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222232, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (35, '皮炎平', 21, 10021, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222233, '2019-05-03 16:17:06', '2019-05-03 16:17:06');
INSERT INTO `medicine` VALUES (36, '皮炎平', 22, 10022, '2019-05-03 16:17:06', '2019-05-03 16:17:06', '北京朝阳', '北京', 12222222234, '2019-05-03 16:17:07', '2019-05-03 16:17:07');
INSERT INTO `medicine` VALUES (37, '皮炎平', 23, 10023, '2019-05-03 16:17:07', '2019-05-03 16:17:07', '北京朝阳', '北京', 12222222235, '2019-05-03 16:17:07', '2019-05-03 16:17:07');
INSERT INTO `medicine` VALUES (38, '皮炎平', 24, 10024, '2019-05-03 16:17:07', '2019-05-03 16:17:07', '北京朝阳', '北京', 12222222236, '2019-05-03 16:17:07', '2019-05-03 16:17:07');
INSERT INTO `medicine` VALUES (88, '皮炎平', 10, 10010, '2019-05-03 16:29:57', '2019-05-03 16:29:57', '北京朝阳', '北京', 12222222222, '2019-05-03 16:29:57', '2019-05-03 16:29:57');
INSERT INTO `medicine` VALUES (89, '皮炎平', 11, 10011, '2019-05-03 16:29:57', '2019-05-03 16:29:57', '北京朝阳', '北京', 12222222223, '2019-05-03 16:29:57', '2019-05-03 16:29:57');
INSERT INTO `medicine` VALUES (90, '皮炎平', 12, 10012, '2019-05-03 16:29:57', '2019-05-03 16:29:57', '北京朝阳', '北京', 12222222224, '2019-05-03 16:29:57', '2019-05-03 16:29:57');
INSERT INTO `medicine` VALUES (91, '皮炎平', 10, 10010, '2019-05-03 16:36:12', '2019-05-03 16:36:12', '北京朝阳', '北京', 12222222222, '2019-05-03 16:36:12', '2019-05-03 16:36:12');
INSERT INTO `medicine` VALUES (92, '皮炎平', 11, 10011, '2019-05-03 16:36:12', '2019-05-03 16:36:12', '北京朝阳', '北京', 12222222223, '2019-05-03 16:36:12', '2019-05-03 16:36:12');
INSERT INTO `medicine` VALUES (93, '皮炎平', 12, 10012, '2019-05-03 16:36:12', '2019-05-03 16:36:12', '北京朝阳', '北京', 12222222224, '2019-05-03 16:36:12', '2019-05-03 16:36:12');
INSERT INTO `medicine` VALUES (94, '皮炎平', 10, 10010, '2019-05-03 16:37:21', '2019-05-03 16:37:21', '北京朝阳', '北京', 12222222222, '2019-05-03 16:37:21', '2019-05-03 16:37:21');
INSERT INTO `medicine` VALUES (95, '皮炎平', 11, 10011, '2019-05-03 16:37:21', '2019-05-03 16:37:21', '北京朝阳', '北京', 12222222223, '2019-05-03 16:37:21', '2019-05-03 16:37:21');
INSERT INTO `medicine` VALUES (96, '皮炎平', 12, 10012, '2019-05-03 16:37:21', '2019-05-03 16:37:21', '北京朝阳', '北京', 12222222224, '2019-05-03 16:37:21', '2019-05-03 16:37:21');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员等级id',
  `member_garde` int(255) NULL DEFAULT NULL COMMENT '积分等级',
  `member_lipin` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '礼品',
  `member_lastTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 10, '笔记本', '2018-11-17 00:00:00');
INSERT INTO `member` VALUES (2, 100, '篮球', '2018-11-17 00:00:00');
INSERT INTO `member` VALUES (3, 1, '足球', '2019-04-29 00:00:00');

-- ----------------------------
-- Table structure for provide
-- ----------------------------
DROP TABLE IF EXISTS `provide`;
CREATE TABLE `provide`  (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商主键id',
  `pro_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名称',
  `pro_num` bigint(100) NULL DEFAULT NULL COMMENT '供应商编号',
  `med_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '药品种类',
  `orders` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来往订单',
  PRIMARY KEY (`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of provide
-- ----------------------------
INSERT INTO `provide` VALUES (1, '广州白云山', 20181117211428, '萘甲唑啉 萘啉，苯扎溴铵 溴铵，苯扎氯铵 氯铵，双氯芬酸钠 氯芬，苯妥英钠 妥英', '来往订单1');
INSERT INTO `provide` VALUES (3, '三九集团', 20190421000135, '三九胃泰', '订单2 ');
INSERT INTO `provide` VALUES (7, '999集团天津制药有限公司', 20190502112421, '999感冒灵，清热解毒口服液，小儿感冒灵', '来往订单3');

-- ----------------------------
-- Table structure for salary_man
-- ----------------------------
DROP TABLE IF EXISTS `salary_man`;
CREATE TABLE `salary_man`  (
  `sa_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '薪资id',
  `sa_number` decimal(10, 0) NULL DEFAULT NULL COMMENT '基本工资',
  `sa_overtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '加班情况',
  `sa_chidao` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '迟到',
  `sa_zaotui` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '早退',
  `sa_lastSalary` decimal(10, 0) NULL DEFAULT NULL COMMENT '最后工资',
  `st_id` int(11) NULL DEFAULT NULL COMMENT '员工id',
  PRIMARY KEY (`sa_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary_man
-- ----------------------------
INSERT INTO `salary_man` VALUES (1, 2000, '加班', '是', '是', 1830, 4);
INSERT INTO `salary_man` VALUES (2, 2000, '加班', '是', '否', 1920, 5);
INSERT INTO `salary_man` VALUES (3, 2000, '加班', '是', '否', 2000, 6);

-- ----------------------------
-- Table structure for sold_note
-- ----------------------------
DROP TABLE IF EXISTS `sold_note`;
CREATE TABLE `sold_note`  (
  `sold_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售记录id',
  `solder_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '销售人员姓名',
  `sold_time` datetime NULL DEFAULT NULL COMMENT '销售时间',
  `order_id` bigint(200) NULL DEFAULT NULL COMMENT '订单编号',
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '顾客',
  PRIMARY KEY (`sold_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sold_note
-- ----------------------------
INSERT INTO `sold_note` VALUES (1, '销售员1', '2018-11-17 00:00:00', 20181117211513, '顾客1');
INSERT INTO `sold_note` VALUES (2, '销售员2', '2018-11-17 00:00:00', 20181117211525, '顾客2');
INSERT INTO `sold_note` VALUES (3, '销售员3', '2019-04-08 00:00:00', 20190421002407, '1');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `st_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `st_Grade` int(255) NULL DEFAULT NULL COMMENT '员工等级',
  `st_ordernum` bigint(100) NULL DEFAULT NULL COMMENT '员工编号',
  `st_birth` timestamp NULL DEFAULT NULL COMMENT '出生年月日',
  `st_Age` int(255) NULL DEFAULT NULL COMMENT '员工年龄',
  `st_phone1` bigint(255) NULL DEFAULT NULL COMMENT '手机号码1',
  `st_phone2` bigint(255) NULL DEFAULT NULL COMMENT '手机号码2',
  `st_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '员工姓名',
  `st_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `st_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `st_ids` bigint(255) NULL DEFAULT NULL COMMENT '身份证号码',
  `st_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属部门',
  `st_creattime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `st_updatetime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `sa_id` int(11) NULL DEFAULT NULL COMMENT '薪资ID',
  PRIMARY KEY (`st_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 0, 19780101000000, '1978-01-01 20:45:56', 40, 13566668888, 13588886666, 'boss', 'e10adc3949ba59abbe56e057f20f883e', '男', 111222333444555120, '董事长部', '2018-11-17 20:47:25', '2018-11-19 17:43:02', 0);
INSERT INTO `staff` VALUES (2, 1, 119880101121212, '1988-01-01 20:47:57', 30, 13244445555, 13255554444, 'store', 'e10adc3949ba59abbe56e057f20f883e', '男', 111122223333444560, '店长部', '2018-11-17 20:49:01', '2018-11-19 17:42:30', 0);
INSERT INTO `staff` VALUES (3, 2, 19980101343434, '1998-01-01 20:49:48', 20, 13899998888, 13200007777, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '男', 222222222222222560, '管理员部', '2018-11-17 20:50:56', '2018-11-19 17:23:41', 0);
INSERT INTO `staff` VALUES (4, 3, 20181117205545, '1989-11-17 00:00:00', 29, 13799998888, 13655557777, '药品部员工', '202cb962ac59075b964b07152d234b70', '男', 123456789876543550, '药品部', '2018-11-17 20:55:45', '2019-05-02 15:48:06', 1);
INSERT INTO `staff` VALUES (5, 3, 20181117205737, '1990-11-17 00:00:00', 28, 13699880000, 13177779999, '销售部员工', 'e10adc3949ba59abbe56e057f20f883e', '男', 111100001115555550, '销售部', '2018-11-17 20:57:37', '2018-11-19 17:12:30', 2);
INSERT INTO `staff` VALUES (6, 3, 20181117205832, '1997-11-17 00:00:00', 21, 13477775555, 13844445555, '财务部员工', 'e10adc3949ba59abbe56e057f20f883e', '男', 222222222222222222, '财务部', '2018-11-17 20:58:32', '2018-11-19 16:57:11', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户姓名',
  `member_dengji` int(11) NULL DEFAULT NULL COMMENT '会员等级',
  `birth` timestamp NULL DEFAULT NULL COMMENT '出生年月',
  `user_phone` bigint(255) NULL DEFAULT NULL COMMENT '电话',
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `balance` decimal(10, 0) NULL DEFAULT NULL COMMENT '余额',
  `point` int(255) NULL DEFAULT NULL COMMENT '积分',
  `Records` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消费记录',
  `state` int(255) NULL DEFAULT NULL COMMENT '状态',
  `Recharge` timestamp NULL DEFAULT NULL COMMENT '充值时间',
  `user_money` decimal(10, 0) NULL DEFAULT NULL COMMENT '充值金额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '会员1', 1, '1996-11-17 00:00:00', 13255554444, '黑龙江省哈尔滨市', 200, 200, '无', NULL, '2018-11-17 00:00:00', 200);
INSERT INTO `user` VALUES (2, '会员21', 2, '2004-05-17 00:00:00', 13266667777, '河南省郑州', 10, 10, '无', NULL, '2018-11-17 00:00:00', 10);

SET FOREIGN_KEY_CHECKS = 1;
