package com.cold.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 几个概念：
 * 1. Proxy:对目标进行代理的代理对象，提供生成动态代理的功能
 * 2. InvocationHandler：实现代理对象的方法调用，每一个Proxy有一个InvocationHandler，当目标对象方法被调用时，都会转发到 该对象的invoke方法
 * 3. MethodInterceptor：方法拦截器，用于在被调用方法之前或之后添加而外的处理（invoke 方法执行）
 * 3. MethodInvocation：方法连接点，用来表示能够被Interceptor（MethodInterceptor）拦截的切点
 * @author faker
 * @date 2017/3/27 15:33.
 */
public class JdkDynamicAopProxy extends AbstractAopProxy implements InvocationHandler{


    public JdkDynamicAopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        if (advised.getMethodMatcher() != null
                && advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),
                    method, args));
        } else {
            return method.invoke(advised.getTargetSource().getTarget(), args);
        }
    }
}
