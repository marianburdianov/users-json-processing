package com.example.usersjsonprocessing.filewriter;

import java.io.IOException;

public interface FileWriterDecl {
    void writeToFile(int count, int statusCode) throws IOException;
}
