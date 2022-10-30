package com.zhu.pojo;

import java.util.List;

// pagination JavaBean
public class PageBean<T> {

    private int totalCount;
    // current page data
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
