package com.cold.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author liaowenhui
 * @date 2017/3/28 20:11.
 */
public interface Advisor {

    Advice getAdvice();
}
