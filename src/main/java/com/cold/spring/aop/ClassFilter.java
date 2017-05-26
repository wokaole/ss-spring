package com.cold.spring.aop;

/**
 * 用于判断是否需要对某个类进行代理（用于筛选要代理的目标对象）
 * @author faker
 * @date 2017/3/28 19:39.
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
