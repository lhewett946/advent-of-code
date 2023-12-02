package net.lsmith946.adventofcode.utils;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.nio.file.FileAlreadyExistsException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputLoader {

    public static String constructFilePath(int year, int day) {
        String fileName = "/" + year + "_day" + day + "_input.txt";
        String dir = System.getProperty("user.dir");
        return dir + fileName;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static void downloadInput(int year, int day) throws IOException, InterruptedException, URISyntaxException {
        String sessionCookieStr = InputLoader.loadToString(System.getProperty("user.dir") + "/session_cookie");
        // configure the session cookie to authenticate with Advent of Code website
        CookieHandler.setDefault(new CookieManager());
        HttpCookie sessionCookie = new HttpCookie("session", sessionCookieStr);
        sessionCookie.setPath("/");
        sessionCookie.setVersion(0);

        ((CookieManager) CookieHandler.getDefault()).getCookieStore().add(new URI("https://adventofcode.com"),
                sessionCookie);

        // construct the client and the request
        HttpClient client = HttpClient.newBuilder()
                .cookieHandler(CookieHandler.getDefault())
                .connectTimeout(Duration.ofSeconds(10))
                .build();


        String requestURL = "https://adventofcode.com/" + year + "/day/" + day + "/input";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(requestURL))
                .GET()
                .build();

        // send the request and accept the response
        String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        // construct the file path to write the response to and write it out to disk
        File file = new File(constructFilePath(year, day));

        if (file.createNewFile()) {
            FileWriter writer = new FileWriter(file);
            writer.write(response);
            writer.close();
        }
        else {
            throw new FileAlreadyExistsException("Downloaded input that was already cached");
        }
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a BufferedReader containing the input file
     * @throws FileNotFoundException when the resource path does not exist
     */
    private static BufferedReader openFileForReading(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        File file = new File(constructFilePath(year, day));
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            downloadInput(year, day);
            return new BufferedReader(new FileReader(file));
        }
    }

    /**
     * @param filePath The path to the file to be opened
     * @return a BufferedReader containing the input file
     * @throws FileNotFoundException when the resource path does not exist
     */
    private static BufferedReader openFileForReading(String filePath) throws IOException, URISyntaxException, InterruptedException {
        File file = new File(filePath);
        if (file.exists()) {
            return new BufferedReader(new FileReader(file));
        }
        else {
            throw new FileNotFoundException();
        }
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a set containing the integers in the input file
     * @throws IOException if the file does not exist, or the contents cannot be stored to an integer set due to containing non-unique values
     */
    public static Set<Integer> loadToIntSet(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        BufferedReader br = openFileForReading(year, day);
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
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a list containing the integers in the input file
     * @throws IOException if the file does not exist
     */
    public static List<Long> loadToLongList(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        BufferedReader br = openFileForReading(year, day);
        List<Long> ints = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            ints.add(Long.valueOf(str));
        }

        return ints;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a list containing the strings in the input file
     * @throws IOException if the file does not exist
     */
    public static List<String> loadToStringList(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        BufferedReader br = openFileForReading(year, day);
        List<String> strings = new ArrayList<>();

        String str;
        while ((str = br.readLine()) != null) {
            strings.add(str);
        }

        return strings;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a string containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public static String loadToString(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        BufferedReader br = openFileForReading(year, day);
        String str;
        String input = "";
        while ((str = br.readLine()) != null) {
            input = input.concat(str);
        }
        return input;
    }

    /**
     * @param filePath The path to the file that we are loading
     * @return a string containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public static String loadToString(String filePath) throws IOException, URISyntaxException, InterruptedException {
        BufferedReader br = openFileForReading(filePath);
        String str;
        String input = "";
        while ((str = br.readLine()) != null) {
            input = input.concat(str);
        }
        return input;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a 2D char array containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public static char[][] loadTo2DCharArray(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        // determine how many lines there are in the file
        BufferedReader br = openFileForReading(year, day);
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        // actually load file content
        String str;
        br = openFileForReading(year, day);
        char[][] chars = new char[lines][];
        int currentLine = 0;
        while ((str = br.readLine()) != null) {
            chars[currentLine] = str.toCharArray();
            currentLine++;
        }
        return chars;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a 2D char array containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public static int[][] loadTo2DIntArray(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        // determine how many lines there are in the file
        BufferedReader br = openFileForReading(year, day);
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        // actually load file content
        String str;
        br = openFileForReading(year, day);
        int[][] ints = new int[lines][];
        int currentLine = 0;
        while ((str = br.readLine()) != null) {
            char[] currentLineChars = str.toCharArray();
            ints[currentLine] = new int[currentLineChars.length];
            for(int i = 0; i < currentLineChars.length; i++) {
                ints[currentLine][i] = Integer.parseInt(String.valueOf(currentLineChars[i]));
            }
            currentLine++;
        }
        return ints;
    }

    /**
     * @param year The year for which we are trying to get the input
     * @param day The day for which we are trying to get the input
     * @return a char array containing the data in the input file
     * @throws IOException if the file does not exist
     */
    public static char[] loadToCharArray(int year, int day) throws IOException, URISyntaxException, InterruptedException {
        return loadToString(year, day).toCharArray();
    }
}
