package com.raya.parkinglot.repository;

import com.raya.parkinglot.dto.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}