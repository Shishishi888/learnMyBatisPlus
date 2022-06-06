/*
 Navicat Premium Data Transfer

 Source Server         : learnSpringBoot
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : learn_mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 06/06/2022 09:58:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1, 'Jone', 18, 'test1@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (2, 'Jack', 110, 'test2@163.com', NULL, '2022-06-05 20:22:21', NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (3, 'Tom', 28, 'test3@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (4, 'Sandy', 21, 'test4@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (5, 'Billie', 24, 'test5@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1533345748995821570, 'lucy', 30, 'lucy@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1533419756231610369, 'marry', 30, 'mary@163.com', NULL, NULL, NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1533423645521641473, 'Lilei', 120, 'Lilei@163.com', '2022-06-05 20:21:01', '2022-06-05 20:23:17', NULL);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1533626740629377026, 'Shishi', 120, 'Shishi@163.com', '2022-06-06 09:48:03', '2022-06-06 09:55:10', 2);
INSERT INTO `user` (`id`, `name`, `age`, `email`, `create_time`, `update_time`, `version`) VALUES (1533627784620933121, 'Shishi', 24, 'Shishi@163.com', '2022-06-06 09:52:12', '2022-06-06 09:52:12', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
