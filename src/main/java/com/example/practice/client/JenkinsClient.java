package com.example.practice.client;

import com.example.practice.enums.JenkinsUrl;
import com.example.practice.properties.JenkinsProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Component
public class JenkinsClient {
    private final JenkinsProperties properties;
    private final RestClient restClient;

    private String endpoint;
    private MultiValueMap<String, String> postParams;

    public JenkinsClient(JenkinsProperties properties, RestClient restClient) {
        this.properties = properties;
        this.restClient = restClient;
        this.endpoint = JenkinsUrl.BUILD.getUrl();
        this.postParams = new LinkedMultiValueMap<>();

        setJenkinsConfig();
    }

    public void build(String jobName) {
        String url = generateUrl(jobName);

        this.restClient.post(url, this.postParams, String.class);
    }

    public void setParameters(Map<String, String> jobParameters) {
        if (jobParameters != null) {
            jobParameters.forEach(this.postParams::set);
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
