# bnade-web-ssh
通过SpringBoot使用SpringMVC, Spring, Spring Data JPA重构项目，决定使用这3种框架重新实现bnade的接口。期待有兴趣的朋友加入我们

## 项目环境
- java 1.8
- mysql 5.7
- redis
- maven
- springBoot
- druid 数据库连接池
- logback 日志框架

## 接口

方法|URI|可选参数|说明
-|-|-|-
GET|/realms/{id}/auctions|itemId owner|查询卖家，物品的拍卖
GET|/auctions|realmId itemId|查询卖家，物品的拍卖
GET|/wowtokens||查询所有时光徽章数据

- GET /items/{id} 通过id查询物品
- GET /items?search={name} 查询含有name物品名的物品
- GET /items/names?search={name} 查询含有name物品名