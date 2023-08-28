package org.example.Task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConvertorLengthsTest {

    ConvertorLengths convertorLengths;

    @BeforeEach
    void setUp() {
        convertorLengths = new ConvertorLengths(ListLengths.kilometers, ListLengths.meters, 2);
    }

    @Test
    void checkLengthMatchingCheck() {
        assertTrue(convertorLengths.getOriginalLengthCode() != convertorLengths.getFinalLengthCode());
    }

    @Test
    void convert() {
        double expected = 2000;
        assertEquals(expected, convertorLengths.convert(), 0.01);
    }

    @AfterEach
    void tearDown() {
        convertorLengths = null;
    }

}