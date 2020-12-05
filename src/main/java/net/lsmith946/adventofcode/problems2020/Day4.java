package net.lsmith946.adventofcode.problems2020;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.*;
import java.util.List;

public class Day4 implements Puzzle {

    List<String> values;

    public Day4() throws IOException {
        InputLoader il = new InputLoader();
        this.values = il.loadToStringList("/day4_input.txt");
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 4 ------");
        solvePartOne();
        solvePartTwo();
    }

    @Override
    public int solvePartOne() {
        Passport currentPassport = new Passport();
        int validPassports = 0;
        for (String s: values) {
            if (s.equals("")) {
                // if the string is empty, we are at the start of a new passport
                // so check the validity of the current one and then create a new one
                if (currentPassport.checkValidity()) {
                    validPassports++;
                }
                currentPassport = new Passport();
            } else {
                // check for each field appearing in the string
                // fields are not presented in a consistent order
                // so any field could be anywhere within each passports data
                if (s.contains("byr:")) {
                    currentPassport.birthYearPresent = true;
                }
                if (s.contains("iyr:")) {
                    currentPassport.issueYearPresent = true;
                }
                if (s.contains("eyr:")) {
                    currentPassport.expirationYearPresent = true;
                }
                if (s.contains("hgt:")) {
                    currentPassport.heightPresent = true;
                }
                if (s.contains("hcl:")) {
                    currentPassport.hairColourPresent = true;
                }
                if (s.contains("ecl:")) {
                    currentPassport.eyeColourPresent = true;
                }
                if (s.contains("pid:")) {
                    currentPassport.passportIDPresent = true;
                }
                if (s.contains("cid:")) {
                    currentPassport.countryIDPresent = true;
                }
            }
        }
        // check the validity of the final passport in the file
        if (currentPassport.checkValidity()) {
            validPassports++;
        }
        System.out.println("The number of valid passports is: " + validPassports);
        return validPassports;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
