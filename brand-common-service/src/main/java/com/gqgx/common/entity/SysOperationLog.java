package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_operation_log")
public class SysOperationLog {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作用户的ID对应sys_user.id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 操作名称(例如：增删改查)
     */
    @Column(name = "operation_name")
    private String operationName;

    @Column(name = "operation_desc")
    private String operationDesc;

    /**
     * 操作URL
     */
    @Column(name = "operation_url")
    private String operationUrl;

    /**
     * ip地址
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * 浏览器名称
     */
    @Column(name = "brower_type")
    private String browerType;

    /**
     * 系统类型1:Windows,2Mac OS,3:Android，4其他
     */
    @Column(name = "termianl_type")
    private String termianlType;

    /**
     * 操作日期
     */
    @Column(name = "operation_date")
    private Date operationDate;

    /**
     * 公司ID对应sys_company.id
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
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作用户的ID对应sys_user.id
     *
     * @return user_id - 操作用户的ID对应sys_user.id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置操作用户的ID对应sys_user.id
     *
     * @param userId 操作用户的ID对应sys_user.id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取模块名称
     *
     * @return module_name - 模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块名称
     *
     * @param moduleName 模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取操作名称(例如：增删改查)
     *
     * @return operation_name - 操作名称(例如：增删改查)
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 设置操作名称(例如：增删改查)
     *
     * @param operationName 操作名称(例如：增删改查)
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    /**
     * @return operation_desc
     */
    public String getOperationDesc() {
        return operationDesc;
    }

    /**
     * @param operationDesc
     */
    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc == null ? null : operationDesc.trim();
    }

    /**
     * 获取操作URL
     *
     * @return operation_url - 操作URL
     */
    public String getOperationUrl() {
        return operationUrl;
    }

    /**
     * 设置操作URL
     *
     * @param operationUrl 操作URL
     */
    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl == null ? null : operationUrl.trim();
    }

    /**
     * 获取ip地址
     *
     * @return ip_address - ip地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置ip地址
     *
     * @param ipAddress ip地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * 获取浏览器名称
     *
     * @return brower_type - 浏览器名称
     */
    public String getBrowerType() {
        return browerType;
    }

    /**
     * 设置浏览器名称
     *
     * @param browerType 浏览器名称
     */
    public void setBrowerType(String browerType) {
        this.browerType = browerType == null ? null : browerType.trim();
    }

    /**
     * 获取系统类型1:Windows,2Mac OS,3:Android，4其他
     *
     * @return termianl_type - 系统类型1:Windows,2Mac OS,3:Android，4其他
     */
    public String getTermianlType() {
        return termianlType;
    }

    /**
     * 设置系统类型1:Windows,2Mac OS,3:Android，4其他
     *
     * @param termianlType 系统类型1:Windows,2Mac OS,3:Android，4其他
     */
    public void setTermianlType(String termianlType) {
        this.termianlType = termianlType == null ? null : termianlType.trim();
    }

    /**
     * 获取操作日期
     *
     * @return operation_date - 操作日期
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * 设置操作日期
     *
     * @param operationDate 操作日期
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * 获取公司ID对应sys_company.id
     *
     * @return company_id - 公司ID对应sys_company.id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID对应sys_company.id
     *
     * @param companyId 公司ID对应sys_company.id
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