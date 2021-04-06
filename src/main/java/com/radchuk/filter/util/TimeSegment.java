package com.radchuk.filter.util;

public class TimeSegment {
    private int start;
    private int end;
    private int id;

    public TimeSegment(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TimeSegment{" +
                "start=" + start +
                ", end=" + end +
                ", id=" + id +
                '}';
    }
}
