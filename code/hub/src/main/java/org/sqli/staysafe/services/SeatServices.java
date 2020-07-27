package org.sqli.staysafe.services;

import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.models.entities.Space;

import java.util.List;

public interface SeatServices {

    Seat setSeatInfos(int spaceId, Seat toSeat);

    Space seatsRecommandantion(Reservation reservation);

    Seat getSeatBySpaceIdAndNumber(long spaceId, long number);
}
