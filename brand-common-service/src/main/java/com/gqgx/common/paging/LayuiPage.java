package com.gqgx.common.paging;

/**
 * Created by Hunter on 2020-06-22.
 */
public class LayuiPage {

    private int page = 1;//当前页
    private int limit = 10;
    private long total = 0;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
