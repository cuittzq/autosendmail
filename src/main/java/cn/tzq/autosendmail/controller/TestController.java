package cn.tzq.autosendmail.controller;

import cn.tzq.autosendmail.utils.ExcelUtil;
import cn.tzq.autosendmail.utils.MailUtil;
import cn.tzq.autosendmail.utils.MimeMessageDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 功能描述
 *
 * @Author tzq24955
 * @Created on 2017/9/4
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
@RestController
@RequestMapping(value = "/SendMail")
@Log4j2
public class TestController {



    @Autowired
    private MailConfig mailconfig;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String helloDemo() {
        try {
            getexcelfiles();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return "邮件发送完毕。";
    }


    /**
     * @throws IOException
     * @throws InvalidFormatException
     */
    private void getexcelfiles() throws IOException, InvalidFormatException {
        ExcelUtil fastExcel = null;
        fastExcel = new ExcelUtil("D:\\邮件发送配置.xlsx");
        fastExcel.setSheetName("发送配置");
        List<SendMailNames> flightInfoList = fastExcel.parse(SendMailNames.class);
        if (flightInfoList != null) {
            flightInfoList.forEach(p -> {
                try {
                    log.info("开始发送给：{}，附件：{}", p.getMailRecipients(), p.getMailAttachment());
                    String userName = mailconfig.getUsername(); // 用户邮箱地址
                    String password = mailconfig.getPassword(); // 密码或者授权码
                    // 设置邮件内容
                    MimeMessageDTO mimeDTO = new MimeMessageDTO();
                    mimeDTO.setSentDate(new Date());
                    mimeDTO.setSubject(p.getMailTile());
                    mimeDTO.setText(p.getMailContext());
                    // 发送单邮件(附件)
                    List<String> filepath = new ArrayList<>();
                    filepath.add(p.getMailAttachment());
                    if (MailUtil.sendGroupEmailByFile(userName, password, p.getMailRecipients(), p.getMailCCRecipients(), mimeDTO, filepath)) {
                        System.out.println("邮件发送成功！");
                    } else {
                        System.out.println("邮件发送失败!!!");
                    }
                    log.info("成功发送给：{}，附件：{}", p.getMailRecipients(), p.getMailAttachment());
                    System.out.println(String.format("成功发送给：%s，附件：%s", p.getMailRecipients(), p.getMailAttachment()));
                } catch (Exception e) {
                    log.error(e);
                }
            });
        }
    }

    public MailConfig getMailconfig() {
        return mailconfig;
    }

    public void setMailconfig(MailConfig mailconfig) {
        this.mailconfig = mailconfig;
    }
}