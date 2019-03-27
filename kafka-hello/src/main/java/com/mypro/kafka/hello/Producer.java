package com.mypro.kafka.hello;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        // 1 加载配置文件
        Properties props = new Properties();
        // kafka服务器地址
        props.put("bootstrap.servers", "node01:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        // 指定序列化
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        // 2 创建kafkaproducer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
        // 3 发送消息
        for (int i = 0; i < 1000; i++) {
            // 发送数据 ,需要一个producerRecord对象,最少参数 String topic, V value
            kafkaProducer.send(new ProducerRecord<String, String>("order", "key"+i,"订单信息！"+i));
            Thread.sleep(100);
        }
    }
}
