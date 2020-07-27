package org.sqli.staysafe.models.dtos;

import lombok.Data;

@Data
public class TeamDto {

    private int members;
    private boolean affected;
    private int spaceId;
    private String name;

}
