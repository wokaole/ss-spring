package com.cold.spring.aop;

import java.lang.reflect.Method;

/**
 * @author faker
 * @date 2017/3/28 19:40.
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}
