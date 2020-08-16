package com.gqgx.common.entity.vo;

import java.util.Date;

public class GqgxBookPeriodVo {

	private Long id;
	private String servicePeriod;
	private Long bookId;
	private String bookName;
	private String accountStatus;
	private String taxStatus;
	private String zeroDeclare;
	private Date createDate;
	private Long customerId;
	private String customerName;
	private String customerMobile;
	private Long wId;
	private String openId;
	private String noticeStatus;
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServicePeriod() {
		return servicePeriod;
	}
	public void setServicePeriod(String servicePeriod) {
		this.servicePeriod = servicePeriod;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getTaxStatus() {
		return taxStatus;
	}
	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}
	public String getZeroDeclare() {
		return zeroDeclare;
	}
	public void setZeroDeclare(String zeroDeclare) {
		this.zeroDeclare = zeroDeclare;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public Long getwId() {
		return wId;
	}
	public void setwId(Long wId) {
		this.wId = wId;
	}
	
}