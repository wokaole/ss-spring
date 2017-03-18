package com.cold.spring;

/**
 * Created by faker on 2017/3/15.
 */
public class HelloService {

    private String text;

    public void hello() {
        System.out.println(text);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
