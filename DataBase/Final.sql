-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2022 at 10:51 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerdetails`
--

CREATE TABLE `customerdetails` (
  `customer_id` int(11) NOT NULL,
  `cus_name` varchar(200) NOT NULL,
  `cus_address` varchar(200) NOT NULL,
  `cus_telephone` varchar(200) NOT NULL,
  `cus_email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customerdetails`
--

INSERT INTO `customerdetails` (`customer_id`, `cus_name`, `cus_address`, `cus_telephone`, `cus_email`) VALUES
(101, 'chandima', 'kaluthara', '076123456', 'chandima@gmail.com'),
(102, 'ishan', 'kandy', '075123456', 'ishan@gmail.com'),
(103, 'irusha', 'mathara', '0123', 'irusha@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `ordersplacing`
--

CREATE TABLE `ordersplacing` (
  `order_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordersplacing`
--

INSERT INTO `ordersplacing` (`order_id`, `order_date`, `customer_id`) VALUES
(1001, '2022-05-24', 101),
(1002, '2022-04-24', 101),
(1003, '2022-02-24', 102),
(1004, '2022-04-24', 102),
(1005, '2022-03-24', 102),
(1007, '2022-06-24', 101),
(1008, '2022-06-24', 102),
(1009, '2022-06-28', 101),
(1010, '2022-05-10', 102),
(1011, '2022-06-28', 102),
(1012, '2022-04-13', 102),
(1013, '2022-03-14', 102),
(1014, '2022-06-28', 103),
(1015, '2022-04-04', 103),
(1016, '2022-03-01', 102);

-- --------------------------------------------------------

--
-- Table structure for table `order_products`
--

CREATE TABLE `order_products` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `order_product_quantity` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_products`
--

INSERT INTO `order_products` (`order_id`, `product_id`, `order_product_quantity`) VALUES
(1001, 101, '50'),
(1002, 100, '42'),
(1003, 100, '16'),
(1003, 101, '10'),
(1004, 100, '28'),
(1004, 101, '11'),
(1005, 101, '34'),
(1006, 100, '5'),
(1006, 101, '3'),
(1008, 100, '1'),
(1008, 101, '2'),
(1008, 102, '5'),
(1009, 101, '10'),
(1009, 102, '15'),
(1009, 109, '14'),
(1010, 100, '10'),
(1010, 101, '20'),
(1011, 100, '10'),
(1011, 101, '20'),
(1012, 100, '10'),
(1012, 101, '8'),
(1013, 100, '10'),
(1013, 101, '8'),
(1014, 100, '9'),
(1014, 101, '10'),
(1015, 100, '9'),
(1015, 101, '10'),
(1016, 100, '10');

-- --------------------------------------------------------

--
-- Table structure for table `order_rawmaterial`
--

