package com.cold.spring;

import com.cold.spring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 从资源中解析BeanDefinition，并保存到HashMap registry,规范了BeanDefinitionReader的基本结构
 * Created by faker on 2017/3/18.
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String, BeanDefinition> register;
    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.register = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegister() {
        return register;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
