package com.hanqi.dao;

import com.hanqi.model.Attendance;

import java.util.List;
import java.util.Map;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer ids);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer ids);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

    List<Map<String, Object>> selectUserAttenInfo(Integer ids);

    int insertAttenInfo(Map<String, Object> args);
}