package com.gqgx.common.entity.vo;

import com.gqgx.common.entity.BrandLargeType;
import com.gqgx.common.entity.BrandSmallType;

import java.util.List;

public class BrandLargeTypeVo extends BrandLargeType {

	private static final long serialVersionUID = 8980719581212865813L;

	/**
	 * 大类下的子类列表
	 */
	private List<BrandSmallType> smallTypeList;

	public List<BrandSmallType> getSmallTypeList() {
		return smallTypeList;
	}

	public void setSmallTypeList(List<BrandSmallType> smallTypeList) {
		this.smallTypeList = smallTypeList;
	}

}