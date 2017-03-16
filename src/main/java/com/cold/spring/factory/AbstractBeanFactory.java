package com.cold.spring.factory;

import com.cold.spring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by faker on 2017/3/15.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        Object object = doCreateBean(beanDefinition);
        beanDefinition.setBean(object);
        beanMap.put(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName) {
        return beanMap.get(beanName).getBean();
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
