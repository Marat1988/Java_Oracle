package org.example.Task5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorWeightsTest {

    ConvertorWeights convertorWeights;

    @BeforeEach
    void setUp() {
        convertorWeights = new ConvertorWeights(ListWeights.ton, ListWeights.centner, 2);
    }

    @Test
    void checkWeightMatchingCheck() {
        assertTrue(convertorWeights.getOriginalWeightCode() != convertorWeights.getFinalWeightCode());
    }

    @Test
    void convert() {
        double expected = 20;
        assertEquals(expected, convertorWeights.convert(), 0.01);
    }

    @AfterEach
    void tearDown() {
    }
}