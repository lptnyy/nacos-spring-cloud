package com.nacos.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScans({
    @ComponentScan("com.nacos.common.exception"), // 载入全局异常管理
    @ComponentScan("com.nacos.common.feign") // 解决 服务调用之间传递 oauth2 头信息
})
public class SearchApplication {
  public static void main(String[] args) {
    SpringApplication.run(SearchApplication.class, args);
  }
}
