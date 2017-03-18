package com.cold.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faker on 2017/3/18.
 */
public class PropertyValues {

    private final List<PropertyValue> valueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue value) {
        //todo 去重操作？
        this.valueList.add(value);
    }

    public List<PropertyValue> getValueList() {
        return valueList;
    }
}
