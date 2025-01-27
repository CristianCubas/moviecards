package com.lauracercas.moviecards.unittest.model.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;

class ActorDTOTest {

    ActorDTO actor = new ActorDTO();

    @Test
    void testDefaultConstructor() {
        ActorDTO actor = new ActorDTO();
        assertNull(actor.getId());
        assertNull(actor.getName());
        assertNull(actor.getBirthDate());
        assertNull(actor.getCountry());
        assertNull(actor.getDeadDate());
        assertNull(actor.getMovies());
    }

    @Test
    void testSetGetId() {
        Integer idExample = 1;
        actor.setId(idExample);
        assertEquals(idExample, actor.getId());
    }

    @Test
    void testSetGetName() {
        String nameExample = "Sample name";
        actor.setName(nameExample);
        assertEquals(nameExample, actor.getName());
    }

    @Test
    void testSetGetBirthDate() {
        Date birthDateExample = new Date();
        actor.setBirthDate(birthDateExample);
        assertEquals(birthDateExample, actor.getBirthDate());
    }

    @Test
    void testSetGetCountry() {
        String countryExample = "Sample country";
        actor.setCountry(countryExample);
        assertEquals(countryExample, actor.getCountry());

    }

    @Test
    void testSetGetMovies() {
        List<MovieDTO> moviesExample = new ArrayList<>();
        actor.setMovies(moviesExample);
        assertEquals(moviesExample, actor.getMovies());
    }

    @Test
    void testSetGetDeadDate() {
        Date deadDateExample = new Date();
        actor.setDeadDate(deadDateExample);
        assertEquals(deadDateExample, actor.getDeadDate());
    }

}