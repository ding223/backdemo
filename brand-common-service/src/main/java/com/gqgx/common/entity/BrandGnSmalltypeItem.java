package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "brand_gn_smalltype_item")
public class BrandGnSmalltypeItem {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 子类表 brand_small_type.id
     */
    @Column(name = "small_type_id")
    private Long smallTypeId;

    /**
     * 组别
     */
    @Column(name = "group_no")
    private String groupNo;

    /**
     * 项目编号
     */
    @Column(name = "project_no")
    private String projectNo;

    /**
     * 项目名称（中文）
     */
    @Column(name = "project_cnname")
    private String projectCnname;

    /**
     * 项目名称（英文）
     */
    @Column(name = "project_enname")
    private String projectEnname;

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
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取子类表 brand_small_type.id
     *
     * @return small_type_id - 子类表 brand_small_type.id
     */
    public Long getSmallTypeId() {
        return smallTypeId;
    }

    /**
     * 设置子类表 brand_small_type.id
     *
     * @param smallTypeId 子类表 brand_small_type.id
     */
    public void setSmallTypeId(Long smallTypeId) {
        this.smallTypeId = smallTypeId;
    }

    /**
     * 获取组别
     *
     * @return group_no - 组别
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * 设置组别
     *
     * @param groupNo 组别
     */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    /**
     * 获取项目编号
     *
     * @return project_no - 项目编号
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * 设置项目编号
     *
     * @param projectNo 项目编号
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * 获取项目名称（中文）
     *
     * @return project_cnname - 项目名称（中文）
     */
    public String getProjectCnname() {
        return projectCnname;
    }

    /**
     * 设置项目名称（中文）
     *
     * @param projectCnname 项目名称（中文）
     */
    public void setProjectCnname(String projectCnname) {
        this.projectCnname = projectCnname == null ? null : projectCnname.trim();
    }

    /**
     * 获取项目名称（英文）
     *
     * @return project_enname - 项目名称（英文）
     */
    public String getProjectEnname() {
        return projectEnname;
    }

    /**
     * 设置项目名称（英文）
     *
     * @param projectEnname 项目名称（英文）
     */
    public void setProjectEnname(String projectEnname) {
        this.projectEnname = projectEnname == null ? null : projectEnname.trim();
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