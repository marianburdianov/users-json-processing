package com.example.usersjsonprocessing.http;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class HttpResponseInstanceImpl implements HttpResponseInstance {
    private final HttpClientInstance httpClientInstance;
    private final HttpRequestInstance httpRequestInstance;

    @Override
    public HttpResponse getHttpResponseInstance() throws IOException, InterruptedException {
        return httpClientInstance.getHttpClientInstance().send(httpRequestInstance.getHttpRequestInstance(),
                HttpResponse.BodyHandlers.ofString());
    }
}
