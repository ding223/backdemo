/**
 * 描述:<p></p>
 * @Title: AccountAuthUtils.java
 * @Package com.gqgx.utils
 * 
 * @author weihongjun
 * @date 2016年11月24日 上午11:55:42
*/


package com.gqgx.utils;

import com.gqgx.common.lang.util.MD5Utils;
import org.apache.commons.lang.text.StrBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 描述:<p></p>
 * @ClassName: AccountAuthUtils
 * @author weihongjun
 * @date 2016年11月24日 上午11:55:42
 *
*/

public class AccountAuthUtils
{
    /**
      * 描述:<p>getAuth</P>
      *
      * @author weihongjun
      * @param map
      * @param secret
      * @return
      * @return String
      * @throws
    */
    public static String getAuth(final Map<String, Object> map, final String secret)
    {
        final List<String> keyList = new ArrayList<String>();
        for (String key : map.keySet())
        {
            keyList.add(key);
        }
        Collections.sort(keyList);
        final StrBuilder builder = new StrBuilder();
        for (String key : keyList)
        {
            builder.append(map.get(key));
        }
        return MD5Utils.encryptMD5(builder.toString() + secret);
    }
}
