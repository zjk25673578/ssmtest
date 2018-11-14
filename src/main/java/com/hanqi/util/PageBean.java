package com.hanqi.util;

public class PageBean {
    private int rows;
    private int page;
    private int maxpage;
    private int minpage;

    public PageBean() {
        this.setPage(1);
        this.setRows(10);
        calMaxAndMin();
    }

    public PageBean(int rows, int page) {
        this.setPage(page);
        this.setRows(rows);
        calMaxAndMin();
    }

    private void calMaxAndMin() {
        this.maxpage = page * rows;
        this.minpage = (page - 1) * rows;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public int getMinpage() {
        return minpage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if (page < 1) {
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public void setRows(int rows) {
        if (rows < 1) {
            this.rows = 1;
            return;
        }
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }
}
