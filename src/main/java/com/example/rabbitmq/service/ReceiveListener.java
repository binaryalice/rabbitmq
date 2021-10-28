package com.example.rabbitmq.service;

import com.example.rabbitmq.bean.Song;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ReceiveListener {


    @RabbitListener(queues = "fanoutQueue.01")
    public void receiveFanoutQueue1(Song song){
        System.out.println(song);
    }


}
