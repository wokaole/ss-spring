package com.cold.spring.beans.factory;

import com.cold.spring.beans.BeanDefinition;
import com.cold.spring.beans.BeanReference;
import com.cold.spring.beans.PropertyValues;

import java.lang.reflect.Field;

/**
 * 自动装配的 BeanFactory 实现了doCreateBean方法，该方法分3步：
 * 1，通过 BeanDefinition 中保存的类信息实例化一个对象；
 * 2，把对象保存在 BeanDefinition 中，以备下次获取；
 * 3，为其装配属性。装配属性时，通过 BeanDefinition 中维护的 PropertyValues 集合类，把 String - Value 键值对注入到 Bean 的属性中去。
 * 如果 Value 的类型是 BeanReference 则说明其是一个引用（对应于 XML 中的 ref），通过 getBean 对其进行获取，然后注入到属性中。
 *
 * Created by faker on 2017/3/16.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object instance = getInstance(beanDefinition);
        if (instance != null) {
            beanDefinition.setBean(instance);
            applyPropertyValues(instance, beanDefinition.getPropertyValues());
        }
        return instance;
    }

    private void applyPropertyValues(Object bean, PropertyValues propertyValues) {
        propertyValues.getValueList().forEach(propertyValue -> {
            try {
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }
                field.set(bean, value);
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
