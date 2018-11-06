package com.hanqi.service;

import com.hanqi.model.Appuser;

import java.util.List;

public interface AppuserService {
    List<Appuser> selectUsers();

    int insertUser(Appuser appuser);

    int updateUserStatus(Integer ids, Integer status);

    Appuser selectUserByIds(Integer ids);

    int updateUser(Appuser appuser);

    int appuserService(Integer ids);
}
