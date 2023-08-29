package org.example.Task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    Calc calc;

    @BeforeEach
    void setUp() {
        calc = new Calc();
    }


    @Test
    void plus() {
        long expected = 15;
        assertEquals(expected, calc.plus(5, 10));

    }

    @Test
    void minus() {
        long expected = 10;
        assertEquals(expected,calc.minus(15,5));
    }

    @Test
    void multiplication() {
        long expected = 50;
        assertEquals(expected,calc.multiplication(10,5));
    }

    @Test
    void division() {
        long expected = 2;
        assertEquals(expected,calc.division(10,5));
    }

    @Test
    void maxNumbers() {
        long expected = 10;
        assertEquals(expected,calc.maxNumbers(10,5));
    }

    @Test
    void minNumbers() {
        long expected = 5;
        assertEquals(expected,calc.minNumbers(10,5));
    }

    @Test
    void percentNumber() {
        double expected = 0.4;
        assertEquals(expected,calc.percentNumber(10,4),0.01);
    }


    @Test
    void pow() {
        double expected = 32;
        assertEquals(expected, calc.pow(2,5), 0.01);
    }


    @AfterEach
    void tearDown() {
        calc = null;
    }


}