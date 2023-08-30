package org.example.Task4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    private static Number number;

    @BeforeAll
    static void setUp() {
        number = new Number();
        number.setValue(1267);
    }

    @Test
    void toBinary() {
        String expected="10011110011";
        assertEquals(expected, number.toBinary());
    }

    @Test
    void toOctal() {
        String expected="2363";
        assertEquals(expected, number.toOctal());
    }

    @Test
    void toHex() {
        String expected="4f3";
        assertEquals(expected, number.toHex());
    }

    @AfterAll
    static void tearDown() {
        number = null;
    }
}