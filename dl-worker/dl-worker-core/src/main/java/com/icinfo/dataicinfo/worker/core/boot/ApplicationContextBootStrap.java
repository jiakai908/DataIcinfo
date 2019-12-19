package com.icinfo.dataicinfo.worker.core.boot;

import com.icinfo.dataicinfo.common.errors.DatalinkException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public class ApplicationContextBootStrap {
    private String filePath;
    private ClassPathXmlApplicationContext applicationContext;

    public ApplicationContextBootStrap(String filePath){
        this.filePath = filePath;
    }

    public void boot(){
        try {
            applicationContext = new ClassPathXmlApplicationContext(filePath){
                @Override
                protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
                    super.customizeBeanFactory(beanFactory);
                    beanFactory.setAllowBeanDefinitionOverriding(false);
                }
            };
        }catch (Throwable e){
            throw new DatalinkException("ERROR ## Datalink Factory initial failed.",e);
        }
    }

    public void close(){
        if (applicationContext != null){
            applicationContext.close();
        }
    }
}
