package com.gqgx.utils;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

public class JsonUtils {
	
	public static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	/**
     * 分页结果设置
     * 
     * @param result 结果集
     * @return JSON串
     */
    public static void renderJson(HttpServletResponse response,@SuppressWarnings("rawtypes") DGJSONResult result)
    {
        try
        {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            PrintWriter pw = response.getWriter();
            
            pw.write(new Gson().toJson(result));
            pw.flush();
            pw.close();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
    }
    
    
    public static <T> List<T>  jsonToList(String jsonString,Class<T> t)
    {
    	JSONArray jsonArray = JSONArray.fromObject(jsonString);
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) JSONArray.toList(jsonArray,t);
    	return list;
    } 
    
    /** 
     * 将  Json 串 解析成 Map或者javabean 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T jsonStrToObject(String jsonStr, Class<T> clazz){  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        Object obj = JSONObject.toBean(json, clazz);  
        return (T) obj;  
    } 
    
    /** 
     * 将  Json 串 解析成 Array,list,set 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> Collection<T> jsonStrToArray(String jsonStr){  
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);  
        Object array = JSONArray.toArray(jsonArray);  
        return (Collection<T>) array;  
    }  

    /*** 
     * 将javabean对象和map对象 解析成 Json 串 
     * @param obj 
     * @return 
     */  
    public static String objectToJsonStr(Object obj){  
        JSONObject json = JSONObject.fromObject(obj);  
        return json.toString();  
          
    }  
    
    /** 
     * 将 Array,list,set 解析成 Json 串 
     * @return Json 串 
     */  
    public static String arrayToJsonStr(Object objs){  
        JSONArray json = JSONArray.fromObject(objs);  
        return json.toString();  
    } 
    
}
