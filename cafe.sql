-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2023 at 10:51 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `beverage`
--

CREATE TABLE `beverage` (
  `B_id` int(11) NOT NULL,
  `B_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `Price` float(10,2) NOT NULL,
  `B_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `beverage`
--

INSERT INTO `beverage` (`B_id`, `B_name`, `Price`, `B_qty`) VALUES
(101, 'โกโก้เย็น', 35.00, 100),
(102, 'ชาเชียวเย็น', 30.00, 100),
(103, 'ชาไทยเย็น', 30.00, 100),
(104, 'กาแฟเย็น', 35.00, 100),
(105, 'นมเย็น', 25.00, 100),
(106, 'ช็อกโกแลตเย็น', 35.00, 100),
(107, 'ชามะนาวเย็น', 30.00, 100),
(108, 'เสาวรสเย็น', 30.00, 100),
(109, 'นมสดเย็น', 25.00, 100),
(110, 'นมสตอเบอร์รี่เย็น', 35.00, 100);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `C_id` int(11) NOT NULL,
  `C_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`C_id`, `C_name`) VALUES
(120, 'สมหญิง'),
(121, 'สมหยอย'),
(122, 'สมชาย'),
(123, 'สมศักด์');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `E_id` int(11) NOT NULL,
  `Address` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `Telephone_num` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `E_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `Salary` float NOT NULL,
  `Card_id` varchar(13) CHARACTER SET utf8mb4 NOT NULL,
  `P_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`E_id`, `Address`, `Telephone_num`, `E_name`, `Salary`, `Card_id`, `P_id`) VALUES
(1, 'ladkabang', '0923456789', 'ศศิกานต์  สารเสวก', 16000, '1101100234', 1),
(2, 'ladkabang', '0876543210', 'ธนชนก  แก้วคำอ้าย', 14000, '1101100456', 2),
(3, 'ladkabang', '0992345678', 'นุชจิรา  ผิวศิริ', 12000, '1101100789', 3);

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE `ingredient` (
  `I_id` int(11) NOT NULL,
  `I_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `I_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredient`
--

INSERT INTO `ingredient` (`I_id`, `I_name`, `I_qty`) VALUES
(1, 'ผงโกโก้', 100),
(2, 'ผงชาเขียว', 100),
(3, 'ผงชาไทย', 100),
(4, 'เมล็ดกาแฟ', 100),
(5, 'เฮลบลูบอย', 100),
(6, 'นมสด', 100),
(7, 'ผงช็อกโกแลต', 100),
(8, 'มะนาว', 100),
(9, 'น้ำผึ้ง', 100),
(10, 'เสาวรส', 100),
(11, 'สตอเบอร์รี่', 100),
(12, 'น้ำเชื่อม', 100),
(13, 'น้ำแข็ง', 100);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_id` int(11) NOT NULL,
  `B_id` int(11) NOT NULL,
  `Total` float NOT NULL,
  `Order_qty` int(11) NOT NULL,
  `C_id` int(11) NOT NULL,
  `R_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_id`, `B_id`, `Total`, `Order_qty`, `C_id`, `R_id`) VALUES
(1, 102, 35, 1, 120, 1),
(2, 110, 35, 1, 121, 2),
(3, 102, 30, 1, 122, 3),
(4, 102, 35, 1, 123, 4);

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `P_id` int(11) NOT NULL,
  `P_Name` varchar(20) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`P_id`, `P_Name`) VALUES
(2, 'Barista'),
(1, 'Cashier'),
(3, 'Front');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `R_id` int(11) NOT NULL,
  `R_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Total` float NOT NULL,
  `P_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`R_id`, `R_date`, `Total`, `P_name`) VALUES
(1, '2023-05-19 17:00:00', 35, 'Cashier'),
(2, '2023-05-19 17:00:00', 35, 'Cashier'),
(3, '2023-05-19 17:00:00', 30, 'Cashier'),
(4, '2023-05-19 17:00:00', 35, 'Cashier');

-- --------------------------------------------------------

--
-- Table structure for table `relation_beverage_ingredient`
--

CREATE TABLE `relation_beverage_ingredient` (
  `B_id` int(11) NOT NULL,
  `I_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `relation_beverage_ingredient`
--

INSERT INTO `relation_beverage_ingredient` (`B_id`, `I_id`) VALUES
(101, 1),
(101, 6),
(101, 13),
(102, 2),
(102, 6),
(102, 13),
(103, 3),
(103, 13),
(104, 4),
(104, 6),
(104, 13),
(105, 6),
(105, 13),
(106, 7),
(106, 6),
(106, 13),
(107, 8),
(107, 9),
(107, 12),
(107, 13),
(108, 10),
(108, 12),
(108, 13),
(110, 6),
(110, 11),
(110, 13);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beverage`
--
ALTER TABLE `beverage`
  ADD PRIMARY KEY (`B_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`C_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`E_id`),
  ADD KEY `waiter_FK` (`P_id`);

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`I_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Order_id`),
  ADD KEY `fk_beverage_order` (`B_id`),
  ADD KEY `fk_receipt` (`R_id`),
  ADD KEY `fk_cusId` (`C_id`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`P_id`),
  ADD UNIQUE KEY `position_un` (`P_Name`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`R_id`),
  ADD KEY `fk_position` (`P_name`);

--
-- Indexes for table `relation_beverage_ingredient`
--
ALTER TABLE `relation_beverage_ingredient`
  ADD KEY `fk_beve` (`B_id`),
  ADD KEY `fk_ingre` (`I_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `waiter_FK` FOREIGN KEY (`P_id`) REFERENCES `position` (`P_id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_beverage_order` FOREIGN KEY (`B_id`) REFERENCES `beverage` (`B_id`),
  ADD CONSTRAINT `fk_cusId` FOREIGN KEY (`C_id`) REFERENCES `customer` (`C_id`),
  ADD CONSTRAINT `fk_receipt` FOREIGN KEY (`R_id`) REFERENCES `receipt` (`R_id`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `fk_position` FOREIGN KEY (`P_name`) REFERENCES `position` (`P_Name`);

--
-- Constraints for table `relation_beverage_ingredient`
--
ALTER TABLE `relation_beverage_ingredient`
  ADD CONSTRAINT `fk_beve` FOREIGN KEY (`B_id`) REFERENCES `beverage` (`B_id`),
  ADD CONSTRAINT `fk_ingre` FOREIGN KEY (`I_id`) REFERENCES `ingredient` (`I_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
