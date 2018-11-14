package com.hanqi.service;

import com.hanqi.model.Emp;

import java.util.Map;

public interface EmpService {

    /**
     * 获取员工列表
     * @param objects
     * @return
     */
    Map<String, Object> selectEmps(Object... objects);

    /**
     * 添加一条记录
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);

    /**
     * 删除一条记录
     * @param empno
     * @return
     */
    int deleteEmp(Integer empno);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int delMultipleEmp(String ids);

    /**
     * 修改一条记录
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);
}
