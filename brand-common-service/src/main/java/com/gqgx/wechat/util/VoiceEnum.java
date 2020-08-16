package com.gqgx.wechat.util;



/**
* @ClassName: VoiceType
* @Description: 语音消息格式
* @author zhongyang
* @date 2017年6月30日 上午9:52:15
* 
*/
public enum VoiceEnum
{
    PCM("PCM", 1), WAV("WAV", 2), AMR("AMR", 3), SILK("SILK", 4);
    
    private String name;
    
    private int type;
    
    VoiceEnum(String name, int type)
    {
        this.name = name;
        this.type = type;
    }
    
    public String getSuffix()
    {
        return "." + this.getName().toLowerCase();
    }
    
    public static VoiceEnum getByType(int type)
    {
        VoiceEnum[] values = VoiceEnum.values();
        for (VoiceEnum val : values)
        {
            if (val.getType() == type)
            {
                return val;
            }
        }
        return null;
    }
    
    public static VoiceEnum getByName(String name)
    {
        VoiceEnum[] values = VoiceEnum.values();
        for (VoiceEnum val : values)
        {
            if (val.getName().equalsIgnoreCase(name))
            {
                return val;
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
}
