package org.sqli.staysafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.staysafe.models.dtos.ReservationDto;
import org.sqli.staysafe.models.entities.User;
import org.sqli.staysafe.services.ReservationServices;
import org.sqli.staysafe.utilities.Mappers;

@RestController
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationServices reservationServices;

    @GetMapping
    public ResponseEntity<?> getAllReservations(){
        return new ResponseEntity<>(this.reservationServices.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> reserveSeat(@RequestBody ReservationDto reservationDto){
        return new ResponseEntity<>(this.reservationServices.reserveSeat(Mappers.toReservation(reservationDto), Mappers.toUser(reservationDto)), HttpStatus.OK);
    }

}
