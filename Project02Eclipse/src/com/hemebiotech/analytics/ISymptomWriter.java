package com.hemebiotech.analytics;

import java.util.Map;

/**
 * A writer instance used to write out symptoms on a local file
 *
 */
public interface ISymptomWriter {
    /**
     * Writes an output file with each symptom and its occurrence
     *
     * @param symptoms a pre-sorted listing of each symptom and its occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
