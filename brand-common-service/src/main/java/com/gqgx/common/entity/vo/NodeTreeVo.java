package com.gqgx.common.entity.vo;

import java.util.List;

public class NodeTreeVo {
	private Long id;
	private String text;
	private String icon="fa-star-o";
	private StateVo state=new StateVo();
	
	

	private List<NodeTreeVo> children;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<NodeTreeVo> getChildren() {
		return children;
	}
	public void setChildren(List<NodeTreeVo> children) {
		this.children = children;
	}
	public StateVo getState() {
		return state;
	}
	public void setState(StateVo state) {
		this.state = state;
	}
	

}
