# sb-ecom (Spring Boot Ecommerce Project)

这是一个基于 **Spring Boot** 的电商项目后端。本项目旨在从零开始构建一个功能齐全的电商系统。

---

## 🚀 避坑指南：版本兼容性说明 (Important!)

在项目初始化阶段，我们遇到了一个关于 **Spring Boot 4.0.2** 的严重兼容性问题，特此记录：

### 1. 问题描述
最初尝试使用 **Spring Boot 4.0.2**（实验性版本）时，发现 **H2 Console (数据库控制台)** 无法正常开启，访问 `/h2-console` 始终报错 **404 Not Found**。

### 2. 排查结果
* **自动配置失效**：Spring Boot 4.x 可能对 H2 的自动注册机制做了重大调整，导致传统的 `application.properties` 配置无法生效。
* **依赖冲突**：该版本使用的 Jakarta EE 11 与当前稳定版的 H2 驱动存在类路径兼容性问题，导致 Servlet 无法正确映射。

### 3. 最终解决方案
我们将项目版本降级到了目前工业界主流且稳定的 **Spring Boot 3.3.4**。
* **操作**：修改 `pom.xml` 中的 `spring-boot-starter-parent` 为 `3.3.4`。
* **结果**：所有自动配置恢复正常，H2 Console 成功启动。

---

## 🛠 技术栈
* **Java:** 17
* **Framework:** Spring Boot 3.3.4 (Stable)
* **Database:** H2 In-Memory Database
* **ORM:** Spring Data JPA
* **Build Tool:** Maven

---

## ⚙️ 数据库配置与访问

为了方便开发调试，项目集成了 H2 内存数据库控制台。

### 1. 配置文件 (`application.properties`)
```properties
# 开启 H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# 固定数据库连接地址
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

### 2. 访问步骤

1. 启动项目。
2. 在浏览器输入：`http://localhost:8080/h2-console`。
3. 在登录界面的 **JDBC URL** 栏输入：`jdbc:h2:mem:testdb`（必须与配置一致）。
4. 点击 **Connect** 即可进入。

------

## 📂 项目启动指南

1. **克隆项目**：

   Bash

   ```
   git clone https://github.com/Shen0302/sb-ecom
   ```

2. **刷新 Maven**： 在 IntelliJ IDEA 中点击 "Reload All Maven Projects" 确保依赖下载完成。

3. **运行项目**： 运行 `src/main/java/com/ecommerce/project/SbEcomApplication.java`。

------
