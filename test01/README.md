# Spring Security学习

## Spring Security练习1

我目前理解的Spring Security的思想大致如下：
首先是拦截器，它来定义服务器上对哪些资源的访问需要拦截；其次是认证管理器，拦截了之后通过认证管理器来确定客户端是否有权限访问资源

写在前面：
* 该项目是个基于maven构建的web项目
* 使用spring mvc作为web框架,spring mvc相关配置步骤这里就不写了

### 针对http的权限认证配置，初步

#### 配置springSecurityFilterChain
web.xml中添加配置：
```xml
  <!-- SpringSecurity过滤器链 -->
  <filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

#### 配置http拦截器，拦截所有请求
spring-security.xml中添加配置：
```xml
    <security:http>
        <!--
            pattern：需要拦截资源的正则表达式，一个*代表一级路径，两个*代表任意级路径
            isFullyAuthenticated()：该资源需要认证才可以被访问
        -->
        <security:intercept-url pattern="/**" access="isFullyAuthenticated()"/>
    </security:http>
```

#### 
spring-security.xml中添加配置：
```xml
    <!-- <security:authentication-manager>:认证管理器
            <security:authentication-provider>:认证提供者
                在这里我们配置了<security:user-service>作为认证提供者，它相当于在
                内存中创建了UserDetailsService，并且拥有你配置的用户
    -->
    <security:authentication-manager>
        <security:authentication-provider>
            <security:user-service>
                <security:user name="eric" password="123456"/>
            </security:user-service>
        </security:authentication-provider>
    </security:authentication-manager>
```
到此为止初步的配置就完成了，
![打开/product/index](./images/1.png)