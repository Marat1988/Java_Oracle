package org.example.Task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    Number number;

    @BeforeEach
    void setUp() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(9);
        nums.add(12);
        nums.add(5);
        nums.add(8);
        number = new Number(nums);
    }

    @Test
    void getSum() {
        long expected = 34;
        assertEquals(expected, number.getSum());
    }

    @Test
    void getAvg() {
        double expected = 8.5;
        assertEquals(expected, number.getAvg());
    }

    @Test
    void getMax() {
        int expected = 12;
        assertEquals(expected, number.getMax());
    }

    @Test
    void getMin() {
        int expected = 5;
        assertEquals(expected, number.getMin());
    }

    @AfterEach
    void tearDown() {
        number = null;
    }
}