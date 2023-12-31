package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.problems2020.Passport;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day4 implements Puzzle<Integer> {

    List<String> values;
    List<Passport> passports;

    public Day4() throws IOException, URISyntaxException, InterruptedException {
        this.values = InputLoader.loadToStringList(2020, 4);
        this.passports = new ArrayList<>();
        loadPassports();
    }

    private void loadPassports() {
        Passport currentPassport = new Passport();
        for (String s: values) {
            if (s.equals("")) {
                // if the string is empty, we are at the start of a new passport
                // so store the current passport and create a new one
                passports.add(currentPassport);
                currentPassport = new Passport();
            } else {
                String[] fieldsInString = s.split(" ");
                // check for each field appearing in the string
                // fields are not presented in a consistent order
                // so any field could be anywhere within each passport's data
                for (String field : fieldsInString) {
                    String[] fieldAndValue = field.split(":");
                    switch (fieldAndValue[0]) {
                        case "byr" -> currentPassport.setBirthYear(fieldAndValue[1]);
                        case "iyr" -> currentPassport.setIssueYear(fieldAndValue[1]);
                        case "eyr" -> currentPassport.setExpirationYear(fieldAndValue[1]);
                        case "hgt" -> currentPassport.setHeight(fieldAndValue[1]);
                        case "hcl" -> currentPassport.setHairColour(fieldAndValue[1]);
                        case "ecl" -> currentPassport.setEyeColour(fieldAndValue[1]);
                        case "pid" -> currentPassport.setPassportID(fieldAndValue[1]);
                        case "cid" -> currentPassport.setCountryID(fieldAndValue[1]);
                    }
                }
            }
        }
        // load the final passport to the list
        passports.add(currentPassport);
    }

    @Override
    public Integer solvePartOne() {
        int validPassports = 0;
        for (Passport p : passports) {
            if (p.checkFieldsPresent()) {
                validPassports++;
            }
        }
        System.out.println("The number of passports with the required fields is: " + validPassports);
        return validPassports;
    }

    @Override
    public Integer solvePartTwo() {
        int validPassports = 0;
        for (Passport p : passports) {
            if (p.checkPassportValidity()) {
                validPassports++;
            }
        }
        System.out.println("The number of valid passports is: " + validPassports);
        return validPassports;
    }
}
