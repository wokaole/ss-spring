package com.cold.spring.aop;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author faker
 * @date 2017/3/31 14:07.
 */
public class Cglib2AopProxy extends AbstractAopProxy {
    public Cglib2AopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
        enhancer.setInterfaces(advised.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        Object object = enhancer.create();
        return object;
    }
}
