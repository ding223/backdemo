package com.gqgx.common.web;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 * Created by Hunter on 2020-06-28.
 */
public class IPAccessControler {
    private static final String _HTTP_PORT_SEPARATER = ":";
    private static final String _HTTP_IP_SEPARATER = ".";
    private static final String _HTTP_IP_UNKNOW = "unknown";

    public boolean hasMatch(String ip, Collection<String> regExps)
    {
        for (String regExp : regExps) {
            if (ip.matches(regExp)) {
                return true;
            }
        }
        return false;
    }

    public static String getRequestIpAddr(HttpServletRequest request)
    {
        String ipString = null;
        String temp = request.getHeader("x-forwarded-for");
        if ((StringUtils.isNotBlank(temp)) && (temp.indexOf(":") == -1) &&
                (temp.indexOf(".") != -1)) {
            ipString = temp;
        }
        if ((StringUtils.isBlank(ipString)) || ("unknown".equalsIgnoreCase(ipString)))
        {
            temp = request.getHeader("Proxy-Client-IP");
            if ((StringUtils.isNotBlank(temp)) && (temp.indexOf(":") == -1) &&
                    (temp.indexOf(".") != -1)) {
                ipString = temp;
            }
        }
        if ((StringUtils.isBlank(ipString)) || ("unknown".equalsIgnoreCase(ipString)))
        {
            temp = request.getHeader("WL-Proxy-Client-IP");
            if ((StringUtils.isNotBlank(temp)) && (temp.indexOf(":") == -1) &&
                    (temp.indexOf(".") != -1)) {
                ipString = temp;
            }
        }
        if ((StringUtils.isBlank(ipString)) || ("unknown".equalsIgnoreCase(ipString)))
        {
            temp = request.getRemoteAddr();
            if ((StringUtils.isNotBlank(temp)) && (temp.indexOf(":") == -1) &&
                    (temp.indexOf(".") != -1)) {
                ipString = temp;
            }
        }
        if (StringUtils.isNotBlank(ipString))
        {
            String[] arr = ipString.split(",");
            String[] arrayOfString1;
            int j = (arrayOfString1 = arr).length;
            for (int i = 0; i < j; i++)
            {
                String str = arrayOfString1[i];
                if ((!"unknown".equalsIgnoreCase(str)) && (str.indexOf(":") == -1) &&
                        (str.split("\\.").length == 4))
                {
                    ipString = str;
                    break;
                }
            }
        }
        else
        {
            try
            {
                ipString = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
        }
        return ipString;
    }
}
