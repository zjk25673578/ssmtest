package com.hanqi.service;

import com.hanqi.model.Reply;

import java.util.List;
import java.util.Map;

public interface ReplyService {

    int saveReply(Reply reply);

    Map<String, Object> get(Integer id);

    List<Map<String, Object>> getReplys(String id);
}
