package com.study.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:kafka-producer.xml")
public class KafkaProducerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    /**
     * 简单字符串的测试
     * @throws Exception
     */
    @Test
    public void testProducer() throws Exception {
        String data = "spring集成kafka发送的生产者数据sssssssss";
        kafkaProducer.sendSpider(data);

    }

}

