package org.sqli.staysafe.repositories.impl;

import org.springframework.stereotype.Repository;
import org.sqli.staysafe.models.entities.Team;
import org.sqli.staysafe.repositories.TeamRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class TeamRepositoryImpl implements TeamRepository {

    private static Map<Long, Team> teams = new HashMap<>();

    @Override
    public Set<Team> findAllTeams() {
        return teams.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Team findTeamById(long id) {
        return teams.get(id);
    }

    @Override
    public void addTeam(Team team) {
        teams.put(team.getId(), team);
    }


}
