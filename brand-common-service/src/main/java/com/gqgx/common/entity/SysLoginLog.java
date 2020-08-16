package com.gqgx.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_login_log")
public class SysLoginLog {
    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID，未登陆使用SESSION号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * session号
     */
    @Column(name = "session_id")
    private String sessionId;

    /**
     * 登陆日期
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 退出时间
     */
    @Column(name = "logout_date")
    private Date logoutDate;

    /**
     * 终端类型，PC(1) android(2) ios(3)
     */
    @Column(name = "termianl_type")
    private String termianlType;

    /**
     * 登录类型：0=成功，1=失败
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 消息
     */
    @Column(name = "login_msg")
    private String loginMsg;

    /**
     * 浏览器终端类型
     */
    @Column(name = "brower_type")
    private String browerType;

    /**
     * 登陆IP
     */
    private String ip;

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
     * 获取PK
     *
     * @return id - PK
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置PK
     *
     * @param id PK
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID，未登陆使用SESSION号
     *
     * @return user_id - 用户ID，未登陆使用SESSION号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID，未登陆使用SESSION号
     *
     * @param userId 用户ID，未登陆使用SESSION号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取session号
     *
     * @return session_id - session号
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 设置session号
     *
     * @param sessionId session号
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    /**
     * 获取登陆日期
     *
     * @return login_date - 登陆日期
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置登陆日期
     *
     * @param loginDate 登陆日期
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取退出时间
     *
     * @return logout_date - 退出时间
     */
    public Date getLogoutDate() {
        return logoutDate;
    }

    /**
     * 设置退出时间
     *
     * @param logoutDate 退出时间
     */
    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    /**
     * 获取终端类型，PC(1) android(2) ios(3)
     *
     * @return termianl_type - 终端类型，PC(1) android(2) ios(3)
     */
    public String getTermianlType() {
        return termianlType;
    }

    /**
     * 设置终端类型，PC(1) android(2) ios(3)
     *
     * @param termianlType 终端类型，PC(1) android(2) ios(3)
     */
    public void setTermianlType(String termianlType) {
        this.termianlType = termianlType == null ? null : termianlType.trim();
    }

    /**
     * 获取登录类型：0=成功，1=失败
     *
     * @return login_type - 登录类型：0=成功，1=失败
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * 设置登录类型：0=成功，1=失败
     *
     * @param loginType 登录类型：0=成功，1=失败
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    /**
     * 获取消息
     *
     * @return login_msg - 消息
     */
    public String getLoginMsg() {
        return loginMsg;
    }

    /**
     * 设置消息
     *
     * @param loginMsg 消息
     */
    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg == null ? null : loginMsg.trim();
    }

    /**
     * 获取浏览器终端类型
     *
     * @return brower_type - 浏览器终端类型
     */
    public String getBrowerType() {
        return browerType;
    }

    /**
     * 设置浏览器终端类型
     *
     * @param browerType 浏览器终端类型
     */
    public void setBrowerType(String browerType) {
        this.browerType = browerType == null ? null : browerType.trim();
    }

    /**
     * 获取登陆IP
     *
     * @return ip - 登陆IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置登陆IP
     *
     * @param ip 登陆IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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