package com.learn.mybatis.pojo;

/**
 * @author :hly
 * @date :2018/5/5
 */
public class PageParam {
    private int start;
    private int limit;

    public PageParam() {
    }

    public PageParam(int start, int limit) {
        this.start = start;
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "start=" + start +
                ", limit=" + limit +
                '}';
    }
}
