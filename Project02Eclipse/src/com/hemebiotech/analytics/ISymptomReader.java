package com.hemebiotech.analytics;

import java.util.List;

/**
 * A simple reader class that uses BufferedReader to read the stream of
 * text-type file.
 *
 */
public interface ISymptomReader {
	/**
	 * Get all symptoms from a text file and stores them in a list.
	 * 
	 * @return An unsorted list of symptoms with many potential duplications.
	 */
	List<String> getSymptoms ();
}
