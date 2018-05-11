-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 30, 2018 at 06:49 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 5.6.34

CREATE DATABASE  IF NOT EXISTS `4CKnowledge` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `4CKnowledge`;

DROP TABLE IF EXISTS `memberInterests`;

DROP TABLE IF EXISTS `members`;

DROP TABLE IF EXISTS `Interests`;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `4CKnowledge`
--

-- --------------------------------------------------------

--
-- Table structure for table `Interests`
--

CREATE TABLE `Interests` (
  `id` int(11) NOT NULL,
  `Description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Interests`
--

INSERT INTO `Interests` (`id`, `Description`) VALUES
(1, 'Artificial Intelligence'),
(2, 'Si-Fi'),
(3, 'Image Processing'),
(4, 'Politics'),
(5, 'Middleware'),
(6, 'Religion');

-- --------------------------------------------------------

--
-- Table structure for table `memberInterests`
--

CREATE TABLE `memberInterests` (
  `interset_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `memberInterests`
--

INSERT INTO `memberInterests` (`interset_id`, `member_id`) VALUES
(1, 14),
(3, 14),
(4, 14),
(6, 14),
(1, 15),
(4, 15),
(6, 15);

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `mid` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(65) DEFAULT NULL,
  `address` varchar(120) DEFAULT NULL,
  `mobile` char(12) DEFAULT NULL,
  `home_tel` char(12) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `user_level` int(11) NOT NULL DEFAULT '0',
  `password` varchar(150) DEFAULT NULL,
  `verification_code` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`mid`, `fname`, `lname`, `email`, `address`, `mobile`, `home_tel`, `dob`, `user_level`, `password`, `verification_code`) VALUES
(13, 'admin', '', '4c.knowledge@gmail.com', '4c', '0713688556', '0715623456', '2017-12-12', 2, '751cb3f4aa17c36186f4856c8982bf27', '4228'),
(14, 'Krishan', 'Prabodha', 'krishan.kr1996@gmail.com', '190/B/2   Samagi Mawatha, Kotugoda', '0712255638', '0112233657', '1996-03-22', 0, '16536eb817b8b991d5cbe34ee22c18', '6203'),
(15, 'Hasitha', 'senevirathne', 'senevirathnehasitha@gmail.com', '190 Anuradhapura', '0741666665', '0112233658', '1995-03-29', 0, '3bfd542ccd5a585b8d4f439ec71194d', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Interests`
--
ALTER TABLE `Interests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `memberInterests`
--
ALTER TABLE `memberInterests`
  ADD KEY `fk_memberInterest_1_idx` (`member_id`),
  ADD KEY `fk_memberInterests_2_idx` (`interset_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`mid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `memberInterests`
--
ALTER TABLE `memberInterests`
  ADD CONSTRAINT `fk_memberInterest_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`mid`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_memberInterests_2` FOREIGN KEY (`interset_id`) REFERENCES `Interests` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
