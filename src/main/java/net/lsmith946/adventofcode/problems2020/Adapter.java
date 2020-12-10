package net.lsmith946.adventofcode.problems2020;

import java.util.HashSet;
import java.util.Set;

public class Adapter {

    int joltage;
    Set<Integer> joltageCanDrive;
    long pathsToReach;

    public Adapter(int joltage) {
        this.joltage = joltage;
        joltageCanDrive = new HashSet<>();
        joltageCanDrive.add(joltage + 1);
        joltageCanDrive.add(joltage + 2);
        joltageCanDrive.add(joltage + 3);
        if (joltage < 4) {
            // joltages below 4 have one path that can reach them, from the start
            pathsToReach = 1;
        } else {
            pathsToReach = 0;
        }
    }

    public long getPathsToReach() {
        return pathsToReach;
    }

    public Set<Integer> getJoltageCanDrive() {
        return joltageCanDrive;
    }

    public void addPathsToReach(long newPaths) {
        pathsToReach += newPaths;
    }
}
