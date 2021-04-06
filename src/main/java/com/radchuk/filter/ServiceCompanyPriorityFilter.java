package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;
import com.radchuk.entity.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ServiceCompanyPriorityFilter implements ServiceFilter {

    /**
     * Filters given bus schedule list with equals arrivals and departures time, by choosing more comfortable bus
     * @param schedules bus schedule list
     */
    @Override
    public void filter(List<BusSchedule> schedules) {
        Map<Integer, BusSchedule> timeIdDict = new HashMap<>();
        List<BusSchedule> schedulesToRemove = new ArrayList<>();
        for (BusSchedule schedule : schedules) {
            int timeId = getTimeId(schedule);
            prioritizePoshCompany(schedulesToRemove, schedule, timeIdDict.get(timeId));
            timeIdDict.put(timeId, schedule);
        }
        schedules.removeAll(schedulesToRemove);
    }

    private void prioritizePoshCompany(List<BusSchedule> schedulesToRemove, BusSchedule currentSchedule, BusSchedule equalTimeBusSchedule) {
        if (equalTimeBusSchedule != null) {
            if (Company.POSH.getName().equals(currentSchedule.getCompanyName())) {
                schedulesToRemove.add(equalTimeBusSchedule);
            } else {
                schedulesToRemove.add(currentSchedule);
            }
        }
    }

    private int getTimeId(BusSchedule schedule) {
        return schedule.getArrivalTime().getHour()*1000000 + schedule.getArrivalTime().getMinute()*10000
                + schedule.getDepartureTime().getHour()*100 + schedule.getDepartureTime().getMinute();
    }
}
