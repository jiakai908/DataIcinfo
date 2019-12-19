package com.icinfo.dataicinfo.biz.utils;

import java.util.Map;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public class DataLinkFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getObject(String name){
        return (T) ContextHolder.getApplicationContext().getBean(name);
    }
    public static <T> T getObject(Class<? extends T> classz) {
        return (T) ContextHolder.getApplicationContext().getBean(classz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return ContextHolder.getApplicationContext().getBeansOfType(clazz);
    }
}
