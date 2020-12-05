package net.lsmith946.adventofcode.problems2020;

public class Passport {

    private String birthYear;
    private boolean birthYearPresent;
    private String issueYear;
    private boolean issueYearPresent;
    private String expirationYear;
    private boolean expirationYearPresent;
    private String height;
    private boolean heightPresent;
    private String hairColour;
    private boolean hairColourPresent;
    private String eyeColour;
    private boolean eyeColourPresent;
    private String passportID;
    private boolean passportIDPresent;
    private String countryID;
    private boolean countryIDPresent;

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
        this.birthYearPresent = true;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
        this.issueYearPresent = true;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
        this.expirationYearPresent = true;
    }

    public void setHeight(String height) {
        this.height = height;
        this.heightPresent = true;
    }


    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
        this.hairColourPresent = true;
    }


    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
        this.eyeColourPresent = true;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
        this.passportIDPresent = true;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
        this.countryIDPresent = true;
    }

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

    public boolean checkFieldsPresent() {
        return this.birthYearPresent &&
                this.issueYearPresent &&
                this.expirationYearPresent &&
                this.heightPresent &&
                this.hairColourPresent &&
                this.eyeColourPresent &&
                this.passportIDPresent;
    }

    public boolean checkPassportValidity() {
        int birthYearInt;
        int issueYearInt;
        int expirationYearInt;
        int heightInt;

        // if some fields are not present, the passport is invalid
        if (!checkFieldsPresent()) {
            return false;
        }

        try {
            birthYearInt = Integer.parseInt(birthYear);
            issueYearInt = Integer.parseInt(issueYear);
            expirationYearInt = Integer.parseInt(expirationYear);
            Integer.parseInt(passportID); // no further checks on passport ID so no need to save it to a variable
            if (height.endsWith("cm") || height.endsWith("in")) {
                heightInt = Integer.parseInt(height.substring(0, height.length() - 2));
            } else {
                // if height is not in inches or centimetres
                // it's invalid and therefore the passport is invalid
                return false;
            }
            if (hairColour.startsWith("#")) {
                // ensure that the remaining characters can be parsed as a hex string
                Integer.parseInt(hairColour.substring(1, 6), 16);
            } else {
                // if hair colour does not start with a #
                // it's invalid and therefore the passport is invalid
                return false;
            }
        } catch (NumberFormatException e) {
            // if any of the above fields cannot be parsed to the expected format
            // they must be invalid and therefore the passport is invalid
            return false;
        }

        // validate the individual fields values

        // birth year must be in range
        if (birthYearInt < 1920 || birthYearInt > 2002) {
            return false;
        }

        // issue year must be in range
        if (issueYearInt < 2010 || issueYearInt > 2020) {
            return false;
        }

        // expiration year must be in range
        if (expirationYearInt < 2020 || expirationYearInt > 2030) {
            return false;
        }

        // height must be in range for the given unit
        if (height.endsWith("cm") &&
                (heightInt < 150 || heightInt > 193)) {
            return false;
        }
        if (height.endsWith("in") &&
                (heightInt < 59 || heightInt > 76)) {
            return false;
        }

        // hair colour must be exactly 7 characters long
        if (hairColour.length() != 7) {
            return false;
        }

        // eye colour must be one of the specified values
        if (!eyeColour.equals("amb") &&
            !eyeColour.equals("blu") &&
            !eyeColour.equals("brn") &&
            !eyeColour.equals("gry") &&
            !eyeColour.equals("grn") &&
            !eyeColour.equals("hzl") &&
            !eyeColour.equals("oth")) {
            return false;
        }

        // passport ID must be exactly 9 digits
        return passportID.length() == 9;
    }
}
