package com.hx5847.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hx5847.beans.Announcement;
import com.hx5847.service.AnnounceService;
import com.hx5847.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin(origins = "*")
@Controller
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    @ResponseBody
    @RequestMapping(value = "/getAllAnnoucenments", method = RequestMethod.GET)
    public List<Announcement> getAllAnnoucenments() {
        List<Announcement> list = announceService.getAllAnnouncements();
        return list;
    }

    @RequestMapping(value = "/toAnnouncement/{id}", method = RequestMethod.GET)
    public String toAnnouncement(@PathVariable("id") Integer id, RedirectAttributes attr) {
        attr.addAttribute("annoId", id);
        System.out.println(id);
        return "redirect:/announcement.html";
    }

    @ResponseBody
    @RequestMapping(value = "/announcement/{id}",method = RequestMethod.GET)
    public Announcement getAnnouncement(@PathVariable("id") Integer id){
        System.out.println(id);
        Announcement announcement = announceService.getAnnouncement(id);
        return announcement;
    }

//    @ResponseBody
//    @RequestMapping(value = "/announcement2",method = RequestMethod.POST)
//    public String insertAnnouncement(@RequestBody  String param) throws IOException {
//        System.out.println(param);
//        Announcement announcement = JsonUtil.parse(param, Announcement.class);
//        System.out.println(announcement);
////        announceService.insertAnnouncement(announcement);
//
//        return "success";
//    }
    @ResponseBody
    @RequestMapping(value = "/announcement",method = RequestMethod.POST)
    public String insertAnnouncement(@RequestBody Announcement announcement){
        System.out.println(announcement);
        announceService.insertAnnouncement(announcement);

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/announcement/{id}",method = RequestMethod.PUT)
    public String updateAnnouncement(@RequestBody Announcement announcement){
        System.out.println(announcement);
        announceService.updateAnnouncement(announcement);
        return "success";
    }

}
