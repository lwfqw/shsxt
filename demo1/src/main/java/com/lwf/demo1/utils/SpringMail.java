package com.lwf.demo1.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URL;

/**
 * @author lwf
 * @title: SpringMail
 * @projectName demo1
 * @description:邮件
 * @date 2020/11/1115:05
 */
@Component
public class SpringMail {
    @Autowired
    private JavaMailSender sender;
    private static final Logger loger= LoggerFactory.getLogger(SpringMail.class);
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮件
     * @param to
     * @param submit
     * @param compnent
     */
    public void setSender(String to,String submit,String compnent) {
        MimeMessage mimeMessage =sender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(submit);
            //支持html
            helper.setText(compnent,true);
            sender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            loger.error("发送失败"+e.getMessage());
        }
    }
    public void setSender(String to, String submit, URL url) {
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = sender.createMimeMessage(url.openStream());
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(submit);
            sender.send(helper.getMimeMessage());
        } catch (Exception e) {
            loger.error("发送失败"+e.getMessage());
        }
    }
}
