package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;

import java.util.List;

public interface ServiceFilter {
    void filter(List<BusSchedule> schedules);
}
