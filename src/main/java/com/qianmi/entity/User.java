package com.qianmi.entity;

import java.io.Serializable;

/**
 * @program: spring-boot-test
 * @description: user
 * @author: zhoucy
 * @create: 2019-06-17 17:59
 */
public class User implements Serializable {

    private String channel;
    private String time;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
