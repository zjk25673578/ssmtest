package com.hanqi.dao;

import com.hanqi.model.Attencensus;

public interface AttencensusMapper {
    int deleteByPrimaryKey(Integer ids);

    int insert(Attencensus record);

    int insertSelective(Attencensus record);

    Attencensus selectByPrimaryKey(Integer ids);

    int updateByPrimaryKeySelective(Attencensus record);

    int updateByPrimaryKey(Attencensus record);
}