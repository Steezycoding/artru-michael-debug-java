package com.hemebiotech.analytics;

import java.util.Map;

/**
 * A simple writer class that uses BufferedWriter to write the stream of
 * text-type file.
 *
 */
public interface ISymptomWriter {
    /**
     * Writes an output file with each symptom and its occurrence.
     *
     * @param symptoms A pre-sorted listing of each unique symptom and its occurrences.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
