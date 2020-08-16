package com.gqgx.utils;

import java.util.List;


/**
 * 树形JSON转换对象
 * 
 * @author tenney
 * 
 */
public class TreeBean extends EasyVO {

	private List<TreeBean> children; // 下级菜单

	public TreeBean() {
		super();
	}

	public TreeBean(String id, String text) {
		super(id, text);
	}

	public TreeBean(String id, String text, List<TreeBean> children) {
		super(id, text);
		this.children = children;
	}

	public List<TreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<TreeBean> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "[" + this.getId() + "," + this.getText() + "]";
	}

}
