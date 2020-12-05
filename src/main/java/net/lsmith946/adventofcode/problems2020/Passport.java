package net.lsmith946.adventofcode.problems2020;

public class Passport {
    boolean birthYearPresent;
    boolean issueYearPresent;
    boolean expirationYearPresent;
    boolean heightPresent;
    boolean hairColourPresent;
    boolean eyeColourPresent;
    boolean passportIDPresent;
    boolean countryIDPresent;

    public Passport() {
        this.birthYearPresent = false;
        this.issueYearPresent = false;
        this.expirationYearPresent = false;
        this.heightPresent = false;
        this.hairColourPresent = false;
        this.eyeColourPresent = false;
        this.passportIDPresent = false;
        this.countryIDPresent = false;
    }

    public boolean checkValidity() {
        return this.birthYearPresent &&
                this.issueYearPresent &&
                this.expirationYearPresent &&
                this.heightPresent &&
                this.hairColourPresent &&
                this.eyeColourPresent &&
                this.passportIDPresent;
    }
}
