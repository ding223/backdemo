package com.gqgx.common.entity;


import java.io.Serializable;
import java.util.Date;

public class SysPositionPermissions implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID<br/>
     * 对应数据库字段 sys_position_permissions.id
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long id;

    /**
     * 职位ID，对应sys_postions.id<br/>
     * 对应数据库字段 sys_position_permissions.position_id
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long positionId;

    /**
     * 权限类型：1=地区，2=数据层级<br/>
     * 对应数据库字段 sys_position_permissions.perm_type
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private String permType;

    /**
     * 对应数据值，type=1值对应sys_area.ID,type=2值为1本人，2为本部门，3为本部门及子本部，4全公司<br/>
     * 对应数据库字段 sys_position_permissions.perm_value
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long permValue;

    /**
     * 公司ID<br/>
     * 对应数据库字段 sys_position_permissions.company_id
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long companyId;

    /**
     * 是否已经失效<br/>
     * 对应数据库字段 sys_position_permissions.record_status
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private String recordStatus;

    /**
     * 记录更新次数<br/>
     * 对应数据库字段 sys_position_permissions.update_count
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Integer updateCount;

    /**
     * 记录创建日期<br/>
     * 对应数据库字段 sys_position_permissions.create_date
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Date createDate;

    /**
     * 记录创建者ID<br/>
     * 对应数据库字段 sys_position_permissions.creator_id
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long creatorId;

    /**
     * 更新日期<br/>
     * 对应数据库字段 sys_position_permissions.update_date
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Date updateDate;

    /**
     * 更新者ID<br/>
     * 对应数据库字段 sys_position_permissions.updater_id
     *
     * mbggenerated 2017-03-30 20:36
     */

    
    private Long updaterId;

    /**
     * 返回: 主键ID<br>
     * 对应数据库字段: sys_position_permissions.id
     *
     * 返回 sys_position_permissions.id
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getId() {
        return id;
    }

    /**
     * 设置: 主键ID<br>
     * 对应数据库字段: sys_position_permissions.id
     *
     * param id 主键ID
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 职位ID，对应sys_postions.id<br>
     * 对应数据库字段: sys_position_permissions.position_id
     *
     * 返回 sys_position_permissions.position_id
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getPositionId() {
        return positionId;
    }

    /**
     * 设置: 职位ID，对应sys_postions.id<br>
     * 对应数据库字段: sys_position_permissions.position_id
     *
     * param positionId 职位ID，对应sys_postions.id
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /**
     * 返回: 权限类型：1=地区，2=数据层级<br>
     * 对应数据库字段: sys_position_permissions.perm_type
     *
     * 返回 sys_position_permissions.perm_type
     * mbggenerated 2017-03-30 20:36
     */

    
    public String getPermType() {
        return permType;
    }

    /**
     * 设置: 权限类型：1=地区，2=数据层级<br>
     * 对应数据库字段: sys_position_permissions.perm_type
     *
     * param permType 权限类型：1=地区，2=数据层级
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setPermType(String permType) {
        this.permType = permType == null ? null : permType.trim();
    }

    /**
     * 返回: 对应数据值，type=1值对应sys_area.ID,type=2值为1本人，2为本部门，3为本部门及子本部，4全公司<br>
     * 对应数据库字段: sys_position_permissions.perm_value
     *
     * 返回 sys_position_permissions.perm_value
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getPermValue() {
        return permValue;
    }

    /**
     * 设置: 对应数据值，type=1值对应sys_area.ID,type=2值为1本人，2为本部门，3为本部门及子本部，4全公司<br>
     * 对应数据库字段: sys_position_permissions.perm_value
     *
     * param permValue 对应数据值，type=1值对应sys_area.ID,type=2值为1本人，2为本部门，3为本部门及子本部，4全公司
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setPermValue(Long permValue) {
        this.permValue = permValue;
    }

    /**
     * 返回: 公司ID<br>
     * 对应数据库字段: sys_position_permissions.company_id
     *
     * 返回 sys_position_permissions.company_id
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置: 公司ID<br>
     * 对应数据库字段: sys_position_permissions.company_id
     *
     * param companyId 公司ID
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 返回: 是否已经失效<br>
     * 对应数据库字段: sys_position_permissions.record_status
     *
     * 返回 sys_position_permissions.record_status
     * mbggenerated 2017-03-30 20:36
     */

    
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     * 设置: 是否已经失效<br>
     * 对应数据库字段: sys_position_permissions.record_status
     *
     * param recordStatus 是否已经失效
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 记录更新次数<br>
     * 对应数据库字段: sys_position_permissions.update_count
     *
     * 返回 sys_position_permissions.update_count
     * mbggenerated 2017-03-30 20:36
     */

    
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * 设置: 记录更新次数<br>
     * 对应数据库字段: sys_position_permissions.update_count
     *
     * param updateCount 记录更新次数
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 记录创建日期<br>
     * 对应数据库字段: sys_position_permissions.create_date
     *
     * 返回 sys_position_permissions.create_date
     * mbggenerated 2017-03-30 20:36
     */

    
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置: 记录创建日期<br>
     * 对应数据库字段: sys_position_permissions.create_date
     *
     * param createDate 记录创建日期
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 记录创建者ID<br>
     * 对应数据库字段: sys_position_permissions.creator_id
     *
     * 返回 sys_position_permissions.creator_id
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置: 记录创建者ID<br>
     * 对应数据库字段: sys_position_permissions.creator_id
     *
     * param creatorId 记录创建者ID
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 更新日期<br>
     * 对应数据库字段: sys_position_permissions.update_date
     *
     * 返回 sys_position_permissions.update_date
     * mbggenerated 2017-03-30 20:36
     */

    
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置: 更新日期<br>
     * 对应数据库字段: sys_position_permissions.update_date
     *
     * param updateDate 更新日期
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 更新者ID<br>
     * 对应数据库字段: sys_position_permissions.updater_id
     *
     * 返回 sys_position_permissions.updater_id
     * mbggenerated 2017-03-30 20:36
     */

    
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置: 更新者ID<br>
     * 对应数据库字段: sys_position_permissions.updater_id
     *
     * param updaterId 更新者ID
     * mbggenerated 2017-03-30 20:36
     */

    
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * * departmentId 部门ID
     */
    private Long departmentId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}