package org.sqli.staysafe.store;

import org.sqli.staysafe.models.entities.Reservation;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.models.entities.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Store {

    private static Map<Long, Space> spaceStore = new HashMap<>();
    private static Map<Long, Reservation> reservationStore = new HashMap<>();
    private static Map<Long, Team> teamsStore = new HashMap<>();

    public static Space getSpaceById(long id) {
        return spaceStore.get(id);
    }

    public static void saveSpace(Space space) {

        spaceStore.put(space.getId(), space);
    }

    public static Set<Space> getAllSpaces() {
        return spaceStore.values().stream().collect(Collectors.toSet());
    }

}
