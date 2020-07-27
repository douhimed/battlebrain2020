package org.sqli.staysafe.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.models.entities.Team;
import org.sqli.staysafe.repositories.ReservationRepository;
import org.sqli.staysafe.repositories.TeamRepository;
import org.sqli.staysafe.services.SpaceServices;
import org.sqli.staysafe.services.TeamServices;
import org.sqli.staysafe.utilities.Mappers;
import org.sqli.staysafe.utilities.constants.CodeMessages;
import org.sqli.staysafe.utilities.exceptions.BusinessException;
import org.sqli.staysafe.utilities.exceptions.OnlySeatsDisponibleException;
import org.sqli.staysafe.utilities.exceptions.SpaceIsFullException;

import java.util.Set;

@Service
public class TeamServicesImpl implements TeamServices {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SpaceServices spaceServices;

    @Override
    public Team saveTeam(Team team, long spaceId) {

        Space space = this.spaceServices.getSpaceById(spaceId);

        if(space.getTotalReserved() == space.getEligibleSeatsNumber())
            throw new SpaceIsFullException();

        if(space.getEligibleSeatsNumber() - space.getTotalReserved() < team.getMembers())
            throw new OnlySeatsDisponibleException(space.getEligibleSeatsNumber() - space.getTotalReserved());

        this.teamRepository.addTeam(team);
        for (int i = 0; i < team.getMembers(); i++){
            Reservation reservation = new Reservation();
            reservation.setSpaceId(spaceId);
            reservation.setTeamId(team.getId());
            this.reservationRepository.saveReservation(reservation);
            space.incrementTotalReserved();

        }
        team.setAffected(true);
        return team;
    }

    @Override
    public Set<Team> getAll() {
        return this.teamRepository.findAllTeams();
    }
}
