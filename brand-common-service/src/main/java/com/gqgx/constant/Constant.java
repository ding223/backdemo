package com.gqgx.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 常量类
 * @author weihongjun
 *
 */
public class Constant {
    
    /**
     * 默认过滤拦截
     */
    public final static Map<String, String> DEFAULT_FILTER_MAP = new LinkedHashMap<String, String>();
    static
    {
        DEFAULT_FILTER_MAP.put("/building", "authc");
        DEFAULT_FILTER_MAP.put("/css/**", "anon");
        DEFAULT_FILTER_MAP.put("/fonts/**", "anon");
        DEFAULT_FILTER_MAP.put("/html/**", "anon");
        DEFAULT_FILTER_MAP.put("/images/**", "anon");
        DEFAULT_FILTER_MAP.put("/js/**", "anon");
        DEFAULT_FILTER_MAP.put("/loginForm", "anon");
        DEFAULT_FILTER_MAP.put("/login", "anon");
        DEFAULT_FILTER_MAP.put("/vcode", "anon");
        DEFAULT_FILTER_MAP.put("/noPage", "anon");
        DEFAULT_FILTER_MAP.put("/403", "anon");
        DEFAULT_FILTER_MAP.put("/api/**", "anon");
        DEFAULT_FILTER_MAP.put("/**", "authc");
    }
    
    /**
     * 任务类型， TAX 会计任务， OTHER 其它任务
     * @author jacky
     */
    public enum TaskType {TAX,OTHER}
    
    /**
     * 做账系统是否开启
     * @author jacky
     *
     */
    public enum accStatus {
    	use("0"), unuse("1"); 
    	private String value;
    	
    	accStatus(String value) {
    		this.value = value;
    	}
    	
    	public String getValue() {
    		return this.value;
    	}
    }
    
    /**
      * 描述:<p>服务状态(0等待开启，1，服务中，2暂停，3已结束)</p>
      * @ClassName: ServiceStatus
      * @author weihongjun
      * @date 2016年12月26日 上午10:31:00
      *
    */
    public enum ServiceStatus
    {
        
        WAITOPEN("0"), SERVICE("1"), SUSPENDED("2"), FINISH("3");
        
        public String value;

        ServiceStatus(String value)
        {
            this.value = value;
        }
    }
    
    /** 有效状态 */
    public final static String ACTIVE_STATUS = "A";
    
    
    /** 无效状态 */
    public final static String INACTIVE_STATUS = "I";
    
    /** 当前用户操作 */
    public final static String CURRENT_USER_OPTIONS = "USEROPTIONS";
	
	/** 当前用户标识 */
	public final static String CURRENT_LOGIN_USER = "current_login_user";
	
	/** 做账系统*/
	public final static String ACCOUNT_BOOK_INIT = "/accountbook/init.do";
	/** 做账系统凭证查询*/
	public final static String ACCOUNT_REPORT_VOUCHER = "/api/reportVoucher.do";
	
	public static final String ENTERPRISE_TEMPLATE_URL="/templates/客户企业模版.xlsx";
	
	public static final String CUSTOMER_TEMPLATE_URL="/templates/客户导入模版.xlsx";
	
	public static final String BILLS_TEMPLATE_URL="/templates/收款登记表.xlsx";
	
	/**
	 * 登录验证码
	 */
    public final static String VALIDATE_CODE = "VALIDATE_CODE";
    
    /** 关注状态(已关注) */
	public static final String FOCUS_STATUS_SUBSCRIBE = "0";

	/** 关注状态(未关注) */
	public static final String FOCUS_STATUS_UNSUBSCRIBE = "1";
	
    
    
    /**已成功
     * */
    public final static String ORDER_STATUS_0 = "0";
    
    /**待审核
     * */
    public final static String ORDER_STATUS_1 = "1";
    
    /**等待付款
     * */
    public final static String ORDER_STATUS_2 = "2";
    
    /**已注册
     * */
    public final static String IS_REGISTER_0="0";
    /**未注册
     * */
    public final static String IS_REGISTER_1="1";
    
    /**成功
     * */
    public final static String PAYMENT_STATUS_0="0";
    
    /**失败
     * */
    public final static String PAYMENT_STATUS_1="1";
    
    /**支付中
     * */
    public final static String PAYMENT_STATUS_2="2";
    
    /**待审核
     * */
    public final static String PAYMENT_STATUS_3="3";
    
    /**未通过审核
     * */
    public final static String PAYMENT_STATUS_4="4";
    
    /**
     * 订单来源：0=PC端
     */
    public final static String SOURCE_CHANNEL_0 = "0";
    
    /**
     * 订单来源：1=wap端
     */
    public final static String SOURCE_CHANNEL_1 = "1";
    
    /**
     * 订单来源：2=线下
     */
    public final static String SOURCE_CHANNEL_2 = "2";
    
    public final static String IMG_BASE64_PREFIX = "data:image/png;base64,";
    
    public final static String SYS_USER_OPTIONS = "SYSUSEROPTIONS";
    
    /**
     * 登录成功
     */
    public final static String LOGIN_TYPE_FAIL = "1";
    
    /**
     * 登录失败
     */
    public final static String LOGIN_TYPE_SUCCESS = "0";
    
    /**
     * 微信配置信息session id
     */
    public final static String WECHAT_CONFIG = "WECHATCONFIG";
    
    /** 
     * 默认premission字符串 
     */  
    public static final String PREMISSION_PERMS_STRING = "perms[{0}]";
    
    public static final String PREMISSION_ROLES_STRING = "roles[{0}]";
    
    public static final String PREMISSION_ANON_STRING = "anon";//anon,表示可以匿名使用
    
    public static final String PREMISSION_AUTHC_STRING = "authc";//表示需要认证(登录)才能使用
    
    /**
     * 微信公众号授权地址
     */
    /*public static final String WECHAT_AUTH_URL = "http://ai.duoyoumi.com/wechat/accreditView";*/
    
    //请求类型：0：anon,表示可以匿名使用，1：authc,表示需要认证(登录)才能使用,2:roles,所需角色，3：perms，所需权限
    
    /**
     * 普通产品
     */
    public static final String SERVICE_TYPE_0="0";
    /**
     * 套餐
     */
    public static final String SERVICE_TYPE_1="1";
    
    /**
     * 企业服务状态服务状态(0等待开启，1，服务中，2暂停，3已结束)
     */
    public static final String SERVICE_status_0="0";
    
    /**
     * 企业服务状态服务状态(0等待开启，1，服务中，2暂停，3已结束)
     */
    public static final String SERVICE_status_1="1";
    
    /**
     * 企业服务状态服务状态(0等待开启，1，服务中，2暂停，3已结束)
     */
    public static final String SERVICE_status_2="2";
    
    /**
     * 企业服务状态服务状态(0等待开启，1，服务中，2暂停，3已结束)
     */
    public static final String SERVICE_status_3="3";
    
    /**
     * 地区权限
     */
    public static final String POSITION_PERM_1 = "1";
    
    /**
     * 数据层级权限
     */
    public static final String POSITION_PERM_2 = "2";
    
    /**
     * 数据层级：本人
     */
    public static final String DATA_PERM_0 = "0";
    
    /**
     * 数据层级：本部门
     */
    public static final String DATA_PERM_1 = "1";
    
    /**
     * 数据层级：本部门及子部门
     */
    public static final String DATA_PERM_2 = "2";
    
    /**
     * 数据层级：全公司
     */
    public static final String DATA_PERM_3 = "3";
    
}
