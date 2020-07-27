package org.sqli.staysafe;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.sqli.staysafe.models.entities.Space;
import org.sqli.staysafe.models.entities.Team;
import org.sqli.staysafe.repositories.TeamRepository;
import org.sqli.staysafe.services.ReservationServices;
import org.sqli.staysafe.services.SpaceServices;
import org.sqli.staysafe.services.TeamServices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HubApplication {

    public static void main(String[] args) {
        SpringApplication.run(HubApplication.class, args);
    }

}