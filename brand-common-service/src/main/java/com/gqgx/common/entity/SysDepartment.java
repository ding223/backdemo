package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_department")
public class SysDepartment {
    /**
     * 表主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 父部门ID对应sys_department.id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门级别,从1开始
     */
    private Integer level;

    /**
     * 同级部门显示顺序
     */
    private Integer seq;

    @Column(name = "department_desc")
    private String departmentDesc;

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
     * 旧的id
     */
    @Column(name = "old_department_id")
    private Long oldDepartmentId;

    /**
     * 是否是分公司0是，1否
     */
    @Column(name = "is_branch_company")
    private String isBranchCompany;

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
     * 获取父部门ID对应sys_department.id
     *
     * @return parent_id - 父部门ID对应sys_department.id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父部门ID对应sys_department.id
     *
     * @param parentId 父部门ID对应sys_department.id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取部门级别,从1开始
     *
     * @return level - 部门级别,从1开始
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置部门级别,从1开始
     *
     * @param level 部门级别,从1开始
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取同级部门显示顺序
     *
     * @return seq - 同级部门显示顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置同级部门显示顺序
     *
     * @param seq 同级部门显示顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * @return department_desc
     */
    public String getDepartmentDesc() {
        return departmentDesc;
    }

    /**
     * @param departmentDesc
     */
    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc == null ? null : departmentDesc.trim();
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

    /**
     * 获取旧的id
     *
     * @return old_department_id - 旧的id
     */
    public Long getOldDepartmentId() {
        return oldDepartmentId;
    }

    /**
     * 设置旧的id
     *
     * @param oldDepartmentId 旧的id
     */
    public void setOldDepartmentId(Long oldDepartmentId) {
        this.oldDepartmentId = oldDepartmentId;
    }

    /**
     * 获取是否是分公司0是，1否
     *
     * @return is_branch_company - 是否是分公司0是，1否
     */
    public String getIsBranchCompany() {
        return isBranchCompany;
    }

    /**
     * 设置是否是分公司0是，1否
     *
     * @param isBranchCompany 是否是分公司0是，1否
     */
    public void setIsBranchCompany(String isBranchCompany) {
        this.isBranchCompany = isBranchCompany == null ? null : isBranchCompany.trim();
    }
}