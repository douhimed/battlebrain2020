package org.sqli.staysafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.staysafe.models.dtos.TeamDto;
import org.sqli.staysafe.services.TeamServices;
import org.sqli.staysafe.utilities.Mappers;

@RestController
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @PostMapping
    public ResponseEntity<?> saveTeam(@RequestBody TeamDto teamDto){
        return new ResponseEntity<>(this.teamServices.saveTeam(Mappers.toTeam(teamDto), teamDto.getSpaceId()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTeams(){
        return new ResponseEntity<>(this.teamServices.getAll(), HttpStatus.OK);
    }

}
