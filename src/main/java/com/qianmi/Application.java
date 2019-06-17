package com.qianmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by qianmi on 2017/6/5.
 */
//@EntityScan(value="com.qianmi.entity")
@SpringBootApplication
public class Application {

    /**
     * main function
     * @param args params
     */
    public static void main(String[] args){
       SpringApplication.run(Application.class,args);
    }
}
