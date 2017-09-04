package cn.tzq.autosendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 功能描述
 *
 * @Author tzq24955
 * @Created on 2017/9/4
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
