package com.cold.spring.factory;

import com.cold.spring.BeanDefinition;

/**
 * Created by faker on 2017/3/16.
 */
public interface BeanFactory {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    Object getBean(String beanName);
}
