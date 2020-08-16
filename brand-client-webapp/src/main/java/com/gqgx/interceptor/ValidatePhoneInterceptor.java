package com.gqgx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gqgx.common.web.PropertyHolder;

/**
 * 验证手机浏览器登录
 * @author Administrator
 *
 */
public class ValidatePhoneInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		 String userAgent = request.getHeader("user-agent");
//		 if(!userAgent.contains("Windows NT")){
//			 String url=PropertyHolder.getProperty("phone.url");
//			 response.sendRedirect(url);
//			 return false;
//		 }
        return super.preHandle(request, response, handler);
	}
	
	
	
}
