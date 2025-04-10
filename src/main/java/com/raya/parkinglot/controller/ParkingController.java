package com.raya.parkinglot.controller;

import com.raya.parkinglot.dto.Ticket;
import com.raya.parkinglot.dto.Vehicle;
import com.raya.parkinglot.model.enums.ParkingTicket;
import com.raya.parkinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<ParkingTicket> park(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(parkingService.parkVehicle(vehicle));
    }

    @PostMapping("/unpark/{ticketId}")
    public ResponseEntity<Ticket> unpark(@PathVariable Long ticketId) {
        return ResponseEntity.ok(parkingService.unparkVehicle(ticketId));
    }
}