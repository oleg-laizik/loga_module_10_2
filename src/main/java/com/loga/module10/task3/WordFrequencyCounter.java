package com.loga.module10.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static com.loga.module10.utils.FileUtils.loadFile;

public class WordFrequencyCounter {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> wordFreq = countWords("task3/words.txt");
        printWordFrequencies(wordFreq);
    }

    public static Map<String, Integer> countWords(String filename) throws FileNotFoundException {
        File file = loadFile(filename);

        Map<String, Integer> wordFreq = new TreeMap<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word.replaceAll("[^a-z]", "");
            if (word.isEmpty()) continue;
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        scanner.close();
        return wordFreq;
    }



    public static void printWordFrequencies(Map<String, Integer> wordFreq) {
        wordFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
