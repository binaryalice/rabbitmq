package com.example.rabbitmq.controller;


import com.example.rabbitmq.bean.Song;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    Song song = new Song("女儿情","许镜清、杨洁","鸳鸯双栖蝶双飞");
    Song song2 = new Song("刚问路在何方","许镜清、杨洁","鸳鸯双栖蝶双飞");
    Song song3 = new Song("主题曲","许镜清、杨洁","鸳鸯双栖蝶双飞");
    Song song4 = new Song("re：从零开始的异世界生活","许镜清、杨洁","鸳鸯双栖蝶双飞");
    Song song5 = new Song("鬼灭之刃","许镜清、杨洁","鸳鸯双栖蝶双飞");


    @GetMapping("/direct")
    public void directExchange(){
        rabbitTemplate.convertAndSend("directExchange","directQueue_01",song);
        rabbitTemplate.convertAndSend("directExchange","directQueue_02",song2);

    }



    @GetMapping("/topic1")
    public void topicExchange1(){
        rabbitTemplate.convertAndSend("topicExchange","image.new.profile","image.new.profile");
    }


    @GetMapping("/topic2")
    public void topicExchange2(){
        rabbitTemplate.convertAndSend("topicExchange","image.delete.profile","image.delete.profile");
    }


    @GetMapping("/topic3")
    public void topicExchange3(){
        rabbitTemplate.convertAndSend("topicExchange","image.test.profile","image.test.profile");
    }





    @GetMapping("/fanout")
    public void fanoutExchange(){

        rabbitTemplate.convertAndSend("fanoutExchange","topic.song4",song);
        rabbitTemplate.convertAndSend("fanoutExchange","topic.song4",song2);
        rabbitTemplate.convertAndSend("fanoutExchange","topic.song4",song3);
        rabbitTemplate.convertAndSend("fanoutExchange","topic.song4",song4);
        rabbitTemplate.convertAndSend("fanoutExchange","topic.song4",song5);

    }





}
