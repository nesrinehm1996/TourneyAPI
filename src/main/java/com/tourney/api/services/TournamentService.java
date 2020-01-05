package com.tourney.api.services;

import com.tourney.api.models.Tournament;
import com.tourney.api.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    public void create(Tournament t){tournamentRepository.save(t);}
}
