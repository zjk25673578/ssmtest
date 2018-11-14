package com.hanqi.controller;

import com.hanqi.model.Emp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ResponseBody + Controller
@RequestMapping("/zhaojk")
public class TestController {

    @RequestMapping("/test1")
    public String test1(String str) {
        System.out.println(str);
        return str;
    }

    @RequestMapping("/test2")
    public String test2(Emp emp) {
        System.out.println(emp);
        return emp.toString();
    }
}
