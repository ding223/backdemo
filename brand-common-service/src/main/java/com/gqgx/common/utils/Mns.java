package com.gqgx.common.utils;

public class Mns {
	
	/**
	 * 阿里云ID
	 */
	private String accessId;
	
	/**
	 * 阿里云key
	 */
	private String accessKey;
	
	/**
	 * 阿里云endpoint
	 */
	private String accountEndpoint;
	
	/**
	 * 主题
	 */
	private String topicName;
	
	/**
	 * 签单员队列
	 */
	private String singleUserQueueName;
	
	/**
	 * 外勤队列
	 */
	private String fieldPersonnelQueueName;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getSingleUserQueueName() {
		return singleUserQueueName;
	}

	public void setSingleUserQueueName(String singleUserQueueName) {
		this.singleUserQueueName = singleUserQueueName;
	}

	public String getFieldPersonnelQueueName() {
		return fieldPersonnelQueueName;
	}

	public void setFieldPersonnelQueueName(String fieldPersonnelQueueName) {
		this.fieldPersonnelQueueName = fieldPersonnelQueueName;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getAccountEndpoint() {
		return accountEndpoint;
	}

	public void setAccountEndpoint(String accountEndpoint) {
		this.accountEndpoint = accountEndpoint;
	}
	
}
