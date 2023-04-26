package com.loga.module10.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.loga.module10.utils.FileUtils.loadFile;

public class PhoneNumbersValidator {

    private static final String PHONE_REGEX = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";

    public static void main(String[] args) {
        String fileName = "task1/file.txt";
        File file = loadFile(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Pattern pattern = Pattern.compile(PHONE_REGEX);

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
