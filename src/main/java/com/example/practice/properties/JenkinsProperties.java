package com.example.practice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jenkins")
@Getter @Setter
public class JenkinsProperties {
    private String url;
    private String user;
    private String token;
}
