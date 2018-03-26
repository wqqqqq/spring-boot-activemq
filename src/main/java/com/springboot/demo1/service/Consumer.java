package com.springboot.demo1.service;

import com.springboot.demo1.model.MqBean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.ObjectMessage;

@Service
public class Consumer {
    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    @JmsListener(destination = "test-queue")
    public void receiveMsg(String text){
        System.out.println("=========> receive message : " + text);
    }

    @JmsListener(destination = "test-queue-bean")
    public void receiveBean(ObjectMessage message) throws Exception{
        MqBean mqBean = (MqBean)message.getObject();
        System.out.println("=========> receive message : " + mqBean.getName());
    }
}
