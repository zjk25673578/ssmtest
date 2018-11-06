package com.hanqi.dao;

import com.hanqi.model.Attendic;

import java.util.List;

public interface AttendicMapper {
    int deleteByPrimaryKey(Integer ids);

    int insert(Attendic record);

    int insertSelective(Attendic record);

    Attendic selectByPrimaryKey(Integer ids);

    int updateByPrimaryKeySelective(Attendic record);

    int updateByPrimaryKey(Attendic record);

    List<Attendic> getList();

    int updateDicStatus(Integer ids, Integer status);
}