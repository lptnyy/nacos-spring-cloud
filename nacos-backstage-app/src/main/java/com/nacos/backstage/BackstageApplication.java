package com.nacos.backstage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients({
		"com.nacos.system"
})
@ComponentScans({
		@ComponentScan("com.nacos.common.exception"), // 载入全局异常管理
		@ComponentScan("com.nacos.common.feign"),
		@ComponentScan("com.nacos.common.aspect"),
		@ComponentScan("com.nacos.system")
})
public class BackstageApplication {
    public static void main(String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
	}
}
