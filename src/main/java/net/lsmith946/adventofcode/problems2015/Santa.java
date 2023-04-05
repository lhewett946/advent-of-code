package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.utils.Counter;
import net.lsmith946.adventofcode.utils.CounterOperations;

public class Santa {

    private final Counter currentFloor;

    public int getCurrentFloor() {
        return currentFloor.getCurrentValue();
    }

    public void setCurrentFloor(int floorNumber) {
        this.currentFloor.setCurrentValue(floorNumber);
    }

    public Santa() {
        this.currentFloor = new Counter();
    }

    public void changeFloors(char direction) {
        if (direction == '(') {
            currentFloor.modifyCounter(CounterOperations.INCREMENT, 1);
        }  else {
            currentFloor.modifyCounter(CounterOperations.DECREMENT, 1);
        }
    }
}
