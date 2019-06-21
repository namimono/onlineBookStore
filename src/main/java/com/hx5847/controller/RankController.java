package com.hx5847.controller;

import com.hx5847.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")
@Controller
public class RankController {


//        如果前端传来的是一个对象（JSON对象），需要用RequestBody接收。
//        传来的是序列化值（表单提交结果，用RequestParam，或者直接用对应字段的对象即可）

    @ResponseBody
    @RequestMapping(value = "/getRank", method = RequestMethod.POST)
    public List<Book> getRank(@RequestBody Map<String, Object> types) {
        System.out.println(types);
//        List<Book> list = announceService.getAllAnnouncements();

        return null;
    }

}
