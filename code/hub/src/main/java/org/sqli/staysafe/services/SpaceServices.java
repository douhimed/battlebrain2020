package org.sqli.staysafe.services;

import org.sqli.staysafe.models.entities.Space;

import java.util.Set;

public interface SpaceServices {

    Space addSpace(Space space);

    Set<Space> getAllSpaces();

    Space getSpaceById(long id);

}
