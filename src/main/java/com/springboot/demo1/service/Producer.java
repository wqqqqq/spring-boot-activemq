package com.springboot.demo1.service;

import com.springboot.demo1.model.MqBean;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class Producer {
    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName, String message){
        System.out.println("============> send message : " + message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destinationName,message);
    }

    public void sendBean(String destinationName, MqBean mqBean){
        System.out.println("============> send bean : " + mqBean.getName());
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destinationName,mqBean);
    }
}
