package com.cold.spring.aop;

/**
 * @author liaowenhui
 * @date 2017/3/28 20:12.
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
