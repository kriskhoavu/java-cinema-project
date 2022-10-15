INSERT INTO `cineplex`
VALUES (1, '/upload/bhd-logo.png', 'BHD Star'),
       (2, '/upload/galaxy-logo.png', 'Galaxy'),
       (3, '/upload/cgv-logo.png', 'CGV'),
       (4, '/upload/lotte-logo.png', 'Lotte Cinema');
INSERT INTO `movies`
VALUES (1,
        'Hậu chiến Vô Cực, Người Nhện Peter Parker và nhóm bạn thân cùng tham gia chuyến du lịch châu Âu của trường. Tuy nhiên, kế hoạch siêu anh hùng nghỉ phép của Peter nhanh chóng bị hủy bỏ sau khi cậu đồng ý giúp Nick Fury khám phá bí ẩn về những cuộc tấn công của nhóm kẻ thù mang sức mạnh nguyên tố đang tàn phá khắp lục địa.',
        'https://s3img.vcdn.vn/mobile/123phim/2019/05/spider-man-nguoi-nhen-xa-nha-spider-man-far-from-home-15585310754140_220x310.jpg',
        true,
        'Spider-Man: Người Nhện Xa Nhà - Spider-Man: Far From Home', '2019-07-17', 8, '2H-1e4XNLBo'),
       (2,
        'Định Mệnh Trong Mắt Anh kể về Shinichiro Kiyama (Ryunosuke Kamiki) – chàng trai đã mất gia đình trong một tai nạn máy bay từ khi còn nhỏ. Cuộc sống của Shinichiro thay đổi hoàn toàn kể từ ngày anh nhận ra mình sở hữu “con mắt của Fortuna”. Anh tình cờ gặp Aoi Kiryu (Kasumi Arimura) – một cô gái rạng rỡ và tràn đầy tự tin. Cuộc sống cô độc của Shinichiro bắt đầu được tô điểm bởi những sắc màu mới mẻ. Hai người cảm mến nhau và cùng trải qua những tháng ngày hạnh phúc. Nhưng đột nhiên, Shinichiro phát hiện anh có thể nhìn xuyên thấu qua Aoi. Shinichiro sẽ làm gì khi cái giá để cứu người anh yêu thương nhất lại là sinh mạng của chính mình?',
        'https://s3img.vcdn.vn/mobile/123phim/2019/07/dinh-menh-trong-mat-anh-fortuna-s-eye-15624311374199_220x310.jpg',
        true,
        'Định Mệnh Trong Mắt Anh - Fortuna Eye', '2019-07-18', 7, 'S_BGJqNCpU4'),
       (3,
        'Truyền thuyết kể rằng, bất kỳ chiếc gương nào cũng có thể mở ra một cánh cổng dẫn đến thế giới của người chết, thông qua nghi lễ triệu hồi ác phụ Đầm Bích. Một nhóm học sinh đã phát hiện ra tấm gương ma quái ngay bên trong ngôi trường nội trú lâu đời của mình. Họ vô tình đọc một câu thần chú cổ xưa mà không biết rằng cái giá phải trả là linh hồn chính mình.',
        'https://s3img.vcdn.vn/mobile/123phim/2019/07/loi-nguyen-con-dam-bich-ac-quy-trong-guong-queen-of-spades-through-the-looking-glass-c16-15619725262782_220x310.jpg',
        true,
        'Lời Nguyền Con Đầm Bích: Ác Quỷ Trong Gương - Queen of Spades: Through the Looking Glass', '2019-07-13', 8,
        'gBfvZYpq4vM'),
       (4, 'Phiên bản live-action của Vua Sư Tử huyền thoại.',
        'https://s3img.vcdn.vn/mobile/123phim/2019/07/vua-su-tu-the-lion-king-15629316510442_220x310.jpg', true,
        'Vua Sư Tử - The Lion King', '2019-07-12', 8, 'ax4Q9rtXiFw'),
       (5,
        'Phim kể về một gã cảnh sát đã nhận hối lộ 30 triệu đô la Hong Kong để giúp một kẻ giết người trong nhà tù sớm được trả tự do. Một cuộc điều tra đã được bắt đầu để tìm ra danh tính gã cảnh sát. Lục Chí Liêm (Cổ Thiên Lạc) vào tù giả làm phạm nhân để tiếp cận và tìm chứng cứ từ Tào Nguyên Nguyên (Lâm Phong) – thiếu gia ăn chơi khét tiếng đang bị giam giữ, còn đồng nghiệp Trình Đức Minh (Trịnh Gia Dĩnh) thì ở bên ngoài để tìm kiếm bằng chứng. Trong khoảng thời gian này, Lục Chí Liêm còn phải đối mặt với những kẻ từng bị anh vạch tội bỏ tù trước đây.',
        'https://s3img.vcdn.vn/mobile/123phim/2019/06/doi-chong-tham-nhung-p-storm-15616946818132_220x310.jpg', true,
        'Đội Chống Tham Nhũng - P Storm', '2019-07-18', 8, '_BtyPxcaKT4');

INSERT INTO `roles`
VALUES ('5711db39-6ddf-4c68-b256-ebf6cd27efb5', 'Quản trị hệ thống', 'ROLE_ADMIN'),
       ('6e9f28ae-4bab-4bab-9a63-39d49cdafca2', 'Học viên', 'ROLE_STUDENT'),
       ('ee2dd09f-03f1-4c5f-803b-ed330b64920f', 'Giảng viên', 'ROLE_TEACHER');

