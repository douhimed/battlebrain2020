package org.sqli.staysafe.utilities.business;

import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.utilities.Predicates;

import java.util.List;
import java.util.stream.Collectors;

public class SeatsUtilities {

    public static List<Seat> getDisponibleSeats(List<Seat> seats){
        return seats.parallelStream().filter(Predicates.isEligiblePredicate.and(Predicates.isReservSeatPredicate)).collect(Collectors.toList());
    }

    public static double calculDistance(Seat seatOne, Seat seatTwo){
        return Math.hypot(Math.abs(seatTwo.getY()- seatOne.getY()), Math.abs(seatTwo.getX()- seatOne.getX()));
    }


}
