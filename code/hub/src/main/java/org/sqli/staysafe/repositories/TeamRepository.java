package org.sqli.staysafe.repositories;

import org.sqli.staysafe.models.entities.Team;

import java.util.Set;

public interface TeamRepository {

    Set<Team> findAllTeams();

    Team findTeamById(long id);

    void addTeam(Team team);

}
