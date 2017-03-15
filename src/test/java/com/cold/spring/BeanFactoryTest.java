package com.cold.spring;

import junit.framework.TestCase;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactoryTest extends TestCase {

    public void testGetBean() throws Exception {
        BeanDefinition beanDefinition = new BeanDefinition(new HelloService());
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("helloService", beanDefinition);
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }

}