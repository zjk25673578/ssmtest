package com.hanqi.model;

public class Attencensus {
    private Integer ids;

    private Integer userid;

    private Integer year;

    private Integer month;

    private Integer atten;

    private Integer attentotal;

    private Byte status;

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getAtten() {
        return atten;
    }

    public void setAtten(Integer atten) {
        this.atten = atten;
    }

    public Integer getAttentotal() {
        return attentotal;
    }

    public void setAttentotal(Integer attentotal) {
        this.attentotal = attentotal;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}