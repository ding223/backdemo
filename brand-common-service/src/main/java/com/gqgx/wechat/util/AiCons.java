package com.gqgx.wechat.util;



/**
* @ClassName: Constant
* @Description: 系统常量类
* @author "zhongyang"
* @date 2017年6月12日 上午11:39:36
* 
*/

public class AiCons
{
    
    /**
     * SOLR 服务端url key
     */
    public final static String SOLR_SERVER_URL = "solr.url";
    
    /**
     * 用户
     */
    public final static String SOLR_DEFAULT_USER = "solr.user";
    
    /**
     * 密码
     */
    public final static String SOLR_DEFAULT_PASS = "solr.auth";
    
    //使用摘要
    public static final boolean SUMMARY = true;
    
    //google查询每页大小
    public static final Integer PAGESIZE =10;
    
    //设置默认搜索域
    public final static String QUERY_DF = "questionKeyworks";
    
    //默认高亮字段
    public final static String HIGHLIGHT_DF = "majorQuestion";
    
    
    
    /**
    * @Fields WECHAT_COMPONENT_TOKEN : 微信开放平台TOKEN
    */
    public static final String WECHAT_COMPONENT_TOKEN = "17p41963h6";
    
    /**
     * @Fields WECHAT_COMPONENT_TOKEN : 微信开放平台Secret
     */
     public static final String WECHAT_COMPONENT_SECRET = "a62aedce322c0657a433cb346182659a";
     
     /**
      * @Fields WECHAT_COMPONENT_TOKEN : 微信开放平台AppId
      */
      public static final String WECHAT_COMPONENT_APPID = "wx334fbaba03474bdb";
    
    /**
     * @Fields WECHAT_COMPONENT_TOKEN : 微信开放平台encodingAESKey
     */
     public static final String WECHAT_COMPONENT_AESKEY = "nFKefKvDr5d4NYdavkOppi64UFsR9wuri8A1LBxno5s";
    
    /**
     * 微信token
     */
    public static final String WECHAT_TOKEN = "17p41963h6";
    
    /**
     * 微信APPID
     */
    public static final String WECHAT_APPID = "wx3e82ba09ff3c5983";
    
    /**
     * 微信APPSECRET
     */
    public static final String WECHAT_APPSECRET = "e00d3d3b867a4ff438da8d5e1529621a";
    
    /**
    * @Fields WECHAT_COMPONENT_REDIRECT_URI : 授权成功页面跳转
    */
    public static final String WECHAT_COMPONENT_REDIRECT_URI = "/wechat/authSuccess";
    
    
    /**
     * 百度API Key
     */
    public static final String BAIDU_API_KEY = "NG9KrUhMiTVPjH1BlgO8PY4L";
    
    
    /**
     * 百度Secret Key
     */
    public static final String BAIDU_SECRE_KEY = "aALQz7wGk9hzoXGAXGh1yK92kS2k3aIX";
    
    
    /**
     * 图灵apikey
     */
    public static final String ROBOT_APIKEY = "b4179a18c287431294a19032a33d7297";
    
    /**
     * 图灵SECRET
     */
    public static final String ROBOT_SECRET = "765e4811d39224b2ONOFF";
    
    
    /**
     * 腾讯智能ai app id
     */
    public static final String TENCENT_AI_APPID = "1106255968";
    
    /**
     * 腾讯智能ai app key
     */
    public static final String TENCENT_AI_APPKEY = "7r1hrX4r51TnV5rn";
    
    
    // 请求消息类型：文本
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";
    // 请求消息类型：图片
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
    // 请求消息类型：语音
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
    // 请求消息类型：视频
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    // 请求消息类型：小视频
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
    // 请求消息类型：地理位置
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
    // 请求消息类型：链接
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    // 请求消息类型：事件推送
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    // 事件类型：subscribe(订阅)
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    // 事件类型：unsubscribe(取消订阅)
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    // 事件类型：scan(用户已关注时的扫描带参数二维码)
    public static final String EVENT_TYPE_SCAN = "scan";
    // 事件类型：LOCATION(上报地理位置)
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    // 事件类型：CLICK(自定义菜单)
    public static final String EVENT_TYPE_CLICK = "CLICK";

    // 响应消息类型：文本
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    // 响应消息类型：图片
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    // 响应消息类型：语音
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    // 响应消息类型：视频
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    // 响应消息类型：音乐
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    // 响应消息类型：图文
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";
    
    // 编码方式：UTF-8
    public static final String CHARSET_UTF_8 = "UTF-8";
    
    // 编码方式：GBK
    public static final String CHARSET_GBK = "GBK";
    
    public static final char[] RANDOM_CHARS = {'a','b','c','d','e','f','1','2','3','4','5','6','7','8','9','0'};
    
    // redis key
    public static final String REDIS_WACHAT_KEY = "wachat_distributed:";
    
    
    // 百度access token redis key
    public static final String REDIS_BAIDU_ACCESS_TOKEN = "baiduAccessToken";
    
    // 微信access token redis key
    public static final String REDIS_WACHAT_ACCESS_TOKEN = "wachatAccessToken";
    
    // 微信开放平台COMPONENT_ACCESS_TOKEN redis key
    public static final String REDIS_COMPONENT_ACCESS_TOKEN = "componentAccessToken";
    
    // 微信开放平台Authorizer ACCESS Token redis key
    public static final String REDIS_AUTHORIZER_ACCESS_TOKEN = "authorizerToken";
    
    /**
     * 登录用户session id
     */
    public static final String AI_LOGIN_USER = "currentUser";
    
    /**
     * 微信接收消息域名
     */
    public static final String WECHAT_WEBAPP_DOMAIN = "http://ai.xxx.com/";
    
}
