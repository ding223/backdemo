package com.gqgx.common.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.Assert;

public class PropertyHolder
        extends PropertyPlaceholderConfigurer
{
    private static Map<String, String> ctxPropertiesMap = new HashMap();

    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
    {
        super.processProperties(beanFactoryToProcess, props);
        for (Object objKey : props.keySet())
        {
            String keyStr = objKey.toString();
            ctxPropertiesMap.put(keyStr, props.getProperty(keyStr));
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("����������" + keyStr + "=" + props.getProperty(keyStr));
            }
        }
    }

    public static boolean getBooleanProperty(String propKey)
    {
        String value = (String)ctxPropertiesMap.get(propKey);
        return "true".equals(value);
    }

    public static <T> T getProperty(String propKey)
    {
        T value = (T) ctxPropertiesMap.get(propKey);
        return value;
    }

    public static String getStringProperty(String propKey)
    {
        String value = (String)ctxPropertiesMap.get(propKey);
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        return "";
    }

    public static void setProperty(String propKey, String value)
    {
        Assert.notNull(propKey);
        ctxPropertiesMap.put(propKey, value);
    }

    public static String getMessageProperty(String propKey, String... args)
    {
        String value = (String)ctxPropertiesMap.get(propKey);
        return getMessageValue(value, args);
    }

    public static String getMessageValue(String propValue, String... args)
    {
        String value = propValue;
        if ((args != null) && (args.length > 0) && (StringUtils.isNotBlank(value))) {
            for (int i = 0; i < args.length; i++) {
                value = value.replace("{" + i + "}", args[i]);
            }
        }
        return value;
    }
}