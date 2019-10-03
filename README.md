# store_v7
传统架构，无spring,springmvc,mybatis的商城项目

项目总体构架：
----前台部分----
1、前台展示商品模块
2、分类商品查询模块
3、热卖商品和新商品模块
4、查询不同分类下商品信息
5、提交商品至购物车
6、提交订单
7、查看订单

----后台部分-----
1、分类管理
2、商品管理
3、订单管理

系统的总体架构

主要包含一下几个包
cn.itcast.store--
              ---dao(数据层)  
              ---domain(pojo)
              ---service(服务层)
              ---test（测试类）
              ---utils（工具类）
              ---web---
                    ---base（基servlet）
                    ---filter(前段过滤器)
                    ---servlet(表现层)
