package com.example.practice.client;

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

    private final String BUILD = "/build";
    private final String BUILD_WITH_PARAMS = "/buildWithParameters";
    private final String JENKINS_URL_PATTERN = "http://%s/job/%s/%s";

    public JenkinsClient(JenkinsProperties properties, RestClient restClient) {
        this.properties = properties;
        this.restClient = restClient;
        this.endpoint = BUILD;
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

        this.endpoint = BUILD_WITH_PARAMS;
    }

    private void setJenkinsConfig() {
        addHeader();
    }

    private void addHeader() {
        this.restClient.addHeader(this.properties.getUser(), this.properties.getToken());
    }

    private String generateUrl(String jobName) {
        return String.format(JENKINS_URL_PATTERN, this.properties.getUrl(), jobName, this.endpoint);
    }
}
