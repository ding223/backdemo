package com.gqgx.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_position_operation")
public class SysPositionOperation {
    /**
     * 表主键
     */
    @Id
    private Long id;

    /**
     * 菜单ID，对应sys_menu.id
     */
    @Column(name = "menu_id")
    private Long menuId;

    /**
     * 对应职位id
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 系统菜单对应的操作表Id，对应sys_menu_operation.id
     */
    @Column(name = "menu_operation_id")
    private Long menuOperationId;

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
     * 获取对应职位id
     *
     * @return position_id - 对应职位id
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * 设置对应职位id
     *
     * @param positionId 对应职位id
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取系统菜单对应的操作表Id，对应sys_menu_operation.id
     *
     * @return menu_operation_id - 系统菜单对应的操作表Id，对应sys_menu_operation.id
     */
    public Long getMenuOperationId() {
        return menuOperationId;
    }

    /**
     * 设置系统菜单对应的操作表Id，对应sys_menu_operation.id
     *
     * @param menuOperationId 系统菜单对应的操作表Id，对应sys_menu_operation.id
     */
    public void setMenuOperationId(Long menuOperationId) {
        this.menuOperationId = menuOperationId;
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
}