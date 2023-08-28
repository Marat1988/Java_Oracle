package org.example.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SquareTest {

    private Square square;

    @BeforeEach
    void setUp() {
        square = new Square(5);
    }

    @Test
    void checkLengthSide() {
        assertTrue(square.getSide() > 0);
    }

    @Test
    void calcSquare() {
        int expected = 25;
        assertEquals(expected, square.calcSquare());
    }

    @AfterEach
    void tearDown() {
        square = null;
    }

}