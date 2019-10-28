bplist00�_WebMainResource�	
^WebResourceURL_WebResourceFrameName_WebResourceData_WebResourceMIMEType_WebResourceTextEncodingName_Vhttp://lms.myclass.vn/pluginfile.php/8824/mod_resource/content/0/booking-ticket-db.sqlPO9b<html><head></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_boot_ticket
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cinemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cineplex_id` int(11) DEFAULT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk3l52tk4mhlovm6c7xoaep0x2` (`cineplex_id`),
  CONSTRAINT `FKk3l52tk4mhlovm6c7xoaep0x2` FOREIGN KEY (`cineplex_id`) REFERENCES `cineplex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,1,'Đây là một trong những cụm rạp được đầu tư quy mô nhất hiện nay tại Việt Nam, với tổng diện tích hơn 2.000 m2, bao gồm 7 phòng chiếu được trang bị theo tiêu chuẩn quốc tế. Âm thanh đạt chuẩn Dolby 7.1 với hệ thống cách âm hiện đại, trong đó có 4 phòng 3D,  cùng hơn 1.000 ghế ngồi được thiết kế theo kiểu dáng đẹp mắt và tiện dụng để mang lại sự thoải mái nhất cho khán giả.','/upload/bhd-star-bitexco.jpg','BHD Star Bitexco','L3-Bitexco Icon 68, 2 Hải Triều, Q.1','028 62 670 670'),(2,1,'Cụm rạp mới BHD Star Mega Mall Thảo Điền toạ lạc tại lầu 5 của TTTM Vincom. Với tầm vóc thương mại và thương hiệu có tiếng của các TTTM Vincom cũng như quy mô đầu tư chất lượng quốc tế của tập đoàn BHD, thì rõ ràng đây lại là một sự kết hợp tuyệt vời nữa giữa giải trí và mua sắm, thiên đường cho các gia đình và các bạn trẻ hội tụ.','/upload/bhd-star-vincom-thao-dien.jpg','BHD Star Vincom Thảo Điền','L5-Megamall, 159 XL Hà Nội, Q.2','028 3744 6969'),(3,1,'Cụm rạp BHD Star Quang Trung toạ lạc tại tầng B1, TTTM Vincom Quang Trung, 190 Quang Trung, P.10, Gò Vấp là sự kết hợp tuyệt vời giữa mô hình TTTM và giải trí. Tại đây khán giả có thể vừa thoả sức mua sắm với hệ thống siêu thị Vinmart, các gian hàng hoá/ mỹ phẩm, khu thời trang cao cấp, ẩm thực thuộc TTTM Vincom; vừa có thể tận hưởng không gian giải trí mang đậm phong cách Việt Nam nhưng lại hiện đại không kém so với quốc tế.','/upload/bhd-star-vincom-quang-trung.jpg','BHD Star Vincom Quang Trung','B1-Vincom QT, 190 Quang Trung, Gò Vấp','028 39892468'),(4,2,'Galaxy Nguyễn Du gồm 5 phòng chiếu với hơn 1000 chỗ ngồi được thiết kế tinh tế giúp khách hàng có thể xem phim một cách thoải mái và thuận tiện. Chất lượng hình ảnh rõ nét, màn hình chiếu kỹ thuật 3D và Digital vô cùng sắc mịn, mang đến một không gian giải trí vô cùng sống động.','/upload/galaxy-nguyen-du.jpg','Galaxy Nguyễn Du','116 Nguyễn Du, Q.1','(028) 3823 5235'),(5,2,'Galaxy Quang Trung nằm trọn lầu 3 của khu phức hợp với diện tích gần 2.500m2, có 7 phòng chiếu với 1.200 chỗ ngồi. Toàn bộ cụm rạp sử dụng các thiết bị và công nghệ tân tiến nhất trên thế giới hiện nay như công nghệ âm thanh Dolby 7.1, công nghệ hình ảnh Digital, chiếu cả phim 2D và 3D.','/upload/galaxy-quang-trung.jpg','Galaxy Quang Trung','L3-Co.opmart Foodcosa, 304A Quang Trung, Gò Vấp','(028)35.897.899'),(6,2,'Với diện tích hơn 3000 m2 gồm 5 phòng chiếu , Galaxy Tân Bình được đánh giá như một thế giới Hollywood thu nhỏ của TP.HCM. Cùng sự hỗ trợ tư vấn thiết kế và lắp đặt bởi các chuyên gia của Tập đoàn Warner Bros đến từ Hollywood, các phòng chiếu 2D và 3D với màn hình chiếu sắc nét và dàn âm thanh Dolby 7.1 bậc nhất tại Việt Nam.','/upload/galaxy-tan-binh.jpg','Galaxy Tân Bình','246 Nguyễn Hồng Đào, Tân Bình','(028) 3849 4567'),(7,2,'Với quy mô 7 phòng chiếu được thiết kế theo đúng chuẩn quốc tế, ghế ngồi được các nhà thiết kế rạp đầy kinh nghiệm thiết kế với khoảng cách rộng rãi, có độ nhún tạo cảm giác thư giãn như ở nhà. Điều đặc biệt mà Galaxy Cinema đem đến cho khán giả là tất cả các phòng chiếu đều được trang bị những thiết bị hiện đại nhất hiện nay: âm thanh Dolby 7.1, màn hình chiếu kỹ thuật 3D và Digital vô cùng mịn, sắc nét đến từng phút giây.','/upload/galaxy-kinh-duong-vuong.jpg','Galaxy Kinh Dương Vương','718bis Kinh Dương Vương, Q.6','(028) 3817 2398');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cineplex`
