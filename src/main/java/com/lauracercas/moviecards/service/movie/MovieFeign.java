package com.lauracercas.moviecards.service.movie;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lauracercas.moviecards.model.Movie;

@FeignClient(name = "movieServiceFeign", url = "${feign.client.config.zure.url}")
public interface MovieFeign {

    @PostMapping(path = "/movies")
    public void newMovie(@RequestBody Movie movie);

    @PutMapping(path = "/movies")
    public void saveMovie(@RequestBody Movie movie);

    @GetMapping(path = "/movies")
    public List<Movie> getMoviesList();

    @GetMapping(path = "/movies/{movieId}")
    public Movie getMovie(@PathVariable("movieId")  Integer movieId);

    @GetMapping(path = "/movies/insc/{idActor}/{idMovie}")
    public void registerCard(@PathVariable("idActor")  Integer idActor, @PathVariable("idMovie")  Integer idMovie);

}
