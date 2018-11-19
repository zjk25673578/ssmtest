package com.hanqi.dao;

import com.hanqi.model.Sysmenu;

import java.util.List;
import java.util.Map;

public interface SysmenuDao {
    List<Sysmenu> trees();
    List<Map<String, Object>> trees2();
}
