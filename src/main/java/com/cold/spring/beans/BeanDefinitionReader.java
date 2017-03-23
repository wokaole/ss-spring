package com.cold.spring.beans;

/**
 * 解析 BeanDefinition 的接口。通过 loadBeanDefinitions(String) 来从一个地址加载类定义。
 * Created by faker on 2017/3/18.
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location);
}
