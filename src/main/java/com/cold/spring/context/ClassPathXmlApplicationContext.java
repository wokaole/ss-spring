package com.cold.spring.context;

import com.cold.spring.beans.BeanDefinition;
import com.cold.spring.beans.factory.AbstractBeanFactory;
import com.cold.spring.beans.factory.AutowireCapableBeanFactory;
import com.cold.spring.beans.io.URLResourceLoader;
import com.cold.spring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *从xml加载配置进行bean设置的具体实现类
 * 内部通过 XmlBeanDefinitionReader 解析URLResourceLoader读取到的resource，
 * 获取beanDefinition信息，并保存到BeanFactory中
 * @author faker
 * @date 2017/3/23 14:51.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new URLResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegister().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
