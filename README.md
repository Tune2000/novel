<a name="MJ77v"></a>
## 项目简介
该项目是基于 Java 技术栈 Spring Boot 2.7.2 + Vue 3 开发的前后端分离的小说项目，包括小说门户系统，作家后台管理系统。提供小说推荐，各类小说榜单查询，小说类型查询，小说评论，小说阅读，作家专区 等功能。
<a name="fkHAW"></a>
## 项目地址
小说项目前端Github地址：[https://github.com/Tune2000/novel-frontend](https://github.com/Tune2000/novel-frontend)<br />小说项目后端Github地址：[https://github.com/Tune2000/novel-backend](https://github.com/Tune2000/novel-backend)
<a name="gzBID"></a>
## 后端技术栈
| **技术** | **版本** |
| --- | --- |
| Spring Boot  | 2.7.2 |
| MySQL  | 8.0 |
| Mybatis-Plus  | 3.5.3 |
| JJWT  | 0.11.5 |
| Caffeine  | 2.9.3 |
| Redis  | 5.0.14 |
| Springdoc-openapi  | 1.7.0 |

<a name="kDFHV"></a>
## 项目详情
该小说项目包括两个部分：小说前台门户系统和作家后台管理系统，主要实现内容是小说前台门户系统，<br />包括小说网站首页、排行榜页、小说详情页、小说目录页、小说阅读页和作品分类搜索页

小说网站首页是小说门户的入口，承载着系统很大一部分流量，并且内容不需要实时更新。所以首页相关内容的查询做缓存处理，例如小说首页热门推荐、精品推荐、本周强推、点击榜单等只读数据使用到**Caffeine缓存。**

本地缓存虽然有着访问速度快的优点，但无法进行大数据的存储。使用**Redis缓存**来持久化数据**，**例如进行小说阅读时，对小说章节对应内容进行查询**。**

网站通过配置类实现WebMvcConfigurer方式，添加拦截器拦截会员中心相关请求和作家后台相关请求如用户对小说进行评论操作，作家后台管理系统对小说章节内容修改操作。

网站用户注册使用到图形验证码工具类来生成随机校验码，防止用户利用机器人自动注册，同时在用户登录注册中使用到**JWT**进行安全校验。
<a name="xag0t"></a>
## 项目截图
注册页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665603892-29f674d7-c366-4eba-87c2-d8ffd07871f9.png#averageHue=%23faf0e5&clientId=u46cc54c6-c1fd-4&from=paste&height=704&id=cRdT3&originHeight=880&originWidth=2560&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=63076&status=done&style=none&taskId=ub0e06f4d-76e6-42c9-a8f5-53635d7d3dc&title=&width=2048)<br />首页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665199749-8edc7701-868f-4abd-be10-cb1363140166.png#averageHue=%23f8efe6&clientId=u46cc54c6-c1fd-4&from=paste&height=814&id=u23aebcb1&originHeight=1017&originWidth=2560&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=247664&status=done&style=none&taskId=u7c81f98a-887f-4817-ab1e-0d8c91c986a&title=&width=2048)<br />分类索引页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665298891-df07df1c-7c32-4d81-b2f1-1c4691e1fc7b.png#averageHue=%23f8f1e9&clientId=u46cc54c6-c1fd-4&from=paste&height=829&id=uf7daf3da&originHeight=1036&originWidth=2560&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=86762&status=done&style=none&taskId=uaa609bd8-da61-49c2-908a-f79712c8071&title=&width=2048)<br />搜索页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665523128-0ab75104-2192-4245-83a6-2e7ef2278178.png#averageHue=%23f9f3ec&clientId=u46cc54c6-c1fd-4&from=paste&height=977&id=u09c65876&originHeight=1221&originWidth=2551&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=96986&status=done&style=none&taskId=u4f764e00-4023-4db7-a37e-872a70f9f15&title=&width=2040.8)<br />小说详情页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665652897-76bec750-51fd-4833-a162-2293e093db02.png#averageHue=%23f8f1e9&clientId=u46cc54c6-c1fd-4&from=paste&height=895&id=uabade5d1&originHeight=1119&originWidth=2560&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=174171&status=done&style=none&taskId=u8e7c7d1c-73c0-460d-8648-23c56da96c3&title=&width=2048)<br />小说阅读页<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665675001-2afbb7c0-abe2-4e22-8cb9-823239a40515.png#averageHue=%23f6f5f5&clientId=u46cc54c6-c1fd-4&from=paste&height=923&id=u47414b9b&originHeight=1154&originWidth=2559&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=88330&status=done&style=none&taskId=u61a12ecc-ca00-4ca0-97f1-462539f70a6&title=&width=2047.2)<br />小说目录<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/39288367/1703665688923-55c2ef3b-f8ea-4bdb-9bbd-ea69f3210150.png#averageHue=%23f8f1e9&clientId=u46cc54c6-c1fd-4&from=paste&height=882&id=u42563485&originHeight=1103&originWidth=2560&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=108794&status=done&style=none&taskId=u35c44ec5-5efa-4216-9712-7866193635d&title=&width=2048)
