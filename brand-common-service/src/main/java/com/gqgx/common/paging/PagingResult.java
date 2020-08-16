package com.gqgx.common.paging;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Hunter on 2020-06-22.
 */
public class PagingResult<T> extends PageInfo<T>{

    private List<T> result;

    private long totalCount;

    public PagingResult(List<T> list){
        super(list);
    }


    public List<T> getResult() {
        return this.getList();
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return this.getTotal();
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
