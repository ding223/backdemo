/**
 * 描述:<p></p>
 * @Title: RequestResult.java
 * @Package com.gqgx.util
 * 
 * @author weihongjun
 * @date 2016年5月17日 上午9:38:27
*/


package com.gqgx.domain;

import java.util.HashMap;
import java.util.Map;


/**
  * 描述:<p>异步请求结果：<br>
  * code：200（成功），400（失败），500（异常）<br>
  * msg：请求返回信息<br>
  * model：请求返回数据
  * </p>
  * @ClassName: RequestResult
  * @author weihongjun
  * @date 2016年11月16日 上午11:13:38
  *
*/
public class RequestResult
{
    public enum CODE
    {
        SUCCESS("成功", "200"), FAIL("失败", "400"), ERROR("异常", "500"), UNAUTH("没有权限", "403"),
        DATABASEERROR("数据库异常", "401"),
        DATANONCONFORMITY("数据不符合要求", "402");
        
        private String name;
        
        private String code;
        
        CODE(String name, String code)
        {
            this.name = name;
            this.code = code;
        }
        
        /**
         * getter method
         * @return the name
         */
        
        public String getName()
        {
            return this.name;
        }

        /**
         * setter method
         * @param name the name to set
         */
        
        public void setName(String name)
        {
            this.name = name;
        }

        /**
         * getter method
         * @return the code
         */
        
        public String getCode()
        {
            return this.code;
        }

        /**
         * setter method
         * @param code the code to set
         */
        
        public void setCode(String code)
        {
            this.code = code;
        }
    }
    
    
    private String code = CODE.SUCCESS.getCode(); //请求编码
    
    private String msg; //错误信息
    
    private Map<String, Object> model = new HashMap<String, Object>();
    
    public RequestResult()
    {
        super();
    }
    
    public RequestResult(CODE code, String msg)
    {
        this.code = code == null ? CODE.SUCCESS.getCode() : code.getCode();
        this.msg = msg;
    }
    
    public RequestResult(CODE code, String msg, Map<String, Object> model)
    {
        this.code = code == null ? CODE.SUCCESS.getCode() : code.getCode();
        this.msg = msg;
        this.model = model;
    }
    
    public void addModel(String key, Object value)
    {
        this.model.put(key, value);
    }

    /**
     * getter method
     * @return the code
     */
    
    public String getCode()
    {
        return this.code;
    }

    /**
     * setter method
     * @param code the code to set
     */
    
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * getter method
     * @return the msg
     */
    
    public String getMsg()
    {
        return this.msg;
    }

    /**
     * setter method
     * @param msg the msg to set
     */
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * getter method
     * @return the model
     */
    
    public Map<String, Object> getModel()
    {
        return this.model;
    }

    /**
     * setter method
     * @param model the model to set
     */
    
    public void setModel(Map<String, Object> model)
    {
        this.model = model;
    }
}
