package com.lauracercas.moviecards.service.movie;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lauracercas.moviecards.model.Movie;

@FeignClient(name = "MovieServiceFeign", url = "${feign.client.config.movies-client.url}")
public interface MovieFeign {

    @PostMapping
    public void newMovie(@RequestBody Movie movie);

    @PutMapping
    public void saveMovie(@RequestBody Movie movie);

    @GetMapping
    public List<Movie> getMoviesList();

    @GetMapping(path = "/{movieId}")
    public Movie getMovie(@PathVariable Integer movieId);

    @GetMapping(path = "/insc/{idActor}/{idMovie}")
    public void registerCard(@PathVariable("idActor") Integer idActor, @PathVariable("idMovie") Integer idMovie);

}
