package com.gqgx.common.entity;


import java.io.Serializable;
import java.util.Date;


   
public class GqgxCitySite implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键PK<br/>
     * 对应数据库字段 gqgx_city_site.id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Long id;

    /**
     * 城市ID，gqgx_area.id<br/>
     * 对应数据库字段 gqgx_city_site.city_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    private Long cityId;

    /**
     * 城市名称<br/>
     * 对应数据库字段 gqgx_city_site.city_name
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private String cityName;

    /**
     * 站点名称<br/>
     * 对应数据库字段 gqgx_city_site.site_name
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private String siteName;

    /**
     * 顺序<br/>
     * 对应数据库字段 gqgx_city_site.site_seq
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    private Integer siteSeq;

    /**
     * 是否已经失效<br/>
     * 对应数据库字段 gqgx_city_site.record_status
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private String recordStatus;

    /**
     * 记录更新次数<br/>
     * 对应数据库字段 gqgx_city_site.update_count
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Integer updateCount;

    /**
     * 记录创建日期<br/>
     * 对应数据库字段 gqgx_city_site.create_date
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Date createDate;

    /**
     * 记录创建者ID<br/>
     * 对应数据库字段 gqgx_city_site.creator_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Long creatorId;

    /**
     * 更新日期<br/>
     * 对应数据库字段 gqgx_city_site.update_date
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Date updateDate;

    /**
     * 更新者ID<br/>
     * 对应数据库字段 gqgx_city_site.updater_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    private Long updaterId;


    /**
     * 返回: 主键PK<br>
     * 对应数据库字段: gqgx_city_site.id
     *
     * 返回  gqgx_city_site.id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Long getId() {
        return id;
    }

    /**
     *  设置: 主键PK<br>
     * 对应数据库字段: gqgx_city_site.id
     *
     * param id 主键PK
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 城市ID，gqgx_area.id<br>
     * 对应数据库字段: gqgx_city_site.city_id
     *
     * 返回  gqgx_city_site.city_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Long getCityId() {
        return cityId;
    }

    /**
     *  设置: 城市ID，gqgx_area.id<br>
     * 对应数据库字段: gqgx_city_site.city_id
     *
     * param cityId 城市ID，gqgx_area.id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 返回: 城市名称<br>
     * 对应数据库字段: gqgx_city_site.city_name
     *
     * 返回  gqgx_city_site.city_name
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public String getCityName() {
        return cityName;
    }

    /**
     *  设置: 城市名称<br>
     * 对应数据库字段: gqgx_city_site.city_name
     *
     * param cityName 城市名称
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 返回: 站点名称<br>
     * 对应数据库字段: gqgx_city_site.site_name
     *
     * 返回  gqgx_city_site.site_name
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public String getSiteName() {
        return siteName;
    }

    /**
     *  设置: 站点名称<br>
     * 对应数据库字段: gqgx_city_site.site_name
     *
     * param siteName 站点名称
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    /**
     * 返回: 顺序<br>
     * 对应数据库字段: gqgx_city_site.site_seq
     *
     * 返回  gqgx_city_site.site_seq
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Integer getSiteSeq() {
        return siteSeq;
    }

    /**
     *  设置: 顺序<br>
     * 对应数据库字段: gqgx_city_site.site_seq
     *
     * param siteSeq 顺序
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setSiteSeq(Integer siteSeq) {
        this.siteSeq = siteSeq;
    }

    /**
     * 返回: 是否已经失效<br>
     * 对应数据库字段: gqgx_city_site.record_status
     *
     * 返回  gqgx_city_site.record_status
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 是否已经失效<br>
     * 对应数据库字段: gqgx_city_site.record_status
     *
     * param recordStatus 是否已经失效
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 记录更新次数<br>
     * 对应数据库字段: gqgx_city_site.update_count
     *
     * 返回  gqgx_city_site.update_count
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 记录更新次数<br>
     * 对应数据库字段: gqgx_city_site.update_count
     *
     * param updateCount 记录更新次数
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 记录创建日期<br>
     * 对应数据库字段: gqgx_city_site.create_date
     *
     * 返回  gqgx_city_site.create_date
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 记录创建日期<br>
     * 对应数据库字段: gqgx_city_site.create_date
     *
     * param createDate 记录创建日期
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 记录创建者ID<br>
     * 对应数据库字段: gqgx_city_site.creator_id
     *
     * 返回  gqgx_city_site.creator_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 记录创建者ID<br>
     * 对应数据库字段: gqgx_city_site.creator_id
     *
     * param creatorId 记录创建者ID
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 更新日期<br>
     * 对应数据库字段: gqgx_city_site.update_date
     *
     * 返回  gqgx_city_site.update_date
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新日期<br>
     * 对应数据库字段: gqgx_city_site.update_date
     *
     * param updateDate 更新日期
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 更新者ID<br>
     * 对应数据库字段: gqgx_city_site.updater_id
     *
     * 返回  gqgx_city_site.updater_id
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新者ID<br>
     * 对应数据库字段: gqgx_city_site.updater_id
     *
     * param updaterId 更新者ID
     *
     * mbggenerated 2018-09-04 10:35
     */
    
    
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }
}