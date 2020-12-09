package com.nacos.rabbit;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.common.feign.FeignRequestInterceptor;
import com.nacos.common.util.ServiceResponse;
import com.nacos.rabbit.hystrix.SendRabbitMessageServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-service", configuration = FeignRequestInterceptor.class,fallback = SendRabbitMessageServiceHystrix.class)
public interface SendRabbitMessageService {

  /**
   * 同步企业信息到其他数据库当中
   * @param proBusinessRequest
   */
  @RequestMapping(path = "/sync/sendSynBusinessDate", method = RequestMethod.POST)
  ServiceResponse sendSynBusinessDate(@RequestBody ProBusinessRequest proBusinessRequest);
}
