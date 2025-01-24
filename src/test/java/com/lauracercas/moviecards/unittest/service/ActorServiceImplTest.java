package com.lauracercas.moviecards.unittest.service;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.service.actor.ActorFeign;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.service.actor.ActorServiceImpl;
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
    public void shouldGetAllActors() {
        List<ActorDTO> actors = new ArrayList<>();
        actors.add(new ActorDTO());
        actors.add(new ActorDTO());

        when(feign.getActorsList()).thenReturn(actors);

        List<ActorDTO> result = sut.getAllActors();

        assertEquals(2, result.size());
    }

    @Test
    public void shouldGetActorById() {
        ActorDTO actor = new ActorDTO();
        actor.setId(1);
        actor.setName("Sample Actor");

        when(feign.getActor(anyInt())).thenReturn(actor);

        ActorDTO result = sut.getActorById(1);

        assertEquals(1, result.getId());
        assertEquals("Sample Actor", result.getName());
    }

}