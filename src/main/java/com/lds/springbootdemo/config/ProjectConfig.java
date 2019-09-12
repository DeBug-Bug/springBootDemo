package com.lds.springbootdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Program:
 * @Description:
 * @Author: lidongsheng
 * @CreateData: 18:43
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

    private String rocketMQAddress;

    public String getRocketMQAddress() {
        return rocketMQAddress;
    }

    public void setRocketMQAddress(String rocketMQAddress) {
        this.rocketMQAddress = rocketMQAddress;
    }


}
