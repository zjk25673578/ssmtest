package com.hanqi.service;

import com.hanqi.model.Sysmenu;

import java.util.List;
import java.util.Map;

public interface ZtreeService {
    List<Sysmenu> trees();

    List<Map<String, Object>> trees2();
}
