package com.raya.parkinglot.controller;

import com.raya.parkinglot.dto.Ticket;
import com.raya.parkinglot.dto.Vehicle;
import com.raya.parkinglot.model.ParkingTicket;
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
    public ResponseEntity<?> park(@RequestBody Vehicle vehicle) {
        ParkingTicket ticket = parkingService.parkVehicle(vehicle);

        if (ticket == null) {
            return ResponseEntity.status(400).body("No available spot for your vehicle type.");
        }

        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/unpark/{ticketId}")
    public ResponseEntity<Ticket> unpark(@PathVariable Long ticketId) {
        return ResponseEntity.ok(parkingService.unparkVehicle(ticketId));
    }
}