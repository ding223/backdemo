package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "brand_nav_item")
public class BrandNavItem {
    /**
     * 主键PK
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 导航名称
     */
    private String name;

    /**
     * 地区名称
     */
    @Column(name = "city_name")
    private String cityName;

    /**
     * 导航映射地址 niceclass通用尼斯，usaclass美国商标，euroclass欧盟商标，auclass澳洲商标，jpclass日本商标，korclass韩国商标，russiaclass俄罗斯商标，dycclass自定义商标
     */
    private String url;

    /**
     * 顺序
     */
    private Integer seq;

    /**
     * 支持修改 0支持 1不支持
     */
    @Column(name = "update_status")
    private String updateStatus;

    /**
     * 显示状态 0显示 1不显示
     */
    @Column(name = "show_status")
    private String showStatus;

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
     * 获取主键PK
     *
     * @return id - 主键PK
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键PK
     *
     * @param id 主键PK
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取导航名称
     *
     * @return name - 导航名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置导航名称
     *
     * @param name 导航名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取地区名称
     *
     * @return city_name - 地区名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置地区名称
     *
     * @param cityName 地区名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取导航映射地址 niceclass通用尼斯，usaclass美国商标，euroclass欧盟商标，auclass澳洲商标，jpclass日本商标，korclass韩国商标，russiaclass俄罗斯商标，dycclass自定义商标
     *
     * @return url - 导航映射地址 niceclass通用尼斯，usaclass美国商标，euroclass欧盟商标，auclass澳洲商标，jpclass日本商标，korclass韩国商标，russiaclass俄罗斯商标，dycclass自定义商标
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置导航映射地址 niceclass通用尼斯，usaclass美国商标，euroclass欧盟商标，auclass澳洲商标，jpclass日本商标，korclass韩国商标，russiaclass俄罗斯商标，dycclass自定义商标
     *
     * @param url 导航映射地址 niceclass通用尼斯，usaclass美国商标，euroclass欧盟商标，auclass澳洲商标，jpclass日本商标，korclass韩国商标，russiaclass俄罗斯商标，dycclass自定义商标
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取顺序
     *
     * @return seq - 顺序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置顺序
     *
     * @param seq 顺序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取支持修改 0支持 1不支持
     *
     * @return update_status - 支持修改 0支持 1不支持
     */
    public String getUpdateStatus() {
        return updateStatus;
    }

    /**
     * 设置支持修改 0支持 1不支持
     *
     * @param updateStatus 支持修改 0支持 1不支持
     */
    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus == null ? null : updateStatus.trim();
    }

    /**
     * 获取显示状态 0显示 1不显示
     *
     * @return show_status - 显示状态 0显示 1不显示
     */
    public String getShowStatus() {
        return showStatus;
    }

    /**
     * 设置显示状态 0显示 1不显示
     *
     * @param showStatus 显示状态 0显示 1不显示
     */
    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus == null ? null : showStatus.trim();
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