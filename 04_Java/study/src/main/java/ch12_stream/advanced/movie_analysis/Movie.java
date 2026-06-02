package main.java.ch12_stream.advanced.movie_analysis;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;
}
