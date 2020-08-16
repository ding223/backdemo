package com.gqgx.common.springutils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * Created by Hunter on 2020-06-27.
 */
public class Springs implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        applicationContext = arg0;
        System.out.println("applicationContext配置文件加载成功!!!!");
    }

    /**
     * @Title: getApplicationContext
     * @Description: 获取应用上下文环境
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;

    }

    /**
     * @Title: getBean
     * @Description: 根据bean对象的名字获取bean
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * @Title: getBean
     * @Description: 用反射的方法获取bean，如果有多个符合条件的，则返回第一个
     * @param clzz
     * @return 返回类型
     */
    public static <T> T getBean(Class<T> clzz) {
        checkApplicationContext();
        Map<String, T> mapBeans = applicationContext.getBeansOfType(clzz);
        if (mapBeans != null && !mapBeans.isEmpty()) {
            return (T) mapBeans.values().iterator().next();
        } else {
            return null;
        }
    }

    /**
     * @Title: checkApplicationContext
     * @Description: 检查applicationContext是否初始化
     * @return 返回类型
     */
    public static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext.xml文件没有加载或者Springs没有在applicationContext.xml中注入！！！！！");
        }
    }
}
