package com.hanqi.controller;

import com.hanqi.model.Message;
import com.hanqi.util.MyUtil;
import com.hanqi.util.quartz.QuartzUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/quartz0")
public class TestQuartzController {

    @RequestMapping("/main")
    public String main() {
        return "page/quartz/main";
    }

    @ResponseBody
    @RequestMapping("/executeQuartz")
    public Message executeQuartz(Date date, String loop) {
        System.out.println(loop);
        System.out.println(date);

        try {
            QuartzUtil.startOneTimeSchedule(date, loop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MyUtil.msg(1);
    }
}
