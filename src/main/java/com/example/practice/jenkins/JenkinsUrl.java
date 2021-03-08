package com.example.practice.jenkins;

import lombok.Getter;

@Getter
public enum JenkinsUrl {
    BUILD("/build"),
    BUILD_WITH_PARAMS("/buildWithParameters"),
    JENKINS_URL_PATTERN("http://%s/job/%s/%s");

    private String url;

    JenkinsUrl(String url) {
        this.url = url;
    }
}
