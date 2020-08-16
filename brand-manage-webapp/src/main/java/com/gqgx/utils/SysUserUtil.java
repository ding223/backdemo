/**
 * 描述:<p></p>
 * @Title: SysUserUtil.java
 * @Package com.gqgx.utils
 * 
 * @author weihongjun
 * @date 2016年11月24日 下午2:37:33
*/


package com.gqgx.utils;

import com.gqgx.common.entity.SysMenu;
import com.gqgx.common.entity.SysMenuOperation;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.lang.Strings;
import com.gqgx.constant.Constant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 描述:<p>登录用户帮助类</p>
 * @ClassName: SysUserUtil
 * @author weihongjun
 * @date 2016年11月24日 下午2:37:33
 *
*/

public class SysUserUtil
{
    public static SysUser getCurrentUser()
    {
        Object obj = getHttpSession().getAttribute(Constant.CURRENT_LOGIN_USER);
        if (obj != null)
        {
            return (SysUser)obj;
        }
        return null;
    }
    
    public static SysUser getCurrentUser(boolean isNew)
    {
        HttpSession session = getHttpSession(isNew);
        if (session != null)
        {
            Object obj = session.getAttribute(Constant.CURRENT_LOGIN_USER);
            if (obj != null)
            {
                return (SysUser)obj;
            }
        }
        return null;
    }
    
    public static Map<String, String> getMsgParam()
    {
        Map<String, String> result = new HashMap<String, String>();
        SysUser sysUser = getCurrentUser();
        if (sysUser != null)
        {
            result.put("@userName", sysUser.getName());
            result.put("@userPhone", sysUser.getPhone());
            result.put("@companyAddress", sysUser.getCompanyAddress());
            result.put("@companyUrl", sysUser.getCompanyUrl());
            result.put("@companyName", sysUser.getCompanyName());
            result.put("@companyAbb", sysUser.getCompanyAbb());
        }
        return result;
    }
    
    public static String getCompanySigner()
    {
        Object obj = getHttpSession().getAttribute(Constant.CURRENT_LOGIN_USER);
        if (obj != null)
        {
            SysUser user = (SysUser)obj;
            return "【"+user.getCompanyAbb()+"】";
        }
        return null;
    }
    
    public static Long getCurrentUserId()
    {
        SysUser user = getCurrentUser();
        return user == null ? null : user.getId();
    }
    
    public static Long getCurrentCompanyId()
    {
        SysUser user = getCurrentUser();
        return user == null ? null : user.getCompanyId();
    }
    
    public static HttpServletRequest getHttpServletRequest()
    {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    public static HttpSession getHttpSession()
    {
        return getHttpServletRequest().getSession();
    }
    
    public static HttpSession getHttpSession(boolean isNew)
    {
        return getHttpServletRequest().getSession(isNew);
    }
   
    
    public static Set<String> getMenuOperation()
    {
        Set<String> result = new HashSet<String>();
        try
        {
            HttpServletRequest request = getHttpServletRequest();
            SysUser user = getCurrentUser();
            
            if (request == null || user == null || Objects.isEmpty(user.getSysMenus()) || Objects.isEmpty(user.getMenuOperations()))
                return null;
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
            {                
                List<SysMenu> sysMenus = user.getSysMenus();
                List<SysMenuOperation> operations = user.getMenuOperations();
                
                Map<String,String> operationsMap = new HashMap<String, String>();
                if(!Objects.isEmpty(operations) && operations.size() > 0){
                	for(SysMenuOperation item : operations){
                		operationsMap.put(item.getMenuId().toString(), item.getCode());
                	}
                }
                
                if(!Objects.isEmpty(sysMenus) && sysMenus.size() > 0){
                	for (int i = 0; i < sysMenus.size(); i++)
                    {
                        if (Strings.isBlank(sysMenus.get(i).getUrl())){
                        	continue;
                        }
                        
                        //判断菜单操作中有该菜单 则循环获取
                        if (operationsMap.containsKey(sysMenus.get(i).getId().toString()))
                        {
                        	for (int j = 0; j < operations.size(); j++)
                            {
                                if (sysMenus.get(i).getId().longValue() == operations.get(j).getMenuId().longValue())
                                {
                                    result.add(operations.get(j).getCode());
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
