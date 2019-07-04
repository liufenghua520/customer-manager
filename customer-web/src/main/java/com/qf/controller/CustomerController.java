package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Customer;
import com.qf.service.CustomerService;
import com.qf.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("/cus")
public class CustomerController {

    @Reference
    private CustomerService customerService;
    @Reference
    private EmailService emailService;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    public Object sendCode(@RequestParam String email, HttpSession session){
        System.out.println("用户邮箱: "+email);
        //int code = (int) (Math.random()*9000+1000);
        Random random = new Random();
        String code = (random.nextInt(9000)+1000)+"";
        System.out.println("生成的验证码: "+code);
        session.setAttribute("code",code);
        emailService.sendCode(email,code);
        return true;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object register(@RequestBody Customer customer,HttpSession session){
        System.out.println(customer);
        String code = (String) session.getAttribute("code");
        System.out.println("session中的验证码:  "+code);
        if (customer.getCode().equals(code)){
            customerService.register(customer);
            return true ;
        }
        return false;
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("loginCkeck")
    public String loginCkeck(@RequestBody Customer customer){
        System.out.println(customer);
        String username = customer.getUsername();
        String password = customer.getPassword();

        Boolean check = customerService.loginCheck(username, password);
        if (check){
            return "main";
        }
        return "登陆失败~";
    }

    @RequestMapping("toFindPass")
    public String toFindPass(){
        return "findpass";
    }

    @RequestMapping("fingPass")
    public String fingPass(){

        return "";
    }
    @RequestMapping("update")
    public String update(Customer customer){

        return "";
    }
}
