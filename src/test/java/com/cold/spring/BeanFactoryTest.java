package com.cold.spring;

import com.cold.spring.beans.BeanDefinition;
import com.cold.spring.beans.factory.AbstractBeanFactory;
import com.cold.spring.beans.factory.AutowireCapableBeanFactory;
import com.cold.spring.beans.io.URLResourceLoader;
import com.cold.spring.beans.xml.XmlBeanDefinitionReader;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Map;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactoryTest extends TestCase {

    @Test
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new URLResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegister().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloService helloWorldService = (HelloService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new URLResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegister().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloService helloWorldService = (HelloService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }

}