package com.hanqi.dao;

import com.hanqi.model.Reply;

import java.util.List;
import java.util.Map;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    Map<String, Object> getDetail(Integer id);

    List<Map<String, Object>> getReplys(String id);
}