INSERT INTO `users`
VALUES ('848e6645-65c2-43b3-b0b9-1b4a04146314', '', '/upload/cute_cat.jpg',
        'admin@gmail.com', NULL, 'Administrator', '$2a$12$1O/BCAGEYPP/jiEEhE7io.ec/JH9u3Qe.JHEYppmCrc9FZ/eu9qlK', '',
        '5711db39-6ddf-4c68-b256-ebf6cd27efb5', NULL);

INSERT INTO `cinemas`
VALUES (1, 'L3-Bitexco Icon 68, 2 Hải Triều, Q.1', 1,
        'Đây là một trong những cụm rạp được đầu tư quy mô nhất hiện nay tại Việt Nam, với tổng diện tích hơn 2.000 m2, bao gồm 7 phòng chiếu được trang bị theo tiêu chuẩn quốc tế. Âm thanh đạt chuẩn Dolby 7.1 với hệ thống cách âm hiện đại, trong đó có 4 phòng 3D,  cùng hơn 1.000 ghế ngồi được thiết kế theo kiểu dáng đẹp mắt và tiện dụng để mang lại sự thoải mái nhất cho khán giả.',
        '/upload/bhd-star-bitexco.jpg', 'BHD Star Bitexco', '028 62 670 670'),
       (2, 'BHD Star Vincom Thảo Điền', 1,
        'Cụm rạp mới BHD Star Mega Mall Thảo Điền toạ lạc tại lầu 5 của TTTM Vincom. Với tầm vóc thương mại và thương hiệu có tiếng của các TTTM Vincom cũng như quy mô đầu tư chất lượng quốc tế của tập đoàn BHD, thì rõ ràng đây lại là một sự kết hợp tuyệt vời nữa giữa giải trí và mua sắm, thiên đường cho các gia đình và các bạn trẻ hội tụ.',
        '/upload/bhd-star-vincom-thao-dien.jpg', 'L5-Megamall, 159 XL Hà Nội, Q.2',
        '028 3744 6969'),
       (3, 'B1-Vincom QT, 190 Quang Trung, Gò Vấp', 1,
        'Cụm rạp BHD Star Quang Trung toạ lạc tại tầng B1, TTTM Vincom Quang Trung, 190 Quang Trung, P.10, Gò Vấp là sự kết hợp tuyệt vời giữa mô hình TTTM và giải trí. Tại đây khán giả có thể vừa thoả sức mua sắm với hệ thống siêu thị Vinmart, các gian hàng hoá/ mỹ phẩm, khu thời trang cao cấp, ẩm thực thuộc TTTM Vincom; vừa có thể tận hưởng không gian giải trí mang đậm phong cách Việt Nam nhưng lại hiện đại không kém so với quốc tế.',
        '/upload/bhd-star-vincom-quang-trung.jpg', 'BHD Star Vincom Quang Trung',
        '028 39892468'),
       (4, '116 Nguyễn Du, Q.1', 2,
        'Galaxy Nguyễn Du gồm 5 phòng chiếu với hơn 1000 chỗ ngồi được thiết kế tinh tế giúp khách hàng có thể xem phim một cách thoải mái và thuận tiện. Chất lượng hình ảnh rõ nét, màn hình chiếu kỹ thuật 3D và Digital vô cùng sắc mịn, mang đến một không gian giải trí vô cùng sống động.',
        '/upload/galaxy-nguyen-du.jpg', 'Galaxy Nguyễn Du', '(028) 3823 5235'),
       (5, 'L3-Co.opmart Foodcosa, 304A Quang Trung, Gò Vấp', 2,
        'Galaxy Quang Trung nằm trọn lầu 3 của khu phức hợp với diện tích gần 2.500m2, có 7 phòng chiếu với 1.200 chỗ ngồi. Toàn bộ cụm rạp sử dụng các thiết bị và công nghệ tân tiến nhất trên thế giới hiện nay như công nghệ âm thanh Dolby 7.1, công nghệ hình ảnh Digital, chiếu cả phim 2D và 3D.',
        '/upload/galaxy-quang-trung.jpg', 'Galaxy Quang Trung',
        '(028)35.897.899'),
       (6, '246 Nguyễn Hồng Đào, Tân Bình', 2,
        'Với diện tích hơn 3000 m2 gồm 5 phòng chiếu , Galaxy Tân Bình được đánh giá như một thế giới Hollywood thu nhỏ của TP.HCM. Cùng sự hỗ trợ tư vấn thiết kế và lắp đặt bởi các chuyên gia của Tập đoàn Warner Bros đến từ Hollywood, các phòng chiếu 2D và 3D với màn hình chiếu sắc nét và dàn âm thanh Dolby 7.1 bậc nhất tại Việt Nam.',
        '/upload/galaxy-tan-binh.jpg', 'Galaxy Tân Bình', '(028) 3849 4567'),
       (7, '718bis Kinh Dương Vương, Q.6', 2,
        'Với quy mô 7 phòng chiếu được thiết kế theo đúng chuẩn quốc tế, ghế ngồi được các nhà thiết kế rạp đầy kinh nghiệm thiết kế với khoảng cách rộng rãi, có độ nhún tạo cảm giác thư giãn như ở nhà. Điều đặc biệt mà Galaxy Cinema đem đến cho khán giả là tất cả các phòng chiếu đều được trang bị những thiết bị hiện đại nhất hiện nay: âm thanh Dolby 7.1, màn hình chiếu kỹ thuật 3D và Digital vô cùng mịn, sắc nét đến từng phút giây.',
        '/upload/galaxy-kinh-duong-vuong.jpg', 'Galaxy Kinh Dương Vương',
        '(028) 3817 2398');
