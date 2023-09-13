package com.example.RestExampleApplication.service;

import com.example.RestExampleApplication.model.Fraction;

public interface FractionService {
    Fraction plus(Fraction fraction1, Fraction fraction2); //Сложение дробей
    Fraction minus(Fraction fraction1, Fraction fraction2); //Вычитание дробей
    Fraction multiplication(Fraction fraction1, Fraction fraction2); //Умножение дробей
    Fraction division(Fraction fraction1, Fraction fraction2); //Деление дробей
    boolean correctFraction(Fraction fraction); //Проверка дроби на корректность
    void reductionFraction(Fraction fraction); //Сокращение дроби
}
