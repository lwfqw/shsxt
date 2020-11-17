package com.lwf.demo1.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lwf.demo1.utils.RandomCode;
import com.lwf.demo1.utils.SpringMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwf
 * @title: LoginAngRegisterController
 * @projectName demo1
 * @description: TODO
 * @date 2020/11/1515:44
 */
@RestController
@RequestMapping("/loginOrRegister")
public class LoginAngRegisterController {
    private static final Logger loger= LoggerFactory.getLogger(LoginAngRegisterController.class);
    @Autowired
    private DefaultKaptcha kaptcha;
    @Autowired
    private SpringMail mail;
    //验证码
    @RequestMapping("/image")
    public void image(HttpServletResponse response, HttpSession session){
        String text = kaptcha.createText();
        BufferedImage image = kaptcha.createImage(text);
        loger.info("验证码:"+text);
        session.setAttribute("imageCheck", text);
        try {
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    private TemplateEngine engine;
    @Autowired
    RandomCode randomCode;
    //发送验证邮箱
    @RequestMapping("/sendEmail")
    public void send(HttpSession session){
        String s = randomCode.get(6);
        session.setAttribute("mailCode", s);
        loger.info("邮箱验证码:"+s);
        Context context=new Context();
        context.setVariable("name", "熊某人");
        context.setVariable("code", s);
        String process = engine.process("mail/mail.html", context);
        mail.setSender("632593482@qq.com", "验证码", process);
    }
    //验证邮箱
    @RequestMapping("/checkEmail")
    public Map<String,String> checkEmailCode(String code){
        Map<String,String> val=new HashMap<>();
         return val;
    }
}
