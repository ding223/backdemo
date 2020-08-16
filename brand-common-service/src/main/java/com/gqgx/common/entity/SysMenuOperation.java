package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "sys_menu_operation")
public class SysMenuOperation {



    /*****************************新加字段开始************/
    /**
     * 是否选中
     */
    @Transient
    private String isCheck;

    /**************************新加字段结束*****************/

    /**
     * 表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单ID，对应sys_menu.id
     */
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 父操作Id，对应sys_menu_operation.id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 操作编码(比如：add，delete等)
     */
    private String code;

    /**
     * 操作地址
     */
    private String url;

    /**
     * 操作排序
     */
    private Integer sort;

    /**
     * 操作描述
     */
    private String remark;

    /**
     * 公司ID,对应sys_company.id
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
     * 获取表主键
     *
     * @return id - 表主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置表主键
     *
     * @param id 表主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单ID，对应sys_menu.id
     *
     * @return menu_id - 菜单ID，对应sys_menu.id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID，对应sys_menu.id
     *
     * @param menuId 菜单ID，对应sys_menu.id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取父操作Id，对应sys_menu_operation.id
     *
     * @return parent_id - 父操作Id，对应sys_menu_operation.id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父操作Id，对应sys_menu_operation.id
     *
     * @param parentId 父操作Id，对应sys_menu_operation.id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取操作名称
     *
     * @return name - 操作名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置操作名称
     *
     * @param name 操作名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取操作编码(比如：add，delete等)
     *
     * @return code - 操作编码(比如：add，delete等)
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置操作编码(比如：add，delete等)
     *
     * @param code 操作编码(比如：add，delete等)
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取操作地址
     *
     * @return url - 操作地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置操作地址
     *
     * @param url 操作地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取操作排序
     *
     * @return sort - 操作排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置操作排序
     *
     * @param sort 操作排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取操作描述
     *
     * @return remark - 操作描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置操作描述
     *
     * @param remark 操作描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取公司ID,对应sys_company.id
     *
     * @return company_id - 公司ID,对应sys_company.id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID,对应sys_company.id
     *
     * @param companyId 公司ID,对应sys_company.id
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

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }
}