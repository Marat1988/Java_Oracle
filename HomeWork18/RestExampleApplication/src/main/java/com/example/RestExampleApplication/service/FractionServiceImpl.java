package com.example.RestExampleApplication.service;

import com.example.RestExampleApplication.model.Fraction;
import org.springframework.stereotype.Service;

@Service
public class FractionServiceImpl implements FractionService {

    @Override
    public Fraction plus(Fraction fraction1, Fraction fraction2) {
        int denominatorNewFraction = 0;
        if (fraction1.getDenominator() == fraction2.getDenominator()) {
            denominatorNewFraction = fraction1.getDenominator();
        } else {
            denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
        }
        int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
        int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
        Fraction fraction = new Fraction(numeratorFraction1 + numeratorFraction2, denominatorNewFraction, "Сложение");
        fraction.reduction();
        return fraction;
    }

    @Override
    public Fraction minus(Fraction fraction1, Fraction fraction2) {
        int denominatorNewFraction = 0; //Общий знаменатель
        if (fraction1.getDenominator() == fraction2.getDenominator()) {
            denominatorNewFraction = fraction1.getDenominator();
        } else {
            denominatorNewFraction = fraction1.getDenominator() * fraction2.getDenominator();
        }
        int numeratorFraction1 = fraction1.getNumerator() * fraction2.getDenominator();
        int numeratorFraction2 = fraction2.getNumerator() * fraction1.getDenominator();
        Fraction fraction = new Fraction(numeratorFraction1 - numeratorFraction2, denominatorNewFraction, "Вычитание");
        fraction.reduction();
        return fraction;
    }

    @Override
    public Fraction multiplication(Fraction fraction1, Fraction fraction2) {
        int numeratorFraction = fraction1.getNumerator() * fraction2.getNumerator();
        int denominatorFraction = fraction1.getDenominator() * fraction2.getDenominator();
        Fraction fraction = new Fraction(numeratorFraction, denominatorFraction, "Умножение");
        fraction.reduction();
        return fraction;
    }

    @Override
    public Fraction division(Fraction fraction1, Fraction fraction2) {
        int numeratorFraction = fraction1.getNumerator() * fraction2.getDenominator();
        int denominatorFraction = fraction1.getDenominator() * fraction2.getNumerator();
        Fraction fraction = new Fraction(numeratorFraction, denominatorFraction, "Деление");
        fraction.reduction();
        return fraction;
    }

    @Override
    public boolean correctFraction(Fraction fraction) {
        return fraction.getNumerator() < fraction.getDenominator();
    }

    @Override
    public void reductionFraction(Fraction fraction) {
        fraction.reduction();
    }
}
