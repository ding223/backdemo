package com.gqgx.common.web;

import com.gqgx.common.lang.Strings;

/**
 * Created by Hunter on 2020-06-28.
 */
public class BrowserUtils {
    public static String getBrowserName(String agent)
    {
        agent = agent.toLowerCase();
        if (Strings.isEmpty(agent)) {
            return "";
        }
        if (agent.indexOf("msie 7") > 0) {
            return "ie7";
        }
        if (agent.indexOf("msie 8") > 0) {
            return "ie8";
        }
        if (agent.indexOf("msie 9") > 0) {
            return "ie9";
        }
        if (agent.indexOf("msie 10") > 0) {
            return "ie10";
        }
        if (agent.indexOf("msie") > 0) {
            return "ie";
        }
        if (agent.indexOf("opera") > 0) {
            return "opera";
        }
        if (agent.indexOf("opera") > 0) {
            return "opera";
        }
        if (agent.indexOf("firefox") > 0) {
            return "firefox";
        }
        if ((agent.indexOf("gecko") > 0) && (agent.indexOf("rv:11") > 0)) {
            return "ie11";
        }
        if (agent.indexOf("camino") > 0) {
            return "camino";
        }
        if (agent.indexOf("safari") > 0) {
            return "safari";
        }
        if (agent.indexOf("webkit") > 0) {
            return "webkit";
        }
        return "Others";
    }

    public static String getTermianlType(String agent)
    {
        String type = "";
        if (!Strings.isEmpty(agent)) {
            if ((agent.contains("Windows NT")) || (agent.contains("Macintosh"))) {
                type = "1";
            } else if (agent.contains("Mac OS")) {
                type = "3";
            } else if (agent.contains("Android")) {
                type = "2";
            } else {
                type = "4";
            }
        }
        return type;
    }
}
