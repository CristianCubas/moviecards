package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieFeign;
import com.lauracercas.moviecards.service.movie.MovieServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
class MovieServiceImplTest {
    
    @Mock
    private MovieFeign feign;
    
     @InjectMocks
    private MovieServiceImpl sut = new MovieServiceImpl();

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void shouldGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        movies.add(new Movie());

        when(feign.getMoviesList()).thenReturn(movies);

        List<Movie> result = sut.getAllMovies();

        assertEquals(2, result.size());
    }

    @Test
    public void shouldGetMovieById() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Sample Movie");

        when(feign.getMovie(anyInt())).thenReturn(movie);

        Movie result = sut.getMovieById(1);

        assertEquals(1, result.getId());
        assertEquals("Sample Movie", result.getTitle());
    }

}