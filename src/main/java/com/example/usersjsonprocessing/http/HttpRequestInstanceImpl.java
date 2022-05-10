package com.example.usersjsonprocessing.http;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestInstanceImpl implements HttpRequestInstance {
    private final String url = "https://jsonplaceholder.typicode.com/users";

    private HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

    @Override
    public HttpRequest getHttpRequestInstance() {
        return httpRequest;
    }
}
