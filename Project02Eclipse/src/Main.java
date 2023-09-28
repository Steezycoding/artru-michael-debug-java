import com.hemebiotech.analytics.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputPath = "Project02Eclipse/symptoms.txt";
        String outputPath = "Project02Eclipse/result.out";

        ISymptomReader reader = new ReadSymptomDataFromFile(inputPath);
        ISymptomWriter writer = new WriteSymptomDataToFile(outputPath);
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsAndOccurrences = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptomsAndOccurrences = analyticsCounter.sortSymptoms(symptomsAndOccurrences);
        analyticsCounter.writeSymptoms(sortedSymptomsAndOccurrences);
    }
}