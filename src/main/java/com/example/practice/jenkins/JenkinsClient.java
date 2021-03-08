package com.example.practice.jenkins;

import com.example.practice.client.RestClient;
import com.example.practice.properties.JenkinsProperties;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Map;

public class JenkinsClient {
    private final JenkinsProperties properties;
    private final RestClient restClient;

    private String endpoint;
    private JenkinsParamCollection jenkinsParamCollection;

    public JenkinsClient(JenkinsProperties properties, RestClient restClient) {
        this.properties = properties;
        this.restClient = restClient;
        this.endpoint = JenkinsUrl.BUILD.getUrl();
        this.jenkinsParamCollection = new JenkinsParamCollection(new LinkedMultiValueMap<>());

        setJenkinsConfig();
    }

    public void build(String jobName) {
        String url = generateUrl(jobName);
        this.restClient.post(url, this.jenkinsParamCollection, String.class);
    }

    public void setParameters(Map<String, String> jobParameters) {
        if (jobParameters != null) {
            jobParameters.forEach(this.jenkinsParamCollection::put);
        }

        this.endpoint = JenkinsUrl.BUILD_WITH_PARAMS.getUrl();
    }

    private void setJenkinsConfig() {
        addHeader();
    }

    private void addHeader() {
        this.restClient.addHeader(this.properties.getUser(), this.properties.getToken());
    }

    private String generateUrl(String jobName) {
        return String.format(JenkinsUrl.JENKINS_URL_PATTERN.getUrl(), this.properties.getUrl(), jobName, this.endpoint);
    }
}
