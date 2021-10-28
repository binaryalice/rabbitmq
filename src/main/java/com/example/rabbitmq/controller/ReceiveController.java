package com.example.rabbitmq.controller;


import com.example.rabbitmq.bean.Song;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  连接一次，接收一次消息
 */
@RestController
public class ReceiveController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     *
     * 接收direct交换机对应的队列里的信息
     */
    @GetMapping("/receive/direct/1")
    public Song directExchange1(){
        return (Song) rabbitTemplate.receiveAndConvert("directQueue.01");
    }

    @GetMapping("/receive/direct/2")
    public Song directExchange2(){
        return (Song) rabbitTemplate.receiveAndConvert("directQueue.02");
    }


    /**
     *
     * 接收topic交换机对应的队列里的信息
     */

    @GetMapping("/receive/topic1")
    public String topicExchange1(){
        return (String) rabbitTemplate.receiveAndConvert("topicQueue1");
    }

    @GetMapping("/receive/topic2")
    public String topicExchange2(){
        return (String) rabbitTemplate.receiveAndConvert("topicQueue2");
    }

    @GetMapping("/receive/topic3")
    public String topicExchange3(){
        return (String) rabbitTemplate.receiveAndConvert("topicQueue3");
    }

    @GetMapping("/receive/topic4")
    public String topicExchange4(){
        return (String) rabbitTemplate.receiveAndConvert("topicQueue4");
    }

    @GetMapping("/receive/topic5")
    public String topicExchange5(){
        return (String) rabbitTemplate.receiveAndConvert("topicQueue5");
    }



    /**
     *
     * 接收fanout交换机对应的队列里的信息
     */

    @GetMapping("/receive/fanout/1")
    public Song fanoutExchange1(){
        return (Song) rabbitTemplate.receiveAndConvert("fanoutQueue.01");
    }

    @GetMapping("/receive/fanout/2")
    public Song fanoutExchange2(){
        return (Song) rabbitTemplate.receiveAndConvert("fanoutQueue.02");
    }










}
