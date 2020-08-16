package com.gqgx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gqgx.utils.SessionUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 处理handler;
        if (handler instanceof HandlerMethod) {
            // 判断当前method上是否有标签;
            HandlerMethod hm = (HandlerMethod) handler;
            Object user = SessionUtils.getUserInfo();
            if (hm.getMethodAnnotation(RequireLogin.class) != null && user == null) {
                // 如果有,判断当前是否用户登录,如果没有登录,跳转到登录页面
                response.sendRedirect(request.getContextPath()+"/login.html");
                return false;
            }
        }
        return super.preHandle(request, response, handler);
	}
}
