/**
 * 描述:<p></p>
 * @Title: SysMenuTreeVO.java
 * @Package com.gqgx.common.entity
 * 
 * @author weihongjun
 * @date 2017年1月9日 上午10:23:12
*/


package com.gqgx.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:<p></p>
 * @ClassName: SysMenuTreeVO
 * @author weihongjun
 * @date 2017年1月9日 上午10:23:12
 *
*/

public class SysMenuTreeVO implements Serializable
{
    /**
      * 描述:<p>TODO</p>
      * @Fields serialVersionUID
    */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private Long parentId;
    
    private String name;
    
    private String code;
    
    private String url;
    
    private List<SysMenuOperation> operations;

    /**
     * getter method
     * @return the id
     */
    
    public Long getId()
    {
        return this.id;
    }

    /**
     * setter method
     * @param id the id to set
     */
    
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * getter method
     * @return the parentId
     */
    
    public Long getParentId()
    {
        return this.parentId;
    }

    /**
     * setter method
     * @param parentId the parentId to set
     */
    
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    /**
     * getter method
     * @return the name
     */
    
    public String getName()
    {
        return this.name;
    }

    /**
     * setter method
     * @param name the name to set
     */
    
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * getter method
     * @return the code
     */
    
    public String getCode()
    {
        return this.code;
    }

    /**
     * setter method
     * @param code the code to set
     */
    
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * getter method
     * @return the url
     */
    
    public String getUrl()
    {
        return this.url;
    }

    /**
     * setter method
     * @param url the url to set
     */
    
    public void setUrl(String url)
    {
        this.url = url;
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
