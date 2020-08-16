package com.gqgx.common.entity.vo;

import java.util.List;

public class LayUITreeVo {
	private Long id;
	private String name;
	private Boolean spread;
	private List<LayUITreeVo> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public List<LayUITreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<LayUITreeVo> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		return "LayUITreeVo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", spread=" + spread +
				", children=" + children +
				'}';
	}
}
