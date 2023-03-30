package net.lsmith946.adventofcode.utils;

/**
 * Provides an implementation of a simple counter that can be incremented and decremented by variable amounts
 */
public class Counter {

    private int currentValue;

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void modifyCounter(CounterOperations op, int magnitude) throws IllegalArgumentException {
        switch (op) {
            case INCREMENT -> currentValue += magnitude;
            case DECREMENT -> currentValue -= magnitude;
            case RESET -> throw new IllegalArgumentException("Cannot reset counter with a magnitude also provided!");
        }
    }

    public void modifyCounter(CounterOperations op) throws IllegalArgumentException {
        if (op.equals(CounterOperations.RESET)) {
            currentValue = 0;
        } else {
            throw new IllegalArgumentException("Cannot modify counter in this way without a magnitude!");
        }
    }

    public Counter() {
        this.currentValue = 0;
    }
}
