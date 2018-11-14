package com.hanqi.service.impl;

import com.hanqi.dao.SysmenuDao;
import com.hanqi.model.Sysmenu;
import com.hanqi.model.TreeModel;
import com.hanqi.service.SysmenuService;
import com.hanqi.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysmenuServiceImpl implements SysmenuService {

    @Autowired
    private SysmenuDao sysmenuDao;

    @Override
    public List<TreeModel> trees() {
        List<Sysmenu> list = sysmenuDao.trees();
        return MyUtil.convertMenuList(list, 0);
    }
}
