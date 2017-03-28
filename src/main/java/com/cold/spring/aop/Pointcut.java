package com.cold.spring.aop;

/**
 * @author liaowenhui
 * @date 2017/3/28 19:42.
 */
public interface Pointcut {

    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}
