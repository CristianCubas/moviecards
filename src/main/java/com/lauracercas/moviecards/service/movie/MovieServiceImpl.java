package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieFeign feign;

    @Override
    public List<Movie> getAllMovies() {
        return feign.getMoviesList();
    }

    @Override
    public Movie save(Movie movie) {
        if (movie.getId() != null && movie.getId() > 0) {
            feign.saveMovie(movie);
        } else {
            feign.newMovie(movie);
        }
        return movie;
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        return feign.getMovie(movieId);
    }
}
