package org.example.Task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    private Word word;

    @BeforeEach
    void setUp() {
        word = new Word("Марат");
    }

    @Test
    void isPalindrome() {
        assertFalse(word.isPalindrome());

    }

    @Test
    void countWordInLine() {
        String line = "Всем привет. Меня зовут Марат";
        int expected = 1;
        assertEquals(expected, word.countWordInLine(line));
    }

    @Test
    void countVowelLettersRus() {
        int expected = 2;
        assertEquals(expected, word.countVowelLettersRus());
    }

    @Test
    void countConsonantLettersRus() {
        int expected = 3;
        assertEquals(expected, word.countConsonantLettersRus());
    }

    @AfterEach
    void tearDown() {
        word = null;
    }
}