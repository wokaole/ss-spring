package com.cold.spring.aop;

import org.aopalliance.aop.Advice;

/**
 * @author liaowenhui
 * @date 2017/3/28 20:13.
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor{

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    private Advice advice;

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
