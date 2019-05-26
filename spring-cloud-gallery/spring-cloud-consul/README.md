# spring cloud consul

参考：[Consul详解](http://www.ityouknow.com/springcloud/2018/07/20/spring-cloud-consul.html)

consul需要独立安装一个consul服务作为服务注册中心

去[consul官网](https://www.consul.io/downloads.html)下载，本地启动

```
# -dev表示开发模式运行，另外还有-server表示服务模式运行
consul agent -dev
```

1. 打开localhost:8500 可以看到管理后台
2. 启动ConsulProducer1Application，管理后台可以看到新注册的服务，服务数为1

访问 `http://localhost:8501/hello` 可以看到服务已启动且可以正常访问
3. 启动 ConsulProducer2Application, 管理后台可以看到服务的节点数量为2

访问 `http://localhost:8512/hello` 可以看到服务已启动且可以正常访问

4. 启动 ConsulConsumerApplication, 访问`http://localhost:8503/services`可以看到有两个服务

访问`http://localhost:8503/discover` 发现空指针

最后发现需要添加依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

否则无法使用`org.springframework.cloud.client.loadbalancer.LoadBalancerClient` 