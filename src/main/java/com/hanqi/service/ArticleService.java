package com.hanqi.service;

import com.hanqi.model.Article;

import java.util.List;

public interface ArticleService {

    int saveOrUpdate(Article article);

    List<Article> list();

    Article get(String id);

    int delete(String id);
}
