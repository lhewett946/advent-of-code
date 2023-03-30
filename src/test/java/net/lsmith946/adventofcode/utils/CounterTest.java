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
        counter.modifyCounter(CounterOperations.INCREMENT, 3);
        Assertions.assertEquals(3, counter.getCurrentValue());
        counter.modifyCounter(CounterOperations.DECREMENT, 2);
        Assertions.assertEquals(1, counter.getCurrentValue());
        counter.modifyCounter(CounterOperations.DECREMENT, 5);
        Assertions.assertEquals(-4, counter.getCurrentValue());
        counter.modifyCounter(CounterOperations.INCREMENT, 10);
        Assertions.assertEquals(6, counter.getCurrentValue());
        counter.modifyCounter(CounterOperations.RESET);
        Assertions.assertEquals(0, counter.getCurrentValue());
    }

    @Test
    void testCounterExceptions() {
        Counter counter = new Counter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperations.RESET, 10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperations.INCREMENT));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.modifyCounter(CounterOperations.DECREMENT));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperations.RESET));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperations.INCREMENT, 10));
        Assertions.assertDoesNotThrow(() -> counter.modifyCounter(CounterOperations.DECREMENT, 10));
    }
}