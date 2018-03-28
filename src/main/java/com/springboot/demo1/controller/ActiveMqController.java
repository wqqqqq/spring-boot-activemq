package com.springboot.demo1.controller;

import com.springboot.demo1.model.MqBean;
import com.springboot.demo1.service.Producer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/activemq")
@RestController
public class ActiveMqController {
    @Resource
    Producer producer;

    @RequestMapping("/sendMsg")
    public String sendMsg(){
        for (int i = 0; i < 10; i++){
            producer.sendMsg("test-queue","hello world --" + i);
        }
        return "send successfully";
    }

    @RequestMapping("/sendBean")
    public String sendBean(){
        MqBean bean;
        for (int i = 0; i < 10; i++){
            bean = new MqBean();
            bean.setName("man-" + i);
            producer.sendBean("test-queue-bean", bean);
        }
        return "send bean successfully";
    }

    @RequestMapping("/sendTopic")
    public String sendTopic(){
        for (int i = 0; i < 10; i++){
            String msg = "topic message" + i;
            producer.sendMsgTopic("test-topic", msg);
        }
        return "send topic successfully";
    }
}
