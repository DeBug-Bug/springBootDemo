package com.lds.springbootdemo.rocketMQ.producer;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.lds.springbootdemo.config.ProjectConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMQProducerTest {

    @Autowired
    private ProjectConfig projectConfig;

    @Test
    public void test(){
        String mqNameServer = projectConfig.getRocketMQAddress().split(";")[0];
        String mqTopics = "MQ-MSG-TOPICS-TEST";

        String producerMqGroupName = "PRODUCER-MQ-GROUP";
        //RocketMQProducer mqProducer = new RocketMQProducer(mqNameServer, producerMqGroupName, mqTopics);
        DefaultMQProducer defaultMQProducer=new DefaultMQProducer();
        RocketMQProducerUtil mqProducer=new RocketMQProducerUtil(defaultMQProducer,mqNameServer, producerMqGroupName, mqTopics);
        mqProducer.init();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        for (int i = 0; i < 100; i++) {
            String content="I send message to RocketMQ " + i;
            mqProducer.sendMsg(null,content.getBytes(),null,true);
        }
        defaultMQProducer.shutdown();
    }

}