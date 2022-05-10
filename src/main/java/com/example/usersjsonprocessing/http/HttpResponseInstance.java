package com.example.usersjsonprocessing.http;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface HttpResponseInstance {
    HttpResponse<String> getHttpResponseInstance() throws IOException, InterruptedException;
}
