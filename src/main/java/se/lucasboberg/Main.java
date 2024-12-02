package se.lucasboberg;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("No arguments given. You need to provide first a pattern and then a file path.");
            return;
        }
        var pattern = args[0];
        var path = args[1];

        try {
            var finder = new Finder(pattern, path);
            finder.find();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}