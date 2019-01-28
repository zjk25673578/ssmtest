package com.hanqi.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FormModel {

    private String name;

    private String password;

    /**
     * @DateTimeFormat 前台到后台
     * @JsonFormat 后台到前台
     * 网上看到的资料是这么说的, 但是经试验JsonFormat这个注解也可以对前台传入后台的值进行格式化
     */
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer city;

    private List<String> like;

    private String[] advance;

    private int switsh;

    private String sex;

    private String desp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public List<String> getLike() {
        return like;
    }

    public void setLike(List<String> like) {
        this.like = like;
    }

    public int getSwitsh() {
        return switsh;
    }

    public void setSwitsh(int switsh) {
        this.switsh = switsh;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    @Override
    public String toString() {
        return "FormModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", city=" + city +
                ", like=" + like +
                ", advance=" + Arrays.toString(advance) +
                ", switsh=" + switsh +
                ", sex='" + sex + '\'' +
                ", desp='" + desp + '\'' +
                '}';
    }

    public String[] getAdvance() {
        return advance;
    }

    public void setAdvance(String[] advance) {
        this.advance = advance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
