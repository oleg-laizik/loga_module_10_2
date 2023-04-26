package com.loga.module10.utils;

import java.io.File;

public class FileUtils {
    private FileUtils() {
    }

    public static File loadFile(String filename) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return new File(classloader.getResource(filename).getFile());
    }
}
