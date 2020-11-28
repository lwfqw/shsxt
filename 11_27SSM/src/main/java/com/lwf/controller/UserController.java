package com.lwf.controller;

import com.lwf.pojo.User;
import com.lwf.pojo.vo.LayUiMsg;
import com.lwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author lwf
 * @title: UserController
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2519:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //所有用户
    @GetMapping("/all")
    public ModelAndView queryAll(){
        ModelAndView view=new ModelAndView();
        List<User> list=userService.queryAll();
        list.forEach(System.out::println);
        view.addObject("users",list);
        view.setViewName("listUser");
        return view;
    }
    //登录
    @PostMapping("/login")
    public ModelAndView login(String id, String password, HttpSession session){
        ModelAndView view=new ModelAndView();
        if(userService.check(id,password)){
            session.setAttribute("user", userService.getByEmail(id));
            view.setViewName("success");
        }else {
            view.addObject("msg", "email或密码错误");
            view.setViewName("redirect:/index.jsp");
        }
        return view;
    }
    //返回json数据layui数据表格数据
    @GetMapping("/json")
    @ResponseBody
    public LayUiMsg json(){
        List<User> list = userService.queryAll();
        LayUiMsg msg=new LayUiMsg();
        msg.setData(list);
        msg.setCode(0);
        msg.setMsg("layui");
        msg.setCount(list.size());
        return msg;
    }
    //去layui数据表格
    @GetMapping("/tojson")
    public String tojson(){
        return "ajaxUserList";
    }
    //转账
    @PostMapping("/transfor")
    public String finishTransfor(String email, Integer money, HttpSession session, Model model){
        User user= (User) session.getAttribute("user");
        boolean transfor = userService.transfor(user.getEmail(), email, new BigDecimal(money))?true:false;
        model.addAttribute("transfor","转账" +transfor);
       return "success";
    }
}
