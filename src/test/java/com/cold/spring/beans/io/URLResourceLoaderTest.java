package com.cold.spring.beans.io;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by faker on 2017/3/18.
 */
public class URLResourceLoaderTest {

    @Test
    public void testGetResource() throws Exception {
        URLResourceLoader loader = new URLResourceLoader();
        Resource resource = loader.getResource("bean.xml");
        Assert.assertNotNull(resource.getInputStream());
    }

}