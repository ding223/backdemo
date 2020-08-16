/**
 * 描述:<p></p>
 * @Title: SpringShiroFilter.java
 * @Package com.gqgx.action.shiro
 * 
 * @author weihongjun
 * @date 2016年12月19日 下午6:43:59
*/


package com.gqgx.shiro;

import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

/**
 * 描述:<p></p>
 * @ClassName: SpringShiroFilter
 * @author weihongjun
 * @date 2016年12月19日 下午6:43:59
 *
 */

public final class SpringShiroFilter extends AbstractShiroFilter
{
    protected SpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver)
    {
      if (webSecurityManager == null) {
        throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
      }
      setSecurityManager(webSecurityManager);
      if (resolver != null)
        setFilterChainResolver(resolver);
    }
}
