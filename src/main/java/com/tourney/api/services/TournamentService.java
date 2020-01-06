package com.tourney.api.services;

import com.tourney.api.models.Team;
import com.tourney.api.models.Tournament;
import com.tourney.api.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    public void create(Tournament t){tournamentRepository.save(t);}

    public List<Team> getTeams(int id) {
        List<Team> result;

        result = tournamentRepository.getAllById(id);

        return result;
    }
}
