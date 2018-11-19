package com.hanqi.service.impl;

import com.hanqi.dao.SysmenuDao;
import com.hanqi.model.Sysmenu;
import com.hanqi.service.ZtreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ZtreeServiceImpl implements ZtreeService {

    @Autowired
    private SysmenuDao sysmenuDao;

    @Override
    public List<Sysmenu> trees() {
        return sysmenuDao.trees();
    }

    @Override
    public List<Map<String, Object>> trees2() {
        return sysmenuDao.trees2();
    }
}
