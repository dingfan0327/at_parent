/*
 Navicat Premium Data Transfer

 Source Server         : seata
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : seata_02

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 21/03/2022 14:44:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_acct_balance
-- ----------------------------
DROP TABLE IF EXISTS `t_acct_balance`;
CREATE TABLE `t_acct_balance` (
  `id` bigint NOT NULL COMMENT '账户主键',
  `acct_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '账户号',
  `amt` decimal(17,2) DEFAULT NULL COMMENT '账户余额额',
  `frozen_amt` decimal(17,2) DEFAULT NULL COMMENT '冻结金额',
  `client_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_acct_balance
-- ----------------------------
BEGIN;
INSERT INTO `t_acct_balance` VALUES (2, '6100010000100001', 100.00, 0.00, '100001', '2022-03-17 15:10:45');
COMMIT;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_id` bigint NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
