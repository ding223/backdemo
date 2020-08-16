package com.gqgx.common.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * 腾讯云短信工具类
 */

public class SmsSenderUtil {
	
	public final static String QCLOUD_PARAM = "%s?sdkappid=%d&random=%d";
	/**
	 * 拉取短信模板
	 */
	public final static String GET_TEMPLATE =  "https://yun.tim.qq.com/v5/tlssmssvr/get_template";
	
	/**
	 * 修改短信模板
	 */
	public final static String MOD_TEMPLATE = "https://yun.tim.qq.com/v5/tlssmssvr/mod_template";
	
	/**
	 * 删除短信模板
	 */
	public final static String DEL_TEMPLATE = "https://yun.tim.qq.com/v5/tlssmssvr/del_template";
	
	/**
	 * 添加短信模板
	 */
	public final static String ADD_TEMPLATE = "https://yun.tim.qq.com/v5/tlssmssvr/add_template";
	
	/**
	 * 添加签名模板
	 */
	public final static String ADD_SIGN = "https://yun.tim.qq.com/v5/tlssmssvr/add_sign";
	
	/**
	 * 拉取签名模板
	 */
	public final static String GET_SIGN = "https://yun.tim.qq.com/v5/tlssmssvr/get_sign";
	
	/**
	 * 修改签名模板
	 */
	public final static String MOD_SIGN = "https://yun.tim.qq.com/v5/tlssmssvr/mod_sign";
	
	/**
	 * 删除签名模板
	 */
	public final static String DEL_SIGN = "https://yun.tim.qq.com/v5/tlssmssvr/del_sign";
	
	/**
	 * 按模板单发短信
	 */
	public final static String SENDSMS = "https://yun.tim.qq.com/v5/tlssmssvr/sendsms";
	
	/**
	 * 按模板群发短信
	 */
	public final static String SENDMULTISMS = "https://yun.tim.qq.com/v5/tlssmssvr/sendmultisms2";
	
	/**
	 * 发送短信参数
	 */
	public final static String SENDPARAMS = "appkey=%s&random=%d&time=%d&mobile=%s";
		
	public static final String REGISTER_CODE = "1001";// 注册

	public static final String FORGET_PWD_CODE = "1002";// 忘记密码
	
	public static final String MOBILE_LOGIN_CODE = "1005";// 手机号码登录验证码

	public static final String REGISTER_SUCESS_CODE = "1003";// 注册成功

	public static final String UPDATE_PWD_CODE = "1004";// 修改密码

	public static final String PAY_SUCESS_CODE = "2001";// 付款成功

	public static final String ZJBS_SERVICE_CODE = "3001";// 做账服务编码

	public static final String SERVICE_ORVER_CODE = "3002";// 服务完成
	
	public static final String SERVICE_RESET_PASSWORD = "4001";// 重置密码
	
	public static final String SERVICE_OPEN_ACCOUNT = "4002";// 开通帐号
	
	public static final String SEND_VOUCHER_CODE = "6001";// 送优惠券
	
	public static final String SEND_TASK_CODE = "7001";// 分配任务
	
	public static final String SEND_TASKBUSINESS_DONE = "7002";//完成任务节点
	
	/**
	 * 默认签名
	 */
	public static final String DEFALT_SIGN = "1100";
	
	protected static Random random = new Random();
	    
    public String stringMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] inputByteArray = input.getBytes();
        messageDigest.update(inputByteArray);
        byte[] resultByteArray = messageDigest.digest();
        return byteArrayToHex(resultByteArray);
    }
    

    public static String strToHash(String str) throws NoSuchAlgorithmException {
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	    byte[] inputByteArray = str.getBytes();
	    messageDigest.update(inputByteArray);
	    byte[] resultByteArray = messageDigest.digest();
	    return byteArrayToHex(resultByteArray);
	}

	public static String byteArrayToHex(byte[] byteArray) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		return new String(resultCharArray);
	}
	    
    public static int getRandom() {
    	return random.nextInt(999999)%900000+100000;
    }
    
    public static HttpURLConnection getPostHttpConn(String url) throws Exception {
        URL object = new URL(url);
        HttpURLConnection conn;
        conn = (HttpURLConnection) object.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("POST");
        return conn;
	}
    
    public static String addcalculateSig(String appkey,long random,long curTime) throws NoSuchAlgorithmException{
    	 return strToHash(String.format("appkey=%s&random=%d&time=%d",appkey, random, curTime));
    }
    
    public static String join(CharSequence delimiter, CharSequence... elements){
        StringBuffer joiner = new StringBuffer();
        if(null != elements && elements.length > 0){
        	 for (int i = 0; i < elements.length; i ++) {
        		 CharSequence item = elements[i];
        		 joiner.append(item);
        		 if(i != (elements.length-1)){
        			 joiner.append(delimiter);
        		 }
             }
        }
        return joiner.toString();
    }
}
