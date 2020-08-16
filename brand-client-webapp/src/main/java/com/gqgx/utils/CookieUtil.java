/**
 * 描述:<p></p>
 *
 * @Title: CookieUtil.java
 * @Package com.gqgx.redis.utils
 * @author zhongyang
 * @date 2017年2月20日 下午2:47:18
 */


package com.gqgx.utils;

import com.alibaba.fastjson.JSONArray;
import com.gqgx.common.entity.vo.CookieVo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CookieUtil {

    private HttpServletRequest request;

    public CookieUtil(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
    }

    /**
     * 保存cookie
     * @param response
     * @param name cookie名称
     * @param value cookie值
     */
    public static void setCookie(HttpServletResponse response, String name, String value) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(value))
            return;
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24 * 30 * 12); //先设置为1年
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获取cookie中保存的值
     * @param name
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getCookieValue(String name)
            throws UnsupportedEncodingException {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (name.equalsIgnoreCase(cookies[i].getName())) {
                    return cookies[i].getValue();
                }
            }
        }
        return "";
    }

    /**
     * 获取cookie值
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        try {
            Cookie cookies[] = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (name.equalsIgnoreCase(cookies[i].getName())) {
                        return cookies[i].getValue();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 移除客户端的cookie
     * @param request
     * @param response
     * @param name
     */
    public static void removeCookieValue(HttpServletRequest request,
                                         HttpServletResponse response, String name) {
        try {
            Cookie cookies[] = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (name.equalsIgnoreCase(cookie.getName())) {
                        cookie = new Cookie(name, null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<CookieVo> getCookieList(HttpServletRequest request, String name) {
        try {
            List<CookieVo> list = JSONArray.parseArray(CookieUtil.getCookieValue(request, name), CookieVo.class);
            List<CookieVo> rtlist = new ArrayList<CookieVo>();
            if (list != null && list.size() > 0) {
                for (CookieVo cookie : list) {
                    CookieVo newcookie = new CookieVo();
                    newcookie.setId(cookie.getId());
                    String name1 = java.net.URLDecoder.decode(cookie.getName(), "UTF-8");
                    System.out.println("===========" + name1);
                    newcookie.setName(name1);
                    rtlist.add(newcookie);
                }

            }
            return rtlist;
        } catch (Exception e) {
            System.err.println("获取cookie值错误" + e.getMessage());
            return null;
        }
    }
}
