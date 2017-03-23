package com.cold.spring.beans;

/**
 * Created by faker on 2017/3/19.
 */
public class BeanReference {

    private String name;
    private Object object;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
