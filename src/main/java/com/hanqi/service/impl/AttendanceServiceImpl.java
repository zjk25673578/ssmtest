package com.hanqi.service.impl;

import com.hanqi.dao.AttendanceMapper;
import com.hanqi.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<Map<String, Object>> selectUserAttenInfo(Integer ids) {
        return attendanceMapper.selectUserAttenInfo(ids);
    }

    @Override
    public int insertAttenInfo(Map<String, Object> args) {
        return attendanceMapper.insertAttenInfo(args);
    }
}
