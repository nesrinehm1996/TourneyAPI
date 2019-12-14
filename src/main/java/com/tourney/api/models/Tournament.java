package com.tourney.api.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Tournament {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String name;
    public Date date;
    @ManyToMany
    public List<Team> teams;
}
