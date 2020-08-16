package com.gqgx.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    /**
     * 表主键
     */
    @Id
    private Long id;

    /**
     * 父级菜单id，对应sys_menu.id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单描述
     */
    @Column(name = "desc")
    private String descption;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 菜单排序
     */
    private Short sort;

    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 公司ID,对应sys_company.id
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 是否需要城市数据权限（0是，1否）
     */
    @Column(name = "ishas_city_permission")
    private String ishasCityPermission;

    /**
     * 是否需要数据权限（0是，1否）
     */
    @Column(name = "ishas_data_permission")
    private String ishasDataPermission;

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
     * 获取父级菜单id，对应sys_menu.id
     *
     * @return parent_id - 父级菜单id，对应sys_menu.id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级菜单id，对应sys_menu.id
     *
     * @param parentId 父级菜单id，对应sys_menu.id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单编码
     *
     * @return code - 菜单编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单编码
     *
     * @param code 菜单编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取菜单描述
     *
     * @return descption - 菜单描述
     */
    public String getDescption() {
        return descption;
    }

    /**
     * 设置菜单描述
     *
     * @param descption 菜单描述
     */
    public void setDescption(String descption) {
        this.descption = descption == null ? null : descption.trim();
    }

    /**
     * 获取菜单地址
     *
     * @return url - 菜单地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单地址
     *
     * @param url 菜单地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取菜单排序
     *
     * @return sort - 菜单排序
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置菜单排序
     *
     * @param sort 菜单排序
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * @return menu_icon
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * @param menuIcon
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
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
     * 获取是否需要城市数据权限（0是，1否）
     *
     * @return ishas_city_permission - 是否需要城市数据权限（0是，1否）
     */
    public String getIshasCityPermission() {
        return ishasCityPermission;
    }

    /**
     * 设置是否需要城市数据权限（0是，1否）
     *
     * @param ishasCityPermission 是否需要城市数据权限（0是，1否）
     */
    public void setIshasCityPermission(String ishasCityPermission) {
        this.ishasCityPermission = ishasCityPermission == null ? null : ishasCityPermission.trim();
    }

    /**
     * 获取是否需要数据权限（0是，1否）
     *
     * @return ishas_data_permission - 是否需要数据权限（0是，1否）
     */
    public String getIshasDataPermission() {
        return ishasDataPermission;
    }

    /**
     * 设置是否需要数据权限（0是，1否）
     *
     * @param ishasDataPermission 是否需要数据权限（0是，1否）
     */
    public void setIshasDataPermission(String ishasDataPermission) {
        this.ishasDataPermission = ishasDataPermission == null ? null : ishasDataPermission.trim();
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