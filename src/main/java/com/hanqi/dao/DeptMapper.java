package com.hanqi.dao;

import com.hanqi.model.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer ids);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer ids);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}