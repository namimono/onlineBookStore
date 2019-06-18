package com.hx5847.controller;

import com.hx5847.beans.Advertisement;
import com.hx5847.exceptions.UpdateException;
import com.hx5847.service.AdvertiseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;

    @ResponseBody
    @RequestMapping(value = "/getAllAdvertise" ,method = RequestMethod.GET)
    public List<Advertisement> getAllAdvertise(){
        List<Advertisement> list = advertiseService.getAdvertisements();
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/advertise/{id}" ,method = RequestMethod.GET)
    public Advertisement getAdvertise(@PathVariable("id") Integer id){
        Advertisement advertise = advertiseService.getAdvertise(id);
        return advertise;
    }

    @ResponseBody
    @RequestMapping(value = "/advertise/{id}" ,method = RequestMethod.DELETE)
    public String delAdvertise(@PathVariable("id") Integer id){

        String msg=advertiseService.delAdvertise(id);
        return msg;
    }
//    @ModelAttribute
//    public void getAdvBefore(@RequestParam(value = "id",required = false) Integer id,Map<String,Advertisement> map){
//        if (id!=null){
//            Advertisement advertise = advertiseService.getAdvertise(id);
//            map.put("adv",advertise);
//
//
//        }
//
//    }
    @ResponseBody
    @RequestMapping(value = "/updateAdvertise" ,method = RequestMethod.POST)
    public String  updateAdvertise(@RequestParam(value = "file",required = false) CommonsMultipartFile file, Advertisement advertisement) throws IOException {
        String msg=null;
        System.out.println(advertisement);
        System.out.println(file);
//        判断文件是否为空，如果不为空保存文件，并更新对象中的PicUrl
        if (!file.isEmpty()){
            File file1 = new File("../webapps/onlineBookStore/static/"+file.getOriginalFilename());
            file.transferTo(file1);
            String absolutePath = file1.getAbsolutePath();
            System.out.println(absolutePath);
            System.out.println("fileName："+file.getOriginalFilename());
            advertisement.setPicUrl("static/"+file.getOriginalFilename());
        }
        if(advertisement.getAdvId()==null){
            String s = advertiseService.insertAdvertise(advertisement);
            return s;
        }
        try {
            msg=advertiseService.updateAdvertise(advertisement);
        } catch (UpdateException e) {
            msg="fail";
        }
//        Advertisement advertise = advertiseService.getAdvertise(id);

        return msg;
    }
//    @ResponseBody
//    @RequestMapping(value = "/a" ,method = RequestMethod.POST)
//    public String  updateA(HttpServletRequest request, @RequestParam(value = "file",required = false)CommonsMultipartFile file) throws IOException {
//        File file1 = new File("../webapps/onlineBookStore/static"+file.getOriginalFilename());
//        file.transferTo(file1);
//        String absolutePath = file1.getAbsolutePath();
//        System.out.println(absolutePath);
////        InputStream resourceAsStream = servletContext.getResourceAsStream("pic1");
////        resourceAsStream.
////        Advertisement advertise = advertiseService.getAdvertise(id);
//
//        return "success";
//    }



}
