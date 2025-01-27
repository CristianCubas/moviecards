package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.model.dto.MovieDTO;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
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
    void setUp() {
        closeable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void shouldGetAllMovies() {
        List<MovieDTO> movies = new ArrayList<>();
        movies.add(new MovieDTO());
        movies.add(new MovieDTO());

        when(feign.getMoviesList()).thenReturn(movies);

        List<MovieDTO> result = sut.getAllMovies();

        assertEquals(2, result.size());
    }

    @Test
    void shouldGetMovieById() {
        MovieDTO movie = new MovieDTO();
        movie.setId(1);
        movie.setTitle("Sample Movie");

        when(feign.getMovie(anyInt())).thenReturn(movie);

        MovieDTO result = sut.getMovieById(1);

        assertEquals(1, result.getId());
        assertEquals("Sample Movie", result.getTitle());
    }

@Test
    public void testSave() {
        // Arrange
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(1);
        movieDTO.setTitle("Sample Movie");
        movieDTO.setReleaseYear(2022);
        movieDTO.setDuration(120);
        movieDTO.setCountry("USA");
        movieDTO.setDirector("Sample Director");
        movieDTO.setGenre("Action");
        movieDTO.setSinopsis("Sample Sinopsis");
        movieDTO.setActors(List.of());

        // Act
        MovieDTO savedMovieDTO = sut.save(movieDTO);

        // Assert
        assertEquals(movieDTO.getId(), savedMovieDTO.getId());
        assertEquals(movieDTO.getTitle(), savedMovieDTO.getTitle());
        assertEquals(movieDTO.getReleaseYear(), savedMovieDTO.getReleaseYear());
        assertEquals(movieDTO.getDuration(), savedMovieDTO.getDuration());
        assertEquals(movieDTO.getCountry(), savedMovieDTO.getCountry());
        assertEquals(movieDTO.getDirector(), savedMovieDTO.getDirector());
        assertEquals(movieDTO.getGenre(), savedMovieDTO.getGenre());
        assertEquals(movieDTO.getSinopsis(), savedMovieDTO.getSinopsis());
        assertEquals(movieDTO.getActors(), savedMovieDTO.getActors());

        // Verify
        verify(feign).saveMovie(any(MovieDTO.class));
    }

}