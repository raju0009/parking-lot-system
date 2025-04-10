package com.raya.parkinglot.service;

import com.raya.parkinglot.model.ParkingTicket;
import com.raya.parkinglot.model.enums.SpotType;
import com.raya.parkinglot.model.enums.VehicleType;
import com.raya.parkinglot.dto.ParkingSpot;
import com.raya.parkinglot.dto.Ticket;
import com.raya.parkinglot.dto.Vehicle;
import com.raya.parkinglot.repository.SpotRepository;
import com.raya.parkinglot.repository.TicketRepository;
import com.raya.parkinglot.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ParkingService {
    @Autowired
    private SpotRepository spotRepo;
    @Autowired
    private TicketRepository ticketRepo;
    @Autowired
    private VehicleRepository vehicleRepo;

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        SpotType preferredType = mapVehicleToSpot(vehicle.getType());

        Optional<ParkingSpot> optionalSpot = spotRepo.findFirstByIsOccupiedFalseAndType(preferredType);

        if (optionalSpot.isEmpty()) {
            return null; // No spot available
        }

        ParkingSpot spot = optionalSpot.get();

        vehicleRepo.save(vehicle);
        spot.setOccupied(true);
        spot.setCurrentVehicle(vehicle);
        spotRepo.save(spot);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setSpot(spot);
        ticket.setEntryTime(LocalDateTime.now());

        Ticket savedTicket = ticketRepo.save(ticket);

        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setNumber(savedTicket.getId());
        parkingTicket.setVehicleNumber(savedTicket.getVehicle().getRegistrationNumber());
        parkingTicket.setVehicleType(savedTicket.getVehicle().getType().toString());
        parkingTicket.setParkingSpotNumber(savedTicket.getSpot().getId());
        parkingTicket.setEntryTime(savedTicket.getEntryTime());

        return parkingTicket;
    }

    public Ticket unparkVehicle(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();
        ticket.setExitTime(LocalDateTime.now());

        long hours = java.time.Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();
        ticket.setFee(hours * 10.0); // Simplified fee calculation

        ParkingSpot spot = ticket.getSpot();
        spot.setOccupied(false);
        spot.setCurrentVehicle(null);
        spotRepo.save(spot);

        return ticketRepo.save(ticket);
    }

    private SpotType mapVehicleToSpot(VehicleType type) {
        return switch (type) {
            case BIKE -> SpotType.SMALL;
            case CAR, VAN -> SpotType.MEDIUM;
            case TRUCK -> SpotType.LARGE;
        };
    }
}