/**
 * 描述:<p></p>
 *
 * @Title: ChildSysMenu.java
 * @Package com.gqgx.common.entity
 * @author weihongjun
 * @date 2016年12月2日 上午11:45:24
 */


package com.gqgx.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:<p></p>
 * @ClassName: ChildSysMenu
 * @author weihongjun
 * @date 2016年12月2日 上午11:45:24
 *
 */

public class ChildSysMenu implements Serializable {

    private Long id;

    private Long parentId;

    private String name;

    private String ishasDataPermission;

    /**
     * 是否选中
     */
    private String isCheck;
    private List<SysMenuOperation> operations;


    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }

    public String getIshasDataPermission() {
        return ishasDataPermission;
    }

    public void setIshasDataPermission(String ishasDataPermission) {
        this.ishasDataPermission = ishasDataPermission;
    }

    /**
     * getter method
     * @return the id
     */

    public Long getId() {
        return this.id;
    }

    /**
     * setter method
     * @param id the id to set
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * getter method
     * @return the parentId
     */

    public Long getParentId() {
        return this.parentId;
    }

    /**
     * setter method
     * @param parentId the parentId to set
     */

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * getter method
     * @return the name
     */

    public String getName() {
        return this.name;
    }

    /**
     * setter method
     * @param name the name to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method
     * @return the operations
     */

    public List<SysMenuOperation> getOperations() {
        return this.operations;
    }

    /**
     * setter method
     * @param operations the operations to set
     */

    public void setOperations(List<SysMenuOperation> operations) {
        this.operations = operations;
    }
}
