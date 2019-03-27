package com.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:kafka-consumer.xml")
public class SpiderKafkaConsumerTest {

    @Test
    public void test(){
        try {
            //等待键盘输入
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
