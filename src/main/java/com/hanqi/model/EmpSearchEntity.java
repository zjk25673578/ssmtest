package com.hanqi.model;

import java.util.Date;

public class EmpSearchEntity {
    private String ename;
    private Integer sex;
    private Integer min_sal;
    private Integer max_sal;
    private Integer min_age;
    private Integer max_age;
    private Date start_hiredate;
    private Date end_hiredate;

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

    public Integer getMin_sal() {
        return min_sal;
    }

    public void setMin_sal(Integer min_sal) {
        this.min_sal = min_sal;
    }

    public Integer getMax_sal() {
        return max_sal;
    }

    public void setMax_sal(Integer max_sal) {
        this.max_sal = max_sal;
    }

    public Integer getMin_age() {
        return min_age;
    }

    public void setMin_age(Integer min_age) {
        this.min_age = min_age;
    }

    public Integer getMax_age() {
        return max_age;
    }

    public void setMax_age(Integer max_age) {
        this.max_age = max_age;
    }

    public Date getStart_hiredate() {
        return start_hiredate;
    }

    public void setStart_hiredate(Date start_hiredate) {
        this.start_hiredate = start_hiredate;
    }

    public Date getEnd_hiredate() {
        return end_hiredate;
    }

    public void setEnd_hiredate(Date end_hiredate) {
        this.end_hiredate = end_hiredate;
    }

    @Override
    public String toString() {
        return "EmpSearchEntity{" +
                "ename='" + ename + '\'' +
                ", sex=" + sex +
                ", min_sal=" + min_sal +
                ", max_sal=" + max_sal +
                ", min_age=" + min_age +
                ", max_age=" + max_age +
                ", start_hiredate=" + start_hiredate +
                ", end_hiredate=" + end_hiredate +
                '}';
    }
}
