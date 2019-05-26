# spring-cloud-gallery

公司有项目用到了spring-cloud，简单了解一下

以下诸多内容翻译自[官网首页](https://spring.io/projects/spring-cloud)

## spring-cloud特点


- 分布式多版本配置管理
- 服务注册与发现
- 路由
- 服务间调用
- 负载均衡
- 服务熔断
- 分布式锁
- 自动选举
- 分布式消息

## 主要项目

这里做个简单介绍和分类，内容栽自[大话Spring Cloud](http://www.ityouknow.com/springcloud/2017/05/01/simple-springcloud.html)

### Spring Cloud Netflix

netflix开源了很多微服务组件，spring cloud官方也是推荐使用这些开源组件。



#### Eureka

**服务中心**，云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。这个可是springcloud最牛鼻的小弟，服务中心，任何小弟需要其它小弟支持什么都需要从这里来拿，同样的你有什么独门武功的都赶紧过报道，方便以后其它小弟来调用；它的好处是你不需要直接找各种什么小弟支持，只需要到服务中心来领取，也不需要知道提供支持的其它小弟在哪里，还是几个小弟来支持的，反正拿来用就行，服务中心来保证稳定性和质量。 

这个组件Netflix已经宣布说2.0暂缓发布，不知道后续如何，所以用这个的优先级应该降低



#### Hystrix

**熔断器**，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。比如突然某个小弟生病了，但是你还需要它的支持，然后调用之后它半天没有响应，你却不知道，一直在等等这个响应；有可能别的小弟也正在调用你的武功绝技，那么当请求多之后，就会发生严重的阻塞影响老大的整体计划。这个时候Hystrix就派上用场了，当Hystrix发现某个小弟不在状态不稳定立马马上让它下线，让其它小弟来顶上来，或者给你说不用等了这个小弟今天肯定不行，该干嘛赶紧干嘛去别在这排队了。 

#### **Zuul** 

**提供动态路由,监控,弹性,安全等边缘服务的框架**。Zuul 相当于是设备和 Netflix 流应用的 Web 网站后端所有请求的前门。当其它门派来找大哥办事的时候一定要先经过zuul,看下有没有带刀子什么的给拦截回去，或者是需要找那个小弟的直接给带过去。 

Nginx有个衍生的Kong也有Zuul类似的能力，不过Nginx是C语言开发的，而Java的Gateway总会让人怀疑其性能，网上有人做的对比

[Netflix Zuul与Nginx的性能对比](http://blog.didispace.com/zuul-vs-nginx-performance/)

[一文看懂Zuul, Nginx, Spring Cloud, Linkerd性能差异](https://blog.csdn.net/zhangbijun1230/article/details/81660834)

结论基本是两者性能不差太多，在JVM预热之后性能可能还比Nginx更好



不过现在Spring Cloud又推出了 Gateway组件，比Zuul更强大，所以貌似已经没有理由使用Zuul了啊



#### **Archaius** 

**配置管理API**，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。可以实现动态获取配置， 原理是每隔60s（默认，可配置）从配置源读取一次内容，这样修改了配置文件后不需要重启服务就可以使修改后的内容生效，前提使用archaius的API来读取。 

这个用的人就比较少了，一般用Spring Cloud Config 和 Spring Cloud Bus可以搞定。



### Spring Cloud Config

**配置中心**，配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion。就是以后大家武器、枪火什么的东西都集中放到一起，别随便自己带，方便以后统一管理、升级装备。 



### Spring Cloud Bus

**事件、消息总线**，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。相当于水浒传中日行八百里的神行太保戴宗，确保各个小弟之间消息保持畅通。 



### **Spring Cloud Sleuth** 

**日志收集工具包**，封装了**Dapper**和log-based追踪以及**Zipkin**和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。 



### Spring Cloud Gateway





### Spring Cloud 运行思路



1. 请求统一通过API网关（Zuul）来访问内部服务.
2. 网关接收到请求后，从注册中心（Eureka）获取可用服务
3. 由Ribbon进行均衡负载后，分发到后端具体实例
4. 微服务之间通过Feign进行通信处理业务
5. Hystrix负责处理服务超时熔断
6. Turbine监控服务间的调用和熔断相关指标



## Spring Cloud 版本依赖

官方对版本号也挺搞笑的，以` London Tube stations  `命名版本号，首字母按照字母序来排，看现在这个顺序就能理解了：

| Release Train | Boot Version |
| ------------- | ------------ |
| Greenwich     | 2.1.x        |
| Finchley      | 2.0.x        |
| Edgware       | 1.5.x        |
| Dalston       | 1.5.x        |

D/E 不支持2.0+的spring boot ，现在可以用Greenwich，这个是大版本号，小版本号用`SRX`表示`service release`后续带上一个数字。比如`Greenwich.SR2`



## 参考链接

1. [Spring Cloud系列](http://www.ityouknow.com/spring-cloud.html)