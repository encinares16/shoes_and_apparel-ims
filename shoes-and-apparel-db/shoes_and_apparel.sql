-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2023 at 01:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoes_and_apparel`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `categories_id` int(11) NOT NULL,
  `categories_name` varchar(50) NOT NULL,
  `categories_description` varchar(50) NOT NULL,
  `categories_archieved` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categories_id`, `categories_name`, `categories_description`, `categories_archieved`) VALUES
(1, 'Men\'s Shoes', 'footwear for men', 0),
(2, 'Women\'s Shoes', 'footwear for women', 0),
(3, 'Men\'s Apparel', 'men\'s clothing', 0),
(4, 'Women\'s Apparel', 'women\'s clothing', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_firstname` varchar(25) NOT NULL,
  `customer_lastname` varchar(25) NOT NULL,
  `customer_contact` varchar(25) NOT NULL,
  `customer_archived` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_firstname`, `customer_lastname`, `customer_contact`, `customer_archived`) VALUES
(1, 'Amparo', 'Cano', '09123456791', 0),
(2, 'Alex', 'Mendez', '09123456796', 0),
(3, 'Angel', 'Alvarez', '09123456795', 0),
(4, 'Luis', 'Romero', '09123456794', 0),
(6, 'Esther', 'Blanco', '09123456792', 0),
(7, 'Nerea', 'Hidalgo', '09123456798', 0),
(8, 'Maria', 'Gomez', '09123456790', 0),
(9, 'Rocio', 'Molina', '09123456799', 0),
(10, 'Alba', 'Bravo', '09123456797', 0),
(11, 'Juan', 'Marin', '09123456789', 0),
(12, 'Daniel', 'Moreno', '09123456789', 0),
(13, 'Marian', 'Rivero', '09123456797', 0),
(14, 'Marcus', 'Stetik', '09123456770', 0);

-- --------------------------------------------------------

--
-- Table structure for table `log_details`
--

