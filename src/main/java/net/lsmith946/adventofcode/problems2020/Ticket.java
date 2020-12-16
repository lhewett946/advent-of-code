package net.lsmith946.adventofcode.problems2020;

import java.util.List;

public class Ticket {

    List<Integer> ticketValues;
    List<TicketField> ticketFields;

    public Ticket(List<Integer> ticketValues, List<TicketField> ticketFields) {
        this.ticketValues = ticketValues;
        this.ticketFields = ticketFields;
    }

    public int calculateErrorRate() {
        int errorRate = 0;
        for (Integer v : ticketValues) {
            boolean validValue = false;
            for (TicketField f : ticketFields) {
                validValue |= f.checkValidValue(v);
            }
            if (!validValue) {
                errorRate += v;
            }
        }
        return errorRate;
    }
}
