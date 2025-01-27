package com.lauracercas.moviecards.unittest.model.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;

class MovieDTOTest {

    MovieDTO movie = new MovieDTO();

    @Test
    void testDefaultConstructor() {
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
    void testSetGetId() {
        Integer idExample = 1;
        movie.setId(idExample);
        assertEquals(idExample, movie.getId());
    }

    @Test
    void testSetGetTitle() {
        String titleExample = "Sample title";
        movie.setTitle(titleExample);
        assertEquals(titleExample, movie.getTitle());
    }

    @Test
    void testSetGetReleaseYear() {
        Integer releaseYearExample = 2000;
        movie.setReleaseYear(releaseYearExample);
        assertEquals(releaseYearExample,movie.getReleaseYear());
    }

    @Test
    void testSetGetDuration() {
        Integer durationExample = 100;
        movie.setDuration(durationExample);
        assertEquals(durationExample,movie.getDuration());
    }    

    @Test
    void testSetGetCountry() {
        String countryExample = "Sample country";
        movie.setCountry(countryExample);
        assertEquals(countryExample,movie.getCountry());
    }

    @Test
    void testSetGetDirector() {
        String directorExample = "Sample director";
        movie.setDirector(directorExample);
        assertEquals(directorExample,movie.getDirector());
    }

    @Test
    void testSetGetGenre() {
        String genreExample = "Sample genre";
        movie.setGenre(genreExample);
        assertEquals(genreExample,movie.getGenre());
    }

    @Test
    void testSetGetSinopsis() {
        String sinopsisExample = "Sample sinopsis";
        movie.setSinopsis(sinopsisExample);
        assertEquals(sinopsisExample,movie.getSinopsis());
    }

    @Test
    void testSetGetActors() {
        List<ActorDTO> actorsExample = new ArrayList<>();
        movie.setActors(actorsExample);
        assertEquals(actorsExample, movie.getActors());
    }

}