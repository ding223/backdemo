/**
 * 描述:<p></p>
 * @Title: GridResult.java
 * @Package com.gqgx.domain
 * 
 * @author weihongjun
 * @date 2016年11月22日 下午4:22:52
*/


package com.gqgx.domain;

import com.gqgx.common.paging.PagingResult;
import com.gqgx.constant.Constant;
import com.gqgx.utils.SysUserUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:<p></p>
 * @ClassName: GridResult
 * @author weihongjun
 * @date 2016年11月22日 下午4:22:52
 *
 */

public class GridResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private Integer total;// 总页数
    
    private Integer curPage;// 当前页
    
    private Long records;// 总记录数
    
    private List<T> rows;// 返回数据
    
    private Map<String, Object> userData = new HashMap<String, Object>();//用户数据返回
    
    /**
      * 创建一个新的实例 GridResult. 
      * <p>描述: </p>
      * @param records：总记录数
      * @param pageSize：每页数据
      * @param curPage：当前页
      * @param rows：返回数据
    */
    public GridResult(Long records, Integer pageSize, Integer curPage, List<T> rows)
    {
        this.total = (int)((total % pageSize > 0) ? (total / pageSize) + 1 : total / pageSize);
        this.rows = rows;
        this.curPage = curPage;
        this.records = records;
        this.addData(Constant.CURRENT_USER_OPTIONS, SysUserUtil.getMenuOperation());
    }
    
    /**
     * getter method
     * @return the userData
     */
    
    public Map<String, Object> getUserData()
    {
        return this.userData;
    }

    /**
     * setter method
     * @param userData the userData to set
     */
    
    public void setUserData(Map<String, Object> userData)
    {
        if(userData != null){
            this.userData.putAll(userData);
        }
    }

    /**
      * 创建一个新的实例 GridResult. 
      * <p>描述: </p>
      * @param pagingResult：分页结果
      * @param curPage：当前页
      * @param pageSize：当前页大小
    */
    public GridResult(PagingResult<T> pagingResult, Integer curPage, Integer pageSize)
    {
        Long totalCount = pagingResult.getTotalCount();
        this.records = totalCount;
        this.total = (int)((totalCount % pageSize > 0) ? (totalCount / pageSize) + 1 : totalCount / pageSize);
        this.curPage = curPage;
        this.rows = pagingResult.getResult();
        this.addData(Constant.CURRENT_USER_OPTIONS, SysUserUtil.getMenuOperation());
    }
    
    public GridResult()
    {
    	this.addData(Constant.CURRENT_USER_OPTIONS, SysUserUtil.getMenuOperation());
    }
    
    public void addData(String key, Object value)
    {
        this.userData.put(key, value);
    }

    /**
     * getter method
     * @return the total
     */
    
    public Integer getTotal()
    {
        return this.total;
    }

    /**
     * setter method
     * @param total the total to set
     */
    
    public void setTotal(Integer total)
    {
        this.total = total;
    }

    /**
     * getter method
     * @return the curPage
     */
    
    public Integer getCurPage()
    {
        return this.curPage;
    }

    /**
     * setter method
     * @param curPage the curPage to set
     */
    
    public void setCurPage(Integer curPage)
    {
        this.curPage = curPage;
    }

    /**
     * getter method
     * @return the records
     */
    
    public Long getRecords()
    {
        return this.records;
    }

    /**
     * setter method
     * @param records the records to set
     */
    
    public void setRecords(Long records)
    {
        this.records = records;
    }

    /**
     * getter method
     * @return the rows
     */
    
    public List<T> getRows()
    {
        return this.rows;
    }

    /**
     * setter method
     * @param rows the rows to set
     */
    
    public void setRows(List<T> rows)
    {
        this.rows = rows;
    }
}
