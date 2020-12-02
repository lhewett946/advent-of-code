package net.lsmith946.adventofcode2020;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoaderTest {

    @Test
    public void testLoadingIntsToSet() throws IOException {
        InputLoader il = new InputLoader();
        Set<Integer> loadedInts = il.loadToIntSet("/int_loader_test_data.txt");
        Set<Integer> expectedInts = new HashSet<>();

        expectedInts.add(1721);
        expectedInts.add(979);
        expectedInts.add(366);
        expectedInts.add(299);
        expectedInts.add(675);
        expectedInts.add(1456);

        Assert.assertEquals(expectedInts, loadedInts);
    }

    @Test
    public void testLoadingStringsToList() throws IOException {
        InputLoader il = new InputLoader();
        List<String> loadedStrings = il.loadToStringList("/string_loader_test_data.txt");
        List<String> expectedStrings = new ArrayList<>();

        expectedStrings.add("1-3 a: abcde");
        expectedStrings.add("1-3 b: cdefg");
        expectedStrings.add("2-9 c: ccccccccc");

        Assert.assertEquals(expectedStrings, loadedStrings);
    }
}
