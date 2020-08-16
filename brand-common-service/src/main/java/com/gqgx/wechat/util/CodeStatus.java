package com.gqgx.wechat.util;

public enum CodeStatus {
	top("topStatus","3"), //置顶显示数
	hot("hotStatus","6"), //热门显示数
	commend("commendStatus","6");//推荐显示数
	private String key;
	private String value;

	private CodeStatus(String key) {
		this.key = key;
	}

	private CodeStatus(String key, String value) {
		this(key);
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValByKey(String key) {
		return Enum.valueOf(CodeStatus.class, key).getValue();
	}

	@Override
	public String toString() {
		return this.getKey();
	}
}
