package com.cold.spring.beans.factory;


/**
 * 解决 IoC 容器在 已经获取 Bean 的定义的情况下，如何装配、获取 Bean 实例 的问题
 * 标识一个 IoC 容器。通过 getBean(String) 方法来 获取一个对象
 * Created by faker on 2017/3/16.
 */
public interface BeanFactory {

    Object getBean(String beanName);
}
