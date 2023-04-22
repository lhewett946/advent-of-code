package net.lsmith946.adventofcode.problems2015;

import net.lsmith946.adventofcode.utils.CompassDirection;
import net.lsmith946.adventofcode.utils.Counter;
import net.lsmith946.adventofcode.utils.CounterOperation;
import net.lsmith946.adventofcode.utils.Grid2DCoordinates;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
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

    public Long countNiceStrings(List<String> strings) {
        long niceStrings = 0;
        for(String s : strings) {
            int vowelsInString = StringUtils.countMatches(s, 'a') +
                    StringUtils.countMatches(s, 'e') +
                    StringUtils.countMatches(s, 'i') +
                    StringUtils.countMatches(s, 'o') +
                    StringUtils.countMatches(s, 'u');
            if (vowelsInString < 3) continue;

            boolean doubleLetterFound = false;
            for(int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                    doubleLetterFound = true;
                    break;
                }
            }
            if (!doubleLetterFound) continue;

            if (s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy")) continue;

            // increment number of nice strings if all checks pass
            niceStrings++;
        }
        return niceStrings;
    }

    public Long countRevisedNiceStrings(List<String> strings) {
        long niceStrings = 0;
        for(String s : strings) {
            boolean repeatedPairFound = false;
            for(int i = 0; i < s.length()-1; i++) {
                String pair = s.substring(i, i+2);
                String stripCurrentPair = s.replaceFirst(pair, "  ");
                if (StringUtils.countMatches(stripCurrentPair, pair) != 0) {
                    repeatedPairFound = true;
                    break;
                }
            }

            if (!repeatedPairFound) continue;

            boolean repeatOneLetterBetween = false;
            for(int i = 0; i < s.length()-2; i++) {
                if (s.charAt(i) == s.charAt(i+2)) {
                    repeatOneLetterBetween = true;
                    break;
                }
            }
            if (!repeatOneLetterBetween) continue;

            // increment number of nice strings if all checks pass
            niceStrings++;
        }
        return niceStrings;
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
