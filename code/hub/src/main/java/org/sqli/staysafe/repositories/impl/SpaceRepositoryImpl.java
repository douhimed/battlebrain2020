package org.sqli.staysafe.repositories.impl;

import org.springframework.stereotype.Repository;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.repositories.SpaceRepository;
import org.sqli.staysafe.utilities.Mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class SpaceRepositoryImpl implements SpaceRepository {

    private static Map<Long, Space> spaces = new HashMap<>();

    @Override
    public Space saveSpace(Space space) {
        spaces.put(space.getId(), space);
        return space;
    }

    @Override
    public Set<Space> findAll() {
        return spaces.values().stream().collect(Collectors.toSet());
    }

    @Override
    public Space findById(long id) {
        Space space = spaces.get(id);
        Mappers.mapSeatsToList(space.getSeats()).forEach(seate -> seate.setRecommanded(false));
        return space;
    }
}
