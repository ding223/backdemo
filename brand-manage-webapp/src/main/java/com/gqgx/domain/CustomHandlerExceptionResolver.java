/**
 * 描述:<p></p>
 * @Title: CustomHandlerExceptionResolver.java
 * @Package com.gqgx.domain
 * 
 * @author weihongjun
 * @date 2017年1月10日 上午11:17:53
*/


package com.gqgx.domain;

import com.alibaba.druid.support.json.JSONUtils;
import com.gqgx.domain.RequestResult.CODE;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:<p></p>
 * @ClassName: CustomHandlerExceptionResolver
 * @author weihongjun
 * @date 2017年1月10日 上午11:17:53
 *
*/
public class CustomHandlerExceptionResolver extends SimpleMappingExceptionResolver
{
    
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex)
    {
        String viewName = determineViewName(ex, request);
        if (viewName != null)
        {
            // JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With")
                .indexOf("XMLHttpRequest") > -1)))
            {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null)
                {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                ModelAndView view = getModelAndView(viewName, ex, request);
                view.addObject("cxtPath", request.getContextPath());
                return view;
            }
            else
            {
                // JSON格式返回
                try
                {
                    PrintWriter writer = response.getWriter();
                    Map<String, Object> map = new HashMap<String, Object>();
                    if (ex instanceof AuthenticationException)
                    {
                        map.put("code", CODE.UNAUTH.getCode());
                        map.put("msg", ex.getMessage());
                    }
                    else if (ex instanceof MySQLSyntaxErrorException)
                    {
                        map.put("code", CODE.DATABASEERROR.getCode());
                        map.put("msg", "数据库异常");
                    }
                    else
                    {
                        map.put("code", CODE.ERROR.getCode());
                        map.put("msg", "服务器内部异常");
                    }
                    writer.write(JSONUtils.toJSONString(map));
                    writer.flush();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    
}
