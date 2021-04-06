package com.radchuk.entity;

import java.time.LocalTime;

/**
 * Represents single bus schedule
 */
public class BusSchedule {
    private String companyName;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    public BusSchedule(String companyName) {
        this.companyName = companyName;
    }

    public BusSchedule(String companyName, LocalTime departureTime, LocalTime arrivalTime) {
        this.companyName = companyName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return companyName + ' ' + departureTime + ' ' + arrivalTime;
    }
}