--

DROP TABLE IF EXISTS `cineplex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cineplex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cineplex`
--

LOCK TABLES `cineplex` WRITE;
/*!40000 ALTER TABLE `cineplex` DISABLE KEYS */;
INSERT INTO `cineplex` VALUES (1,'/upload/bhd-logo.png','BHD Star'),(2,'/upload/galaxy-logo.png','Galaxy'),(3,'/upload/cgv-logo.png','CGV'),(4,'/upload/lotte-logo.png','Lotte Cinema');
/*!40000 ALTER TABLE `cineplex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open_date` date DEFAULT NULL,
  `ratting` int(11) NOT NULL,
  `trailer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('5711db39-6ddf-4c68-b256-ebf6cd27efb5','Quản trị hệ thống','ROLE_ADMIN'),('6e9f28ae-4bab-4bab-9a63-39d49cdafca2','Học viên','ROLE_STUDENT'),('ee2dd09f-03f1-4c5f-803b-ed330b64920f','Giảng viên','ROLE_TEACHER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `seat_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjp9bjtvlojbw581bpq23cpw4j` (`cinema_id`),
  CONSTRAINT `FKjp9bjtvlojbw581bpq23cpw4j` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_categories`
--

DROP TABLE IF EXISTS `seat_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seat_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_categories`
--

LOCK TABLES `seat_categories` WRITE;
/*!40000 ALTER TABLE `seat_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt2vntgxetuck30viepwcjk4gh` (`category_id`),
  KEY `FKg993pi7ucgy616icmddq8u335` (`room_id`),
  CONSTRAINT `FKg993pi7ucgy616icmddq8u335` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`),
  CONSTRAINT `FKt2vntgxetuck30viepwcjk4gh` FOREIGN KEY (`category_id`) REFERENCES `seat_categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtimes`
--

DROP TABLE IF EXISTS `showtimes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `showtimes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) DEFAULT NULL,
  `movie_time` int(11) DEFAULT NULL,
  `open_date` date DEFAULT NULL,
  `open_hours` time DEFAULT NULL,
  `price` float NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeltpyuei1d5g3n6ikpsjwwil6` (`movie_id`),
  KEY `FKrumrrbei9jppryk4teoyoetit` (`room_id`),
  CONSTRAINT `FKeltpyuei1d5g3n6ikpsjwwil6` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FKrumrrbei9jppryk4teoyoetit` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtimes`
--

LOCK TABLES `showtimes` WRITE;
/*!40000 ALTER TABLE `showtimes` DISABLE KEYS */;
/*!40000 ALTER TABLE `showtimes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `booking_date` date DEFAULT NULL,
  `seat_id` int(11) DEFAULT NULL,
  `showtime_id` int(11) DEFAULT NULL,
  `total` float NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1f6n3pv4b80wl6gj4ra32ctxk` (`seat_id`),
  KEY `FKo0u22315eoxdv59tn6wsdn8b1` (`showtime_id`),
  KEY `FK4eqsebpimnjen0q46ja6fl2hl` (`user_id`),
  CONSTRAINT `FK1f6n3pv4b80wl6gj4ra32ctxk` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`),
  CONSTRAINT `FK4eqsebpimnjen0q46ja6fl2hl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKo0u22315eoxdv59tn6wsdn8b1` FOREIGN KEY (`showtime_id`) REFERENCES `showtimes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `facebook` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('848e6645-65c2-43b3-b0b9-1b4a04146314','','/upload/1520805_639142046204871_1551292379302375531_n.jpg','admin@gmail.com',NULL,'Administrator','$2a$12$/mR4FAF1pga7OdU1CVE7NuZYQkhYmrWqd6jsggR.Wlm2NQdJfFJCG','','5711db39-6ddf-4c68-b256-ebf6cd27efb5',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-13 15:37:59
</pre></body></html>Ztext/plainUUTF-8    ( 7 N ` v � � �:T:_                           :e