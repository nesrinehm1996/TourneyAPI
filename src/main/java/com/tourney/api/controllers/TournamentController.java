package com.tourney.api.controllers;

import com.tourney.api.models.Team;
import com.tourney.api.models.Tournament;
import com.tourney.api.services.TournamentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tourney.api.viewmodels.TournamentVM;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TournamentController {

    @Autowired
    TournamentService service;

    @PostMapping("/createTournament")
    public ResponseEntity createTournament(@RequestBody TournamentVM tournamentVM){
        Tournament tournament = setTournament(tournamentVM);
        service.create(tournament);
        return ResponseEntity.ok().body("Tournament not yet added");
    }




    private Tournament setTournament(TournamentVM tournament){
        Tournament entityTournament = new Tournament();
        try{
            entityTournament.setId(tournament.getId());
            entityTournament.setDate(tournament.getDate());
            entityTournament.setName(tournament.getName());
            // TODO: 06/01/2020  Get all Teams with method
            List<Team> teams = service.getTeams(tournament.getId());
            if(teams.size() > 0){
                entityTournament.setTeams(teams);
            }

        }
        catch(Exception ex){
            throw ex;
        }
        return entityTournament;
    }
}
