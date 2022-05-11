package com.example.usersjsonprocessing.http;

import org.springframework.stereotype.Component;

import java.net.http.HttpClient;

@Component
public class HttpClientInstanceImpl implements HttpClientInstance {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public HttpClient getHttpClientInstance() {
        return httpClient;
    }
}
