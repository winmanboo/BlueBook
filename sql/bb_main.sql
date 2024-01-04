-- MySQL dump 10.13  Distrib 8.0.31, for macos13.0 (arm64)
--
-- Host: 127.0.0.1    Database: bb_main
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '类目id',
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '类目名称',
  `create_time` datetime NOT NULL DEFAULT (now()),
  `update_time` datetime NOT NULL DEFAULT (now()),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='类目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (12,'推荐','2023-12-21 16:17:48','2023-12-21 16:17:48'),(13,'穿搭','2023-12-21 16:17:48','2023-12-21 16:17:48'),(14,'美食','2023-12-21 16:17:48','2023-12-21 16:17:48'),(15,'彩妆','2023-12-21 16:17:48','2023-12-21 16:17:48'),(16,'影视','2023-12-21 16:17:48','2023-12-21 16:17:48'),(17,'职场','2023-12-21 16:17:48','2023-12-21 16:17:48'),(18,'情感','2023-12-21 16:17:48','2023-12-21 16:17:48'),(19,'家居','2023-12-21 16:17:48','2023-12-21 16:17:48'),(20,'游戏','2023-12-21 16:17:48','2023-12-21 16:17:48'),(21,'旅行','2023-12-21 16:17:48','2023-12-21 16:17:48'),(22,'健身','2023-12-21 16:17:48','2023-12-21 16:17:48');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `topic_id` bigint unsigned NOT NULL COMMENT '主题 id',
  `content` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `from_uid` bigint unsigned NOT NULL COMMENT '评论用户 id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_topic_id` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` bigint unsigned NOT NULL COMMENT '评论 id',
  `reply_id` bigint unsigned NOT NULL COMMENT '回复目标的 id',
  `reply_type` tinyint NOT NULL COMMENT '回复类型 0：针对评论的回复 1：针对回复的回复',
  `content` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '回复内容',
  `from_uid` bigint unsigned NOT NULL COMMENT '回复用户 id',
  `to_uid` bigint unsigned NOT NULL COMMENT '目标用户 id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_comment_id` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='回复表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `information` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述信息',
  `banners` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片banner以逗号分割,最多 9 张图片',
  `video` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '短视频地址',
  `subject` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '主题',
  `type` tinyint NOT NULL COMMENT '类型 0:图文形式 1:视频形式',
  `create_time` datetime NOT NULL DEFAULT (now()),
  `update_time` datetime NOT NULL DEFAULT (now()),
  `comments_number` int NOT NULL DEFAULT '0' COMMENT '评论数量',
  `likes_number` int NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `collects_number` int NOT NULL DEFAULT '0' COMMENT '收藏数量',
  `post_uid` bigint NOT NULL COMMENT '发布人id',
  `province` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '省份',
  `post_ip` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '发布ip',
  `talk_id` bigint DEFAULT NULL COMMENT '话题id',
  `site` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地点',
  `permission_type` tinyint NOT NULL COMMENT '权限类型 0:公开可见 1:仅自己可见',
  `post_type` tinyint NOT NULL DEFAULT '0' COMMENT '发布类型 0:立即发布 1:定时发布',
  `posted_time` datetime NOT NULL COMMENT '发布时间（如果发布类型是定时发布需要用户手动传递）',
  `top_comment_id` bigint DEFAULT '-1' COMMENT '置顶评论的id,默认为-1表示没有置顶评论',
  `category_id` bigint NOT NULL COMMENT '所属类别id',
  PRIMARY KEY (`id`),
  KEY `idx_category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='帖子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'测试描述信息','测试',NULL,'测试主题',0,'2023-12-21 16:22:02','2023-12-21 16:22:02',0,0,0,1,'浙江','localhost',NULL,NULL,0,0,'2023-12-21 16:21:50',-1,12);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-04 19:12:41
