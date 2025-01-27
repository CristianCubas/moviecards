package com.lauracercas.moviecards.service.actor;

import com.lauracercas.moviecards.model.dto.ActorDTO;

import java.util.List;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
public interface ActorService {

    List<ActorDTO> getAllActors();

    ActorDTO save(ActorDTO actor);

    ActorDTO getActorById(Integer actorId);
}
