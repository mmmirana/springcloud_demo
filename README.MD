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
  client:
    registerWithEureka: false # 表示是否将自己注册到Eureka Server,默认为true
    fetchRegistry: false # 表示是否从Eureka Server获取注册信息,默认为true
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/ # 服务注册中心的地址
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
  client:
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:8761/eureka/
```
3.ribboncustomer
--------------------------------------
ribbon消费者-9010

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

```