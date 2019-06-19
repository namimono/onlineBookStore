package com.hx5847.controller;

import com.hx5847.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@Controller
public class RankController {

//    @Autowired
//    private AnnounceService announceService;

    @ResponseBody
    @RequestMapping(value = "/getAllRank", method = RequestMethod.GET)
    public List<Book> getAllAnnoucenments(@RequestParam("types") String[] types, @RequestParam("condition")String condition) {
        for (String type:types){
            System.out.println(type);
        }
        System.out.println(condition);
//        List<Book> list = announceService.getAllAnnouncements();

        return null;
    }

}
