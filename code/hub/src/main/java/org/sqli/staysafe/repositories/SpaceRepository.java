package org.sqli.staysafe.repositories;

import org.sqli.staysafe.models.entities.Space;

import java.util.Set;

public interface SpaceRepository extends AbstractRepository<Space>{

    Space saveSpace(Space space);

    Set<Space> findAll();

}
