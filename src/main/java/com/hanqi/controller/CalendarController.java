package com.hanqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    @RequestMapping("/main")
    public String main() {
        return "page/util/calendar";
    }
}
