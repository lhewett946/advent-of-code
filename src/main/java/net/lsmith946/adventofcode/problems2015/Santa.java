package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.Counter;
import net.lsmith946.adventofcode.utils.CounterOperation;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;

import java.util.HashSet;
import java.util.Set;

public class Santa {

    private final Counter currentFloor;

    public Set<Grid2DCoordinates> getHousesVisited() {
        return housesVisited;
    }

    private final Set<Grid2DCoordinates> housesVisited;
    private Grid2DCoordinates currentPosition;

    public int getCurrentFloor() {
        return currentFloor.getCurrentValue();
    }

    public void setCurrentFloor(int floorNumber) {
        this.currentFloor.setCurrentValue(floorNumber);
    }

    public Santa() {
        this.currentFloor = new Counter();
        this.housesVisited = new HashSet<>();
        this.currentPosition = new Grid2DCoordinates(0, 0);
        this.housesVisited.add(new Grid2DCoordinates(0, 0));
    }

    public void changeFloors(char direction) {
        if (direction == '(') {
            currentFloor.modifyCounter(CounterOperation.INCREMENT, 1);
        }  else {
            currentFloor.modifyCounter(CounterOperation.DECREMENT, 1);
        }
    }

    private CompassDirection decodeDirections(char c) {
        return switch (c) {
            case '^' -> CompassDirection.NORTH;
            case 'v' -> CompassDirection.SOUTH;
            case '>' -> CompassDirection.EAST;
            default -> CompassDirection.WEST;
        };
    }

    public void addHouseLocation(char dir) {
        CompassDirection direction = decodeDirections(dir);
        Grid2DCoordinates newPosition = currentPosition.move(direction, 1);
        housesVisited.add(newPosition);
        currentPosition = newPosition;
    }

}
