package com.lauracercas.moviecards.service.actor;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lauracercas.moviecards.model.Actor;

@FeignClient(name = "ActorServiceFeign", url = "${feign.client.config.movies-client.url}")
public interface ActorFeign {

    @PostMapping
    public void newActor(@RequestBody Actor actor);

    @PutMapping
    public void saveActor(@RequestBody Actor actor);

    @GetMapping
    public List<Actor> getActorsList();

    @GetMapping(path = "/{actorId}")
    public Actor getActor(@PathVariable("actorId") Integer actorId);

}
