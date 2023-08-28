package org.example.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle(5, 6, 7);
    }

    @Test
    void checkTriangleValidation() {
        assertTrue(triangle.getSideA() + triangle.getSideB() > triangle.getSideC()
                && triangle.getSideA() + triangle.getSideC() > triangle.getSideB()
                && triangle.getSideB() + triangle.getSideC() > triangle.getSideA());
    }

    @Test
    void calcSquare() {
        double expected = 14.69;
        assertEquals(expected, triangle.calcSquare(), 0.01);
    }

    @AfterEach
    void tearDown() {
        triangle = null;
    }

}