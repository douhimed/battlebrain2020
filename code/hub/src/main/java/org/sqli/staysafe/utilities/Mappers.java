package org.sqli.staysafe.utilities;

import org.sqli.staysafe.models.dtos.ReservationDto;
import org.sqli.staysafe.models.dtos.SeatDto;
import org.sqli.staysafe.models.dtos.SpaceDto;
import org.sqli.staysafe.models.dtos.TeamDto;
import org.sqli.staysafe.models.entities.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mappers {

    public static Space toSpace(SpaceDto spaceDto) {
        Space space = new Space();
        if (spaceDto.rows != 0)
            space.setRows(spaceDto.rows);
        if (spaceDto.totalPlaces != 0)
            space.setTotalPlaces(spaceDto.totalPlaces);
        return space;
    }

    public static Seat toSeat(SeatDto seatDto) {
        Seat seat = new Seat();
        seat.setNumber(seatDto.number);
        seat.setEligible(seatDto.eligible);
        seat.setReserved(seatDto.reserved);
        return seat;
    }

    public static Reservation toReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        if (reservationDto.teamId != 0)
            reservation.setTeamId(reservationDto.teamId);
        if (reservationDto.spaceId != 0)
            reservation.setSpaceId(reservationDto.spaceId);
        if (reservationDto.getSeatNumber() != 0)
            reservation.setSeatNumber(reservationDto.getSeatNumber());
        if (reservationDto.userId != 0)
            reservation.setUserId(reservationDto.userId);
        return reservation;
    }

    public static Team toTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setAffected(teamDto.isAffected());
        team.setName(teamDto.getName());
        team.setMembers(teamDto.getMembers());
        return team;
    }

    public static List<Seat> mapSeatsToList(Map<Integer, List<Seat>> seats) {
        return seats.values().parallelStream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    public static User toUser(ReservationDto reservationDto) {
        User user = new User();
        user.setName(reservationDto.getUserName());
        user.setId(reservationDto.getUserId());
        return user;
    }

    public static Reservation toReservation(long spaceId, long teamId) {
        return Reservation.builder().teamId(teamId).spaceId(spaceId).build();
    }
}
