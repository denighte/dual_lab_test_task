package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;

import java.util.List;

public class TableServiceFilterController {
    private static final ServiceFilter[] FILTERS = new ServiceFilter[]{new ServiceDurationFilter(), new ServiceCompanyPriorityFilter()};

    public List<BusSchedule> filter(List<BusSchedule> busSchedules) {
        for (ServiceFilter filter : FILTERS) {
            filter.filter(busSchedules);
        }
        return busSchedules;
    }
}
