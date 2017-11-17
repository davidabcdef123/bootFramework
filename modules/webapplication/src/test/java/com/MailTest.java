package com;

import com.dave.sun.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Super.Sun on 2017/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailTest {

    public static String from="1111@qq.com";
    public static String to = "111111111";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixinaaa\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixinaaa", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("主题：这是模板邮件");
        message.setText(emailContent);

        try {
            mailSender.send(message);
        } catch (Exception e) {
        }
    }

    /*@Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashedMap();
        model.put("username", "didi");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "template.vm", "UTF-8", model);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }*/

}
