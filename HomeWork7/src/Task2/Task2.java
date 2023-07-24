package Task2;

import java.util.function.BinaryOperator;

public class Task2 {
    public static void main(String[] args) {
        BinaryOperator<Fraction> plus = (fraction1, fraction2) -> {
            int denominatorNewFraction = 0;
            if (fraction1.getDenominator() == fraction2.getDenominator()) {
                denominatorNewFraction = fraction1.getDenominator();
            } else {
                denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
            }
            int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
            int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
            return new Fraction(numeratorFraction1 + numeratorFraction2, denominatorNewFraction);
        };

        BinaryOperator<Fraction> minus = (fraction1, fraction2) -> {
            int denominatorNewFraction = 0; //Общий знаменатель
            if (fraction1.getDenominator() == fraction2.getDenominator()) {
                denominatorNewFraction = fraction1.getDenominator();
            } else {
                denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
            }
            int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
            int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
            return new Fraction(numeratorFraction1 - numeratorFraction2, denominatorNewFraction);
        };

        BinaryOperator<Fraction> multiplication = (fraction1, fraction2) -> {
            int numeratorFraction = fraction1.getNumerator() * fraction2.getNumerator();
            int denominatorFraction = fraction1.getDenominator() * fraction2.getDenominator();
            return new Fraction(numeratorFraction, denominatorFraction);
        };

        BinaryOperator<Fraction> division = (fraction1, fraction2) -> {
            int numeratorFraction = fraction1.getNumerator() * fraction2.getDenominator();
            int denominatorFraction = fraction1.getDenominator() * fraction2.getNumerator();
            return new Fraction(numeratorFraction, denominatorFraction);
        };

        Fraction fraction1 = new Fraction(3, 5);
        Fraction fraction2 = new Fraction(1, 2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + plus.apply(fraction1, fraction2));
        System.out.println(fraction1 + " - " + fraction2 + " = " + minus.apply(fraction1, fraction2));
        System.out.println(fraction1 + " * " + fraction2 + " = " + multiplication.apply(fraction1, fraction2));
        System.out.println(fraction1 + " % " + fraction2 + " = " + division.apply(fraction1, fraction2));
    }
}
