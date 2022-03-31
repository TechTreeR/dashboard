package com.techtree.portal.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Dysprosium
 * @title: MailServiceUtil
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-3013:56
 */
@Slf4j
@Component
public class MailServiceUtil {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("发送邮件成功");
        } catch (MailException e) {
            log.error("发送邮件失败");
        }
    }



}
