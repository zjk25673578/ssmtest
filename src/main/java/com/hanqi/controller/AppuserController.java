package com.hanqi.controller;

import com.hanqi.model.Appuser;
import com.hanqi.service.AppuserService;
import com.hanqi.util.MyDate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/appuser")
public class AppuserController {

    @Autowired
    protected AppuserService appuserService;

    @RequestMapping("/{path}")
    public String formPage(@PathVariable("path") String path, String action, Model model) {
        model.addAttribute("action", action);
        return "page/users/" + path;
    }

    @RequestMapping("/showUsers")
    public String showUsers(Model model) {
        List<Appuser> list = appuserService.selectUsers();
        model.addAttribute("users", list);
        model.addAttribute("currMonth", MyDate.getCurrMonth());
        return "page/users/users";
    }

    @RequestMapping("/saveUser")
    public String saveUser(Appuser appuser, Model model) {
        model.addAttribute(appuser);
        int result;

        if (StringUtils.isEmpty(String.valueOf(appuser.getIds()))) {
            result = appuserService.insertUser(appuser);
        } else {
            result = appuserService.updateUser(appuser);
        }

        if (result > 0) {
            return "redirect:/appuser/showUsers";
        }
        model.addAttribute("message", "<font color='red'>保存失败</font>");
        return "/page/users/userinfo";
    }

    @RequestMapping("/updateUserStatus")
    public String updateUserStatus(Integer ids, Integer status, Model model) {
        int i = appuserService.updateUserStatus(ids, status);
        if (i > 0) {
            return "redirect:/appuser/showUsers";
        }
        model.addAttribute("message", "<font color='red'>修改用戶狀態失败</font>");
        return "/page/users/userinfo";
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(Integer ids, Model model) {
        Appuser appuser = null;
        if (ids != null) {
            appuser = appuserService.selectUserByIds(ids);
        }
        model.addAttribute(appuser);
        return "/page/users/userinfo";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer ids, Model model) {
        int result = appuserService.appuserService(ids);
        if (result > 0) {
            return "redirect:/appuser/showUsers";
        }
        model.addAttribute("message", "<font color='red'>刪除失败</font>");
        return "/page/users/userinfo";
    }
}
