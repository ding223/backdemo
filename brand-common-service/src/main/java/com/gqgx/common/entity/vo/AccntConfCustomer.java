package com.gqgx.common.entity.vo;

import java.io.Serializable;
import java.util.Date;


public class AccntConfCustomer implements  Serializable {

    /**
      * 描述:<p>TODO</p>
      * @Fields serialVersionUID
    */
    private static final long serialVersionUID = 2042376083940759070L;
    
    private String appDomainPath;

    /**
     * 主键ID<br/>
     * 对应数据库字段 accnt_conf_customer.id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private Long id;

    /**
     * 客户系统唯一标识<br/>
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private String appId;

    /**
     * 客户系统唯解密Key<br/>
     * 对应数据库字段 accnt_conf_customer.app_key
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private String appKey;

    /**
     * 是否已经失效<br/>
     * 对应数据库字段 accnt_conf_customer.record_status
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private String recordStatus;

    /**
     * 记录更新次数<br/>
     * 对应数据库字段 accnt_conf_customer.update_count
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    private Integer updateCount;

    /**
     * 记录创建日期<br/>
     * 对应数据库字段 accnt_conf_customer.create_date
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    private Date createDate;

    /**
     * 记录创建者ID<br/>
     * 对应数据库字段 accnt_conf_customer.creator_id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private Long creatorId;

    /**
     * 更新日期<br/>
     * 对应数据库字段 accnt_conf_customer.update_date
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private Date updateDate;

    /**
     * 更新者ID<br/>
     * 对应数据库字段 accnt_conf_customer.updater_id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    private Long updaterId;


    /**
     * 返回: 主键ID<br>
     * 对应数据库字段: accnt_conf_customer.id
     *
     * @返回  accnt_conf_customer.id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Long getId() {
        return id;
    }

    /**
     *  设置: 主键ID<br>
     * 对应数据库字段: accnt_conf_customer.id
     *
     * @param id 主键ID
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 客户系统唯一标识<br>
     * 对应数据库字段: accnt_conf_customer.app_id
     *
     * @返回  accnt_conf_customer.app_id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public String getAppId() {
        return appId;
    }

    /**
     *  设置: 客户系统唯一标识<br>
     * 对应数据库字段: accnt_conf_customer.app_id
     *
     * @param appId 客户系统唯一标识
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 返回: 客户系统唯解密Key<br>
     * 对应数据库字段: accnt_conf_customer.app_key
     *
     * @返回  accnt_conf_customer.app_key
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public String getAppKey() {
        return appKey;
    }

    /**
     *  设置: 客户系统唯解密Key<br>
     * 对应数据库字段: accnt_conf_customer.app_key
     *
     * @param appKey 客户系统唯解密Key
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * 返回: 是否已经失效<br>
     * 对应数据库字段: accnt_conf_customer.record_status
     *
     * @返回  accnt_conf_customer.record_status
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 是否已经失效<br>
     * 对应数据库字段: accnt_conf_customer.record_status
     *
     * @param recordStatus 是否已经失效
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 记录更新次数<br>
     * 对应数据库字段: accnt_conf_customer.update_count
     *
     * @返回  accnt_conf_customer.update_count
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 记录更新次数<br>
     * 对应数据库字段: accnt_conf_customer.update_count
     *
     * @param updateCount 记录更新次数
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 记录创建日期<br>
     * 对应数据库字段: accnt_conf_customer.create_date
     *
     * @返回  accnt_conf_customer.create_date
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 记录创建日期<br>
     * 对应数据库字段: accnt_conf_customer.create_date
     *
     * @param createDate 记录创建日期
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 记录创建者ID<br>
     * 对应数据库字段: accnt_conf_customer.creator_id
     *
     * @返回  accnt_conf_customer.creator_id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 记录创建者ID<br>
     * 对应数据库字段: accnt_conf_customer.creator_id
     *
     * @param creatorId 记录创建者ID
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 更新日期<br>
     * 对应数据库字段: accnt_conf_customer.update_date
     *
     * @返回  accnt_conf_customer.update_date
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新日期<br>
     * 对应数据库字段: accnt_conf_customer.update_date
     *
     * @param updateDate 更新日期
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 更新者ID<br>
     * 对应数据库字段: accnt_conf_customer.updater_id
     *
     * @返回  accnt_conf_customer.updater_id
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新者ID<br>
     * 对应数据库字段: accnt_conf_customer.updater_id
     *
     * @param updaterId 更新者ID
     *
     * @mbggenerated 2016-04-14 15:06
     */
    
    
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * getter method
     * @return the appDomainPath
     */
    
    public String getAppDomainPath()
    {
        return this.appDomainPath;
    }

    /**
     * setter method
     * @param appDomainPath the appDomainPath to set
     */
    
    public void setAppDomainPath(String appDomainPath)
    {
        this.appDomainPath = appDomainPath;
    }
    
    private String remark;


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    
    
    
    
}