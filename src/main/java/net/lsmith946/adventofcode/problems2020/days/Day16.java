package net.lsmith946.adventofcode.problems2020.days;

import net.lsmith946.adventofcode.problems2020.Ticket;
import net.lsmith946.adventofcode.problems2020.TicketField;
import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day16 implements Puzzle {

    List<String> inputStrings;
    List<TicketField> ticketFields;
    Ticket myTicket;
    List<Ticket> nearbyTickets;

    public Day16() throws IOException {
        InputLoader il = new InputLoader();
        inputStrings = il.loadToStringList("/2020/day16_input.txt");
        ticketFields = new ArrayList<>();
        nearbyTickets = new ArrayList<>();
        parseInput();
    }

    private Ticket createTicket(String ticketValues) {
        // load the values into a ticket object
        String[] ticketStrings = ticketValues.split(",");
        List<Integer> ticketContents = new ArrayList<>();
        for (String v : ticketStrings) {
            ticketContents.add(Integer.parseInt(v));
        }
        return new Ticket(ticketContents, ticketFields);
    }

    private void parseInput() {
        boolean endOfFirstSection = false;
        boolean endOfSecondSection = false;
        for (String s : inputStrings) {
            // the first section describes the fields that exist within a ticket,
            // and their valid ranges
            if (!endOfFirstSection) {
                if (s.equals("")) {
                    // empty string denotes the end of the section
                    endOfFirstSection = true;
                } else {
                    String[] fieldDescriptionsSplit = s.split(":| or |-");
                    TicketField newField = new TicketField(fieldDescriptionsSplit[0],
                            Integer.parseInt(fieldDescriptionsSplit[1].trim()),
                            Integer.parseInt(fieldDescriptionsSplit[2].trim()),
                            Integer.parseInt(fieldDescriptionsSplit[3].trim()),
                            Integer.parseInt(fieldDescriptionsSplit[4].trim()));
                    ticketFields.add(newField);
                }
            } else if (!endOfSecondSection) {
                if (s.equals("your ticket:")) {
                    // discard this line
                } else if (s.equals("")) {
                    // empty string denotes the end of the section
                    endOfSecondSection = true;
                } else {
                    myTicket = createTicket(s);
                }
            } else {
                if (s.equals("nearby tickets:")) {
                    // discard this line
                } else {
                    // load all the other tickets
                    nearbyTickets.add(createTicket(s));
                }
            }
        }
    }

    @Override
    public void solve() {
        System.out.println("------ DAY 16 ------");
        System.out.println("--- PART ONE ---");
        solvePartOne();
        System.out.println("--- PART TWO ---");
        solvePartTwo();
    }

    @Override
    public long solvePartOne() {
        int errorRate = 0;
        for (Ticket t : nearbyTickets) {
            errorRate += t.calculateErrorRate();
        }
        System.out.println("The ticket scanning error rate is: " + errorRate);
        return errorRate;
    }

    @Override
    public long solvePartTwo() {
        return 0;
    }
}
