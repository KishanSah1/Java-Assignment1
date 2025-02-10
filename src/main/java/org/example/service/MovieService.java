package org.example.service;

import org.example.model.Movie;
import java.util.*;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovieById(String movieId) {
        return movies.stream().filter(m -> m.getMovieId().equals(movieId)).findFirst().orElse(null);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream().filter(m -> m.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }

    public List<Movie> getTopRatedMovies() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
