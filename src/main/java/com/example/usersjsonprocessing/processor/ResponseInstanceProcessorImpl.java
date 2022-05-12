package com.example.usersjsonprocessing.processor;

import com.example.usersjsonprocessing.http.HttpResponseInstance;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ResponseInstanceProcessorImpl implements ResponseInstanceProcessor {
    private final HttpResponseInstance httpResponseInstance;

    @Override
    public JsonArray getJsonBodyAsJsonArray() throws IOException, InterruptedException {
        JsonParser jsonParser = new JsonParser();
        Object jsonObject = jsonParser.parse(httpResponseInstance.getHttpResponseInstance().body());

        return (JsonArray) jsonObject;
    }

    @Override
    public int getStatusCode() throws IOException, InterruptedException {
        return httpResponseInstance.getHttpResponseInstance().statusCode();
    }

    @Override
    public int getCountOfObjectsFromRequestedJson() throws IOException, InterruptedException {
        return getJsonBodyAsJsonArray().size();
    }
}
