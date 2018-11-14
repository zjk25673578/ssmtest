package com.hanqi.model;

import com.alibaba.fastjson.JSON;

public class Message {
    private boolean success;
    private String action;
    private int type;

    public Message() {
    }

    public Message(boolean success, String action, int type) {
        this.success = success;
        this.action = action;
        this.type = type;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
