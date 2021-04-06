package com.radchuk.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class AppTest extends Assert {
    private static final String INPUT_FILENAME = "input.txt";
    private static final String OUTPUT_FILENAME = "output.txt";

    @Test
    public void test() throws IOException {
        Files.write(Files.createFile(Paths.get(INPUT_FILENAME)), Collections.singleton("Posh 10:15 11:10\n" +
                "Posh 10:10 11:00\n" +
                "Grotty 10:10 11:00\n" +
                "Grotty 16:30 18:45\n" +
                "Posh 12:05 12:30\n" +
                "Grotty 12:30 13:25\n" +
                "Grotty 12:45 13:25\n" +
                "Posh 17:25 18:01"));
        App.main(new String[]{INPUT_FILENAME, OUTPUT_FILENAME});
        assertEquals("Posh 10:10 11:00\n" +
                        "Posh 10:15 11:10\n" +
                        "Posh 12:05 12:30\n" +
                        "Posh 17:25 18:01\n\n" +
                        "Grotty 12:30 13:25\n" +
                        "Grotty 12:45 13:25",
                String.join("\n", Files.readAllLines(Paths.get(OUTPUT_FILENAME))));
    }

    @After
    public void cleanUpFiles() throws IOException {
        Files.deleteIfExists(Paths.get(INPUT_FILENAME));
        Files.deleteIfExists(Paths.get(OUTPUT_FILENAME));
    }
}
