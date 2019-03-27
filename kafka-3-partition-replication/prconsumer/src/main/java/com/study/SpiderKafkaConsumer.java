package com.study;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class SpiderKafkaConsumer implements MessageListener<Integer,String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> recoders) {
        String value = recoders.value();
        System.out.println("获取topic中的数据进行消费，内容：" + value);
    }
}
