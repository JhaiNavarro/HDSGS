-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2015 at 04:45 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hdsgs`
--
CREATE DATABASE IF NOT EXISTS `hdsgs` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hdsgs`;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
`id` int(11) NOT NULL,
  `survey_id` int(11) NOT NULL,
  `question_number` int(3) NOT NULL,
  `question` varchar(255) NOT NULL,
  `input_type` enum('number','radio','checkbox','dropdown') NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `question`:
--   `survey_id`
--       `survey` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `question_choice`
--

CREATE TABLE IF NOT EXISTS `question_choice` (
`id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `option_value` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `question_choice`:
--   `question_id`
--       `question` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `question_function`
--

CREATE TABLE IF NOT EXISTS `question_function` (
`id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `function_to_compute` enum('average','minimum','maximum','tally') NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `question_function`:
--   `question_id`
--       `question` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
`id` int(11) NOT NULL,
  `survey_id` int(11) NOT NULL,
  `uploaded_by` int(11) NOT NULL,
  `uploaded_on` date NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `report`:
--   `survey_id`
--       `survey` -> `id`
--   `uploaded_by`
--       `user` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE IF NOT EXISTS `survey` (
`id` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `title` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `survey`:
--   `created_by`
--       `user` -> `id`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `institution` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` enum('contributor','researchLeader','superAdmin') NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
 ADD PRIMARY KEY (`id`), ADD KEY `survey_id` (`survey_id`);

--
-- Indexes for table `question_choice`
--
ALTER TABLE `question_choice`
 ADD PRIMARY KEY (`id`), ADD KEY `question_id` (`question_id`);

--
-- Indexes for table `question_function`
--
ALTER TABLE `question_function`
 ADD PRIMARY KEY (`id`), ADD KEY `question_id` (`question_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
 ADD PRIMARY KEY (`id`), ADD KEY `survey_id` (`survey_id`), ADD KEY `uploaded_by` (`uploaded_by`);

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
 ADD PRIMARY KEY (`id`), ADD KEY `created_by` (`created_by`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question_choice`
--
ALTER TABLE `question_choice`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question_function`
--
ALTER TABLE `question_function`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `survey`
--
ALTER TABLE `survey`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_choice`
--
ALTER TABLE `question_choice`
ADD CONSTRAINT `question_choice_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question_function`
--
ALTER TABLE `question_function`
ADD CONSTRAINT `question_function_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `report`
--
ALTER TABLE `report`
ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`uploaded_by`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `survey`
--
ALTER TABLE `survey`
ADD CONSTRAINT `survey_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
