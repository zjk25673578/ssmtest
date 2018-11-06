package com.hanqi.service.impl;

import com.hanqi.dao.AppuserMapper;
import com.hanqi.model.Appuser;
import com.hanqi.service.AppuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppuserServiceImpl implements AppuserService {

    @Autowired
    private AppuserMapper appuserMapper;

    @Override
    public List<Appuser> selectUsers() {
        return appuserMapper.selectUsers();
    }

    @Override
    public int insertUser(Appuser appuser) {

        return appuserMapper.insertSelective(appuser);
    }

    @Override
    public int updateUserStatus(Integer ids, Integer status) {
        return appuserMapper.updateUserStatus(ids, status);
    }

    @Override
    public Appuser selectUserByIds(Integer ids) {
        return appuserMapper.selectByPrimaryKey(ids);
    }

    @Override
    public int updateUser(Appuser appuser) {
        return appuserMapper.updateByPrimaryKeySelective(appuser);
    }

    @Override
    public int appuserService(Integer ids) {
        return appuserMapper.deleteByPrimaryKey(ids);
    }
}
