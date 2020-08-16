package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "brand_usa_type_item")
public class BrandUsaTypeItem {
    /*
    * 新增字段
    * */
    private BrandLargeType brandLargeType;
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
     * 类-编号
     */
    @Column(name = "type_no")
        private String typeNo;

    @Column(name = "project_name")
    private String projectName;

    /**
     * 译文
     */
    @Column(name = "project_translation")
    private String projectTranslation;

    /**
     * 状态
     */
    @Column(name = "project_status")
    private String projectStatus;

    /**
     * 生效日期
     */
    @Column(name = "project_invalid_date")
    private String projectInvalidDate;

    /**
     * 类型
     */
    @Column(name = "project_type")
    private String projectType;

    /**
     * 版本
     */
    @Column(name = "project_version")
    private String projectVersion;

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
     * 获取类-编号
     *
     * @return type_no - 类-编号
     */
    public String getTypeNo() {
        return typeNo;
    }

    /**
     * 设置类-编号
     *
     * @param typeNo 类-编号
     */
    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo == null ? null : typeNo.trim();
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取译文
     *
     * @return project_translation - 译文
     */
    public String getProjectTranslation() {
        return projectTranslation;
    }

    /**
     * 设置译文
     *
     * @param projectTranslation 译文
     */
    public void setProjectTranslation(String projectTranslation) {
        this.projectTranslation = projectTranslation == null ? null : projectTranslation.trim();
    }

    /**
     * 获取状态
     *
     * @return project_status - 状态
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * 设置状态
     *
     * @param projectStatus 状态
     */
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    /**
     * 获取生效日期
     *
     * @return project_invalid_date - 生效日期
     */
    public String getProjectInvalidDate() {
        return projectInvalidDate;
    }

    /**
     * 设置生效日期
     *
     * @param projectInvalidDate 生效日期
     */
    public void setProjectInvalidDate(String projectInvalidDate) {
        this.projectInvalidDate = projectInvalidDate == null ? null : projectInvalidDate.trim();
    }

    /**
     * 获取类型
     *
     * @return project_type - 类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置类型
     *
     * @param projectType 类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    /**
     * 获取版本
     *
     * @return project_version - 版本
     */
    public String getProjectVersion() {
        return projectVersion;
    }

    /**
     * 设置版本
     *
     * @param projectVersion 版本
     */
    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion == null ? null : projectVersion.trim();
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

    public BrandLargeType getBrandLargeType() {
        return brandLargeType;
    }

    public void setBrandLargeType(BrandLargeType brandLargeType) {
        this.brandLargeType = brandLargeType;
    }
}