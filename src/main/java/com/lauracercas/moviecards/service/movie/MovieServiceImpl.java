package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.dto.MovieDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieFeign movieFeign;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieFeign.getMoviesList();
    }

    @Override
    public MovieDTO save(MovieDTO movie) {
        if (movie.getId() != null && movie.getId() > 0) {
            movieFeign.saveMovie(movie);
        } else {
            movieFeign.newMovie(movie);
        }
        return movie;
    }

    @Override
    public MovieDTO getMovieById(Integer movieId) {
        return movieFeign.getMovie(movieId);
    }

    @Override
    public void registerCard(Integer idActor, Integer idMovie) {
        movieFeign.registerCard(idActor,idMovie);
    }
}
