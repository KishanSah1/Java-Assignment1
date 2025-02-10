package org.example;

import org.example.model.*;
import org.example.service.MovieService;
import org.example.util.CSVReaderUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String actorFile = "src/main/resources/actors_large.csv";
        String directorFile = "src/main/resources/directors_large.csv";
        String movieFile = "src/main/resources/movies_large.csv";

        List<String[]> actorData = CSVReaderUtil.readCSV(actorFile);
        List<String[]> directorData = CSVReaderUtil.readCSV(directorFile);
        List<String[]> movieData = CSVReaderUtil.readCSV(movieFile);

        List<Movie> movies = movieData.stream().skip(1).map(row -> new Movie(
                row[0], row[1], row[2], Double.parseDouble(row[3]), Integer.parseInt(row[4]), row[5],
                Arrays.asList(row[6].split(";")))).collect(Collectors.toList());

        MovieService movieService = new MovieService(movies);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Get Movie Information\n2. Get Top 10 Rated Movies\n3. Get Movies by Genre\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie ID: ");
                    String movieId = scanner.nextLine();
                    System.out.println(movieService.getMovieById(movieId));
                    break;
                case 2:
                    movieService.getTopRatedMovies().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    movieService.getMoviesByGenre(genre).forEach(System.out::println);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
