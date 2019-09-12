package com.lds.springbootdemo.rocketMQ.consumer.MessageListenerOrderly;


import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.UUID;

/**
 * @Program:
 * @Description:  MQ的消费类RocketMQConsumer.java：顺序消费模式
 * @Author: lidongsheng
 * @CreateData: 14:28
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
public class RocketMQConsumer {
    private DefaultMQPushConsumer consumer;

    private MessageListener listener;

    protected String nameServer;

    protected String groupName;

    protected String topics;

    public RocketMQConsumer(MessageListener listener, String nameServer, String groupName, String topics) {
        this.listener = listener;
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topics = topics;
    }

    public void init() {
        consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(nameServer);
        consumer.setVipChannelEnabled(false);
        try {
            consumer.subscribe(topics, "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        consumer.setInstanceName(UUID.randomUUID().toString());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener((MessageListenerOrderly) this.listener);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("RocketMQConsumer Started! group=" + consumer.getConsumerGroup() + " instance=" + consumer.getInstanceName()
        );
    }
}
