package org.sqli.staysafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.staysafe.models.dtos.ReservationDto;
import org.sqli.staysafe.models.dtos.SeatDto;
import org.sqli.staysafe.services.SeatServices;
import org.sqli.staysafe.utilities.Mappers;

@RestController
@RequestMapping("/seat")
@CrossOrigin
public class SeatController {

    @Autowired
    private SeatServices seatServices;

    @PutMapping
    public ResponseEntity<?> setEligible(@RequestBody SeatDto seatDto){
        return new ResponseEntity<>(this.seatServices.setSeatInfos(seatDto.spaceId, Mappers.toSeat(seatDto)), HttpStatus.OK);
    }

    @GetMapping("/recommandation/{spaceId}/{teamId}")
    public ResponseEntity<?> getRecommandation(@PathVariable long spaceId, @PathVariable long teamId){
        return new ResponseEntity<>(this.seatServices.seatsRecommandantion(Mappers.toReservation(spaceId, teamId)), HttpStatus.OK);
    }

}
