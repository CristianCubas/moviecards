package com.lauracercas.moviecards.unittest.model.dto;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;

public class ActorDTOTest {

    @Test
    public void testDefaultConstructor() {
        ActorDTO actor = new ActorDTO();
        assertNull(actor.getId());
        assertNull(actor.getName());
        assertNull(actor.getBirthDate());
        assertNull(actor.getCountry());
        assertNull(actor.getDeadDate());
        assertNull(actor.getMovies());
    }

    @Test
    public void testGettersAndSetters() {
        ActorDTO actor = new ActorDTO();
        Integer id = 1;
        String name = "John Doe";
        Date birthDate = new Date();
        String country = "USA";
        Date deadDate = new Date();
        List<MovieDTO> movies = List.of(new MovieDTO());

        actor.setId(id);
        actor.setName(name);
        actor.setBirthDate(birthDate);
        actor.setCountry(country);
        actor.setDeadDate(deadDate);
        actor.setMovies(movies);

        assertEquals(id, actor.getId());
        assertEquals(name, actor.getName());
        assertEquals(birthDate, actor.getBirthDate());
        assertEquals(country, actor.getCountry());
        assertEquals(deadDate, actor.getDeadDate());
        assertEquals(movies, actor.getMovies());
    }

}