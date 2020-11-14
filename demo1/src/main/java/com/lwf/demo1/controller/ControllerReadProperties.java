package com.lwf.demo1.controller;

import com.lwf.demo1.pojo.Panda;
import com.lwf.demo1.pojo.Zoo;
import com.lwf.demo1.server.PandaServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * @author lwf
 * @title: ControllerReadProperties
 * @projectName demo1
 * @description: TODO
 * @date 2020/10/2819:28
 */
@Controller
public class ControllerReadProperties {
    @Autowired
    private Panda panda;
    @Autowired
    private Zoo zoo;
    @Autowired
    private PandaServer pandaServer;
    @RequestMapping("/panda")
    @ResponseBody
    //获取配置文件数据
    public Panda propertiesReadPanda() throws UnsupportedEncodingException {
        System.out.println(panda);
        return panda;
    }
    //返回json数组
    @RequestMapping("/allPanda")
    @ResponseBody
    public List<Panda> allPanda(HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return pandaServer.allPanda();
    }

    //加requestBody接收不了数据
    @RequestMapping(value = "/insertPanda",method = RequestMethod.POST)
    @ResponseBody
    public boolean insertPanda(Panda panda2){
        return pandaServer.insert(panda2);
    }
    //路径参数
    @RequestMapping("/panda/{name}")
    @ResponseBody
    public boolean deletePanda(@PathVariable String name) throws UnsupportedEncodingException {
        System.out.println("删除"+name);
        return pandaServer.delete(name);
    }


    @ResponseBody
    @RequestMapping("/zoo")
    public Zoo propertiesReadZoo(){
        Zoo zoo1=new Zoo();
        zoo1.setName("上海");
        return zoo1;
    }
}
