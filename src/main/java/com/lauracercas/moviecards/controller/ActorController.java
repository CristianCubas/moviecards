package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.util.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Autor: Laura Cercas Ramos
 * Proyecto: TFM Integración Continua con GitHub Actions
 * Fecha: 04/06/2024
 */
@Controller
public class ActorController {

    private static final String ACTORS_STRING = "actors";
    private static final String ACTOR_STRING = "actor";
    private static final String TITLE_STRING = "title";
    private static final String ACTORS_FORM_STRING = "actors/form";

    @Autowired
    private ActorService actorService;

    @GetMapping("actors")
    public String getActorsList(Model model) {
        model.addAttribute(ACTORS_STRING, actorService.getAllActors());
        return "actors/list";
    }

    @GetMapping("actors/new")
    public String newActor(Model model) {
        model.addAttribute(ACTOR_STRING, new ActorDTO());
        model.addAttribute(TITLE_STRING, Messages.NEW_ACTOR_TITLE);
        return ACTORS_FORM_STRING;
    }

    @PostMapping("saveActor")
    public String saveActor(@ModelAttribute ActorDTO actor, BindingResult result, Model model) {
        String url = ACTORS_FORM_STRING;

        if (!result.hasErrors()) {
            ActorDTO actorSaved = actorService.save(actor);
            if (actor.getId() != null) {
                model.addAttribute("message", Messages.UPDATED_ACTOR_SUCCESS);
            } else {
                model.addAttribute("message", Messages.SAVED_ACTOR_SUCCESS);
            }

            model.addAttribute(ACTOR_STRING, actorSaved);
            model.addAttribute(TITLE_STRING, Messages.EDIT_ACTOR_TITLE);
        }

        return ACTORS_FORM_STRING;
    }

    @GetMapping("editActor/{actorId}")
    public String editActor(@PathVariable Integer actorId, Model model) {
        ActorDTO actor = actorService.getActorById(actorId);
        List<MovieDTO> movies = actor.getMovies();
        model.addAttribute(ACTOR_STRING, actor);
        model.addAttribute("movies", movies);

        model.addAttribute(TITLE_STRING, Messages.EDIT_ACTOR_TITLE);

        return ACTORS_FORM_STRING;
    }

}
