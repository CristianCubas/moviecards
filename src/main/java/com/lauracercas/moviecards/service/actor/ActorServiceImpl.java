package com.lauracercas.moviecards.service.actor;

import com.lauracercas.moviecards.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorFeign actorFeign;

    @Override
    public List<Actor> getAllActors() {
        return actorFeign.getActorsList();
    }

    @Override
    public Actor save(Actor actor) {

        if (actor.getId() != null && actor.getId() > 0) {
            actorFeign.saveActor(actor);
        } else {
            actorFeign.newActor(actor);
        }
        return actor;
    }

    @Override
    public Actor getActorById(Integer actorId) {
        return actorFeign.getActor(actorId);
    }

}
