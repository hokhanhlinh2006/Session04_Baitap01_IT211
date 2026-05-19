package com.example.baitap01_ss04.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new Movie("M001", "Inception", "Sci-Fi", 8.8));
        movies.add(new Movie("M002", "Parasite", "Drama", 8.6));
    }

    static class Movie {

        private String movieId;
        private String title;
        private String genre;
        private double rating;

        // Constructor rỗng cho JSON
        public Movie() {
        }

        public Movie(String movieId, String title, String genre, double rating) {
            this.movieId = movieId;
            this.title = title;
            this.genre = genre;
            this.rating = rating;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movies;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {

        movies.add(movie);

        return movie;
    }
}