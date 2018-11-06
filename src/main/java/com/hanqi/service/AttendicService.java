package com.hanqi.service;

import com.hanqi.model.Attendic;

import java.util.List;

public interface AttendicService {
    List<Attendic> getList();

    int updateDicInfo(Attendic attendic);

    int insertDicInfo(Attendic attendic);

    int updateDicStatus(Integer ids, Integer status);

    Attendic selectAttendic(Integer ids);

    int deleteDic(Integer ids);
}
