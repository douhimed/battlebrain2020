package org.sqli.staysafe.models.entities;

import lombok.Data;

@Data
public class User extends AbstractEntity {

    private String name;
    private Team team;

}
