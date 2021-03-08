package com.example.practice.jenkins;

import org.springframework.util.MultiValueMap;

import java.util.List;

public class JenkinsParamCollection {
    private final MultiValueMap<String, String> postParams;

    public JenkinsParamCollection(MultiValueMap<String, String> postParams) {
        this.postParams = postParams;
    }

    public void put(String key, String value) {
        postParams.set(key, value);
    }

    public void put(String key, List<String> values) {
        postParams.put(key, values);
    }

    public List<String> get(String key) {
        return postParams.get(key);
    }
}
