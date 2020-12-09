package com.nacos.rabbit.service;
import com.alibaba.fastjson.JSON;
import com.nacos.business.request.ProBusinessRequest;
import com.nacos.common.rabbit.RabbitConstant;
import com.nacos.common.util.ServiceResponse;
import com.nacos.rabbit.SendRabbitMessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendRabbitMessageServiceImpl implements SendRabbitMessageService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发送同步企业消息
     * @param proBusinessRequest
     * @return
     */
    @Override
    public ServiceResponse sendSynBusinessDate(ProBusinessRequest proBusinessRequest) {
        return new ServiceResponse()
            .run((serviceResponse -> {
                String objJson = JSON.toJSONString(proBusinessRequest);
                rabbitTemplate.convertAndSend(RabbitConstant.exchangeName,RabbitConstant.businessQueueName, objJson);
                return serviceResponse;
            }))
            .exec();
    }
}
