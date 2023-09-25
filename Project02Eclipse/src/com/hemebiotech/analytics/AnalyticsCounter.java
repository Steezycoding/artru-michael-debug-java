package com.hemebiotech.analytics;

import java.util.*;

/**
 * Process a list of symptoms (input) and write out the processed list
 * in a human-readable file (output).
 *
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Instantiates:
	 * - a reader, to read symptoms from a file
	 * - a writer, to write out the processed list of symptoms (list of sorted, counted & unique symptoms)
	 *
	 * @param reader ISymptomReader interface
	 * @param writer ISymptomWriter interface
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Gets symptoms from input file (ISymptomReader) and stores them in a list.
	 *
	 * @return List of all symptoms (including duplication for each occurrence)
	 */
	public List<String> getSymptoms() {

		return this.reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom from a list and returns a Map
	 * of unique symptoms and their occurrences.
	 *
	 * @param symptoms The list of symptoms
	 * @return Key-value paired listing of symptoms and their occurrence
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> symptomsOccurrences = new HashMap<String, Integer>();

		for (String symptom : symptoms) {
			if (symptomsOccurrences.containsKey(symptom)) continue;

			symptomsOccurrences.put(symptom, Collections.frequency(symptoms, symptom));
		}

		return symptomsOccurrences;
	}

	/**
	 * Sorts (alphabetically) a non-sorted map of symptoms.
	 *
	 * @param symptoms A non-sorted map of symptoms and their occurrence.
	 * @return Key-value paired and sorted (alphabetically) listing of symptoms and their occurrence. Key is the symptom name, value is the occurrence.
	 *
	 */
	public SortedMap<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<String, Integer>(symptoms);
	}

	/**
	 * Outputs the list of symptoms and their occurrences in a text-type file.
	 *
	 * @param symptoms A map of symptoms and their occurrence.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}
