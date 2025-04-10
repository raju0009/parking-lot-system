package com.raya.parkinglot.controller;

import com.raya.parkinglot.dto.ParkingSpot;
import com.raya.parkinglot.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkingspot")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @PostMapping("/create")
    public ResponseEntity<ParkingSpot> park(@RequestBody String parkingSpotType) {
        return ResponseEntity.ok(parkingSpotService.createSpot(parkingSpotType));
    }
}
