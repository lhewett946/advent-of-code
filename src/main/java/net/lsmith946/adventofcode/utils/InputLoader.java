package net.lsmith946.adventofcode.utils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoader {

    /**
     * @param resourcePath The path to the file to be read in, under resources
     * @return a BufferedReader containing the input file
     * @throws FileNotFoundException when the resource path does not exist
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
     * @param resourcePath The path to the file to be read in, under resources
     * @return a set containing the integers in the input file
     * @throws IOException if the file does not exist, or the contents cannot be stored to an integer set due to containing non-unique values
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
     * @param resourcePath The path to the file to be read in, under resources
     * @return a list containing the integers in the input file
     * @throws IOException if the file does not exist
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
     * @param resourcePath The path to the file to be read in, under resources
     * @return a list containing the strings in the input file
     * @throws IOException if the file does not exist
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
     * @param resourcePath The path to the file to be read in, under resources
     * @return a string containing the data in the input file
     * @throws IOException if the file does not exist
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
     * @param resourcePath The path of the file to be read in, under resources
     * @return a 2D char array containing the data in the input file
     * @throws IOException if the file does not exist
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
     * @param resourcePath The path to the file to be read in, under resources
     * @return a char array containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public char[] loadToCharArray(String resourcePath) throws IOException {
        return loadToString(resourcePath).toCharArray();
    }
}
