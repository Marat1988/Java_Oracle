package org.example.Task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertorTest {
    private Convertor convertor;

    @BeforeEach
    void setUp() {
        convertor = new Convertor(Currency.dollar, 2, 94.71, Currency.ruble);
    }

    @Test
    void checkTotalOriginalCurrency() {
        assertTrue(convertor.getTotalOriginalCurrency() > 0);
    }

    @Test
    void checkCourse() {
        assertTrue(convertor.getCourse() > 0);
    }

    @Test
    void checkCurrencyMatchingCheck(){
        assertTrue(convertor.getOriginalCurrencyCode() != convertor.getFinalCurrencyCode());
    }

    @Test
    void calcConvertor() {
        double expected = 189.42;
        assertEquals(expected, convertor.calcConvertor());
    }

    @AfterEach
    void tearDown() {
        convertor = null;
    }
}