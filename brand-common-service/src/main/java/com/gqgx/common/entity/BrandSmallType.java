package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "brand_small_type")
public class BrandSmallType {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 大类ID brand_large_type
     */
    @Column(name = "large_type_id")
    private Long largeTypeId;

    /**
     * 类别编号
     */
    private String no;

    /**
     * 类别名
     */
    private String name;

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
     * 获取大类ID brand_large_type
     *
     * @return large_type_id - 大类ID brand_large_type
     */
    public Long getLargeTypeId() {
        return largeTypeId;
    }

    /**
     * 设置大类ID brand_large_type
     *
     * @param largeTypeId 大类ID brand_large_type
     */
    public void setLargeTypeId(Long largeTypeId) {
        this.largeTypeId = largeTypeId;
    }

    /**
     * 获取类别编号
     *
     * @return no - 类别编号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置类别编号
     *
     * @param no 类别编号
     */
    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    /**
     * 获取类别名
     *
     * @return name - 类别名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名
     *
     * @param name 类别名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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