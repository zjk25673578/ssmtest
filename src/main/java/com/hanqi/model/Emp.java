package com.hanqi.model;

import java.util.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private Integer sex;
    private Integer age;
    private Date hiredate;
    private Double sal;
    private Integer comm;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getComm() {
        return comm;
    }

    public void setComm(Integer comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}
