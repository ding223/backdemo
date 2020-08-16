package com.gqgx.common.entity.vo;

import com.gqgx.common.entity.BrandDycTypeItem;
import com.gqgx.common.entity.BrandNavItem;

public class BrandDycTypeItemVo extends BrandDycTypeItem {

	private static final long serialVersionUID = 8461338873030297185L;
	
	/**
	 * 搜索内容
	 */
	private String filter;
	
	/**
	 * 导航
	 * @return
	 */
	private BrandNavItem navitem;

	public BrandNavItem getNavitem() {
		return navitem;
	}

	public void setNavitem(BrandNavItem navitem) {
		this.navitem = navitem;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
}