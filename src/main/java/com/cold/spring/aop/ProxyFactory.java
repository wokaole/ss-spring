package com.cold.spring.aop;

/**
 * @author faker
 * @date 2017/3/31 14:05.
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy{
    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    protected final AopProxy createAopProxy() {
        return new Cglib2AopProxy(this);
    }
}
