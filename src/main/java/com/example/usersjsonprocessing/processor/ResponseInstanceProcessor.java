package com.example.usersjsonprocessing.processor;

import com.google.gson.JsonArray;

import java.io.IOException;

public interface ResponseInstanceProcessor {
    JsonArray getJsonBodyAsJsonArray() throws IOException, InterruptedException;
    int getStatusCode() throws IOException, InterruptedException;
}
