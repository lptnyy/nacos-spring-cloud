package com.nacos.xiaoshuo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
@EnableFeignClients({
        "com.nacos.system",
        "com.nacos.xiaoshuo"
})
@ComponentScans({
    @ComponentScan("com.nacos.system"),
    @ComponentScan("com.nacos.common.exception"), // 载入全局异常管理
    @ComponentScan("com.nacos.common.feign"), // 解决 服务调用之间传递 oauth2 头信息
})
public class XSAppApplication {
  public static void main(String[] args) {
    SpringApplication.run(XSAppApplication.class, args);
  }
}
