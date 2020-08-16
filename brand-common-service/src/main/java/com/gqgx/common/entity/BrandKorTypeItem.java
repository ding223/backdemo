package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "brand_kor_type_item")
public class BrandKorTypeItem {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * brand_large_type.id
     */
    @Column(name = "large_type_id")
    private Long largeTypeId;

    /**
     * 类别
     */
    @Column(name = "type_no")
    private String typeNo;

    /**
     * 项目
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 类似群
     */
    @Column(name = "project_group")
    private String projectGroup;

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
     * 获取brand_large_type.id
     *
     * @return large_type_id - brand_large_type.id
     */
    public Long getLargeTypeId() {
        return largeTypeId;
    }

    /**
     * 设置brand_large_type.id
     *
     * @param largeTypeId brand_large_type.id
     */
    public void setLargeTypeId(Long largeTypeId) {
        this.largeTypeId = largeTypeId;
    }

    /**
     * 获取类别
     *
     * @return type_no - 类别
     */
    public String getTypeNo() {
        return typeNo;
    }

    /**
     * 设置类别
     *
     * @param typeNo 类别
     */
    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo == null ? null : typeNo.trim();
    }

    /**
     * 获取项目
     *
     * @return project_name - 项目
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目
     *
     * @param projectName 项目
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取类似群
     *
     * @return project_group - 类似群
     */
    public String getProjectGroup() {
        return projectGroup;
    }

    /**
     * 设置类似群
     *
     * @param projectGroup 类似群
     */
    public void setProjectGroup(String projectGroup) {
        this.projectGroup = projectGroup == null ? null : projectGroup.trim();
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