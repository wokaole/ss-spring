package com.cold.spring.factory;

import com.cold.spring.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 规范了 IoC 容器的基本结构，把生成 Bean 的具体实现方式留给子类实现。
 * Created by faker on 2017/3/15.
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanMap = new ConcurrentHashMap<>();
    private final List<String> beanDefinitionNames = new ArrayList<String>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanMap.get(beanName);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + beanName + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
