DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '類別Id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父類別id當id=0時說明是根節點,一級類別',
  `name` varchar(50) DEFAULT NULL COMMENT '類別名稱',
  `status` tinyint(1) DEFAULT '1' COMMENT '類別狀態1-正常,2-停用',
  `sort_order` int(4) DEFAULT NULL COMMENT '排序編號,同類展示順序,數值相等則自然排序',
  `create_time` datetime DEFAULT NULL COMMENT '建立時間',
  `update_time` datetime DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `mall_category` (`id`, `parent_id`, `name`, `status`, `sort_order`, `create_time`, `update_time`)
VALUES
	(100001,0,'家用電器',1,NULL,'2021-03-25 16:46:00','2021-03-25 16:46:00'),
	(100002,0,'數位3C',1,NULL,'2021-03-25 16:46:21','2021-03-25 16:46:21'),
	(100003,0,'服裝箱包',1,NULL,'2021-03-25 16:49:53','2021-03-25 16:49:53'),
	(100004,0,'食品生鮮',1,NULL,'2021-03-25 16:50:19','2021-03-25 16:50:19'),
	(100005,0,'酒水飲料',1,NULL,'2021-03-25 16:50:29','2021-03-25 16:50:29'),
	(100006,100001,'冰箱',1,NULL,'2021-03-25 16:52:15','2021-03-25 16:52:15'),
	(100007,100001,'電視',1,NULL,'2021-03-25 16:52:26','2021-03-25 16:52:26'),
	(100008,100001,'洗衣機',1,NULL,'2021-03-25 16:52:39','2021-03-25 16:52:39'),
	(100009,100001,'空調',1,NULL,'2021-03-25 16:52:45','2021-03-25 16:52:45'),
	(100010,100001,'電熱水器',1,NULL,'2021-03-25 16:52:54','2021-03-25 16:52:54'),
	(100011,100002,'電腦',1,NULL,'2021-03-25 16:53:18','2021-03-25 16:53:18'),
	(100012,100002,'手機',1,NULL,'2021-03-25 16:53:27','2021-03-25 16:53:27'),
	(100013,100002,'平板電腦',1,NULL,'2021-03-25 16:53:35','2021-03-25 16:53:35'),
	(100014,100002,'數位相機',1,NULL,'2021-03-25 16:53:56','2021-03-25 16:53:56'),
	(100015,100002,'3C配件',1,NULL,'2021-03-25 16:54:07','2021-03-25 16:54:07'),
	(100016,100003,'女裝',1,NULL,'2021-03-25 16:54:44','2021-03-25 16:54:44'),
	(100017,100003,'帽子',1,NULL,'2021-03-25 16:54:51','2021-03-25 16:54:51'),
	(100018,100003,'旅行箱',1,NULL,'2021-03-25 16:55:02','2021-03-25 16:55:02'),
	(100019,100003,'手提包',1,NULL,'2021-03-25 16:55:09','2021-03-25 16:55:09'),
	(100020,100003,'保暖內衣',1,NULL,'2021-03-25 16:55:18','2021-03-25 16:55:18'),
	(100021,100004,'零食',1,NULL,'2021-03-25 16:55:30','2021-03-25 16:55:30'),
	(100022,100004,'生鮮',1,NULL,'2021-03-25 16:55:37','2021-03-25 16:55:37'),
	(100023,100004,'半成品菜',1,NULL,'2021-03-25 16:55:47','2021-03-25 16:55:47'),
	(100024,100004,'速凍食品',1,NULL,'2021-03-25 16:55:56','2021-03-25 16:55:56'),
	(100025,100004,'進口食品',1,NULL,'2021-03-25 16:56:06','2021-03-25 16:56:06'),
	(100026,100005,'白酒',1,NULL,'2021-03-25 16:56:22','2021-03-25 16:56:22'),
	(100027,100005,'紅酒',1,NULL,'2021-03-25 16:56:30','2021-03-25 16:56:30'),
	(100028,100005,'飲料',1,NULL,'2021-03-25 16:56:37','2021-03-25 16:56:37'),
	(100029,100005,'調制雞尾酒',1,NULL,'2021-03-25 16:56:45','2021-03-25 16:56:45'),
	(100030,100005,'進口洋酒',1,NULL,'2021-03-25 16:57:05','2021-03-25 16:57:05');


DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '訂單id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '訂單號',
  `user_id` int(11) DEFAULT NULL COMMENT '用戶id',
  `shipping_id` int(11) DEFAULT NULL,
  `payment` decimal(20,2) DEFAULT NULL COMMENT '實際付款金額,單位是元,保留兩位小數',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付類型,1-在線支付',
  `postage` int(10) DEFAULT NULL COMMENT '運費,單位是元',
  `status` int(10) DEFAULT NULL COMMENT '訂單狀態:0-已取消，10-未付款，20-已付款，40-已發貨，50-交易成功，60-交易關閉',
  `payment_time` datetime DEFAULT NULL COMMENT '支付時間',
  `send_time` datetime DEFAULT NULL COMMENT '發貨時間',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成時間',
  `close_time` datetime DEFAULT NULL COMMENT '交易關閉時間',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mall_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '訂單子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '商品名稱',
  `product_image` varchar(500) DEFAULT NULL COMMENT '商品圖片地址',
  `current_unit_price` decimal(20,2) DEFAULT NULL COMMENT '生成訂單時的商品單價，單位是元,保留兩位小數',
  `quantity` int(10) DEFAULT NULL COMMENT '商品數量',
  `total_price` decimal(20,2) DEFAULT NULL COMMENT '商品總價,單位是元,保留兩位小數',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `mall_pay_info`;
