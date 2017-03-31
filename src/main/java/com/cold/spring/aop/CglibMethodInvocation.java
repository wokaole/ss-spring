package com.cold.spring.aop;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author faker
 * @date 2017/3/31 14:16.
 */
public class CglibMethodInvocation extends ReflectiveMethodInvocation{
    private final MethodProxy methodProxy;

    public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
        super(target, method, args);
        this.methodProxy = methodProxy;
    }

    @Override
    public Object proceed() throws Throwable {
        return this.methodProxy.invoke(this.target, this.getArguments());
    }
}
