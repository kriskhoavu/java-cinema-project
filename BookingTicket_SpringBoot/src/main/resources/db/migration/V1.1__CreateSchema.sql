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
VALUES ('848e6645-65c2-43b3-b0b9-1b4a04146314', '', '/upload/1520805_639142046204871_1551292379302375531_n.jpg',
        'admin@gmail.com', NULL, 'Administrator', '$2a$12$1O/BCAGEYPP/jiEEhE7io.ec/JH9u3Qe.JHEYppmCrc9FZ/eu9qlK', '',
        '5711db39-6ddf-4c68-b256-ebf6cd27efb5', NULL);
