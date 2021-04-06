package com.radchuk.io;

import com.radchuk.entity.BusSchedule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TableServiceReader {
    /**
     * Reads bus timetable and writes it to <code>LinkedList</code> collection, to achieve more effective delete operation later
     * @param filename path to a data file
     * @return bus schedule linked list
     * @throws IOException if any i/o operation error occurs
     */
    public static List<BusSchedule> read(Path filename) throws IOException {
        return Files.lines(filename).map(line -> line.split("\\s")).map(data -> new BusSchedule(data[0], LocalTime.parse(data[1]), LocalTime.parse(data[2]))).collect(Collectors.toCollection(LinkedList::new));
    }
}
