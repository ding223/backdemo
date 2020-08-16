package com.gqgx.common.entity.vo;

import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandUsaTypeItem;

public class BrandUsaTypeItemVo extends BrandUsaTypeItem {

	private static final long serialVersionUID = 8461338873030297185L;
	
	/**
	 * 搜索内容
	 */
	private String filter;
	
	/**
	 * 大类
	 */
	private BrandLargeType brandLargeType;

	public BrandLargeType getBrandLargeType() {
		return brandLargeType;
	}

	public void setBrandLargeType(BrandLargeType brandLargeType) {
		this.brandLargeType = brandLargeType;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
}