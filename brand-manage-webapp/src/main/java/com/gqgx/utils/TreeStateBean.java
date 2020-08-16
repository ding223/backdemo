package com.gqgx.utils;

import java.util.Map;

public class TreeStateBean extends TreeBean {

	private TreeStatus state;
	private String checked; // 表示该节点是否被选中
	private Map<String, Object> attributes; // 被添加到节点的自定义属性。
	
	public TreeStateBean() {
	}
	
	public TreeStateBean(String id, String text) {
		super(id, text);
	}
	
	public TreeStateBean(String id, String text,String checked) {
		super(id, text);
		this.checked = checked;
	}

	public TreeStatus getState() {
		return state;
	}

	public void setState(TreeStatus state) {
		this.state = state;
	}

	public String isChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
