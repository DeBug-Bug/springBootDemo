package com.lds.springbootdemo.rocketMQ.producer;

import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.exception.ONSClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.exception.MQClientException;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.client.producer.*;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.Message;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageQueue;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Program:
 * @Description: mq发送消息的工具类
 * @Author: lidongsheng
 * @CreateData: 2019年8月28日 17:59
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
public class RocketMQProducerUtil {
    private Logger logger = LoggerFactory.getLogger(RocketMQProducerUtil.class);


    protected DefaultMQProducer sender;

    protected String nameServer;

    protected String groupName;

    protected String topic;

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

    public RocketMQProducerUtil(DefaultMQProducer sender,String nameServer, String groupName, String topic) {
        this.sender=sender;
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topic = topic;
    }

    /**
     * 同步发送消息
     *
     * @param msgTag      标签，可用于消息小分类标注
     * @param messageBody 消息body内容，生产者自定义内容
     * @param msgKey      消息key值，建议设置全局唯一，可不传，不影响消息投递
     * @param orderly     是否为顺序消息发送模式
     * @return success:SendResult or error:null
     */
    public SendResult sendMsg(String msgTag, byte[] messageBody, String msgKey,boolean orderly) {
        Message msg = new Message(this.topic, msgTag, msgKey, messageBody);
        if(!orderly) {
            return this.send(msg, Boolean.FALSE);
        } else {
            return this.sendOrderly(msg);
        }
    }

    /**
     * 同步发送定时/延时消息
     *
     * @param msgTag         标签，可用于消息小分类标注，对消息进行再归类
     * @param messageBody    消息body内容，生产者自定义内容，二进制形式的数据
     * @param msgKey         消息key值，建议设置全局唯一值，可不设置，不影响消息收发
     * @param orderly        是否为顺序消息发送模式
     * @param delayTimeLevel 消息延迟等级
     * @return success:SendResult or error:null
     */
    public SendResult sendTimeMsg(String msgTag, byte[] messageBody, String msgKey, int delayTimeLevel,boolean orderly) {
        Message msg = new Message(msgTag, msgKey, messageBody);
        msg.setDelayTimeLevel(delayTimeLevel);
        if(!orderly) {
            return this.send(msg, Boolean.FALSE);
        } else {
            return this.sendOrderly(msg);
        }
    }

    /**
     * 发送单向消息
     */
    public void sendOneWayMsg(String msgTag, byte[] messageBody, String msgKey) {
        Message msg = new Message(this.topic, msgTag, msgKey, messageBody);
        this.send(msg, Boolean.TRUE);
    }

    /**
     * 普通消息发送
     *
     * @param msg      消息
     * @param isOneWay 是否单向发送
     */
    private SendResult send(Message msg, Boolean isOneWay) {
        try {
            if (isOneWay) {
                //由于在 oneway 方式发送消息时没有请求应答处理，一旦出现消息发送失败，则会因为没有重试而导致数据丢失。
                //若数据不可丢，建议选用同步或异步发送方式。
                sender.sendOneway(msg);
                success(msg, "单向消息MsgId不返回");
                return null;
            } else {
                //可靠同步发送
                SendResult sendResult = sender.send(msg);
                //获取发送结果，不抛异常即发送成功
                if (sendResult != null) {
                    success(msg, sendResult.getMsgId());
                    return sendResult;
                } else {
                    error(msg, null);
                    return null;
                }
            }
        } catch (Exception e) {
            error(msg, e);
            return null;
        }
    }

    //对于使用异步接口，可设置单独的回调处理线程池，拥有更灵活的配置和监控能力。
    //根据项目需要，服务器配置合理设置线程数，线程太多有OOM 风险，
    private ExecutorService threads = Executors.newFixedThreadPool(3);
    //仅建议执行轻量级的Callback任务，避免阻塞公共线程池 引起其它链路超时。

    /**
     * 异步发送普通消息
     *
     * @param msgTag
     * @param messageBody
     * @param msgKey
     */
    public void sendAsyncMsg(String topic, String msgTag, byte[] messageBody, String msgKey) {
        sender.setCallbackExecutor(threads);
        Message msg = new Message(topic, msgTag, msgKey, messageBody);
        try {
            sender.send(msg, new SendCallback() {
                @Override
                public void onSuccess(final SendResult sendResult) {
                    assert sendResult != null;
                    success(msg, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    //出现异常意味着发送失败，为了避免消息丢失，建议缓存该消息然后进行重试。
                    error(msg, (Exception) throwable);
                }
            });
        } catch (ONSClientException e) {
            error(msg, e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 普通消息顺序发送
     * @param msg 消息
     * @return
     */
    private SendResult sendOrderly(Message msg) {

        try {
            //发送消息
            //SendResult result = sender.send(message);
            /*发送消息的时候，消息发送默认是会采用轮询的方式发送到不同的queue（分区）。
             * 消费端消费的时候，是会分配到多个queue的，多个queue是同时拉取提交消费。
             * 所以要想保证顺序消费必须要保证下面两点：
             * Producer端保证发送消息有序，且发送到同一个队列。
             * consumer端保证消费同一个队列。
             */
            SendResult sendResult = sender.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    Integer index = id % mqs.size();
                    return mqs.get((int) index);
                }
            }, 0);
            //获取发送结果，不抛异常即发送成功
            if (sendResult != null) {
                success(msg, sendResult.getMsgId());
                return sendResult;
            } else {
                error(msg, new Exception("sendResult为空"));
                return null;
            }
        } catch (Exception e) {
            error(msg, e);
            return null;
        }
    }
    //--------------日志打印----------
    private void error(Message msg,Exception e) {
        logger.error("发送MQ消息失败-- Topic:{}, Key:{}, tag:{}, body:{}"
                ,msg.getTopic(),msg.getKeys(),msg.getTags(),new String(msg.getBody()));
        logger.error("errorMsg --- {}",e.getMessage());
    }
    private void success(Message msg,String messageId) {
        logger.info("发送MQ消息成功 -- Topic:{} ,msgId:{} , Key:{}, tag:{}, body:{}"
                ,msg.getTopic(),messageId,msg.getKeys(),msg.getTags(),new String(msg.getBody()));
    }
}
