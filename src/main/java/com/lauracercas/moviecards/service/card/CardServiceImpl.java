package com.lauracercas.moviecards.service.card;


import com.lauracercas.moviecards.model.Card;
import com.lauracercas.moviecards.model.dto.ActorDTO;
import com.lauracercas.moviecards.model.dto.MovieDTO;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.service.movie.MovieService;
import com.lauracercas.moviecards.util.Messages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;

    @Override
    public String registerActorInMovie(Card card) {
        Integer actorId = card.getIdActor();
        Integer movieId = card.getIdMovie();

        ActorDTO actor = actorService.getActorById(actorId);
        MovieDTO movie = movieService.getMovieById(movieId);

        if (actor == null || movie == null) {
            return Messages.ERROR_MESSAGE;
        }

        if (existActorInMovie(actor, movie.getActors())) {
            return Messages.CARD_ALREADY_EXISTS;
        }

        movieService.registerCard(actorId, movieId);
        
        return Messages.CARD_REGISTRATION_SUCCESS;
    }

    private boolean existActorInMovie(ActorDTO actor, List<ActorDTO> actors) {
        return actors.stream()
                .anyMatch(existingActor -> existingActor.getId().equals(actor.getId()));
    }

}
