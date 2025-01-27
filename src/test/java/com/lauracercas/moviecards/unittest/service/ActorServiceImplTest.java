package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;
import com.lauracercas.moviecards.service.actor.ActorFeign;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.service.actor.ActorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.Date;
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
class ActorServiceImplTest {

    @Mock
    private ActorFeign feign;

    @InjectMocks
    private ActorService sut = new ActorServiceImpl();

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
    void shouldGetAllActors() {
        List<ActorDTO> actors = new ArrayList<>();
        actors.add(new ActorDTO());
        actors.add(new ActorDTO());

        when(feign.getActorsList()).thenReturn(actors);

        List<ActorDTO> result = sut.getAllActors();

        assertEquals(2, result.size());
    }

    @Test
    void shouldGetActorById() {
        ActorDTO actor = new ActorDTO();
        actor.setId(1);
        actor.setName("Sample Actor");
        actor.setDeadDate(new Date());

        when(feign.getActor(anyInt())).thenReturn(actor);

        ActorDTO result = sut.getActorById(1);

        assertEquals(1, result.getId());
        assertEquals("Sample Actor", result.getName());
    }

    @Test
    void testSave() {
        // Arrange
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(1);
        actorDTO.setName("John Doe");
        actorDTO.setBirthDate(new Date());
        actorDTO.setCountry("USA");
        actorDTO.setDeadDate(new Date());
        actorDTO.setMovies(List.of());

        // Act
        ActorDTO savedActorDTO = sut.save(actorDTO);

        // Assert
        assertEquals(actorDTO.getId(), savedActorDTO.getId());
        assertEquals(actorDTO.getName(), savedActorDTO.getName());
        assertEquals(actorDTO.getBirthDate(), savedActorDTO.getBirthDate());
        assertEquals(actorDTO.getCountry(), savedActorDTO.getCountry());
        assertEquals(actorDTO.getDeadDate(), savedActorDTO.getDeadDate());
        assertEquals(actorDTO.getMovies(), savedActorDTO.getMovies());

        // Verify
        verify(feign).saveActor(any(ActorDTO.class));
    }
}