package Task2;

public class Fraction {
    private int numerator; //числитель
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
