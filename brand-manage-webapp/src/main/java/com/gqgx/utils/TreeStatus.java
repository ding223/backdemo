package com.gqgx.utils;

public class TreeStatus {

	private boolean opened;
	private boolean disabled;
	private boolean selected;
	
	public TreeStatus(){
		super();
	}
	
	public TreeStatus(boolean opened,boolean disabled,boolean selected){
		this.opened = opened;
		this.disabled = disabled;
		this.selected = selected;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
