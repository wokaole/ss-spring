package com.cold.spring.factory;

import com.cold.spring.BeanDefinition;

/**
 * Created by faker on 2017/3/16.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object instance = beanDefinition.getBeanClass().newInstance();
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
