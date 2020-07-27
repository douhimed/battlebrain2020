package org.sqli.staysafe.models.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Reservation extends AbstractEntity{

    private long spaceId;
    private long userId;
    private long seatNumber;
    private long teamId;

}
