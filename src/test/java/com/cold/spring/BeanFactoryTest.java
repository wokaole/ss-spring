package com.cold.spring;

import com.cold.spring.factory.AutowireCapableBeanFactory;
import com.cold.spring.factory.BeanFactory;
import junit.framework.TestCase;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactoryTest extends TestCase {

    public void testGetBean() throws Exception {
        // 1.初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.cold.spring.HelloService");

        //注入属性
        PropertyValue value = new PropertyValue("text", "hello world!");
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(value);
        beanDefinition.setPropertyValues(propertyValues);

        //注入bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        //获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }

}