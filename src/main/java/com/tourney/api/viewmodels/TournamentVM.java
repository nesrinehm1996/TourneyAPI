package com.tourney.api.viewmodels;

import com.tourney.api.models.Team;

import java.util.Date;
import java.util.List;

public class TournamentVM {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    public int id;
    public String name;
    public Date date;
    public List<Team> teams;
}
