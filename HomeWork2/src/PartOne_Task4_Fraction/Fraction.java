package PartOne_Task4_Fraction;

public class Fraction {
    private int numerator; //Числитель
    private int denominator; //Знаменатель

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static Fraction plus(Fraction a, Fraction b) {
        int denominatorNewFraction = 0;
        if (a.getDenominator() == b.getDenominator()) {
            denominatorNewFraction = a.getDenominator();
        } else {
            denominatorNewFraction = a.getDenominator() * b.getDenominator();
        }
        int numeratorFraction1 = a.getNumerator() * b.getDenominator();
        int numeratorFraction2 = b.getNumerator() * a.getDenominator();
        return new Fraction(numeratorFraction1 + numeratorFraction2, denominatorNewFraction);
    }

    public static Fraction minus(Fraction a, Fraction b) {
        int denominatorNewFraction = 0; //Общий знаменатель
        if (a.getDenominator() == b.getDenominator()) {
            denominatorNewFraction = a.getDenominator();
        } else {
            denominatorNewFraction = a.getDenominator() * b.getDenominator();
        }
        int numeratorFraction1 = a.getNumerator() * b.getDenominator();
        int numeratorFraction2 = b.getNumerator() * a.getDenominator();
        return new Fraction(numeratorFraction1 - numeratorFraction2, denominatorNewFraction);
    }

    public static Fraction multiplication(Fraction a, Fraction b) {
        int numeratorFraction = a.getNumerator() * b.getNumerator();
        int denominatorFraction = a.getDenominator() * b.getDenominator();
        return new Fraction(numeratorFraction, denominatorFraction);
    }

    public static Fraction division(Fraction a, Fraction b) {
        int numeratorFraction = a.getNumerator() * b.getDenominator();
        int denominatorFraction = a.getDenominator() * b.getNumerator();
        return new Fraction(numeratorFraction, denominatorFraction);
    }

    private int gcd(int a, int b) { //Наибольший общий делитель
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        int gcd = this.gcd(numerator, denominator);
        if (gcd > 0) {
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }
}
