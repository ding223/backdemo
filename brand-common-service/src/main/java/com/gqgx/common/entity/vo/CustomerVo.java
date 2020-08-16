package com.gqgx.common.entity.vo;

import java.text.DecimalFormat;

public class CustomerVo
{
    private Long id;
    
    private String customerName;
    
    private String customerMobile;
    
    /**
	 * 回答数量
	 */
	private Integer answerNumber;
	
	/**
	 * 采纳数量
	 */
	private Integer acceptAnswerNumber;
	
	/**
	 * 财富值
	 */
	private Integer userWealth;
	
	/**
	 * 帮助人数
	 */
	private Integer helpedpeopleNumber;
	
	/**
	 * 收到的赞
	 */
	private Integer praiseNumber;
	
	private String acceptAnswerL;
	
	public String getAcceptAnswerL() {
		DecimalFormat df = new DecimalFormat("#"); 
		if(null != this.answerNumber && null != this.acceptAnswerNumber && this.answerNumber > 0){
	       this.acceptAnswerL = df.format(Math.floor(this.acceptAnswerNumber*100/this.answerNumber));
		}
		
		return this.acceptAnswerL;
	}

	
	
	public void setAcceptAnswerL(String acceptAnswerL) {
		this.acceptAnswerL = acceptAnswerL;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(Integer answerNumber) {
		this.answerNumber = answerNumber;
	}

	public Integer getAcceptAnswerNumber() {
		return acceptAnswerNumber;
	}

	public void setAcceptAnswerNumber(Integer acceptAnswerNumber) {
		this.acceptAnswerNumber = acceptAnswerNumber;
	}

	public Integer getUserWealth() {
		return userWealth;
	}

	public void setUserWealth(Integer userWealth) {
		this.userWealth = userWealth;
	}

	public Integer getHelpedpeopleNumber() {
		return helpedpeopleNumber;
	}

	public void setHelpedpeopleNumber(Integer helpedpeopleNumber) {
		this.helpedpeopleNumber = helpedpeopleNumber;
	}

	public Integer getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(Integer praiseNumber) {
		this.praiseNumber = praiseNumber;
	}
	
	
    
    
    
}
