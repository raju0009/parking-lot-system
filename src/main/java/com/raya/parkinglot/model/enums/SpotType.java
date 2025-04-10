package com.raya.parkinglot.model.enums;

public enum SpotType {
    SMALL, MEDIUM, LARGE;

    public static SpotType fromString(String type) {
        try {
            return SpotType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid SpotType: " + type);
        }
    }
}