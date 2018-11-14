package com.hanqi.dao;

import com.hanqi.model.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    /**
     * 获取员工列表
     * @param args
     * @return
     */
    List<Emp> selectEmpsByOracle(Map<String, Object> args);
    List<Emp> selectEmpsByMysql(Map<String, Object> args);

    /**
     * 添加一条记录
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);

    /**
     * 获取员工数量
     * @return
     */
    int selectEmpsCounts(Map<String, Object> args);

    /**
     * 删除一个员工
     * @param empno
     * @return
     */
    int deleteEmp(Integer empno);

    /**
     * 删除多个
     * @param ids_split
     * @return
     */
    int delMultipleEmp(String[] ids_split);

    /**
     * 修改一条记录
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);
}
