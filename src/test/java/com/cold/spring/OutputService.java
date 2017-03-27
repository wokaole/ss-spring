package com.cold.spring;

import org.junit.Assert;

/**
 * Created by faker on 2017/3/19.
 */
public class OutputService {

    private HelloServiceImpl helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloServiceImpl helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
