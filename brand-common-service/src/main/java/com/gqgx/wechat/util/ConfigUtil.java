package com.gqgx.wechat.util;


public class ConfigUtil {
	 private ConfigUtil(){}
	// 签名加密方式
	public final static String SIGN_TYPE = "MD5";
	// 微信支付证书存放路径地址
	public final static String CERT_PATH = "D:/cert1/apiclient_cert.p12";
	
	// 微信支付统一接口的会调action
	public final static String NOTIFY_URL = "/order/wechatPayment";
	// 获取微信openId
	public final static String OPEN_ID = "open_id";
	
	// 一级微信菜单最大字符数
	public final static Integer MENU_LEVE1_MAXSIZE = 4;
	// 二级微信菜单最大字符数
	public final static Integer MENU_LEVE2_MAXSIZE = 7;
	// 获取token接口(GET)
	public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 获取已关注用户信息接口(GET)
	public final static String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 获取微信用户(无论是否关注)信息接口(GET);access_token:网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	public final static String WECHAT_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 获取二维码ticket接口(POST)
	public final static String QRCODE_TICKET = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	// 通过ticket换取二维码接口(GET)
	public final static String TICKET2QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	// 获取素材列表接口(POST)
	public final static String MATERIAL_LIST = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	// 请求 access_token 接口 url
    public final static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    // 创建菜单信息URL
    public final static String menuCreateUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    // 删除菜单信息URL
    public final static String deleteCreateUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
    // 获取菜单信息URL
    public final static String menuFindUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
    // 客户推送文本消息接口
    public final static String customMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
    // 通过code换取网页授权access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    public final static String CODE2ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
    // 发送微信模板消息链接 SEND_TEMPLATE_URL 
    public final static String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    // 根据模板编号获取模板ID,(不同服务号对应的相同编号的模板ID不一样)API_ADD_TEMPLATE 
    public final static String API_ADD_TEMPLATE = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
    // 新增永久素材 uploadMediaUrl 
    public final static String UPLOAD_MEDIAURL = "http://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
    // 删除永久素材 
    public final static String DELETE_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";
    // 调用微信JS接口的临时票据：jsapi_ticket
    public final static String JSAPI_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=";
	
	/**
	 * 微信支付接口地址
	 */
	// 微信支付统一接口(POST)
	public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	// 微信退款接口(POST)
	public final static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	// 订单查询接口(POST)
	public final static String CHECK_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	// 关闭订单接口(POST)
	public final static String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	// 退款查询接口(POST)
	public final static String CHECK_REFUND_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	// 对账单接口(POST)
	public final static String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
	// 短链接转换接口(POST)
	public final static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
	// 接口调用上报接口(POST)
	public final static String REPORT_URL = "https://api.mch.weixin.qq.com/payitil/report";
}
