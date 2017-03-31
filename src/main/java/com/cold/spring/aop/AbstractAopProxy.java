package com.cold.spring.aop;

/**
 * @author faker
 * @date 2017/3/31 14:07.
 */
public abstract class AbstractAopProxy implements AopProxy{

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
