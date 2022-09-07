-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 15, 2022 at 11:25 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.30

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
(102, 'ishan', 'kandy', '075123456', 'ishan@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `ordersplacing`
--

CREATE TABLE `ordersplacing` (
  `order_id` int(11) NOT NULL,
  `order_date` varchar(150) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordersplacing`
--

INSERT INTO `ordersplacing` (`order_id`, `order_date`, `customer_id`) VALUES
(1, '', 101),
(1000, '', 102),
(1001, '11/03/2022', 101),
(1002, '11/03/2022', 101),
(1003, '11/03/2022', 102),
(1004, '11/03/2022', 102),
(1005, '13/03/2022', 102);

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
(1002, 100, '42'),
(1002, 101, '50'),
(1003, 100, '16'),
(1003, 101, '10'),
(1004, 100, '28'),
(1004, 101, '11'),
(1005, 101, '34'),
(10001, 100, '25'),
(10001, 101, '10');

-- --------------------------------------------------------

--
-- Table structure for table `order_rawmaterial`
--

CREATE TABLE `order_rawmaterial` (
  `order_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `order_material_total_qty` varchar(200) NOT NULL,
  `order_material_total_price` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `productdetails`
--

CREATE TABLE `productdetails` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `product_weight` varchar(200) NOT NULL,
  `product_price` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productdetails`
--

INSERT INTO `productdetails` (`product_id`, `product_name`, `product_weight`, `product_price`) VALUES
(100, 'Iron Man Cuddly Toy', '150g', '1500'),
(101, 'Racing Car Toy', '100g', '1000');

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
(100, 1, '0.5'),
(100, 2, '0.1'),
(101, 1, '0.25'),
(101, 2, '0.3');

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
(1, 'Plastic', '1', '5000', '10'),
(2, 'Fiber', '1', '6500', '5');

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
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `ordersplacing`
--
ALTER TABLE `ordersplacing`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1006;

--
-- AUTO_INCREMENT for table `productdetails`
--
ALTER TABLE `productdetails`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `rawmaterial`
--
ALTER TABLE `rawmaterial`
  MODIFY `material_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
