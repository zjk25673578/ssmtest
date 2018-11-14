package com.hanqi.service.impl;

import com.hanqi.dao.EmpDao;
import com.hanqi.model.Emp;
import com.hanqi.service.EmpService;
import com.hanqi.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public Map<String, Object> selectEmps(Object... objects) {
        Map<String, Object> args = null;
        try {
            args = MyUtil.bean2Map(objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Emp> list = empDao.selectEmpsByMysql(args);
        int count = empDao.selectEmpsCounts(args);
        Map<String, Object> resultMap = MyUtil.layData(0, "返回的消息", count, list);
        return resultMap;
    }

    @Override
    public int insertEmp(Emp emp) {
        return empDao.insertEmp(emp);
    }

    @Override
    public int deleteEmp(Integer empno) {
        return empDao.deleteEmp(empno == null ? -1 : empno);
    }

    @Override
    public int delMultipleEmp(String ids) {
        String[] ids_split = ids.split(",");
        return empDao.delMultipleEmp(ids_split);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }
}
