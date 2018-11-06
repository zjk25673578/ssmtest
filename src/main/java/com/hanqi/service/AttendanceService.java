package com.hanqi.service;

import java.util.List;
import java.util.Map;

public interface AttendanceService {
    List<Map<String, Object>> selectUserAttenInfo(Integer ids);

    int insertAttenInfo(Map<String, Object> args);
}
