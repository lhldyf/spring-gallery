
打开`http://localhost:8001/config-repo/dev`
可以看到配置中心config-repo-dev配置的信息

```
{"name":"config-repo","profiles":["dev"],"label":null,"version":"d8c9eeed5716453d5ea4969e93a84f755d22caf2","state":null,"propertySources":[]}
```

刷新的时候通过actuator地址

```
curl -X POST http://localhost:9001/monitor/refresh
```

可以把配置中心再做成一个微服务，配置两台配置中心，在客户端使用时把bootstrap.properties配置变更一下：

单节点配置：
```
spring.cloud.config.uri = http://localhost:8001/
```

高可用配置中心配置：
```
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.serviceId=spring-cloud-config-server

eureka.client.serviceUrl.defaultZone=http://localhost:8000/eureka/
```