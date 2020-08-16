package com.gqgx.wechat.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class PayCommonUtil {
	/** 
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 
     * @return boolean 
     */  
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
		Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            String v = (String)entry.getValue();  
            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
          
        sb.append("key=" + API_KEY);  
          
        //算出摘要  
        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();  
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  
          
        return tenpaySign.equals(mysign);  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：sign签名 
     * @param characterEncoding 
     *            编码格式 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + API_KEY);  
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：将请求参数转换为xml格式的string 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String getRequestXml(SortedMap<Object, Object> parameters) {  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
            } else {  
                sb.append("<" + k + ">" + v + "</" + k + ">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
  
    /** 
     * 取出一个指定长度大小的随机正整数. 
     *  
     * @param length 
     *            int 设定所取出随机数的长度。length小于11 
     * @return int 返会生成的随机数。 
     */  
    public static int buildRandom(int length) {  
        int num = 1;  
        double random = Math.random();  
        if (random < 0.1) {  
            random = random + 0.1;  
        }  
        for (int i = 0; i < length; i++) {  
            num = num * 10;  
        }  
        return (int) ((random * num));  
    }  
  
    /** 
     * 获取当前时间 yyyyMMddHHmmss 
     *  
     * @return String 
     */  
    public static String getCurrTime() {  
        Date now = new Date();  
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
        String s = outFormat.format(now);  
        return s;  
    }
	
    public static String CreateNoncestr() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}
    
    /** 
     * @Description 解释微信异步响应
     * @author weihongjun
     * @param inputStream
     * @return
     * @throws Exception  
     */
    public static SortedMap<Object,Object> readWechatMap(InputStream inputStream ) throws Exception{
    	SortedMap<Object,Object> map = new  TreeMap<Object,Object>();  
        SAXReader reader = new SAXReader();
        Document document=null;
        document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList){
            System.out.println("=====================================================");
            System.out.println(e.getName()+"=============================="+e.getText());
            System.out.println("=====================================================");
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }
    
    public static void main(String[] args) {
    	
    	SortedMap<Object, Object> packageParams =new TreeMap<Object, Object>();
    	packageParams.put("appid", "wx4a8150ddf3453aac");
    	packageParams.put("attach", "337a87b679b9569310b76b6226c2fffe");
    	packageParams.put("bank_type", "CMB_CREDIT");
    	packageParams.put("cash_fee", "1");
    	packageParams.put("fee_type", "CNY");
    	packageParams.put("is_subscribe", "N");
    	packageParams.put("mch_id", "1225557002");
    	packageParams.put("nonce_str", "XDrdwsueSR5yJi1d");
    	packageParams.put("openid", "odvQLuHS8EqEGygCTW-FZMPK1AuY");
    	packageParams.put("out_trade_no", "1201712151944061735");
    	packageParams.put("result_code", "SUCCESS");
    	packageParams.put("return_code", "SUCCESS");
    	packageParams.put("sign", "0E58CBE89F606D8177F66ACA33DFF1A4");
    	packageParams.put("time_end", "20171215194428");
    	packageParams.put("trade_type", "NATIVE");
    	packageParams.put("total_fee", "1");
    	packageParams.put("transaction_id", "4200000028201712154720832306");
    	System.out.println(isTenpaySign("utf-8", packageParams, "sgsgfLJLKHJGH44s4fgs7gs4g4ss4dgs"));
	}
}
