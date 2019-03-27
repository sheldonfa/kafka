package com.mypro.kafka.hello;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    /**
     * 大量写入producer，不consume，观察segment分段
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        /* 1、连接集群，通过配置文件的方式
         * 2、发送数据-topic:order，value
         */
        Properties props = new Properties();
        props.put("bootstrap.servers", "node01:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
        while (true) {
            // 发送数据 ,需要一个producerRecord对象,最少参数 String topic, V value
            kafkaProducer.send(new ProducerRecord<String, String>("segmenttest", "key", "{\"version\":1,\"partitions\":[{\"topic\":\"topic1\",\"partition\":0,\"replicas\":[7,1,2]},{\"topic\":\"topic1\",\"partition\":1,\"replicas\":[8,2,3]},{\"topic\":\"topic1\",\"partition\":2,\"replicas\":[9,3,4]}]}"));
        }
        // 加不加 kafkaProducer.flush()?
    }
}
