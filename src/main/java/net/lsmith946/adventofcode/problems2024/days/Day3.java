package net.lsmith946.adventofcode.problems2024.days;

import net.lsmith946.adventofcode.utils.InputLoader;
import net.lsmith946.adventofcode.utils.Puzzle;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day3 implements Puzzle<Long> {

    List<String> values;

    public Day3() throws IOException, URISyntaxException, InterruptedException {
        values = new ArrayList<>();
        this.values = InputLoader.loadToStringList(2024, 3);
    }

    @Override
    public Long solvePartOne() {
        long sum = 0;
        Pattern findMulOp = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Pattern extractInt = Pattern.compile("\\d+");
        for(String s : values) {
            Matcher mulOpMatch = findMulOp.matcher(s);
            while(mulOpMatch.find()) {
                String mulOperation = mulOpMatch.group();
                Matcher getInts = extractInt.matcher(mulOperation);
                long result = 1;
                while(getInts.find()) {
                    result = result * Integer.parseInt(getInts.group());
                }
                sum += result;
            }
        }
        System.out.println("The sum of the results of the multiplication operations is " + sum);
        return sum;
    }

    @Override
    public Long solvePartTwo() {
        return 0L;
    }
}
