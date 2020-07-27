package org.sqli.staysafe.models.entities;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class Team extends AbstractEntity {

    private String name;
    private int members;
    private boolean affected;

}
