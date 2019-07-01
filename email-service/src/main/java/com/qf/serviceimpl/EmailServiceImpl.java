package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendCode(String email,int code)  {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom("hellojerk@sina.com");
            messageHelper.addTo(email);
            messageHelper.setSubject("验证码");
            messageHelper.setText("XXX平台注册中心：本次操作验证码为："+code);
            messageHelper.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }


}
