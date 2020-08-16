/**
 * 描述:<p></p>
 * @Title: RelativeDateFormat.java
 * @Package com.gqgx.utils
 * 
 * @author weihongjun
 * @date 2017年5月5日 下午5:23:02
*/


package com.gqgx.common.utils;

import com.gqgx.common.lang.Dates;

import java.util.Date;

/**
 * 描述:<p></p>
 * @ClassName: RelativeDateFormat
 * @author weihongjun
 * @date 2017年5月5日 下午5:23:02
 *
 */

public class RelativeDateFormat
{
    private static final long ONE_MINUTE = 60000L;
    
    private static final long ONE_HOUR = 3600000L;
    
    private static final long ONE_DAY = 86400000L;
    
    private static final String ONE_SECOND_AGO = "秒前";
    
    private static final String ONE_MINUTE_AGO = "分钟前";
    
    private static final String ONE_HOUR_AGO = "小时前";
    
    private static final String ONE_DAY_AGO = "天前";
    
    private static final String ONE_WRRK_AGO = "周前";
    
    private static final String ONE_MONTH_AGO = "月前";
    
    private static final String ONE_YEAR_AGO = "年前";
    
    public static String format(Date date)
    {
        String result = "";
        if (date != null)
        {
            Date currentDate = new Date();
            long diff = currentDate.getTime() - date.getTime();
            long days = diff / ONE_DAY;
            long hours = (diff - days * ONE_DAY) / ONE_HOUR;
            long minutes = (diff - days * ONE_DAY - hours * ONE_HOUR) / ONE_MINUTE;
            long second = (diff - days * ONE_DAY - hours * ONE_HOUR - minutes * ONE_MINUTE) / 1000;
            
            if (days > 365 * 2)
            {
                result = Dates.format("yyyy-MM-dd HH:mm:ss", date);
            }
            else if (days > 365 && days <= 365 * 2)
            {
                result = days / 365 + ONE_YEAR_AGO;
            }
            else if (days > 30)
            {
                result = days / 30 + ONE_MONTH_AGO;
            }
            else if (days > 0 && days <= 30)
            {
                if (days / 7 > 0)
                {
                    result = days / 7 + ONE_WRRK_AGO;
                }
                else
                {
                    result = days + ONE_DAY_AGO;
                }
            }
            else if (hours > 0 && hours <= 24)
            {
                result = hours + ONE_HOUR_AGO;
            }
            else if (minutes > 0 && minutes <= 60)
            {
                result = minutes + ONE_MINUTE_AGO;
            }
            else if (second > 0 && second <= 60)
            {
                result = second + ONE_SECOND_AGO;
            }
        }
        return result;
    }
}
