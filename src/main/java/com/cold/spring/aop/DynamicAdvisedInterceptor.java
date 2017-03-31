package com.cold.spring.aop;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author faker
 * @date 2017/3/31 14:14.
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor {
    private AdvisedSupport advised;
    private org.aopalliance.intercept.MethodInterceptor delegateMethodInterceptor;

    public DynamicAdvisedInterceptor(AdvisedSupport advised) {
        this.advised = advised;
        this.delegateMethodInterceptor = advised.getMethodInterceptor();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (advised.getMethodMatcher() == null
                || advised.getMethodMatcher().matches(method, advised.getTargetSource().getTargetClass())) {
            return delegateMethodInterceptor.invoke(new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, proxy));
        }
        return new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, proxy).proceed();
    }
}
