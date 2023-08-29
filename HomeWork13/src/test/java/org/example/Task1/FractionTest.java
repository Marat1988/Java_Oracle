package org.example.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FractionTest {
    private Fraction fraction_1;
    private Fraction fraction_2;

    @BeforeEach
    void setUp() {
        fraction_1 = new Fraction(3,5);
        fraction_2 = new Fraction(1,2);
    }

    @Test
    void plus() {
        Fraction fractionExpected = new Fraction(11,10);
        Fraction fractionResult = Fraction.plus(fraction_1, fraction_2);
        assertEquals(fractionExpected,fractionResult);
    }


    @Test
    void minus() {
        Fraction fractionExpected = new Fraction(1,10);
        Fraction fractionResult = Fraction.minus(fraction_1, fraction_2);
        assertEquals(fractionExpected,fractionResult);
    }

    @Test
    void multiplication() {
        Fraction fractionExpected = new Fraction(3,10);
        Fraction fractionResult = Fraction.multiplication(fraction_1, fraction_2);
        assertEquals(fractionExpected,fractionResult);
    }

    @Test
    void division() {
        Fraction fractionExpected = new Fraction(6,5);
        Fraction fractionResult = Fraction.division(fraction_1, fraction_2);
        assertEquals(fractionExpected,fractionResult);
    }

    @AfterEach
    void tearDown() {
        fraction_1 = null;
        fraction_2 = null;
    }



}