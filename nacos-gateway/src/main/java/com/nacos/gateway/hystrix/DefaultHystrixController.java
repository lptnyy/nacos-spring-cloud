package com.nacos.gateway.hystrix;
import com.nacos.common.util.ServiceResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public ServiceResponse defaultfallback(){
        return ServiceResponse.getBEBUSYFAIL();
    }
}
