package com.raya.parkinglot.service;

import com.raya.parkinglot.dto.ParkingSpot;
import com.raya.parkinglot.model.enums.SpotType;
import com.raya.parkinglot.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {
    @Autowired
    private SpotRepository spotRepo;

    public ParkingSpot createSpot(String sportType) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setType(SpotType.fromString(sportType));
        parkingSpot.setCurrentVehicle(null);
        parkingSpot.setOccupied(false);

        return spotRepo.save(parkingSpot);
    }
}
