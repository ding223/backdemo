package com.gqgx.domain;

import com.gqgx.common.paging.PagingResult;

import java.io.Serializable;
import java.util.List;

public class LayUiResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer code;// 0 成功 1失败

	private String msg;// 消息

	private Long count;// 总记录数

	private List<T> data;// 返回数据

	public LayUiResult(){
		
	}
	
	public LayUiResult(PagingResult<T> pagingResult){
       this.count = pagingResult.getTotalCount();
       this.data = pagingResult.getResult();
       this.code = 0;
    }


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
