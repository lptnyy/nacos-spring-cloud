package com.nacos.rabbit.listener;
import com.nacos.common.rabbit.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = RabbitConstant.businessQueueName)
@Component
public class SyncBusiness {

  @RabbitHandler
  public void handler(String message) {
    System.out.println(message);
  }
}
