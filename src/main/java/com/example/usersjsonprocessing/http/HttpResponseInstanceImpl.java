package com.example.usersjsonprocessing.http;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;

@Component
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
