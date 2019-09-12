package com.lds.springbootdemo.rocketMQ.producer;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendResult;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.SendStatus;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.List;
import java.util.UUID;

/**
 * @Program:
 * @Description: MQ消息的生产者类RocketMQProducer.java
 * @Author: lidongsheng
 * @CreateData: 14:38
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
public class RocketMQProducer {
    private DefaultMQProducer sender;

    protected String nameServer;

    protected String groupName;

    protected String topics;

    public void init() {
        sender = new DefaultMQProducer(groupName);
        sender.setNamesrvAddr(nameServer);
        sender.setInstanceName(UUID.randomUUID().toString());
        sender.setVipChannelEnabled(false);
        try {
            sender.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public RocketMQProducer(String nameServer, String groupName, String topics) {
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topics = topics;
    }

    public void send(Message message) {

        message.setTopic(topics);
        //message.setTags("test");
        try {
            //发送消息
            SendResult result = sender.send(message);
            /*发送消息的时候，消息发送默认是会采用轮询的方式发送到不同的queue（分区）。
             * 消费端消费的时候，是会分配到多个queue的，多个queue是同时拉取提交消费。
             * 所以要想保证顺序消费必须要保证下面两点：
             * Producer端保证发送消息有序，且发送到同一个队列。
             * consumer端保证消费同一个队列。
             */
//            SendResult result = sender.send(message,new MessageQueueSelector() {
//                @Override
//                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
//                    Long id = (Long) arg;
//                    long index = id % mqs.size();
//                    return mqs.get((int)index);
//                }
//            }, 0);
            SendStatus status = result.getSendStatus();
            System.out.println("messageId=" + result.getMsgId() + ", status=" + status);
            sender.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
