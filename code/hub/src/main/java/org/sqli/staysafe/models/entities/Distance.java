package org.sqli.staysafe.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Distance extends AbstractEntity implements Comparator<Distance> {

    private long seatNumber;
    private double distance;

    @Override
    public int compare(Distance o1, Distance o2) {
        return o1.getDistance() > o2.getDistance() ? 0 : 1;
    }
}
