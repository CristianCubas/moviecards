package com.lauracercas.moviecards.service.movie;

import com.lauracercas.moviecards.model.dto.MovieDTO;

import java.util.List;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO save(MovieDTO movie);

    MovieDTO getMovieById(Integer movieId);

    void registerCard(Integer idActor, Integer idMovie);

}
