package org.sqli.staysafe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.staysafe.models.entities.Distance;
import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.repositories.SpaceRepository;
import org.sqli.staysafe.repositories.TeamRepository;
import org.sqli.staysafe.services.ReservationServices;
import org.sqli.staysafe.services.SeatServices;
import org.sqli.staysafe.utilities.Mappers;
import org.sqli.staysafe.utilities.SortByDistance;
import org.sqli.staysafe.utilities.business.SeatsUtilities;
import org.sqli.staysafe.utilities.exceptions.DonneeRechercheeNexistePas;
import org.sqli.staysafe.utilities.exceptions.YouFirstToReserveFromYourTeam;

import javax.swing.text.Utilities;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SeatServicesImpl implements SeatServices {

    private static final Comparator<Distance> BY_DISTANCE = (d1, d2) -> d1.getDistance() > d2.getDistance() ? 1 : 0;

    @Autowired
    private SpaceRepository spaceRepository;

    @Autowired
    private ReservationServices reservationServices;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Seat setSeatInfos(int spaceId, Seat updatedSeat) {
        Space space = this.spaceRepository.findById(spaceId);
        Seat oldSeat = Mappers.mapSeatsToList(space.getSeats()).parallelStream().
                filter(seat -> seat.getNumber() == updatedSeat.getNumber()).findFirst().orElseThrow(DonneeRechercheeNexistePas::new);
        oldSeat.setReserved(updatedSeat.isEligible() && updatedSeat.isReserved());
        oldSeat.setEligible(updatedSeat.isEligible());
        return oldSeat;
    }

    @Override
    public Space seatsRecommandantion(Reservation reservation) {

        List<Reservation> teamReservations = this.reservationServices.getReservationsByTeamAndSpace(reservation.getTeamId(), reservation.getSpaceId());

        Space space = this.spaceRepository.findById(reservation.getSpaceId());

        if (teamReservations.isEmpty())
            return space;

        List<Seat> seatsReservedByTeam = new ArrayList<>();
        List<Long> seatsNumbersReservedByTeam = new ArrayList<>();
        getSeatsReservedByTeam(teamReservations, seatsReservedByTeam, seatsNumbersReservedByTeam);

        List<Seat> seats = Mappers.mapSeatsToList(space.getSeats());

        List<Seat> disponibleSeats = SeatsUtilities.getDisponibleSeats(seats).parallelStream()
                .filter(seat -> !seatsNumbersReservedByTeam.contains(seat.getNumber())).collect(Collectors.toList());

        Map<Integer, Distance> distances = calculDistancesForEachSeatDisponible(seatsReservedByTeam, disponibleSeats);

        List<Distance> distancesList = new ArrayList<>(distances.values());
        distancesList.sort(Comparator.comparing(Distance::getDistance));

        int numbreSeatsToRecommand = this.teamRepository.findTeamById(reservation.getTeamId()).getMembers() - teamReservations.size();

        for (int i = 0; i < numbreSeatsToRecommand ; i++) {
            final int index = i;
            Seat seat = seats.parallelStream().filter(s -> s.getNumber() == distancesList.get(index).getSeatNumber())
                    .findFirst().orElseThrow(DonneeRechercheeNexistePas::new);
            seat.setRecommanded(true);
        }

        return space;
    }

    private void getSeatsReservedByTeam(List<Reservation> teamReservations, List<Seat> seatsReservedByTeam, List<Long> seatsNumbersReservedByTeam) {
        for (Reservation r : teamReservations) {
            seatsReservedByTeam.add(getSeatBySpaceIdAndNumber(r.getSpaceId(), r.getSeatNumber()));
            seatsNumbersReservedByTeam.add(r.getSeatNumber());
        }
    }

    private Map<Integer, Distance> calculDistancesForEachSeatDisponible(List<Seat> seatsReservedByTeam, List<Seat> disponibleSeats) {
        Map<Integer, Distance> distances = new HashMap<>();
        for (Seat reservedSeat : seatsReservedByTeam)
            for (Seat disponibleSeat : disponibleSeats) {
                int key = disponibleSeat.getNumber();
                double calculatedDistance = SeatsUtilities.calculDistance(reservedSeat, disponibleSeat);
                if (!distances.containsKey(key) || calculatedDistance < distances.get(key).getDistance())
                    distances.put(key, new Distance(key, calculatedDistance));
            }
        return distances;
    }

    @Override
    public Seat getSeatBySpaceIdAndNumber(long spaceId, long number) {
        return Mappers.mapSeatsToList(this.spaceRepository.findById(spaceId).getSeats()).parallelStream().filter(seat -> seat.getNumber() == number).findFirst().get();
    }

}
