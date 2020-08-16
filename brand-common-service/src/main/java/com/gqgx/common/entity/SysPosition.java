package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_position")
public class SysPosition {


//    新增字段开始
    private static final long serialVersionUID = -6749093997114975681L;

    @Transient
    private Long sysMenuId;
    @Transient
    private String areaPrem;
    @Transient
    private String departmentName;
//    新增字段结束

    /**
     * 表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 上级职位id对应sys_position.id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 职位描述
     */
    private String remark;

    /**
     * 所属部门Id对应sys_department.id
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 所属公司id关联sys_company.id
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
     * 数据权限0本人，1本部门，2本部门及子部门，3全公司
     */
    @Column(name = "data_power")
    private String dataPower;

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
     * 获取上级职位id对应sys_position.id
     *
     * @return parent_id - 上级职位id对应sys_position.id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级职位id对应sys_position.id
     *
     * @param parentId 上级职位id对应sys_position.id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取职位名称
     *
     * @return name - 职位名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职位名称
     *
     * @param name 职位名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取职位描述
     *
     * @return remark - 职位描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置职位描述
     *
     * @param remark 职位描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取所属部门Id对应sys_department.id
     *
     * @return department_id - 所属部门Id对应sys_department.id
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置所属部门Id对应sys_department.id
     *
     * @param departmentId 所属部门Id对应sys_department.id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取所属公司id关联sys_company.id
     *
     * @return company_id - 所属公司id关联sys_company.id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司id关联sys_company.id
     *
     * @param companyId 所属公司id关联sys_company.id
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

    /**
     * 获取数据权限0本人，1本部门，2本部门及子部门，3全公司
     *
     * @return data_power - 数据权限0本人，1本部门，2本部门及子部门，3全公司
     */
    public String getDataPower() {
        return dataPower;
    }

    /**
     * 设置数据权限0本人，1本部门，2本部门及子部门，3全公司
     *
     * @param dataPower 数据权限0本人，1本部门，2本部门及子部门，3全公司
     */
    public void setDataPower(String dataPower) {
        this.dataPower = dataPower == null ? null : dataPower.trim();
    }

    public Long getSysMenuId() {
        return sysMenuId;
    }

    public void setSysMenuId(Long sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    public String getAreaPrem() {
        return areaPrem;
    }

    public void setAreaPrem(String areaPrem) {
        this.areaPrem = areaPrem;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "SysPosition{" +
                "sysMenuId=" + sysMenuId +
                ", areaPrem='" + areaPrem + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", departmentId=" + departmentId +
                ", companyId=" + companyId +
                ", recordStatus='" + recordStatus + '\'' +
                ", updateCount=" + updateCount +
                ", createDate=" + createDate +
                ", creatorId=" + creatorId +
                ", updateDate=" + updateDate +
                ", updaterId=" + updaterId +
                ", dataPower='" + dataPower + '\'' +
                '}';
    }
}