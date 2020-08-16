package com.gqgx.common.utils;

/**
 * 阿里云短信配置
 */
public class AliyunSmsUtil {
	
	/**
	 * 模板
	 * ALIYUN_KTZH ERP开通账号通知
	 * ALIYUN_CZMM 重置密码
	 * ALIYUN_ZCYH 注册用户验证码
	 * ALIYUN_WJMM 忘记密码验证码
	 */
    public final static String ALIYUN_KTZH = "aliyun_ktzh";
    public final static String ALIYUN_CZMM = "aliyun_czmm";
    public final static String ALIYUN_ZCYH = "aliyun_zcyh";
    public final static String ALIYUN_WJMM = "aliyun_wjmm";
    
    /**
     * 配置
     * aliyunConnectTimeout 连接超时时间
     * aliyunReadTimeout 读超时时间
     * aliyunAccessKeyId 阿里云ID
     * aliyunAccessKeySecret 阿里云秘钥
     * aliyunSignName 短信签名
     * aliyunProduct 产品名称
     * aliyunDomain 阿里云域名
     */
    private String aliyunConnectTimeout;
    
    private String aliyunReadTimeout;
    
    private String aliyunAccessKeyId;
    
    private String aliyunAccessKeySecret;
    
    private String aliyunSignName;
    
    private String aliyunProduct;
    
    private String aliyunDomain;

	public String getAliyunConnectTimeout() {
		return aliyunConnectTimeout;
	}

	public void setAliyunConnectTimeout(String aliyunConnectTimeout) {
		this.aliyunConnectTimeout = aliyunConnectTimeout;
	}

	public String getAliyunReadTimeout() {
		return aliyunReadTimeout;
	}

	public void setAliyunReadTimeout(String aliyunReadTimeout) {
		this.aliyunReadTimeout = aliyunReadTimeout;
	}

	public String getAliyunAccessKeyId() {
		return aliyunAccessKeyId;
	}

	public void setAliyunAccessKeyId(String aliyunAccessKeyId) {
		this.aliyunAccessKeyId = aliyunAccessKeyId;
	}

	public String getAliyunAccessKeySecret() {
		return aliyunAccessKeySecret;
	}

	public void setAliyunAccessKeySecret(String aliyunAccessKeySecret) {
		this.aliyunAccessKeySecret = aliyunAccessKeySecret;
	}

	public String getAliyunSignName() {
		return aliyunSignName;
	}

	public void setAliyunSignName(String aliyunSignName) {
		this.aliyunSignName = aliyunSignName;
	}

	public String getAliyunProduct() {
		return aliyunProduct;
	}

	public void setAliyunProduct(String aliyunProduct) {
		this.aliyunProduct = aliyunProduct;
	}

	public String getAliyunDomain() {
		return aliyunDomain;
	}

	public void setAliyunDomain(String aliyunDomain) {
		this.aliyunDomain = aliyunDomain;
	}
}
