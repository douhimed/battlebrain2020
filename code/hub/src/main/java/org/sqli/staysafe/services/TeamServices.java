package org.sqli.staysafe.services;

import org.sqli.staysafe.models.entities.Team;

import java.util.Set;

public interface TeamServices {

    Team saveTeam(Team team, long spaceId);

    Set<Team> getAll();
}
