package com.hanqi.controller;

import com.hanqi.model.Attendic;
import com.hanqi.service.AttendicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attendic")
public class AttenDicController {

    @Autowired
    protected AttendicService attendicService;

    @RequestMapping("/showDics")
    public String showDics(Model model) {
        List<Attendic> list = attendicService.getList();
        model.addAttribute("list", list);
        return "page/attendic/diclist";
    }

    @RequestMapping("/updateDicInfo")
    public String updateDicInfo(String action, Model model, Integer ids) {
        Attendic attendic;
        if (ids != null) {
            attendic = attendicService.selectAttendic(ids);
            model.addAttribute("dic", attendic);
        }
        model.addAttribute("action", action);
        return "page/attendic/dicinfo";
    }

    @RequestMapping("/saveDic")
    public String saveDic(Attendic attendic, Model model) {
        Integer ids = attendic.getIds();
        int result = -1;
        if (ids != null) {
            result = attendicService.updateDicInfo(attendic);
            model.addAttribute("action", "update");
        } else {
            result = attendicService.insertDicInfo(attendic);
            model.addAttribute("action", "add");
        }
        if (result > 0) {
            return "redirect:/attendic/showDics";
        }
        return "redirect:/attendic/updateDicInfo";
    }

    @RequestMapping("/updateDicStatus")
    public String updateDicStatus(Integer ids, Integer status) {
        int result = attendicService.updateDicStatus(ids, status);
        return "redirect:/attendic/showDics";
    }

    @RequestMapping("/deleteDic")
    public String deleteDic(Integer ids) {
        int result = attendicService.deleteDic(ids);
        return "redirect:/attendic/showDics";
    }
}
