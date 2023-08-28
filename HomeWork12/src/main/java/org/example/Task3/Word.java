package org.example.Task3;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean isPalindrome() { //Проверка на полиндром
        String modifyWord = word.toUpperCase();
        String newWord = new StringBuilder(modifyWord).reverse().toString();
        return modifyWord.equals(newWord);
    }

    public long countWordInLine(String line) { //Проверка вхождения слова в строку
        String[] arr = line.split(" ");
        return Arrays.stream(arr)
                .filter(word -> word.equals(this.word))
                .count();
    }

    public int countVowelLettersRus(){ //Подсчет количества гласных (для русских букв)
        Pattern vowels = Pattern.compile("(?iu)[ауоыиэяюёе]");
        Matcher m = vowels.matcher(this.word);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }

    public int countConsonantLettersRus(){ //Подсчет количества согласных (для русских букв)
        Pattern consonant = Pattern.compile("(?iu)[бвгджзйклмнпрстфхцчшщ]");
        Matcher m = consonant.matcher(this.word);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }
}
