package com.nacos.rabbit.hystrix;

import com.nacos.business.request.ProBusinessRequest;
import com.nacos.common.util.ServiceResponse;
import com.nacos.rabbit.SendRabbitMessageService;

public class SendRabbitMessageServiceHystrix implements SendRabbitMessageService {

  @Override
  public ServiceResponse sendSynBusinessDate(ProBusinessRequest proBusinessRequest) {
    return ServiceResponse.getFAIL();
  }
}
