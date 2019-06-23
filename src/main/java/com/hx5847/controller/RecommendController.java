package com.hx5847.controller;

import com.hx5847.beans.Book;
import com.hx5847.service.RankService;
import com.hx5847.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
public class RecommendController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserRecommend/{id}", method = RequestMethod.GET)
    public Map<String ,Object> getUserRecommend(@PathVariable("id") Integer id){
        Map<String, Object> userRecommend = userService.getUserRecommendById(id);
        if (userRecommend==null){
            return null;
        }
        return userRecommend;
    }

    @ResponseBody
    @RequestMapping(value = "/generateRecommend/{id}", method = RequestMethod.GET)
    public String  generateRecommend(@PathVariable("id") Integer id){
        String msg = userService.generateUserRecommendById(id);
        return msg;
    }

}
