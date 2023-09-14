package com.example.fractionwebservice;

import jakarta.annotation.PostConstruct;
import io.spring.guides.gs_fraction_web_service.Fraction;
import org.springframework.stereotype.Component;

@Component
public class FractionRepository {
    @PostConstruct
    public void initData() {
    }

    private int gcd(int a, int b) { //Наибольший общий делитель
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public Fraction plus(Fraction fraction1, Fraction fraction2) { //Сложение
        Fraction newFraction = new Fraction();
        int denominatorNewFraction = 0;
        if (fraction1.getDenominator() == fraction2.getDenominator()) {
            denominatorNewFraction = fraction1.getDenominator();
        } else {
            denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
        }
        int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
        int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
        newFraction.setDenominator(denominatorNewFraction);
        newFraction.setNumerator(numeratorFraction1 + numeratorFraction2);
        int gcd = gcd(newFraction.getNumerator(), newFraction.getDenominator());
        if (gcd > 0) {
            newFraction.setNumerator(newFraction.getNumerator() / gcd);
            newFraction.setDenominator(newFraction.getDenominator() / gcd);
        }
        return newFraction;
    }

    public Fraction minus(Fraction fraction1, Fraction fraction2) { //Вычитание
        Fraction newFraction = new Fraction();
        int denominatorNewFraction = 0; //Общий знаменатель
        if (fraction1.getDenominator() == fraction2.getDenominator()) {
            denominatorNewFraction = fraction1.getDenominator();
        } else {
            denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
        }
        int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
        int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
        newFraction.setDenominator(denominatorNewFraction);
        newFraction.setNumerator(numeratorFraction1 - numeratorFraction2);
        int gcd = gcd(newFraction.getNumerator(), newFraction.getDenominator());
        if (gcd > 0) {
            newFraction.setNumerator(newFraction.getNumerator() / gcd);
            newFraction.setDenominator(newFraction.getDenominator() / gcd);
        }
        return newFraction;
    }

    public Fraction multiplication(Fraction fraction1, Fraction fraction2) { //Умножение
        Fraction newFraction = new Fraction();
        int numeratorFraction = fraction1.getNumerator() * fraction2.getNumerator();
        int denominatorFraction = fraction1.getDenominator() * fraction2.getDenominator();
        int gcd = gcd(numeratorFraction, denominatorFraction);
        if (gcd > 0) {
            numeratorFraction /= gcd;
            denominatorFraction /= gcd;
        }
        newFraction.setDenominator(denominatorFraction);
        newFraction.setNumerator(numeratorFraction);
        return newFraction;
    }

    public Fraction division(Fraction fraction1, Fraction fraction2) { //Деление
        Fraction newFraction = new Fraction();
        int numeratorFraction = fraction1.getNumerator() * fraction2.getDenominator();
        int denominatorFraction = fraction1.getDenominator() * fraction2.getNumerator();
        int gcd = gcd(numeratorFraction, denominatorFraction);
        if (gcd > 0) {
            numeratorFraction /= gcd;
            denominatorFraction /= gcd;
        }
        newFraction.setDenominator(denominatorFraction);
        newFraction.setNumerator(numeratorFraction);
        return newFraction;
    }

    public Fraction reducingFraction(Fraction fraction) {
        Fraction newFraction = new Fraction();
        int gcd = gcd(fraction.getNumerator(), fraction.getDenominator());
        if (gcd > 0) {
            newFraction.setNumerator(fraction.getNumerator() / gcd);
            newFraction.setDenominator(fraction.getDenominator() / gcd);
        } else {
            newFraction.setNumerator(fraction.getNumerator());
            newFraction.setDenominator(fraction.getDenominator());
        }
        return newFraction;
    }

    public String properFraction(Fraction fraction) {
        return (fraction.getNumerator() <= fraction.getDenominator()) ? "Дробь правильная:" : "Дробь не правильная";
    }
}