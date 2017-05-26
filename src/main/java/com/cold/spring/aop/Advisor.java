package com.cold.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * 通知器对象，返回一个Advice,实现对具体的方法拦截
 * @author faker
 * @date 2017/3/28 20:11.
 */
public interface Advisor {

    Advice getAdvice();
}
