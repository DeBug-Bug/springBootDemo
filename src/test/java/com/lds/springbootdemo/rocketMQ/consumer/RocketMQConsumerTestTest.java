package com.lds.springbootdemo.rocketMQ.consumer;

import com.lds.springbootdemo.config.ProjectConfig;
import com.lds.springbootdemo.rocketMQ.consumer.MessageListenerConcurrently.RocketMQConsumer;
import com.lds.springbootdemo.rocketMQ.consumer.MessageListenerConcurrently.RocketMQListener;
import com.lds.springbootdemo.redis.RedisCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMQConsumerTestTest {

    @Autowired
    private RedisCacheService redisCacheService;

    @Autowired
    private ProjectConfig projectConfig;
    @Test
    public void test(){
        String mqNameServer = projectConfig.getRocketMQAddress();
        String mqTopics = "MQ-MSG-TOPICS-TEST";
        String consumerMqGroupName = "CONSUMER-MQ-GROUP";
        RocketMQListener mqListener = new RocketMQListener(redisCacheService);
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, mqNameServer, consumerMqGroupName, mqTopics);
        mqConsumer.init();


        try {
            Thread.sleep(1000 * 6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}