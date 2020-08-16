package com.gqgx.common.entity.vo;

public class StateVo {
	private String opened="true"; //节点处于打开状态

	private String disabled;
	
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getOpened() {
		return opened;
	}
	public void setOpened(String opened) {
		this.opened = opened;
	}
}
