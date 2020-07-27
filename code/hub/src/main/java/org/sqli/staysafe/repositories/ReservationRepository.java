package org.sqli.staysafe.repositories;

import org.springframework.stereotype.Repository;
import org.sqli.staysafe.models.entities.Reservation;

import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository {

    List<Reservation> getSeatsReservedByTeamMembers(long teamId);

    void saveReservation(Reservation reservation);

    List<Reservation> getAll();

}
