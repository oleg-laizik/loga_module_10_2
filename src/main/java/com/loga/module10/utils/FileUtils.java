package com.loga.module10.utils;

import java.io.File;

public class FileUtils {
    private FileUtils() {
    }

    public static File loadFile(String filename) {
        try {
            return new File(
                    Thread.currentThread().getContextClassLoader().getResource(filename).toURI());
        } catch (Exception e) {
            System.out.println("Can't load file: " + filename);
            throw new RuntimeException();
        }
    }
}