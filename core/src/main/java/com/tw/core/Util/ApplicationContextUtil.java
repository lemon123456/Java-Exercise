package com.tw.core.Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;


/**
 * Created by twer on 7/11/15.
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 把ApplicationContext对象注入到当前类中作为一个静态成员变量
     * {@inheritDoc}
     */
    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * 功能说明：通过名称获得Bean对象
     * @param beanName	bean名称
     * @return T	bean对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName)
    {
        checkApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 功能说明：通过类型获得Bean对象级的第一个对象
     * @param classes
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> classes)
    {
        checkApplicationContext();
        Map<?, ?> beanMaps = applicationContext.getBeansOfType(classes);
        if (beanMaps == null || beanMaps.isEmpty())
        {
            return null;
        }
        return (T) beanMaps.values().iterator().next();
    }

    /**
     * 功能说明：检查applicationContext是否为空
     * @return void
     */
    private static void checkApplicationContext()
    {
        if (applicationContext == null)
        {
            throw new IllegalStateException("applicationContext is null.");
        }
    }

}
