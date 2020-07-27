package org.sqli.staysafe.services;

import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.User;

import java.util.List;
import java.util.Set;

public interface ReservationServices {

    List<Reservation> getAll();

    Reservation reserveSeat(Reservation reservation, User user);

    List<Reservation> getReservationsByTeamAndSpace(long teamId, long spaceId);
}
