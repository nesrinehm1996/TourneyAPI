package com.tourney.api.controllers;

import com.tourney.api.models.Tournament;
import com.tourney.api.services.TournamentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tourney.api.viewmodels.TournamentVM;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TournamentController {

    @Autowired
    TournamentService service;

    @PostMapping("/createTournament")
    public ResponseEntity createTournament(@RequestBody TournamentVM tournamentVM){

        // TODO: 18/12/2019 Fix
//        service.create();
        return ResponseEntity.ok().body("Tournament not yet added");
    }
}
