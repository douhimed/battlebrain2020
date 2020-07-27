package org.sqli.staysafe.repositories.impl;

import org.springframework.stereotype.Repository;
import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.repositories.ReservationRepository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ReservationReposirotyImpl implements ReservationRepository {

    private static Map<Long, Reservation> reservations = new Hashtable<>();

    @Override
    public List<Reservation> getSeatsReservedByTeamMembers(long teamId) {
        List<Reservation> res = new ArrayList<>();
        reservations.values().forEach(reservation -> {
            if(reservation.getTeamId() == teamId)
                res.add(reservation);
        });
        return res;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservations.values().stream().collect(Collectors.toList());
    }
}
