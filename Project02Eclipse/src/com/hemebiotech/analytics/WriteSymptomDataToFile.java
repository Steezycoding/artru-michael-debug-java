package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

/**
 * A simple writer class that uses BufferedWriter to write the stream of
 * text-type file.
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * Stores the output file path (file name) for further use.
     *
     * @param filepath The absolute or relative output path to write a text-type file.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes an output file with each symptom and its occurrence.
     *
     * @param symptoms A pre-sorted listing of each unique symptom and its occurrences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            FileWriter fileWriter = new FileWriter(this.filepath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry: symptoms.entrySet()) {
                writer.write(String.format("%s:%d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
