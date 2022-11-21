/*
Navicat MySQL Data Transfer

Source Server         : zhao
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : heima-estate

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-11-17 19:44:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_activity`
-- ----------------------------
DROP TABLE IF EXISTS `tb_activity`;
CREATE TABLE `tb_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `title` varchar(100) DEFAULT NULL COMMENT '活动标题',
  `address` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `organizer` varchar(100) DEFAULT NULL COMMENT '举办单位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动截止时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-活动未开始（默认），1-活动进行中，2-活动已结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

-- ----------------------------
-- Records of tb_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_building`
-- ----------------------------
DROP TABLE IF EXISTS `tb_building`;
CREATE TABLE `tb_building` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '楼栋ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `name` varchar(50) DEFAULT NULL COMMENT '栋数名称',
  `total_households` int(11) DEFAULT NULL COMMENT '总户数',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='楼栋表';

-- ----------------------------
-- Records of tb_building
-- ----------------------------
INSERT INTO `tb_building` VALUES ('1', '汤臣一品', null, '01', '200', '36666', '2022-11-05 20:27:33', '2022-11-05 20:27:33');

-- ----------------------------
-- Table structure for `tb_charge_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tb_charge_detail`;
CREATE TABLE `tb_charge_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费明细ID',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `charge_item_id` int(11) DEFAULT NULL COMMENT '收费项目ID',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `contractor` varchar(50) DEFAULT NULL COMMENT '承办人名称',
  `telephone` int(20) DEFAULT NULL COMMENT '承办人联系电话',
  `pay_money` int(11) DEFAULT NULL COMMENT '应收金额(￥)，单位分',
  `actual_money` int(11) DEFAULT NULL COMMENT '实收金额(￥)，单位分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '缴费时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-生效中（默认），1-已过期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收费名细表';

-- ----------------------------
-- Records of tb_charge_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_charge_item`
-- ----------------------------
DROP TABLE IF EXISTS `tb_charge_item`;
CREATE TABLE `tb_charge_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收费项目ID',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `code` varchar(20) DEFAULT NULL COMMENT '收费编号',
  `name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `money` int(11) DEFAULT NULL COMMENT '项目收费金额（年），单位分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收费项目表';

-- ----------------------------
-- Records of tb_charge_item
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_coach`
-- ----------------------------
DROP TABLE IF EXISTS `tb_coach`;
CREATE TABLE `tb_coach` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '教练编号',
  `coach_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '教练姓名',
  `coach_telephone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '教练联系方式',
  `coach_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '教练住址',
  `coach_sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `coach_id_card` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '教练身份证号码',
  `coach_description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '教练描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_coach
-- ----------------------------
INSERT INTO `tb_coach` VALUES ('1', '李小龙', '17745682589', '香港路122号', '男', '私人教练', '421301199202245689', '国际巨星', '2022-11-07 21:27:45');
INSERT INTO `tb_coach` VALUES ('2', '杰森.斯坦森', '0722-48345', '帝国大厦6008', '男', '私人教练', '421302125975126526', '国际巨星', '2022-11-07 21:42:41');
INSERT INTO `tb_coach` VALUES ('3', '刘飞', '18971794523', '东宝区象山二路22号', '男', '普通教练', '421301199102234569', '人很热情，还在学习成长的路上!', '2022-11-08 08:26:27');
INSERT INTO `tb_coach` VALUES ('4', '刘耕宏', '15678541236', '上海浦东区虾仁路112号', '男', '私人教练', '421000198805234589', '百万粉丝网红教练', '2022-11-04 11:00:19');
INSERT INTO `tb_coach` VALUES ('6', '张俊辉', '17785263214', '掇刀区万达广场附近', '男', '普通教练', '421301199006216548', '心中有光，继续向前', '2022-11-05 11:00:28');
INSERT INTO `tb_coach` VALUES ('7', '胡博文', '17896321568', '掇刀区星球路23号', '男', '高级教练', '421201199802124569', '健身界的黑马，省赛亚军', '2022-11-08 15:13:52');
INSERT INTO `tb_coach` VALUES ('8', '周楠楠', '17852634896', '东宝区长宁大道12号', '女', '高级教练', '421103199901235826', '女子健身市赛冠军', '2022-10-20 15:13:54');
INSERT INTO `tb_coach` VALUES ('9', '余飞', '15748752654', '龙泉公园附近', '男', '瑜伽教练', '421506199502215684', '获有减脂专家称号!', '2022-11-01 15:13:56');
INSERT INTO `tb_coach` VALUES ('10', '孟云', '15874526548', '紫禁城小区三单元201', '男', '高级教练', '421301199506254125', '职业高级健美选手', '2022-11-08 15:15:45');
INSERT INTO `tb_coach` VALUES ('11', '张欣悦', '18745682154', '长宁大道188号', '女', '私人教练', '421101199804238564', '95后美女教练!', '2022-11-09 11:48:56');
INSERT INTO `tb_coach` VALUES ('12', '刘易斯', '19871397878', '汉东路15号', '男', '私人教练', '421021199208214578', '职业健美运动员退役', '2022-11-15 08:42:57');

-- ----------------------------
-- Table structure for `tb_community`
-- ----------------------------
DROP TABLE IF EXISTS `tb_community`;
CREATE TABLE `tb_community` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小区id',
  `code` varchar(20) NOT NULL COMMENT '小区编号',
  `name` varchar(50) NOT NULL COMMENT '小区名称',
  `address` varchar(200) DEFAULT NULL COMMENT '坐落地址',
  `area` double DEFAULT NULL COMMENT '占地面积（m2）',
  `total_buildings` int(11) DEFAULT NULL COMMENT '总栋数',
  `total_households` int(11) DEFAULT NULL COMMENT '总户数',
  `greening_rate` int(11) DEFAULT NULL COMMENT '绿化率（%）',
  `thumbnail` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `developer` varchar(100) DEFAULT NULL COMMENT '开发商名称',
  `estate_company` varchar(100) DEFAULT NULL COMMENT '物业公司名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='小区表';

-- ----------------------------
-- Records of tb_community
-- ----------------------------
INSERT INTO `tb_community` VALUES ('1', 'HX19960101001', '化纤小区', '历城区花园路5号', '22000', '66', '2432', '30', '/fileupload/d2cea885-a986-463a-97da-7073c9e6fbf6.jpg', '济南齐鲁化纤集团有限责任公司', '上海新长宁集团新华物业有限公司', '2020-12-13 09:12:04', '2020-12-13 09:26:12', '0');
INSERT INTO `tb_community` VALUES ('2', 'DH19960101002', '东风小区', '历城区花园路6号', '33000', '50', '2222', '40', '/images/dongfeng.jpg', '济南齐鲁化纤集团有限责任公司', '上海新长宁集团新华物业有限公司', '2020-12-13 09:24:42', '2020-12-13 09:26:14', '0');
INSERT INTO `tb_community` VALUES ('3', 'BH19960101003', '百花小区', '历城区花园路7号', '44444', '88', '3000', '50', '/fileupload/e6daae7d-17f6-4053-9e44-81cf5a4c5d82.jpg', '济南齐鲁化纤集团有限责任公司', '上海新长宁集团新华物业有限公司', '2020-12-13 09:24:42', '2020-12-13 09:24:42', '0');
INSERT INTO `tb_community` VALUES ('28', 'JYHF20160101001', '金域华府', '齐鲁软件园', '66666', '66', '2195', '35', '/fileupload/ec760e4a-1e1e-479a-9d5d-8c8671069a58.jpg', '万达地产集团', '万科物业', '2020-12-14 19:29:48', null, '0');
INSERT INTO `tb_community` VALUES ('29', 'B001231522000', '汤臣一品', '上海浦东', '1500000', '6', '1500', '1230', '', '万达集团', '黑马', null, null, '0');

-- ----------------------------
-- Table structure for `tb_counter`
-- ----------------------------
DROP TABLE IF EXISTS `tb_counter`;
CREATE TABLE `tb_counter` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `counter_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '前台人员姓名',
  `counter_sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `counter_telephone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '前台电话号码',
  `counter_address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭地址',
  `counter_id_card` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `counter_remark` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_counter
-- ----------------------------
INSERT INTO `tb_counter` VALUES ('1', '谭雯雯', '女', '17789895665', '东宝区象山二路16号', '421103200008235689', '普通员工', '2022-11-08 12:31:57');
INSERT INTO `tb_counter` VALUES ('2', '周星宇', '女', '17745698752', '长宁大道53号', '421302200011048652', '普通员工', '2022-11-05 12:51:27');
INSERT INTO `tb_counter` VALUES ('3', '蔡倩纹', '女', '15678564856', '长宁大道99号', '421301199805236546', '前台班长', '2022-11-08 13:05:21');
INSERT INTO `tb_counter` VALUES ('4', '周子康', '男', '17789896545', '紫禁城六单元204', '421301199607278965', '临时工', '2022-11-09 11:51:01');

-- ----------------------------
-- Table structure for `tb_course`
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '课程名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开课时间',
  `teacher_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '教练名称',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结课时间',
  `course_span` int(10) DEFAULT NULL COMMENT '课时数目',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
  `course_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上课地点',
  `course_capacity` int(10) NOT NULL DEFAULT '30' COMMENT '课程人数容量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES ('1', '减脂操(入门版)', '2022-11-12 16:54:52', '杨艳', '2022-12-15 16:54:37', '24', '0', 'F区2号体操室', '35');
INSERT INTO `tb_course` VALUES ('2', '动感单车(减脂课)', '2022-11-14 00:00:00', '鲁强', '2022-12-14 00:00:00', '20', '0', 'F区1号单车厅', '30');
INSERT INTO `tb_course` VALUES ('3', '健身操(基础)', '2022-11-16 00:00:00', '李强', '2022-12-19 00:00:00', '20', null, 'F区2号瑜伽室', '32');
INSERT INTO `tb_course` VALUES ('4', '有氧操(基础版)', '2022-11-18 00:00:00', '刘易斯', '2022-12-18 00:00:00', '30', null, 'F区1号体操室', '32');

-- ----------------------------
-- Table structure for `tb_crew`
-- ----------------------------
DROP TABLE IF EXISTS `tb_crew`;
CREATE TABLE `tb_crew` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `crew_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '后勤人员姓名',
  `crew_sex` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '后勤人员性别',
  `crew_telephone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '后勤人员联系方式',
  `crew_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '后勤人员地址',
  `crew_id_card` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `crew_remark` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_crew
-- ----------------------------
INSERT INTO `tb_crew` VALUES ('1', '张秀丽', '女', '19871798564', '银泰城附近', '421506198806218564', 'B区保洁员', '2022-11-08 14:15:11');
INSERT INTO `tb_crew` VALUES ('2', '周水凤', '女', '17745698752', '长宁大道53号', '421204198004235689', 'A区保洁员', '2022-11-08 14:29:26');
INSERT INTO `tb_crew` VALUES ('3', '梁明红', '男', '17654238965', '紫禁城小区一单元602', '421402199001214875', '器材保养员', '2022-11-08 14:41:28');
INSERT INTO `tb_crew` VALUES ('4', '张俊辉', '男', '15974125489', '紫禁城四单元401', '421023199505124589', '配菜师傅', '2022-11-09 11:52:26');
INSERT INTO `tb_crew` VALUES ('5', '王秀丽', '女', '17895467852', '紫禁城四单元201', '421204197910214587', 'C区保洁员', '2022-11-15 08:48:38');

-- ----------------------------
-- Table structure for `tb_device`
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `code` varchar(20) DEFAULT NULL COMMENT '设备编号',
  `name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `brand` varchar(40) DEFAULT NULL COMMENT '设备品牌',
  `unit_price` int(11) DEFAULT NULL COMMENT '购买单价(￥)，单位分',
  `num` int(11) DEFAULT NULL COMMENT '购买数量',
  `expected_useful_life` int(11) DEFAULT NULL COMMENT '预计使用年限(年)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `purchase_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '购买日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- ----------------------------
-- Records of tb_device
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_equipment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_equipment`;
CREATE TABLE `tb_equipment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `equipment_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '器械名称',
  `manufacturer` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '制造商',
  `model` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '器械型号',
  `price` double(16,2) DEFAULT NULL COMMENT '器械价格',
  `status` varchar(200) COLLATE utf8_bin DEFAULT '正常使用' COMMENT '器械状态',
  `des` varchar(240) COLLATE utf8_bin DEFAULT '这个家伙很懒，什么都没留下...' COMMENT '器械介绍',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '购置时间',
  `area` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '存放区域',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_equipment
-- ----------------------------
INSERT INTO `tb_equipment` VALUES ('1', '龙门架', '山东建材有限公司', 'LG1000', '23520.20', '正常使用', '这个家伙很懒，什么都没留下...', '2022-11-07 09:35:47', 'A区', '6');
INSERT INTO `tb_equipment` VALUES ('2', '史密斯卧推架', '中国健身器械有限公司', 'KL800', '18888.60', '运输中', '练胸肌的', '2022-11-07 09:35:52', 'C区', '3');
INSERT INTO `tb_equipment` VALUES ('3', '哑铃', '山东建材有限公司', '10KG', '682.00', '正常使用', '锻造手臂力量', '2022-11-07 14:16:53', 'D区', '10');
INSERT INTO `tb_equipment` VALUES ('4', '杠铃', '福建器械制造厂', '100KG', '1260.00', '正常使用', '卧推必备，深蹲', '2022-11-07 12:26:52', 'D区', '4');
INSERT INTO `tb_equipment` VALUES ('5', '椭圆仪', '武汉健身器械制造公司', 'TY1006', '3288.00', '维修中', '减脂必备，脂肪杀手', '2022-11-09 11:55:05', 'E区', '3');

-- ----------------------------
-- Table structure for `tb_estate_manager`
-- ----------------------------
DROP TABLE IF EXISTS `tb_estate_manager`;
CREATE TABLE `tb_estate_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物业管理人员ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登录名:登录时使用的名称',
  `name` varchar(50) DEFAULT NULL COMMENT '真实名称',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `telephone` int(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID：0-普通用户（默认0），1-管理员用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='物业管理人员表';

-- ----------------------------
-- Records of tb_estate_manager
-- ----------------------------
INSERT INTO `tb_estate_manager` VALUES ('1', '化纤小区', '1', '15900000000', '张三', '123456', '2147483647', '123@163.com', '0', '2020-12-14 10:17:49', '2020-12-14 10:17:49');
INSERT INTO `tb_estate_manager` VALUES ('2', '百花小区', '3', '15911111111', '李四', '123456', '2147483647', '456@163.com', '0', '2020-12-14 10:17:55', '2020-12-14 10:17:55');
INSERT INTO `tb_estate_manager` VALUES ('3', '东风小区', '2', '15922222222', '王五', '123456', '2147483647', '789@163.com', '0', '2020-12-14 10:18:03', '2020-12-14 10:18:03');

-- ----------------------------
-- Table structure for `tb_house`
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `building_name` varchar(50) DEFAULT NULL COMMENT '所属栋数名称',
  `building_id` int(11) DEFAULT NULL COMMENT '所属栋数ID',
  `code` varchar(50) DEFAULT NULL COMMENT '房产编码',
  `name` varchar(100) DEFAULT NULL COMMENT '房产名称',
  `owner_id` int(11) DEFAULT NULL COMMENT '户主（业主）ID',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '户主（业主）名称',
  `telephone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `room_num` int(11) DEFAULT NULL COMMENT '房间数',
  `unit` int(2) DEFAULT NULL COMMENT '单元',
  `floor` int(3) DEFAULT NULL COMMENT '楼层',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `live_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入住时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='房屋表';

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('3', '汤臣一品', null, null, '6', null, 'A1001', null, '吕布', '423125632', '666', '6', '6', null, '2022-11-03 00:00:00');
INSERT INTO `tb_house` VALUES ('7', '汤臣一品', null, null, null, null, null, null, '赵德汉', '1397179', '61803', '6', '18', null, '2022-11-06 00:00:00');
INSERT INTO `tb_house` VALUES ('8', '王府井', null, null, null, null, null, null, '高育良', '13971794183', '10602', '1', '6', null, '2022-06-21 00:00:00');
INSERT INTO `tb_house` VALUES ('9', '铜锣湾', null, null, null, null, null, null, '丁义珍', '15671254852', '30201', '3', '2', null, '2022-11-06 00:00:00');
INSERT INTO `tb_house` VALUES ('10', '汤臣一品', null, null, null, null, null, null, '侯亮平', '15174259874', '20601', '2', '6', null, '2022-11-06 14:40:06');

-- ----------------------------
-- Table structure for `tb_letter`
-- ----------------------------
DROP TABLE IF EXISTS `tb_letter`;
CREATE TABLE `tb_letter` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信件ID',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `owner_id` int(11) DEFAULT NULL COMMENT '信件发送者（业主）ID',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '信件发送者（业主）名称',
  `origin` char(1) DEFAULT '0' COMMENT '信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc',
  `title` varchar(100) DEFAULT NULL COMMENT '信件标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '信箱内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-未读（默认），1-已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信件表';

-- ----------------------------
-- Records of tb_letter
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_member`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '会员姓名',
  `member_sex` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '会员性别',
  `member_id_card` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '会员身份证号码',
  `member_telephone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '会员电话号码',
  `member_address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '会员居住地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `member_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '会员类型',
  `end_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '到期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('1', '李小康', '男', '421302199908247542', '15574125489', '洪山路89号', '2022-11-09 12:17:22', '季卡会员', '2023-01-09 12:17:27');
INSERT INTO `tb_member` VALUES ('2', '严昊', '男', '421201200004218563', '15671284562', '辖区路21号', '2022-11-09 13:06:19', '月卡会员', '2022-12-09 14:40:47');
INSERT INTO `tb_member` VALUES ('3', '李子轩', '男', '421201199805221456', '17745698745', '洪山路56号', '2022-11-09 14:39:07', '周卡会员', '2022-11-16 15:15:19');
INSERT INTO `tb_member` VALUES ('4', '曹文轩', '男', '421201200010215689', '17985462145', '幸福路21号', '2022-11-09 15:06:03', '年卡会员', '2023-11-09 15:15:28');
INSERT INTO `tb_member` VALUES ('5', '刘少聪', '男', '421203199808241546', '14789654123', '洪山路99号', '2022-11-09 15:12:00', '月卡会员', '2022-12-09 15:15:38');
INSERT INTO `tb_member` VALUES ('6', '张文硕', '男', '421204200010234587', '17789654523', '虾仁路77号', '2022-11-09 15:17:15', '月卡会员', '2022-12-09 15:17:15');
INSERT INTO `tb_member` VALUES ('7', '王紫玉', '女', '421204200004258796', '17785641478', '虾仁路89号', '2022-11-15 08:15:51', '季卡会员', null);

-- ----------------------------
-- Table structure for `tb_parking`
-- ----------------------------
DROP TABLE IF EXISTS `tb_parking`;
CREATE TABLE `tb_parking` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车位ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `picture` varchar(100) DEFAULT NULL COMMENT '车位图片',
  `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
  `name` varchar(50) DEFAULT NULL COMMENT '车位名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位表';

-- ----------------------------
-- Records of tb_parking
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_parking_use`
-- ----------------------------
DROP TABLE IF EXISTS `tb_parking_use`;
CREATE TABLE `tb_parking_use` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车位使用ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int(11) DEFAULT NULL COMMENT '所属小区ID',
  `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
  `car_number` varchar(20) DEFAULT NULL COMMENT '车牌号码',
  `picture` varchar(100) DEFAULT NULL COMMENT '车辆牌照（照片）',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '车辆所有人（业主）名称',
  `owner_id` int(11) DEFAULT NULL COMMENT '车辆所有人（业主）ID',
  `telephone` int(20) DEFAULT NULL COMMENT '联系方式',
  `use_type` char(1) DEFAULT '0' COMMENT '使用性质：0-购买(默认)，1-月租，2-年租',
  `total_fee` int(11) DEFAULT NULL COMMENT '总费用(￥)，以分为单位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车位使用表';

-- ----------------------------
-- Records of tb_parking_use
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_repair`
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair`;
CREATE TABLE `tb_repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修ID',
  `name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `reason` varchar(100) DEFAULT NULL COMMENT '维修原因',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-待受理，1-已受理，2-修理完毕',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上报时间',
  `place` varchar(100) DEFAULT NULL COMMENT '设备存放位置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='维修表';

-- ----------------------------
-- Records of tb_repair
-- ----------------------------
INSERT INTO `tb_repair` VALUES ('1', '龙门架1号', '左侧绳索断了', '0', '2022-11-14 15:58:19', 'A区');
INSERT INTO `tb_repair` VALUES ('2', '史密斯卧推架1号', '固定器松动', '0', '2022-11-14 16:12:03', 'C区');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '管理员名字',
  `password` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '管理员密码',
  `rule` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '角色',
  `telephone` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入时间',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '超级管理员', '13971785263', '2022-11-07 14:53:00', '0');
INSERT INTO `tb_user` VALUES ('2', 'zhaoxin', 'zx20001204', '老板', '15671254952', '2022-11-07 14:53:11', '0');
INSERT INTO `tb_user` VALUES ('5', 'superAdmin', '123456', '总经理', '15785264896', '2022-11-07 18:47:27', '0');
INSERT INTO `tb_user` VALUES ('6', 'spider', '123456', '保安', '18874125985', '2022-11-16 16:26:23', '0');
INSERT INTO `tb_user` VALUES ('8', '袁绍', '123456', '诸侯', '17798785421', '2022-11-16 16:41:38', '0');

-- ----------------------------
-- Table structure for `tb_vip`
-- ----------------------------
DROP TABLE IF EXISTS `tb_vip`;
CREATE TABLE `tb_vip` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vip_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '会员姓名',
  `vip_sex` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `vip_id_card` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `vip_telephone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `vip_address` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '会员地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开卡时间',
  `vip_type` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '会员类型',
  `vip_left` int(10) DEFAULT NULL COMMENT '剩余课时数（次）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_vip
-- ----------------------------
INSERT INTO `tb_vip` VALUES ('1', '张世豪', '男', '421201200602145689', '18974562547', '中天街51号', '2022-11-12 11:05:07', '跆拳道(基础班)', '32');
INSERT INTO `tb_vip` VALUES ('2', '李正名', '男', '421302200010245989', '18952462548', '白云大道49', '2022-11-12 12:03:06', '拳击基础班', '48');
INSERT INTO `tb_vip` VALUES ('3', '夏竹', '女', '412501200405147852', '17785641254', '白云大道23号', '2022-11-12 12:29:38', '瑜伽(基础班)', '48');
INSERT INTO `tb_vip` VALUES ('4', '吕塞', '女', '421102199905214875', '19871254785', '凤凰路89号', '2022-11-15 08:20:34', '跳绳(基础班)', '42');
