package com.cold.spring.aop;

/**
 * 被代理对象
 * @author faker
 * @date 2017/3/27 16:43.
 */
public class TargetSource {

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    private Object target;

    public TargetSource(Object target, Class<?> targetClass,Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
