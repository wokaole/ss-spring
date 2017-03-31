package com.cold.spring.aop;

import com.cold.spring.HelloService;
import com.cold.spring.HelloServiceImpl;
import com.cold.spring.context.ApplicationContext;
import com.cold.spring.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author faker
 */
public class Cglib2AopProxyTest {

	@Test
	public void testInterceptor() throws Exception {
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		HelloService helloWorldService = (HelloService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService, HelloServiceImpl.class,
				HelloService.class);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
		HelloService helloWorldServiceProxy = (HelloService) cglib2AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloWorld();

	}
}
