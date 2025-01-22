package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieFeign movieFeign;

    @Override
    public List<Movie> getAllMovies() {
        return movieFeign.getMoviesList();
    }

    @Override
    public Movie save(Movie movie) {
        if (movie.getId() != null && movie.getId() > 0) {
            movieFeign.saveMovie(movie);
        } else {
            movieFeign.newMovie(movie);
        }
        return movie;
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieFeign.getMovie(movieId);
    }
}
