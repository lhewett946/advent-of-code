package net.lsmith946.adventofcode2020;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class InputLoader {

    public static Set<Integer> loadToIntSet (String filePath) throws IOException {
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
