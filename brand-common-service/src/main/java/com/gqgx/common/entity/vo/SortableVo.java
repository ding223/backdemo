package com.gqgx.common.entity.vo;

import java.util.List;

public class SortableVo {

	private Long id;
	
	private String name;
	
	private String remark;
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private List<SortableItemVo> items;

	
	public List<SortableItemVo> getItems() {
		return items;
	}

	public void setItems(List<SortableItemVo> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
