package net.lsmith946.adventofcode.problems2015.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 implements Puzzle {

    String input;
    MessageDigest md5;

    public Day4() throws IOException, NoSuchAlgorithmException {
        InputLoader il = new InputLoader();
        this.input = il.loadToString("/2015/day4_input.txt");
        md5 = MessageDigest.getInstance("MD5");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 4 ------");
        solvePartOne();
        solvePartTwo();
    }

    private Long findNumberForHashStartingWith(String targetStart) {
        long currentNumber = 0;
        byte[] currentHashBytes;
        String currentHash;
        do {
            currentNumber++;
            String hashInput = input + currentNumber;
            currentHashBytes = md5.digest(hashInput.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            // performance optimisation, only process the exact number of bytes that we need to in order to
            // generate enough characters at the start of the hex string
            int bytesToConvert = (int) Math.ceil((double) targetStart.length() / 2.0);
            for(int i = 0; i < bytesToConvert; i++) {
                sb.append(String.format("%02x", currentHashBytes[i]));
            }
            currentHash = sb.toString();
        } while (!currentHash.startsWith(targetStart));
        return currentNumber;
    }

    @Override
    public long solvePartOne() {
        Long currentNumber = findNumberForHashStartingWith("00000");
        System.out.println("The lowest number producing a suitable hash is " + currentNumber);
        return currentNumber;
    }

    @Override
    public long solvePartTwo() {
        Long currentNumber = findNumberForHashStartingWith("000000");
        System.out.println("The lowest number producing a suitable hash is " + currentNumber);
        return currentNumber;
    }
}
