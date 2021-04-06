package com.radchuk.io;

import com.radchuk.entity.BusSchedule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JointTableServiceWriter {
    /**
     * Writes joint bus timetable in a specific format
     * @param filename path to a result file
     * @param list resulting bus schedule list
     * @throws IOException if any i/o operation error occurs
     */
    public static void write(Path filename, List<BusSchedule> list) throws IOException {
        String result = String.join("\n\n", list.stream()
                .sorted(Comparator.comparing(BusSchedule::getCompanyName).thenComparing(BusSchedule::getDepartureTime))
                .collect(Collectors.groupingBy(BusSchedule::getCompanyName, Collectors.mapping(BusSchedule::toString, Collectors.joining("\n")))).values());
        Files.write(filename, Collections.singleton(result), StandardOpenOption.CREATE_NEW);
    }
}
