package com.alvin.design.demo.utils;

import java.util.Map;

public class Topic {

    private Map<String, String> options;
    private String key;

    public Topic(Map<String, String> options, String key) {
        this.options = options;
        this.key = key;
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
