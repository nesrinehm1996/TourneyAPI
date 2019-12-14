package com.tourney.api.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Team {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @OneToMany
    Set<Player> members;

    @ManyToMany
    Set<Tournament> tournaments;

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Set<Player> getMembers() {
        return members;
    }

    public void setMembers(Set<Player> members) {
        this.members = members;
    }




}
