package com.hanqi.dao;

import com.hanqi.model.Appuser;

import java.util.List;

public interface AppuserMapper {
    int deleteByPrimaryKey(Integer ids);

    int insert(Appuser record);

    int insertSelective(Appuser record);

    Appuser selectByPrimaryKey(Integer ids);

    int updateByPrimaryKeySelective(Appuser record);

    int updateByPrimaryKey(Appuser record);

    List<Appuser> selectUsers();

    int updateUserStatus(Integer ids, Integer status);
}