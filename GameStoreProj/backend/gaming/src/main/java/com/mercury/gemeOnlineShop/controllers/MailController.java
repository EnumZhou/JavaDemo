package com.mercury.gemeOnlineShop.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.gemeOnlineShop.beans.Email;
import com.mercury.gemeOnlineShop.beans.User;
import com.mercury.gemeOnlineShop.http.Response;
import com.mercury.gemeOnlineShop.services.MailService;
import com.mercury.gemeOnlineShop.services.UserService;


@Controller
public class MailController {

    @Autowired
    private MailService mailService;
    
    @Autowired 
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/sendMail")
    public String sendEmail(@RequestBody List<String> addressList) {
    	
    		Email email_email = new Email();
//           List<String> addressList = new ArrayList<String>();
//           addressList.add("s1272343@monmouth.edu");
           email_email.setToAddress(addressList);
           email_email.setSubject("java碎碎念-主题测试");// 主题
           email_email.setContent("你好！<br><br> 测试邮件发送成功！");
           // 发送邮件
           mailService.sendMail(email_email);

           return "ok";
    	
    	
//        Email email_email = new Email();
////        List<String> addressList = new ArrayList<String>();
////        addressList.add("s1272343@monmouth.edu");
//        email_email.setToAddress(addressList);
//        email_email.setSubject("java碎碎念-主题测试");// 主题
//        email_email.setContent("你好！<br><br> 测试邮件发送成功！");
//        // 发送邮件
//        mailService.sendMail(email_email);
//
//        return new Response(true);
    }
    
    @ResponseBody
    @PostMapping(value = "/sendMail1")
    public Response sendEmail1(@RequestBody List<String> addressList) {
        Email email_email = new Email();
//        List<String> addressList = new ArrayList<String>();
//        addressList.add("s1272343@monmouth.edu");
        email_email.setToAddress(addressList);
        email_email.setSubject("Register Success");// 主题
        email_email.setContent("Welcome to join Game Store!");
        // 发送邮件
        mailService.sendMail(email_email);

        return new Response(true);
    }
    
    @ResponseBody
    @RequestMapping(value = "/sendCancelMail/{order_ID}")
    public Response sendCancelMail(@RequestBody List<String> addressList,@PathVariable String order_ID) {
        Email email_email = new Email();
//        List<String> addressList = new ArrayList<String>();
//        addressList.add("s1272343@monmouth.edu");
        email_email.setToAddress(addressList);
        email_email.setSubject("Cancel Order");// 主题
        email_email.setContent("Hi Yinan, please cancel order "+order_ID);
        // 发送邮件
        mailService.sendMail(email_email);
        return new Response(true);
    }
    
    @ResponseBody
    @RequestMapping(value = "/sendShippingMail")
    public Response sendShippingMail(@RequestBody List<String> addressList) {
        Email email_email = new Email();
//        List<String> addressList = new ArrayList<String>();
//        addressList.add("s1272343@monmouth.edu");
        email_email.setToAddress(addressList);
        email_email.setSubject("Shipping Status");// 主题
        email_email.setContent("Thank you for shopping with us, your order has alreday been shipped.");
        // 发送邮件
        mailService.sendMail(email_email);
        return new Response(true);
    }
    
    @ResponseBody
    @PostMapping(value = "/sendMail2")
    public Response sendEmail2(@RequestBody List<String> addressList) {
        Email email_email = new Email();
//      List<String> addressList = new ArrayList<String>();
//      addressList.add("s1272343@monmouth.edu");
        email_email.setToAddress(addressList);
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
        	result+=random.nextInt(10);
        }
        System.out.println(result);
        String email = addressList.get(0);
        User u = userService.getUserByUsername(email);
        u.setPassword(result);
        userService.changePassword(u);
        email_email.setToAddress(addressList);
        email_email.setSubject("Forgot password");// 主题
        email_email.setContent("Hi, here is your new password "+result);
        // 发送邮件
        mailService.sendMail(email_email);

        return new Response(true);
    }
}
