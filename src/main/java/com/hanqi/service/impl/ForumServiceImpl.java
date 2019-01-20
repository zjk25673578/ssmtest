package com.hanqi.service.impl;

import com.hanqi.dao.ArticleMapper;
import com.hanqi.dao.ReplyMapper;
import com.hanqi.model.Article;
import com.hanqi.model.Reply;
import com.hanqi.service.ArticleService;
import com.hanqi.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ForumServiceImpl implements ArticleService, ReplyService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public int saveOrUpdate(Article article) {
        Integer id = article.getId();
        if (id == null) {
            article.setCreateTime(new Date());
            return articleMapper.insertSelective(article);
        } else {
            return articleMapper.updateByPrimaryKeySelective(article);
        }
    }

    @Override
    public List<Article> list() {
        return articleMapper.list();
    }

    @Override
    public Article get(String id) {
        return articleMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int delete(String id) {
        return articleMapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public int saveReply(Reply reply) {
        return replyMapper.insertSelective(reply);
    }

    @Override
    public Map<String, Object> get(Integer id) {
        return replyMapper.getDetail(id);
    }

    @Override
    public List<Map<String, Object>> getReplys(String id) {
        return replyMapper.getReplys(id);
    }
}
