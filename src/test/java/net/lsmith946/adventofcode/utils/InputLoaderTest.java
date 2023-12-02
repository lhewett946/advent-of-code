package net.lsmith946.adventofcode.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputLoaderTest {

    /* TODO - fix these tests to work with new downloading of input data
    @Test
    public void testLoadingIntsToSet() throws IOException {
        Set<Integer> loadedInts = InputLoader.loadToIntSet("/int_loader_test_data.txt");
        Set<Integer> expectedInts = new HashSet<>();

        expectedInts.add(1721);
        expectedInts.add(979);
        expectedInts.add(366);
        expectedInts.add(299);
        expectedInts.add(675);
        expectedInts.add(1456);

        Assertions.assertEquals(expectedInts, loadedInts);
    }

    @Test
    public void testLoadingStringsToList() throws IOException {
        List<String> loadedStrings = InputLoader.loadToStringList("/string_loader_test_data.txt");
        List<String> expectedStrings = new ArrayList<>();

        expectedStrings.add("1-3 a: abcde");
        expectedStrings.add("1-3 b: cdefg");
        expectedStrings.add("2-9 c: ccccccccc");

        Assertions.assertEquals(expectedStrings, loadedStrings);
    }
    */

    @Test
    public void testDownload() throws IOException, InterruptedException, URISyntaxException {
        InputLoader.downloadInput(2023, 2);
    }
}
