-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th10 15, 2021 lúc 09:18 PM
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
-- Cấu trúc bảng cho bảng `Block`
--

CREATE TABLE `Block` (
  `id_user` int(11) NOT NULL,
  `id_room` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Block`
--

INSERT INTO `Block` (`id_user`, `id_room`) VALUES
(1, 1);

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
-- Cấu trúc bảng cho bảng `Join_Room`
--

CREATE TABLE `Join_Room` (
  `id_room` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Join_Room`
--

INSERT INTO `Join_Room` (`id_room`, `id_user`) VALUES
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Message`
--

CREATE TABLE `Message` (
  `id_mess` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_room` int(11) NOT NULL,
  `is_url` tinyint(1) NOT NULL,
  `body` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Message`
--

INSERT INTO `Message` (`id_mess`, `id_user`, `id_room`, `is_url`, `body`, `time`) VALUES
(1, 1, 1, 0, 'Hello world', '2021-11-10 06:21:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Room`
--

CREATE TABLE `Room` (
  `id_room` int(11) NOT NULL,
  `id_owner` int(11) NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `group_chat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `Room`
--

INSERT INTO `Room` (`id_room`, `id_owner`, `name`, `group_chat`) VALUES
(1, 1, 'Phòng Chat test', 0),
(2, 1, 'Network', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `User`
--

CREATE TABLE `User` (
  `id_user` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `birthday` date NOT NULL,
  `online_status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `User`
--

INSERT INTO `User` (`id_user`, `email`, `password`, `name`, `sex`, `birthday`, `online_status`) VALUES
(1, 'pnmthuan@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Phạm Nguyễn Minh Thuận', 1, '2001-01-28', 1),
(2, 'pnmthuan_02@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Tai khoan 2', 1, '2021-11-02', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `View_Message`
--

CREATE TABLE `View_Message` (
  `id_mess` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Block`
--
ALTER TABLE `Block`
  ADD PRIMARY KEY (`id_user`,`id_room`),
  ADD KEY `id_user` (`id_user`,`id_room`),
  ADD KEY `id_room` (`id_room`);

--
-- Chỉ mục cho bảng `Friend`
--
ALTER TABLE `Friend`
  ADD PRIMARY KEY (`id_user_1`,`id_user_2`),
  ADD KEY `id_user_1` (`id_user_1`,`id_user_2`),
  ADD KEY `id_user_2` (`id_user_2`);

--
-- Chỉ mục cho bảng `Join_Room`
--
ALTER TABLE `Join_Room`
  ADD PRIMARY KEY (`id_room`,`id_user`),
  ADD KEY `id_room` (`id_room`,`id_user`),
  ADD KEY `id_user` (`id_user`);

--
-- Chỉ mục cho bảng `Message`
--
ALTER TABLE `Message`
  ADD PRIMARY KEY (`id_mess`),
  ADD KEY `id_user` (`id_user`,`id_room`),
  ADD KEY `id_room` (`id_room`);

--
-- Chỉ mục cho bảng `Room`
--
ALTER TABLE `Room`
  ADD PRIMARY KEY (`id_room`),
  ADD KEY `id_owner` (`id_owner`);

--
-- Chỉ mục cho bảng `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id_user`);

--
-- Chỉ mục cho bảng `View_Message`
--
ALTER TABLE `View_Message`
  ADD PRIMARY KEY (`id_mess`,`id_user`),
  ADD KEY `id_mess` (`id_mess`,`id_user`),
  ADD KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Message`
--
ALTER TABLE `Message`
  MODIFY `id_mess` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT cho bảng `Room`
--
ALTER TABLE `Room`
  MODIFY `id_room` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT cho bảng `User`
--
ALTER TABLE `User`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `Block`
--
ALTER TABLE `Block`
  ADD CONSTRAINT `Block_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Block_ibfk_2` FOREIGN KEY (`id_room`) REFERENCES `Room` (`id_room`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Friend`
--
ALTER TABLE `Friend`
  ADD CONSTRAINT `Friend_ibfk_1` FOREIGN KEY (`id_user_1`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Friend_ibfk_2` FOREIGN KEY (`id_user_2`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Join_Room`
--
ALTER TABLE `Join_Room`
  ADD CONSTRAINT `Join_Room_ibfk_1` FOREIGN KEY (`id_room`) REFERENCES `Room` (`id_room`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Join_Room_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Message`
--
ALTER TABLE `Message`
  ADD CONSTRAINT `Message_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Message_ibfk_2` FOREIGN KEY (`id_room`) REFERENCES `Room` (`id_room`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `Room`
--
ALTER TABLE `Room`
  ADD CONSTRAINT `Room_ibfk_1` FOREIGN KEY (`id_owner`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `View_Message`
--
ALTER TABLE `View_Message`
  ADD CONSTRAINT `View_Message_ibfk_1` FOREIGN KEY (`id_mess`) REFERENCES `Message` (`id_mess`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `View_Message_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
