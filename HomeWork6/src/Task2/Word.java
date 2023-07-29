package Task2;

import java.util.Comparator;

public class Word {
    private String word; //Слово
    private int popularCount; //Счетчик обращений

    public Word(String word) {
        this.word = word;
        this.popularCount = 0;
    }

    public Word(String word, int popularCount) {
        this.word = word;
        this.popularCount = popularCount;
    }

    public boolean getWord(String findWord) {
        if (findWord.equals(this.word)) {
            this.popularCount++;
            return true;
        }
        return false;
    }

    public String getWord() {
        return word;
    }

    public int getPopularCount() {
        return popularCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Word)) {
            return false;
        }
        Word tmp = (Word) obj;
        return tmp.word.equals(this.word);
    }

    @Override
    public int hashCode() {
        int code = 17;
        code = 31 * code + this.word.hashCode();
        return code;
    }

    @Override
    public String toString() {
        return "Слово: " + this.word + ". Популярность: " + this.popularCount + ".";
    }
}
