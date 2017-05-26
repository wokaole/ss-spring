package com.cold.spring.aop;

/**
 * 切点通知器，用于提供 对哪个对象的哪个方法进行什么样的拦截 的具体内容
 * @author faker
 * @date 2017/3/28 20:12.
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
