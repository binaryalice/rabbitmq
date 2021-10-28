package com.example.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbtimq的配置类
 * 定义3个交换机
 */
@Configuration
public class RabbitMQConfiguration {

    /**
     * 直接交换机
     */
    @Bean
    public DirectExchange directExchange(){
        /*第一个参数：交换机名称;
         * 第二个参数：持久化支持;
         * 第三个参数：没有连接访问该交换机 ，不删除该交换机*/
        return new DirectExchange(
                "directExchange",false,false);
    }

    /**
     * 直接队列
     */
    @Bean
    public Queue directQueueOne(){
        return new Queue("directQueue.01",false);
    }

    @Bean
    public Queue directQueueTwo(){
        return new Queue("directQueue.02",false);
    }

    /**
     * 绑定
     */
    @Bean
    public Binding bindingDirectExchangeOne(){
        return BindingBuilder.bind(directQueueOne()).to(directExchange()).with("directQueue_01");
    }

    @Bean
    public Binding bindingDirectExchangeTwo(){
        return BindingBuilder.bind(directQueueTwo()).to(directExchange()).with("directQueue_02");
    }











    /**
     * 主题交换机
     * 如果消息的routing key（可能含通配符）匹配，那么消息将会被路由到一个或者多个这样的队列上
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",false,false);
    }

    /**
     * 主题队列
     */

    @Bean
    public Queue topicQueue1(){
        return new Queue("topicQueue1",false);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topicQueue2",false);
    }

    @Bean
    public Queue topicQueue3(){
        return new Queue("topicQueue3",false);
    }

    @Bean
    public Queue topicQueue4(){
        return new Queue("topicQueue4",false);
    }

    @Bean
    public Queue topicQueue5(){
        return new Queue("topicQueue5",false);
    }

    /**
     * 将主题交换机与主题队列绑定
     */
    @Bean
    public Binding bindingTopicExchange1(){
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("image.new.profile");
    }

    @Bean
    public Binding bindingTopicExchange2(){
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("image.new.*");
    }

    @Bean
    public Binding bindingTopicExchange3(){
        return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with("image.*.profile");
    }

    @Bean
    public Binding bindingTopicExchange4(){
        return BindingBuilder.bind(topicQueue4()).to(topicExchange()).with("image.delete.*");
    }

    @Bean
    public Binding bindingTopicExchange5(){
        return BindingBuilder.bind(topicQueue5()).to(topicExchange()).with("image.#");
    }







    /**
     * 扇形交换机
     * 不管routing key是什么，消息都会被路由到所有绑定的队列上
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange",false,false);
    }

    /**
     * 扇形队列
     */
    @Bean
    public Queue queueA(){
        return new Queue("fanoutQueue.01",false);
    }
    @Bean
    public Queue queueB(){
        return new Queue("fanoutQueue.02",false);
    }

    /**
     * 将扇形交换机与扇形队列绑定
     */
    @Bean
    public Binding bindingFanoutExchangeA(){
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutExchangeB(){
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }






}
