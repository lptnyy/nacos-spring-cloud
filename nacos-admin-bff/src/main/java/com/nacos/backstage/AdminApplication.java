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
		"com.nacos.system",
		"com.nacos.member",
		"com.nacos.oss",
		"com.nacos.product",
		"com.nacos.business"
})
@ComponentScans({
		@ComponentScan("com.nacos.common.exception"), // 载入全局异常管理
		@ComponentScan("com.nacos.common.feign"),
		@ComponentScan("com.nacos.common.aspect"),
		@ComponentScan("com.nacos.system"),
		@ComponentScan("com.nacos.member"),
		@ComponentScan("com.nacos.oss"),
		@ComponentScan("com.nacos.product"),
		@ComponentScan("com.nacos.business")
})
public class AdminApplication {
    public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
