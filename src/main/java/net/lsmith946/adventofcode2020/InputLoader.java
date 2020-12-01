package net.lsmith946.adventofcode2020;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class InputLoader {

    public Set<Integer> loadToIntSet (String resourcePath) throws IOException {
        URL u = getClass().getResource(resourcePath);
        if (u == null) {
            throw new FileNotFoundException();
        }
        String filePath = getClass().getResource(resourcePath).getFile();
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Set<Integer> ints = new HashSet<>();

        String str;
        while ((str = br.readLine()) != null) {
            ints.add(Integer.valueOf(str));
        }

        return ints;
    }
}
