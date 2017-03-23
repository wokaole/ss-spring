package com.cold.spring.beans.io;

/**
 * Created by faker on 2017/3/18.
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
