package net.lsmith946.adventofcode2020;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class InputLoaderTest {

    @Test
    public void testLoadingIntsToSet() throws IOException {
        Set<Integer> loadedInts = InputLoader.loadToIntSet(getClass().getResource("/int_loader_test_data.txt").getFile());
        Set<Integer> expectedInts = new HashSet<>();

        expectedInts.add(1721);
        expectedInts.add(979);
        expectedInts.add(366);
        expectedInts.add(299);
        expectedInts.add(675);
        expectedInts.add(1456);

        Assert.assertEquals(expectedInts, loadedInts);
    }
}
