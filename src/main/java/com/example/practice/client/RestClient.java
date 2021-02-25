package com.example.practice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class RestClient {
    private final RestTemplate restTemplate;

    private final String HEADER_BASIC = "Basic ";
    private final String AUTHORIZATION = "Authorization";

    public <T> ResponseEntity<T> get(final String url, final Class<T> responseType) {
        return restTemplate.getForEntity(url, responseType);
    }

    public <T> ResponseEntity<T> post(final String url, Object request, final Class<T> responseType) {
        return restTemplate.postForEntity(url, request, responseType);
    }

    public void put(final String url, final Object request) {
        restTemplate.put(url, request);
    }

    public void delete(final String url) {
        restTemplate.delete(url);
    }

    public void addHeader(String username, String token) {
        String authHeaderValue = HEADER_BASIC + Base64.getEncoder().encodeToString((username + ":" + token).getBytes(StandardCharsets.UTF_8));

        restTemplate.getInterceptors().add((request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.set(AUTHORIZATION, authHeaderValue);
            return execution.execute(request, body);
        });
    }
}
