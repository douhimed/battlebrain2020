package org.sqli.staysafe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.models.entities.Team;
import org.sqli.staysafe.models.entities.User;
import org.sqli.staysafe.repositories.ReservationRepository;
import org.sqli.staysafe.repositories.TeamRepository;
import org.sqli.staysafe.repositories.UserRepository;
import org.sqli.staysafe.services.ReservationServices;
import org.sqli.staysafe.services.SeatServices;
import org.sqli.staysafe.utilities.exceptions.AlreadyReservedException;
import org.sqli.staysafe.utilities.exceptions.NotEligibleSeatException;
import org.sqli.staysafe.utilities.exceptions.YouAlreadyHaveAReservation;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServicesImpl implements ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatServices seatServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Reservation> getAll() {
        return this.reservationRepository.getAll();
    }

    @Override
    public Reservation reserveSeat(Reservation reservation, User user) {

        Seat reservationSeat = this.seatServices.getSeatBySpaceIdAndNumber(reservation.getSpaceId(), reservation.getSeatNumber());
        if (reservationSeat.isReserved())
            throw new AlreadyReservedException();

        if (!reservationSeat.isEligible())
            throw new NotEligibleSeatException();

        List<Reservation> reservations = this.reservationRepository.getSeatsReservedByTeamMembers(reservation.getTeamId());

        if (reservations.stream().anyMatch(r -> r.getUserId() == user.getId()))
            throw new YouAlreadyHaveAReservation();

        reservationSeat.setUser(user);

        Team team = this.teamRepository.findTeamById(reservation.getTeamId());
        user.setTeam(team);

        this.userRepository.saveUser(user);

        int reservationIndex = -1;
        for (Reservation r : reservations) {
            reservationIndex++;
            if (r.getUserId() == reservation.getUserId())
                throw new AlreadyReservedException();
            if (r.getSeatNumber() == 0) {
                r.setUserId(reservation.getUserId());
                r.setSeatNumber(reservation.getSeatNumber());
                reservationSeat.setReserved(true);
                break;
            }
        }
        return reservations.get(reservationIndex);
    }

    @Override
    public List<Reservation> getReservationsByTeamAndSpace(long teamId, long spaceId) {
        return this.reservationRepository.getAll().stream().filter(reservation -> reservation.getTeamId() == teamId && reservation.getUserId() != 0 && reservation.getSpaceId() == spaceId)
                .collect(Collectors.toList());
    }


}
