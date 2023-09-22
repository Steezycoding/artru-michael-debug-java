package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     *
     * @param symptoms a pre-sorted listing of each symptom and its occurrences
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter fileWriter = new FileWriter(this.filepath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry: symptoms.entrySet()) {
                writer.write(String.format("%s: %d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
