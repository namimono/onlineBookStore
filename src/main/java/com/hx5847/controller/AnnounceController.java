package com.hx5847.controller;

import com.hx5847.beans.Announcement;
import com.hx5847.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    @ResponseBody
    @RequestMapping(value="/getAllAnnoucenments",method = RequestMethod.GET)
    public List<Announcement> getAllAnnoucenments(){
        List<Announcement> list = announceService.getAllAnnouncements();
        return list;
    }
}
