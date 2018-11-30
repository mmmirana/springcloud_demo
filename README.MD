# springcloud_demo

1.springboot
--------------------------------------
springboot demo

控制器：
@Controller:

@RestController: 集成@Controller和@ResponseBody

读取yml属性：

@Value("${person.name}")

application.yml:

```
person:
 name: wangzhifei
 age: 12
```
   
2.eurekaserver
--------------------------------------
Eureka服务注册中心-8761

application.yml:

```yml
spring:
  application:
    name: eurekaserver # app名称

server:
  port: 8761 # app端口

# eureka配置
eureka:
  instance:
    hostname: localhost # ip
  server:
    enableSelfPreservation: false   # 关闭自我保护模式（缺省为打开）
    evictionIntervalTimerInMs: 5000 # 续期时间，即扫描失效服务的间隔时间（缺省为60*1000ms）

  client:
    registerWithEureka: false       # 表示是否将自己注册到Eureka Server,默认为true
    fetchRegistry: false            # 表示是否从Eureka Server获取注册信息,默认为true
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/  # 服务注册中心的地址
```   

3.eurekaclient
--------------------------------------
Eureka服务提供商-9001/9002

application.yml:

```yml
spring:
  application:
    name: eurekaclient

server:
  port: 9001

# eureka 注册中心配置
eureka:
  instance:
    hostname: localhost
    # 心跳时间，即服务续约间隔时间（缺省为30s）
    leaseRenewalIntervalInSeconds: 5
    # 发呆时间，即服务续约到期时间（缺省为90s）
    leaseExpirationDurationInSeconds: 10
  client:
    # 拉取服务器注册信息间隔时间（缺省为30s）
    registryFetchIntervalSeconds: 5
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:8761/eureka/
    healthcheck:
      enabled: true


```
4.ribboncustomer
--------------------------------------
ribbon消费者-9010

\+ 20181129加入Hystrix断路器

application.yml:

```yml
spring:
  application:
    name: ribboncustomer

server:
  port: 9010

# eureka 注册中心配置
eureka:
  instance:
    hostname: localhost
  client:
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:8761/eureka/


# 熔断超时时间，设置为5s
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 5000
```
5.feigncustomer
--------------------------------------
feign消费者-9011

application.yml:

```yml
spring:
  application:
    name: feigncustomer

server:
  port: 9011

# eureka 注册中心配置
eureka:
  instance:
    hostname: localhost
  client:
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:8761/eureka/
      
feign:
  httpclient:
    enabled: true
```