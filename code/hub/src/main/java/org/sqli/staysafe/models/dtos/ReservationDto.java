package org.sqli.staysafe.models.dtos;

import lombok.Data;

@Data
public class ReservationDto {
    public long teamId;
    public long spaceId;
    public long seatNumber;
    public long userId;
    private String userName;
}
