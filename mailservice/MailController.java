package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.beans.Email;
import com.example.bookstore.services.MailService;


@Controller
public class MailController {

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/sendMail")
    public String sendEmail(@RequestBody List<String> addressList) {
        Email email_email = new Email();
//        List<String> addressList = new ArrayList<String>();
//        addressList.add("s1272343@monmouth.edu");
        email_email.setToAddress(addressList);
        email_email.setSubject("java碎碎念-主题测试");// 主题
        email_email.setContent("你好！<br><br> 测试邮件发送成功！");
        // 发送邮件
        mailService.sendMail(email_email);

        return "ok";
    }
}
