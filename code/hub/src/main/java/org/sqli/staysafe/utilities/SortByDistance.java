package org.sqli.staysafe.utilities;

import org.sqli.staysafe.models.entities.Distance;

import java.util.Comparator;

public class SortByDistance implements Comparator<Distance> {
    @Override
    public int compare(Distance o1, Distance o2) {
        return o1.getDistance() < o2.getDistance() ? 1 : 0;
    }
}
