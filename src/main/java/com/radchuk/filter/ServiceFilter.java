package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;

import java.util.List;

public interface ServiceFilter {
    List<BusSchedule> filter(List<BusSchedule> schedules);
}
