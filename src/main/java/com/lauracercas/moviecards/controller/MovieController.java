package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;
import com.lauracercas.moviecards.service.movie.MovieService;
import com.lauracercas.moviecards.util.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
@Controller
public class MovieController {

    private static final String TITLE_STRING = "title";
    private static final String MOVIE_STRING = "movie";
    private static final String MOVIES_FORM_STRING = "movies/form";

    @Autowired
    private MovieService movieService;

    @GetMapping("movies")
    public String getMoviesList(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/list";
    }

    @GetMapping("movies/new")
    public String newMovie(Model model) {
        model.addAttribute(MOVIE_STRING, new MovieDTO());
        model.addAttribute(TITLE_STRING, Messages.NEW_MOVIE_TITLE);
        return MOVIES_FORM_STRING;
    }

    @PostMapping("saveMovie")
    public String saveMovie(@ModelAttribute MovieDTO movie, BindingResult result, Model model) {

        if (!result.hasErrors()) {
            MovieDTO movieSaved = movieService.save(movie);
            if (movieSaved.getId() != null) {
                model.addAttribute("message", Messages.UPDATED_MOVIE_SUCCESS);
            } else {
                model.addAttribute("message", Messages.SAVED_MOVIE_SUCCESS);
            }
            model.addAttribute(MOVIE_STRING, movieSaved);
            model.addAttribute(TITLE_STRING, Messages.EDIT_MOVIE_TITLE);
        }

        return MOVIES_FORM_STRING;
    }

    @GetMapping("editMovie/{movieId}")
    public String editMovie(@PathVariable Integer movieId, Model model) {
        MovieDTO movie = movieService.getMovieById(movieId);
        List<ActorDTO> actors = movie.getActors();
        model.addAttribute(MOVIE_STRING, movie);
        model.addAttribute("actors", actors);

        model.addAttribute(TITLE_STRING, Messages.EDIT_MOVIE_TITLE);

        return MOVIES_FORM_STRING;
    }

}
