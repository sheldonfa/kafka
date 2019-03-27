package com.study.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    /**
     *
     * 发送消息到spider-test这个topic
     * @param data<br/>
     * ============History===========<br/>
     * 2018年8月24日   Administrator    新建
     */
    public void sendSpider(String data) {

        kafkaTemplate.send("spider-test", data);
    }
}
