package com.cold.spring.context;


import com.cold.spring.HelloServiceImpl;
import org.junit.Test;

/**
 * @author liaowenhui
 * @date 2017/3/23 15:13.
 */
public class ClassPathXmlApplicationContextTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        HelloServiceImpl helloService = (HelloServiceImpl) applicationContext.getBean("helloService");
        helloService.helloWorld();
    }

}