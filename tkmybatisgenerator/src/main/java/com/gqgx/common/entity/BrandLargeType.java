package com.gqgx.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "brand_large_type")
public class BrandLargeType {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 目录
     */
    private String catalog;

    /**
     * 中文序号，第几类
     */
    private String cnno;

    /**
     * 序号，第几类
     */
    private String no;

    /**
     * 类别名
     */
    private String name;

    /**
     * 简介
     */
    private String instruction;

    /**
     * 说明
     */
    private String remark;

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
     * 获取目录
     *
     * @return catalog - 目录
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * 设置目录
     *
     * @param catalog 目录
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    /**
     * 获取中文序号，第几类
     *
     * @return cnno - 中文序号，第几类
     */
    public String getCnno() {
        return cnno;
    }

    /**
     * 设置中文序号，第几类
     *
     * @param cnno 中文序号，第几类
     */
    public void setCnno(String cnno) {
        this.cnno = cnno == null ? null : cnno.trim();
    }

    /**
     * 获取序号，第几类
     *
     * @return no - 序号，第几类
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置序号，第几类
     *
     * @param no 序号，第几类
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
     * 获取简介
     *
     * @return instruction - 简介
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * 设置简介
     *
     * @param instruction 简介
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    /**
     * 获取说明
     *
     * @return remark - 说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置说明
     *
     * @param remark 说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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