CREATE TABLE `mall_pay_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用戶id',
  `order_no` bigint(20) NOT NULL COMMENT '訂單號',
  `pay_platform` int(10) DEFAULT NULL COMMENT '支付平臺:1-支付寶,2-微信',
  `platform_number` varchar(200) DEFAULT NULL COMMENT '支付流水號',
  `platform_status` varchar(20) DEFAULT NULL COMMENT '支付狀態',
  `pay_amount` decimal(20,2) NOT NULL COMMENT '支付金額',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uqe_order_no` (`order_no`),
  UNIQUE KEY `uqe_platform_number` (`platform_number`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `mall_product`;
CREATE TABLE `mall_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) NOT NULL COMMENT '分類id,對應mall_category表的主鍵',
  `name` varchar(100) NOT NULL COMMENT '商品名稱',
  `subtitle` varchar(200) DEFAULT NULL COMMENT '商品副標題',
  `main_image` varchar(500) DEFAULT NULL COMMENT '產品主圖,url相對地址',
  `sub_images` text COMMENT '圖片地址,json格式,擴展用',
  `detail` text COMMENT '商品詳情',
  `price` decimal(20,2) NOT NULL COMMENT '價格,單位-元保留兩位小數',
  `stock` int(11) NOT NULL COMMENT '庫存數量',
  `status` int(6) DEFAULT '1' COMMENT '商品狀態:1-在售 2-下架 3-刪除',
  `create_time` datetime DEFAULT NULL COMMENT '建立時間',
  `update_time` datetime DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_product` (`id`, `category_id`, `name`, `subtitle`, `main_image`, `sub_images`, `detail`, `price`, `stock`, `status`, `create_time`, `update_time`)
VALUES
	(26,100002,'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移動聯通電信4G手機','iPhone 7，現更以紅色呈現。','http://img.springboot.cn/241997c4-9e62-4824-b7f0-7425c3c28917.jpeg','241997c4-9e62-4824-b7f0-7425c3c28917.jpeg,b6c56eb0-1748-49a9-98dc-bcc4b9788a54.jpeg,92f17532-1527-4563-aa1d-ed01baa0f7b2.jpeg,3adbe4f7-e374-4533-aa79-cc4a98c529bf.jpeg','<p><img alt=\"10000.jpg\" src=\"http://img.springboot.cn/00bce8d4-e9af-4c8d-b205-e6c75c7e252b.jpg\" width=\"790\" height=\"553\"><br></p><p><img alt=\"20000.jpg\" src=\"http://img.springboot.cn/4a70b4b4-01ee-46af-9468-31e67d0995b8.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"30000.jpg\" src=\"http://img.springboot.cn/0570e033-12d7-49b2-88f3-7a5d84157223.jpg\" width=\"790\" height=\"365\"><br></p><p><img alt=\"40000.jpg\" src=\"http://img.springboot.cn/50515c02-3255-44b9-a829-9e141a28c08a.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"50000.jpg\" src=\"http://img.springboot.cn/c138fc56-5843-4287-a029-91cf3732d034.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"60000.jpg\" src=\"http://img.springboot.cn/c92d1f8a-9827-453f-9d37-b10a3287e894.jpg\" width=\"790\" height=\"525\"><br></p><p><br></p><p><img alt=\"TB24p51hgFkpuFjSspnXXb4qFXa-1776456424.jpg\" src=\"http://img.springboot.cn/bb1511fc-3483-471f-80e5-c7c81fa5e1dd.jpg\" width=\"790\" height=\"375\"><br></p><p><br></p><p><img alt=\"shouhou.jpg\" src=\"http://img.springboot.cn/698e6fbe-97ea-478b-8170-008ad24030f7.jpg\" width=\"750\" height=\"150\"><br></p><p><img alt=\"999.jpg\" src=\"http://img.springboot.cn/ee276fe6-5d79-45aa-8393-ba1d210f9c89.jpg\" width=\"790\" height=\"351\"><br></p>',6999.00,96,1,NULL,'2021-04-13 21:45:41'),
	(27,100006,'Midea/美的 BCD-535WKZM(E)冰箱雙開門對開門風冷無霜智能電家用','送品牌烤箱，五一大促','http://img.springboot.cn/ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg','ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg,4bb02f1c-62d5-48cc-b358-97b05af5740d.jpeg,36bdb49c-72ae-4185-9297-78829b54b566.jpeg','<p><img alt=\"miaoshu.jpg\" src=\"http://img.springboot.cn/9c5c74e6-6615-4aa0-b1fc-c17a1eff6027.jpg\" width=\"790\" height=\"444\"><br></p><p><img alt=\"miaoshu2.jpg\" src=\"http://img.springboot.cn/31dc1a94-f354-48b8-a170-1a1a6de8751b.jpg\" width=\"790\" height=\"1441\"><img alt=\"miaoshu3.jpg\" src=\"http://img.springboot.cn/7862594b-3063-4b52-b7d4-cea980c604e0.jpg\" width=\"790\" height=\"1442\"><img alt=\"miaoshu4.jpg\" src=\"http://img.springboot.cn/9a650563-dc85-44d6-b174-d6960cfb1d6a.jpg\" width=\"790\" height=\"1441\"><br></p>',3299.00,99,1,'2021-04-13 18:51:54','2021-04-13 21:45:41'),
	(28,100012,'4+64G送手環/Huawei/華為 nova 手機P9/P10plus青春','NOVA青春版1999元','http://img.springboot.cn/0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg','0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg,13da2172-4445-4eb5-a13f-c5d4ede8458c.jpeg,58d5d4b7-58d4-4948-81b6-2bae4f79bf02.jpeg','<p><img alt=\"11TB2fKK3cl0kpuFjSsziXXa.oVXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/5c2d1c6d-9e09-48ce-bbdb-e833b42ff664.jpg\" width=\"790\" height=\"966\"><img alt=\"22TB2YP3AkEhnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/9a10b877-818f-4a27-b6f7-62887f3fb39d.jpg\" width=\"790\" height=\"1344\"><img alt=\"33TB2Yyshk.hnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/7d7fbd69-a3cb-4efe-8765-423bf8276e3e.jpg\" width=\"790\" height=\"700\"><img alt=\"TB2diyziB8kpuFjSspeXXc7IpXa_!!1777180618.jpg\" src=\"http://img.springboot.cn/1d7160d2-9dba-422f-b2a0-e92847ba6ce9.jpg\" width=\"790\" height=\"393\"><br></p>',1999.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
	(29,100008,'Haier/海爾HJ100-1HU1 10公斤滾筒洗衣機全自動帶烘乾家用大容量 洗烘一體','門店機型 德邦送貨','http://img.springboot.cn/173335a4-5dce-4afd-9f18-a10623724c4e.jpeg','173335a4-5dce-4afd-9f18-a10623724c4e.jpeg,42b1b8bc-27c7-4ee1-80ab-753d216a1d49.jpeg,2f1b3de1-1eb1-4c18-8ca2-518934931bec.jpeg','<p><img alt=\"1TB2WLZrcIaK.eBjSspjXXXL.XXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/ffcce953-81bd-463c-acd1-d690b263d6df.jpg\" width=\"790\" height=\"920\"><img alt=\"2TB2zhOFbZCO.eBjSZFzXXaRiVXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/58a7bd25-c3e7-4248-9dba-158ef2a90e70.jpg\" width=\"790\" height=\"1052\"><img alt=\"3TB27mCtb7WM.eBjSZFhXXbdWpXa_!!2114960396.jpg\" src=\"http://img.springboot.cn/2edbe9b3-28be-4a8b-a9c3-82e40703f22f.jpg\" width=\"790\" height=\"820\"><br></p>',4299.00,100,1,'2021-04-13 19:07:47','2021-04-13 21:45:41'),
    (30,100012,'小米CC9','3200萬+4800萬 前後雙旗艦相機','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f515ab05232ed14ccd78ec67e024495a.png',null,null,1799.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (31,100012,'小米CC9','3200萬+4800萬 前後雙旗艦相機','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/df9b3e7a562e02a33eb069b3f0119815.png',null,null,1299.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (32,100012,'小米CC9 美圖定製版','直出超質感美顏','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/b02f50c9dd2e01c139a06a12502755ef.png',null,null,2599.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (33,100012,'小米9','小米9 戰鬥天使','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/2c9307e9690dfbca39d8de770a7a8664.png',null,null,2599.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (34,100012,'小米9 Pro 5G','快的不只是5G','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/41c566d825a3ae3b5751a78d4c7cffdb.png',null,null,3699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (35,100012,'小米MIX Alpha','5G環繞屏概念手機','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/5d19da60f9f62eb2aa5dcdbd7df19f0f.png',null,null,19999.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (36,100012,'Redmi Note 8 Pro','6400萬全場景四攝','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6f2493e6c6fe8e2485c407e5d75e3651.jpg',null,null,1399.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (37,100012,'Redmi Note 8','千元4800萬四攝','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/4c87947d104ee5833913e4c520108f16.jpg',null,null,999.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (38,100012,'Redmi K20 Pro 尊享版','驍龍855 Plus， 彈出全面屏','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8737a33c78a94bc36afb860ab23b3939.jpg',null,null,2699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (39,100012,'Redmi Note 7','4800萬拍照千元機','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/0ce61b71e2f81df62bd0c05aaa901d22.jpg',null,null,1099.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (40,100012,'Redmi 7','4000mAh超長續航','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9aab8a7fa9005ef918c9aa2d5f17c806.jpg',null,null,699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (41,100012,'Redmi 7A','小巧大電量 持久流暢','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/3c1af9783bdc53ed843af5655ca92009.jpg',null,null,579.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (42,100012,'小米CC9','3200萬自拍，4800萬三攝','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/bd25cc614a670f4d5546fe82e239ef86.jpg',null,null,1799.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (43,100012,'小米9 Pro 5G','5G雙卡全網通，驍龍855Plus','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/ca9b4f81af709935556bef9aa21a90e8.jpg',null,null,3699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (44,100012,'紅米8A','5000mAh 充電寶級大電量','https://i1.mifile.cn/f/i/2019/redmi1014a/part39.png',null,null,699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (45,100012,'紅米Note 7','4800萬拍照千元機 / 品質“小金剛”','https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1551869450.61563110.jpg',null,null,999.00,9999999,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (46,100012,'AI 4K 全面屏電視','小米全面屏電視 55英寸','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/a40904b6a053b73b631a152334388d0e.jpg',null,null,1799.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (47,100012,'小米MIX 3','一面科技，一面藝術','https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/9e83fabc3efeb8dd9f880ce26220c294.png',null,null,2599.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41'),
    (48,100012,'Redmi K20 Pro 尊享版','真旗艦、敢K.O. ','https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/8737a33c78a94bc36afb860ab23b3939.jpg',null,null,2699.00,100,1,'2021-04-13 18:57:18','2021-04-13 21:45:41');

DROP TABLE IF EXISTS `mall_shipping`;
CREATE TABLE `mall_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用戶id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收貨姓名',
  `receiver_phone` varchar(20) DEFAULT NULL COMMENT '收貨固定電話',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收貨移動電話',
  `receiver_province` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '區/縣',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '詳細地址',
  `receiver_zip` varchar(6) DEFAULT NULL COMMENT '郵遞區號',
  `create_time` datetime DEFAULT NULL COMMENT '建立時間',
  `update_time` datetime DEFAULT NULL COMMENT '更新時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_shipping` (`id`, `user_id`, `receiver_name`, `receiver_phone`, `receiver_mobile`, `receiver_province`, `receiver_city`, `receiver_district`, `receiver_address`, `receiver_zip`, `create_time`, `update_time`)
VALUES
	(4,1,'李知恩','010','886955123123','台灣','台北市','中山區','科技大樓','24100','2021-01-22 14:26:25','2021-01-22 14:26:25');

DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用戶表id',
  `username` varchar(50) NOT NULL COMMENT '用戶名',
  `password` varchar(50) NOT NULL COMMENT '用戶密碼，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密碼問題',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密碼答案',
  `role` int(4) NOT NULL COMMENT '角色:0-管理員,1-普通用戶',
  `create_time` datetime NOT NULL COMMENT '建立時間',
  `update_time` datetime NOT NULL COMMENT '最後一次更新時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `mall_user` (`id`, `username`, `password`, `email`, `phone`, `question`, `answer`, `role`, `create_time`, `update_time`)
VALUES
	(1,'admin','21232F297A57A5A743894A0E4A801FC3','admin@qq.com',NULL,NULL,NULL,0,'2021-08-06 15:12:00','2021-08-06 15:12:00');

-- 修改mall_user表欄位結構
alter table mall_user modify create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間';
alter table mall_user modify update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後一次更新時間';
