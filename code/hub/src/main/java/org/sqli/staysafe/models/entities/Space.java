package org.sqli.staysafe.models.entities;

import lombok.Data;

import java.util.*;

@Data
public class Space extends AbstractEntity {

    private int totalPlaces;
    private int rows;
    private int eligibleSeatsNumber;
    private int totalReserved;
    private Map<Integer, List<Seat>> seats = new HashMap<>();

    public void addRow(int rowNumber, List<Seat> row){
        this.seats.put(rowNumber, row);
    }

    public void incrementEligibleSeats(){
        this.eligibleSeatsNumber++;
    }

    public List<Seat> getRow(int i) {
        return this.seats.get(i);
    }

    public void incrementTotalReserved() {
        totalReserved++;
    }
}
