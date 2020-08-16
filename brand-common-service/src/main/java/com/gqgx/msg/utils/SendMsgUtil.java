package com.gqgx.msg.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class SendMsgUtil {
	
	public static int sendMsg(String phone,int appId,String appKey,String sign,int templateId,String[] params) {
		int resultCode = 1;
		try {
		    SmsSingleSender ssender = new SmsSingleSender(appId, appKey);
		    SmsSingleSenderResult result = ssender.sendWithParam("86", phone,templateId, params, sign, "", "");
		    System.err.println("发送短信结果========"+result);
		} catch (Exception e) {
			resultCode = 0;
		    System.err.println("发送短信失败========"+e.getMessage());
		}
		return resultCode;
	}
}
