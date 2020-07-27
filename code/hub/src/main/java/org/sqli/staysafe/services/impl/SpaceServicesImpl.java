package org.sqli.staysafe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.staysafe.models.entities.Seat;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.repositories.SpaceRepository;
import org.sqli.staysafe.services.SpaceServices;
import org.sqli.staysafe.utilities.Mappers;
import org.sqli.staysafe.utilities.exceptions.PlacesCannotBeNullException;
import org.sqli.staysafe.utilities.exceptions.SpaceMustHaveRowsException;

import java.util.*;

@Service
public class SpaceServicesImpl implements SpaceServices {

    @Autowired
    private SpaceRepository spaceRepository;

    @Override
    public Space addSpace(Space space) {

        if(space.getTotalPlaces() == 0)
            throw new PlacesCannotBeNullException();

        if(space.getRows() == 0)
            throw new SpaceMustHaveRowsException();

        int maxPlacesInRow = space.getTotalPlaces() / space.getRows();

        int number = 1;
        for (int i = 0; i < space.getRows(); i++) {
            List<Seat> row = new ArrayList<>();
            space.addRow(i, row);

            for (int j = 0; j < maxPlacesInRow; j++) {
                Seat seat = Seat.builder().x(i).y(j).number(number++).build();
                row.add(seat);

                int frontIndex = Math.max(i - 1, 0);
                int nextSeat = Math.max(j - 1, 0);
                //boolean isEligible = (i == 0 && j == 0) || !(space.getRow(frontIndex).get(j).isEligible() || row.get(nextSeat).isEligible());
                boolean isEligible = (i + j)% 2 == 0;
                seat.setEligible(isEligible);
                if (isEligible) space.incrementEligibleSeats();
            }
        }

        this.spaceRepository.saveSpace(space);
        return space;
    }

    @Override
    public Set<Space> getAllSpaces() {
        return this.spaceRepository.findAll();
    }

    @Override
    public Space getSpaceById(long id) {
        return this.spaceRepository.findById(id);
    }

}
