# Ecommerce

> **快速體驗項目**：[DEMO](http://ec2-54-215-191-12.us-west-1.compute.amazonaws.com/) 。

##  目錄



## 項目簡介

本項目是一套電商平台+通用型支付系統的雙系統項目，基於SpringBoot+MyBatis实现。
使用MySQL作為存儲層，Redis存儲購物車的商品，使用 Nginx 服務器實現反向代理，部署於AWS，支付系統串接微信和支付寶，並使用RabbitMQ實現支付的異步通知。

本項目為電商平台和通用性支付系统，這是電商平台，支付系統請往[這邊](https://github.com/karenchuu/pay)。

## 功能模塊

購物車

商品管理

商品分類管理

訂單管理

地址管理

用戶管理

支付系統



## 技術棧

* SpringBoot
* MySQL
* Redis：使用Redis緩存實現高性能購物車，減少MySQL數據庫的壓力
* RabbitMQ：使用MQ實現支付與訂單模塊之間消息的異步通知。
* Nginx：進行反向代理，將訪問到後端的接口轉發到電商系統進行處理。
* AWS



## API規格

[API文檔](https://github.com/karenchuu/Ecommerce/tree/main/docs/api)

## 資料庫設計

[SQL語法](https://github.com/karenchuu/Ecommerce/tree/main/docs/sql)

![](https://github.com/karenchuu/Ecommerce/blob/main/docs/imgs/%E8%B3%87%E6%96%99%E5%BA%ABER%E5%9C%96.jpg)

## 頁面展示

### 【首頁】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202208010025853.png)



### 【會員登入】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202208010023849.png)

### 【購物車】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202208010028368.png)

### 【訂單結算】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202208010029204.png)

![](https://raw.githubusercontent.com/karenchuu/oss/main/202208010029487.png)

### 【訂單列表】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202207272229024.png)

### 【支付頁面】

![](https://raw.githubusercontent.com/karenchuu/oss/main/202207272232977.png)



## 環境搭建

### 開發環境

| 工具     | 版本號   | 下載                                                                                   |
| -------- |-------|--------------------------------------------------------------------------------------|
| JDK      | 1.8   | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| Mysql    | 8.0.28 | https://www.mysql.com/                                                               |
| Redis    | 5.0.7 | https://redis.io/download                                                            |
| RabbitMQ | 3.8.2 | http://www.rabbitmq.com/download.html                                                |
| Nginx    | 1.22  | http://nginx.org/en/download.html                                                    |

