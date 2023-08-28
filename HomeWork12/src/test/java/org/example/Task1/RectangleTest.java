package org.example.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle rectangle;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(5, 6);
    }

    @Test
    void checkValidationSide() {
        assertTrue(rectangle.getSideA() > 0 && rectangle.getSideB() > 0);
    }

    @Test
    void calcSquare() {
        int expected = 30;
        assertEquals(expected, rectangle.calcSquare());
    }

    @AfterEach
    void tearDown() {
        rectangle = null;
    }
}