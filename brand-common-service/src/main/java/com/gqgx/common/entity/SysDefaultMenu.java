package com.gqgx.common.entity;


import java.io.Serializable;
import java.util.Date;


    
public class SysDefaultMenu implements  Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 表主键<br/>
     * 对应数据库字段 sys_default_menu.id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Long id;

    /**
     * 菜单ID<br/>
     * 对应数据库字段 sys_default_menu.menu_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Long menuId;

    /**
     * 用户ID<br/>
     * 对应数据库字段 sys_default_menu.user_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Long userId;

    /**
     * 是否已经失效<br/>
     * 对应数据库字段 sys_default_menu.record_status
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private String recordStatus;

    /**
     * 记录更新次数<br/>
     * 对应数据库字段 sys_default_menu.update_count
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Integer updateCount;

    /**
     * 记录创建日期<br/>
     * 对应数据库字段 sys_default_menu.create_date
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Date createDate;

    /**
     * 记录创建者ID<br/>
     * 对应数据库字段 sys_default_menu.creator_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Long creatorId;

    /**
     * 更新日期<br/>
     * 对应数据库字段 sys_default_menu.update_date
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Date updateDate;

    /**
     * 更新者ID<br/>
     * 对应数据库字段 sys_default_menu.updater_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    private Long updaterId;


    /**
     * 返回: 表主键<br>
     * 对应数据库字段: sys_default_menu.id
     *
     * 返回  sys_default_menu.id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Long getId() {
        return id;
    }

    /**
     *  设置: 表主键<br>
     * 对应数据库字段: sys_default_menu.id
     *
     * param id 表主键
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 菜单ID<br>
     * 对应数据库字段: sys_default_menu.menu_id
     *
     * 返回  sys_default_menu.menu_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Long getMenuId() {
        return menuId;
    }

    /**
     *  设置: 菜单ID<br>
     * 对应数据库字段: sys_default_menu.menu_id
     *
     * param menuId 菜单ID
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 返回: 用户ID<br>
     * 对应数据库字段: sys_default_menu.user_id
     *
     * 返回  sys_default_menu.user_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Long getUserId() {
        return userId;
    }

    /**
     *  设置: 用户ID<br>
     * 对应数据库字段: sys_default_menu.user_id
     *
     * param userId 用户ID
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 返回: 是否已经失效<br>
     * 对应数据库字段: sys_default_menu.record_status
     *
     * 返回  sys_default_menu.record_status
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 是否已经失效<br>
     * 对应数据库字段: sys_default_menu.record_status
     *
     * param recordStatus 是否已经失效
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 记录更新次数<br>
     * 对应数据库字段: sys_default_menu.update_count
     *
     * 返回  sys_default_menu.update_count
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 记录更新次数<br>
     * 对应数据库字段: sys_default_menu.update_count
     *
     * param updateCount 记录更新次数
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 记录创建日期<br>
     * 对应数据库字段: sys_default_menu.create_date
     *
     * 返回  sys_default_menu.create_date
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 记录创建日期<br>
     * 对应数据库字段: sys_default_menu.create_date
     *
     * param createDate 记录创建日期
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 记录创建者ID<br>
     * 对应数据库字段: sys_default_menu.creator_id
     *
     * 返回  sys_default_menu.creator_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 记录创建者ID<br>
     * 对应数据库字段: sys_default_menu.creator_id
     *
     * param creatorId 记录创建者ID
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 更新日期<br>
     * 对应数据库字段: sys_default_menu.update_date
     *
     * 返回  sys_default_menu.update_date
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新日期<br>
     * 对应数据库字段: sys_default_menu.update_date
     *
     * param updateDate 更新日期
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 更新者ID<br>
     * 对应数据库字段: sys_default_menu.updater_id
     *
     * 返回  sys_default_menu.updater_id
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新者ID<br>
     * 对应数据库字段: sys_default_menu.updater_id
     *
     * param updaterId 更新者ID
     *
     * mbggenerated 2016-12-20 15:40
     */
    
    
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }
}