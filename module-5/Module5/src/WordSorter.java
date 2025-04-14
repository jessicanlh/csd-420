//Jessica Long-Heinicke 4.13.25 Module 5 

import java.io.*;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        // Run tests first
        testWordProcessor();

        // Process the main file
        String filename = "collection_of_words.txt";
        List<String> words = readWordsFromFile(filename);

        if (!words.isEmpty()) {
            List<String> uniqueWords = getUniqueWords(words);
            List<String> ascending = sortAscending(uniqueWords);
            List<String> descending = sortDescending(uniqueWords);

            displayResults("Ascending order:", ascending);
            displayResults("Descending order:", descending);
        }
    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    public static List<String> getUniqueWords(List<String> words) {
        Set<String> uniqueSet = new HashSet<>(words);
        return new ArrayList<>(uniqueSet);
    }

    public static List<String> sortAscending(List<String> words) {
        List<String> sorted = new ArrayList<>(words);
        Collections.sort(sorted);
        return sorted;
    }

    public static List<String> sortDescending(List<String> words) {
        List<String> sorted = new ArrayList<>(words);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted;
    }

    public static void displayResults(String title, List<String> words) {
        System.out.println("\n" + title);
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void testWordProcessor() {
        // Create test file
        String testFilename = "test_words.txt";
        createTestFile(testFilename, "apple banana apple cherry banana date cherry apple");

        // Test the functionality
        List<String> words = readWordsFromFile(testFilename);
        List<String> uniqueWords = getUniqueWords(words);
        List<String> ascending = sortAscending(uniqueWords);
        List<String> descending = sortDescending(uniqueWords);

        // Expected results
        List<String> expectedAscending = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> expectedDescending = Arrays.asList("date", "cherry", "banana", "apple");

        // Verify results
        if (!ascending.equals(expectedAscending)) {
            System.err.println("Test failed: Ascending order mismatch.");
            System.err.println("Expected: " + expectedAscending);
            System.err.println("Got: " + ascending);
            System.exit(1);
        }

        if (!descending.equals(expectedDescending)) {
            System.err.println("Test failed: Descending order mismatch.");
            System.err.println("Expected: " + expectedDescending);
            System.err.println("Got: " + descending);
            System.exit(1);
        }

        // Clean up
        deleteTestFile(testFilename);
        System.out.println("All tests passed successfully!");
    }

    private static void createTestFile(String filename, String content) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(content);
        } catch (FileNotFoundException e) {
            System.err.println("Error creating test file: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void deleteTestFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}