package net.lsmith946.adventofcode.problems2020;

public class TicketField {

    String fieldName;
    int firstRangeMin;
    int firstRangeMax;
    int secondRangeMin;
    int secondRangeMax;

    public TicketField(String fieldName, int firstRangeMin, int firstRangeMax, int secondRangeMin, int secondRangeMax) {
        this.fieldName = fieldName;
        this.firstRangeMin = firstRangeMin;
        this.firstRangeMax = firstRangeMax;
        this.secondRangeMin = secondRangeMin;
        this.secondRangeMax = secondRangeMax;
    }

    public boolean checkValidValue(int checkValue) {
        return (checkValue >= firstRangeMin && checkValue <= firstRangeMax) || (checkValue >= secondRangeMin && checkValue <= secondRangeMax);
    }
}
