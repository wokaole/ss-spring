package com.cold.spring.context;

import com.cold.spring.beans.BeanPostProcessor;
import com.cold.spring.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * 内置一个beanFactory，refresh用于beanFactory的刷新，主要用途是告诉beanFactory使用哪个资源来进行bean的加载
 * 类定义信息，留给子类实现，方便实现来自于不同来源不同资源类型的加载类定义。
 * spring中分的更细，有AbstractXmlApplicationContext、ClassPathXmlApplicationContext
 * @author faker
 * @date 2017/3/23 14:40.
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
