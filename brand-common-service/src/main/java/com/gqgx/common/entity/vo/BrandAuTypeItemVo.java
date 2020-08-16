package com.gqgx.common.entity.vo;

import com.gqgx.common.entity.BrandAuTypeItem;

public class BrandAuTypeItemVo extends BrandAuTypeItem {

	private static final long serialVersionUID = 8461338873030297185L;
	
	/**
	 * 搜索内容
	 */
	private String filter;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
}