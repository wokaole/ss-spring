package com.cold.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanMap.put(beanName, beanDefinition);
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName).getBean();
    }

}
