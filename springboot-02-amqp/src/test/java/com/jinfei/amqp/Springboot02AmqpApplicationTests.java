package com.jinfei.amqp;

import com.jinfei.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");

//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

//        创建绑定规则
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqpadmin.haha",null));
    }
    /*
    * 1、单播（点对点）
    * */
    @Test
    void contextLoads() {
//        Message需要自己构造一个定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routeKey,message)；
//        object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routeKey,message);

        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
//        对象被默认序列化以后发送
        rabbitTemplate.convertAndSend("exchange.direct","jinfei.news",new Book("哈哈哈","jinfei"));

    }

    //接受数据，如何将数据自动的转为json发送出去
    @Test
    void receiveTest() {
        Object o = rabbitTemplate.receiveAndConvert("jinfei.news");
        System.out.println(o);
    }


    /*
    * 2、广播
    * */
    @Test
    void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("呵呵呵","金飞"));
    }

    @Test
    void receiveMsg() {
//        Object o = rabbitTemplate.receive();
//        System.out.println(o);
    }
}
