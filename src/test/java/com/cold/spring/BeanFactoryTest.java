package com.cold.spring;

import com.cold.spring.factory.AutowireCapableBeanFactory;
import com.cold.spring.factory.BeanFactory;
import com.cold.spring.io.URLResourceLoader;
import com.cold.spring.xml.XmlBeanDefinitionReader;
import junit.framework.TestCase;

import java.util.Map;

/**
 * Created by faker on 2017/3/15.
 */
public class BeanFactoryTest extends TestCase {

    public void testGetBean() throws Exception {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new URLResourceLoader());
        reader.loadBeanDefinitions("bean.xml");

        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        for (Map.Entry<String, BeanDefinition> entry: reader.getRegister().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        //获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }

}