package com.icinfo.dataicinfo.biz.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public class ContextHolder implements ApplicationContextAware {
    private static volatile ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
