package com.jinfei.springboot04task;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {

        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知：今晚开会");
        message.setText("今晚7:30开会");
        message.setTo("jinfei_0224@163.com");
        message.setFrom("1677016493@qq.com");

        mailSender.send(message);
    }

    @Test
    void test02() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("通知：今晚开会");
        helper.setText("<b style='color:red'>今晚7:30开会</b>",true);
        helper.setTo("jinfei_0224@163.com");
        helper.setFrom("1677016493@qq.com");

        //上传文件
        helper.addAttachment("1.jpg", new File(""));
        helper.addAttachment("2.jpg", new File(""));
        mailSender.send(mimeMessage);

    }

}
