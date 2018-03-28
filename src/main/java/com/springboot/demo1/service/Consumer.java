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
        System.out.println("r1=========> receive message : " + text);
    }

    @JmsListener(destination = "test-queue")
    public void receiveMsg2(String text){
        System.out.println("r2=========> receive message : " + text);
    }
    @JmsListener(destination = "test-queue-bean")
    public void receiveBean(ObjectMessage message) throws Exception{
        MqBean mqBean = (MqBean)message.getObject();
        System.out.println("=========> receive message : " + mqBean.getName());
    }



    @JmsListener(destination = "test-topic",containerFactory = "jmsListenerTopic")
    public void receiveTopic(String message) throws Exception{
        System.out.println("rt1=========> receive message : " + message.toString());
    }

    @JmsListener(destination = "test-topic",containerFactory = "jmsListenerTopic")
    public void receiveTopic2(String message) throws Exception{
        System.out.println("rt2=========> receive message : " + message.toString());
    }
}
