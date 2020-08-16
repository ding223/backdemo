package com.gqgx.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 表主键
     */
    @Id
    private Long id;

    /**
     * 登录帐号
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 登录密码
     */
    @Column(name = "pass_word")
    private String passWord;

    /**
     * 职员名称
     */
    private String name;

    /**
     * 职员编码（工号）
     */
    private String code;

    /**
     * 性别0男1女
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 入职日期
     */
    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * 部门Id，对应sys_department.di
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 员工图片id
     */
    @Column(name = "photo_id")
    private Long photoId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 紧急联系人
     */
    private String contacts;

    /**
     * 联系人手机号码
     */
    @Column(name = "contacts_phone")
    private String contactsPhone;

    /**
     * 工作所在详细地址
     */
    private String address;

    /**
     * 毕业学校
     */
    private String school;

    /**
     * 专业
     */
    private String major;

    /**
     * 毕业时间
     */
    private Date graduation;

    /**
     * 学历(0高中及以下，1大专，2本科，3研究，4博士，5博士后及以上
     */
    private String education;

    /**
     * 籍贯
     */
    private String origin;

    /**
     * 名族
     */
    private String race;

    /**
     * 婚姻情况(0是，1否）
     */
    private String marriage;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 备注
     */
    private String remark;

    /**
     * 离职状态 0在职,1离职
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 用户类型0客服或业务员，1工商人员2,记账会计，3报税会计，4外勤人员,5其他
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 所属公司关联sys_company.id
     */
    @Column(name = "company_id")
    private Long companyId;

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
     * 分公司id
     */
    @Column(name = "branch_company_id")
    private Long branchCompanyId;

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
     * 获取登录帐号
     *
     * @return account_name - 登录帐号
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置登录帐号
     *
     * @param accountName 登录帐号
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取登录密码
     *
     * @return pass_word - 登录密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置登录密码
     *
     * @param passWord 登录密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * 获取职员名称
     *
     * @return name - 职员名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职员名称
     *
     * @param name 职员名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取职员编码（工号）
     *
     * @return code - 职员编码（工号）
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置职员编码（工号）
     *
     * @param code 职员编码（工号）
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取性别0男1女
     *
     * @return sex - 性别0男1女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别0男1女
     *
     * @param sex 性别0男1女
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取入职日期
     *
     * @return entry_date - 入职日期
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 设置入职日期
     *
     * @param entryDate 入职日期
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * 获取部门Id，对应sys_department.di
     *
     * @return department_id - 部门Id，对应sys_department.di
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门Id，对应sys_department.di
     *
     * @param departmentId 部门Id，对应sys_department.di
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取员工图片id
     *
     * @return photo_id - 员工图片id
     */
    public Long getPhotoId() {
        return photoId;
    }

    /**
     * 设置员工图片id
     *
     * @param photoId 员工图片id
     */
    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮箱地址
     *
     * @return email - 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取固定电话
     *
     * @return telephone - 固定电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置固定电话
     *
     * @param telephone 固定电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 获取紧急联系人
     *
     * @return contacts - 紧急联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置紧急联系人
     *
     * @param contacts 紧急联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取联系人手机号码
     *
     * @return contacts_phone - 联系人手机号码
     */
    public String getContactsPhone() {
        return contactsPhone;
    }

    /**
     * 设置联系人手机号码
     *
     * @param contactsPhone 联系人手机号码
     */
    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    /**
     * 获取工作所在详细地址
     *
     * @return address - 工作所在详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置工作所在详细地址
     *
     * @param address 工作所在详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取毕业学校
     *
     * @return school - 毕业学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置毕业学校
     *
     * @param school 毕业学校
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * 获取专业
     *
     * @return major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * 获取毕业时间
     *
     * @return graduation - 毕业时间
     */
    public Date getGraduation() {
        return graduation;
    }

    /**
     * 设置毕业时间
     *
     * @param graduation 毕业时间
     */
    public void setGraduation(Date graduation) {
        this.graduation = graduation;
    }

    /**
     * 获取学历(0高中及以下，1大专，2本科，3研究，4博士，5博士后及以上
     *
     * @return education - 学历(0高中及以下，1大专，2本科，3研究，4博士，5博士后及以上
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历(0高中及以下，1大专，2本科，3研究，4博士，5博士后及以上
     *
     * @param education 学历(0高中及以下，1大专，2本科，3研究，4博士，5博士后及以上
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 获取籍贯
     *
     * @return origin - 籍贯
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置籍贯
     *
     * @param origin 籍贯
     */
    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    /**
     * 获取名族
     *
     * @return race - 名族
     */
    public String getRace() {
        return race;
    }

    /**
     * 设置名族
     *
     * @param race 名族
     */
    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    /**
     * 获取婚姻情况(0是，1否）
     *
     * @return marriage - 婚姻情况(0是，1否）
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * 设置婚姻情况(0是，1否）
     *
     * @param marriage 婚姻情况(0是，1否）
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    /**
     * 获取政治面貌
     *
     * @return political - 政治面貌
     */
    public String getPolitical() {
        return political;
    }

    /**
     * 设置政治面貌
     *
     * @param political 政治面貌
     */
    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取离职状态 0在职,1离职
     *
     * @return user_status - 离职状态 0在职,1离职
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置离职状态 0在职,1离职
     *
     * @param userStatus 离职状态 0在职,1离职
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 获取用户类型0客服或业务员，1工商人员2,记账会计，3报税会计，4外勤人员,5其他
     *
     * @return user_type - 用户类型0客服或业务员，1工商人员2,记账会计，3报税会计，4外勤人员,5其他
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型0客服或业务员，1工商人员2,记账会计，3报税会计，4外勤人员,5其他
     *
     * @param userType 用户类型0客服或业务员，1工商人员2,记账会计，3报税会计，4外勤人员,5其他
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取所属公司关联sys_company.id
     *
     * @return company_id - 所属公司关联sys_company.id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司关联sys_company.id
     *
     * @param companyId 所属公司关联sys_company.id
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    /**
     * 获取分公司id
     *
     * @return branch_company_id - 分公司id
     */
    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    /**
     * 设置分公司id
     *
     * @param branchCompanyId 分公司id
     */
    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }
}