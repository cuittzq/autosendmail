package cn.tzq.autosendmail.controller;

import cn.tzq.autosendmail.utils.MapperCell;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 功能描述
 *
 * @Author tzq24955
 * @Created on 2017/9/4
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendMailNames {
    /**
     * 邮件标题
     */
    @MapperCell(cellName = "邮件标题", order = 0)
    private String mailTile;
    /**
     * 邮件内容
     */
    @MapperCell(cellName = "邮件内容", order = 1)
    private String mailContext;

    /**
     * 邮件发送人
     */
    @MapperCell(cellName = "邮件发送人", order = 2)
    private String mailSendName;

    /**
     * 邮件收件人用,号隔开
     */
    @MapperCell(cellName = "邮件接收人", order = 3)
    private String mailRecipients;

    /**
     * 邮件抄送人,号隔开
     */
    @MapperCell(cellName = "邮件抄送人", order = 4)
    private String mailCCRecipients;

    /**
     * 多个附件用;号隔开
     */
    @MapperCell(cellName = "附件", order = 5)
    private String mailAttachment;

    /**
     * 附件名称
     */
    @MapperCell(cellName = "附件名称", order = 6)
    private String mailAttachmentName;
}
