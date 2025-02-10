package org.example.model;

import java.util.List;

public class Movie {
    private String movieId;
    private String title;
    private String genre;
    private double rating;
    private int releaseYear;
    private String directorId;
    private List<String> actorIds;

    public Movie(String movieId, String title, String genre, double rating, int releaseYear, String directorId, List<String> actorIds) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.directorId = directorId;
        this.actorIds = actorIds;
    }

    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }
    public String getDirectorId() { return directorId; }
    public List<String> getActorIds() { return actorIds; }

    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
