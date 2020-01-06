package com.tourney.api.repositories;

import com.tourney.api.models.Team;
import com.tourney.api.models.Tournament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Team> getAllById(int id);
}
