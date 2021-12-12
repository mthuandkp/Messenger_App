-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th12 02, 2021 lúc 08:48 PM
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
(2, 1, 'Chat linux ');

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
(1, 2);

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
(1, 1, 2, '2021-11-10 06:21:00', 'Hello', 0);

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
(15, 1, 1, '2021/12/02 09:11:23', 'sticker6.gif', 1);

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
(2, 'hello@gmail.com', '202cb962ac59075b964b07152d234b70', 'Tai khoan hello', 1, '20-01-2001', 0, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `View_Message_11`
--

CREATE TABLE `View_Message_11` (
  `id_user` int(11) NOT NULL,
  `id_mess` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(2, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(1, 9),
(2, 10),
(1, 11),
(1, 12),
(2, 13),
(2, 14),
(2, 15);

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
  MODIFY `id_group` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `Message_11`
--
ALTER TABLE `Message_11`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `Message_Group`
--
ALTER TABLE `Message_Group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT cho bảng `User`
--
ALTER TABLE `User`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
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
