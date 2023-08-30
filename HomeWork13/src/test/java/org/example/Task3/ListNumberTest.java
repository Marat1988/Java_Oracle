package org.example.Task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListNumberTest {
    ListNumber listNumber;

    @BeforeEach
    void setUp() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(9);
        nums.add(12);
        nums.add(5);
        nums.add(8);
        listNumber = new ListNumber(nums);
    }

    @Test
    void getSum() {
        long expected = 34;
        assertEquals(expected, listNumber.getSum());
    }

    @Test
    void getAvg() {
        double expected = 8.5;
        assertEquals(expected, listNumber.getAvg());
    }

    @Test
    void getMax() {
        int expected = 12;
        assertEquals(expected, listNumber.getMax());
    }

    @Test
    void getMin() {
        int expected = 5;
        assertEquals(expected, listNumber.getMin());
    }

    @AfterEach
    void tearDown() {
        listNumber = null;
    }
}