package com.cold.spring.aop;

import com.cold.spring.beans.factory.BeanFactory;

/**
 * @author faker
 * @date 2017/3/30 14:26.
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory);
}
