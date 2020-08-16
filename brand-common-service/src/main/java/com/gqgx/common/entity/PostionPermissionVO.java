/**
 * 描述:<p></p>
 * @Title: PostionPermissionVO.java
 * @Package com.gqgx.common.entity
 * 
 * @author weihongjun
 * @date 2016年12月2日 上午9:16:29
*/


package com.gqgx.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:<p></p>
 * @ClassName: PostionPermissionVO
 * @author weihongjun
 * @date 2016年12月2日 上午9:16:29
 *
*/

public class PostionPermissionVO implements Serializable
{

    /**
      * 描述:<p>TODO</p>
      * @Fields serialVersionUID
    */
    private static final long serialVersionUID = -5825806904475060528L;
    
    private Long postionId;
    
    private String postionName;
    
    private String departmentName;
    
    private List<SysMenu> menus;
    
    private List<SysMenuOperation>  operations;
    
    private String positionIds;
	private String positionNames;

	public String getPositionIds() {
		return positionIds;
	}

	public void setPositionIds(String positionIds) {
		this.positionIds = positionIds;
	}

	public String getPositionNames() {
		return positionNames;
	}

	public void setPositionNames(String positionNames) {
		this.positionNames = positionNames;
	}

    /**
     * getter method
     * @return the postionId
     */
    
    public Long getPostionId()
    {
        return this.postionId;
    }

    /**
     * setter method
     * @param postionId the postionId to set
     */
    
    public void setPostionId(Long postionId)
    {
        this.postionId = postionId;
    }

    /**
     * getter method
     * @return the postionName
     */
    
    public String getPostionName()
    {
        return this.postionName;
    }

    /**
     * setter method
     * @param postionName the postionName to set
     */
    
    public void setPostionName(String postionName)
    {
        this.postionName = postionName;
    }

    /**
     * getter method
     * @return the departmentName
     */
    
    public String getDepartmentName()
    {
        return this.departmentName;
    }

    /**
     * setter method
     * @param departmentName the departmentName to set
     */
    
    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    /**
     * getter method
     * @return the menus
     */
    
    public List<SysMenu> getMenus()
    {
        return this.menus;
    }

    /**
     * setter method
     * @param menus the menus to set
     */
    
    public void setMenus(List<SysMenu> menus)
    {
        this.menus = menus;
    }

    /**
     * getter method
     * @return the operations
     */
    
    public List<SysMenuOperation> getOperations()
    {
        return this.operations;
    }

    /**
     * setter method
     * @param operations the operations to set
     */
    
    public void setOperations(List<SysMenuOperation> operations)
    {
        this.operations = operations;
    }
}
