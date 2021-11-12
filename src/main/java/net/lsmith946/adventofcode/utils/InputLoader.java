package net.lsmith946.adventofcode.utils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoader {

    /**
     * The method opens the file specified by resourcePath for reading into a program
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws FileNotFoundException
     */
    private BufferedReader openFileForReading(String resourcePath) throws FileNotFoundException {
        URL u = getClass().getResource(resourcePath);
        if (u == null) {
            throw new FileNotFoundException();
        }
        String filePath = u.getFile();
        File file = new File(filePath);
        return new BufferedReader(new FileReader(file));
    }

    /**
     * This method loads the contents of the file specified by resourcePath to an integer set
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public Set<Integer> loadToIntSet(String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        Set<Integer> ints = new HashSet<>();

        String str;
        while ((str = br.readLine()) != null) {
            if (!ints.add(Integer.valueOf(str))) {
                throw new IllegalArgumentException("Tried to add an integer that already existed in the set!");
            }
        }

        return ints;
    }

    /**
     * This method loads the contents of the file specified by resourcePath to an integer list
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public List<Long> loadToLongList(String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        List<Long> ints = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            ints.add(Long.valueOf(str));
        }

        return ints;
    }

    /**
     * This method loads the contents of the file specified by resourcePath to a list of strings
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public List<String> loadToStringList(String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        List<String> strings = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            strings.add(str);
        }

        return strings;
    }

    /**
     * This method loads the contents of the file specified by resourcePath to a single string
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public String loadToString(String resourcePath) throws IOException {
        BufferedReader br = openFileForReading(resourcePath);
        String str;
        String input = "";
        while ((str = br.readLine()) != null) {
            input = input.concat(str);
        }
        return input;
    }

    /**
     * This method loads the contents of the file specified by resourcePath to a 2D character array
     *
     * @param resourcePath The path of the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public char[][] loadTo2DCharArray(String resourcePath) throws IOException {
        // determine how many lines there are in the file
        BufferedReader br = openFileForReading(resourcePath);
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        // actually load file content
        String str;
        br = openFileForReading(resourcePath);
        char[][] chars = new char[lines][];
        int currentLine = 0;
        while ((str = br.readLine()) != null) {
            chars[currentLine] = str.toCharArray();
            currentLine++;
        }
        return chars;
    }

    /**
     * This method loads the contents of the file specified by resourcePath to an array of characters
     *
     * @param resourcePath The path to the file to be read in, under resources
     * @return
     * @throws IOException
     */
    public char[] loadToCharArray(String resourcePath) throws IOException {
        return loadToString(resourcePath).toCharArray();
    }
}
