package com.radchuk.app;

import com.radchuk.filter.TableServiceFilterController;
import com.radchuk.io.JointTableServiceWriter;
import com.radchuk.io.TableServiceReader;

import java.io.IOException;
import java.nio.file.Paths;

public class App {
    /**
     *
     * @param args arg[0] is input file path, arg[1] is output file path
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("");
        }
        JointTableServiceWriter.write(Paths.get(args[1]), new TableServiceFilterController().filter(TableServiceReader.read(Paths.get(args[0]))));
    }
}
