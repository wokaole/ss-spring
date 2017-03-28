package com.cold.spring.aop;

import com.cold.spring.HelloService;
import com.cold.spring.HelloServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.cold.spring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.cold.spring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloServiceImpl.class.getDeclaredMethod("helloWorld"), HelloServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
