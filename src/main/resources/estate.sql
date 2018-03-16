/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : estate

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-03-16 18:37:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for billaccount
-- ----------------------------
DROP TABLE IF EXISTS `billaccount`;
CREATE TABLE `billaccount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `housing_id` int(11) DEFAULT NULL COMMENT '对应小区id',
  `roominfo_id` int(11) DEFAULT NULL COMMENT '对应房间id',
  `cost_type` int(11) DEFAULT NULL COMMENT '费用类型名称',
  `bill_entry_amount` double(11,2) DEFAULT NULL COMMENT '应收金额',
  `acct_period` varchar(255) DEFAULT NULL COMMENT '账期，用于归类和向用户展示',
  `release_day` varchar(255) DEFAULT NULL COMMENT '出账日期20160831',
  `deadline` varchar(255) DEFAULT NULL COMMENT '缴费截止日期20160831',
  `relate_id` varchar(255) DEFAULT NULL COMMENT '缴费明细条目关联ID。若物业系统业务约束上传的多条明细条目必须被一次同时支付，则对应的明细条目需传入同样的relate_id。',
  `status` tinyint(1) DEFAULT '0' COMMENT '0:未同步 1：已同步',
  `payDate` datetime DEFAULT NULL COMMENT '付款时间',
  `payType` int(11) DEFAULT NULL COMMENT '微信 支付宝 现金 刷卡 银行转账',
  `payStatus` tinyint(1) DEFAULT '0' COMMENT '付款状态 0：未付款  1：已付款',
  `deleteStatus` tinyint(1) DEFAULT '0',
  `alipay_trade_no` varchar(255) DEFAULT NULL COMMENT '支付宝付款成功回传编号',
  `weixin_trade_no` varchar(255) DEFAULT NULL COMMENT '微信付款成功回传编号',
  `printStatus` tinyint(1) DEFAULT '0' COMMENT '打印状态',
  `ticketStatus` int(11) DEFAULT '0' COMMENT '开票状态0未开票，1已开票，2退票',
  `invoiceSerialNum` varchar(255) DEFAULT NULL COMMENT '发票流水号',
  `invoiceCode` varchar(255) DEFAULT NULL COMMENT '发票代码',
  `invoiceNum` varchar(255) DEFAULT NULL COMMENT '发票号码',
  `buyer_user_id` varchar(255) DEFAULT NULL COMMENT '付款人支付宝id',
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171681 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for costtype
-- ----------------------------
DROP TABLE IF EXISTS `costtype`;
CREATE TABLE `costtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `taxRate` double(11,2) DEFAULT NULL COMMENT '税率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for directfee
-- ----------------------------
DROP TABLE IF EXISTS `directfee`;
CREATE TABLE `directfee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee` double(11,2) DEFAULT NULL COMMENT '金额',
  `costtypeid` int(11) DEFAULT NULL COMMENT '费用类型',
  `phone` varchar(255) DEFAULT NULL,
  `projectid` varchar(255) DEFAULT NULL COMMENT '项目类型',
  `fee_unit` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式',
  `code` varchar(255) DEFAULT NULL COMMENT '关联users的parent_code',
  `ticketStatus` int(1) DEFAULT '0' COMMENT '开票状态：0未开票，1已开票，2退票',
  `invoiceSerialNum` varchar(255) DEFAULT NULL COMMENT '发票流水号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for housinginfo
-- ----------------------------
DROP TABLE IF EXISTS `housinginfo`;
CREATE TABLE `housinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `community_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '支付宝小区统一编号',
  `code` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL COMMENT '上级物业id',
  `district_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '区县编码',
  `city_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '地级市编码',
  `province_code` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '省份编码',
  `community_locations` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '小区所在的经纬度列表',
  `associated_pois` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '小区对应的高德POI兴趣点列表',
  `hotline` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '服务热线电话',
  `message_num` int(11) DEFAULT NULL COMMENT '短信条数',
  `status` int(11) DEFAULT NULL COMMENT '1未同步2已同步3已初始化\r\n4已上线',
  `deleteStatus` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `water_unit` double(11,2) DEFAULT NULL COMMENT '水费单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10088 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon_Cls` varchar(255) DEFAULT NULL COMMENT '图标',
  `parent_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `enable` tinyint(4) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=702 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='权限表';

-- ----------------------------
-- Table structure for printinfo
-- ----------------------------
DROP TABLE IF EXISTS `printinfo`;
CREATE TABLE `printinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `machine_code` varchar(255) DEFAULT NULL COMMENT '打印机终端号',
  `msign` varchar(255) DEFAULT NULL COMMENT '打印机密钥',
  `mobile_phone` varchar(255) DEFAULT NULL,
  `print_name` varchar(255) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0小区，1物业',
  `deleteStatus` tinyint(1) DEFAULT '0' COMMENT '0,禁用；1，激活',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for propertyinfo
