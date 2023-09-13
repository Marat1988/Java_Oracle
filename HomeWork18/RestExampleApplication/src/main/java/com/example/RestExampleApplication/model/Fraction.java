package com.example.RestExampleApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fraction {
    private int numerator; //Числитель
    private int denominator; //Знаменатель
    private String operation; //Выполняемая операция

    private int gcd(int a, int b) { //Наибольший общий делитель
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void reduction(){
        int gcd = this.gcd(numerator, denominator);
        if (gcd > 0) {
            numerator /= gcd;
            denominator /= gcd;
        }
    }

}
