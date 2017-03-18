package com.cold.spring.factory;

import com.cold.spring.BeanDefinition;
import com.cold.spring.PropertyValues;

import java.lang.reflect.Field;

/**
 * Created by faker on 2017/3/16.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object instance = getInstance(beanDefinition);
        if (instance != null) {
            applyPropertyValues(instance, beanDefinition.getPropertyValues());
        }
        return instance;
    }

    private void applyPropertyValues(Object bean, PropertyValues propertyValues) {
        propertyValues.getValueList().forEach(propertyValue -> {
            try {
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, propertyValue.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private Object getInstance(BeanDefinition beanDefinition) {
        try {
            Object instance = beanDefinition.getBeanClass().newInstance();
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
