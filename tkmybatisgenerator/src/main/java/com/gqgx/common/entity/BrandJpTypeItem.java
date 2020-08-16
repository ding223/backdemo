package com.gqgx.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "brand_jp_type_item")
public class BrandJpTypeItem {
    /**
     * 主键
     */
    @Id
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
     * Coor(C)——统一国家局预批准的商品和服务清单描述公共数据库。使用来自该数据库的描述将在商标申请中自动获参与国家局接受。
     */
    @Column(name = "project_coor")
    private String projectCoor;

    /**
     * Harm(H)——参与商品和服务统一化的所有国家局接受的术语
     */
    @Column(name = "project_harm")
    private String projectHarm;

    /**
     * Nice(N)——官方字母索引尼斯分类中的术语
     */
    @Column(name = "project_nice")
    private String projectNice;

    /**
     * IDli(I)——所有 TM5 国家局接受的术语
     */
    @Column(name = "project_idli")
    private String projectIdli;

    /**
     * MGS(M)——源自马德里商品和服务且在马德里申请中获世界知识产权组织接受的术语
     */
    @Column(name = "project_mgs")
    private String projectMgs;

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
     * 获取Coor(C)——统一国家局预批准的商品和服务清单描述公共数据库。使用来自该数据库的描述将在商标申请中自动获参与国家局接受。
     *
     * @return project_coor - Coor(C)——统一国家局预批准的商品和服务清单描述公共数据库。使用来自该数据库的描述将在商标申请中自动获参与国家局接受。
     */
    public String getProjectCoor() {
        return projectCoor;
    }

    /**
     * 设置Coor(C)——统一国家局预批准的商品和服务清单描述公共数据库。使用来自该数据库的描述将在商标申请中自动获参与国家局接受。
     *
     * @param projectCoor Coor(C)——统一国家局预批准的商品和服务清单描述公共数据库。使用来自该数据库的描述将在商标申请中自动获参与国家局接受。
     */
    public void setProjectCoor(String projectCoor) {
        this.projectCoor = projectCoor == null ? null : projectCoor.trim();
    }

    /**
     * 获取Harm(H)——参与商品和服务统一化的所有国家局接受的术语
     *
     * @return project_harm - Harm(H)——参与商品和服务统一化的所有国家局接受的术语
     */
    public String getProjectHarm() {
        return projectHarm;
    }

    /**
     * 设置Harm(H)——参与商品和服务统一化的所有国家局接受的术语
     *
     * @param projectHarm Harm(H)——参与商品和服务统一化的所有国家局接受的术语
     */
    public void setProjectHarm(String projectHarm) {
        this.projectHarm = projectHarm == null ? null : projectHarm.trim();
    }

    /**
     * 获取Nice(N)——官方字母索引尼斯分类中的术语
     *
     * @return project_nice - Nice(N)——官方字母索引尼斯分类中的术语
     */
    public String getProjectNice() {
        return projectNice;
    }

    /**
     * 设置Nice(N)——官方字母索引尼斯分类中的术语
     *
     * @param projectNice Nice(N)——官方字母索引尼斯分类中的术语
     */
    public void setProjectNice(String projectNice) {
        this.projectNice = projectNice == null ? null : projectNice.trim();
    }

    /**
     * 获取IDli(I)——所有 TM5 国家局接受的术语
     *
     * @return project_idli - IDli(I)——所有 TM5 国家局接受的术语
     */
    public String getProjectIdli() {
        return projectIdli;
    }

    /**
     * 设置IDli(I)——所有 TM5 国家局接受的术语
     *
     * @param projectIdli IDli(I)——所有 TM5 国家局接受的术语
     */
    public void setProjectIdli(String projectIdli) {
        this.projectIdli = projectIdli == null ? null : projectIdli.trim();
    }

    /**
     * 获取MGS(M)——源自马德里商品和服务且在马德里申请中获世界知识产权组织接受的术语
     *
     * @return project_mgs - MGS(M)——源自马德里商品和服务且在马德里申请中获世界知识产权组织接受的术语
     */
    public String getProjectMgs() {
        return projectMgs;
    }

    /**
     * 设置MGS(M)——源自马德里商品和服务且在马德里申请中获世界知识产权组织接受的术语
     *
     * @param projectMgs MGS(M)——源自马德里商品和服务且在马德里申请中获世界知识产权组织接受的术语
     */
    public void setProjectMgs(String projectMgs) {
        this.projectMgs = projectMgs == null ? null : projectMgs.trim();
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