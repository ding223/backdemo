package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_user_online")
public class SysUserOnline {
    /**
     * 主键PK
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录帐号ID对应sys_login_account.id
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 用户ID对应sys_user.id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户回话SESSION
     */
    @Column(name = "session_id")
    private String sessionId;

    /**
     * 用户请求IP地址
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * 当前状态(0在线 ，1离开，2繁忙）
     */
    @Column(name = "current_status")
    private String currentStatus;

    /**
     * 所属公司关联sys_company.id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 是否已经失效
     */
    @Column(name = "record_status")
    private String recordStatus;

    /**
     * 记录更新次数
     */
    @Column(name = "update_count")
    private Integer updateCount;

    /**
     * 记录创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 记录创建者ID
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 更新日期
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 更新者ID
     */
    @Column(name = "updater_id")
    private Long updaterId;

    /**
     * 获取主键PK
     *
     * @return id - 主键PK
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键PK
     *
     * @param id 主键PK
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录帐号ID对应sys_login_account.id
     *
     * @return account_id - 登录帐号ID对应sys_login_account.id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置登录帐号ID对应sys_login_account.id
     *
     * @param accountId 登录帐号ID对应sys_login_account.id
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取用户ID对应sys_user.id
     *
     * @return user_id - 用户ID对应sys_user.id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID对应sys_user.id
     *
     * @param userId 用户ID对应sys_user.id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户回话SESSION
     *
     * @return session_id - 用户回话SESSION
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 设置用户回话SESSION
     *
     * @param sessionId 用户回话SESSION
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    /**
     * 获取用户请求IP地址
     *
     * @return ip_address - 用户请求IP地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置用户请求IP地址
     *
     * @param ipAddress 用户请求IP地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * 获取当前状态(0在线 ，1离开，2繁忙）
     *
     * @return current_status - 当前状态(0在线 ，1离开，2繁忙）
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     * 设置当前状态(0在线 ，1离开，2繁忙）
     *
     * @param currentStatus 当前状态(0在线 ，1离开，2繁忙）
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus == null ? null : currentStatus.trim();
    }

    /**
     * 获取所属公司关联sys_company.id
     *
     * @return company_id - 所属公司关联sys_company.id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司关联sys_company.id
     *
     * @param companyId 所属公司关联sys_company.id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取是否已经失效
     *
     * @return record_status - 是否已经失效
     */
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     * 设置是否已经失效
     *
     * @param recordStatus 是否已经失效
     */
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 获取记录更新次数
     *
     * @return update_count - 记录更新次数
     */
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * 设置记录更新次数
     *
     * @param updateCount 记录更新次数
     */
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 获取记录创建日期
     *
     * @return create_date - 记录创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置记录创建日期
     *
     * @param createDate 记录创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取记录创建者ID
     *
     * @return creator_id - 记录创建者ID
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置记录创建者ID
     *
     * @param creatorId 记录创建者ID
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取更新日期
     *
     * @return update_date - 更新日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新日期
     *
     * @param updateDate 更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取更新者ID
     *
     * @return updater_id - 更新者ID
     */
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新者ID
     *
     * @param updaterId 更新者ID
     */
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }
}