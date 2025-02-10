package org.example.util;

import java.io.*;
import java.util.*;

public class CSVReaderUtil {
    public static List<String[]> readCSV(String filePath) {
        List<String[]> csvData = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("Error: File not found - " + filePath);
            return csvData;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                csvData.add(line.split(","));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return csvData;
    }
}
