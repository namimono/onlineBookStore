package com.hx5847.controller;

import com.hx5847.beans.Advertisement;
import com.hx5847.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