-- ----------------------------
DROP TABLE IF EXISTS `propertyinfo`;
CREATE TABLE `propertyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `contact_people` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `contact_address` varchar(255) DEFAULT NULL,
  `salerTaxNum` varchar(255) DEFAULT NULL COMMENT '税号',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级物业id',
  `alipay_login_id` varchar(255) DEFAULT NULL COMMENT '商户账号',
  `app_id` varchar(255) DEFAULT NULL COMMENT '商户PID',
  `token` varchar(255) DEFAULT NULL COMMENT '授权TOKEN',
  `alipay_debit_num` varchar(255) DEFAULT NULL COMMENT '支付宝代扣协议编号',
  `weixin_debit_num` varchar(255) DEFAULT NULL COMMENT '微信代扣协议编号',
  `weixin_children_num` varchar(255) DEFAULT NULL COMMENT '微信子商户',
  `api` varchar(255) DEFAULT NULL COMMENT 'API',
  `create_time` datetime DEFAULT NULL,
  `nuonuo_appkey` varchar(255) DEFAULT NULL COMMENT '用户申请的appkey',
  `nuonuo_accessToken` varchar(255) DEFAULT NULL COMMENT '用户Oauth登录后得到的令牌access token',
  `nuonuo_secret` varchar(255) DEFAULT NULL COMMENT 'APP Secre',
  `salerAccount` varchar(255) DEFAULT NULL COMMENT '销方银行账号和开户行地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2051 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `role_sign` varchar(255) DEFAULT NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '1代表服务商，2代表物业，3代表小区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色与权限关联表';

-- ----------------------------
-- Table structure for roominfo
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `room_id` varchar(255) DEFAULT NULL COMMENT '支付宝房屋编号',
  `group_name` varchar(255) DEFAULT NULL COMMENT '房屋所在的组团名称。例如“一期”，“东区”，“香桂苑”等',
  `building` varchar(255) DEFAULT NULL COMMENT '房屋所在楼栋名称。例如“1栋”，“1幢”等',
  `unit` varchar(255) DEFAULT NULL COMMENT '房屋所在单元名称',
  `room` varchar(255) DEFAULT NULL COMMENT '房屋所在房号。例如“1101室”，“11B室”等',
  `address` varchar(255) DEFAULT NULL COMMENT '房间的完整门牌地址，例如一期1栋2单元2202室',
  `owner_name` varchar(255) DEFAULT NULL COMMENT '业主姓名',
  `owner_card` varchar(255) DEFAULT NULL COMMENT '业主身份证',
  `owner_phone` varchar(255) DEFAULT NULL COMMENT '业主电话',
  `entryDate` varchar(255) DEFAULT NULL COMMENT '入住时间',
  `deleteStatus` tinyint(1) DEFAULT '0',
  `status` tinyint(1) DEFAULT '0' COMMENT 'false没有同步，true同步',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127832 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for serviceinfo
-- ----------------------------
DROP TABLE IF EXISTS `serviceinfo`;
CREATE TABLE `serviceinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL COMMENT '区域',
  `contact_people` varchar(255) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `contact_address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级服务商id',
  `app_id` varchar(255) DEFAULT NULL COMMENT '应用ID,您的APPID',
  `merchant_private_key` varchar(2555) DEFAULT NULL COMMENT '商户私钥',
  `alipay_public_key` varchar(2555) DEFAULT NULL COMMENT '支付宝公钥',
  `return_url` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `opt_content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端ip',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=422 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billaccount_id` int(11) DEFAULT NULL,
  `title_name` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `type` int(11) DEFAULT NULL COMMENT '发票类型0单位，1个人',
  `register_no` varchar(255) DEFAULT NULL COMMENT '税号',
  `amount` double(11,0) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `parent_id` int(11) DEFAULT NULL COMMENT '部门id',
  `parent_code` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `type` int(11) DEFAULT NULL COMMENT '1代表服务商，2代表物业，3代表小区',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for watermeter
-- ----------------------------
DROP TABLE IF EXISTS `watermeter`;
CREATE TABLE `watermeter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `housing_id` int(11) DEFAULT NULL,
  `roominfo_id` int(11) DEFAULT NULL,
  `water_num` double(11,2) DEFAULT NULL COMMENT '本期实数',
  `use_num` double(11,2) DEFAULT NULL COMMENT '本期用量',
  `user_id` int(11) DEFAULT NULL COMMENT '抄表员',
  `amount` double(11,2) DEFAULT NULL COMMENT '本期金额',
  `create_time` datetime DEFAULT NULL,
  `old_water_num` double(11,2) DEFAULT NULL,
  `old_use_num` double(11,2) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL COMMENT '0:未上传 1：已上传',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12807 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for weixinconfig
-- ----------------------------
DROP TABLE IF EXISTS `weixinconfig`;
CREATE TABLE `weixinconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appId` varchar(255) DEFAULT NULL COMMENT '公众号appId',
  `appSecret` varchar(255) DEFAULT NULL COMMENT '微信appSecret',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for weixinuser
-- ----------------------------
DROP TABLE IF EXISTS `weixinuser`;
CREATE TABLE `weixinuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL COMMENT '微信openid',
  `roominfoid` int(11) DEFAULT NULL COMMENT '房间id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='微信openid与业主的绑定关系';
