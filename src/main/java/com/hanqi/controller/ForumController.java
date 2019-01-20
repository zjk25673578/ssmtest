package com.hanqi.controller;

import com.alibaba.fastjson.JSONObject;
import com.hanqi.model.Appuser;
import com.hanqi.model.Article;
import com.hanqi.model.Reply;
import com.hanqi.service.AppuserService;
import com.hanqi.service.ArticleService;
import com.hanqi.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ArticleService forumService;
    @Autowired
    private AppuserService appuserService;
    @Autowired
    private ReplyService replyService;

    /**
     * 论坛主题列表
     *
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<Article> list = forumService.list();
        model.addAttribute("articleList", list);
        return "page/forum/list";
    }

    @RequestMapping("/add")
    public String add() {
        return "page/forum/add";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Article article) {
        forumService.saveOrUpdate(article);
        return "redirect:list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Article article = forumService.get(id);
        model.addAttribute("article", article);
        List<Appuser> userList = appuserService.selectUsers();
        model.addAttribute("userList", userList);
        List<Map<String, Object>> replyList = replyService.getReplys(id);
        model.addAttribute("replyList", replyList);
        return "page/forum/detail";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        forumService.delete(id);
        return "redirect:/forum/list";
    }

    @ResponseBody
    @RequestMapping("/saveReply")
    public String saveReply(Reply reply, HttpSession session) {
        Appuser currenUser = (Appuser) session.getAttribute("currentUser");
        reply.setUserId(currenUser.getIds());
        reply.setReplyTime(new Date());
        int r = replyService.saveReply(reply);
        JSONObject jo = new JSONObject();
        if (r > 0) {
            Map<String, Object> _reply = replyService.get(reply.getId());
            jo.put("success", true);
            jo.put("reply", _reply);
            return jo.toJSONString();
        }
        jo.put("success", false);
        return jo.toJSONString();
    }
}
