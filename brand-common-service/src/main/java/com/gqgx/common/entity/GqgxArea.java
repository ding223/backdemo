package com.gqgx.common.entity;


import java.io.Serializable;
import java.util.Date;


public class GqgxArea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键PK<br/>
	 * 对应数据库字段 gqgx_area.id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Long id;

	/**
	 * 父ID，0表示根<br/>
	 * 对应数据库字段 gqgx_area.parent_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Long parentId;

	/**
	 * 区域名称<br/>
	 * 对应数据库字段 gqgx_area.area_name
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String areaName;

	/**
	 * 区域的全名称<br/>
	 * 对应数据库字段 gqgx_area.area_fullname
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String areaFullname;

	/**
	 * 区域代码<br/>
	 * 对应数据库字段 gqgx_area.area_code
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String areaCode;

	/**
	 * 区域代码全称<br/>
	 * 对应数据库字段 gqgx_area.area_fullcode
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String areaFullcode;

	/**
	 * 区域等级，1表示省 2城市 3区域<br/>
	 * 对应数据库字段 gqgx_area.area_level
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Integer areaLevel;

	/**
	 * 备注<br/>
	 * 对应数据库字段 gqgx_area.remark
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String remark;

	/**
	 * 是否已经失效<br/>
	 * 对应数据库字段 gqgx_area.record_status
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private String recordStatus;

	/**
	 * 记录更新次数<br/>
	 * 对应数据库字段 gqgx_area.update_count
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Integer updateCount;

	/**
	 * 记录创建日期<br/>
	 * 对应数据库字段 gqgx_area.create_date
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Date createDate;

	/**
	 * 记录创建者ID<br/>
	 * 对应数据库字段 gqgx_area.creator_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Long creatorId;

	/**
	 * 更新日期<br/>
	 * 对应数据库字段 gqgx_area.update_date
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Date updateDate;

	/**
	 * 更新者ID<br/>
	 * 对应数据库字段 gqgx_area.updater_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	private Long updaterId;

	/**
	 * 返回: 主键PK<br>
	 * 对应数据库字段: gqgx_area.id
	 *
	 * 返回  gqgx_area.id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Long getId() {
		return id;
	}

	/**
	 *  设置: 主键PK<br>
	 * 对应数据库字段: gqgx_area.id
	 *
	 * param id 主键PK
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回: 父ID，0表示根<br>
	 * 对应数据库字段: gqgx_area.parent_id
	 *
	 * 返回  gqgx_area.parent_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Long getParentId() {
		return parentId;
	}

	/**
	 *  设置: 父ID，0表示根<br>
	 * 对应数据库字段: gqgx_area.parent_id
	 *
	 * param parentId 父ID，0表示根
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 返回: 区域名称<br>
	 * 对应数据库字段: gqgx_area.area_name
	 *
	 * 返回  gqgx_area.area_name
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getAreaName() {
		return areaName;
	}

	/**
	 *  设置: 区域名称<br>
	 * 对应数据库字段: gqgx_area.area_name
	 *
	 * param areaName 区域名称
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setAreaName(String areaName) {
		this.areaName = areaName == null ? null : areaName.trim();
	}

	/**
	 * 返回: 区域的全名称<br>
	 * 对应数据库字段: gqgx_area.area_fullname
	 *
	 * 返回  gqgx_area.area_fullname
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getAreaFullname() {
		return areaFullname;
	}

	/**
	 *  设置: 区域的全名称<br>
	 * 对应数据库字段: gqgx_area.area_fullname
	 *
	 * param areaFullname 区域的全名称
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setAreaFullname(String areaFullname) {
		this.areaFullname = areaFullname == null ? null : areaFullname.trim();
	}

	/**
	 * 返回: 区域代码<br>
	 * 对应数据库字段: gqgx_area.area_code
	 *
	 * 返回  gqgx_area.area_code
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 *  设置: 区域代码<br>
	 * 对应数据库字段: gqgx_area.area_code
	 *
	 * param areaCode 区域代码
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode == null ? null : areaCode.trim();
	}

	/**
	 * 返回: 区域代码全称<br>
	 * 对应数据库字段: gqgx_area.area_fullcode
	 *
	 * 返回  gqgx_area.area_fullcode
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getAreaFullcode() {
		return areaFullcode;
	}

	/**
	 *  设置: 区域代码全称<br>
	 * 对应数据库字段: gqgx_area.area_fullcode
	 *
	 * param areaFullcode 区域代码全称
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setAreaFullcode(String areaFullcode) {
		this.areaFullcode = areaFullcode == null ? null : areaFullcode.trim();
	}

	/**
	 * 返回: 区域等级，1表示省 2城市 3区域<br>
	 * 对应数据库字段: gqgx_area.area_level
	 *
	 * 返回  gqgx_area.area_level
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Integer getAreaLevel() {
		return areaLevel;
	}

	/**
	 *  设置: 区域等级，1表示省 2城市 3区域<br>
	 * 对应数据库字段: gqgx_area.area_level
	 *
	 * param areaLevel 区域等级，1表示省 2城市 3区域
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}

	/**
	 * 返回: 备注<br>
	 * 对应数据库字段: gqgx_area.remark
	 *
	 * 返回  gqgx_area.remark
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getRemark() {
		return remark;
	}

	/**
	 *  设置: 备注<br>
	 * 对应数据库字段: gqgx_area.remark
	 *
	 * param remark 备注
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 返回: 是否已经失效<br>
	 * 对应数据库字段: gqgx_area.record_status
	 *
	 * 返回  gqgx_area.record_status
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 *  设置: 是否已经失效<br>
	 * 对应数据库字段: gqgx_area.record_status
	 *
	 * param recordStatus 是否已经失效
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus == null ? null : recordStatus.trim();
	}

	/**
	 * 返回: 记录更新次数<br>
	 * 对应数据库字段: gqgx_area.update_count
	 *
	 * 返回  gqgx_area.update_count
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Integer getUpdateCount() {
		return updateCount;
	}

	/**
	 *  设置: 记录更新次数<br>
	 * 对应数据库字段: gqgx_area.update_count
	 *
	 * param updateCount 记录更新次数
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 返回: 记录创建日期<br>
	 * 对应数据库字段: gqgx_area.create_date
	 *
	 * 返回  gqgx_area.create_date
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 *  设置: 记录创建日期<br>
	 * 对应数据库字段: gqgx_area.create_date
	 *
	 * param createDate 记录创建日期
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 返回: 记录创建者ID<br>
	 * 对应数据库字段: gqgx_area.creator_id
	 *
	 * 返回  gqgx_area.creator_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 *  设置: 记录创建者ID<br>
	 * 对应数据库字段: gqgx_area.creator_id
	 *
	 * param creatorId 记录创建者ID
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 返回: 更新日期<br>
	 * 对应数据库字段: gqgx_area.update_date
	 *
	 * 返回  gqgx_area.update_date
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 *  设置: 更新日期<br>
	 * 对应数据库字段: gqgx_area.update_date
	 *
	 * param updateDate 更新日期
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 返回: 更新者ID<br>
	 * 对应数据库字段: gqgx_area.updater_id
	 *
	 * 返回  gqgx_area.updater_id
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public Long getUpdaterId() {
		return updaterId;
	}

	/**
	 *  设置: 更新者ID<br>
	 * 对应数据库字段: gqgx_area.updater_id
	 *
	 * param updaterId 更新者ID
	 *
	 * mbggenerated 2018-07-30 10:57
	 */

	
	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}
}