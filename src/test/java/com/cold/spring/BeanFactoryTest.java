package com.cold.spring;

import com.cold.spring.factory.AbstractBeanFactory;
import com.cold.spring.factory.AutowireCapableBeanFactory;
import com.cold.spring.factory.BeanFactory;
import junit.framework.TestCase;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactoryTest extends TestCase {

    public void testGetBean() throws Exception {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cold.spring.HelloService");

        //注入bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        //获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }

}