CREATE TABLE `order_rawmaterial` (
  `order_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `order_material_total_qty` varchar(200) NOT NULL,
  `order_material_total_price` varchar(200) NOT NULL,
  `check_material_issue` varchar(50) NOT NULL DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_rawmaterial`
--

INSERT INTO `order_rawmaterial` (`order_id`, `material_id`, `order_material_total_qty`, `order_material_total_price`, `check_material_issue`) VALUES
(1001, 1, '12.5', '', 'true'),
(1001, 2, '15.0', '', 'true'),
(1001, 5, '32.5', '', 'true'),
(1002, 1, '23.939999999999998', '', 'true'),
(1002, 2, '18.06', '', 'true'),
(1003, 1, '11.62', '58099.99999999999', 'true'),
(1003, 2, '9.879999999999999', '64219.99999999999', 'true'),
(1003, 5, '6.5', '23010.0', 'true'),
(1005, 1, '8.5', '42500.0', 'true'),
(1005, 2, '10.2', '66300.0', 'true'),
(1005, 5, '22.1', '78234.0', 'true'),
(1009, 1, '2.5', '12500.0', 'true'),
(1009, 2, '6.75', '43875.0', 'true'),
(1009, 5, '6.668', '23604.72', 'true'),
(1014, 1, '7.63', '38150.0', 'false'),
(1014, 2, '6.87', '44655.0', 'false'),
(1014, 5, '6.5', '23010.0', 'false'),
(1015, 1, '7.63', '38150.0', 'false'),
(1015, 2, '6.87', '44655.0', 'false'),
(1015, 5, '6.5', '23010.0', 'false'),
(1016, 1, '5.699999999999999', '28499.999999999996', 'true'),
(1016, 2, '4.3', '27950.0', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `productdetails`
--

CREATE TABLE `productdetails` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `product_weight` varchar(200) NOT NULL COMMENT 'g',
  `product_price` varchar(200) NOT NULL COMMENT 'Rs'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productdetails`
--

INSERT INTO `productdetails` (`product_id`, `product_name`, `product_weight`, `product_price`) VALUES
(100, 'Iron Man Cuddly Toy', '150', '1500'),
(101, 'Racing Car Toy', '100', '1000'),
(102, 'Bat Man', '123', '545'),
(109, 'Train set', '265', '980'),
(110, 'jeep', '400', '1,750');

-- --------------------------------------------------------

--
-- Table structure for table `product_planing`
--

CREATE TABLE `product_planing` (
  `product_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `product_material_quantity` varchar(20) NOT NULL COMMENT 'kg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_planing`
--

INSERT INTO `product_planing` (`product_id`, `material_id`, `product_material_quantity`) VALUES
(100, 1, '0.57'),
(100, 2, '0.43'),
(101, 1, '0.25'),
(101, 2, '0.3'),
(101, 5, '0.65'),
(102, 2, '0.25'),
(109, 5, '0.012'),
(110, 1, '0.1'),
(110, 2, '0.1'),
(110, 4, '0.1'),
(110, 7, '0.1');

-- --------------------------------------------------------

--
-- Table structure for table `rawmaterial`
--

CREATE TABLE `rawmaterial` (
  `material_id` int(11) NOT NULL,
  `material_name` varchar(200) NOT NULL,
  `material_unit` varchar(200) NOT NULL COMMENT 'kg',
  `price_per_unit` varchar(200) NOT NULL COMMENT 'Rs',
  `stock_quantity` varchar(200) NOT NULL COMMENT 'kg'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rawmaterial`
--

INSERT INTO `rawmaterial` (`material_id`, `material_name`, `material_unit`, `price_per_unit`, `stock_quantity`) VALUES
(1, 'Plastic', '1', '5000', '100'),
(2, 'Fiber', '1', '6500', '100'),
(4, 'Iron', '1', '5675', '100'),
(5, 'Tin', '1', '3540', '100'),
(7, 'copper', '1', '10,000', '100');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `user_id` int(11) NOT NULL,
  `u_name` varchar(200) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_telephone` varchar(20) NOT NULL,
  `u_address` varchar(200) NOT NULL,
  `u_department` varchar(50) NOT NULL,
  `u_password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`user_id`, `u_name`, `u_email`, `u_telephone`, `u_address`, `u_department`, `u_password`) VALUES
(100, 'pavan', 'pavan@gmail.com', '0123', 'piliyandala', 'Sales', '123'),
(101, 'Nandun', 'kaluthara', '0123', 'nandun@gmail.com', 'Administration', '123'),
(102, 'mahela', 'wadduwa', '0123', 'mahela@gmail.com', 'Production', '123'),
(103, 'hansala', 'rathnapura', '0123', 'hansala@gmail.com', 'Marketing', '123'),
(104, 'kara', 'kara@gmail.com', '0123', 'rathnepura', 'Administration', '123'),
(105, 'vhg', 'piliyandala', '0123', 'vhg@gmail.com', 'Warehouse', '123'),
(106, 'ishan', 'kandy', '0123', 'ishan@gmail.com', 'Finance', '123'),
(107, 'parami', 'haputhale', '123', 'parami@gmailcom', 'Finance', '123'),
(108, 'testuser01', 'test', '12345678', 'testuse01@gnail,com', 'Sales', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customerdetails`
--
ALTER TABLE `customerdetails`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `ordersplacing`
--
ALTER TABLE `ordersplacing`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `order_products`
--
ALTER TABLE `order_products`
  ADD PRIMARY KEY (`order_id`,`product_id`);

--
-- Indexes for table `order_rawmaterial`
--
ALTER TABLE `order_rawmaterial`
  ADD PRIMARY KEY (`order_id`,`material_id`);

--
-- Indexes for table `productdetails`
--
ALTER TABLE `productdetails`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `product_planing`
--
ALTER TABLE `product_planing`
  ADD PRIMARY KEY (`product_id`,`material_id`);

--
-- Indexes for table `rawmaterial`
--
ALTER TABLE `rawmaterial`
  ADD PRIMARY KEY (`material_id`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customerdetails`
--
ALTER TABLE `customerdetails`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT for table `ordersplacing`
--
ALTER TABLE `ordersplacing`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1024;

--
-- AUTO_INCREMENT for table `productdetails`
--
ALTER TABLE `productdetails`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT for table `rawmaterial`
--
ALTER TABLE `rawmaterial`
  MODIFY `material_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
