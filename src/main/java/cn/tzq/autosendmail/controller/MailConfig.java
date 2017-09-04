package cn.tzq.autosendmail.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @Author tzq24955
 * @Created on 2017/9/4
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
@Component
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
