package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ServiceDurationFilter implements ServiceFilter {
    /**
     * Filters bus schedules list, which have trip duration > 1 hour
     * @param schedules bus schedules list
     */
    @Override
    public List<BusSchedule> filter(List<BusSchedule> schedules) {
        return schedules.stream().filter(schedule -> !(MINUTES.between(schedule.getDepartureTime(), schedule.getArrivalTime()) > 60)).collect(Collectors.toList());
    }
}
