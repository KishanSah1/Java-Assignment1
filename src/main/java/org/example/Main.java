package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String actor = "src/main/resources/actors_large.csv";
        String director = "src/main/resources/directors_large.csv";
        String movie = "src/main/resources/movies_large.csv";

        List<String[]> actorData = readCSV(actor);
        List<String[]> directorsData = readCSV(director);
        List<String[]> moviesData = readCSV(movie);

        String[] header = moviesData.remove(0);

//        for (String[] row : actorData) {
//            System.out.println(Arrays.toString(row));
//        }

    }



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
                String[] values = line.split(",");

                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }

                csvData.add(values);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return csvData;
    }
}
