package com.lwf.controller;

import com.google.protobuf.compiler.PluginProtos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lwf
 * @title: FileController
 * @projectName 11_26SSM
 * @description: TODO
 * @date 2020/11/2620:13
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/go")
    public String goUpload(){
        return "file";
    }

    /**
     * 单个文件
     * @param file
     * @param model
     * @param rep
     * @return
     */
    @PostMapping("/one")
    public String oneFile(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest rep){
        //空文件
       if(file.isEmpty()){
           model.addAttribute("oneFileCode", "文件不能为空");
           return "file";
       }else {
           String filePath=rep.getServletContext().getRealPath("/")+"/upload";
           File upload=new File(filePath);
           if(!upload.exists()){
               upload.mkdir();
           }
           try {
               file.transferTo(new File(filePath,System.currentTimeMillis()+file.getOriginalFilename()));
               model.addAttribute("oneFileCode","文件传输成功");
           } catch (IOException e) {
               model.addAttribute("oneFileCode", "文件传输失败");
               e.printStackTrace();
           }finally {
               return "file";
           }
       }
    }

   //多个文件
   public void copyOne(MultipartFile file, HttpServletRequest rep){
       //空文件
       if(file.isEmpty()){
           return;
       }else {
           String filePath=rep.getServletContext().getRealPath("/")+"/upload";
           File upload=new File(filePath);
           if(!upload.exists()){
               upload.mkdir();
           }
           try {
               file.transferTo(new File(filePath,System.currentTimeMillis()+file.getOriginalFilename()));
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   @PostMapping("some")
   public String someFile(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request,Model model){
        int i=0;
       try {
           for(MultipartFile file:files){
              copyOne(file, request);
              i++;
           }
           model.addAttribute("someFileCode", "3个文件成功");
       }catch (Exception e){
           model.addAttribute("someFileCode", i+"个文件成功");
           System.out.println(e.getMessage());
       }finally {
           return "file";
       }
   }
}
