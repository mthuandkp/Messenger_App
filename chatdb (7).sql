-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th12 12, 2021 lúc 02:12 PM
-- Phiên bản máy phục vụ: 5.7.36-0ubuntu0.18.04.1
-- Phiên bản PHP: 7.2.34-26+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `chatdb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Block_Group`
--

CREATE TABLE `Block_Group` (
  `id_user` int(11) NOT NULL,
  `id_group` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Block_Group`
--

INSERT INTO `Block_Group` (`id_user`, `id_group`) VALUES
(3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Block_User`
--

CREATE TABLE `Block_User` (
  `id_user` int(11) NOT NULL,
  `id_user_block` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Friend`
--

CREATE TABLE `Friend` (
  `id_user_1` int(11) NOT NULL,
  `id_user_2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Group_Chat`
--

CREATE TABLE `Group_Chat` (
  `id_group` int(11) NOT NULL,
  `id_owner` int(11) NOT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Group_Chat`
--

INSERT INTO `Group_Chat` (`id_group`, `id_owner`, `name`) VALUES
(1, 1, 'Chat java '),
(2, 1, 'Chat linux '),
(8, 1, 'PTTK'),
(9, 1, 'C cong cong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Join_Group`
--

CREATE TABLE `Join_Group` (
  `id_user` int(11) NOT NULL,
  `id_group` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Join_Group`
--

INSERT INTO `Join_Group` (`id_user`, `id_group`) VALUES
(1, 1),
(2, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Message_11`
--

CREATE TABLE `Message_11` (
  `id` int(11) NOT NULL,
  `id_sender` int(11) NOT NULL,
  `id_received` int(11) NOT NULL,
  `time` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `url` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Message_11`
--

INSERT INTO `Message_11` (`id`, `id_sender`, `id_received`, `time`, `content`, `url`) VALUES
(9, 1, 2, '2021/12/09 09:34:36', 'Alo alo', 0),
(10, 2, 1, '2021-11-10 06:21:00', 'Nghe nghe', 0),
(11, 1, 2, '2021/12/10 11:27:25', 'sticker7.gif', 1),
(12, 2, 3, '2021/12/12 13:34:30', 'Long ơi !!!', 0),
(13, 3, 2, '2021/12/12 13:34:47', 'sticker4.gif', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Message_Group`
--

CREATE TABLE `Message_Group` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_group` int(11) NOT NULL,
  `time` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `url` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Message_Group`
--

INSERT INTO `Message_Group` (`id`, `id_user`, `id_group`, `time`, `content`, `url`) VALUES
(2, 2, 1, '2021-11-23 08:20:00', 'Test tin nhan SGU', 0),
(3, 1, 1, '2021-11-12 11:13:00', 'sticker2.gif', 1),
(4, 2, 1, '2021-11-12 11:13:00', 'hello.txt', 1),
(5, 1, 1, '2021/12/01 15:14:52', 'Hello hello', 0),
(6, 1, 1, '2021/12/01 15:18:28', 'Hello', 0),
(7, 1, 1, '2021/12/01 15:18:37', 'Helofdfbbfd', 0),
(8, 1, 1, '2021/12/01 15:19:32', 'ae oi =))', 0),
(9, 2, 1, '2021/12/01 15:51:29', 'alo', 0),
(10, 1, 1, '2021/12/01 15:51:57', 'Nghe nghe', 0),
(11, 2, 1, '2021/12/01 22:12:53', 'inputReceipt_02.txt', 1),
(12, 2, 1, '2021/12/01 22:14:55', 'inputReceipt_02.txt', 1),
(13, 1, 1, '2021/12/02 07:35:48', 'test test ', 0),
(14, 1, 1, '2021/12/02 09:09:55', 'sticker2.gif', 1),
(15, 1, 1, '2021/12/02 09:11:23', 'sticker6.gif', 1),
(16, 1, 1, '2021/12/02 20:49:28', 'sticker4.gif', 1),
(17, 2, 1, '2021/12/02 21:06:00', 'sticker3.gif', 1),
(18, 1, 1, '2021/12/02 21:44:07', 'sticker5.gif', 1),
(19, 2, 1, '2021/12/02 21:44:25', 'sticker7.gif', 1),
(20, 2, 1, '2021/12/02 22:27:32', 'sticker4.gif', 1),
(21, 1, 1, '2021/12/02 22:27:54', 'sticker10.gif', 1),
(22, 2, 1, '2021/12/03 07:32:25', 'Hello', 0),
(23, 2, 1, '2021/12/03 07:32:37', 'sticker8.gif', 1),
(24, 2, 1, '2021/12/03 07:37:18', 'Hello', 0),
(25, 1, 1, '2021/12/03 07:37:46', 'Nghe nghe', 0),
(26, 2, 1, '2021/12/03 07:38:04', 'sticker2.gif', 1),
(27, 1, 1, '2021/12/03 07:38:07', 'sticker4.gif', 1),
(28, 1, 1, '2021/12/03 07:48:25', 'alo', 0),
(29, 1, 1, '2021/12/03 07:52:45', 'sticker8.gif', 1),
(30, 1, 1, '2021/12/03 07:53:13', 'sticker7.gif', 1),
(31, 1, 1, '2021/12/03 07:53:21', 'sticker10.gif', 1),
(32, 1, 1, '2021/12/03 19:55:13', 'sticker4.gif', 1),
(33, 1, 1, '2021/12/05 10:28:21', 'send send ', 0),
(34, 1, 1, '2021/12/05 10:30:12', 'Hello', 0),
(35, 1, 1, '2021/12/05 10:32:09', 'nhan nhan ', 0),
(36, 1, 1, '2021/12/05 10:35:40', 'alo alo', 0),
(37, 1, 1, '2021/12/05 10:37:51', 'waiting......', 0),
(38, 1, 1, '2021/12/05 10:37:58', 'inputReceipt_02.txt', 1),
(39, 1, 1, '2021/12/05 10:38:13', 'sticker4.gif', 1),
(40, 1, 1, '2021/12/05 10:38:22', 'alo alo ', 0),
(41, 1, 1, '2021/12/05 10:38:36', 'inputReceipt_02.txt', 1),
(42, 1, 1, '2021/12/05 10:49:19', 'sticker4.gif', 1),
(43, 1, 1, '2021/12/05 10:58:44', 'hello\\nae', 0),
(44, 1, 1, '2021/12/05 10:58:50', 'nghe nghe', 0),
(45, 1, 1, '2021/12/06 07:05:44', 'hocbu_sgu.txt', 1),
(46, 1, 1, '2021/12/06 07:06:25', 'CNPM.jpg', 1),
(47, 1, 1, '2021/12/06 08:16:51', 'templateUML_03.jpg', 1),
(48, 1, 1, '2021/12/06 13:14:40', 'hocbu_sgu.txt', 1),
(49, 1, 2, '2021/12/09 09:11:50', 'hello', 0),
(50, 2, 1, '2021/12/12 13:14:01', 'sticker1.gif', 1),
(51, 1, 1, '2021/12/12 13:36:06', 'Hey bro =)))', 0),
(52, 1, 1, '2021/12/12 13:37:01', 'hocbu_sgu.txt', 1),
(53, 1, 1, '2021/12/12 14:11:05', 'sticker14.gif', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `User`
--

CREATE TABLE `User` (
  `Id` int(11) NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `birthday` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `online_status` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `ServerBlock` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `User`
--

INSERT INTO `User` (`Id`, `email`, `password`, `name`, `sex`, `birthday`, `online_status`, `is_active`, `ServerBlock`) VALUES
(1, 'pnmthuan@gmail.com', '202cb962ac59075b964b07152d234b70', 'Phạm Nguyễn Minh Thuận', 1, '2001-11-28', 0, 1, 0),
(2, 'khang@gmail.com', '202cb962ac59075b964b07152d234b70', 'Đỗ Nhỉ Khang', 1, '20-01-2001', 0, 1, 0),
(3, 'long@gmail.com', '202cb962ac59075b964b07152d234b70', 'Nguyễn Trần Huỳnh Long', 1, '2001-01-28', 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `View_Message_11`
--

CREATE TABLE `View_Message_11` (
  `id_user` int(11) NOT NULL,
  `id_mess` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `View_Message_11`
--

INSERT INTO `View_Message_11` (`id_user`, `id_mess`) VALUES
(1, 10),
(3, 12),
(2, 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `View_Message_Group`
--

CREATE TABLE `View_Message_Group` (
  `id_user` int(11) NOT NULL,
  `id_mess` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `View_Message_Group`
--

INSERT INTO `View_Message_Group` (`id_user`, `id_mess`) VALUES
(1, 2),
(3, 2),
(2, 3),
(3, 3),
(1, 4),
(3, 4),
(2, 5),
(3, 5),
(2, 6),
(3, 6),
(2, 7),
(3, 7),
(2, 8),
(3, 8),
(1, 9),
(3, 9),
(2, 10),
(3, 10),
(1, 11),
(3, 11),
(1, 12),
(3, 12),
(1, 13),
(2, 13),
(3, 13),
(2, 14),
(3, 14),
(2, 15),
(3, 15),
(2, 16),
(3, 16),
(1, 17),
(3, 17),
(2, 18),
(3, 18),
(1, 19),
(3, 19),
(1, 20),
(3, 20),
(2, 21),
(3, 21),
(1, 22),
(3, 22),
(1, 23),
(3, 23),
(1, 24),
(3, 24),
(2, 25),
(3, 25),
(1, 26),
(3, 26),
(2, 27),
(3, 27),
(2, 28),
(3, 28),
(2, 29),
(3, 29),
(2, 30),
(3, 30),
(2, 31),
(3, 31),
(2, 32),
(3, 32),
(2, 33),
(3, 33),
(2, 34),
(3, 34),
(2, 35),
(3, 35),
(2, 36),
(3, 36),
(2, 37),
(3, 37),
(2, 38),
(3, 38),
(2, 39),
(3, 39),
(2, 40),
(3, 40),
(2, 41),
(3, 41),
(2, 42),
(3, 42),
(2, 43),
(3, 43),
(2, 44),
(3, 44),
(2, 45),
(3, 45),
(2, 46),
(3, 46),
(2, 47),
(3, 47),
(2, 48),
(3, 48),
(1, 50),
(3, 50),
(2, 51),
(3, 51),
(2, 52),
(3, 52);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Block_Group`
--
ALTER TABLE `Block_Group`
  ADD PRIMARY KEY (`id_user`,`id_group`),
  ADD KEY `id_user` (`id_user`,`id_group`),
  ADD KEY `id_group` (`id_group`);

--
-- Chỉ mục cho bảng `Block_User`
--
ALTER TABLE `Block_User`
  ADD PRIMARY KEY (`id_user`,`id_user_block`),
  ADD KEY `id_user` (`id_user`,`id_user_block`),
  ADD KEY `id_user_block` (`id_user_block`);

--
-- Chỉ mục cho bảng `Friend`
--
ALTER TABLE `Friend`
  ADD PRIMARY KEY (`id_user_1`,`id_user_2`),
  ADD KEY `id_user_1` (`id_user_1`,`id_user_2`),
  ADD KEY `id_user_2` (`id_user_2`);

--
-- Chỉ mục cho bảng `Group_Chat`
--
ALTER TABLE `Group_Chat`
  ADD PRIMARY KEY (`id_group`),
  ADD KEY `id_owner` (`id_owner`);

--
-- Chỉ mục cho bảng `Join_Group`
--
ALTER TABLE `Join_Group`
  ADD PRIMARY KEY (`id_user`,`id_group`),
  ADD KEY `id_user` (`id_user`,`id_group`),
  ADD KEY `id_group` (`id_group`);

--
-- Chỉ mục cho bảng `Message_11`
--
ALTER TABLE `Message_11`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sender` (`id_sender`,`id_received`),
  ADD KEY `id_received` (`id_received`);

--
-- Chỉ mục cho bảng `Message_Group`
--
ALTER TABLE `Message_Group`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`,`id_group`),
  ADD KEY `id_group` (`id_group`);

--
-- Chỉ mục cho bảng `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `View_Message_11`
--
ALTER TABLE `View_Message_11`
  ADD PRIMARY KEY (`id_user`,`id_mess`),
  ADD KEY `id_user` (`id_user`,`id_mess`),
  ADD KEY `id_mess` (`id_mess`);

--
-- Chỉ mục cho bảng `View_Message_Group`
--
ALTER TABLE `View_Message_Group`
  ADD PRIMARY KEY (`id_user`,`id_mess`),
  ADD KEY `id_user` (`id_user`,`id_mess`),
  ADD KEY `id_mess` (`id_mess`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Group_Chat`
--
ALTER TABLE `Group_Chat`
  MODIFY `id_group` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT cho bảng `Message_11`
--
ALTER TABLE `Message_11`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT cho bảng `Message_Group`
--
ALTER TABLE `Message_Group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT cho bảng `User`
--
ALTER TABLE `User`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `Block_Group`
--
ALTER TABLE `Block_Group`
  ADD CONSTRAINT `Block_Group_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Block_Group_ibfk_2` FOREIGN KEY (`id_group`) REFERENCES `Group_Chat` (`id_group`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Block_User`
--
ALTER TABLE `Block_User`
  ADD CONSTRAINT `Block_User_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Block_User_ibfk_2` FOREIGN KEY (`id_user_block`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Friend`
--
ALTER TABLE `Friend`
  ADD CONSTRAINT `Friend_ibfk_1` FOREIGN KEY (`id_user_1`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Friend_ibfk_2` FOREIGN KEY (`id_user_2`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Group_Chat`
--
ALTER TABLE `Group_Chat`
  ADD CONSTRAINT `Group_Chat_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Join_Group`
--
ALTER TABLE `Join_Group`
  ADD CONSTRAINT `Join_Group_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Join_Group_ibfk_2` FOREIGN KEY (`id_group`) REFERENCES `Group_Chat` (`id_group`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Message_11`
--
ALTER TABLE `Message_11`
  ADD CONSTRAINT `Message_11_ibfk_1` FOREIGN KEY (`id_sender`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Message_11_ibfk_2` FOREIGN KEY (`id_received`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Message_Group`
--
ALTER TABLE `Message_Group`
  ADD CONSTRAINT `Message_Group_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Message_Group_ibfk_2` FOREIGN KEY (`id_group`) REFERENCES `Group_Chat` (`id_group`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `View_Message_11`
--
ALTER TABLE `View_Message_11`
  ADD CONSTRAINT `View_Message_11_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `View_Message_11_ibfk_2` FOREIGN KEY (`id_mess`) REFERENCES `Message_11` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `View_Message_Group`
--
ALTER TABLE `View_Message_Group`
  ADD CONSTRAINT `View_Message_Group_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `View_Message_Group_ibfk_2` FOREIGN KEY (`id_mess`) REFERENCES `Message_Group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
