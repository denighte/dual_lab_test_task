package com.radchuk.filter;

import com.radchuk.entity.BusSchedule;
import com.radchuk.filter.util.TimeSegment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Complexity of the filter - n*log(n)
 */
public class ServiceEfficiencyFilter implements ServiceFilter {

    @Override
    public List<BusSchedule> filter(List<BusSchedule> schedules) {
        // Creating priority queue
        Queue<TimeSegment> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(TimeSegment::getStart));
        List<TimeSegment> timeSegments = generateTimeSegments(schedules);
        List<BusSchedule> result = new ArrayList<>();
        boolean[] visited = new boolean[schedules.size()];
        for (TimeSegment timeSegment : timeSegments) {
            if (visited[timeSegment.getId()]) {
                continue;
            }
            if (timeSegment.getStart() <= timeSegment.getEnd()) {
                priorityQueue.add(timeSegment);
            } else {
                TimeSegment last = null;
                while (priorityQueue.peek() != null && priorityQueue.peek().getStart() <= timeSegment.getEnd()) {
                    last = priorityQueue.poll();
                    visited[last.getId()] = true;
                }
                result.add(schedules.get(timeSegment.getId()));
            }
        }
        return result;
    }

    private List<TimeSegment> generateTimeSegments(List<BusSchedule> schedules) {
        return Stream.concat(IntStream.range(0, schedules.size()).mapToObj(i -> new TimeSegment(getSegmentPointStart(schedules.get(i)),
                                                                           getSegmentPointEnd(schedules.get(i)),
                                                                           i)),
                IntStream.range(0, schedules.size()).mapToObj(i -> new TimeSegment(getSegmentPointEnd(schedules.get(i)),
                        getSegmentPointStart(schedules.get(i)),
                        i))).sorted((a,b) -> {
                            int res = a.getStart() - b.getStart();
                            if (res == 0) {
                                return b.getEnd() - a.getEnd();
                            }
                            return res;
        }).collect(Collectors.toList());
    }

    private int getSegmentPointStart(BusSchedule schedule) {
        return schedule.getDepartureTime().getHour()*100 + schedule.getDepartureTime().getMinute();
    }

    private int getSegmentPointEnd(BusSchedule schedule) {
        return schedule.getArrivalTime().getHour()*100 + schedule.getArrivalTime().getMinute();
    }
}
