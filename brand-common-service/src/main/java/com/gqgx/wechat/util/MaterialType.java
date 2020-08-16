/**
 * 描述:<p></p>
 * @Title: MaterialType.java
 * @Package com.gqgx.constant
 * 
 * @author zhongyang
 * @date 2017年8月28日 下午2:59:19
*/


package com.gqgx.wechat.util;
/**
 * 描述:<p>微信素材类型</p>
 * @ClassName: MaterialType
 * @author zhongyang
 * @date 2017年8月28日 下午2:59:19
 *
*/

public enum MaterialType
{
    image("image","图片"),
    voice("voice","语音"),
    video("video","视频"),
    thumb("thumb","缩略图"),
    imagetext("imagetext","图文");
    
    private String type;
    
    private String name;
    
    MaterialType(String type, String name)
    {
        this.type=type;
        this.name=name;
    }

    /**
     * getter method
     * @return the type
     */
    
    public String getType()
    {
        return this.type;
    }

    /**
     * setter method
     * @param type the type to set
     */
    
    public void setType(String type)
    {
        this.type = type;
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
    
}
