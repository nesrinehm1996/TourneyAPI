package com.tourney.api.repositories;

import com.tourney.api.models.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Long> {

}
