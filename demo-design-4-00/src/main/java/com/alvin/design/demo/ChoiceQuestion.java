package com.alvin.design.demo;

import java.util.HashMap;
import java.util.Map;

public class ChoiceQuestion {

    private String name;  //题目
    private Map<String,String> options; //选项
    private String key;  //答案

    public ChoiceQuestion(String name, Map<String, String> options, String key) {
        this.name = name;
        this.options = options;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
