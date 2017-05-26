package com.cold.spring.aop;

/**
 * 切点对象
 * 包含一个ClassFilter和MethodMatcher
 * ClassFilter：用于判断是否需要对某个类进行代理（用于筛选要代理的目标对象）
 * MethodMatcher：判断是否需要对代理类中的某个方法进行拦截（用于在代理对象中对不同的方法进行不同的操作）
 * @author faker
 * @date 2017/3/28 19:42.
 */
public interface Pointcut {

    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
}
