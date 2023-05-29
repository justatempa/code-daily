/*
 Navicat Premium Data Transfer

 Source Server         : 10.8.2.14
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : 10.8.2.14:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 29/05/2023 14:09:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `bio` blob NULL,
  `favourite_section` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (101, 'jim', '********', 'jim@ibatis.apache.org', '', 'NEWS');
INSERT INTO `author` VALUES (102, 'sally', '********', 'sally@ibatis.apache.org', NULL, 'VIDEOS');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, 101, 'Jim Business');
INSERT INTO `blog` VALUES (2, 102, 'Bally Slog');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `name` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `comment` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 'troll', 'I disagree and think...');
INSERT INTO `comment` VALUES (2, 1, 'anonymous', 'I agree and think troll is an...');

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`  (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(11) NOT NULL,
  `blog_id` int(11) NULL DEFAULT NULL,
  `author_id` int(11) NOT NULL,
  `created_on` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `section` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `body` blob NOT NULL,
  `draft` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `blog_id`(`blog_id`) USING BTREE,
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 1, 101, '2007-12-05 00:00:00', 'NEWS', 'Corn nuts', 0x49207468696E6B2069662049206E6576657220736D656C6C656420616E6F7468657220636F726E206E757420697420776F756C6420626520746F6F20736F6F6E2E2E2E, 1);
INSERT INTO `post` VALUES (2, 1, 101, '2008-01-12 00:00:00', 'VIDEOS', 'Paul Hogan on Toy Dogs', 0x546861742773206E6F74206120646F672E2020544841542773206120646F6721, 0);
INSERT INTO `post` VALUES (3, 2, 102, '2007-12-05 00:00:00', 'PODCASTS', 'Monster Trucks', 0x49207468696E6B206D6F6E7374657220747275636B73206172652067726561742E2E2E, 1);
INSERT INTO `post` VALUES (4, 2, 102, '2008-01-12 00:00:00', 'IMAGES', 'Tea Parties', 0x4120746561207061727479206973206E6F20706C61636520746F20686F6C64206120627573696E657373206D656574696E672E2E2E, 0);
INSERT INTO `post` VALUES (5, NULL, 101, '2008-01-12 00:00:00', 'IMAGES', 'An orphaned post', 0x7468697320706F7374206973206F727068616E6564, 0);

-- ----------------------------
-- Table structure for post_tag
-- ----------------------------
DROP TABLE IF EXISTS `post_tag`;
CREATE TABLE `post_tag`  (
  `post_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_tag
-- ----------------------------
INSERT INTO `post_tag` VALUES (1, 1);
INSERT INTO `post_tag` VALUES (1, 2);
INSERT INTO `post_tag` VALUES (1, 3);
INSERT INTO `post_tag` VALUES (2, 1);
INSERT INTO `post_tag` VALUES (4, 3);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'funny');
INSERT INTO `tag` VALUES (2, 'cool');
INSERT INTO `tag` VALUES (3, 'food');

SET FOREIGN_KEY_CHECKS = 1;
