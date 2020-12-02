package net.lsmith946.adventofcode2020;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoader {

    private BufferedReader openFileForReading(String resourcePath) throws FileNotFoundException {
        URL u = getClass().getResource(resourcePath);
        if (u == null) {
            throw new FileNotFoundException();
        }
        String filePath = getClass().getResource(resourcePath).getFile();
        File file = new File(filePath);
        return new BufferedReader(new FileReader(file));
    }

    public Set<Integer> loadToIntSet (String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        Set<Integer> ints = new HashSet<>();

        String str;
        while ((str = br.readLine()) != null) {
            ints.add(Integer.valueOf(str));
        }

        return ints;
    }

    public List<String> loadToStringList (String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        List<String> strings = new ArrayList<>();

        String str;
        while((str = br.readLine()) != null) {
            strings.add(str);
        }

        return strings;
    }
}
