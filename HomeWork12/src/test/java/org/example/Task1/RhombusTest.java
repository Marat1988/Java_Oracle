package org.example.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RhombusTest {
    private Rhombus rhombus;

    @BeforeEach
    void setUp() {
        rhombus = new Rhombus(6, 8);
    }

    @Test
    void checkLengthDiagonal() {
        assertTrue(rhombus.getDiagonal_1() > 0 && rhombus.getDiagonal_2() > 0);
    }

    @Test
    void calcSquare() {
        double expected = 24;
        assertEquals(expected, rhombus.calcSquare(), 0.01);
    }

    @AfterEach
    void tearDown() {
        rhombus = null;
    }

}