CREATE TABLE `log_details` (
  `log_id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `date_login` varchar(50) DEFAULT NULL,
  `time_login` varchar(50) DEFAULT NULL,
  `time_logout` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log_details`
--

INSERT INTO `log_details` (`log_id`, `users_id`, `date_login`, `time_login`, `time_logout`) VALUES
(100000, 2023002, '2023-11-06', '23:43:52', '23:45:52'),
(100001, 2023001, '2023-11-11', '03:11:03', '03:13:53'),
(100003, 2023001, '2023-11-11', '04:09:01', NULL),
(100004, 2023001, '2023-11-11', '11:35:38', NULL),
(100005, 2023001, '2023-11-11', '11:35:38', '11:35:38'),
(100007, 2023003, '2023-11-11', '12:04:26', '12:11:22'),
(100008, 2023001, '2023-11-11', '12:18:51', '12:18:51'),
(100009, 2023001, '2023-11-11', '12:21:38', NULL),
(100010, 2023001, '2023-11-11', '12:21:38', '12:21:38'),
(100011, 2023003, '2023-11-11', '12:35:30', '12:35:30'),
(100012, 2023002, '2023-11-11', '12:53:56', NULL),
(100013, 2023002, '2023-11-11', '12:53:56', NULL),
(100014, 2023002, '2023-11-11', '12:53:56', '12:53:56'),
(100015, 2023002, '2023-11-11', '13:02:35', NULL),
(100016, 2023002, '2023-11-11', '13:02:35', '13:02:35'),
(100017, 2023002, '2023-11-11', '13:04:39', NULL),
(100018, 2023002, '2023-11-11', '13:04:39', NULL),
(100019, 2023002, '2023-11-11', '13:10:06', NULL),
(100020, 2023002, '2023-11-11', '13:10:06', '13:10:06'),
(100021, 2023001, '2023-11-11', '13:53:23', NULL),
(100022, 2023001, '2023-11-11', '13:53:23', '13:53:23'),
(100024, 2023001, '2023-11-11', '20:10:33', NULL),
(100025, 20230026, '2023-11-11', '21:10:25', NULL),
(100026, 20230026, '2023-11-11', '21:18:32', NULL),
(100027, 20230026, '2023-11-11', '21:18:32', '21:18:32'),
(100028, 2023001, '2023-11-11', '21:28:20', '21:28:20'),
(100029, 20230026, '2023-11-11', '21:28:20', NULL),
(100030, 20230026, '2023-11-11', '21:28:20', '21:28:20'),
(100031, 2023002, '2023-11-11', '21:34:31', NULL),
(100032, 2023002, '2023-11-11', '21:39:21', NULL),
(100033, 2023002, '2023-11-11', '21:39:21', '21:39:21'),
(100034, 2023002, '2023-11-11', '21:44:28', '21:44:28'),
(100035, 2023002, '2023-11-11', '21:52:13', NULL),
(100036, 2023002, '2023-11-11', '21:52:13', NULL),
(100037, 2023002, '2023-11-11', '21:52:13', NULL),
(100038, 2023001, '2023-11-11', '22:03:12', NULL),
(100039, 2023001, '2023-11-11', '22:03:12', NULL),
(100040, 2023001, '2023-11-11', '22:04:40', NULL),
(100041, 2023001, '2023-11-11', '22:06:03', NULL),
(100042, 2023002, '2023-11-11', '22:19:25', '22:19:25'),
(100043, 2023002, '2023-11-11', '22:21:49', NULL),
(100044, 20230027, '2023-11-10', '20:01:30', NULL),
(100045, 20230027, '2023-11-10', '20:01:30', NULL),
(100046, 20230027, '2023-11-10', '20:01:30', '20:01:30'),
(100047, 2023001, '2023-11-10', '20:01:30', NULL),
(100048, 2023001, '2023-11-10', '20:01:30', '20:01:30'),
(100049, 2023002, '2023-11-10', '20:01:30', NULL),
(100050, 2023002, '2023-11-10', '20:01:30', '20:01:30'),
(100051, 2023001, '2023-11-10', '20:21:03', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `invoice_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `order_quantity` int(11) NOT NULL,
  `order_date` datetime DEFAULT current_timestamp(),
  `invoice_manager` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`invoice_id`, `customer_id`, `product_id`, `order_quantity`, `order_date`, `invoice_manager`) VALUES
(23001, 1, 1000, 10, '2023-11-06 11:54:14', 2023001),
(23031, 14, 1000, 2, '2023-11-11 21:31:08', 20230026),
(23032, 1, 1006, 5, '2023-11-11 21:35:43', 2023002),
(23033, 2, 1006, 2, '2023-11-11 21:54:01', 2023002),
(23034, 10, 1002, 5, '2023-11-10 20:06:30', 20230027),
(23035, 11, 1013, 5, '2023-11-10 20:16:22', 2023002);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_brand` varchar(30) NOT NULL,
  `product_model` varchar(30) NOT NULL,
  `product_description` varchar(100) DEFAULT NULL,
  `product_size` int(11) NOT NULL,
  `product_category` int(11) NOT NULL,
  `product_archived` int(11) NOT NULL DEFAULT 0,
  `on_stock` int(11) NOT NULL,
  `created_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_brand`, `product_model`, `product_description`, `product_size`, `product_category`, `product_archived`, `on_stock`, `created_by`) VALUES
(1000, 'Nike', 'Nike Air Force 1 \'07', 'Original', 3, 1, 0, 23, 2023001),
(1002, 'Adidas', 'Stan Smith Shoes (White)', 'Adidas Stan Smith Shoes', 3, 1, 0, 125, 2023001),
(1006, 'Adidas', 'Stan Smith Shoes (Black)', 'Original', 4, 1, 0, 43, 2023001),
(1007, 'MNLA', 'MNL Shirt', 'MNL Original Tshirt', 1, 1, 0, 50, 2023001),
(1008, 'UnderArmour', 'SC30 Shoes 2023', 'UnderArmour Curry Shoes', 2, 3, 1, 0, 2023003),
(1009, 'Sneakers', 'SKR-2023 Shirt', 'Sneakers Shiert', 1, 1, 1, 0, 2023001),
(1010, 'Nike', 'N23-Shirt', 'Nike Women Slim Shirt', 3, 4, 1, 0, 2023001),
(1012, 'Sketcher', 'SKC-2023', 'Sketcher Girl Shoes (Pink)', 1, 2, 0, 25, 2023001),
(1013, 'Adidas', 'Adidas23', 'Adidas Shoes (White)', 3, 1, 0, 70, 2023001);

-- --------------------------------------------------------

--
-- Table structure for table `qrcode`
--

CREATE TABLE `qrcode` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `image` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `qrcode`
--

INSERT INTO `qrcode` (`id`, `username`, `filename`, `description`, `image`) VALUES
(1, 'newtestuser1', 'newtestuser1.jpg', 'test test', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000055e49444154785eed91418e23310cc4e6ff9fde456e012f8446553d416c027509e56a39fef977398e1ffe70f97eeea31fc87df403b98f7e20f7d10fe43efa81dc473f90fbe807721ffd40eea31fc87df403b98f7e20f7d10fe43efa81dc473f90fbe807721ffd40eea31fc87df403893ffacfcfcfa321f4db10fa761ac45bb9743b847e1b42df4e83782b976e87d06f43e8db69106fe5d2ed10fa6d087d3b0de2adeda5a7fd366f9e4ce7a7b4fb5fc45bdb4b4ffb6dde3c99ce4f69f7bf88b7b6979ef6dbbc79329d9fd2ee7f116f6d2f3dedb779f3643a3fa5ddff22de6a4bd35b8879c279668a9da7b710f309e2adb634bd8598279c67a6d8797a0b319f20de6a4bd35b8879c279668a9da7b710f309e2adb634bd8598279c67a6d8797a0b319f20de6a4bd35b8879c2798b61f3f416623e41bcd596a6b710f384f316c3e6e92dc47c8278ab2d4d6f21e609e72d86cdd35b88f904f1565b9ade42cc13ce5b0c9ba7b710f309e2adb634bd859837ec7cda5b88f904f1565b9ade42cc1b763eed2dc47c8278ab2d4d6f21e60d3b9ff616623e41bcd596a6b710f3869d4f7b0b319f20deda5e3addcf3e8698dfd2ee7f116f6d2f9dee671f43cc6f69f7bf88b7b6974ef7b38f21e6b7b4fb5fc45bdb4ba7fbd9c710f35bdafd2fe2ad5cba1df2b46fa741bc954bb7439ef6ed3488b772e976c8d3be9d06f1562edd0e79dab7d3a0d3fa87f04fdbe61bf9ba5bf1d1b6f946beee567cb46dbe91afbb151f6d9b6f247e2bfe690ca1678879c279866cfd9676ff8b782b9766083d43cc13ce3364ebb7b4fb5fc45bb93443e819629e709e215bbfa5ddff22decaa51942cf10f384f30cd9fa2dedfe179dd637b697b0f3e6a7b06f1a42cffc05f5af6e2f69e7cd4f61df34849ef90bea5fdd5ed2ce9b9fc2be69083df317d4bfbabda49d373f857dd3107ae62fa87f95979c86d04f3385e799293c6f69d0697d83979886d04f3385e799293c6f69d0697d83979886d04f3385e799293c6f69d0697d83979886d04f3385e799293c6f69d0697d637a89e9bc617d5b4f6c7eeb13745adf985e623a6f58dfd6139bdffa049dd637a69798ce1bd6b7f5c4e6b73e41a7f58de925a6f386f56d3db1f9ad4f106fb5a5e919c3e6b77e4bbb3f417c2bbb343d63d8fcd66f69f727886f6597a6670c9bdffa2dedfe04f1adecd2f48c61f35bbfa5dd9fe033b75ab0fdd379fee93cc1335f7990ed9fc8f34fe7099ef9ca836cff449e7f3a4ff0cc571e64fb27f2fcd37982f8577889768cf4fcd4339f407c0b5eb21d233d3ff5cc2710df82976cc748cf4f3df309c4b7e025db31d2f353cf7c02f12dda979cf673be1d42cf10f309e2adeda5a7fd9c6f87d033c47c82786b7be9693fe7db21f40c319f20deda5e7adacff976083d43cc2788b7dad2f41632f5db18d379b23dff1be25fb14bd05bc8d46f634ce7c9f6fc6f887fc52e416f2153bf8d319d27dbf3bf21fe15bb04bd854cfd36c6749e6ccfff86f857ec12f416d2f6c4e6cd93e97c83f857ed52f416d2f6c4e6cd93e97c83f857ed52f416d2f6c4e6cd93e97c83f857ed52f416d2f6c4e6cd93e97c83f857ed52f416629ed83c3d43a67e9b06f1565b9ade42cc139ba767c8d46fd320de6a4bd35b887962f3f40c99fa6d1ac45b6d697a0b314f6c9e9e2153bf4d83786b7b69eb37bf85fd0ca19fa641bcb5bdb4f59bdfc27e86d04fd320deda5edafacd6f613f43e8a769106f6d2f6dfde6b7b09f21f4d33488b772e97608bd85b4fd2710df8a976e87d05b48db7f02f1ad78e97608bd85b4fd2710df8a976e87d05b48db7f029fb9d5a5ca7df403b98f7e20f7d10fe43efa81dc473f90fbe807721ffd40eea31fc87df403b98f7e20f7d10fe43efa81dc473f90fbe807721ffd40eea31fc87df403b98f7e20f7d10fe43efa81fc07ded8a655afbdc6ae0000000049454e44ae426082),
(5, 'rmtalavera24', 'rmtalavera24.jpg', 'Rm Talavera', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000057e49444154785eed91418e23310cc4f2ff4fef22b7010f2134ae720f6213e0a54b96add6ebdfe5385efc70f97eeed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40eed20fe42efd40e24b7fbd5e5b35d2f5ccdb368877e5a3db1ae97ae66d1bc4bbf2d16d8d743df3b60de25df9e8b646ba9e79db06f1aeed475b7fcb49bb7e4abbff9b78d7f6a3adbfe5a45d3fa5ddff4dbc6bfbd1d6df72d2ae9fd2eeff26deb5fd68eb6f3969d74f69f77f13ef6a8f666e12cbc9b4deb07ecc4d62798278577b347393584ea6f586f5636e12cb13c4bbdaa3999bc47232ad37ac1f7393589e20ded51ecddc24969369bd61fd989bc4f204f1aef668e62659cd49ba9eb9492c4f10ef6a8f666e92d59ca4eb999bc4f204f1aef668e62659cd49ba9eb9492c4f10ef6a8f666e92d59ca4eb999bc4f204f1aef668e626b1dce079934c7393589e20ded51ecddc24961b3c6f92696e12cb13c4bbdaa3999bc47283e74d32cd4d62798278577b347393586ef0bc49a6b9492c4f10efda7eb4f5676e92d57c9576ff37f1aeed475b7fe62659cd5769f77f13efda7eb4f5676e92d57c9576ff37f1aeed475b7fe62659cd5769f77f13efca47b725bbf3b60de25df9e8b66477deb641bc2b1fdd96eccedb368877e5a3db92dd79db069dae7f18fe54f31bf9cea93ec0a59adfc8774ef5012ed5fc46be73aa0f70a9e637129f8a3f6d55c27caac17a4ada7983f82d1c6255c27caac17a4ada7983f82d1c6255c27caac17a4ada7983f82d1c6255c27caac17a4ada79833db7fc603aa4d533a753789e12e6a631adff0d9dae1f980e65f5cce9149ea784b9694ceb7f43a7eb07a643593d733a85e729616e1ad3fadfd0e9fa81e95056cf9c4ee1794a989bc6b4fe37c4bbdaa3db3961bd492c3778dedc41fc161ba29d13d69bc47283e7cd1dc46fb121da3961bd492c3778dedc41fc161ba29d13d69bc47283e7cd1decb9e5073624734a98536239b17ae65389e5093a5d3f604331a78439259613ab673e95589ea0d3f5033614734a98536239b17ae65389e5093a5d3f604331a78439259613ab673e95589ea0d3750087a484f95432cda931addfc1e3afe04fa184f95432cda931addfc1e3afe04fa184f95432cda931addfc1e3afe04fa184f95432cda931addfc1df784590d59f9c3ebf6a834ed70759fd69e9f3ab36e8747d90d59f963ebf6a834ed70759fd69e9f3ab368877e5a3db12e6d4b07acb0d9ea73b88dfc221da12e6d4b07acb0d9ea73b88dfc221da12e6d4b07acb0d9ea73b88dfc221da12e6d4b07acb0d9ea73b88dfd21e62777f3a85e7e913c46f6d0fb5bb3f9dc2f3f409e2b7b687dadd9f4ee179fa04f15bdb43edee4fa7f03c7d82f8ad361473934c734a9853c29c4ee179da20ded51ecddc24d39c12e69430a753789e368877b5473337c934a7843925cce9149ea70de25dedd1cc4d32cd29614e09733a85e7698378577b347393ace6645a4f789e12cb7710bfd586626e92d59c4ceb09cf5362f90ee2b7da50cc4db29a93693de1794a2cdf41fc561b8ab949567332ad273c4f89e53b88df6a433137c934a706ebe9149ea74f10bfd586626e92694e0dd6d3293c4f9f207eab0dc5dc24d39c1aaca753789e3e41fc561b8ab949a63935584fa7f03c7d82f8adeda1ac3f739ac6fa33a74f10bfb53d94f5674ed3587fe6f409e2b7b687b2fecc691aebcf9c3e41fcd6f650d69f394d63fd99d32788dfcaa1da12e6d460bd492c27d3fa04f15b38445bc29c1aac3789e5645a9f207e0b87684b985383f526b19c4ceb13c46fe1106d09736ab0de249693697d823db75cfe1477e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e2077e90772977e20ff01059665a4bcfe18260000000049454e44ae426082),
(7, 'encinares', 'encinares.jpg', 'Jerome Talavera', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000059449444154785eed91416e6b390c0473ff4bcfc0bba010a0d256d3feb158406ddc7c2dcafafa6fb98e2ffeb07c3efbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21f547fffafa7aa986cd33a784f9b413d45bb9f4b486cd33a784f9b413d45bb9f4b486cd33a784f9b413d45bb9f4b486cd33a784f9b413d45ba797b67ee694584ed2f994e9fe07f5d6e9a5ad9f39259693743e65baff41bd757a69eb674e89e5249d4f99ee7f506f9d5edafa9953623949e753a6fb1fd45b6d69e62649736ad87c9a9bc4f206f5565b9ab949d29c1a369fe626b1bc41bdd596666e9234a786cda7b9492c6f506fb5a5999b24cda961f3696e12cb1bd45b6d69e626b19cd8bce5c4e6999bc4f206f5565b9ab9492c27366f39b179e626b1bc41bdd596666e12cb89cd5b4e6c9eb9492c6f506fb5a5999bc47262f396139b676e12cb1bd45b6d69e62639cd0dfb3ecd4d6279837aab2dcddc24a7b961dfa7b9492c6f506fb5a5999be43437ecfb343789e50deaadb63473939ce6867d9fe626b1bc41bd757a69ebb79c709e12cb4f99ee7f506f9d5edafa2d279ca7c4f253a6fb1fd45ba797b67ecb09e729b1fc94e9fe07f5d6e9a5addf72c2794a2c3f65baff41bd954b4f4b5e9d4f3b41bd954b4f4b5e9d4f3b41bd954b4f4b5e9d4f3b41bd954b4f4b5e9d4f3bc14ceb1be19f76ea27f271b7e2a39dfa897cdcadf868a77e221f772b3edaa99f48fd56fcd328b19c709e12e63485df9b84397d05f55378094a2c279ca784394de1f726614e5f41fd145e8212cb09e729614e53f8bd4998d357503f8597a0c472c2794a98d3147e6f12e6f415d44fe1254cc29c12cba7e1f994303727a8b772699330a7c4f269783e25cccd09eaad5cda24cc29b17c1a9e4f097373827a2b973609734a2c9f86e753c2dc9c60a6f51bbc044de1f7668a7dcf9c9ed2eefb8999d66ff0123485df9b29f63d737a4abbef27665abfc14bd0147e6fa6d8f7cce929edbe9f9869fd062f4153f8bd9962df33a7a7b4fb7ea2de9a2e6df3694e8dd3f954239d7f867a6bbab4cda739354ee7538d74fe19eaade9d2369fe6d4389d4f35d2f967a8b7a64bdb7c9a53e3743ed548e79fa1de6a4b333709f35309736a9cced309eaadb6347393303f9530a7c6e93c9da0de6a4b333709f35309736a9cced309eaadb6347393303f9530a7c6e93c9d60a6f58dd89fc69cb649fbd3f96798697d23f6a731a76dd2fe74fe19665adf88fd69cc699bb43f9d7f8699d637627f1a73da26ed4fe79fa1decaa5a72596a7b02fd548e71bd44fe125a62596a7b02fd548e71bd44fe125a62596a7b02fd548e71bd44fe125a62596a7b02fd548e71bd44f99be44dacff9533f81fa2da6ffa4b49ff3a77e02f55b4cff49693fe74ffd04eab798fe93d27ece9ffa09d46f617f127393589e627dcce929edbedf503fc52ec1dc2496a7581f737a4abbef37d44fb14b303789e529d6c79c9ed2eefb0df553ec12cc4d62798af531a7a7b4fb7e43fd14bb047393a4796a0abfa784b93941bdd596666e92344f4de1f794303727a8b7dad2cc4d92e6a929fc9e12e6e604f5565b9ab949d23c3585df53c2dc9ca0de6a4b333789e584f394584e389f4a2c6f506fb5a5999bc472c2794a2c279c4f259637a8b7dad2cc4d6239e13c259613cea712cb1bd45b6d69e626b19c709e12cb09e75389e50deaadd34b5bbfe529ec33ff02f52da7ff04ebb73c857de65fa0bee5f49f60fd96a7b0cffc0bd4b79cfe13acdff214f6997f81fa96fc13a625696e1a367f9a4f503f85979896a4b969d8fc693e41fd145e625a92e6a661f3a7f904f553788969499a9b86cd9fe613bce694e59f621ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12f641ffd42f6d12fe47f9adda655192654ba0000000049454e44ae426082),
(11, 'ryanbangs', 'ryanbangs.jpg', 'Ryan Bang', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000056549444154785eed914b8e63310cc472ff4bcf20bb06378ca092f3b1087093d22bcbf1e3df721d0ffeb0fc3efbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21fbe817b28f7e21f1477f3c1e4725d5dc24cca79d20decaa5a725d5dc24cca79d20decaa5a725d5dc24cca79d20decaa5a725d5dc24cca79d20de3abd74b79fdf53a33a5f65baff49bc757ae96e3fbfa74675beca74ff9378ebf4d2dd7e7e4f8dea7c95e9fe27f1d6e9a5bbfdfc9e1ad5f92ad3fd4fe2adb634739354734a2c2736cfdc24962788b7dad2cc4d52cd29b19cd83c7393589e20de6a4b33374935a7c47262f3cc4d62798278ab2dcddc24d59c12cb89cd333789e509e2adb634739354736ad87c353789e509e2adb634739354736ad87c353789e509e2adb634739354736ad87c353789e509e2adb634739354736ad87c353789e509e2adb63473937473929e676e12cb13c45b6d69e626e9e6243dcfdc24962788b7dad2cc4dd2cd497a9eb9492c4f106fb5a5999ba49b93f43c7393589e20de3abd74b59ff35589e55da6fb9fc45ba797aef673be2ab1bccb74ff9378ebf4d2d57ece5725967799ee7f126f9d5ebadacff9aac4f22ed3fd4fe2ad5c7a5a723a9f7682782b979e969ccea79d20decaa5a725a7f3692788b772e969c9e97cda09665abf08fec9f417f9cd5b15e023d35fe4376f55808f4c7f91dfbc55013e32fd45e2b7e29f56d5b079e6690dce9bc4f204f1562e5dd5b079e6690dce9bc4f204f1562e5dd5b079e6690dce9bc4f204f1562e5dd5b079e6690dce9bc4f204f1562e4dabd8f7cca9c1799330a706e7e904f1562e4dabd8f7cca9c1799330a706e7e904f1562e4dabd8f7cca9c1799330a706e7e904f1562e4dabd8f7cca9c1799330a706e7e90433ad7fa85ec2e6995725d3b9c1efe90433ad7fa85ec2e6995725d3b9c1efe90433ad7fa85ec2e6995725d3b9c1efe90433ad7fa85ec2e6995725d3b9c1efe904f1d6ead29ca75daccff22ed6cf9c4e106fad2ecd79dac5fa2cef62fdcce904f1d6ead29ca75daccff22ed6cf9c4e106fad2ecd79dac5fa2cef62fdcce904f1565b9a7957a33b6f12cb3f81f8567669e65d8deebc492cff04e25bd9a5997735baf326b1fc13886f659766ded5e8ce9bc4f24fe033b76a50fdd3d3f3cc29b17c8233a71ca4fa27a6e7995362f904674e3948f54f4ccf33a7c4f209ce9c7290ea9f989e674e89e513c44fe125a6356c9e3925ccab7e02f12d78c9690d9b674e09f3aa9f407c0b5e725ac3e69953c2bcea2710df82979cd6b079e69430affa09c4b798be64b7bffb7d159e679e207ecaf425bafdddefabf03cf304f153a62fd1edef7e5f85e79927889f327d896e7ff7fb2a3ccf3c41fc14bb047393584e384f4937279ca7ef207eaa5d8ab9492c279ca7a49b13ced377103fd52ec5dc249613ce53d2cd09e7e93b889f6a97626e12cb09e729e9e684f3f41dc44fb54b3137493aa74677de3c41fc14bb047393a4736a74e7cd13c44fb14b3037493aa74677de3c41fc14bb047393a4736a74e7cd13c44fb14b30374935a786cd5bfe0dc4b7b63f85b949aa39356cdef26f20beb5fd29cc4d52cda961f3967f03f1aded4f616e926a4e0d9bb7fc1b886f3dfda7587f3727d3f3a4fbfd2bc45ba797b6fe6e4ea6e749f7fb5788b74e2f6dfddd9c4ccf93eef7af106f9d5edafabb39999e27ddef5f21decaa5a7259657a9f6d9bce527889fca4b4d4b2caf52edb379cb4f103f95979a96585ea5da67f3969f207e2a2f352db1bc4ab5cfe62d3fc17b4e5ddeca3efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc87f731dc544a54e54be0000000049454e44ae426082),
(12, 'jdc25', 'jdc25.jpg', 'null null', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000057449444154785eed91416e1c3110c4fcff4f27d85b401b201aaa9acd5a4d8017b3b7a5b1befe2cd7f1c53f2cbf9f7df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf90f8a37f7d7d3dea14fede24ec6d1bc4b7f2d26da7f0f726616fdb20be95976e3b85bf37097bdb06f1adbc74db29fcbd49d8db36886f6d5fdaf6b39be4b49fd2deff22beb57d69dbcf6e92d37e4a7bff8bf8d6f6a56d3fbb494efb29edfd2fe25bdb97b6fdec2639eda7b4f7bf886fb54bb39bc4bac1df9b64da4d623d417cab5d9add24d60dfede24d36e12eb09e25bedd2ec26b16ef0f726997693584f10df6a976637897583bf37c9b49bc47a82f856bb34bb49a69d1a363fed26b19e20bed52ecd6e9269a786cd4fbb49ac27886fb54bb39b64daa961f3d36e12eb09e25bedd2ec2699766ad8fcb49bc47a82f856bb34bb49ac93f4fcb49bc47a82f856bb34bb49ac93f4fcb49bc47a82f856bb34bb49ac93f4fcb49bc47a82f856bb34bb49ac93f4fcb49bc47a82f8d6f6a56dbf75d29e9fd2deff22beb57d69db6f9db4e7a7b4f7bf886f6d5fdaf65b27edf929edfd2fe25bdb97b6fdd6497b7e4a7bff8bf8565eba2d79bab76d10dfca4bb7254ff7b60de25b79e9b6e4e9deb6417c2b2fdd963cdddb36e86cfd8f78e29ff869fcfaffc23efa777efd7f611ffd3bbffebfb08ffe9df87f81ffe45309bb69d8fcbb7b83f829fc885309bb69d8fcbb7b83f829fc885309bb69d8fcbb7b83f829fc885309bb69d8fcbb7b83f829fc0893b05392ee530dce53623d417c2b2f6d12764ad27daac1794aac27886fe5a54dc24e49ba4f35384f89f504f1adbcb449d82949f7a906e729b19ea0b3f51fec23a67dea14fb3d3b35384f9fa07e8a7dd4b44f9d62bf67a706e7e913d44fb18f9af6a953ecf7ecd4e03c7d82fa29f651d33e758afd9e9d1a9ca74f103f851f6112764ad8a9c1f9a906e729b19e20be959736093b25ecd4e0fc5483f394584f10dfca4b9b849d12766a707eaac1794aac27886fe5a54dc24e093b35383fd5e03c25d613c4b7f2d22699766ad8bc75329d37d2fb7e22be959736c9b453c3e6ad93e9bc91def713f1adbcb449a69d1a366f9d4ce78df4be9f886fe5a54d32edd4b079eb643a6fa4f7fd4467eb1be13fcd24d6497ade7a82ced637c27f9a49ac93f4bcf5049dad6f84ff34935827e979eb093a5bdf08ff6926b14ed2f3d613c4b7f2d26dc9b453629d709e12eb0de2a7f023da9269a7c43ae13c25d61bc44fe147b425d34e8975c2794aac37889fc28f684ba69d12eb84f394586f103fa5fd11d3fd9ca7a7701f25ecf409e2a7b43f62ba9ff3f414eea3849d3e41fc94f6474cf7739e9ec27d94b0d327889fd2fe88e97eced353b88f1276fa04f153ec23d84d32ed949c76c2794aac37889f621fc16e9269a7e4b413ce5362bd41fc14fb0876934c3b25a79d709e12eb0de2a7d847b09b64da2939ed84f394586f103fc53e82dd24e99ed698ce37889f6a1fc56e92744f6b4ce71bc44fb58f623749baa735a6f30de2a7da47b19b24ddd31ad3f906f153eda3d84d32edd4b07976fa09c46f69ff0476934c3b356c9e9d7e02f15bda3f81dd24d34e0d9b67a79f40fc96f64f6037c9b453c3e6d9e92710bf65fb9f60fbd929619f3ae5f4f709e2a7b63fcaf6b353c23e75cae9ef13c44f6d7f94ed67a7847dea94d3df27889fdafe28dbcf4e09fbd429a7bf4f103f951fd596b053633a6fd83eeb0de2a7f023da12766a4ce70ddb67bd41fc147e445bc24e8de9bc61fbac37889fc28f684bd8a9319d376c9ff506cf9cb2fc57eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85eca35fc83efa85fc05afa287663aecd4050000000049454e44ae426082),
(13, 'danielpadilla', 'danielpadilla.jpg', 'Daniel Padilla', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000059e49444154785eed91418e2b390cc5fefd2f3d836cb90821f8bdaa462c02dc3465c5d5fef7df721dfff887e5f7d947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40b893ffabf7fff1ed5b079764ad8db36886fe5a5db1a36cf4e097bdb06f1adbc745bc3e6d929616fdb20be95976e6bd83c3b25ec6d1bc4b7b62f6dfbd929b14ea6f353dafb3fc4b7b62f6dfbd929b14ea6f353dafb3fc4b7b62f6dfbd929b14ea6f353dafb3fc4b7b62f6dfbd929b14ea6f353dafb3fc4b7daa5d94d32edd4b0f9693789f504f1ad766976934c3b356c7eda4d623d417cab5d9add24d34e0d9b9f7693584f10df6a976637c9b453c3e6a7dd24d613c4b7daa5d94d629dd8bc7562f3ec26b19e20bed52ecd6e12ebc4e6ad139b673789f504f1ad766976935827366f9dd83cbb49ac27886fb54bb39bc43ab179ebc4e6d94d623d417cab5d9add24a7ddb0f3d36e12eb09e25bedd2ec2639ed869d9f7693584f10df6a976637c96937ecfcb49bc47a82f856bb34bb494ebb61e7a7dd24d613c4b7b62f6dfbad13ce5362fd94f6fe0ff1aded4bdb7eeb84f394583fa5bdff437c6bfbd2b6df3ae13c25d64f69efff10dfdabeb4edb74e384f89f553dafb3fc4b7f2d26dc9d3bd6d83f8565eba2d79bab76d10dfca4bb7254ff7b60de25b79e9b6e4e9deb64167eb8bf09f76ea2ff2735fc5473bf517f9b9afe2a39dfa8bfcdc57f1d14efd45e25fc57f1a25d609e72961a75378de24ecf409e2bfc28fa0c43ae13c25ec740acf9b849d3e41fc57f8119458279ca7849d4ee17993b0d32788ff0a3f8212eb84f394b0d3293c6f1276fa04f15fb18f98763a85e74d32ed2661a70de25bedd2d34ea7f0bc49a6dd24ecb4417cab5d7adae9149e37c9b49b849d36886fb54b4f3b9dc2f326997693b0d3069dad5fe04799849d1a363fed94b053623d4167eb17f8512661a786cd4f3b25ec94584fd0d9fa057e9449d8a961f3d34e093b25d61374b67e811f6512766ad8fcb453c24e89f504f1adbcb449ac13ce53c24e0dce5332edb4417c2b2f6d12eb84f394b05383f3944c3b6d10dfca4b9bc43ae13c25ecd4e03c25d34e1bc4b7f2d226b14e384f093b35384fc9b4d3069dad5fb08f6237a7d879ebc6f43ce76983ced62fd847b19b53ecbc75637a9ef3b44167eb17eca3d8cd2976deba313dcf79daa0b3f50bf651ece6143b6fdd989ee73c6dd0d9fa22fca751c26e9e62fbac27e86c7d11fed32861374fb17dd61374b6be08ff6994b09ba7d83eeb093a5b5f84ff344ad8cd536c9ff504f1adbc745b62dd989ee7bc49ac3788ff0a3fa22db16e4ccf73de24d61bc47f851fd1965837a6e7396f12eb0de2bfc28f684bac1bd3f39c3789f506f15f697fc474bfcd5b374ecfbf41fc96ed7fc274bfcd5b374ecfbf41fc96ed7fc274bfcd5b374ecfbf41fc96ed7fc274bfcd5b374ecfbf41fc96f64f6037897583e7299976fa1789dfca3e9add24d60d9ea764dae95f247e2bfb6876935837789e9269a77f91f8adeca3d94d62dde0794aa69dfe45e2b7b28f6637c9d39d12764ad8cd06f1ad766976933cdd2961a784dd6c10df6a976637c9d39d12764ad8cd06f1ad766976933cdd2961a784dd6c10df6a976637897562f3ec4f4bac27886fb54bb39bc43ab179f6a725d613c4b7daa5d94d629dd83cfbd312eb09e25bedd2ec26b14e6c9efd6989f504f1aded4bdb7e764a4e3b99cebf41fc56ed8fb6fdec949c76329d7f83f8adda1f6dfbd92939ed643aff06f15bb53fdaf6b35372dac974fe0de2b7e247b725a7dde0f9a9c47a83f8aff023da92d36ef0fc5462bd41fc57f8116dc96937787e2ab1de20fe2bfc88b6e4b41b3c3f95586ff0ccaf2c7f8a7df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf907df40bd947bf90ff01abee8766b61ac4da0000000049454e44ae426082),
(14, 'encinares16', 'encinares16.jpg', 'Jerome Encinares', 0x89504e470d0a1a0a0000000d494844520000007d0000007d08060000008f806c250000057149444154785eed9141aeeb3810c472ff4bcf20bb801bbeb2aaedfc4804b849b5caade8f5df613b5efce1f0fb9c47df90f3e81b721e7d43cea36fc879f40d398fbe21e7d137e43cfa869c47df90f3e81b721e7d43cea36fc879f40d398fbe21e7d137e43cfa869c47df90f3e81b527ff4d7eb75ab24cd4dc27cda09eaad5c7a5a92e626613eed04f5562e3d2d497393309f76827a2b979e96a4b949984f3b41bd757ae9d57e9ea7463a9f32ddffa6de3abdf46a3fcf53239d4f99ee7f536f9d5e7ab59fe7a991cea74cf7bfa9b74e2fbddacff3d448e753a6fbdfd45b6d69e62649734a2c2736cfdc249637a8b7dad2cc4d92e694584e6c9eb9492c6f506fb5a5999b24cd29b19cd83c739358dea0de6a4b3337499a536239b179e626b1bc41bdd596666e9234a786cda7b9492c6f506fb5a5999b24cda961f3696e12cb1bd45b6d69e62649736ad87c9a9bc4f206f5565b9ab949d29c1a369fe626b1bc41bdd596666e92d59cb4e7999bc4f206f5565b9ab9495673d29e676e12cb1bd45b6d69e62659cd497b9eb9492c6f506fb5a5999b643527ed79e626b1bc41bd757ae9b49ff3a9c4f255a6fbdfd45ba7974efb399f4a2c5f65baff4dbd757ae9b49ff3a9c4f255a6fbdfd45ba7974efb399f4a2c5f65baff4dbd954b4f4beecea79da0decaa5a72577e7d34e506fe5d2d392bbf36927a8b772e969c9ddf9b413ccb4fe43f04fa6bfc86fde2a808f4c7f91dfbc55001f99fe22bf79ab003e32fd45eab7e29f966ad83cf3b606e74d6279837a2b974e356c9e795b83f326b1bc41bd954ba71a36cfbcadc1799358dea0decaa5530d9b67ded6e0bc492c6f30d3fa417a89749ea4e7396f12e6a691ce5f61a6f583f412e93c49cf73de24cc4d239dbfc24ceb07e925d279929ee7bc49989b463a7f8599d60fd24ba4f3243dcf799330378d74fe0a33ad1ff012a661f3cc53097393304f9d60a6f5035ec2346c9e792a616e12e6a913ccb47ec04b9886cd334f25cc4dc23c758299d60f7809d3b079e6a984b94998a74e506fe5d2a9c472c2f9d436d3fd57a86fc14ba612cb09e753db4cf75fa1be052f994a2c279c4f6d33dd7f85fa16bc642ab19c703eb5cd74ff15ea5b4c5f92fd660acfa7a6ac9ebf42fd2bd39760bf99c2f3a929abe7af50ffcaf425d86fa6f07c6acaeaf92bd4bf327d09f69b293c9f9ab27afe0af77ce546d23f71753ef51bf88e2d8aa47ff2ea7cea37f01d5b1449ffe4d5f9d46fe03bb62892fec9abf3a9df407d0b5e72da149e3709f3559fa0fe555e6ada149e3709f3559fa0fe555e6ada149e3709f3559fa0fe555e6ada149e3709f3559fa0fed5e94ba5fde97c1b7e3f75827aebf4d2697f3adf86df4f9da0de3abd74da9fceb7e1f75327a8b74e2f9df6a7f36df8fdd409eaadb6347393586ed879e63485e7e913d4bf6a97626e12cb0d3bcf9ca6f03c7d82fa57ed52cc4d62b961e799d3149ea74f50ffaa5d8ab9492c37ec3c739ac2f3f409ea5fb54b3137499a9b463a6fb08fde41fd2b7609e6264973d348e70df6d13ba87fc52ec1dc24696e1ae9bcc13e7a07f5afd825989b24cd4d239d37d847efa0fe15bb047393a4b94998d3149ea74f50ffaa5d8ab949d2dc24cc690acfd327a87fd52ec5dc24696e12e63485e7e913d4bf6a97626e92343709739ac2f3f409ea5f9dbe94f5335f95ace6c6eaf9bf506f9d5edafa99af4a567363f5fc5fa8b74e2f6dfdcc5725abb9b17afe2fd45ba797b67ee6ab92d5dc583dff17eaad5c7a5a92e6d4e03c35d2f909ea5fe5a5a625694e0dce53239d9fa0fe555e6a5a92e6d4e03c35d2f909ea5fe5a5a625694e0dce53239d9fe099af1e1ee53cfa869c47df90f3e81b721e7d43cea36fc879f40d398fbe21e7d137e43cfa869c47df90f3e81b721e7d43cea36fc879f40d398fbe21e7d137e43cfa869c47df90f3e81b721e7d43fe071068e70696314a230000000049454e44ae426082);

-- --------------------------------------------------------

--
-- Table structure for table `restock_details`
--

CREATE TABLE `restock_details` (
  `restock_id` int(11) NOT NULL,
  `restock_product_id` int(11) NOT NULL,
  `on_stock_before` int(11) NOT NULL,
  `restock_quantity` int(11) NOT NULL,
  `on_stock_after` int(11) NOT NULL,
  `restock_date` varchar(25) NOT NULL,
  `restock_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `restock_details`
--

INSERT INTO `restock_details` (`restock_id`, `restock_product_id`, `on_stock_before`, `restock_quantity`, `on_stock_after`, `restock_date`, `restock_by`) VALUES
(202310001, 1002, 0, 100, 100, '2023-11-11', 2023001),
(202310008, 1000, 0, 25, 25, '2023-11-11', 2023001),
(202310009, 1002, 100, 25, 125, '2023-11-11', 2023003),
(202310010, 1002, 125, 5, 130, '2023-11-11', 2023001),
(202310011, 1006, 0, 50, 50, '2023-11-11', 2023001),
(202310012, 1007, 0, 50, 50, '2023-11-10', 2023001),
(202310013, 1012, 0, 25, 25, '2023-11-10', 2023001),
(202310014, 1013, 0, 50, 50, '2023-11-10', 2023001),
(202310015, 1013, 50, 25, 75, '2023-11-10', 2023001);

-- --------------------------------------------------------

--
-- Table structure for table `sizes`
--

CREATE TABLE `sizes` (
  `sizes_id` int(11) NOT NULL,
  `sizes_type` varchar(5) NOT NULL,
  `sizes_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sizes`
--

INSERT INTO `sizes` (`sizes_id`, `sizes_type`, `sizes_name`) VALUES
(1, 'XS', 'Extra Small'),
(2, 'S', 'Small'),
(3, 'M', 'Medium'),
(4, 'L', 'Large'),
(5, 'XL', 'Extra Large');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_firstname` varchar(30) NOT NULL,
  `user_lastname` varchar(30) NOT NULL,
  `user_birthday` varchar(25) NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_gender` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_contact` varchar(12) DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT 0,
  `created_At` varchar(30) NOT NULL,
  `user_archived` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_firstname`, `user_lastname`, `user_birthday`, `user_age`, `user_gender`, `username`, `password`, `user_email`, `user_contact`, `role`, `created_At`, `user_archived`) VALUES
(2023001, 'Jerome', 'Encinares', 'January 15, 1998', 25, 'Male', 'encinares16', '2546admin', 'encinares16@gmail.com', '09510515930', 1, '2023-11-05 05:25:22', 0),
(2023002, 'Juan', 'Dela Cruz', 'January 12, 1997', 26, 'Male', 'jdc25', 'jdelacruz123', 'juandelacruz@gmail.com', '09123456770', 0, '2023-11-06 19:21:13', 0),
(2023003, 'Rm', 'Talavera', 'January 16, 1998', 25, 'Male', 'admin', 'admin123', 'admin1@gmail.com', '09123456789', 1, '2023-11-06 19:21:13', 0),
(2023004, 'Whamos', 'Cute', 'December 8, 1990', 32, 'Male', 'whamos', 'whamoscute', 'whamos@gmail.com', '09123456782', 0, '2023-11-08 08:37:37', 1),
(20230023, 'Rm', 'Talavera', 'January 15, 1998', 25, 'Male', 'rmtalavera24', 'rm123', 'rm.talavera@gmail.com', '09932711647', 0, '2023-11-11 04:09:01', 0),
(20230026, 'Ryan', 'Bangs', 'January 15, 1995', 28, 'Male', 'ryanbangs', 'ryanbang12345', 'ryan.bang@gmail.com', '09123456781', 0, '2023-11-11 21:10:25', 0),
(20230027, 'Daniel', 'Padilla', 'May 25, 1995', 28, 'Male', 'danielpadilla', 'daniel123', 'daniel.padilla@gmail.com', '0912345673', 0, '2023-11-10 20:01:30', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categories_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `log_details`
--
ALTER TABLE `log_details`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `logdetails_users_fk` (`users_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `invoiced_users_fk` (`invoice_manager`),
  ADD KEY `invoiced_products_fk` (`product_id`),
  ADD KEY `invoiced_customers_fk` (`customer_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `products_categories_fk` (`product_category`),
  ADD KEY `products_sizes_fk` (`product_size`),
  ADD KEY `products_users_fk` (`created_by`);

--
-- Indexes for table `qrcode`
--
ALTER TABLE `qrcode`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restock_details`
--
ALTER TABLE `restock_details`
  ADD PRIMARY KEY (`restock_id`),
  ADD KEY `restock_details_product_fk` (`restock_product_id`),
  ADD KEY `restock_details_users_fk` (`restock_by`);

--
-- Indexes for table `sizes`
--
ALTER TABLE `sizes`
  ADD PRIMARY KEY (`sizes_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `user_email` (`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `categories_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `log_details`
--
ALTER TABLE `log_details`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100052;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23036;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1014;

--
-- AUTO_INCREMENT for table `qrcode`
--
ALTER TABLE `qrcode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `restock_details`
--
ALTER TABLE `restock_details`
  MODIFY `restock_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202310016;

--
-- AUTO_INCREMENT for table `sizes`
--
ALTER TABLE `sizes`
  MODIFY `sizes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20230028;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `log_details`
--
ALTER TABLE `log_details`
  ADD CONSTRAINT `logdetails_users_fk` FOREIGN KEY (`users_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `invoiced_customers_fk` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `invoiced_products_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `invoiced_users_fk` FOREIGN KEY (`invoice_manager`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_categories_fk` FOREIGN KEY (`product_category`) REFERENCES `categories` (`categories_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `products_sizes_fk` FOREIGN KEY (`product_size`) REFERENCES `sizes` (`sizes_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `products_users_fk` FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE;

--
-- Constraints for table `restock_details`
--
ALTER TABLE `restock_details`
  ADD CONSTRAINT `restock_details_product_fk` FOREIGN KEY (`restock_product_id`) REFERENCES `products` (`product_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `restock_details_users_fk` FOREIGN KEY (`restock_by`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
