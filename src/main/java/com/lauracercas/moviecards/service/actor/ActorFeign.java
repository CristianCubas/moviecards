package com.lauracercas.moviecards.service.actor;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lauracercas.moviecards.model.dto.ActorDTO;

@FeignClient(name = "actorServiceFeign", url = "${feign.client.config.zure.url}")
public interface ActorFeign {

    @PostMapping(path = "/actors")
    public void newActor(@RequestBody ActorDTO actor);

    @PutMapping(path = "/actors")
    public void saveActor(@RequestBody ActorDTO actor);

    @GetMapping(path = "/actors")
    public List<ActorDTO> getActorsList();

    @GetMapping(path = "/actors/{actorId}")
    public ActorDTO getActor(@PathVariable("actorId") Integer actorId);

}
