package com.lds.springbootdemo.rocketMQ.consumer.MessageListenerConcurrently;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageExt;
import com.lds.springbootdemo.redis.RedisCacheService;

import java.util.List;

/**
 * @Program:
 * @Description:  MQ消息的监听接口类RocketMQListener.java
 * @Author: lidongsheng
 * @CreateData: 14:36
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
public class RocketMQListener1 implements MessageListenerConcurrently {

    private  RedisCacheService redisCacheService;

    public RocketMQListener1(RedisCacheService redisCacheService){
        this.redisCacheService = redisCacheService;
        this.redisCacheService.setHK("ROCKETMQ-TEST");

    }
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        System.out.println("get data from rocketMQ:" + msgs);
//        MessageExt message=msgs.get(0);
//        String msg = new String(message.getBody());
//        if(!redisCacheService.hasKeyForHash(message.getMsgId())){
//            redisCacheService.putForHash(message.getMsgId(),"1");
//            System.out.println("msg data from rocketMQ:" + msg+"-masId:"+message.getMsgId()+"-host"+message.getStoreHost()+"-time:"+System.currentTimeMillis());
//            System.out.println("msg data from rocketMQ:-BornTimestamp:"+ message.getBornTimestamp()+"-StoreTimestamp"+message.getStoreTimestamp());
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        }
        System.out.println("-------------------size:"+msgs.size());
        // 容易导致重复消费
        for (MessageExt message : msgs) {
            System.out.println("msg data from rocketMQ:" + message.getBody()+"-masId:"+message.getMsgId()+"-host"+message.getStoreHost()+"-time:"+System.currentTimeMillis());
            System.out.println("msg data from rocketMQ:-BornTimestamp:"+ message.getBornTimestamp()+"-StoreTimestamp"+message.getStoreTimestamp());
        }
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }
}
