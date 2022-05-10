package com.example.usersjsonprocessing.http;

import java.net.http.HttpClient;

public class HttpClientInstanceImpl implements HttpClientInstance {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public HttpClient getHttpClientInstance() {
        return httpClient;
    }
}
