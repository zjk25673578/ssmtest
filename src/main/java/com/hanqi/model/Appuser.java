package com.hanqi.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appuser {
    private Integer ids;

    private String username;

    private String realname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Byte status;

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appuser{" +
                "ids=" + ids +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}