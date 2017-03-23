package com.cold.spring.context;

import com.cold.spring.beans.factory.BeanFactory;

/**
 * 1.BeanDefinitionReader：实现了Bean的来源、BeanDefinition的装载
 * 要实现一个IOC容器时，首先使用ResourceLoader加载配置文件，转化成一个Resource及获取一个inputStream
 * 接着BeanDefinitionReader读取该文件流，解析其配置，把配置信息转换成BeanDefinition信息，并保存在一个内置的HashMap registry中
 * 2. BeanFactory
 * beanFactory通过读取BeanDefinition信息，实现bean的装配和获取
 *
 * ApplicationContext就是把两者结合起来，继承BeanFactory
 * @author liaowenhui
 * @date 2017/3/23 14:26.
 */
public interface ApplicationContext extends BeanFactory{
}
