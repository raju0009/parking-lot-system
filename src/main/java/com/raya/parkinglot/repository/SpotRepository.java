package com.raya.parkinglot.repository;

import com.raya.parkinglot.dto.ParkingSpot;
import com.raya.parkinglot.model.enums.SpotType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpotRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findFirstByIsOccupiedFalseAndType(SpotType type);
}