package com.hanqi.controller;

import com.hanqi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController // ResponseBody + Controller
@Controller // ResponseBody + Controller
@RequestMapping("/tranc")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping("/test")
    public String test1(String str) {
        return str;
    }
}
