package com.cold.spring.context;

import com.cold.spring.beans.factory.AbstractBeanFactory;

/**
 * 内置一个beanFactory，refresh用于beanFactory的刷新，主要用途是告诉beanFactory使用哪个资源来进行bean的加载
 * 类定义信息，留给子类实现，方便实现来自于不同来源不同资源类型的加载类定义。
 * @author liaowenhui
 * @date 2017/3/23 14:40.
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }
}
