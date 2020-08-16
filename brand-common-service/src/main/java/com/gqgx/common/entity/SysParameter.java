package com.gqgx.common.entity;


import java.io.Serializable;
import java.util.Date;


    
public class SysParameter implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键PK<br/>
     * 对应数据库字段 sys_parameter.id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Long id;

    /**
     * 父ID<br/>
     * 对应数据库字段 sys_parameter.parent_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Long parentId;

    /**
     * 参数名称<br/>
     * 对应数据库字段 sys_parameter.model_name
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String modelName;

    /**
     * 参数code,(module_name+para_code组合唯一)<br/>
     * 对应数据库字段 sys_parameter.para_code
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String paraCode;

    /**
     * 参数类型：S(STRING)I(int)D(DECAIML)T(DATATIME)<br/>
     * 对应数据库字段 sys_parameter.para_type
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String paraType;

    /**
     * 参数取值<br/>
     * 对应数据库字段 sys_parameter.para_value
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String paraValue;

    /**
     * 参数默认值，当参数名称相同时，在使用填充下拉框或单选框时默认选中的值<br/>
     * 对应数据库字段 sys_parameter.para_default
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String paraDefault;

    /**
     * 参数顺序，当参数名称相同时，参数的排列顺序<br/>
     * 对应数据库字段 sys_parameter.para_seq
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Integer paraSeq;

    /**
     * 参数描述<br/>
     * 对应数据库字段 sys_parameter.para_desc
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String paraDesc;

    /**
     * 是否已经失效<br/>
     * 对应数据库字段 sys_parameter.record_status
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private String recordStatus;

    /**
     * 记录更新次数<br/>
     * 对应数据库字段 sys_parameter.update_count
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Integer updateCount;

    /**
     * 记录创建日期<br/>
     * 对应数据库字段 sys_parameter.create_date
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Date createDate;

    /**
     * 记录创建者ID<br/>
     * 对应数据库字段 sys_parameter.creator_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Long creatorId;

    /**
     * 更新日期<br/>
     * 对应数据库字段 sys_parameter.update_date
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Date updateDate;

    /**
     * 更新者ID<br/>
     * 对应数据库字段 sys_parameter.updater_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    private Long updaterId;


    /**
     * 返回: 主键PK<br>
     * 对应数据库字段: sys_parameter.id
     *
     * 返回  sys_parameter.id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Long getId() {
        return id;
    }

    /**
     *  设置: 主键PK<br>
     * 对应数据库字段: sys_parameter.id
     *
     * param id 主键PK
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 父ID<br>
     * 对应数据库字段: sys_parameter.parent_id
     *
     * 返回  sys_parameter.parent_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: 父ID<br>
     * 对应数据库字段: sys_parameter.parent_id
     *
     * param parentId 父ID
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: 参数名称<br>
     * 对应数据库字段: sys_parameter.model_name
     *
     * 返回  sys_parameter.model_name
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getModelName() {
        return modelName;
    }

    /**
     *  设置: 参数名称<br>
     * 对应数据库字段: sys_parameter.model_name
     *
     * param modelName 参数名称
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 返回: 参数code,(module_name+para_code组合唯一)<br>
     * 对应数据库字段: sys_parameter.para_code
     *
     * 返回  sys_parameter.para_code
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getParaCode() {
        return paraCode;
    }

    /**
     *  设置: 参数code,(module_name+para_code组合唯一)<br>
     * 对应数据库字段: sys_parameter.para_code
     *
     * param paraCode 参数code,(module_name+para_code组合唯一)
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaCode(String paraCode) {
        this.paraCode = paraCode == null ? null : paraCode.trim();
    }

    /**
     * 返回: 参数类型：S(STRING)I(int)D(DECAIML)T(DATATIME)<br>
     * 对应数据库字段: sys_parameter.para_type
     *
     * 返回  sys_parameter.para_type
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getParaType() {
        return paraType;
    }

    /**
     *  设置: 参数类型：S(STRING)I(int)D(DECAIML)T(DATATIME)<br>
     * 对应数据库字段: sys_parameter.para_type
     *
     * param paraType 参数类型：S(STRING)I(int)D(DECAIML)T(DATATIME)
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaType(String paraType) {
        this.paraType = paraType == null ? null : paraType.trim();
    }

    /**
     * 返回: 参数取值<br>
     * 对应数据库字段: sys_parameter.para_value
     *
     * 返回  sys_parameter.para_value
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getParaValue() {
        return paraValue;
    }

    /**
     *  设置: 参数取值<br>
     * 对应数据库字段: sys_parameter.para_value
     *
     * param paraValue 参数取值
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue == null ? null : paraValue.trim();
    }

    /**
     * 返回: 参数默认值，当参数名称相同时，在使用填充下拉框或单选框时默认选中的值<br>
     * 对应数据库字段: sys_parameter.para_default
     *
     * 返回  sys_parameter.para_default
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getParaDefault() {
        return paraDefault;
    }

    /**
     *  设置: 参数默认值，当参数名称相同时，在使用填充下拉框或单选框时默认选中的值<br>
     * 对应数据库字段: sys_parameter.para_default
     *
     * param paraDefault 参数默认值，当参数名称相同时，在使用填充下拉框或单选框时默认选中的值
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaDefault(String paraDefault) {
        this.paraDefault = paraDefault == null ? null : paraDefault.trim();
    }

    /**
     * 返回: 参数顺序，当参数名称相同时，参数的排列顺序<br>
     * 对应数据库字段: sys_parameter.para_seq
     *
     * 返回  sys_parameter.para_seq
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Integer getParaSeq() {
        return paraSeq;
    }

    /**
     *  设置: 参数顺序，当参数名称相同时，参数的排列顺序<br>
     * 对应数据库字段: sys_parameter.para_seq
     *
     * param paraSeq 参数顺序，当参数名称相同时，参数的排列顺序
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaSeq(Integer paraSeq) {
        this.paraSeq = paraSeq;
    }

    /**
     * 返回: 参数描述<br>
     * 对应数据库字段: sys_parameter.para_desc
     *
     * 返回  sys_parameter.para_desc
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getParaDesc() {
        return paraDesc;
    }

    /**
     *  设置: 参数描述<br>
     * 对应数据库字段: sys_parameter.para_desc
     *
     * param paraDesc 参数描述
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc == null ? null : paraDesc.trim();
    }

    /**
     * 返回: 是否已经失效<br>
     * 对应数据库字段: sys_parameter.record_status
     *
     * 返回  sys_parameter.record_status
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: 是否已经失效<br>
     * 对应数据库字段: sys_parameter.record_status
     *
     * param recordStatus 是否已经失效
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: 记录更新次数<br>
     * 对应数据库字段: sys_parameter.update_count
     *
     * 返回  sys_parameter.update_count
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: 记录更新次数<br>
     * 对应数据库字段: sys_parameter.update_count
     *
     * param updateCount 记录更新次数
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: 记录创建日期<br>
     * 对应数据库字段: sys_parameter.create_date
     *
     * 返回  sys_parameter.create_date
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: 记录创建日期<br>
     * 对应数据库字段: sys_parameter.create_date
     *
     * param createDate 记录创建日期
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: 记录创建者ID<br>
     * 对应数据库字段: sys_parameter.creator_id
     *
     * 返回  sys_parameter.creator_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: 记录创建者ID<br>
     * 对应数据库字段: sys_parameter.creator_id
     *
     * param creatorId 记录创建者ID
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: 更新日期<br>
     * 对应数据库字段: sys_parameter.update_date
     *
     * 返回  sys_parameter.update_date
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: 更新日期<br>
     * 对应数据库字段: sys_parameter.update_date
     *
     * param updateDate 更新日期
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 更新者ID<br>
     * 对应数据库字段: sys_parameter.updater_id
     *
     * 返回  sys_parameter.updater_id
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: 更新者ID<br>
     * 对应数据库字段: sys_parameter.updater_id
     *
     * param updaterId 更新者ID
     *
     * mbggenerated 2016-12-14 16:36
     */
    
    
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }
    
    /**
     * 用于模糊查询code
     */
    private String paramCodeLike;


	public String getParamCodeLike() {
		return paramCodeLike;
	}

	public void setParamCodeLike(String paramCodeLike) {
		this.paramCodeLike = paramCodeLike;
	}
	
}