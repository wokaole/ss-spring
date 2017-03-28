package com.cold.spring.beans;

/**
 * @author liaowenhui
 * @date 2017/3/28 20:16.
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;

}
