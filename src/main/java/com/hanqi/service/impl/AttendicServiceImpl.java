package com.hanqi.service.impl;

import com.hanqi.dao.AttendicMapper;
import com.hanqi.model.Attendic;
import com.hanqi.service.AttendicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendicServiceImpl implements AttendicService {

    @Autowired
    private AttendicMapper attendicMapper;

    @Override
    public List<Attendic> getList() {
        return attendicMapper.getList();
    }

    @Override
    public int updateDicInfo(Attendic attendic) {
        return attendicMapper.updateByPrimaryKeySelective(attendic);
    }

    @Override
    public int insertDicInfo(Attendic attendic) {
        return attendicMapper.insertSelective(attendic);
    }

    @Override
    public int updateDicStatus(Integer ids, Integer status) {
        return attendicMapper.updateDicStatus(ids, status);
    }

    @Override
    public Attendic selectAttendic(Integer ids) {
        return attendicMapper.selectByPrimaryKey(ids);
    }

    @Override
    public int deleteDic(Integer ids) {
        return attendicMapper.deleteByPrimaryKey(ids);
    }
}
