package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;

import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ServiceDurationFilter implements ServiceFilter {
    /**
     * Filters bus schedules list, which have trip duration > 1 hour
     * @param schedules bus schedules list
     */
    @Override
    public void filter(List<BusSchedule> schedules) {
        schedules.removeIf(schedule -> MINUTES.between(schedule.getDepartureTime(), schedule.getArrivalTime()) > 60);
    }
}
