package com.gqgx.utils;
/**
 * Easyui ajax传递 vo对象
 * @author tenney
 *
 */
public class EasyVO {

	private String id; // ID标识
	private String text; // 显示名称

	public EasyVO() {
		super();
	}

	public EasyVO(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
