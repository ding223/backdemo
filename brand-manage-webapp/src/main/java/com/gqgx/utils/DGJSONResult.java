package com.gqgx.utils;

import java.util.ArrayList;
import java.util.List;

public class DGJSONResult<T> {

	public List<T> rows = new ArrayList<T>();
	public long total = 0;
	public long records = 0;

	/**
	 * DGJSONResult.java的构造函数
	 */
	public DGJSONResult() {
		super();
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
		if (rows != null) {
			this.setTotal(rows.size());
		}
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	/**
	 * DGJSONResult.java的构造函数
	 * 
	 * @param rows
	 * @param total
	 */
	public DGJSONResult(List<T> rows, int total,int records) {
		super();
		this.rows = rows;
		this.total = total;
		this.records = records;
	}

	public DGJSONResult(List<T> rows, long total,long records) {
		super();
		this.rows = rows;
		this.total = total;
		this.records = records;
	}
}
