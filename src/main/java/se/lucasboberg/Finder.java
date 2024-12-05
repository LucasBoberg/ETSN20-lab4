package se.lucasboberg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Finder {
    private final Pattern pattern;
    private final FileReader fileReader;
    public Finder(String pattern, String filePath) throws FileNotFoundException {
        this.pattern = Pattern.compile(pattern);

        this.fileReader = new FileReader(filePath);
    }

    public void find() throws IOException {
        List<Tuple<Integer, String>> lines = readLines();
        for (Tuple<Integer, String> line : lines) {
            if (pattern.matcher(line.getSecond()).find()) {
                System.out.println("line " + line.getFirst() + ": " + line.getSecond());
            }
        }
    }

    private List<Tuple<Integer, String>> readLines() throws IOException {
        List<Tuple<Integer, String>> lines = new ArrayList<>();
        int lineNumber = 1;
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        while (line != null) {
            lines.add(new Tuple<>(lineNumber, line));
            // read next line
            line = reader.readLine();
            lineNumber++;
        }

        reader.close();
        return lines;
    }
}
