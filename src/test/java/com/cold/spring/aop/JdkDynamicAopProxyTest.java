package com.cold.spring.aop;

import com.cold.spring.HelloService;
import com.cold.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author faker
 * @date 2017/3/27 17:44.
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void invoke() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.helloWorld();

        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport support = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloService, HelloService.class);
        support.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor interceptor = new TimerInterceptor();
        support.setMethodInterceptor(interceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(support);
        HelloService proxyService = (HelloService) proxy.getProxy();

        proxyService.helloWorld();
    }

}