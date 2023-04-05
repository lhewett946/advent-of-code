package net.lsmith946.adventofcode.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    void testSetCounter() {
        Counter counter = new Counter();
        counter.setCurrentValue(5);
        Assertions.assertEquals(5, counter.getCurrentValue());
    }

    @Test
    void testModifyCounter() throws IllegalArgumentException {
        Counter counter = new Counter();
        counter.modifyCounter(CounterOperation.INCREMENT, 3);
        Assertions.assertEquals(3, counter.getCurrentValue());
        counter.modifyCounter(CounterOperation.DECREMENT, 2);
        Assertions.assertEquals(1, counter.getCurrentValue());
        counter.modifyCounter(CounterOperation.DECREMENT, 5);
        Assertions.assertEquals(-4, counter.getCurrentValue());
        counter.modifyCounter(CounterOperation.INCREMENT, 10);
        Assertions.assertEquals(6, counter.getCurrentValue());
        counter.modifyCounter(CounterOperation.RESET);
        Assertions.assertEquals(0, counter.getCurrentValue());
    }

    @Test
    void testCounterExceptions() {
        Counter counter = new Counter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperation.RESET, 10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperation.INCREMENT));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperation.DECREMENT));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperation.RESET));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperation.INCREMENT, 10));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperation.DECREMENT, 10));
    }
}