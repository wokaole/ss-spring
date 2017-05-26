package com.cold.spring.aop;

import java.lang.reflect.Method;

/**
 * 判断是否需要对代理类中的某个方法进行拦截（用于在代理对象中对不同的方法进行不同的操作）
 * @author faker
 * @date 2017/3/28 19:40.
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
