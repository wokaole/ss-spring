package com.cold.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author liaowenhui
 * @date 2017/3/27 17:44.
 */
public class TimerInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.nanoTime();
        System.out.println("invocation of method " + invocation.getMethod().getName() + " start : ");
        Object result = invocation.proceed();
        System.out.println("invocation of method "+ invocation.getMethod().getName() + " end , cost:" + (System.nanoTime() - start));
        return result;
    }
}
