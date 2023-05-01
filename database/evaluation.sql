/*
 Navicat Premium Data Transfer

 Source Server         : 4H8G8M
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : 1.12.55.165:3306
 Source Schema         : evaluation

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 01/05/2023 03:40:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_dimension
-- ----------------------------
DROP TABLE IF EXISTS `tb_dimension`;
CREATE TABLE `tb_dimension`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `weight` double NOT NULL COMMENT '权重',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价模块表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_dimension
-- ----------------------------
INSERT INTO `tb_dimension` VALUES (1, '能力域', 0.3);
INSERT INTO `tb_dimension` VALUES (2, '组织引领', 0.3);
INSERT INTO `tb_dimension` VALUES (3, '场景实现', 0.3);
INSERT INTO `tb_dimension` VALUES (4, '其他', 0.1);

-- ----------------------------
-- Table structure for tb_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `tb_enterprise`;
CREATE TABLE `tb_enterprise`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业名称',
  `representative` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '法人代表',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系电话',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业地址',
  `scale` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业规模',
  `Registeredcapital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '注册资本',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '成立日期',
  `user_id` int NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `enterprise_user`(`user_id` ASC) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE,
  CONSTRAINT `enterprise_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '企业表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_enterprise
-- ----------------------------
INSERT INTO `tb_enterprise` VALUES (2, 'XXX公司', '张三', '18246602913', '广西北海市银海区银滩镇南珠大道9号', '500', '20万元', '2023-05-01', 2);

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (1, 'admin');
INSERT INTO `tb_role` VALUES (2, 'user');

-- ----------------------------
-- Table structure for tb_testpoint
-- ----------------------------
DROP TABLE IF EXISTS `tb_testpoint`;
CREATE TABLE `tb_testpoint`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `weight` double NOT NULL COMMENT '权重',
  `firstsuggestion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '低于9分的建议',
  `secondsuggestion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '低于5分的建议',
  `thirdsuggestion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '低于3分的建议',
  `bug` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '漏洞（低于5分）',
  `type_id` int NOT NULL COMMENT '评价类别id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `point_type`(`type_id` ASC) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE,
  CONSTRAINT `point_type` FOREIGN KEY (`type_id`) REFERENCES `tb_testtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价点表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_testpoint
-- ----------------------------
INSERT INTO `tb_testpoint` VALUES (1, '数据管理', 0.33, '应将数据管理与ai相结合，形成数据管理自动化', '增加数据与性能的关注度，建立数据汇集层', '学习运维数据概念，加强数据监控', '对资料的关注度关注度不够', 1);
INSERT INTO `tb_testpoint` VALUES (2, '数据采集', 0.33, '应采用多种方式采集，提高采集效率，同时应用ai采集，减少人工成本', '升级采集方式，用条形码扫码的方式进行数据采集需求', '采用工具进行数据采集', '资料采集手段手段等级较低', 1);
INSERT INTO `tb_testpoint` VALUES (3, '数据共享', 0.33, '升级传递方式，使用oa、ERP等管理系统，可以使用数据库实现数据库共享传输', '利用u盘进行数据传递，提高效率', '实现初步共享', '资料的分享率较低', 1);
INSERT INTO `tb_testpoint` VALUES (4, '网络覆盖', 0.5, '升级管理技术，利用ai信息系统进行数据管理', '向信息管理进阶 采用信息管理工具', '应对网络进行初步管理，实现人工记录', '网络管理意识较弱', 2);
INSERT INTO `tb_testpoint` VALUES (5, '网络安全', 0.5, '增加风险评估频率，实现实时监控', '利用防火墙和防病毒软件进行网络防护', '初步制定网络安全防护制度', '网络安全较低', 2);

-- ----------------------------
-- Table structure for tb_testrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_testrecord`;
CREATE TABLE `tb_testrecord`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `score` double NOT NULL COMMENT '得分',
  `point_id` int NOT NULL COMMENT '评价点id',
  `select_id` int NOT NULL COMMENT '评分细则id',
  `report_id` int NOT NULL COMMENT '评分报告id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `record_point_id`(`point_id` ASC) USING BTREE,
  INDEX `record_select_id`(`select_id` ASC) USING BTREE,
  INDEX `record_report_id`(`report_id` ASC) USING BTREE,
  CONSTRAINT `record_point_id` FOREIGN KEY (`point_id`) REFERENCES `tb_testpoint` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_report_id` FOREIGN KEY (`report_id`) REFERENCES `tb_testreport` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_select_id` FOREIGN KEY (`select_id`) REFERENCES `tb_testselect` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_testrecord
-- ----------------------------

-- ----------------------------
-- Table structure for tb_testreport
-- ----------------------------
DROP TABLE IF EXISTS `tb_testreport`;
CREATE TABLE `tb_testreport`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `finalpoint` double NULL DEFAULT NULL COMMENT '总分',
  `dimensionpoint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '模块分',
  `typepoint` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '单项分',
  `suggestion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '建议',
  `bug` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '漏洞',
  `createtime` datetime NOT NULL COMMENT '开始时间',
  `endtime` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `user_id` int NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '测试报告表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_testreport
-- ----------------------------

-- ----------------------------
-- Table structure for tb_testselect
-- ----------------------------
DROP TABLE IF EXISTS `tb_testselect`;
CREATE TABLE `tb_testselect`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评分细则',
  `score` double NOT NULL COMMENT '分数',
  `point_id` int NOT NULL COMMENT '评价点id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `select_point`(`point_id` ASC) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE,
  CONSTRAINT `select_point` FOREIGN KEY (`point_id`) REFERENCES `tb_testpoint` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价细则表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_testselect
-- ----------------------------
INSERT INTO `tb_testselect` VALUES (1, '无运维数据概念', 1, 1);
INSERT INTO `tb_testselect` VALUES (2, '部分关注监控、日志、性能数据', 3, 1);
INSERT INTO `tb_testselect` VALUES (3, '关注监控、日志、性能数据、开始建立运维数据汇集层', 5, 1);
INSERT INTO `tb_testselect` VALUES (4, '全面关注监控、日志等各类数据构建运维大数据平台、统一采集、存储、分析。评价it基础设施和应用对于业务运营的影响', 7, 1);
INSERT INTO `tb_testselect` VALUES (5, '形成丰富的数据消费场景，提供自动是数据消费服务。将及其又是与运维专家经验相结合，形成运维知识图谱，数据洞察和预测等能力', 9, 1);
INSERT INTO `tb_testselect` VALUES (6, '对数据自主分析，ai自主决策', 10, 1);
INSERT INTO `tb_testselect` VALUES (7, '工厂未对任何业务环节的数据进行采集和分析', 1, 2);
INSERT INTO `tb_testselect` VALUES (8, '工厂通过纸质单据进行人工采集', 3, 2);
INSERT INTO `tb_testselect` VALUES (9, '工厂利用条形码扫码的方式进行数据采集需求', 5, 2);
INSERT INTO `tb_testselect` VALUES (10, '工厂利用RFID等采集方式进行自动采集', 7, 2);
INSERT INTO `tb_testselect` VALUES (11, '工厂利用多种采集方式实现了数据采集', 9, 2);
INSERT INTO `tb_testselect` VALUES (12, '工厂利用ai自动采集', 10, 2);
INSERT INTO `tb_testselect` VALUES (13, '工厂部门内数据没有实现共享', 1, 3);
INSERT INTO `tb_testselect` VALUES (14, '采用纸质文件进行数据共享', 3, 3);
INSERT INTO `tb_testselect` VALUES (15, '利用u盘进行数据传递', 5, 3);
INSERT INTO `tb_testselect` VALUES (16, '以建立共享网盘的方式进行共享传递', 7, 3);
INSERT INTO `tb_testselect` VALUES (17, '利用OA、ERP等管理系统进行数据的共享传递', 9, 3);
INSERT INTO `tb_testselect` VALUES (18, '通过数据库实现数据共享传输', 10, 3);
INSERT INTO `tb_testselect` VALUES (19, '未对网络进行管理', 1, 4);
INSERT INTO `tb_testselect` VALUES (20, '采用人工记录等方式进行管理', 3, 4);
INSERT INTO `tb_testselect` VALUES (21, '以人工记录为主，采用信息管理工具', 5, 4);
INSERT INTO `tb_testselect` VALUES (22, '主要采用信息化手段进行网络管理', 7, 4);
INSERT INTO `tb_testselect` VALUES (23, '通过信息系统开展网络管理', 9, 4);
INSERT INTO `tb_testselect` VALUES (24, '通过ai进行信息系统管理', 10, 4);
INSERT INTO `tb_testselect` VALUES (25, '尚无网络安全防护措施', 1, 5);
INSERT INTO `tb_testselect` VALUES (26, '制定网络安全防护制度', 3, 5);
INSERT INTO `tb_testselect` VALUES (27, '利用防火墙和防病毒软件实现安全网络防护', 5, 5);
INSERT INTO `tb_testselect` VALUES (28, '实现网络安全隔离和授权访问', 7, 5);
INSERT INTO `tb_testselect` VALUES (29, '实现企业内网与互联网的有效隔离，不断进行网络安全风险评估', 9, 5);
INSERT INTO `tb_testselect` VALUES (30, '实时监控网络防火墙，并不断更新安全防护制度', 10, 5);

-- ----------------------------
-- Table structure for tb_testtype
-- ----------------------------
DROP TABLE IF EXISTS `tb_testtype`;
CREATE TABLE `tb_testtype`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `weight` double NOT NULL COMMENT '权重',
  `dimension_id` int NOT NULL COMMENT '维度id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_dimension`(`dimension_id` ASC) USING BTREE,
  UNIQUE INDEX `name_unique`(`name` ASC) USING BTREE,
  CONSTRAINT `type_dimension` FOREIGN KEY (`dimension_id`) REFERENCES `tb_dimension` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评价域表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_testtype
-- ----------------------------
INSERT INTO `tb_testtype` VALUES (1, '数据域', 0.2, 1);
INSERT INTO `tb_testtype` VALUES (2, '网络域', 0.2, 1);
INSERT INTO `tb_testtype` VALUES (3, '生产管理域域', 0.2, 1);
INSERT INTO `tb_testtype` VALUES (4, '物流域', 0.2, 1);
INSERT INTO `tb_testtype` VALUES (5, '信息安全域', 0.2, 1);
INSERT INTO `tb_testtype` VALUES (6, '制度类', 0.33, 2);
INSERT INTO `tb_testtype` VALUES (7, '结构类', 0.33, 2);
INSERT INTO `tb_testtype` VALUES (8, '管理类', 0.33, 2);
INSERT INTO `tb_testtype` VALUES (9, '运维场景分析', 1, 3);
INSERT INTO `tb_testtype` VALUES (10, '服务域', 0.5, 4);
INSERT INTO `tb_testtype` VALUES (11, '恢复类', 0.5, 4);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `headImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_unique`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', 'admin', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (2, 'test111', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (3, 'test222', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (4, 'test333', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (7, 'zhang', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (8, 'zhang3', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');
INSERT INTO `tb_user` VALUES (9, 'liwu', '123456', 'https://cdn.qingk.com/cover/84bc9daf-c245-49dc-9bcf-8f447afbfe84.png');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `role_id`(`role_id` ASC) USING BTREE,
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
