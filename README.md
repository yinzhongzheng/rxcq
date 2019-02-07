# 项目结构
分布式项目 rxcq

## 闲聊分布式
>  1. **分布式架构，我的理解是，大的逻辑是将应用按照模块进行拆分，如果某个模块的某个点热度比较高，可以考虑将此功能拆出来，单独部提高吞吐量**
> 2. **分布式架构实现了业务和api接口的分离，通过dubbo实现RPC通信，API不在参与具体业务。**
> 3.**通过使用消息队列组建来解耦可被异步调用的一些业务，如验证码相关，邮件相关、用户积分相关、推送相关、日志相关等一些可以异步的操作** 
> 4. **动静分离，前端只和Api服务进行交互，独立部署在高性能的静态资源服务器上，例如nginx**

## 项目结构
```

rxcq (root)
    - parent-dubbo
        - pom.xml
    - parent-web
        - pom.xml
    - common
    - user
        - user-api
        - user-provider
    - web
        - view-mh
```
1. ### parent-dubbo
	dubbo server端的通用父pom，包含了**spring**、**dubbo**（排除了spring相关的组件)、**mybatis**、**druid**、**zkClient**、**jms**以及通用的工具包。
2. ### parent-web
	dubbo consumer端的通用父pom，包含**spring**、springMVC、**dubbo**（排除了spring相关的组件)、**zkClient**等不含数据库操作的组件。
3. common
    通用的包，包含大部分模块需要的类。
4. user
    代表的使用模块，其他模块和此模块差不多
    1. user-api 
    提供api供消费者使用，包含service接口和消费的将会用到的远程调用xml文件
    ![](md_img\user-api.png)
    ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
               xsi:schemaLocation="http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans.xsd
                http://code.alibabatech.com/schema/dubbo
                http://code.alibabatech.com/schema/dubbo/dubbo.xsd" default-autowire="byName">
        
        
            <dubbo:reference id="loginService" interface="com.yzz.user.api.ILogin"/>
        
            <dubbo:reference id="registerService" interface="com.yzz.user.api.IRegister"/>
        
        </beans>
    ```
    2. user-provider
    真正用户模块的服务提供者，实现了user-api的所有接口。
 5. web
    代表的是接口模块,在现阶段，没有实现动静分离，api层和静态资源还是放在一起，后面将会将web包拆分成view和api。

 ## 注意事项
 1. 修改provider模块后，需要重新install。
 2. 模块做到依赖的精简，不需要的依赖要去除。
 3. common模块可以按类型分细一点，各取所需。
 4. 2018的最新版idea在部署web应用的时候的url一定要认真和之前的版本有所区别，我都为此忙活了好久。
 5. 下载Maven依赖的时候，尽量不要断网，那将是很蛋疼的一件事。
 
 ## 项目地址
 >[rzcq](https://github.com/yinzhongzheng/rxcq)
