package org.sqli.staysafe.utilities;

import org.sqli.staysafe.models.entities.Seat;

import java.util.function.Predicate;

public final class Predicates {


    public static Predicate<Seat> isEligiblePredicate = seat -> seat.isEligible();
    public static Predicate<Seat> isReservSeatPredicate = seat -> !seat.isReserved();

}
