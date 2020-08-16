package com.gqgx.common.entity.vo;

import com.gqgx.common.entity.BrandGnSmalltypeItem;

public class BrandGnSmalltypeItemVo extends BrandGnSmalltypeItem {

	private static final long serialVersionUID = -9002817171754103988L;
	
	/**
	 * 大类ID
	 */
	private Long largeTypeId;
	
	/**
	 * 小类ID
	 */
	private Long smallTypeId;
	
	/**
	 * 搜索过滤
	 */
	private String filter;

	public Long getLargeTypeId() {
		return largeTypeId;
	}

	public void setLargeTypeId(Long largeTypeId) {
		this.largeTypeId = largeTypeId;
	}

	public Long getSmallTypeId() {
		return smallTypeId;
	}

	public void setSmallTypeId(Long smallTypeId) {
		this.smallTypeId = smallTypeId;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}