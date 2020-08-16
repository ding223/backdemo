package com.gqgx.interceptor;

import com.gqgx.common.context.SimpleInvocationContext;
import com.gqgx.common.entity.SysOperationLog;
import com.gqgx.common.entity.SysUser;
import com.gqgx.common.entity.UserAccount;
import com.gqgx.common.lang.Objects;
import com.gqgx.common.service.SysOperationLogService;
import com.gqgx.common.springutils.Springs;
import com.gqgx.common.web.BrowserUtils;
import com.gqgx.common.web.IPAccessControler;
import com.gqgx.constant.Constant;
import com.gqgx.utils.SysUserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * 登陆拦截器
 *
 * @author weihongjun
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
     * (javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SysUser user = SysUserUtil.getCurrentUser(false);
        if (!Objects.isEmpty(user)) {
            SimpleInvocationContext.create(user, null);
        }

            return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SysUser user = SysUserUtil.getCurrentUser(false);
        if (modelAndView == null) {
            try {
                // 记录操作日志
                addOpreationLog(request);
            } catch (Exception e) {
                logger.error("记录操作日志异常：" + e);
                e.printStackTrace();
            }
        }
        if (modelAndView != null) {
            modelAndView.addObject("cxtPath", request.getContextPath());
            modelAndView.addObject("currentLoginUser", user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void addOpreationLog(HttpServletRequest request) {
        SysUser user = SysUserUtil.getCurrentUser();
        String requestUrl = request.getServletPath();
        if (user != null) {
            Subject currentSession = SecurityUtils.getSubject();
            Session session = currentSession.getSession();
            @SuppressWarnings("unchecked")
            Map<String, String> map = (Map<String, String>) session.getAttribute(Constant.SYS_USER_OPTIONS + user.getId());
            SysOperationLogService sysOperationLogService = Springs.getBean(SysOperationLogService.class);
            SysOperationLog sysOperationLog = new SysOperationLog();
            sysOperationLog.setOperationDate(new Date());
            sysOperationLog.setUserId(user.getId());
//			sysOperationLog.setUserName(user.getName());
            if (map != null) {
                sysOperationLog.setOperationName(map.get(requestUrl));
                sysOperationLog.setModuleName(map.get(requestUrl));
            }
            sysOperationLog.setOperationUrl(requestUrl);
            sysOperationLog.setIpAddress(IPAccessControler.getRequestIpAddr(request));
            sysOperationLog.setBrowerType(BrowserUtils.getBrowserName(request.getHeader("User-Agent")));
            sysOperationLog.setTermianlType(BrowserUtils.getTermianlType(request.getHeader("User-Agent")));
            @SuppressWarnings("rawtypes")
            Enumeration enumeration = request.getParameterNames();
            StringBuilder sb = new StringBuilder("请求参数：{");
            if (enumeration != null) {
                while (enumeration.hasMoreElements()) {
                    Object obj = enumeration.nextElement();
                    if (obj != null) {
                        sb.append(obj + "=" + request.getParameter(obj.toString()) + ",");
                    }
                }
            }
            sb.append("}");
            String pperationDesc = "";
            if (sb.length() > 1024) {
                pperationDesc = sb.substring(0, 1024);
            } else {
                pperationDesc = sb.toString();
            }
            sysOperationLog.setOperationDesc(pperationDesc);
            sysOperationLog.setUpdateCount(sysOperationLog.getUpdateCount() == null ? 0 : sysOperationLog.getUpdateCount() + 1);
            sysOperationLogService.saveSysOperationLog(sysOperationLog);
        }
    }
}
