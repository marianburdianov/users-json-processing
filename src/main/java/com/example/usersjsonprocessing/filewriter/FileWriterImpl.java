package com.example.usersjsonprocessing.filewriter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class FileWriterImpl implements FileWriterDecl {

    @Override
    public void writeToFile(int count, int statusCode) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("statusCode", statusCode);
        map.put("count", count);

        File file = new File("statistics.txt");

        BufferedWriter bufferedWriter = null;

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, Integer> entry : map.entrySet()) {

                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());

                bufferedWriter.newLine();
            }

            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
    }
}
