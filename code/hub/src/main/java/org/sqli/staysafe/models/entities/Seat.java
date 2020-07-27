package org.sqli.staysafe.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Seat extends AbstractEntity {

    private int number;
    private boolean eligible;
    private boolean reserved;
    private boolean recommanded;
    private User user;

    @JsonIgnore
    private int x;
    @JsonIgnore
    private int y;

    public Seat() {
        super();
    }

}
