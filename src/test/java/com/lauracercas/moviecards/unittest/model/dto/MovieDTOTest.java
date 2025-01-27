package com.lauracercas.moviecards.unittest.model.dto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;

public class MovieDTOTest {

    @Test
    public void testDefaultConstructor() {
        MovieDTO movie = new MovieDTO();
        assertNull(movie.getId());
        assertNull(movie.getTitle());
        assertNull(movie.getReleaseYear());
        assertNull(movie.getDuration());
        assertNull(movie.getCountry());
        assertNull(movie.getDirector());
        assertNull(movie.getGenre());
        assertNull(movie.getSinopsis());
        assertNull(movie.getActors());
    }

    @Test
    public void testGettersAndSetters() {
        MovieDTO movie = new MovieDTO();
        Integer id = 1;
        String title = "Test Movie";
        Integer releaseYear = 2022;
        Integer duration = 120;
        String country = "USA";
        String director = "Test Director";
        String genre = "Action";
        String sinopsis = "Test Sinopsis";
        List<ActorDTO> actors = List.of(new ActorDTO());

        movie.setId(id);
        movie.setTitle(title);
        movie.setReleaseYear(releaseYear);
        movie.setDuration(duration);
        movie.setCountry(country);
        movie.setDirector(director);
        movie.setGenre(genre);
        movie.setSinopsis(sinopsis);
        movie.setActors(actors);

        assertEquals(id, movie.getId());
        assertEquals(title, movie.getTitle());
        assertEquals(releaseYear, movie.getReleaseYear());
        assertEquals(duration, movie.getDuration());
        assertEquals(country, movie.getCountry());
        assertEquals(director, movie.getDirector());
        assertEquals(genre, movie.getGenre());
        assertEquals(sinopsis, movie.getSinopsis());
        assertEquals(actors, movie.getActors());
    }

}