/**
 * 描述:<p></p>
 * @Title: ApiUrls.java
 * @Package com.gqgx.constant
 * 
 * @author zhongyang
 * @date 2017年8月25日 下午5:43:56
*/


package com.gqgx.wechat.util;
/**
 * 描述:<p>微信api接口地址</p>
 * @ClassName: ApiUrls
 * @author zhongyang
 * @date 2017年8月25日 下午5:43:56
 *
*/

public class ApiUrls
{
    /**
     * 微信获取access token url
     */
    public static final String WECHAT_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    
    
    /**
     * 微信开放平台access token url
     */
    public static final String WECHAT_COMPONENT_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
    
    
    /**
     * 微信开放平台 使用授权码换取公众号或小程序的接口调用凭据和授权信息
     */
    public static final String WECHAT_COMPONENT_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=COMPONENT_ACCESS_TOKEN";
    
    
    /**
     * 微信开放平台 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
     * 该API用于在授权方令牌（authorizer_access_token）失效时，可用刷新令牌（authorizer_refresh_token）获取新的令牌。
     * 请注意，此处token是2小时刷新一次，开发者需要自行进行token的缓存，避免token的获取次数达到每日的限定额度。
     */
    public static final String WECHAT_COMPONENT_AUTHORIZER_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=COMPONENT_ACCESS_TOKEN";
    
    /**
     * 微信开放平台 获取授权方的帐号基本信息
     * 该API用于获取授权方的基本信息，包括头像、昵称、帐号类型、认证类型、微信号、原始ID和二维码图片URL。
     * 需要特别记录授权方的帐号类型，在消息及事件推送时，对于不具备客服接口的公众号，需要在5秒内立即响应；而若有客服接口，则可以选择暂时不响应，而选择后续通过客服接口来发送消息触达粉丝。
     */
    public static final String WECHAT_COMPONENT_AUTHORIZER_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=COMPONENT_ACCESS_TOKEN";
    
    
    /**
     * 微信开放平台授权页面地址
     */
    public static final String WECHAT_COMPONENT_LOGIN_PAGE = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=COMPONENT_APPID&pre_auth_code=PRE_AUTH_CODE&redirect_uri=REDIRECT_URI";
    
    /**
     * 微信开放平台获取预授权code
     */
    public static final String WECHAT_COMPONENT_CREATE_PREAUTHCODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=COMPONENT_ACCESS_TOKEN";
    
    /**
      * 描述:<p>将公众号/小程序从开放平台帐号下解绑</p>
      * @Fields WECHAT_COMPONENT_UNBIND
    */
    public static final String WECHAT_COMPONENT_UNBIND ="https://api.weixin.qq.com/cgi-bin/open/unbind?access_token=ACCESS_TOKEN";
    
    /**
     * 百度获取access token url
     */
    public static final String BAIDU_GET_ACCESS_TOKEN = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=API_Key&client_secret=Secret_Key";
    
    /**
     * 百度语音识别api
     */
    public static final String BAIDU_SPEECH_API = "http://vop.baidu.com/server_api?lan=zh&cuid=SPEECHCUID&token=SPEECHTOKEN";
    
    /**
     * 微信获取临时素材
     */
    public static final String WECHAT_GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    
    
    /**
     * 图灵API_URL ROBOT_API_URL_V2
     */
    public static final String ROBOT_API_URL_V2 = "http://openapi.tuling123.com/openapi/api/v2";
    
    public static final String ROBOT_API_URL_V1 = "http://openapi.tuling123.com/openapi/api";
    
    /**
     * 腾讯智能ai 对音频进行语音识别，并返回语音的文字内容
     */
    public static final String TENCENT_AAI_ASR = "https://api.ai.qq.com/fcgi-bin/aai/aai_asr";
    
    /**
     * 腾讯智能ai 基础闲聊api接口
     */
    public static final String TENCENT_AAI_TEXTCHAT = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textchat";
    
    /**
      * 描述:<p>新增微信图文消息</p>
      * @Fields WECHAT_ADD_NEWS
    */
    public static final String WECHAT_ADD_NEWS = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";
    
    /**
      * 描述:<p>上传图文消息内的图片获取URL</p>
      * @Fields WECHAT_UPLOAD_IMG
    */
    public static final String WECHAT_UPLOAD_IMG = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";
    
    /**
      * 描述:<p>新增其他类型永久素材</p>
      * @Fields WECHAT_ADD_MATERIAL
    */
    public static final String WECHAT_ADD_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s";
    
    
    /**
      * 描述:<p>获取永久素材</p>
      * @Fields WECHAT_GET_MATERIAL
    */
    public static final String WECHAT_GET_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";
    
    /**
      * 描述:<p>删除永久素材</p>
      * @Fields WECHAT_DEL_MATERIAL
    */
    public static final String WECHAT_DEL_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s";
    
    
    /**
      * 描述:<p>修改永久图文素材</p>
      * @Fields WECHAT_UPDATE_NEWS
    */
    public static final String WECHAT_UPDATE_NEWS = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=%s";
    
}
