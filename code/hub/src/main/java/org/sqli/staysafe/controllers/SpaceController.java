package org.sqli.staysafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.staysafe.models.dtos.SpaceDto;
import org.sqli.staysafe.services.SpaceServices;
import org.sqli.staysafe.utilities.Mappers;

@RestController
@RequestMapping("/space")
@CrossOrigin
public class SpaceController {

    @Autowired
    private SpaceServices spaceServices;

    @PostMapping
    public ResponseEntity<?> saveSpace(@RequestBody SpaceDto spaceDto){
        return new ResponseEntity<>(this.spaceServices.addSpace(Mappers.toSpace(spaceDto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllSpaces(){
        return new ResponseEntity<>(this.spaceServices.getAllSpaces(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpaceById(@PathVariable long id){
        return new ResponseEntity<>(this.spaceServices.getSpaceById(id), HttpStatus.OK);
    }

}
