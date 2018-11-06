package com.hanqi.controller;

import com.hanqi.model.Attendic;
import com.hanqi.service.AttendanceService;
import com.hanqi.service.AttendicService;
import com.hanqi.util.MyDate;
import com.hanqi.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/attendance")
public class AttenDanceController {

    @Autowired
    protected AttendanceService attendanceService;
    @Autowired
    protected AttendicService attendicService;

    @RequestMapping("/showUserAttenInfo")
    public String showUserAttenInfo(Integer ids, Model model, int month) {
        List<Map<String, Object>> attenlist = attendanceService.selectUserAttenInfo(ids);
        Map<String, Object> mapInfo = MyUtil.list2MapInfo(attenlist);
        String realname = (String) attenlist.get(0).get("realname");
        model.addAttribute("attenlist", attenlist);
        model.addAttribute("row", 6);
        model.addAttribute("col", 7);
        model.addAttribute("firstweekday", MyDate.getMonthFirstDayWeek(month));
        model.addAttribute("maxDay", MyDate.getCurrentMonthDays(month));
        model.addAttribute("month", month);
        model.addAttribute("realname", realname);
        model.addAttribute("ids", ids);
        model.addAttribute("mapInfo", mapInfo);

        List<Attendic> dicList = attendicService.getList();
        model.addAttribute("dicList", dicList);
        return "page/atten/atteninfo";
    }

    @RequestMapping("/insertUserAttenInfo")
    public String insertUserAttenInfo(String code, String sign, String userid) {
        String[] date = sign.split("-");
        Map<String, Object> args = new HashMap<>();
        args.put("year", date[0]);
        args.put("month", date[1]);
        args.put("day", date[2]);
        args.put("ids", userid);
        args.put("atten", code);
        int result = attendanceService.insertAttenInfo(args);
        return "redirect:/attendance/showUserAttenInfo?ids=" + userid + "&month=" + date[1];
    }
}
