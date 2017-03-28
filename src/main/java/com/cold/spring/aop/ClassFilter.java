package com.cold.spring.aop;

/**
 * @author liaowenhui
 * @date 2017/3/28 19:39.
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
