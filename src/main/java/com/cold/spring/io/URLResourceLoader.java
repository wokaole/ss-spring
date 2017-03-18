package com.cold.spring.io;

import java.net.URL;

/**
 * 定义一个从URL中加载资源获取输入流的loader
 * Created by faker on 2017/3/18.
 */
public class URLResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new URLResource(resource);
    }
}
