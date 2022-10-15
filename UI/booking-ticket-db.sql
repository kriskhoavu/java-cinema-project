-- Host: localhost    Database: spring_boot_ticket
-- ------------------------------------------------------
SET NAMES UTF8;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `CINEMAS`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `CINEMAS` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CINEPLEX_ID` INT(11) DEFAULT NULL,
  `DESCRIPTION` TEXT,
  `IMAGE` VARCHAR(255) DEFAULT NULL,
  `NAME` VARCHAR(255) DEFAULT NULL,
  `ADDRESS` VARCHAR(255) DEFAULT NULL,
  `PHONE` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKK3L52TK4MHLOVM6C7XOAEP0X2` (`CINEPLEX_ID`),
  CONSTRAINT `FKK3L52TK4MHLOVM6C7XOAEP0X2` FOREIGN KEY (`CINEPLEX_ID`) REFERENCES `CINEPLEX` (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `CINEMAS` WRITE;

INSERT INTO `CINEMAS` VALUES (
  1,
  1,
  'Đây là một trong những cụm rạp được đầu tư quy mô nhất hiện nay tại Việt Nam, với tổng diện tích hơn 2.000 m2, bao gồm 7 phòng chiếu được trang bị theo tiêu chuẩn quốc tế. Âm thanh đạt chuẩn Dolby 7.1 với hệ thống cách âm hiện đại, trong đó có 4 phòng 3D,  cùng hơn 1.000 ghế ngồi được thiết kế theo kiểu dáng đẹp mắt và tiện dụng để mang lại sự thoải mái nhất cho khán giả.',
  '/upload/bhd-star-bitexco.jpg',
  'BHD Star Bitexco',
  'L3-Bitexco Icon 68, 2 Hải Triều, Q.1',
  '028 62 670 670'
),
(
  2,
  1,
  'Cụm rạp mới BHD Star Mega Mall Thảo Điền toạ lạc tại lầu 5 của TTTM Vincom. Với tầm vóc thương mại và thương hiệu có tiếng của các TTTM Vincom cũng như quy mô đầu tư chất lượng quốc tế của tập đoàn BHD, thì rõ ràng đây lại là một sự kết hợp tuyệt vời nữa giữa giải trí và mua sắm, thiên đường cho các gia đình và các bạn trẻ hội tụ.',
  '/upload/bhd-star-vincom-thao-dien.jpg',
  'BHD Star Vincom Thảo Điền',
  'L5-Megamall, 159 XL Hà Nội, Q.2',
  '028 3744 6969'
),
(
  3,
  1,
  'Cụm rạp BHD Star Quang Trung toạ lạc tại tầng B1, TTTM Vincom Quang Trung, 190 Quang Trung, P.10, Gò Vấp là sự kết hợp tuyệt vời giữa mô hình TTTM và giải trí. Tại đây khán giả có thể vừa thoả sức mua sắm với hệ thống siêu thị Vinmart, các gian hàng hoá/ mỹ phẩm, khu thời trang cao cấp, ẩm thực thuộc TTTM Vincom; vừa có thể tận hưởng không gian giải trí mang đậm phong cách Việt Nam nhưng lại hiện đại không kém so với quốc tế.',
  '/upload/bhd-star-vincom-quang-trung.jpg',
  'BHD Star Vincom Quang Trung',
  'B1-Vincom QT, 190 Quang Trung, Gò Vấp',
  '028 39892468'
),
(
  4,
  2,
  'Galaxy Nguyễn Du gồm 5 phòng chiếu với hơn 1000 chỗ ngồi được thiết kế tinh tế giúp khách hàng có thể xem phim một cách thoải mái và thuận tiện. Chất lượng hình ảnh rõ nét, màn hình chiếu kỹ thuật 3D và Digital vô cùng sắc mịn, mang đến một không gian giải trí vô cùng sống động.',
  '/upload/galaxy-nguyen-du.jpg',
  'Galaxy Nguyễn Du',
  '116 Nguyễn Du, Q.1',
  '(028) 3823 5235'
),
(
  5,
  2,
  'Galaxy Quang Trung nằm trọn lầu 3 của khu phức hợp với diện tích gần 2.500m2, có 7 phòng chiếu với 1.200 chỗ ngồi. Toàn bộ cụm rạp sử dụng các thiết bị và công nghệ tân tiến nhất trên thế giới hiện nay như công nghệ âm thanh Dolby 7.1, công nghệ hình ảnh Digital, chiếu cả phim 2D và 3D.',
  '/upload/galaxy-quang-trung.jpg',
  'Galaxy Quang Trung',
  'L3-Co.opmart Foodcosa, 304A Quang Trung, Gò Vấp',
  '(028)35.897.899'
),
(
  6,
  2,
  'Với diện tích hơn 3000 m2 gồm 5 phòng chiếu , Galaxy Tân Bình được đánh giá như một thế giới Hollywood thu nhỏ của TP.HCM. Cùng sự hỗ trợ tư vấn thiết kế và lắp đặt bởi các chuyên gia của Tập đoàn Warner Bros đến từ Hollywood, các phòng chiếu 2D và 3D với màn hình chiếu sắc nét và dàn âm thanh Dolby 7.1 bậc nhất tại Việt Nam.',
  '/upload/galaxy-tan-binh.jpg',
  'Galaxy Tân Bình',
  '246 Nguyễn Hồng Đào, Tân Bình',
  '(028) 3849 4567'
),
(
  7,
  2,
  'Với quy mô 7 phòng chiếu được thiết kế theo đúng chuẩn quốc tế, ghế ngồi được các nhà thiết kế rạp đầy kinh nghiệm thiết kế với khoảng cách rộng rãi, có độ nhún tạo cảm giác thư giãn như ở nhà. Điều đặc biệt mà Galaxy Cinema đem đến cho khán giả là tất cả các phòng chiếu đều được trang bị những thiết bị hiện đại nhất hiện nay: âm thanh Dolby 7.1, màn hình chiếu kỹ thuật 3D và Digital vô cùng mịn, sắc nét đến từng phút giây.',
  '/upload/galaxy-kinh-duong-vuong.jpg',
  'Galaxy Kinh Dương Vương',
  '718bis Kinh Dương Vương, Q.6',
  '(028) 3817 2398'
);

UNLOCK TABLES;

--
-- Table structure for table `cineplex`
--

DROP TABLE IF EXISTS `CINEPLEX`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `CINEPLEX` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `LOGO` VARCHAR(255) DEFAULT NULL,
  `NAME` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `cineplex`
--

LOCK TABLES `CINEPLEX` WRITE;

INSERT INTO `CINEPLEX` VALUES (
  1,
  '/upload/bhd-logo.png',
  'BHD Star'
),
(
  2,
  '/upload/galaxy-logo.png',
  'Galaxy'
),
(
  3,
  '/upload/cgv-logo.png',
  'CGV'
),
(
  4,
  '/upload/lotte-logo.png',
  'Lotte Cinema'
);

UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `MOVIES`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `MOVIES` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` TEXT,
  `IMAGE` VARCHAR(255) DEFAULT NULL,
  `NAME` VARCHAR(255) DEFAULT NULL,
  `OPEN_DATE` DATE DEFAULT NULL,
  `RATTING` INT(11) NOT NULL,
  `TRAILER` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `ROLES`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `ROLES` (
  `ID` VARCHAR(255) NOT NULL,
  `DESCRIPTION` VARCHAR(255) DEFAULT NULL,
  `NAME` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `roles`
--

LOCK TABLES `ROLES` WRITE;

/*!40000 ALTER TABLE `roles` DISABLE KEYS */;

INSERT INTO `ROLES` VALUES (
  '5711db39-6ddf-4c68-b256-ebf6cd27efb5',
  'Quản trị hệ thống',
  'ROLE_ADMIN'
),
(
  '6e9f28ae-4bab-4bab-9a63-39d49cdafca2',
  'Học viên',
  'ROLE_STUDENT'
),
(
  'ee2dd09f-03f1-4c5f-803b-ed330b64920f',
  'Giảng viên',
  'ROLE_TEACHER'
);

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `ROOMS`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `ROOMS` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CINEMA_ID` INT(11) DEFAULT NULL,
  `NAME` VARCHAR(50) DEFAULT NULL,
  `SEAT_COUNT` INT(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKJP9BJTVLOJBW581BPQ23CPW4J` (`CINEMA_ID`),
  CONSTRAINT `FKJP9BJTVLOJBW581BPQ23CPW4J` FOREIGN KEY (`CINEMA_ID`) REFERENCES `CINEMAS` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `ROOMS` WRITE;

/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;

/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;

UNLOCK TABLES;

--
-- Table structure for table `seat_categories`
--

DROP TABLE IF EXISTS `SEAT_CATEGORIES`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `SEAT_CATEGORIES` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `seat_categories`
--

LOCK TABLES `SEAT_CATEGORIES` WRITE;

/*!40000 ALTER TABLE `seat_categories` DISABLE KEYS */;

/*!40000 ALTER TABLE `seat_categories` ENABLE KEYS */;

UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `SEATS`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `SEATS` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` INT(11) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(255) DEFAULT NULL,
  `NAME` VARCHAR(255) DEFAULT NULL,
  `ROOM_ID` INT(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKT2VNTGXETUCK30VIEPWCJK4GH` (`CATEGORY_ID`),
  KEY `FKG993PI7UCGY616ICMDDQ8U335` (`ROOM_ID`),
  CONSTRAINT `FKG993PI7UCGY616ICMDDQ8U335` FOREIGN KEY (`ROOM_ID`) REFERENCES `ROOMS` (`ID`),
  CONSTRAINT `FKT2VNTGXETUCK30VIEPWCJK4GH` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `SEAT_CATEGORIES` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Table structure for table `showtimes`
--

DROP TABLE IF EXISTS `SHOWTIMES`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `SHOWTIMES` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `MOVIE_ID` INT(11) DEFAULT NULL,
  `MOVIE_TIME` INT(11) DEFAULT NULL,
  `OPEN_DATE` DATE DEFAULT NULL,
  `OPEN_HOURS` TIME DEFAULT NULL,
  `PRICE` FLOAT NOT NULL,
  `ROOM_ID` INT(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKELTPYUEI1D5G3N6IKPSJWWIL6` (`MOVIE_ID`),
  KEY `FKRUMRRBEI9JPPRYK4TEOYOETIT` (`ROOM_ID`),
  CONSTRAINT `FKELTPYUEI1D5G3N6IKPSJWWIL6` FOREIGN KEY (`MOVIE_ID`) REFERENCES `MOVIES` (`ID`),
  CONSTRAINT `FKRUMRRBEI9JPPRYK4TEOYOETIT` FOREIGN KEY (`ROOM_ID`) REFERENCES `ROOMS` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `TICKETS`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `TICKETS` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `BOOKING_DATE` DATE DEFAULT NULL,
  `SEAT_ID` INT(11) DEFAULT NULL,
  `SHOWTIME_ID` INT(11) DEFAULT NULL,
  `TOTAL` FLOAT NOT NULL,
  `USER_ID` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK1F6N3PV4B80WL6GJ4RA32CTXK` (`SEAT_ID`),
  KEY `FKO0U22315EOXDV59TN6WSDN8B1` (`SHOWTIME_ID`),
  KEY `FK4EQSEBPIMNJEN0Q46JA6FL2HL` (`USER_ID`),
  CONSTRAINT `FK1F6N3PV4B80WL6GJ4RA32CTXK` FOREIGN KEY (`SEAT_ID`) REFERENCES `SEATS` (`ID`),
  CONSTRAINT `FK4EQSEBPIMNJEN0Q46JA6FL2HL` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`ID`),
  CONSTRAINT `FKO0U22315EOXDV59TN6WSDN8B1` FOREIGN KEY (`SHOWTIME_ID`) REFERENCES `SHOWTIMES` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `USERS`;

SET CHARACTER_SET_CLIENT = UTF8MB4;

CREATE TABLE `USERS` (
  `ID` VARCHAR(255) NOT NULL,
  `ADDRESS` VARCHAR(255) DEFAULT NULL,
  `AVATAR` VARCHAR(255) DEFAULT NULL,
  `EMAIL` VARCHAR(255) DEFAULT NULL,
  `FACEBOOK` VARCHAR(255) DEFAULT NULL,
  `FULLNAME` VARCHAR(255) DEFAULT NULL,
  `PASSWORD` VARCHAR(255) DEFAULT NULL,
  `PHONE` VARCHAR(255) DEFAULT NULL,
  `ROLE_ID` VARCHAR(255) DEFAULT NULL,
  `WEBSITE` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKP56C1712K691LHSYEWCSSF40F` (`ROLE_ID`),
  CONSTRAINT `FKP56C1712K691LHSYEWCSSF40F` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

/;

--
-- Dumping data for table `users`
--

LOCK TABLES `USERS` WRITE;

INSERT INTO `USERS` VALUES (
  '848e6645-65c2-43b3-b0b9-1b4a04146314',
  '',
  '/upload/1520805_639142046204871_1551292379302375531_n.jpg',
  'admin@gmail.com',
  NULL,
  'Administrator',
  '$2a$12$/mR4FAF1pga7OdU1CVE7NuZYQkhYmrWqd6jsggR.Wlm2NQdJfFJCG',
  '',
  '5711db39-6ddf-4c68-b256-ebf6cd27efb5',
  NULL
);

UNLOCK TABLES;