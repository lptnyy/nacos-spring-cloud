package com.nacos.rabbit.configuration.rabbit;
import com.nacos.common.rabbit.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfiguration {

  /**
   * 同步数据交换机
   * @return
   */
  public TopicExchange getTopicExchange() {
    return new TopicExchange(RabbitConstant.exchangeName, false, false);
  }

  /**
   * 同步企业信息到相关数据库中
   * @return
   */
  public Queue businessQueue() {
    return new Queue(RabbitConstant.businessQueueName, false);
  }

  @Bean
  public Binding businessQueueBinding() {
    return BindingBuilder.bind(businessQueue()).to(getTopicExchange()).with(RabbitConstant.businessQueueName);
  }
}
