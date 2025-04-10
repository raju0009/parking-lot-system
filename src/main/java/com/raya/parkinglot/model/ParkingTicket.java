package com.raya.parkinglot.model;

import java.time.LocalDateTime;

public class ParkingTicket {
    private Long number;
    private String vehicleNumber;

    private String vehicleType;
    private Long parkingSpotNumber;
    private LocalDateTime entryTime;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(Long parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
}
